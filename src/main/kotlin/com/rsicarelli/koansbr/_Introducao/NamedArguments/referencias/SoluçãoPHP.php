<?php

function joinOptions(array $options): string {
    $joined = implode(', ', $options);
    return '[' . $joined . ']';
}

?>
