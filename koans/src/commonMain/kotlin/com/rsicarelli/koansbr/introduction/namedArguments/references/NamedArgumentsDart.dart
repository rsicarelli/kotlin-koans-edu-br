/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

// Dart não suporta named arguments.
String joinOptions(List<String> options) {
  return options.join(', ');
}

void main() {
  List<String> options = ['Option 1', 'Option 2', 'Option 3'];
  String result = joinOptions(options);
  print(result);
}

