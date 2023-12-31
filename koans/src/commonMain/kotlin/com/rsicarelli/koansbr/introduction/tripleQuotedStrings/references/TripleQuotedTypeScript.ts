/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

const question: string = "life, the universe, and everything";
const answer: number = 42;

const tripleQuotedString: string = `
#question = "${question}"
#answer = ${answer}
`.trim().replace(/#/g, '');
