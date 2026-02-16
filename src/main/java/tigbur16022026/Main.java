package tigbur16022026;

public class Main {

    public static int countPiks(int[] numbers){
        // {1,2,3,1,4,5,2,5}
        //  ^
        int count = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]){
                count++;
            }
        }
        count++;
        return count;
    }

    public static int[] maxSidra(int[] numbers){
        // {1,2,3,1,4,5,7,2,5,8,9,12}
        //                ^
        // currentLength++ = 3
        // maxLength = 4

        int maxLength = 0;
        int currentLength = 0;
        int pointer = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] < numbers[i + 1]){
                currentLength++;
            } else {
                if (currentLength > maxLength){
                    maxLength = currentLength;
                    pointer = i - currentLength;
                }
                currentLength = 0;
            }
        }
        if (currentLength > maxLength){
            maxLength = currentLength;
            pointer = numbers.length - currentLength;
        }

        int[] result = new int[maxLength];

        for (int i = 0; i < maxLength; i++) {
            result[i] = numbers[pointer + i];
        }

        return result;
    }

    public static int[] getLowest(int[] nums1, int[] nums2){
        // {1,2,3,4,2,6,9,2,3} = 4
        // {1,2,3,4,9,6,8,12,7} = 5
        
        int[] nums1Max = maxSidra(nums1);
        int[] nums2Max = maxSidra(nums2);
        
        if (nums1Max.length > nums2Max.length){
            return nums2;
        } else if (nums1Max.length < nums2Max.length) {
            return nums1;
        } else {
            return null;
        }
    }

    public static boolean isSameChar(String[] text){
        // {"AsD","EhkguD","AnfkubfD"}

        char firstLetter = text[0].charAt(0);
        char secondLetter = text[0].charAt(text[0].length() - 1);

        for (int i = 1; i < text.length; i++) {
            if (text[i].charAt(0) != firstLetter
                || text[i].charAt(text[i].length() - 1) != secondLetter){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,1,4,5,2,5};
        System.out.println(countPiks(numbers));
    }
}
