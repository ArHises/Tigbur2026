package tigbur02032026;

public class Employee {
    private String name;
    private float hourSalary;
    private int yearsOfExperience;

    public float calculateSalary(){
        return this.hourSalary * 180;
    }

    public String getName() {
        return name;
    }
}
