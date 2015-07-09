package org.tekCorp.api.domain;

import javax.persistence.*;

/**
 * Created by Inspiron on 15/06/2015.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    private String boincId;
    private String name;

    public User() {}
    public User(String boincId, String name) {
        this.boincId = boincId;
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format("User[id=%d, BoincId='%s', name='%s']", getIdUser(), getBoincId(), getName());
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getBoincId() {
        return boincId;
    }

    public void setBoincId(String boincId) {
        this.boincId = boincId;
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
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return getIdUser().equals(user.getIdUser());
    }

    @Override
    public int hashCode() {
        return getIdUser().hashCode();
    }
}
