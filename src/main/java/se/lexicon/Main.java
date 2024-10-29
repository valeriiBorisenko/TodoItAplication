package se.lexicon;

import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;
import se.lexicon.model.TodoItemTask;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person samwise = new Person("Samwise", "Gamgee", "samwise.gamgee@lor.com");
        System.out.println(samwise.getSummary());

        TodoItem frodo = new TodoItem("Check Frodo", LocalDate.parse("2024-10-29"), true, samwise );
        System.out.println(frodo.getSummary());

        TodoItem frodoMountain = new TodoItem("Lift Frodo up the mountain", "Help and check his ring", LocalDate.parse("2024-10-27"), samwise );
        System.out.println(frodoMountain.getSummary());

        TodoItemTask itemTask1 = new TodoItemTask(frodo);
        System.out.println(itemTask1.getSummary());

        TodoItemTask itemTask2 = new TodoItemTask(frodoMountain, samwise);
        System.out.println(itemTask2.getSummary());
    }
}