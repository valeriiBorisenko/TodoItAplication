package se.lexicon.model;

import se.lexicon.data.sequencers.TodoItemIdSequencer;

import java.util.Objects;

public class TodoItemTask {
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    public TodoItemTask() {}

    public TodoItemTask(int id) {
        this.id = id;
        this.assigned = false;
    }

    public TodoItemTask(TodoItem todoItem) {
        this(TodoItemIdSequencer.nextId());
        this.setTodoItem(todoItem);
    }

    public TodoItemTask(TodoItem todoItem, Person assignee) {
        this(todoItem);
        this.setAssignee(assignee);
        this.setAssigned(assignee != null);
    }

    public int getId() {
        return id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
        this.todoItem = Objects.requireNonNull(todoItem, "Not allowed to be null.");
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = Objects.requireNonNull(assignee, "Not allowed to be null.");
        this.assigned = true;
    }

    @Override
    public String toString() {
        return "TodoItemTask{" +
                "todoItem=" + todoItem +
                ", assigned=" + assigned +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItemTask itemTask = (TodoItemTask) o;
        return id == itemTask.id && assigned == itemTask.assigned && Objects.equals(todoItem, itemTask.todoItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, assigned, todoItem);
    }

}
