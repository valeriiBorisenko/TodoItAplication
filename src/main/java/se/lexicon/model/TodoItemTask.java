package se.lexicon.model;

import java.util.Objects;

public class TodoItemTask {
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    public TodoItemTask(int id, TodoItem todoItem) {
        this.id = id;
        this.assigned = false;
        this.setTodoItem(todoItem);
    }

    public TodoItemTask(int id, TodoItem todoItem, Person assignee) {
        this(id, todoItem);
        this.setAssignee(assignee);
        this.setAssigned(assignee);
    }

    public int getId() {
        return id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(Person assignee) {
        this.assigned = assignee != null;
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
