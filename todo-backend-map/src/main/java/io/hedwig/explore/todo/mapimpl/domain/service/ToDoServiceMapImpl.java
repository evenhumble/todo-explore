package io.hedwig.explore.todo.mapimpl.domain.service;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import io.hedwig.explore.todo.entities.ToDo;
import io.hedwig.explore.todo.service.ToDoService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

/**
 * Created by patrick on 2017/6/30.
 */
@Service
public class ToDoServiceMapImpl implements ToDoService {

    protected Map<Long,ToDo> todos = Maps.newConcurrentMap();


    public Collection<ToDo> getAllToDoes() {

        return todos.values();
    }

    public ToDo getToDoById(long id) {

        return todos.get(id);
    }

    public ToDo addToDo(ToDo toDo) {
        toDo.setId(ToDoIDGenerator.getId());
        todos.put(toDo.getId(),toDo);
        return toDo;
    }

    public ToDo deleteToDo(ToDo toDo) {

        Preconditions.checkNotNull(toDo.getId(),"Please make sure the todo item is a valid todo");
        return todos.remove(toDo.getId());
    }

    public ToDo updateToDo(ToDo toDo) {
        Preconditions.checkNotNull(toDo.getId(),"Please make sure the todo item is a valid todo");
        final ToDo origin = todos.get(toDo.getId());
        if(origin==null) {
            throw  new RuntimeException("Invalid todo item, Not Found");
        }
        origin.setCompleted(toDo.getCompleted());
        origin.setOrder(toDo.getOrder());
        origin.setTitle(toDo.getTitle());
        return origin;
    }
}
