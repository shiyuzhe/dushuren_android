package com.hulai.dushuren.mvp.model.bean;

/**
 * 作者:shiyuzhe on 2018/6/29 12:19
 * 邮箱:18091664559@163.com
 * Desc:
 */
public class Teacher {
    private String id;
    private String name;

    public Teacher() {

    }

    public Teacher(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id == null ? "" : id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + getName() + '\'' +
                ", id='" + getId() + '\'' +
                '}';
    }
}
