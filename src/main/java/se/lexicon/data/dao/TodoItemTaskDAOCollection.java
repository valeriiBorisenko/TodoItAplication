package se.lexicon.data.dao;

import se.lexicon.model.TodoItem;
import se.lexicon.model.TodoItemTask;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO {

    private Collection<TodoItemTask> todoItemTasks;

    public TodoItemTaskDAOCollection(Collection<TodoItemTask> todoItemTasks) {
        this.todoItemTasks = todoItemTasks;
    }

    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {
        return todoItemTasks.add(todoItemTask) ? todoItemTask : null;
    }

    @Override
    public TodoItemTask findById(int id) {
        for (TodoItemTask item: todoItemTasks) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return Collections.unmodifiableCollection(todoItemTasks);
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean status) {
        Collection<TodoItemTask> findByStatus = new HashSet<>();

        for (TodoItemTask item: todoItemTasks) {
            if (item.isAssigned() == status) {
                findByStatus.add(item);
            }
        }
        return findByStatus;
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int personId) {
        Collection<TodoItemTask> findByPerson = new HashSet<>();

        for (TodoItemTask item: todoItemTasks) {
            if (item.getAssignee().getId() == personId) {
                findByPerson.add(item);
            }
        }
        return findByPerson;
    }

    @Override
    public void remove(int id) {
        todoItemTasks.remove(findById(id));
    }
}
