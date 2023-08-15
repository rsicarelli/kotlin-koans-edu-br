<?php
/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 *
 */

function joinOptions(array $options): string {
    $joined = implode(', ', $options);
    return '[' . $joined . ']';
}

?>
