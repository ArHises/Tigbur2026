package tigbur02032026;

public class Manager extends Employee{
    private int bonusPercent; // 15

    @Override
    public float calculateSalary() {
        return super.calculateSalary() * ((this.bonusPercent / 100f) + 1);
    }
}
