package org.tekCorp.api.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.tekCorp.api.domain.Computer;
import org.tekCorp.api.domain.projectcomputer.ProjectComputer;
import org.tekCorp.api.domain.statistic.Statistic;
import org.tekCorp.api.repository.ComputerRepositoy;
import org.tekCorp.api.repository.ProjectComputerRepository;
import org.tekCorp.api.repository.StatisticRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shouwy on 03/07/2015.
 */
@RestController
@RequestMapping(value="/computer", produces = MediaType.APPLICATION_JSON_VALUE)
public class ComputerController {

    @Autowired
    ComputerRepositoy computerRepositoy;
    @Autowired
    ProjectComputerRepository projectComputerRepository;
    @Autowired
    StatisticRepository statisticRepository;

    @RequestMapping(value = "/list")
    public List<Computer> listComputer(){
        return computerRepositoy.findAll();
    }

    @RequestMapping(value = "/list/user/{id}")
    public List<Computer> listUserComputer(@PathVariable("id") Integer id){
        return computerRepositoy.findByIdUser(id);
    }

    @RequestMapping(value = "/list/project/{id}")
    public List<Computer> listProjectComputer(@PathVariable("id") Integer id){
        List<ProjectComputer> list = projectComputerRepository.findByIdProjectId(id);
        List<Integer> listIdComputer = new ArrayList<>();
        for (ProjectComputer projectComputer : list){
            listIdComputer.add(projectComputer.getId().getComputerId());
        }
        return computerRepositoy.findByIdComputerIn(listIdComputer);
    }

    @RequestMapping(value  = "/create", method = RequestMethod.POST)
    public Computer createComputer(@RequestBody Computer computer){
        return computerRepositoy.save(computer);
    }

    @RequestMapping(value = "/delete/{id}")
    public List<Computer> deleteComputer(@PathVariable("id") Integer id){
        computerRepositoy.delete(id);
        return computerRepositoy.findAll();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Computer updateComputer(@RequestBody Computer computer){
        return  computerRepositoy.save(computer);
    }

    @RequestMapping(value = "/stat")
    public HashMap<Computer, ArrayList<Statistic>> getAllStatComputer(){
        ArrayList<Computer> listComputer = (ArrayList<Computer>) computerRepositoy.findAll();
        ArrayList<Statistic> listStat = (ArrayList<Statistic>) statisticRepository.findAll();

        HashMap<Computer, ArrayList<Statistic>> mapStat = new HashMap<>();
        for (Statistic statistic : listStat){
            Computer computer = new Computer();
            computer.setIdComputer(statistic.getId().getComputerId());

            computer = listComputer.get(listComputer.indexOf(computer));
            if (!mapStat.containsKey(computer)){
                mapStat.put(computer, new ArrayList<Statistic>());
            }

            mapStat.get(computer).add(statistic);
        }
        return mapStat;
    }

    @RequestMapping(value = "/stat/{id}")
    public List<Statistic> getStatByIdComputer(@PathVariable("id") Integer id){
        return statisticRepository.findByIdComputerId(id);
    }
}
