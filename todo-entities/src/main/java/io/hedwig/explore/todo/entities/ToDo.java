package io.hedwig.explore.todo.entities;


/**
 * Created by patrick on 2017/6/30.
 */
public class ToDo {

    private long id ;
    private String title;
    private Boolean completed;
    private Integer order;
  /**
   * 0: hiden
   * 1: active
   * 2: deleted
   */
  private int status=1;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }
}
