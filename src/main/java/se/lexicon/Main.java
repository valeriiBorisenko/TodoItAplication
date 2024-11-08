package se.lexicon;

import se.lexicon.model.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        AppUser user = new AppUser("Sam", "q1w2e3r4", AppRole.ROLE_APP_USER);
        AppUser admin = new AppUser("Gandalf", "q1w2e3r4t5", AppRole.ROLE_APP_ADMIN);


        Person samwise = new Person("Samwise", "Gamgee", "samwise.gamgee@lor.com", user);
        Person gandalf = new Person("Gandalf", "the Grey", "gandalf.thegray@lor.com", admin);

        System.out.println(user);
        System.out.println(samwise);

        TodoItem frodoWith = new TodoItem("With Frodo", LocalDate.parse("2024-10-28"), samwise );
        TodoItem frodoWith2 = new TodoItem("With Frodo", LocalDate.parse("2024-10-28"), samwise );
        System.out.println(frodoWith);
        System.out.println(frodoWith.equals(frodoWith2));

        TodoItem frodoCheck = new TodoItem("Check Frodo", LocalDate.parse("2024-10-29"), samwise, true );
        System.out.println(frodoCheck);

        TodoItem frodoMountain = new TodoItem("Lift Frodo up the mountain", LocalDate.parse("2024-10-27"), samwise, "Help him to climb" );
        System.out.println(frodoMountain);

        TodoItem frodoRing = new TodoItem("Frodo and ring", LocalDate.parse("2024-10-30"), samwise, "Check his ring", true);
        System.out.println(frodoRing);

        TodoItemTask itemTask1 = new TodoItemTask(frodoRing);
        System.out.println(itemTask1);

        TodoItemTask itemTask2 = new TodoItemTask(frodoMountain, samwise);
        System.out.println(itemTask2);
    }
}