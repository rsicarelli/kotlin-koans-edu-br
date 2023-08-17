/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

void main() {
  try {
    checkAge(10);
  } catch (e) {
    print(e);
  }
}

void failWithWrongAge(int? age) {
  throw ArgumentError("Wrong age: $age");
}

void checkAge(int? age) {
  if (age == null || age < 0 || age > 150) {
    failWithWrongAge(age);
  }
  print("Congrats! Next year you'll be ${age! + 1}.");
}
