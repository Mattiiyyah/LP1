package entities;

public abstract class User {
    private Integer id;
    private String name;
    private String email;
    private String password;

    public User() {
        id = 0;
        name = new String();
        email = new String();
        password = new String();
    }

    public User(Integer id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n#################################################### \n");
        sb.append("Id: ").append(id).append("\n");
        sb.append("Nome: ").append(name).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Senha: ").append(password).append("\n");
        return sb.toString();
    }

}
