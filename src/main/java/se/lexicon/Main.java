package se.lexicon;

import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;
import se.lexicon.model.TodoItemTask;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person samwise = new Person("Samwise", "Gamgee", "samwise.gamgee@lor.com");
        System.out.println(samwise.getSummary());

        TodoItem frodoWith = new TodoItem("With Frodo", LocalDate.parse("2024-10-28"), samwise );
        System.out.println(frodoWith.getSummary());

        TodoItem frodoCheck = new TodoItem("Check Frodo", LocalDate.parse("2024-10-29"), samwise, true );
        System.out.println(frodoCheck.getSummary());

        TodoItem frodoMountain = new TodoItem("Lift Frodo up the mountain", LocalDate.parse("2024-10-27"), samwise, "Help him to climb" );
        System.out.println(frodoMountain.getSummary());

        TodoItem frodoRing = new TodoItem("Frodo and ring", LocalDate.parse("2024-10-30"), samwise, "Check his ring", true);
        System.out.println(frodoRing.getSummary());

        TodoItemTask itemTask1 = new TodoItemTask(frodoRing);
        System.out.println(itemTask1.getSummary());

        TodoItemTask itemTask2 = new TodoItemTask(frodoMountain, samwise);
        System.out.println(itemTask2.getSummary());
    }
}