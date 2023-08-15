/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 *
 */

class Client {
  PersonalInfo? personalInfo;

  Client(this.personalInfo);
}

class PersonalInfo {
  String? email;

  PersonalInfo(this.email);
}

abstract class Mailer {
  void sendMessage(String email, String message);
}

void sendMessageToClient(Client? client, String? message, Mailer mailer) {
  String? email = client?.personalInfo?.email;
  if (email != null && message != null) {
    mailer.sendMessage(email, message);
  }
}
