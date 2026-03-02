package tigbur02032026;

public class SalesPerson extends Employee{
    private int salesSum;

    @Override
    public float calculateSalary() {
        return super.calculateSalary() + salesSum * 0.05f;
    }
}
