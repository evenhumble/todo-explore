package io.hedwig.todo.mock.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;

import io.hedwig.explore.todo.entities.ToDo;
import io.hedwig.explore.todo.service.ToDoService;
import io.hedwig.todo.mock.todoitems.ToDoGenerator;

/**
 * 1. author: patrick
 * 2. address: github.com/ideafortester
 */
@Service
public class ToDoMockService implements ToDoService {

  @Override
  public Collection<ToDo> getAllToDoes() {
    return ToDoGenerator.generateToDoList();
  }

  @Override
  public ToDo getToDoById(long id) {
    return ToDoGenerator.generateToDo();
  }

  @Override
  public ToDo updateToDo(ToDo toDo) {
    ToDo todoItem = ToDoGenerator.generateToDo();
    todoItem.setId(toDo.getId());
    if (toDo.getCompleted() != null) {
      todoItem.setCompleted(toDo.getCompleted());
    }
    if (toDo.getTitle() != null) {
      todoItem.setTitle(toDo.getTitle());
    }

    if (toDo.getOrder() != null) {
      todoItem.setOrder(toDo.getOrder());
    }

    return todoItem;
  }

  @Override
  public ToDo deleteToDo(ToDo toDo) {
    ToDo todoItem = ToDoGenerator.generateToDo();
    todoItem.setId(toDo.getId());
    todoItem.setStatus(2);
    return todoItem;
  }

  @Override
  public ToDo addToDo(ToDo toDo) {
    ToDo todoItem = ToDoGenerator.generateToDo();
    todoItem.setTitle(toDo.getTitle());
    todoItem.setCompleted(toDo.getCompleted());
    todoItem.setOrder(toDo.getOrder());
    return todoItem;
  }
}
