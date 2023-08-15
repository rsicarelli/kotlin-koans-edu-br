<?php
/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 *
 */

function containsEven($collection)
{
    foreach ($collection as $num) {
        if ($num % 2 == 0) {
            return true;
        }
    }
    return false;
}
