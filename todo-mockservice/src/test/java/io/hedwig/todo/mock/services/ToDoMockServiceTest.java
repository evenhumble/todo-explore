package io.hedwig.todo.mock.services;

import static org.hamcrest.core.IsEqual.equalTo;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Map;

import io.hedwig.explore.todo.entities.ToDo;
import io.hedwig.explore.todo.service.ToDoService;
import io.hedwig.todo.mock.AbstractToDoIntegrationTest;

/**
 * 1. author: patrick 2. address: github.com/ideafortester
 */
public class ToDoMockServiceTest extends AbstractToDoIntegrationTest{

  @Autowired
  private ToDoService toDoService;

  @Autowired
  private ApplicationContext applicationContext;

  @Test
  public void testGetById() {
    Assert.assertNotNull(toDoService.getToDoById(100L));
  }

  @Test
  public void testAddToDo() {
    ToDo item = new ToDo();
    item.setTitle("ToDoGenerator");
    ToDo toDo = toDoService.addToDo(item);
    Assert.assertThat(toDo.getTitle(), equalTo("ToDoGenerator"));
  }
  @Test
  public void testUpdateToDo() {
    ToDo item = new ToDo();
    item.setTitle("ToDoGenerator");
    item.setCompleted(false);
    item.setOrder(2);
    item.setStatus(0);
    item.setId(1000);
    ToDo toDo = toDoService.updateToDo(item);
    Assert.assertThat(toDo.getTitle(), equalTo("ToDoGenerator"));
    Assert.assertThat(toDo.getCompleted(), equalTo(false));
    Assert.assertThat(toDo.getOrder(), equalTo(2));
    // TODO: 2017/10/9  trick things, need to update status also
    Assert.assertThat(toDo.getStatus(), equalTo(1));

    Assert.assertThat(toDo.getId(), equalTo(1000L));
  }

  @Test
  public void testDeleteToDo() {
    ToDo item = new ToDo();
    item.setTitle("ToDoGenerator");
    item.setId(1000);
    ToDo toDo = toDoService.deleteToDo(item);
    Assert.assertThat(toDo.getStatus(), equalTo(2));
  }
  @Test
  public void testBeanType() {
    Map<String, ToDoService>
        toDoServiceMapping = this.applicationContext.getBeansOfType(ToDoService.class);
    for (Map.Entry<String, ToDoService> entry : toDoServiceMapping.entrySet()) {
      System.out.println(entry.getKey() + "=" + entry.getValue());
    }
    Assert.assertThat(this.applicationContext.getBeansOfType(ToDoService.class).size(), equalTo(1));
  }
}