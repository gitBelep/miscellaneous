package reflection;

import java.util.List;

public class Trainer extends Human{
    private String name;
    private int birth;
    private List<String> skills;
    private List<Course> courses;

    public Trainer() {
    }

    public Trainer(String name) {
        this.name = name;
    }

    public Trainer(String name, int birth) {
        this.name = name;
        this.birth = birth;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }


    private List<String> getSkills() {
        return skills;
    }

    private void setSkills(List<String> skills) {
        this.skills = skills;
    }

    class InnerSkills{
        String innerSkill = "clever";

        public void setInnerSkill(String innerSkill) {
            this.innerSkill = innerSkill;
        }
    }

}
