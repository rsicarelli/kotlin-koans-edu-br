/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.introduction.nullableTypes.references;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

interface Mailer {
    void sendMessage(String email, String message);
}

class Client {
    private final PersonalInfoJava personalInfo;

    public Client(PersonalInfoJava personalInfo) {
        this.personalInfo = personalInfo;
    }

    public PersonalInfoJava getPersonalInfo() {
        return personalInfo;
    }
}

class PersonalInfoJava {
    private final String email;

    public PersonalInfoJava(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}

@SuppressWarnings("unused")
public class NullableTypesJava {
    @SuppressWarnings("ClassEscapesDefinedScope")
public void sendMessageToClient(
        @Nullable Client client,
        @Nullable String message,
        @NotNull Mailer mailer
) {
    if (client == null || message == null) return;

    PersonalInfoJava personalInfo = client.getPersonalInfo();
    if (personalInfo == null) return;

    String email = personalInfo.getEmail();
    if (email == null) return;

    mailer.sendMessage(email, message);
}
}
