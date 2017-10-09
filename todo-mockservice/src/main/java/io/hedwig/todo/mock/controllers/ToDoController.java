package io.hedwig.todo.mock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

import io.hedwig.explore.todo.entities.ToDo;
import io.hedwig.explore.todo.service.ToDoService;

import static io.hedwig.todo.mock.dtos.RRBuilder.*;

import io.hedwig.todo.mock.dtos.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

/**
 * 1. author: patrick
 * 2. address: github.com/ideafortester
 */

@Controller
@Api(tags = {"todo_relative"},value = "todo"
,authorizations={
    @Authorization(value = "no-auth",scopes = {})
})
public class ToDoController {

  @Autowired
  ToDoService mockService;

  @ApiOperation(
      value = "Find All ToDos",
      notes ="find all to dos",
      response = ResponseResult.class
  )

  @RequestMapping(value ="/todo",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody ResponseEntity<ResponseResult> getAllToDos() {
    Collection<ToDo> result = mockService.getAllToDoes();
    return ResponseEntity.ok(successResult(result));
  }

  @ApiOperation(
      value = "Find one todo by todo Id",
      notes ="Find one todo by todo Id",
      response = ResponseResult.class
  )
  @ApiResponses(value={
      @ApiResponse(code = 400, message = "Invalid ID NOt found")
  })
  @RequestMapping(value = "/todo/{id}",
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody
  ResponseEntity<ResponseResult> getToDo(
      @ApiParam(value = "todo Id to be updated", required = true)
      @PathVariable int id) {
    ToDo result = mockService.getToDoById(id);
    return ResponseEntity.ok(successResult(result));
  }

  @RequestMapping(value ="/todo",method = RequestMethod.POST,
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ApiOperation(
      value = "Add ToDo Item",
      notes ="Add ToDo Item",
      response = ResponseResult.class
  )
  public @ResponseBody ResponseEntity<ResponseResult> addToDo(
      @ApiParam(value = "to be added todo object", required = true)
      @RequestBody ToDo toDo) {
    ToDo addedTodo = mockService.addToDo(toDo);
    return ResponseEntity.ok(successResult(addedTodo));
  }


  @RequestMapping(value ="/todo",method = RequestMethod.DELETE,
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ApiOperation(
      value = "Delete ToDo Item",
      notes ="Delete ToDo Item",
      response = ResponseResult.class
  )
  public @ResponseBody ResponseEntity<ResponseResult> deleteDo(
      @ApiParam(value = "Updated To Do object", required = true)
      @RequestBody ToDo toDo) {
    ToDo deletedToDo = mockService.deleteToDo(toDo);
    return ResponseEntity.ok(successResult(deletedToDo));
  }

  @RequestMapping(value = "/todo/{id}", method = RequestMethod.PUT,
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ApiOperation(
      value = "Update ToDo Item",
      notes ="Update ToDo Item",
      response = ResponseResult.class
  )
  public @ResponseBody ResponseEntity<ResponseResult> updateTodo(
      @ApiParam(value = "todo Id to be updated", required = true)
      @PathVariable(value = "id") int id,
      @ApiParam(value = "Updated To Do object", required = true)
      @RequestBody ToDo toDo) {
    toDo.setId(id);
    ToDo updatedToDo = mockService.updateToDo(toDo);
    return ResponseEntity.ok(successResult(updatedToDo));
  }


}
