package io.hedwig.todo.mock.dtos;



import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;

/**
 * 1. author: patrick 2. address: github.com/ideafortester
 */
public class RRBuilderTest {

  @Test
  public void test_GetResponseResult() throws Exception {
    ResponseResult rr = RRBuilder.successResult(Lists.emptyList());
    Assert.assertNotNull(rr);
  }

}