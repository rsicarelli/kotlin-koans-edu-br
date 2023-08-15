class Client {
    var personalInfo: PersonalInfo?
    init(personalInfo: PersonalInfo?){
        self.personalInfo = personalInfo
    }
}

class PersonalInfo {
    var email: String?
    init(email: String?){
        self.email = email
    }
}

protocol Mailer {
    func sendMessage(_ email: String, _ message: String)
}

func sendMessageToClient(client: Client?, message: String?, mailer: Mailer) {
    guard let email = client?.personalInfo?.email, email != "" else { return }
    guard let message = message, message != "" else { return }
    mailer.sendMessage(email, message)
}
