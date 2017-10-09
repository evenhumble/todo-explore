package io.hedwig.todo.mock.dtos;


import org.junit.Assert;
import org.junit.Test;

/**
 * 1. author: patrick 2. address: github.com/ideafortester
 */
public class RMBuilderTest {

  @Test
  public void test_initBuilder() throws Exception {
    RMBuilder builder = RMBuilder.init();
    Assert.assertNotNull(builder);
  }

  @Test
  public void test_buildResponseMsg() throws Exception {

    ResponseMsg msg = RMBuilder.init().message("this is test").statusCode("100").build();
    Assert.assertEquals(msg.getMsg(),"this is test");
    Assert.assertEquals(msg.getStatusCode(),"100");
  }

}