package org.tekCorp.api.Util;

import org.tekCorp.api.domain.Computer;
import org.tekCorp.api.domain.Project;
import org.tekCorp.api.domain.User;
import org.tekCorp.api.views.StatisticViews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Inspiron on 09/07/2015.
 */
public class StatUtil {

    public static ArrayList<StatisticViews> sumByProject(List<StatisticViews> statisticViewsList){
        HashMap<Project, ArrayList<StatisticViews>> mapStatByProject = new HashMap<>();
        for (StatisticViews statisticViews : statisticViewsList){
            if (!mapStatByProject.containsKey(statisticViews.getProject())){
                mapStatByProject.put(statisticViews.getProject(), new ArrayList<StatisticViews>());
            }
            mapStatByProject.get(statisticViews.getProject()).add(statisticViews);
        }

        ArrayList<StatisticViews> list = new ArrayList<>();
        for (Project project : mapStatByProject.keySet()){
            StatisticViews statisticViews = new StatisticViews();
            statisticViews.setProject(project);
            statisticViews.setValue(0);

            for (StatisticViews view : mapStatByProject.get(project)){
                addValue(statisticViews, view);
            }
            list.add(statisticViews);
        }

        return list;
    }

    public static ArrayList<StatisticViews> sumByComputer(List<StatisticViews> statisticViewsList){
        HashMap<Computer, ArrayList<StatisticViews>> mapStatByProject = new HashMap<>();
        for (StatisticViews statisticViews : statisticViewsList){
            if (!mapStatByProject.containsKey(statisticViews.getComputer())){
                mapStatByProject.put(statisticViews.getComputer(), new ArrayList<StatisticViews>());
            }
            mapStatByProject.get(statisticViews.getProject()).add(statisticViews);
        }

        ArrayList<StatisticViews> list = new ArrayList<>();
        for (Computer computer : mapStatByProject.keySet()){
            StatisticViews statisticViews = new StatisticViews();
            statisticViews.setComputer(computer);
            statisticViews.setValue(0);

            for (StatisticViews view : mapStatByProject.get(computer)){
                addValue(statisticViews, view);
            }
            list.add(statisticViews);
        }

        return list;
    }

    public static ArrayList<StatisticViews> sumByUser(List<StatisticViews> statisticViewsList){
        HashMap<User, ArrayList<StatisticViews>> mapStatByProject = new HashMap<>();
        for (StatisticViews statisticViews : statisticViewsList){
            if (!mapStatByProject.containsKey(statisticViews.getUser())){
                mapStatByProject.put(statisticViews.getUser(), new ArrayList<StatisticViews>());
            }
            mapStatByProject.get(statisticViews.getUser()).add(statisticViews);
        }

        ArrayList<StatisticViews> list = new ArrayList<>();
        for (User user : mapStatByProject.keySet()){
            StatisticViews statisticViews = new StatisticViews();
            statisticViews.setUser(user);
            statisticViews.setValue(0);

            for (StatisticViews view : mapStatByProject.get(user)){
                addValue(statisticViews, view);
            }
            list.add(statisticViews);
        }

        return list;
    }

    public static StatisticViews bestProject(List<StatisticViews> statisticViewsList){
        List<StatisticViews> list = sumByProject(statisticViewsList);
        return best(list);
    }

    public static StatisticViews bestComputer(List<StatisticViews> statisticViewsList) {
        List<StatisticViews> list = sumByComputer(statisticViewsList);
        return best(list);
    }

    public static StatisticViews bestUser(List<StatisticViews> statisticViewsList){
        List<StatisticViews> list = sumByUser(statisticViewsList);
        return best(list);
    }

    private static StatisticViews best(List<StatisticViews> list){
        StatisticViews statisticViews = new StatisticViews();
        if (list != null && list.size() > 0) {
            statisticViews = list.get(0);
            for (StatisticViews tmp : list) {
                if (tmp.getValue() > statisticViews.getValue()){
                    statisticViews = tmp;
                }
            }
        }
        return statisticViews;
    }

    private static void addValue(StatisticViews statisticViews, StatisticViews view) {
        statisticViews.setValue(statisticViews.getValue() + view.getValue());
    }
}
