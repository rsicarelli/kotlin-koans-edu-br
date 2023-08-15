<?php

/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

/** @noinspection PhpIllegalPsrClassPathInspection */
/** @noinspection PhpMultipleClassesDeclarationsInOneFile */

namespace JavaRandom {
    class JavaRandom
    {
        public function nextInt($value): int
        {
            return $value;
        }
    }
}

namespace KotlinRandom {
    class KotlinRandom
    {
        public function nextInt($value): int
        {
            return $value;
        }
    }
}

namespace Main {

    use JavaRandom\JavaRandom as JRandom;
    use KotlinRandom\KotlinRandom as KRandom;

    function useDifferentRandomClasses(): string
    {
        return "Kotlin random: " . (new KRandom())->nextInt(2) . " Java random: " . (new JRandom())->nextInt(2) . ".";
    }

    echo useDifferentRandomClasses();
}
