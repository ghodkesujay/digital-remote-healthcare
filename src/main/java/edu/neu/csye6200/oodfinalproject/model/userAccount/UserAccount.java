package edu.neu.csye6200.oodfinalproject.model.userAccount;

import edu.neu.csye6200.oodfinalproject.model.employee.Employee;
import edu.neu.csye6200.oodfinalproject.model.role.Role;
import edu.neu.csye6200.oodfinalproject.model.workqueue.WorkQueue;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class UserAccount {

    private String username;
    private String password;
    private Role role;
    private Employee employee;
    private WorkQueue workQueue = new WorkQueue();



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(employee, that.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, employee);
    }
}
