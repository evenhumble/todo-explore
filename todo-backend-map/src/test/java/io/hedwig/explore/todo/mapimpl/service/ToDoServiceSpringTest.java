package io.hedwig.explore.todo.mapimpl.service;

import io.hedwig.explore.todo.entities.ToDo;
import io.hedwig.explore.todo.mapimpl.AbstractToDoIntegrationTest;
import io.hedwig.explore.todo.service.ToDoService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by patrick on 2017/7/3.
 */
public class ToDoServiceSpringTest extends AbstractToDoIntegrationTest{

    @Autowired
    private ToDoService toDoService;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testGetById(){
        Assert.assertNull(toDoService.getToDoById(100L));
    }

    @Test
    public void testAddToDo(){
       ToDo toDo= toDoService.addToDo(new ToDo());
       Assert.assertThat(toDo.getTitle(),equalTo("MockToDo"));
    }
    @Test
    public void testBeanType(){
        Map<String,ToDoService> toDoServiceMapping = this.applicationContext.getBeansOfType(ToDoService.class);
        for (Map.Entry<String, ToDoService> entry : toDoServiceMapping.entrySet()) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
        Assert.assertThat(this.applicationContext.getBeansOfType(ToDoService.class).size(),equalTo(2));
    }
}
