package io.hedwig.todo.mock.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

/**
 * 1. author: patrick 2. address: github.com/ideafortester
 */

@Data
public class ResponseMsg {
  private String statusCode;
  private String msg;


}
