package edu.neu.csye6200.oodfinalproject.model.organization;

import edu.neu.csye6200.oodfinalproject.model.role.DoctorRole;
import edu.neu.csye6200.oodfinalproject.model.role.Role;

import java.util.Collections;
import java.util.List;

public class DoctorOrganization extends Organization {

    public DoctorOrganization() {
        super(Type.DOCTORS_ORGANIZATION);
    }

    @Override
    public List<Role> getSupportedRole() {
        return Collections.singletonList(new DoctorRole());
    }
}
