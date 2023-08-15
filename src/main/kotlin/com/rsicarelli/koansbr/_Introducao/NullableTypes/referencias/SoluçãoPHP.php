<?php
/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

class Client
{
    public $personalInfo;

    function __construct($personalInfo)
    {
        $this->personalInfo = $personalInfo;
    }
}

class PersonalInfo
{
    public $email;

    function __construct($email)
    {
        $this->email = $email;
    }
}

interface Mailer
{
    public function sendMessage($email, $message);
}

function sendMessageToClient($client, $message, $mailer)
{
    $email = null;
    if ($client != null && $client->personalInfo != null) {
        $email = $client->personalInfo->email;
    }

    if ($email != null && $message != null) {
        $mailer->sendMessage($email, $message);
    }
}
