/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */
class Client {
    constructor(public personalInfo: PersonalInfo) {
    }
}

class PersonalInfo {
    constructor(public email: string) {
    }
}

interface Mailer {
    sendMessage(email: string, message: string): void;
}

class ConsoleMailer implements Mailer {
    sendMessage(email: string, message: string): void {
        console.log(`Sending message to ${email}: ${message}`);
    }
}

function sendMessageToClient(client: Client | null, message: string | null, mailer: Mailer): void {
    const email: string = client?.personalInfo?.email;
    if (email !== undefined && message !== null) {
        mailer.sendMessage(email, message);
    }
}

const personalInfo: PersonalInfo = new PersonalInfo('test@example.com');
const client: Client = new Client(personalInfo);
const mailer: ConsoleMailer = new ConsoleMailer();
sendMessageToClient(client, 'Hello, client!', mailer);
