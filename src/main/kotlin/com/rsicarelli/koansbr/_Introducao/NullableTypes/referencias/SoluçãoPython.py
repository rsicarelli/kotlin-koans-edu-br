class Client:
    def __init__(self, personal_info=None):
        self.personal_info = personal_info


class PersonalInfo:
    def __init__(self, email=None):
        self.email = email


class Mailer:
    def send_message(self, email: str, message: str):
        # Implementation of send_message goes here.
        pass


def send_message_to_client(client, message, mailer):
    email = None if client is None else client.personal_info.email
    if email and message:
        mailer.send_message(email, message)
