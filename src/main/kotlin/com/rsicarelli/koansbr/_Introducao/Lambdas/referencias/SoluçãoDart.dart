/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 *
 */

bool containsEven(List<int> collection) {
  return collection.any((number) => number % 2 == 0);
}

void main() {
  print(containsEven([1, 3, 5])); // Outputs: false
  print(containsEven([1, 2, 3])); // Outputs: true
}
