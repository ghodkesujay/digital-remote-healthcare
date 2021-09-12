package edu.neu.csye6200.oodfinalproject.model.role;

import edu.neu.csye6200.oodfinalproject.ui.ViewFXMLs;

public class DoctorRole extends Role {
    public DoctorRole() {
        super(RoleType.DOCTOR);
    }

    @Override
    public String getWorkArea() {
        return ViewFXMLs.DOCTOR_VIEWS.DASHBOARD.getValue();
    }
}
