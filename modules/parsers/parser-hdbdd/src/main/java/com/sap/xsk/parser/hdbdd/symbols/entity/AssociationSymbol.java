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
package com.sap.xsk.parser.hdbdd.symbols.entity;

import com.sap.xsk.parser.hdbdd.symbols.Symbol;
import com.sap.xsk.parser.hdbdd.symbols.context.Scope;
import java.util.ArrayList;
import java.util.List;

public class AssociationSymbol extends Symbol {
    private CardinalityEnum cardinality;
    private EntitySymbol target;
    private List<EntityElementSymbol> foreignKeys = new ArrayList<>();

    public AssociationSymbol(String name) {
        super(name);
    }

    public AssociationSymbol(String name, Scope scope) {
        super(name, scope);
    }

    public CardinalityEnum getCardinality() {
        return cardinality;
    }

    public void setCardinality(CardinalityEnum cardinality) {
        this.cardinality = cardinality;
    }

    public List<EntityElementSymbol> getForeignKeys() {
        return foreignKeys;
    }

    public void setForeignKeys(List<EntityElementSymbol> foreignKeys) {
        this.foreignKeys = foreignKeys;
    }

    public EntitySymbol getTarget() {
        return target;
    }

    public void setTarget(EntitySymbol target) {
        this.target = target;
    }

    public void addForeignKey(EntityElementSymbol elementSymbol) {
        this.foreignKeys.add(elementSymbol);
    }
}
