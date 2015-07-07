package org.tekCorp.api.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tekCorp.api.domain.Computer;
import org.tekCorp.api.domain.Project;
import org.tekCorp.api.domain.User;
import org.tekCorp.api.domain.projectcomputer.ProjectComputer;
import org.tekCorp.api.domain.projectuser.ProjectUser;
import org.tekCorp.api.domain.statistic.Statistic;
import org.tekCorp.api.domain.statistic.StatisticKey;
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
    protected UserRepository userRepository;
    @Autowired
    protected ComputerRepository computerRepository;
    @Autowired
    protected StatisticRepository statisticRepository;
    @Autowired
    protected ProjectUserRepository projectUserRepository;
    @Autowired
    protected ProjectComputerRepository projectComputerRepository;

    @RequestMapping(value = "/project")
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

    @RequestMapping(value = "/project/{id}/user")
    public HashMap<User, ArrayList<Statistic>> getProjectStatUser(@PathVariable("id") Integer id){
        ArrayList<Statistic> listStat = (ArrayList<Statistic>) statisticRepository.findByIdProjectId(id);
        List<ProjectUser> listProjectUser = projectUserRepository.findByIdProjectId(id);
        List<Integer> listIdUser = new ArrayList<>();
        for (ProjectUser projectUser : listProjectUser){
            listIdUser.add(projectUser.getId().getUserId());
        }
        ArrayList<User> listUser = (ArrayList<User>) userRepository.findByIdUserIn(listIdUser);
        ArrayList<Computer> listComputer = computerRepository.findByIdUserIn(listIdUser);
        HashMap<User, ArrayList<Statistic>> mapStat = new HashMap<>();
        for (Statistic statistic : listStat){
            Computer computer = new Computer();
            computer.setIdComputer(statistic.getId().getComputerId());
            computer = listComputer.get(listComputer.indexOf(computer));

            User user = new User();
            user.setIdUser(computer.getIdUser());

            user = listUser.get(listComputer.indexOf(user));
            if (!mapStat.containsKey(user)){
                mapStat.put(user, new ArrayList<Statistic>());
            }

            mapStat.get(user).add(statistic);
        }

        return mapStat;
    }

    @RequestMapping(value = "/project/{id}/computer")
    public HashMap<Computer, ArrayList<Statistic>> getProjectStatComputer(@PathVariable("id") Integer id){
        ArrayList<Statistic> listStat = (ArrayList<Statistic>) statisticRepository.findByIdProjectId(id);
        List<ProjectComputer> listProjectComputer = projectComputerRepository.findByIdProjectId(id);
        List<Integer> listIdComputer = new ArrayList<>();
        for (ProjectComputer projectComputer : listProjectComputer){
            listIdComputer.add(projectComputer.getId().getComputerId());
        }
        ArrayList<Computer> listComputer = (ArrayList<Computer>) computerRepository.findByIdComputerIn(listIdComputer);
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

    @RequestMapping(value = "/computer")
    public HashMap<Computer, ArrayList<Statistic>> getAllComputerStat(){
        ArrayList<Computer> listComputer  = (ArrayList<Computer>) computerRepository.findAll();
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

    @RequestMapping(value = "/computer/{id}")
    public List<Statistic> getComputerStat(@PathVariable("id") Integer id){
        return statisticRepository.findByIdComputerId(id);
    }

    @RequestMapping(value = "/computer/{id}/project")
    public HashMap<Project, ArrayList<Statistic>> getComputerStatProject(@PathVariable("id") Integer id){
        List<Statistic> listStat = statisticRepository.findByIdComputerId(id);
        List<ProjectComputer> listProjectComputer = projectComputerRepository.findByIdComputerId(id);
        List<Integer> listIdProject = new ArrayList<>();
        for (ProjectComputer projectComputer : listProjectComputer){
            listIdProject.add(projectComputer.getId().getProjectId());
        }
        ArrayList<Project> listProject = (ArrayList<Project>) projectRepository.findByIdProjectIn(listIdProject);

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

    @RequestMapping(value = "/user")
    public HashMap<User, ArrayList<Statistic>> getAllUserStat(){
        ArrayList<User> listUser = (ArrayList<User>) userRepository.findAll();
        ArrayList<Computer> listComputer = (ArrayList<Computer>) computerRepository.findAll();
        ArrayList<Statistic> listStat = (ArrayList<Statistic>) statisticRepository.findAll();

        HashMap<User, ArrayList<Statistic>> mapStat = new HashMap<>();
        for (Statistic statistic : listStat){
            Computer computer = new Computer();
            computer.setIdComputer(statistic.getId().getComputerId());
            computer = listComputer.get(listComputer.indexOf(computer));

            User user = new User();
            user.setIdUser(computer.getIdUser());

            user = listUser.get(listComputer.indexOf(user));
            if (!mapStat.containsKey(user)){
                mapStat.put(user, new ArrayList<Statistic>());
            }
            mapStat.get(user).add(statistic);
        }

        return mapStat;
    }

    @RequestMapping(value = "/user/{id}")
    public List<Statistic> getUserStat(@PathVariable("id") Integer id){
        List<Computer> listComputer = computerRepository.findByIdUser(id);
        return statisticRepository.findByIdComputerIdIn(listComputer);
    }

    @RequestMapping(value = "/user/{id}/computer")
    public HashMap<Computer, ArrayList<Statistic>> getUserStatComputer(@PathVariable("id") Integer id){
        HashMap<Computer, ArrayList<Statistic>> mapStat = new HashMap<>();
        /**
         * TODO
         */
        return mapStat;
    }

    @RequestMapping(value = "/user/{id}/project")
    public HashMap<Project, ArrayList<Statistic>> getUserStatProject(@PathVariable("id") Integer id){
        HashMap<Project, ArrayList<Statistic>> mapStat = new HashMap<>();
        /**
         * TODO
         */
        return mapStat;
    }
    @RequestMapping(value = "/user/{idUser}/project/{idProject}")
    public List<Statistic> getUserStatProjectStat(@PathVariable("idUser") Integer idUser, @PathVariable("idProject") Integer idProject){
        List<StatisticKey> listIdKey = new ArrayList<>();
        /**
         * TODO
         */
        return statisticRepository.findByIdIn(listIdKey);
    }
    @RequestMapping(value = "/user/{idUser}/project/{idProject}/computer")
    public HashMap<Computer, ArrayList<Statistic>> getUserStatProjectStatComputer(@PathVariable("idUser") Integer idUser, @PathVariable("idProject") Integer idProject){
        HashMap<Computer, ArrayList<Statistic>> mapStat = new HashMap<>();
        /**
         * TODO
         */
        return mapStat;
    }
}
