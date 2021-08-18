/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company and XSK contributors
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License, v2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * SPDX-FileCopyrightText: 2021 SAP SE or an SAP affiliate company and XSK contributors
 * SPDX-License-Identifier: Apache-2.0
 */
package com.sap.xsk.hdb.ds.parser.hdbsequence;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sap.xsk.parser.utils.ParserConstants;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.dirigible.core.problems.exceptions.ProblemsException;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.sap.xsk.exceptions.XSKArtifactParserException;
import com.sap.xsk.hdb.ds.api.IXSKDataStructureModel;
import com.sap.xsk.hdb.ds.api.XSKDataStructuresException;
import com.sap.xsk.hdb.ds.model.XSKDBContentType;
import com.sap.xsk.hdb.ds.model.XSKDataStructureModel;
import com.sap.xsk.hdb.ds.model.hdbsequence.XSKDataStructureHDBSequenceModel;
import com.sap.xsk.hdb.ds.parser.XSKDataStructureParser;
import com.sap.xsk.parser.hdbsequence.core.HdbsequenceBaseVisitor;
import com.sap.xsk.parser.hdbsequence.core.HdbsequenceLexer;
import com.sap.xsk.parser.hdbsequence.core.HdbsequenceParser;
import com.sap.xsk.parser.hdbsequence.custom.HdbsequenceVisitor;
import com.sap.xsk.parser.hdbsequence.custom.XSKHDBSEQUENCEModelAdapter;
import com.sap.xsk.parser.hdbsequence.custom.XSKHDBSEQUENCESyntaxErrorListener;
import com.sap.xsk.parser.hdbsequence.models.XSKHDBSEQUENCEModel;
import com.sap.xsk.utils.XSKCommonsUtils;
import com.sap.xsk.utils.XSKHDBUtils;

public class XSKHDBSequenceParser implements XSKDataStructureParser {


    private static final Logger logger = LoggerFactory.getLogger(XSKHDBSequenceParser.class);

    @Override
    public XSKDataStructureModel parse(String location, String content)
        throws XSKDataStructuresException, IOException, XSKArtifactParserException, ProblemsException {
        Pattern pattern = Pattern.compile("^(\\t\\n)*(\\s)*SEQUENCE", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content.trim().toUpperCase(Locale.ROOT));
        boolean matchFound = matcher.find();
        return (matchFound)
                ? parseHanaXSAdvancedContent(location, content)
                : parseHanaXSClassicContent(location, content);
    }


    @Override
    public String getType() {
        return IXSKDataStructureModel.TYPE_HDB_SEQUENCE;
    }


    @Override
    public Class<XSKDataStructureHDBSequenceModel> getDataStructureClass() {
        return XSKDataStructureHDBSequenceModel.class;
    }

    private XSKDataStructureModel parseHanaXSClassicContent(String location, String content)
        throws IOException, XSKArtifactParserException, ProblemsException {
        logger.debug("Parsing hdbsequence as Hana XS Classic format");
        ByteArrayInputStream is = new ByteArrayInputStream(content.getBytes());
        ANTLRInputStream inputStream = new ANTLRInputStream(is);

        HdbsequenceLexer lexer = new HdbsequenceLexer(inputStream);
        XSKHDBSEQUENCESyntaxErrorListener lexerErrorListener = new XSKHDBSEQUENCESyntaxErrorListener();
        lexer.removeErrorListeners();
        lexer.addErrorListener(lexerErrorListener);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        HdbsequenceParser parser = new HdbsequenceParser((tokenStream));
        parser.setBuildParseTree(true);
        parser.removeErrorListeners();
        XSKHDBSEQUENCESyntaxErrorListener parserErrorListener = new XSKHDBSEQUENCESyntaxErrorListener();
        parser.removeErrorListeners();
        parser.addErrorListener(parserErrorListener);

        ParseTree parseTree = parser.hdbsequence();
        XSKCommonsUtils.logParserErrors(parserErrorListener.getErrors(), ParserConstants.PARSER_ERROR, location, "HDB Sequence", logger);
        XSKCommonsUtils.logParserErrors(lexerErrorListener.getErrors(), ParserConstants.LEXER_ERROR, location, "HDB Sequence", logger);

        HdbsequenceBaseVisitor<JsonElement> visitor = new HdbsequenceVisitor();
        JsonElement parsedResult = visitor.visit(parseTree);
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(XSKHDBSEQUENCEModel.class, new XSKHDBSEQUENCEModelAdapter())
                .create();
        XSKHDBSEQUENCEModel antlr4Model = gson.fromJson(parsedResult, XSKHDBSEQUENCEModel.class);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);

        XSKDataStructureHDBSequenceModel hdbSequenceModel = modelMapper.map(antlr4Model, XSKDataStructureHDBSequenceModel.class);
        XSKHDBUtils.populateXSKDataStructureModel(location, content, hdbSequenceModel, IXSKDataStructureModel.TYPE_HDB_SEQUENCE, XSKDBContentType.XS_CLASSIC);

        return hdbSequenceModel;
    }

    private XSKDataStructureModel parseHanaXSAdvancedContent(String location, String content) {
        logger.debug("Parsing hdbsequence as Hana XS Advanced format");
        XSKDataStructureHDBSequenceModel hdbSequenceModel = new XSKDataStructureHDBSequenceModel();
        XSKHDBUtils.populateXSKDataStructureModel(location, content, hdbSequenceModel, IXSKDataStructureModel.TYPE_HDB_SEQUENCE, XSKDBContentType.OTHERS);
        hdbSequenceModel.setRawContent(content);
        return hdbSequenceModel;
    }
}
