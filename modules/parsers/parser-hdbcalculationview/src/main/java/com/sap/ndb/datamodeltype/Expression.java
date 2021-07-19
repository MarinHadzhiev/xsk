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
// Generated on: 2020.11.26 at 10:54:28 AM EET 
//


package com.sap.ndb.datamodeltype;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Simple string type to store an expression
 *
 *
 * <p>Java class for Expression complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Expression"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="formula" type="{http://www.sap.com/ndb/DataModelType.ecore}ExpressionString" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="language" type="{http://www.sap.com/ndb/DataModelType.ecore}ExpressionLanguage" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Expression", propOrder = {
    "formula"
})
public class Expression {

  protected String formula;
  @XmlAttribute(name = "language")
  protected ExpressionLanguage language;

  /**
   * Gets the value of the formula property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getFormula() {
    return formula;
  }

  /**
   * Sets the value of the formula property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setFormula(String value) {
    this.formula = value;
  }

  /**
   * Gets the value of the language property.
   *
   * @return possible object is
   * {@link ExpressionLanguage }
   */
  public ExpressionLanguage getLanguage() {
    return language;
  }

  /**
   * Sets the value of the language property.
   *
   * @param value allowed object is
   *              {@link ExpressionLanguage }
   */
  public void setLanguage(ExpressionLanguage value) {
    this.language = value;
  }

}
