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

function sendMessageToClient(client, message, mailer) {
    const email = client?.personalInfo?.email;
    if (email && message) {
        mailer.sendMessage(email, message);
    }
}
