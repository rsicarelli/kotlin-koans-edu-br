/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

public class Client
{
    public PersonalInfo? PersonalInfo { get; }

    public Client(PersonalInfo? personalInfo)
    {
        PersonalInfo = personalInfo;
    }
}

public class PersonalInfo
{
    public string? Email { get; }

    public PersonalInfo(string? email)
    {
        Email = email;
    }
}

public interface IMailer
{
    void SendMessage(string email, string message);
}

public static class MessageService
{
    public static void SendMessageToClient(
        Client? client, string? message, IMailer mailer)
    {
        string? email = client?.PersonalInfo?.Email;
        if (email != null && message != null)
        {
            mailer.SendMessage(email, message);
        }
    }
}
