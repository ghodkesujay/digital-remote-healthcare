package edu.neu.csye6200.oodfinalproject.model.role;

import edu.neu.csye6200.oodfinalproject.ui.ViewFXMLs;

public class LabRole extends Role {
    public LabRole() {
        super(RoleType.LAB_TECHNICIAN);
    }

    @Override
    public String getWorkArea() {
        return ViewFXMLs.LAB_TECHS_VIEWS.DASHBOARD.getValue();
    }

}
