/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.introduction.nullableTypes.references;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NullableTypesJava {
    public static void main(String[] args) {
        PersonalInfo personalInfo = new PersonalInfo("test@example.com");
        Client client = new Client(personalInfo);
        Mailer mailer = new ConsoleMailer();
        sendMessageToClient(client, "Hello, client!", mailer);
    }

    @SuppressWarnings("SameParameterValue")
    static void sendMessageToClient(@Nullable Client client, @Nullable String message, @NotNull Mailer mailer) {
        String email = client != null && client.personalInfo != null ? client.personalInfo.email : null;
        if (email != null && message != null) {
            mailer.sendMessage(email, message);
        }
    }
}

class Client {
    @Nullable
    PersonalInfo personalInfo;

    Client(@Nullable PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }
}

class PersonalInfo {
    @NotNull
    String email;

    PersonalInfo(@NotNull String email) {
        this.email = email;
    }
}

interface Mailer {
    void sendMessage(@NotNull String email, @NotNull String message);
}

class ConsoleMailer implements Mailer {
    public void sendMessage(@NotNull String email, @NotNull String message) {
        System.out.printf("Sending message to %s: %s%n", email, message);
    }
}

