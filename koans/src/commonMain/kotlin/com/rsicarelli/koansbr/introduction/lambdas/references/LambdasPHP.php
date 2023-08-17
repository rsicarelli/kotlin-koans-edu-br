<?php
/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

function containsEven($collection)
{
    return in_array(true, array_map(function ($item) {
        return $item % 2 === 0;
    }, $collection));
}
