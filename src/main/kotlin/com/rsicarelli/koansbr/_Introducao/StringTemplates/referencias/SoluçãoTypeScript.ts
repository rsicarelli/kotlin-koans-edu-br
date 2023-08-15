const month: string = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)";

function getPattern(): string {
    return `\\d{2} ${month} \\d{4}`;
}
