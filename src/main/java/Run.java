public class Run {

    public static String mostProfitable(Hotel[] hotels){
        Hotel max = hotels[0];
        for (int i = 1; i < hotels.length; i++) {
            if (hotels[i].income() > max.income()){
                max = hotels[i];
            }
        }
        return max.getName();
    }

    public static int replaceDigits(int num){

        // 5476
        // 4567
        int temp = num;
        String result = "";
        while (temp > 0){
            int first = temp % 10; // 6
            int second = (temp % 100) / 10; // 7
            result += second + "" + first;
            temp /= 100;
        }
        String fin = "";
        for (int i = result.length() - 1; i >= 0; i--) {
            fin += result.charAt(i);
        }
        return Integer.parseInt(fin);
    }

    public static void main(String[] args) {
//        Room room1 = new Room(1012, 3);
//        System.out.println(room1);

        System.out.println(replaceDigits(5476));

    }
}
