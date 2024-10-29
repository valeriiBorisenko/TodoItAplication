package se.lexicon.model;

import se.lexicon.util.TodoItemConstant;
import se.lexicon.util.TodoItemIdGenerate;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class TodoItem {
    private final int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;

    public TodoItem(String title, LocalDate deadLine, Person creator) {
        this.id = TodoItemIdGenerate.nextId();
        this.done = TodoItemConstant.DONE;
        this.setTitle(title);
        this.setDeadLine(deadLine);
        this.setCreator(creator);
    }

    public TodoItem(String title, String taskDescription, LocalDate deadLine, Person creator) {
        this(title, deadLine, creator);
        this.setTaskDescription(taskDescription);
    }

    public TodoItem(String title, LocalDate deadLine, boolean done, Person creator) {
        this(title, deadLine, creator);
        this.setDone(done);
    }

    public TodoItem(String title, String taskDescription, LocalDate deadLine, boolean done, Person creator) {
        this(title, deadLine, creator);
        this.setTaskDescription(taskDescription);
        this.setDone(done);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) throw new IllegalArgumentException("Title should not be null or empty.");
        this.title = title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        if (taskDescription == null || taskDescription.isEmpty()) throw new IllegalArgumentException("Task description should not be null or empty.");
        this.taskDescription = taskDescription;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = Objects.requireNonNull(deadLine, "Deadline should not be null or empty.");
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isDone() {
        return done;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    public boolean isOverdue() {
        return Period.between(deadLine, LocalDate.now()).getDays() > 0;
    }

    public String getSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id);
        sb.append(", title: ").append(title);
        if (taskDescription != null) {
            sb.append(", description: ").append(taskDescription);
        }
        sb.append(", deadline: ").append(deadLine);
        if (done) {
            sb.append(", done");
        }
        sb.append(", creator: ").append(creator.getFirstName()).append(" ").append(creator.getLastName());

        return sb.toString();
    }
}
