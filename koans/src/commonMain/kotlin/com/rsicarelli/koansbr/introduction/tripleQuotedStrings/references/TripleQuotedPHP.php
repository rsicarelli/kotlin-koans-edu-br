<?php
/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */


$answer = 42;
$question = "life, the universe, and everything";
define("tripleQuotedString", <<<EOT
#question = "$question"
#answer = $answer
EOT
);
