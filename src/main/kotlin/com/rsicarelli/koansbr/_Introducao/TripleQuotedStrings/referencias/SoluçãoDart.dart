/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 *
 */

const question = 'life, the universe, and everything';
const answer = 42;

String tripleQuotedString() {
  return '''
  #question = "$question"
  #answer = $answer
  '''
      .trimLeft();
}

void main() {
  print(tripleQuotedString());
}
