package org.tekCorp.api.domain.projectcomputer;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Inspiron on 16/06/2015.
 */
@Embeddable
public class ProjectComputerKey implements Serializable{

    @Column(nullable = false)
    private Integer projectId;
    @Column(nullable = false)
    private Integer computerId;

    protected ProjectComputerKey(){}
    public ProjectComputerKey(Integer projectId, Integer computerId) {
        this.projectId = projectId;
        this.computerId = computerId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getComputerId() {
        return computerId;
    }

    public void setComputerId(Integer computerId) {
        this.computerId = computerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectComputerKey)) return false;

        ProjectComputerKey that = (ProjectComputerKey) o;

        if (!projectId.equals(that.projectId)) return false;
        return computerId.equals(that.computerId);

    }

    @Override
    public int hashCode() {
        int result = projectId.hashCode();
        result = 31 * result + computerId.hashCode();
        return result;
    }
}
