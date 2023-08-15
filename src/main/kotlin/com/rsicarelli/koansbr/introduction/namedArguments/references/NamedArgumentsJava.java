/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.introduction.namedArguments.references;

import java.util.Collection;

public class NamedArgumentsJava {
    public static String joinOptionsJava(Collection<String> options) {
        return "[" + String.join(", ", options) + "]";
    }
}
