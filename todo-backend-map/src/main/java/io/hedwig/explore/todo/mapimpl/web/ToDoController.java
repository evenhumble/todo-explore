package io.hedwig.explore.todo.mapimpl.web;

import io.hedwig.explore.todo.entities.ToDo;
import io.hedwig.explore.todo.service.ToDoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by patrick on 2017/7/3.
 */
@Controller
public class ToDoController {

    private static Logger logger = LoggerFactory.getLogger(ToDoController.class);
    @Autowired
    private ToDoService toDoService;

    @RequestMapping(value = "/todos",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public  Collection<ToDo> getAll(){
        // TODO: 2017/7/3 add aop logging
        logger.info("start get all todo items");
        return toDoService.getAllToDoes();
    }

    @RequestMapping(value = "/todos/{todoId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ToDo getById(@PathVariable(value = "todoId") long todoId){
        logger.info("get todo by id={}",todoId);
       return toDoService.getToDoById(todoId);
    }

    @RequestMapping(value = "/todos",method = RequestMethod.POST,
                produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
                consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ToDo create(@RequestBody ToDo toDo){
        logger.info("create todo item");
        return toDoService.addToDo(toDo);
    }

    @RequestMapping(value = "/todos/{todoId}",method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ToDo update(@PathVariable long todoId,@RequestBody ToDo toDo){
        logger.info("update todo item");
        toDo.setId(todoId);
        return toDoService.updateToDo(toDo);
    }

}
