/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

import Foundation

class Client {
    let personalInfo: PersonalInfo?

    init(personalInfo: PersonalInfo?) {
        self.personalInfo = personalInfo
    }
}

class PersonalInfo {
    let email: String?

    init(email: String?) {
        self.email = email
    }
}

protocol Mailer {
    func sendMessage(email: String, message: String)
}

class ConsoleMailer: Mailer {
    func sendMessage(email: String, message: String) {
        print("Sending message to \(email): \(message)")
    }
}

func sendMessageToClient(client: Client?, message: String?, mailer: Mailer) {
    let email = client?.personalInfo?.email
    if let email = email, let message = message {
        mailer.sendMessage(email: email, message: message)
    }
}

let client = Client(personalInfo: PersonalInfo(email: "test@example.com"))
let mailer = ConsoleMailer()
sendMessageToClient(client: client, message)
