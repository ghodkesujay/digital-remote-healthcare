package edu.neu.csye6200.oodfinalproject.util;

import edu.neu.csye6200.oodfinalproject.model.ecosystem.Ecosystem;
import edu.neu.csye6200.oodfinalproject.model.employee.Employee;
import edu.neu.csye6200.oodfinalproject.model.network.Network;
import edu.neu.csye6200.oodfinalproject.model.role.SystemAdminRole;
import edu.neu.csye6200.oodfinalproject.model.userAccount.UserAccount;

public class ConfigureASystem {
    public static Ecosystem configure() {

        Ecosystem system = Ecosystem.getInstance();

        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees
        //create user account


        Employee employee = new Employee("sysadmin");
        system.getEmployeeDirectory().addEmployee(employee);

        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", Utils.getHash("sysadmin"), employee, new SystemAdminRole());

        system.addNetwork(new Network("Massachusetts"));
        system.addNetwork(new Network("New York"));



        return system;
    }
}
