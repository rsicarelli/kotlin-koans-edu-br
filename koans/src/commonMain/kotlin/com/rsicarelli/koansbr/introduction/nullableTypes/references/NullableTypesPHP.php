<?php
/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2014-2023 Rodrigo Sicarelli
 */

/** @noinspection PhpUnused */
/** @noinspection PhpIllegalPsrClassPathInspection */

/** @noinspection PhpMultipleClassesDeclarationsInOneFile */

/**
 * @property mixed $personalInfo
 */
class Client
{
    public function __construct($personalInfo)
    {
        $this->personalInfo = $personalInfo;
    }
}

/**
 * @property mixed $email
 */
class PersonalInfo
{
    public function __construct($email)
    {
        $this->email = $email;
    }
}

class Mailer
{
    public function sendMessage($email, $message)
    {
        echo "Sending message to $email: $message\n";
    }
}

class ConsoleMailer extends Mailer
{
}

function sendMessageToClient($client, $message, $mailer)
{
    $email = $client->personalInfo->email ?? null;
    if ($email !== null && $message !== null) {
        $mailer->sendMessage($email, $message);
    }
}

$client = new Client(new PersonalInfo('test@example.com'));
$mailer = new ConsoleMailer();
sendMessageToClient($client, 'Hello, client!', $mailer);
