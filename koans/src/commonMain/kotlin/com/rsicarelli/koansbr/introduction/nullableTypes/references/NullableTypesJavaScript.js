/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

class Client {
    constructor(personalInfo = null) {
        this.personalInfo = personalInfo;
    }
}

class PersonalInfo {
    constructor(email = '') {
        this.email = email;
    }
}

class Mailer {
    sendMessage(email, message) {
    }
}

// noinspection JSUnusedGlobalSymbols
function sendMessageToClient(client, message, mailer) {
    const email = client?.personalInfo?.email;
    if (email && message) {
        mailer.sendMessage(email, message);
    }
}
