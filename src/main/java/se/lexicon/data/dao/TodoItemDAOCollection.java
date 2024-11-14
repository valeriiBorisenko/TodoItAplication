package se.lexicon.data.dao;

import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class TodoItemDAOCollection implements TodoItemDAO{

    private Collection<TodoItem> todoItems;

    public TodoItemDAOCollection(Collection<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    @Override
    public TodoItem persist(TodoItem todoItem) {
        return todoItems.add(todoItem) ? todoItem : null;
    }

    @Override
    public TodoItem findById(int id) {
        for (TodoItem item: todoItems) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Collection<TodoItem> findByAll() {
        return Collections.unmodifiableCollection(todoItems);
    }

    @Override
    public Collection<TodoItem> findByAllDoneStatus(boolean done) {
        Collection<TodoItem> findByDone = new HashSet<>();

        for (TodoItem item: todoItems) {
            if (item.isDone() == done) {
                findByDone.add(item);
            }
        }
        return findByDone;
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        Collection<TodoItem> findByTitle = new HashSet<>();

        for (TodoItem item: todoItems) {
            if (item.getTitle().trim().toLowerCase().contains(title.trim().toLowerCase())) {
                findByTitle.add(item);
            }
        }
        return findByTitle;
    }

    @Override
    public Collection<TodoItem> findByPersonId(int personId) {
        Collection<TodoItem> findByPersonId = new HashSet<>();

        for (TodoItem item: todoItems) {
            if (item.getCreator().getId() == personId) {
                findByPersonId.add(item);
            }
        }
        return findByPersonId;
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate date) {
        Collection<TodoItem> findByBefore = new HashSet<>();

        for (TodoItem item : todoItems) {
            if (item.getDeadLine().isBefore(date)) {
                findByBefore.add(item);
            }
        }
        return findByBefore;
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate date) {
        Collection<TodoItem> findByAfter = new HashSet<>();

        for (TodoItem item : todoItems) {
            if (item.getDeadLine().isAfter(date)) {
                findByAfter.add(item);
            }
        }
        return findByAfter;
    }

    @Override
    public void remove(int id) {
        todoItems.remove(findById(id));
    }
}
