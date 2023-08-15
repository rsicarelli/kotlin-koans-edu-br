package com.rsicarelli.koansbr.__Classes.RenameOnImport.referencias;

class JavaRandom {

    public int nextInt(int value) {
        return 0;
    }
}

class KotlinRandom {

    public int nextInt(int value) {
        return 0;
    }
}

class Test {

    public static String useDifferentRandomClasses() {
        return "Kotlin random: " +
                new KotlinRandom().nextInt(2) +
                " Java random:" +
                new JavaRandom().nextInt(2) +
                ".";
    }

    public static void main(String[] args) {
        System.out.println(useDifferentRandomClasses());
    }
}
