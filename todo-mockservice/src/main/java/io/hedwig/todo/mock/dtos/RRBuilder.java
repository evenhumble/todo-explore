package io.hedwig.todo.mock.dtos;

/**
 * 1. author: patrick
 * 2. address: github.com/ideafortester
 *
 * ResponseMsg Builder to build default response status message
 */
public class RRBuilder {

  public static ResponseResult successResult(Object data) {

    ResponseResult rr = new ResponseResult();
    // TODO: 2017/10/9 Conversion Service Here
    rr.setData(data);
    rr.setStatus(RMBuilder.init().
        statusCode("200").
        message("success").build());
    return rr;
  }
}
