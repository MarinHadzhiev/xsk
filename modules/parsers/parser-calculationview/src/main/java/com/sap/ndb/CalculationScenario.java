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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.11.27 at 08:01:21 PM EET 
//


package com.sap.ndb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}origin"/&gt;
 *         &lt;element ref="{}descriptions"/&gt;
 *         &lt;element ref="{}metadata"/&gt;
 *         &lt;element ref="{}defaultSchema"/&gt;
 *         &lt;element ref="{}localVariables"/&gt;
 *         &lt;element ref="{}variableMappings"/&gt;
 *         &lt;element ref="{}dataSources"/&gt;
 *         &lt;element ref="{}calculationViews"/&gt;
 *         &lt;element ref="{}logicalModel"/&gt;
 *         &lt;element ref="{}layout"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="schemaVersion" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="applyPrivilegeType" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="checkAnalyticPrivileges" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="defaultClient" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="defaultLanguage" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="hierarchiesSQLEnabled" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="translationRelevant" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="visibility" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="calculationScenarioType" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="dataCategory" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="enforceSqlExecution" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="executionSemantic" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="outputViewType" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "origin",
    "descriptions",
    "metadata",
    "defaultSchema",
    "localVariables",
    "variableMappings",
    "dataSources",
    "calculationViews",
    "logicalModel",
    "layout"
})
@XmlRootElement(name = "CalculationScenario")
public class CalculationScenario {

  @XmlElement(required = true)
  protected String origin;
  @XmlElement(required = true)
  protected Descriptions descriptions;
  @XmlElement(required = true)
  protected Metadata metadata;
  @XmlElement(required = true)
  protected DefaultSchema defaultSchema;
  @XmlElement(required = true)
  protected String localVariables;
  @XmlElement(required = true)
  protected String variableMappings;
  @XmlElement(required = true)
  protected DataSources dataSources;
  @XmlElement(required = true)
  protected CalculationViews calculationViews;
  @XmlElement(required = true)
  protected LogicalModel logicalModel;
  @XmlElement(required = true)
  protected Layout layout;
  @XmlAttribute(name = "schemaVersion")
  protected Float schemaVersion;
  @XmlAttribute(name = "id")
  protected String id;
  @XmlAttribute(name = "applyPrivilegeType")
  protected String applyPrivilegeType;
  @XmlAttribute(name = "checkAnalyticPrivileges")
  protected String checkAnalyticPrivileges;
  @XmlAttribute(name = "defaultClient")
  protected String defaultClient;
  @XmlAttribute(name = "defaultLanguage")
  protected String defaultLanguage;
  @XmlAttribute(name = "hierarchiesSQLEnabled")
  protected String hierarchiesSQLEnabled;
  @XmlAttribute(name = "translationRelevant")
  protected String translationRelevant;
  @XmlAttribute(name = "visibility")
  protected String visibility;
  @XmlAttribute(name = "calculationScenarioType")
  protected String calculationScenarioType;
  @XmlAttribute(name = "dataCategory")
  protected String dataCategory;
  @XmlAttribute(name = "enforceSqlExecution")
  protected String enforceSqlExecution;
  @XmlAttribute(name = "executionSemantic")
  protected String executionSemantic;
  @XmlAttribute(name = "outputViewType")
  protected String outputViewType;

  /**
   * Gets the value of the origin property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getOrigin() {
    return origin;
  }

  /**
   * Sets the value of the origin property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setOrigin(String value) {
    this.origin = value;
  }

  /**
   * Gets the value of the descriptions property.
   *
   * @return possible object is
   * {@link Descriptions }
   */
  public Descriptions getDescriptions() {
    return descriptions;
  }

  /**
   * Sets the value of the descriptions property.
   *
   * @param value allowed object is
   *              {@link Descriptions }
   */
  public void setDescriptions(Descriptions value) {
    this.descriptions = value;
  }

  /**
   * Gets the value of the metadata property.
   *
   * @return possible object is
   * {@link Metadata }
   */
  public Metadata getMetadata() {
    return metadata;
  }

  /**
   * Sets the value of the metadata property.
   *
   * @param value allowed object is
   *              {@link Metadata }
   */
  public void setMetadata(Metadata value) {
    this.metadata = value;
  }

  /**
   * Gets the value of the defaultSchema property.
   *
   * @return possible object is
   * {@link DefaultSchema }
   */
  public DefaultSchema getDefaultSchema() {
    return defaultSchema;
  }

  /**
   * Sets the value of the defaultSchema property.
   *
   * @param value allowed object is
   *              {@link DefaultSchema }
   */
  public void setDefaultSchema(DefaultSchema value) {
    this.defaultSchema = value;
  }

  /**
   * Gets the value of the localVariables property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getLocalVariables() {
    return localVariables;
  }

  /**
   * Sets the value of the localVariables property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setLocalVariables(String value) {
    this.localVariables = value;
  }

  /**
   * Gets the value of the variableMappings property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getVariableMappings() {
    return variableMappings;
  }

  /**
   * Sets the value of the variableMappings property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setVariableMappings(String value) {
    this.variableMappings = value;
  }

  /**
   * Gets the value of the dataSources property.
   *
   * @return possible object is
   * {@link DataSources }
   */
  public DataSources getDataSources() {
    return dataSources;
  }

