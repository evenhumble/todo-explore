package io.hedwig.todo.mock.todoitems;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

import io.hedwig.explore.todo.entities.ToDo;

/**
 * 1. author: patrick 2. address: github.com/ideafortester
 */
public class ToDoGeneratorTest {

  @Test
  public void test_generateToDo() throws Exception {
    ToDo todo = ToDoGenerator.generateToDo();
    assertNotNull(todo);
  }

  @Test
  public void test_generateToDoList() throws Exception {
    List<ToDo> todos = ToDoGenerator.generateToDoList();
    assertNotNull(todos);
  }

}