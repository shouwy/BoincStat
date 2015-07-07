package org.tekCorp.api.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.tekCorp.api.domain.Computer;
import org.tekCorp.api.domain.Project;
import org.tekCorp.api.domain.projectcomputer.ProjectComputer;
import org.tekCorp.api.repository.ComputerRepository;
import org.tekCorp.api.repository.ProjectComputerRepository;
import org.tekCorp.api.repository.ProjectRepository;
import org.tekCorp.api.repository.StatisticRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shouwy on 03/07/2015.
 */
@RestController
@RequestMapping(value="/computer", produces = MediaType.APPLICATION_JSON_VALUE)
public class ComputerController {

    @Autowired
    ComputerRepository computerRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ProjectComputerRepository projectComputerRepository;
    @Autowired
    StatisticRepository statisticRepository;

    @RequestMapping(value = "/list")
    public List<Computer> listComputer(){
        return computerRepository.findAll();
    }

    @RequestMapping(value = "{id}/list/project/")
    public List<Project> listProjectComputer(@PathVariable("id") Integer id){
        List<ProjectComputer> list = projectComputerRepository.findByIdComputerId(id);
        List<Integer> listIdProject = new ArrayList<>();
        for (ProjectComputer projectComputer : list){
            listIdProject.add(projectComputer.getId().getProjectId());
        }
        return projectRepository.findByIdProjectIn(listIdProject);
    }

    @RequestMapping(value  = "/create", method = RequestMethod.POST)
    public Computer createComputer(@RequestBody Computer computer){
        return computerRepository.save(computer);
    }

    @RequestMapping(value = "/delete/{id}")
    public List<Computer> deleteComputer(@PathVariable("id") Integer id){
        computerRepository.delete(id);
        return computerRepository.findAll();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Computer updateComputer(@RequestBody Computer computer){
        return  computerRepository.save(computer);
    }
}
