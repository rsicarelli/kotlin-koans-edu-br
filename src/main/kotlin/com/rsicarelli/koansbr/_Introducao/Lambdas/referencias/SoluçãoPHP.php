<?php

function containsEven($collection)
{
    foreach ($collection as $num) {
        if ($num % 2 == 0) {
            return true;
        }
    }
    return false;
}
