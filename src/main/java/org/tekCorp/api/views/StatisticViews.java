package org.tekCorp.api.views;

import org.tekCorp.api.Util.DateUtil;
import org.tekCorp.api.domain.Computer;
import org.tekCorp.api.domain.Project;
import org.tekCorp.api.domain.User;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Inspiron on 09/07/2015.
 */
public class StatisticViews {
    private Project project;
    private Computer computer;
    private User user;
    private Calendar date;
    private Integer value;

    public StatisticViews() {}
    public StatisticViews(Project project, Computer computer, User user, Calendar date, Integer value) {
        this.project = project;
        this.computer = computer;
        this.user = user;
        this.date = date;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Statistic["+
                "project=" + project.toString() +
                ", computer=" + computer.toString() +
                ", user=" + user.toString() +
                ", date=" + DateUtil.getDateInString((GregorianCalendar) date) +
                ", value=" + value.toString() + ']';
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}