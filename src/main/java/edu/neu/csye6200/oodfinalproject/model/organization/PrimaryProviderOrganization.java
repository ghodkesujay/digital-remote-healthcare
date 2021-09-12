package edu.neu.csye6200.oodfinalproject.model.organization;

import edu.neu.csye6200.oodfinalproject.model.role.PrimaryCareProviderRole;
import edu.neu.csye6200.oodfinalproject.model.role.Role;

import java.util.List;

public class PrimaryProviderOrganization extends Organization{

    public PrimaryProviderOrganization() {
        super(Type.PRIMARY_CARE_PROVIDER);
    }

    @Override
    public List<Role> getSupportedRole() {
        return List.of(new PrimaryCareProviderRole());
    }
}
