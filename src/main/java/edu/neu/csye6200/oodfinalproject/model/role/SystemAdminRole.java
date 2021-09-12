package edu.neu.csye6200.oodfinalproject.model.role;

import edu.neu.csye6200.oodfinalproject.ui.ViewFXMLs;

public class SystemAdminRole extends Role {
    public SystemAdminRole() {
        super(RoleType.SYSTEM_ADMIN);
    }

    @Override
    public String getWorkArea() {
        return ViewFXMLs.SYSADMIN_VIEWS.DASHBOARD.getValue();
    }
}
