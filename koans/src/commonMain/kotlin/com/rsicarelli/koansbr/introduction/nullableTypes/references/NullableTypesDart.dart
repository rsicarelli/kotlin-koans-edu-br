/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

void main() {
  final client = Client(PersonalInfo('test@example.com'));
  final mailer = ConsoleMailer();
  sendMessageToClient(client, 'Hello, client!', mailer);
}

void sendMessageToClient(Client? client, String? message, Mailer mailer) {
  final email = client?.personalInfo?.email;
  if (email != null && message != null) {
    mailer.sendMessage(email, message);
  }
}

class Client {
  final PersonalInfo? personalInfo;

  Client(this.personalInfo);
}

class PersonalInfo {
  final String? email;

  PersonalInfo(this.email);
}

class Mailer {
  void sendMessage(String email, String message) {
    print('Sending message to $email: $message');
  }
}

class ConsoleMailer extends Mailer {}
