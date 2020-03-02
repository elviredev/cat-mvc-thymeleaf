package com.elv.catmvcthymeleaf.dao;

import com.elv.catmvcthymeleaf.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    @Override
    void delete(Role role);

}
