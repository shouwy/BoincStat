package org.tekCorp.api.domain;

import javax.persistence.*;

/**
 * Created by Inspiron on 15/06/2015.
 */
@Entity
public class User {

    @Id
    private String boincId;
    private String name;

    public User() {}
    public User(String boincId, String name) {
        this.boincId = boincId;
        this.name = name;
    }

    public String getBoincId() {
        return boincId;
    }

    public void setBoincId(String boincId) {
        this.boincId = boincId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return boincId.equals(user.boincId);

    }

    @Override
    public int hashCode() {
        return boincId.hashCode();
    }
}
