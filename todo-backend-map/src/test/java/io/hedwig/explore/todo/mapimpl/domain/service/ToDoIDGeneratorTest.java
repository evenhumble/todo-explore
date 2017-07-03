package io.hedwig.explore.todo.mapimpl.domain.service;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by patrick on 2017/7/3.
 */
public class ToDoIDGeneratorTest {
    @Test
    public void testGetId() throws Exception {

        Assert.assertEquals(ToDoIDGenerator.getId()-ToDoIDGenerator.getId(),-1L);
    }

}