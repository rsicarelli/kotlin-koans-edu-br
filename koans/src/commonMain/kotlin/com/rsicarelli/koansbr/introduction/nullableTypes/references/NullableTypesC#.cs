/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

using System;

class Program
{
    static void Main(string[] args)
    {
        Client client = new Client(new PersonalInfo("test@example.com"));
        Mailer mailer = new ConsoleMailer();
        SendMessageToClient(client, "Hello, client!", mailer);
    }

    static void SendMessageToClient(Client? client, string? message, Mailer mailer)
    {
        string? email = client?.PersonalInfo?.Email;
        if (!string.IsNullOrEmpty(email) && !string.IsNullOrEmpty(message))
        {
            mailer.SendMessage(email, message);
        }
    }
}

class Client
{
    public PersonalInfo? PersonalInfo { get; }

    public Client(PersonalInfo? personalInfo)
    {
        PersonalInfo = personalInfo;
    }
}

class PersonalInfo
{
    public string? Email { get; }

    public PersonalInfo(string? email)
    {
        Email = email;
    }
}

interface Mailer
{
    void SendMessage(string email, string message);
}

class ConsoleMailer : Mailer
{
    public void SendMessage(string email, string message)
    {
        Console.WriteLine($"Sending message to {email}: {message}");
    }
}

