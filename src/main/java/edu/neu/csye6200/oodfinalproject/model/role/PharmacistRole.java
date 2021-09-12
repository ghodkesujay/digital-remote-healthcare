package edu.neu.csye6200.oodfinalproject.model.role;

import edu.neu.csye6200.oodfinalproject.ui.ViewFXMLs;

public class PharmacistRole extends Role{
    public PharmacistRole() {
        super(RoleType.PHARMACIST);
    }

    @Override
    public String getWorkArea() {
        return ViewFXMLs.PHARMACIST_VIEWS.DASHBOARD.getValue();
    }
}
