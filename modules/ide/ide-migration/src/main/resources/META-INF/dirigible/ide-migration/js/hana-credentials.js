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
migrationLaunchView.controller('HanaCredentialsViewController', ['$scope', '$messageHub', function ($scope, $messageHub) {
    $scope.isVisible = false;
    $scope.passwordVisible = false;

    $scope.userInput = function () {
        if ($scope.schemaName && $scope.username && $scope.password) {
            $scope.$parent.setNextEnabled(true);
        } else {
            $scope.$parent.setNextEnabled(false);
        };
    };

    $scope.showPassword = function () {
        $scope.passwordVisible = !$scope.passwordVisible;
    };

    $messageHub.on('migration.hana-credentials', function (msg) {
        if ("isVisible" in msg.data) {
            $scope.$apply(function () {
                $scope.isVisible = msg.data.isVisible;
                if (msg.data.isVisible) {
                    $scope.userInput();
                    $scope.$parent.setPreviousVisible(true);
                    $scope.$parent.setPreviousEnabled(true);
                    $scope.$parent.setNextVisible(true);
                    $scope.$parent.setFinishVisible(false);
                }
            });
        }
        if ("getData" in msg.data) {
            if (msg.data.getData === "all") {
                $messageHub.message(msg.data.controller, {
                    hanaData: {
                        "databaseSchema": $scope.schemaName,
                        "username": $scope.username,
                        "password": $scope.password
                    }
                });
            }
        }
    }.bind(this));
}]);