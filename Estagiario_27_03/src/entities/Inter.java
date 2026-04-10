package entities;

public class Inter {
    //atributs
    private String name;
    private String email;
    private String curso;
    private Double generealAverage;
    private Integer age;
    private String gender;

    //connstructor
    public Inter() {}

    public Inter(String name, String email, String curso, Double generealAverage, Integer age, String gender) {
        this.name = name;
        this.email = email;
        this.curso = curso;
        this.generealAverage = generealAverage;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCurso() {
        return curso;
    }

    public Double getGenerealAverage() {
        return generealAverage;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append("\n#################################################### \n");
       sb.append("Nome: ");
       sb.append(name + "\n");
       sb.append("Email: ");
       sb.append(email + "\n");
       sb.append("Curso: ");
       sb.append(curso + "\n");
       sb.append("Média Geral: ");
       sb.append(generealAverage + "\n");
       sb.append("Idade: ");
       sb.append(age + "\n");
       sb.append("Gênero: ");
       sb.append(gender + "\n");
       sb.append("####################################################");
       return sb.toString();
    }
    
    
    
}
