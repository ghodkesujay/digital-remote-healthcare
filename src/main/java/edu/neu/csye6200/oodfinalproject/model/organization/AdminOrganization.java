package edu.neu.csye6200.oodfinalproject.model.organization;

import edu.neu.csye6200.oodfinalproject.model.role.AdminRole;
import edu.neu.csye6200.oodfinalproject.model.role.Role;

import java.util.Collections;
import java.util.List;

public class AdminOrganization extends Organization {
    public AdminOrganization(String name) {
        super(Type.ADMIN);
        this.setName(name);
    }

    @Override
    public List<Role> getSupportedRole() {
        return Collections.singletonList(new AdminRole());
    }
}
