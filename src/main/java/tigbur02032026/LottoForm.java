package tigbur02032026;

import java.util.Random;
import java.util.Scanner;

public class LottoForm {
    private int[] numbers; // 1 - 37 normal numbers
    private int strong; // 1 - 7 strong numbers
    private String name;

    public LottoForm(String name, boolean auto){
        this.name = name;
        this.numbers = new int[6];
        if (auto){
            Random random = new Random();
            this.strong = random.nextInt(1, 8);

            for (int i = 0; i < this.numbers.length; i++) {
                int theNumber = random.nextInt(1, 38);
                if (checkDoubles(theNumber)){
                    i--;
                    continue;
                }
                this.numbers[i] = theNumber;
            }
        } else {
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < this.numbers.length; i++) {
                System.out.println("Enter regular number(1 - 37): ");
                int theNumber = scanner.nextInt();
                if (theNumber < 1 || theNumber > 37 || checkDoubles(theNumber)){
                    System.out.println("Invalid number, try again");
                    i--;
                    continue;
                }
                this.numbers[i] = theNumber;
            }
            int theNumber = 0;
            do {
                System.out.println("Enter strong number(1 - 7): ");
                theNumber = scanner.nextInt();
            } while (theNumber < 1 || theNumber > 7);
            this.strong = theNumber;
        }
    }

    private boolean checkDoubles(int number){
        for (int i = 0; i < this.numbers.length; i++) {
            if (this.numbers[i] == number){
                return true;
            }
        }
        return false;
    }
}
