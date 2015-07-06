package org.tekCorp.api.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tekCorp.api.domain.Project;
import org.tekCorp.api.domain.statistic.Statistic;
import org.tekCorp.api.repository.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Inspiron on 06/07/2015.
 */
@RestController
@RequestMapping(value="/stat", produces = MediaType.APPLICATION_JSON_VALUE)
public class StatisticController {

    @Autowired
    protected ProjectRepository projectRepository;
    @Autowired
    protected StatisticRepository statisticRepository;
    @Autowired
    protected ProjectUserRepository projectUserRepository;
    @Autowired
    protected ProjectComputerRepository projectComputerRepository;
    @Autowired
    protected UserRepository userRepository;

    @RequestMapping(value = "/project/")
    public HashMap<Project, ArrayList<Statistic>> getAllProjectStat(){
        ArrayList<Project> listProject = (ArrayList<Project>) projectRepository.findAll();
        ArrayList<Statistic> listStat = (ArrayList<Statistic>) statisticRepository.findAll();

        HashMap<Project, ArrayList<Statistic>> mapStat = new HashMap<>();
        for (Statistic statistic : listStat){
            Project project = new Project();
            project.setIdProject(statistic.getId().getProjectId());

            project = listProject.get(listProject.indexOf(project));
            if (!mapStat.containsKey(project)){
                mapStat.put(project, new ArrayList<Statistic>());
            }

            mapStat.get(project).add(statistic);
        }

        return mapStat;
    }

    @RequestMapping(value = "/project/{id}")
    public List<Statistic> getStatProject(@PathVariable("id") Integer id){
        return statisticRepository.findByIdProjectId(id);
    }
}
