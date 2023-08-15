/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package references

type Client struct {
	PersonalInfo *PersonalInfo
}

type PersonalInfo struct {
	Email string
}

type Mailer interface {
	SendMessage(string, string)
}

func sendMessageToClient(client *Client, message string, mailer Mailer) {
	if client == nil || client.PersonalInfo == nil || message == "" {
		return
	}

	email := client.PersonalInfo.Email
	if email != "" {
		mailer.SendMessage(email, message)
	}
}