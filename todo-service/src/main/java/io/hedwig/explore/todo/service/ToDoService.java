package io.hedwig.explore.todo.service;

import io.hedwig.explore.todo.entities.ToDo;

import java.util.Collection;

/**
 * Created by patrick on 2017/6/30.
 */
public interface ToDoService {
    Collection<ToDo> getAllToDoes();
    ToDo getToDoById(long id);
    ToDo updateToDo(ToDo toDo);
    ToDo deleteToDo(ToDo toDo);
    ToDo addToDo(ToDo toDo);
}
