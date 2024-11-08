package se.lexicon.model;

import se.lexicon.util.TodoItemTaskIdConstant;
import se.lexicon.util.TodoItemTaskIdGenerate;

import java.util.Objects;

public class TodoItemTask {
    private final int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    public TodoItemTask(TodoItem todoItem) {
        this.id = TodoItemTaskIdGenerate.nextId();
        this.assigned = TodoItemTaskIdConstant.ASSIGNED;
        this.setTodoItem(todoItem);
    }

    public TodoItemTask(TodoItem todoItem, Person assignee) {
        this(todoItem);
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
        StringBuilder sb = new StringBuilder();
        sb.append("{id: ").append(id).append(", assigned: ").append(assigned).append(", todoItem: ").append(todoItem).append("}");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, assigned, todoItem);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TodoItemTask newObj = (TodoItemTask) obj;

        return id == newObj.id && Objects.equals(todoItem, newObj.todoItem) && assigned == newObj.assigned;
    }
}
