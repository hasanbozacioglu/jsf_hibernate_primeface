package bootstrap;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class StudentMB {
    private String firstName;
    private String lastName;
    private String standerd;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStanderd() {
        return standerd;
    }

    public void setStanderd(String standerd) {
        this.standerd = standerd;
    }
}
