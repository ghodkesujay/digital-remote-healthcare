package edu.neu.csye6200.oodfinalproject.model.role;

import edu.neu.csye6200.oodfinalproject.ui.ViewFXMLs;

public class PrimaryCareProviderRole extends Role {
    public PrimaryCareProviderRole() {
        super(RoleType.PRIMARY_CARE_PROVIDER);
    }

    @Override
    public String getWorkArea() {
        return ViewFXMLs.PRIMARY_CARE_PROVIDER_VIEWS.DASHBOARD.getValue();
    }
}
