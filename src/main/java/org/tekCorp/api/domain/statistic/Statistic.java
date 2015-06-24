package org.tekCorp.api.domain.statistic;

import org.tekCorp.api.Util.DateUtil;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.GregorianCalendar;

/**
 * Created by Inspiron on 15/06/2015.
 */
@Entity
public class Statistic {

    @EmbeddedId
    private StatisticKey id;

    private Integer value;

    protected Statistic(){}

    public Statistic(StatisticKey id, Integer value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("Statistic[projectId=%d, computerId=%d, date='%s', value=%d", id.getProjectId(), id.getComputerId(), DateUtil.getDateInString((GregorianCalendar) id.getDate()), value);
    }

    public StatisticKey getId() {
        return id;
    }

    public void setId(StatisticKey id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Statistic)) return false;

        Statistic statistic = (Statistic) o;

        return id.equals(statistic.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
