/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

void failWithWrongAge(int? age) {
  throw ArgumentError('Wrong age: $age');
}

void checkAge(int? age) {
  if (age == null || age < 0 || age > 150) failWithWrongAge(age);
  print("Congrats! Next year you'll be ${age! + 1}.");
}

void main() {
  checkAge(10); // Outputs: Congrats! Next year you'll be 11.
}
