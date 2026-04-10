package entities;

public class Inter extends User {
    private Integer age;
    private Double average;
    private String gender;

    public Inter() {
        super();
        age = 0;
        average = 0.0;
        gender = new String();
    }

    public Inter(Integer id, String name, String email, String password, Integer age, Double average, String gender) {
        super(id, name, email, password);
        this.age = age;
        this.average = average;
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    @Override
    public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(super.toString());
    sb.append("Idade: ").append(age).append("\n");
    sb.append("Média: ").append(average).append("\n");
    sb.append("Sexo: ").append(gender).append("\n");
    sb.append("####################################################");
    return sb.toString();
}

}
