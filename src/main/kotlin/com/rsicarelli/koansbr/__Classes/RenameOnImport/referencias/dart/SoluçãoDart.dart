/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 *
 */

import 'JavaRandom.dart' as JRandom;
import 'KotlinRandom.dart' as KRandom;

String useDifferentRandomClasses() {
  return "Kotlin random: " +
      KRandom.KotlinRandom().nextInt(2).toString() +
      " Java random: " +
      JRandom.JavaRandom().nextInt(2).toString() +
      ".";
}

void main() {
  print(useDifferentRandomClasses());
}
