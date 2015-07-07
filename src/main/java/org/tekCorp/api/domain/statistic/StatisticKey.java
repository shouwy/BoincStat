package org.tekCorp.api.domain.statistic;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by Inspiron on 16/06/2015.
 */
@Embeddable
public class StatisticKey implements Serializable{

    @Column(nullable = false)
    private Integer projectId;
    @Column(nullable = false)
    private Integer computerId;
    @Column(nullable = false)
    private Calendar date;

    protected StatisticKey(){}
    public StatisticKey(Integer projectId, Integer computerId, Calendar date) {
        this.projectId = projectId;
        this.computerId = computerId;
        this.date = date;
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

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatisticKey)) return false;

        StatisticKey that = (StatisticKey) o;

        if (!getProjectId().equals(that.getProjectId())) return false;
        if (!getComputerId().equals(that.getComputerId())) return false;
        return getDate().equals(that.getDate());

    }

    @Override
    public int hashCode() {
        int result = getProjectId().hashCode();
        result = 31 * result + getComputerId().hashCode();
        result = 31 * result + getDate().hashCode();
        return result;
    }
}
