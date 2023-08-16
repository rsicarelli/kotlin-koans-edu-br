<?php
/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */
// PHP não suporta named arguments.
function joinOptions($options): string
{
    return implode(', ', $options);
}

$options = ['Option 1', 'Option 2', 'Option 3'];
$result = joinOptions($options);
echo $result;
