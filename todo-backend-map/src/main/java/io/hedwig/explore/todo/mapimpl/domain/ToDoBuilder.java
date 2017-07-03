package io.hedwig.explore.todo.mapimpl.domain;

import io.hedwig.explore.todo.entities.ToDo;
import io.hedwig.explore.todo.mapimpl.domain.service.ToDoIDGenerator;

/**
 * Created by patrick on 2017/7/3.
 */
public class ToDoBuilder {

    private transient ToDo todo ;

    public static ToDoBuilder builder(){
        final ToDoBuilder builder = new ToDoBuilder();
        builder.todo=new ToDo();
        builder.todo.setId(ToDoIDGenerator.getId());
        return builder;
    }
    public ToDoBuilder complete(final boolean completed){
        todo.setCompleted(completed);
        return this;
    }

    public ToDoBuilder title(final String title){
        todo.setTitle(title);
        return this;
    }

    public ToDoBuilder order(final int order){
        todo.setOrder(order);
        return this;
    }

    public ToDo build(){
        return this.todo;
    }
}
