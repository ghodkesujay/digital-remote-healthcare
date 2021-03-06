package edu.neu.csye6200.oodfinalproject.model.enterprise;

import edu.neu.csye6200.oodfinalproject.model.role.Role;
import edu.neu.csye6200.oodfinalproject.model.organization.Organization;

import java.util.EnumSet;
import java.util.List;

public class PrimaryCareCentreEnterprise extends Enterprise {
    private static final EnumSet<Organization.Type> organizationTypes = EnumSet.of(Organization.Type.PRIMARY_CARE_PROVIDER, Organization.Type.MEDICAL_STORE_ORGANIZATION, Organization.Type.LAB_ORGANIZATION);
    public PrimaryCareCentreEnterprise() {
        super(Enterprise.Type.PRIMARY_CARE_CENTER);
    }

    @Override
    public List<Role> getSupportedRole() {
        return null;
    }

    public EnumSet<Organization.Type> getOrganizationTypes() {
        return organizationTypes;
    }

}
