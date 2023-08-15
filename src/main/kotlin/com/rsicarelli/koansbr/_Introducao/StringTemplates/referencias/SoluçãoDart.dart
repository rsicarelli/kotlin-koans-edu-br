const month = r'(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)';

String getPattern() {
  return r'\d{2} ' + month + ' \d{4}';
}

void main() {
  print(getPattern());
}
