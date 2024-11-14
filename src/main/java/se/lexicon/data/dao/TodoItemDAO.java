package se.lexicon.data.dao;

import se.lexicon.model.AppUser;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;

public interface TodoItemDAO {
    TodoItem persist(TodoItem todoItem);
    TodoItem findById(int id);
    Collection<TodoItem> findByAll();
    Collection<TodoItem> findByAllDoneStatus(boolean done);
    Collection<TodoItem> findByTitleContains(String title);
    Collection<TodoItem> findByPersonId(int personId);
    Collection<TodoItem> findByDeadlineBefore(LocalDate date);
    Collection<TodoItem> findByDeadlineAfter(LocalDate date);
    void remove(int id);
}
