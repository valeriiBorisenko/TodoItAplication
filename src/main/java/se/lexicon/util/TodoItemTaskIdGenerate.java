package se.lexicon.util;

public class TodoItemTaskIdGenerate {
    private static int id = 15;

    public static int nextId() {
        return ++id;
    }
}
