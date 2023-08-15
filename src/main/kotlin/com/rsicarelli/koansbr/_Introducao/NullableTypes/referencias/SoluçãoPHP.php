<?php

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
