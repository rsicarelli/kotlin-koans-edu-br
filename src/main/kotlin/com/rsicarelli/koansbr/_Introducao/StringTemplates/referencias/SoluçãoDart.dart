/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 *
 */

const month = r'(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)';

String getPattern() {
  return r'\d{2} ' + month + ' \d{4}';
}

void main() {
  print(getPattern());
}
