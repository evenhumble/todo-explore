package io.hedwig.explore.todo.mapimpl.mock;

import io.hedwig.explore.todo.entities.ToDo;
import io.hedwig.explore.todo.mapimpl.domain.ToDoBuilder;
import io.hedwig.explore.todo.service.ToDoService;
import org.assertj.core.util.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

/**
 * Created by patrick on 2017/7/3.
 */
@Configuration
//@Profile("dev")
public class MockToDoService {

    @Primary
    @Bean
    public ToDoService toDoService(){
        ToDoService service = mock(ToDoService.class);
        given(service.addToDo(new ToDo())).willReturn(
                ToDoBuilder.builder().complete(true)
                .order(1).title("MockToDo").build()
        );
        List<ToDo> toDoList = Lists.newArrayList();
        toDoList.add(ToDoBuilder.builder().complete(false).title("mockAllToDo")
        .order(100).id(100L).build());
        given(service.getAllToDoes()).willReturn(
            toDoList
        );
        given(service.updateToDo(new ToDo())).willReturn(
                ToDoBuilder.builder().complete(false).title("updateToDo")
                        .order(1000).id(1000L).build()
        );
        given(service.deleteToDo(new ToDo())).willReturn(
                ToDoBuilder.builder().complete(false).title("deleteToDo")
                        .order(10000).id(10000L).build()
        );

        given(service.getToDoById(1L)).willReturn(
                ToDoBuilder.builder().complete(false).title("getToDoById")
                        .order(10000).id(1L).build()
        );
        return service;
    }
}
