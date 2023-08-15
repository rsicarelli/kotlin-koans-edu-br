<?php

const MONTH = '(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)';

function getPattern(): string
{
    return '/\d{2} ' . MONTH . ' \d{4}/';
}

echo getPattern();
