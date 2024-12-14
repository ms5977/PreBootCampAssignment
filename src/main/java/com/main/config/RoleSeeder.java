package com.main.config;

import com.main.enitity.Role;
import com.main.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class RoleSeeder implements CommandLineRunner {
    private final RoleRepository roleRepo;

    public RoleSeeder(RoleRepository roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        if (roleRepo.count()==0){
            Role userRole=new Role();
            userRole.setName("STUDENT_ROLE");

            Role adminRole=new Role();
            adminRole.setName("ADMIN_ROLE");

            roleRepo.save(userRole);
            roleRepo.save(adminRole);
        }
    }
}
