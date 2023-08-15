/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 *
 */

package com.rsicarelli.koansbr._Introducao.NullableTypes.referencias.java;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SoluçãoJava {
    public void sendMessageToClient(
            @Nullable ClientJava client,
            @Nullable String message,
            @NotNull MailerJava mailer
    ) {
        if (client == null || message == null) return;

        PersonalInfoJava personalInfo = client.getPersonalInfo();
        if (personalInfo == null) return;

        String email = personalInfo.getEmail();
        if (email == null) return;

        mailer.sendMessage(email, message);
    }
}
