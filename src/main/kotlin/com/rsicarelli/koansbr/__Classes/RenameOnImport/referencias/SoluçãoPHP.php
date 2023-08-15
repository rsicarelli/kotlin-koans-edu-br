<?php

namespace JavaRandom {
    class JavaRandom
    {
        public function nextInt($value)
        {
            return 0;
        }
    }
}

namespace KotlinRandom {
    class KotlinRandom
    {
        public function nextInt($value)
        {
            return 0;
        }
    }
}

namespace Main {

    use JavaRandom\JavaRandom as JRandom;
    use KotlinRandom\KotlinRandom as KRandom;

    function useDifferentRandomClasses()
    {
        return "Kotlin random: " . (new KRandom())->nextInt(2) . " Java random: " . (new JRandom())->nextInt(2) . ".";
    }

    echo useDifferentRandomClasses();
}
