package io.hedwig.explore.todo.entities;


/**
 * Created by patrick on 2017/6/30.
 */
public class ToDo {

    private long id ;
    private String title;
    private Boolean completed;
    private Integer order;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToDo toDo = (ToDo) o;

        if (id != toDo.id) return false;
        if (title != null ? !title.equals(toDo.title) : toDo.title != null) return false;
        if (completed != null ? !completed.equals(toDo.completed) : toDo.completed != null) return false;
        return order != null ? order.equals(toDo.order) : toDo.order == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (completed != null ? completed.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        return result;
    }
}
