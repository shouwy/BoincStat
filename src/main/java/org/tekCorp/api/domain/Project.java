package org.tekCorp.api.domain;

import javax.persistence.*;

/**
 * Created by Inspiron on 15/06/2015.
 */

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProject;

    private String name;
    private String status;
    private Boolean archived;

    public Project(){}
    public Project(String name, String status, Boolean archived){
        this.name=name;
        this.status=status;
        this.archived=archived;
    }

    @Override
    public String toString(){
        return String.format("Project[id=%d, name='%s', status='%s', archived='%s']", idProject, name, status, archived);
    }

    public Integer getIdProject() {
        return idProject;
    }

    public void setIdProject(Integer idProject) {
        this.idProject = idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;

        Project project = (Project) o;

        return getIdProject().equals(project.getIdProject());

    }

    @Override
    public int hashCode() {
        return getIdProject().hashCode();
    }
}
