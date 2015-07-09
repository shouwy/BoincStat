package org.tekCorp.api.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tekCorp.api.Util.StatUtil;
import org.tekCorp.api.domain.Computer;
import org.tekCorp.api.domain.Project;
import org.tekCorp.api.domain.User;
import org.tekCorp.api.domain.projectcomputer.ProjectComputer;
import org.tekCorp.api.domain.projectuser.ProjectUser;
import org.tekCorp.api.domain.statistic.Statistic;
import org.tekCorp.api.repository.*;
import org.tekCorp.api.views.StatisticViews;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Inspiron on 06/07/2015.
 */
@RestController
@RequestMapping(value="/stat")
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

    @RequestMapping(value = "/all")
    public ArrayList<StatisticViews> getAllStat(){
        ArrayList<Project> listProject = (ArrayList<Project>) projectRepository.findAll();
        ArrayList<Computer> listComputer = (ArrayList<Computer>) computerRepository.findAll();
        ArrayList<User> listUser = (ArrayList<User>) userRepository.findAll();
        List<Statistic> listStat = statisticRepository.findAll();

        return computeData(listProject, listComputer, listUser, listStat);
    }

    @RequestMapping(value = "/all/project")
    public ArrayList<StatisticViews> getAllStatByProject(){
        ArrayList<Project> listProject = (ArrayList<Project>) projectRepository.findAll();
        ArrayList<Computer> listComputer = (ArrayList<Computer>) computerRepository.findAll();
        ArrayList<User> listUser = (ArrayList<User>) userRepository.findAll();
        List<Statistic> listStat = statisticRepository.findAll();

        return StatUtil.sumByProject(computeData(listProject, listComputer, listUser, listStat));
    }

    @RequestMapping(value = "/all/project/best")
    public StatisticViews getAllProjectBest(){
        ArrayList<Project> listProject = (ArrayList<Project>) projectRepository.findAll();
        ArrayList<Computer> listComputer = (ArrayList<Computer>) computerRepository.findAll();
        ArrayList<User> listUser = (ArrayList<User>) userRepository.findAll();
        List<Statistic> listStat = statisticRepository.findAll();

        return StatUtil.bestProject(computeData(listProject, listComputer, listUser, listStat));
    }

    @RequestMapping(value = "/all/computer")
    public ArrayList<StatisticViews> getAllStatByComputer(){
        ArrayList<Project> listProject = (ArrayList<Project>) projectRepository.findAll();
        ArrayList<Computer> listComputer = (ArrayList<Computer>) computerRepository.findAll();
        ArrayList<User> listUser = (ArrayList<User>) userRepository.findAll();
        List<Statistic> listStat = statisticRepository.findAll();

        return StatUtil.sumByComputer(computeData(listProject, listComputer, listUser, listStat));
    }

    @RequestMapping(value = "/all/computer/best")
    public StatisticViews getAllCommputerBest(){
        ArrayList<Project> listProject = (ArrayList<Project>) projectRepository.findAll();
        ArrayList<Computer> listComputer = (ArrayList<Computer>) computerRepository.findAll();
        ArrayList<User> listUser = (ArrayList<User>) userRepository.findAll();
        List<Statistic> listStat = statisticRepository.findAll();

        return StatUtil.bestComputer(computeData(listProject, listComputer, listUser, listStat));
    }

    @RequestMapping(value = "/all/user")
    public ArrayList<StatisticViews> getAllStatByUser(){
        ArrayList<Project> listProject = (ArrayList<Project>) projectRepository.findAll();
        ArrayList<Computer> listComputer = (ArrayList<Computer>) computerRepository.findAll();
        ArrayList<User> listUser = (ArrayList<User>) userRepository.findAll();
        List<Statistic> listStat = statisticRepository.findAll();

        return StatUtil.sumByUser(computeData(listProject, listComputer, listUser, listStat));
    }

    @RequestMapping(value = "/all/user/best")
    public StatisticViews getAllUserBest(){
        ArrayList<Project> listProject = (ArrayList<Project>) projectRepository.findAll();
        ArrayList<Computer> listComputer = (ArrayList<Computer>) computerRepository.findAll();
        ArrayList<User> listUser = (ArrayList<User>) userRepository.findAll();
        List<Statistic> listStat = statisticRepository.findAll();

        return StatUtil.bestUser(computeData(listProject, listComputer, listUser, listStat));
    }

    @RequestMapping(value = "/project/{id}")
    public ArrayList<StatisticViews> getStatProject(@PathVariable("id") Integer id){
        Project project = projectRepository.findOne(id);
        ArrayList<Project> listProject = new ArrayList<>();
        listProject.add(project);

        List<ProjectComputer> listProjectComputer = projectComputerRepository.findByIdProjectId(id);
        List<Integer> listIdComputer = new ArrayList<>();
        for (ProjectComputer projectComputer : listProjectComputer){
            listIdComputer.add(projectComputer.getId().getComputerId());
        }
        ArrayList<Computer> listComputer = (ArrayList<Computer>) computerRepository.findByIdComputerIn(listIdComputer);

        List<Integer> listIdUser = new ArrayList<>();
        for (Computer computer : listComputer){
            listIdUser.add(computer.getIdUser());
        }
        ArrayList<User> listUser = (ArrayList<User>) userRepository.findByIdUserIn(listIdUser);

        List<Statistic> listStat = statisticRepository.findByIdProjectId(id);

        return computeData(listProject, listComputer, listUser, listStat);
    }

    @RequestMapping(value = "/computer/{id}")
    public ArrayList<StatisticViews> getComputerStat(@PathVariable("id") Integer id){
        Computer computer = computerRepository.findOne(id);
        ArrayList<Computer> listComputer = new ArrayList<>();
        listComputer.add(computer);

        List<Integer> listIdUser = new ArrayList<>();
        listIdUser.add(computer.getIdUser());
        ArrayList<User> listUser = (ArrayList<User>) userRepository.findByIdUserIn(listIdUser);

        List<ProjectComputer> listProjectComputer = projectComputerRepository.findByIdComputerId(id);
        List<Integer> listIdProject = new ArrayList<>();
        for (ProjectComputer projectComputer : listProjectComputer){
            listIdProject.add(projectComputer.getId().getProjectId());
        }
        ArrayList<Project> listProject = (ArrayList<Project>) projectRepository.findByIdProjectIn(listIdProject);

        List<Statistic> listStat = statisticRepository.findByIdComputerId(id);

        return computeData(listProject, listComputer, listUser, listStat);
    }

    @RequestMapping(value = "/user/{id}")
    public ArrayList<StatisticViews> getUserStat(@PathVariable("id") Integer id){
        User user = userRepository.findOne(id);
        ArrayList<User> listUser = new ArrayList<>();
        listUser.add(user);

        ArrayList<Computer> listComputer = (ArrayList<Computer>) computerRepository.findByIdUser(id);
        List<Integer> listIdComputer = new ArrayList<>();
        for (Computer computer : listComputer){
            listIdComputer.add(computer.getIdComputer());
        }

        List<ProjectUser> listProjectUser = projectUserRepository.findByIdUserId(id);
        List<Integer> listIdProject = new ArrayList<>();
        for (ProjectUser projectUser : listProjectUser){
            listIdProject.add(projectUser.getId().getProjectId());
        }
        ArrayList<Project> listProject = (ArrayList<Project>) projectRepository.findByIdProjectIn(listIdProject);

        List<Statistic> listStat = statisticRepository.findByIdComputerIdIn(listIdComputer);

        return computeData(listProject, listComputer, listUser, listStat);
    }

    @RequestMapping(value = "/user/{idUser}/project/{idProject}")
    public ArrayList<StatisticViews> getUserStatProjectStat(@PathVariable("idUser") Integer idUser, @PathVariable("idProject") Integer idProject){
        Project project = projectRepository.findOne(idProject);
        ArrayList<Project> listProject = new ArrayList<>();
        listProject.add(project);
        List<Integer> listIdProject = new ArrayList<>();
        listIdProject.add(idProject);

        ArrayList<Computer> listComputer = (ArrayList<Computer>) computerRepository.findByIdUser(idUser);
        List<Integer> listIdComputer = new ArrayList<>();
        for (Computer computer : listComputer){
            listIdComputer.add(computer.getIdComputer());
        }

        User user = userRepository.findOne(idUser);
        ArrayList<User> listUser = new ArrayList<>();
        listUser.add(user);

        List<Statistic> listStat = statisticRepository.findByIdProjectIdInAndIdComputerIdIn(listIdProject, listIdComputer);

        return computeData(listProject, listComputer, listUser, listStat);
    }

    private ArrayList<StatisticViews> computeData(ArrayList<Project> listProject, ArrayList<Computer> listComputer, ArrayList<User> listUser, List<Statistic> listStat) {
        ArrayList<StatisticViews> list = new ArrayList<>();

        for (Statistic statistic : listStat){
            Project project = new Project();
            project.setIdProject(statistic.getId().getProjectId());
            project = listProject.get(listProject.indexOf(project));

            Computer computer = new Computer();
            computer.setIdComputer(statistic.getId().getComputerId());
            computer = listComputer.get(listComputer.indexOf(computer));

            User user = new User();
            user.setIdUser(computer.getIdUser());
            user = listUser.get(listUser.indexOf(user));

            StatisticViews statisticViews = new StatisticViews(project, computer, user, statistic.getId().getDate(), statistic.getValue());
            list.add(statisticViews);
        }
        return list;
    }
}
