package org.tekCorp.api.domain.projectuser;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Inspiron on 16/06/2015.
 */
@Embeddable
public class ProjectUserKey implements Serializable {

    @Column(nullable = false)
    private Integer projectId;
    @Column(nullable = false)
    private Integer userId;

    protected ProjectUserKey(){}
    public ProjectUserKey(Integer projectId, Integer userId) {
        this.projectId = projectId;
        this.userId = userId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectUserKey)) return false;

        ProjectUserKey that = (ProjectUserKey) o;

        if (projectId != null ? !projectId.equals(that.projectId) : that.projectId != null) return false;
        return !(userId != null ? !userId.equals(that.userId) : that.userId != null);

    }

    @Override
    public int hashCode() {
        int result = projectId != null ? projectId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
