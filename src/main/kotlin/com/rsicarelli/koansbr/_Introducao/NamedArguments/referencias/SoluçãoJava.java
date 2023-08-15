/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr._Introducao.NamedArguments.referencias;

import java.util.Collection;

public class SoluçãoJava {
    public static String joinOptions(Collection<String> options) {
        return "[" + String.join(", ", options) + "]";
    }
}
