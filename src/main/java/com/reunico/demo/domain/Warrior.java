package com.reunico.demo.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Warrior implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonAlias("name.findName")
    private String name;
    @JsonAlias("name.title")
    private String title;
    private Boolean isAlive;
    @JsonAlias("random.number")
    private Integer hp;

    public Warrior() {
    }

    public Warrior(String name, String title, Boolean isAlive, Integer hp) {
        this.name = name;
        this.title = title;
        this.isAlive = isAlive;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getAlive() {
        return isAlive;
    }

    public void setAlive(Boolean alive) {
        isAlive = alive;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }
}