  /**
   * Sets the value of the dataSources property.
   *
   * @param value allowed object is
   *              {@link DataSources }
   */
  public void setDataSources(DataSources value) {
    this.dataSources = value;
  }

  /**
   * Gets the value of the calculationViews property.
   *
   * @return possible object is
   * {@link CalculationViews }
   */
  public CalculationViews getCalculationViews() {
    return calculationViews;
  }

  /**
   * Sets the value of the calculationViews property.
   *
   * @param value allowed object is
   *              {@link CalculationViews }
   */
  public void setCalculationViews(CalculationViews value) {
    this.calculationViews = value;
  }

  /**
   * Gets the value of the logicalModel property.
   *
   * @return possible object is
   * {@link LogicalModel }
   */
  public LogicalModel getLogicalModel() {
    return logicalModel;
  }

  /**
   * Sets the value of the logicalModel property.
   *
   * @param value allowed object is
   *              {@link LogicalModel }
   */
  public void setLogicalModel(LogicalModel value) {
    this.logicalModel = value;
  }

  /**
   * Gets the value of the layout property.
   *
   * @return possible object is
   * {@link Layout }
   */
  public Layout getLayout() {
    return layout;
  }

  /**
   * Sets the value of the layout property.
   *
   * @param value allowed object is
   *              {@link Layout }
   */
  public void setLayout(Layout value) {
    this.layout = value;
  }

  /**
   * Gets the value of the schemaVersion property.
   *
   * @return possible object is
   * {@link Float }
   */
  public Float getSchemaVersion() {
    return schemaVersion;
  }

  /**
   * Sets the value of the schemaVersion property.
   *
   * @param value allowed object is
   *              {@link Float }
   */
  public void setSchemaVersion(Float value) {
    this.schemaVersion = value;
  }

  /**
   * Gets the value of the id property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getId() {
    return id;
  }

  /**
   * Sets the value of the id property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setId(String value) {
    this.id = value;
  }

  /**
   * Gets the value of the applyPrivilegeType property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getApplyPrivilegeType() {
    return applyPrivilegeType;
  }

  /**
   * Sets the value of the applyPrivilegeType property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setApplyPrivilegeType(String value) {
    this.applyPrivilegeType = value;
  }

  /**
   * Gets the value of the checkAnalyticPrivileges property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getCheckAnalyticPrivileges() {
    return checkAnalyticPrivileges;
  }

  /**
   * Sets the value of the checkAnalyticPrivileges property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setCheckAnalyticPrivileges(String value) {
    this.checkAnalyticPrivileges = value;
  }

  /**
   * Gets the value of the defaultClient property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getDefaultClient() {
    return defaultClient;
  }

  /**
   * Sets the value of the defaultClient property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setDefaultClient(String value) {
    this.defaultClient = value;
  }

  /**
   * Gets the value of the defaultLanguage property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getDefaultLanguage() {
    return defaultLanguage;
  }

  /**
   * Sets the value of the defaultLanguage property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setDefaultLanguage(String value) {
    this.defaultLanguage = value;
  }

  /**
   * Gets the value of the hierarchiesSQLEnabled property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getHierarchiesSQLEnabled() {
    return hierarchiesSQLEnabled;
  }

  /**
   * Sets the value of the hierarchiesSQLEnabled property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setHierarchiesSQLEnabled(String value) {
    this.hierarchiesSQLEnabled = value;
  }

  /**
   * Gets the value of the translationRelevant property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getTranslationRelevant() {
    return translationRelevant;
  }

  /**
   * Sets the value of the translationRelevant property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setTranslationRelevant(String value) {
    this.translationRelevant = value;
  }

  /**
   * Gets the value of the visibility property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getVisibility() {
    return visibility;
  }

  /**
   * Sets the value of the visibility property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setVisibility(String value) {
    this.visibility = value;
  }

  /**
   * Gets the value of the calculationScenarioType property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getCalculationScenarioType() {
    return calculationScenarioType;
  }

  /**
   * Sets the value of the calculationScenarioType property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setCalculationScenarioType(String value) {
    this.calculationScenarioType = value;
  }

  /**
   * Gets the value of the dataCategory property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getDataCategory() {
    return dataCategory;
  }

  /**
   * Sets the value of the dataCategory property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setDataCategory(String value) {
    this.dataCategory = value;
  }

  /**
   * Gets the value of the enforceSqlExecution property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getEnforceSqlExecution() {
    return enforceSqlExecution;
  }

  /**
   * Sets the value of the enforceSqlExecution property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setEnforceSqlExecution(String value) {
    this.enforceSqlExecution = value;
  }

  /**
   * Gets the value of the executionSemantic property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getExecutionSemantic() {
    return executionSemantic;
  }

  /**
   * Sets the value of the executionSemantic property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setExecutionSemantic(String value) {
    this.executionSemantic = value;
  }

  /**
   * Gets the value of the outputViewType property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getOutputViewType() {
    return outputViewType;
  }

  /**
   * Sets the value of the outputViewType property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setOutputViewType(String value) {
    this.outputViewType = value;
  }

}
