package org.tekCorp.api.domain.projectcomputer;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Created by Inspiron on 16/06/2015.
 */
@Entity
public class ProjectComputer {

    @EmbeddedId
    private ProjectComputerKey id;

    protected ProjectComputer(){}

    @Override
    public String toString() {
        return String.format("ProjectComputer[ProjectId=%d, ComputerId=%d", id.getProjectId(), id.getComputerId());
    }

    public ProjectComputerKey getId() {
        return id;
    }

    public void setId(ProjectComputerKey id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectComputer)) return false;

        ProjectComputer that = (ProjectComputer) o;

        return !(id != null ? !id.equals(that.id) : that.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
