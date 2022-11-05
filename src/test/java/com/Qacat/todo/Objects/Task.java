package com.Qacat.todo.Objects;

public class Task {

    // two items which send when creating a new todo
    private String item;
    private boolean isCompleted;

    public Task(String item, boolean isCompleted) {
        this.item = item;
        this.isCompleted = isCompleted;
    }


    public void setItem(String item) {
        this.item = item;
    }

    public void setIsCompleted(boolean isCompleted) {
        isCompleted = isCompleted;
    }

    public String getItem() {
        return item;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }
}
