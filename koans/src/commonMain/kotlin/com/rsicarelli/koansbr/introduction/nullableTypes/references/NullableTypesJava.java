/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.introduction.nullableTypes.references;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class NullableTypesJava {

    public static void sendMessageToClient(
            @Nullable Client client,
            @Nullable String message,
            @NotNull Mailer mailer
    ) {
        PersonalInfo personalInfo = (client != null) ? client.personalInfo() : null;
        String email = (personalInfo != null) ? personalInfo.email() : null;

        if (email != null && message != null) {
            mailer.sendMessage(email, message);
        }
    }

    public interface Mailer {
        void sendMessage(@NotNull String email, @NotNull String message);
    }

    public record Client(@Nullable PersonalInfo personalInfo) {
    }

    public record PersonalInfo(@Nullable String email) {
    }
}
