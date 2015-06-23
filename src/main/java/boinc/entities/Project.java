package boinc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by shouwy on 23/06/2015.
 */
@Entity
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String projecId;
    private String name;


    public Project() {}

    public Project(String name) {
        this.name = name;
    }
    public Project(String projectId, String name){
        this.projecId = projectId;
        this.name = name;
    }

    public String getProjecId() {
        return projecId;
    }

    public void setProjecId(String projecId) {
        this.projecId = projecId;
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
        if (!(o instanceof Project)) return false;

        Project project = (Project) o;

        return getProjecId().equals(project.getProjecId());

    }

    @Override
    public int hashCode() {
        return getProjecId().hashCode();
    }
}
