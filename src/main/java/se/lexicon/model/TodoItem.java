package se.lexicon.model;

import se.lexicon.data.sequencers.TodoItemIdSequencer;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class TodoItem {
    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;

    public TodoItem() {}

    public TodoItem(int id) {
        this.id = id;
    }

    public TodoItem(String title, LocalDate deadLine, Person creator) {
        this(TodoItemIdSequencer.nextId());
        this.done = false;
        this.setTitle(title);
        this.setDeadLine(deadLine);
        this.setCreator(creator);
    }

    public TodoItem(String title, LocalDate deadLine, Person creator, String taskDescription) {
        this(title, deadLine, creator);
        this.setTaskDescription(taskDescription);
    }

    public TodoItem(String title, LocalDate deadLine, Person creator, boolean done) {
        this(title, deadLine, creator);
        this.setDone(done);
    }

    public TodoItem(String title, LocalDate deadLine, Person creator, String taskDescription, boolean done) {
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
        this.creator = Objects.requireNonNull(creator, "Creator should not be null or empty.");
    }

    public boolean isOverdue() {
        return Period.between(deadLine, LocalDate.now()).getDays() > 0;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "done=" + done +
                ", deadLine=" + deadLine +
                ", taskDescription='" + taskDescription + '\'' +
                ", title='" + title + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return id == todoItem.id && done == todoItem.done && Objects.equals(title, todoItem.title) && Objects.equals(taskDescription, todoItem.taskDescription) && Objects.equals(deadLine, todoItem.deadLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, taskDescription, deadLine, done);
    }
}
