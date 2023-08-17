#  SPDX-License-Identifier: MIT
#  Copyright (c) 2023-2023 Rodrigo Sicarelli
#
#
#
#
#
#
#
#

class Client:
    def __init__(self, personal_info):
        self.personal_info = personal_info


class PersonalInfo:
    def __init__(self, email):
        self.email = email


class Mailer:
    @staticmethod
    def send_message(email, message):
        print(f"Sending message to {email}: {message}")


class ConsoleMailer(Mailer):
    pass


# noinspection PyShadowingNames
def send_message_to_client(client, message, mailer):
    email = client.personal_info.email if client and client.personal_info and client.personal_info.email else None
    if email is not None and message is not None:
        mailer.send_message(email, message)


client = Client(PersonalInfo("test@example.com"))
mailer = ConsoleMailer()
send_message_to_client(client, "Hello, client!", mailer)
