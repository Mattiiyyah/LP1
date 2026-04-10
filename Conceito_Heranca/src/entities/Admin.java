package entities;

public class Admin extends User {
    private String department;

    public Admin() {
        super();
        department = new String();
    }

    public Admin(Integer id, String name, String email, String password, String department) {
        super(id, name, email, password);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Departamento: ").append(department).append("\n");
        sb.append("####################################################");
        return sb.toString();
    }

}
