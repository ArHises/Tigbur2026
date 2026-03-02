package tigbur02032026;

public class Basketballer {
    private String name;
    private int[] points;
    private int[] rebounds;
    private int[] assists;

    public int countDoubleDouble(){
        int count = 0;
        for (int i = 0; i < this.points.length; i++) {
            int doubles = 0;
            if (this.points[i] > 9 && this.points[i] < 100){
                doubles++;
            }
            if (this.rebounds[i] > 9 && this.rebounds[i] < 100){
                doubles++;
            }
            if (this.assists[i] > 9 && this.assists[i] < 100){
                doubles++;
            }

            if (doubles == 2){
                count++;
            }
        }
        return count;
    }

    public int countTrippleDouble(){
        int count = 0;
        for (int i = 0; i < this.points.length; i++) {
            if (this.points[i] > 9 && this.points[i] < 100){
                if (this.rebounds[i] > 9 && this.rebounds[i] < 100){
                    if (this.assists[i] > 9 && this.assists[i] < 100){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public String getName() {
        return name;
    }
}
