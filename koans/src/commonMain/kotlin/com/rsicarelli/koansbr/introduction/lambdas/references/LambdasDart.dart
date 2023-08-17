/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

bool containsEven(List<int> collection) {
  return collection.any((item) => item % 2 == 0);
}
