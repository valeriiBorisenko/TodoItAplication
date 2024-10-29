package se.lexicon.util;

public class TodoItemIdGenerate {
    private static int id = 10;

    public static int nextId() {
        return ++id;
    }
}
