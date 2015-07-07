package org.tekCorp.api.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.tekCorp.api.domain.Computer;
import org.tekCorp.api.domain.Project;
import org.tekCorp.api.domain.User;
import org.tekCorp.api.domain.projectuser.ProjectUser;
import org.tekCorp.api.repository.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inspiron on 06/07/2015.
 */
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    protected UserRepository userRepository;
    @Autowired
    protected StatisticRepository statisticRepository;
    @Autowired
    protected ProjectUserRepository projectUserRepository;
    @Autowired
    protected ProjectRepository projectRepository;
    @Autowired
    protected ComputerRepository computerRepository;

    @RequestMapping(value = "/list")
    public List<User> listUser(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/{id}/list/project")
    public List<Project> listProject(@PathVariable("id") Integer id){
        List<ProjectUser> list = projectUserRepository.findByIdUserId(id);
        List<Integer> listIdProject = new ArrayList<>();
        for (ProjectUser projectUser : list){
            listIdProject.add(projectUser.getId().getProjectId());
        }

        return projectRepository.findByIdProjectIn(listIdProject) ;
    }

    @RequestMapping(value = "/{id}/list/computer")
    public List<Computer> listComputer(@PathVariable("id") Integer id){
        return computerRepository.findByIdUser(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @RequestMapping(value = "/view/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userRepository.findOne(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public User updateUser(@RequestBody User user){
        return userRepository.save(user);
    }
}