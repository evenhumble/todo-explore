package io.hedwig.explore.todo.mapimpl.service;

import io.hedwig.explore.todo.entities.ToDo;
import io.hedwig.explore.todo.mapimpl.domain.ToDoBuilder;
import io.hedwig.explore.todo.mapimpl.service.ToDoServiceMapImpl;
import org.junit.Assert;
import org.junit.BeforeClass;


/**
 * Created by patrick on 2017/7/3.
 */
public class ToDoServiceMapImplTest {

    private static ToDoServiceMapImpl service = new ToDoServiceMapImpl();

    @BeforeClass
    public static void setUpToDoes(){
        for (int i = 0; i < 10; i++) {
            ToDo toDo = ToDoBuilder.builder()
                    .complete(false)
                    .title("this is test todo"+i)
                    .order(1).build();
            service.todos.put(toDo.getId(),toDo);
        }
    }


    @org.junit.Test
    //todo: junit test order ?
    public void getAllToDoes() throws Exception {
        Assert.assertEquals(service.getAllToDoes().size(),11);
    }

    @org.junit.Test
    public void getToDoById() throws Exception {
        ToDo toDo = ToDoBuilder.builder()
                .complete(false)
                .title("this is test todo")
                .order(1).build();
        service.todos.put(toDo.getId(),toDo);
        Assert.assertEquals(service.getToDoById(toDo.getId()),toDo);
    }

    @org.junit.Test
    public void addToDo() throws Exception {

        ToDo toDo = ToDoBuilder.builder()
                .complete(false)
                .title("Test Add ToDo")
                .order(1).build();
        service.addToDo(toDo);
        Assert.assertEquals(service.getToDoById(toDo.getId()),toDo);
    }

    @org.junit.Test
    public void deleteToDo() throws Exception {
        ToDo toDo = ToDoBuilder.builder()
                .complete(false)
                .title("Test Remove ToDo")
                .order(1).build();
        toDo.setId(10000L);
        service.addToDo(toDo);
        service.deleteToDo(toDo);
        Assert.assertNull(service.getToDoById(1000L));
    }

    @org.junit.Test
    public void updateToDo() throws Exception {
        ToDo toDo = ToDoBuilder.builder()
                .complete(false)
                .title("Test Update ToDo")
                .order(1).build();
        service.addToDo(toDo);
        toDo.setCompleted(true);
        toDo.setTitle("Updated To DO");
        service.updateToDo(toDo);

        Assert.assertEquals(service.getToDoById(toDo.getId()),toDo);
    }


}