class Client {
    personalInfo: PersonalInfo | null;

    constructor(personalInfo: PersonalInfo | null = null) {
        this.personalInfo = personalInfo;
    }
}

class PersonalInfo {
    email: string | null;

    constructor(email: string | null = null) {
        this.email = email;
    }
}

class Mailer {
    sendMessage(email: string, message: string): void {
        // Implementation of sendMessage goes here.
    }
}

function sendMessageToClient(client: Client | null, message: string | null, mailer: Mailer): void {
    const email = client?.personalInfo?.email;
    if (email && message) {
        mailer.sendMessage(email, message);
    }
}
