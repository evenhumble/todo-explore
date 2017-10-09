package io.hedwig.todo.mock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 1. author: patrick
 * 2. address: github.com/ideafortester
 */

@SpringBootApplication
@EnableSwagger2
public class ToDoMockApplication {

  public static void main(String[] args) {
    SpringApplication.run(ToDoMockApplication.class,args);
  }
}
