package edu.neu.csye6200.oodfinalproject.model.role;

import edu.neu.csye6200.oodfinalproject.ui.ViewFXMLs;

public class AdminRole extends Role {
    public AdminRole() {
        super(RoleType.ADMIN);
    }
/*@Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new AdminWorkAreaJPanel(userProcessContainer, enterprise);
    }*/

    @Override
    public String getWorkArea() {
        return ViewFXMLs.ENTERPRISE_ADMIN_VIEWS.DASHBOARD.getValue();
    }
}