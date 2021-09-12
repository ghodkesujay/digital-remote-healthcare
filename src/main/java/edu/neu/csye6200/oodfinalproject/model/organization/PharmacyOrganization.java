package edu.neu.csye6200.oodfinalproject.model.organization;

import edu.neu.csye6200.oodfinalproject.model.role.PharmacistRole;
import edu.neu.csye6200.oodfinalproject.model.role.Role;

import java.util.Collections;
import java.util.List;

public class PharmacyOrganization extends Organization {

    public PharmacyOrganization() {
        super(Type.PHARMACY_ORGANIZATION);
    }

    @Override
    public List<Role> getSupportedRole() {
        return Collections.singletonList(new PharmacistRole());
    }
}
