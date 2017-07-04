package io.hedwig.explore.todo.mapimpl.service;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by patrick on 2017/7/3.
 */
public final class ToDoIDGenerator {

    private static AtomicLong todoId = new AtomicLong();

    private ToDoIDGenerator() {
    }

    public static Long getId(){
        return todoId.incrementAndGet();
    }

}
