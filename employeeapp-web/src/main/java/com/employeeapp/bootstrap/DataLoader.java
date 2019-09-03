package com.employeeapp.bootstrap;

import com.employeeapp.model.Role;
import com.employeeapp.service.RoleService;
import org.springframework.boot.CommandLineRunner;

//@Component
public class DataLoader implements CommandLineRunner {
   // private final TeamNameService teamNameService;
    private final RoleService roleService;

    public DataLoader( RoleService roleService) {
        //this.teamNameService = teamNameService;
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
//        TeamName t1 = new TeamName();
//        t1.setName("Team A");
//        t1.setDateAdded(new Date());
//        teamNameService.save(t1);
//
//        TeamName t2 = new TeamName();
//        t2.setName("Team B");
//        t2.setDateAdded(new Date());
//        teamNameService.save(t2);

        Role role1 = new Role();
        role1.setName("Admin");
        roleService.save(role1);

        Role role2 = new Role();
        role2.setName("Manager");
        roleService.save(role2);

        Role role3 = new Role();
        role3.setName("Employee");
        roleService.save(role3);
    }
}
