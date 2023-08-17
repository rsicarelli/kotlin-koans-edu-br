/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

func containsEven(collection: [Int]) -> Bool {
    return collection.contains(where: { item in item % 2 == 0 })
}
