package tigbur02032026;

public class Main {

    public static String getMaxTrippleDoubler(Basketballer[] players){
        Basketballer max = players[0];

        for (int i = 1; i < players.length; i++) {
            if (max.countTrippleDouble() < players[i].countTrippleDouble()){
                max = players[i];
            }
        }
        return max.getName();
    }

    public static void EmployeeWithHighestSalary(Employee[] workers){
        if (workers.length == 0){
            System.out.println("No workers");
            return;
        }

        Employee max = workers[0];
        for (int i = 1; i < workers.length; i++) {
            if (max.calculateSalary() < workers[i].calculateSalary()){
                max = workers[i];
            }
        }
        System.out.println("Worker with highst salary: " + max.getName());
    }

    public static void main(String[] args) {

    }
}
