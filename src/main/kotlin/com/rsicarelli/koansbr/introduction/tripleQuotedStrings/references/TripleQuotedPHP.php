<?php
/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

const QUESTION = "life, the universe, and everything";
const ANSWER = 42;

$tripleQuotedString = "
#question = \"" . QUESTION . "\"
#answer = " . ANSWER;

echo $tripleQuotedString;
