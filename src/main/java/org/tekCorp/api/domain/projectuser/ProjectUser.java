package org.tekCorp.api.domain.projectuser;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Created by Inspiron on 16/06/2015.
 */
@Entity
public class ProjectUser {

    @EmbeddedId
    private ProjectUserKey id;
    protected ProjectUser(){}
    public ProjectUser(ProjectUserKey id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("ProjectUser[ProjectId=%d, UserId=%d", id.getProjectId(), id.getUserId());
    }

    public ProjectUserKey getId() {
        return id;
    }

    public void setId(ProjectUserKey id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectUser)) return false;

        ProjectUser that = (ProjectUser) o;

        return getId().equals(that.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
