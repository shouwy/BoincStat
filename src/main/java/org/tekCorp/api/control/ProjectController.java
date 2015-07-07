package org.tekCorp.api.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.tekCorp.api.domain.Project;
import org.tekCorp.api.domain.User;
import org.tekCorp.api.domain.projectcomputer.ProjectComputer;
import org.tekCorp.api.domain.projectuser.ProjectUser;
import org.tekCorp.api.repository.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inspiron on 15/06/2015.
 */
@RestController
@RequestMapping(value="/project", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectController {

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
    @Autowired
    protected ComputerRepository computerRepository;

    @RequestMapping(value = "/list")
    public List<Project> listProject(){
        return projectRepository.findAll();
    }

    @RequestMapping(value = "/{id}/list/user")
    public List<User> listProjectUser(@PathVariable("id") Integer id){
        List<ProjectUser> list = projectUserRepository.findByIdProjectId(id);
        List<Integer> listIdUser = new ArrayList<>();
        for (ProjectUser projectUser : list){
            listIdUser.add(projectUser.getId().getUserId());
        }

        return userRepository.findByIdUserIn(listIdUser) ;
    }

    @RequestMapping(value = "/list/computer/{id}")
    public List<Project> listComputerProject(@PathVariable("id") Integer id){
        List<ProjectComputer> list = projectComputerRepository.findByIdComputerId(id);
        List<Integer> listIdProject = new ArrayList<>();
        for (ProjectComputer projectComputer : list){
            listIdProject.add(projectComputer.getId().getProjectId());
        }

        return projectRepository.findByIdProjectIn(listIdProject) ;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Project createProject(@RequestBody Project project){
        return projectRepository.save(project);
    }

    @RequestMapping(value = "/delete/{id}")
    public List<Project> deleteProject(@PathVariable("id") Integer id){
        projectRepository.delete(id);
        return projectRepository.findAll();
    }

    @RequestMapping(value = "/view/{id}")
    public Project getProject(@PathVariable("id") Integer id){
        return projectRepository.findOne(id);
    }

    @RequestMapping(value = "/update/", method = RequestMethod.POST)
    public Project updateProject(@RequestBody Project project){
        return projectRepository.save(project);
    }
}
