package io.hedwig.todo.mock.todoitems;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import io.hedwig.explore.todo.entities.ToDo;

/**
 * 1. author: patrick 2. address: github.com/ideafortester
 */
public class ToDoGenerator {

  private static AtomicInteger TODOID_GENERATOR = new AtomicInteger(0);
  private static Random orderRandomer = new Random();
  private static Random todoSizeRandomer = new Random();

  /**
   * Generate To Do Item
   * @return
   */
  public static ToDo generateToDo(){
    ToDo todo = new ToDo();
    todo.setId(TODOID_GENERATOR.getAndIncrement());
    todo.setCompleted(true);
    todo.setOrder(orderRandomer.nextInt(10));
    todo.setTitle("ToDoGenerator");
    return todo;
  }

  /**
   * Generate To Do List
   * @return
   */
  public static List<ToDo> generateToDoList(){
    int size =todoSizeRandomer.nextInt(6);
    List<ToDo> toDoList = Lists.newArrayList();
    for (int i = 0; i < size; i++) {
      toDoList.add(generateToDo());
    }
    return toDoList;
  }
}
