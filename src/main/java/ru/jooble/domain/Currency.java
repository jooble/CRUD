package ru.jooble.domain;


public class Currency {
    private long id;
    private String name;


    public Currency(long id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Currency{ " +
                " id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
