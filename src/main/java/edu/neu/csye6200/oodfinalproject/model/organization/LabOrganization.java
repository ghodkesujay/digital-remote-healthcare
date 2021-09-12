package edu.neu.csye6200.oodfinalproject.model.organization;

import edu.neu.csye6200.oodfinalproject.model.role.LabRole;
import edu.neu.csye6200.oodfinalproject.model.role.Role;

import java.util.Collections;
import java.util.List;

public class LabOrganization extends Organization {

    public LabOrganization() {
        super(Type.LAB_ORGANIZATION);
    }


    @Override
    public List<Role> getSupportedRole() {
        return Collections.singletonList(new LabRole());
    }
}
