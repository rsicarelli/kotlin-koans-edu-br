/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */
class Client {
    constructor(personalInfo) {
        this.personalInfo = personalInfo;
    }
}

class PersonalInfo {
    constructor(email) {
        this.email = email;
    }
}

class Mailer {
    sendMessage(email, message) {
        console.log(`Sending message to ${email}: ${message}`);
    }
}

class ConsoleMailer extends Mailer {
}

function sendMessageToClient(client, message, mailer) {
    const email = client?.personalInfo?.email;
    if (email !== undefined && message !== undefined) {
        mailer.sendMessage(email, message);
    }
}

const client = new Client(new PersonalInfo('test@example.com'));
const mailer = new ConsoleMailer();
sendMessageToClient(client, 'Hello, client!', mailer);
