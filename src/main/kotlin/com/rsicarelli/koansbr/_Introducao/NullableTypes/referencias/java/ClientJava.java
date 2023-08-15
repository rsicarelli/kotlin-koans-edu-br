/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 *
 */

package com.rsicarelli.koansbr._Introducao.NullableTypes.referencias.java;

public class ClientJava {
    private PersonalInfoJava personalInfo;

    public ClientJava(PersonalInfoJava personalInfo) {
        this.personalInfo = personalInfo;
    }

    public PersonalInfoJava getPersonalInfo() {
        return personalInfo;
    }
}
