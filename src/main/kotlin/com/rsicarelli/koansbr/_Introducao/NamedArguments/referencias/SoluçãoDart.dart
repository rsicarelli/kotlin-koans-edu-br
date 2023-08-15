/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

String joinOptions(List<String> options) {
  return '[' + options.join(', ') + ']';
}

void main() {
  print(joinOptions([
    'Option 1',
    'Option 2',
    'Option 3'
  ])); // Outputs: [Option 1, Option 2, Option 3]
}
