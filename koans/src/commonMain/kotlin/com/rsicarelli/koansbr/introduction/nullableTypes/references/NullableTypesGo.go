/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package references

import (
	"fmt"
)

func main() {
	email := "test@example.com"
	personalInfo := &PersonalInfo{Email: &email}
	client := &Client{PersonalInfo: personalInfo}
	mailer := ConsoleMailer{}
	sendMessageToClient(client, "Hello, client!", mailer)
}

func sendMessageToClient(client *Client, message string, mailer Mailer) {
	var email string
	if client != nil && client.PersonalInfo != nil && client.PersonalInfo.Email != nil {
		email = *client.PersonalInfo.Email
	}
	if email != "" && message != "" {
		mailer.SendMessage(email, message)
	}
}

type Client struct {
	PersonalInfo *PersonalInfo
}

type PersonalInfo struct {
	Email *string
}

type Mailer interface {
	SendMessage(email string, message string)
}

type ConsoleMailer struct{}

func (c ConsoleMailer) SendMessage(email string, message string) {
	fmt.Printf("Sending message to %s: %s\n", email, message)
}
