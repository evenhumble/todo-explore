package io.hedwig.explore.todo.mapimpl.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.hedwig.explore.todo.entities.ToDo;
import io.hedwig.explore.todo.mapimpl.AbstractToDoIntegrationTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Created by patrick on 2017/7/3.
 */
public class ToDoControllerTest extends AbstractToDoIntegrationTest {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void getAll() throws Exception {

       mockMvc.perform(MockMvcRequestBuilders.get("/todos"))
                .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
               .andExpect(jsonPath("$.[0].title").value("mockAllToDo"));
    }

    @Test
    public void getById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/todos/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.title").value("getToDoById"));
    }

    @Test
    public void create() throws Exception {


        ObjectMapper mapper = new ObjectMapper();
        String todoString = mapper.writeValueAsString(new ToDo());
       MvcResult result = mockMvc.
               perform(MockMvcRequestBuilders.post("/todos", todoString))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andReturn();

//                .andExpect(jsonPath("title").value("MockToDo"));
        System.out.println(result.getResponse().toString());
    }

    @Test
    public void update() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/todos/1",new ToDo()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
//                .andExpect(jsonPath("title").value("updateToDo"));
    }

}