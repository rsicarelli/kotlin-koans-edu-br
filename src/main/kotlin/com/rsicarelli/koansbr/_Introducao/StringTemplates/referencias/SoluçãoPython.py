month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

def get_pattern():
    return "\\d{2} " + month + " \\d{4}"
