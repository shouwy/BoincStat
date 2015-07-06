package org.tekCorp.api.domain;

import javax.persistence.*;

/**
 * Created by Inspiron on 15/06/2015.
 */
@Entity

public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idComputer;

    private Integer idUser;
    private String name;

    protected Computer(){}
    public Computer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Computer[computerId=%d, idUser=%d, Name=%s]", getIdComputer(), getIdUser(), getName());
    }

    public Integer getIdComputer() {
        return idComputer;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public void setIdComputer(Integer idComputer) {
        this.idComputer = idComputer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Computer)) return false;

        Computer computer = (Computer) o;

        return getIdComputer().equals(computer.getIdComputer());

    }

    @Override
    public int hashCode() {
        return getIdComputer().hashCode();
    }
}
