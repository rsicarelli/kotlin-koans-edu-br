/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.introduction.lambdas.references;

import java.util.Collection;

public class LambdasJava {
    public static boolean containsEvenJava(Collection<Integer> collection) {
        return collection.stream().anyMatch(num -> num % 2 == 0);
    }
}
