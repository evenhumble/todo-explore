package io.hedwig.todo.mock.dtos;

/**
 * 1. author: patrick
 * 2. address: github.com/ideafortester
 *
 * ResponseMsg Builder to build default response status message
 */
public class RMBuilder {

  private ResponseMsg rMsg = new ResponseMsg();

  public static RMBuilder init(){
    RMBuilder rmBuilder = new RMBuilder();
    return rmBuilder;
  }

  public RMBuilder statusCode(String statusCode){
    this.rMsg.setStatusCode(statusCode);
    return this;
  }

  public RMBuilder message(String message){
    this.rMsg.setMsg(message);
    return this;
  }

  public ResponseMsg build(){
    return this.rMsg;
  }
}
