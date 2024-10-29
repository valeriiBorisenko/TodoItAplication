package se.lexicon.util;

public class PersonIdGenerate {
    private static int id = 5;

    public static int nextId() {
        return ++id;
    }
}
