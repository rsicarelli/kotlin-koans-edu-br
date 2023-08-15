const month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)";

function getPattern() {
    return `\\d{2} ${month} \\d{4}`;
}
