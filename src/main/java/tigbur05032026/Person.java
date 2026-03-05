package tigbur05032026;

public class Person {
    private String name;
    private int age;
    private Person[] children;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.children = new Person[0];
    }

    public boolean hasChildren() {
        if (this.children == null || this.children.length == 0){
            return false;
        }
        return true;
    }

    public boolean isGrandfather() {
        for (int i = 0; i < this.children.length; i++) {
            if (this.children[i].hasChildren()){
                return true;
            }
        }
        return false;
    }

    public boolean addChild(Person child){
        if (this.age >= child.age + 18 ) {
            Person[] result = new Person[this.children.length + 1];
            // this.children = [p1,p2,p3,p4]
            // result = [_,_,_,_,_]
            for (int i = 0; i < this.children.length; i++) {
                result[i] = this.children[i];
            }
            // result = [p1,p2,p3,p4,_]
            result[result.length -1] = child;
            // result = [p1,p2,p3,p4,child]
            this.children = result;
            return true;
        } else {
            return false;
        }
    }

    public Person getYoungestChild() {
        if (!this.hasChildren()){
            return null;
        }
        Person min = this.children[0];
        for (int i = 1; i < this.children.length; i++) {
            if (this.children[i].age < min.age){
                min = this.children[i];
            }
        }
        return min;
    }
    // Natan
    // this.children = [gabi, moshe, kobi, shoval, Goby]
    //                    V
    //                  [dawd ,adwd , dwaw ,dawd]

    // String temp = "NGMKSGSADD"
    //

    public char mostCommonStartingLetter(){
        char result = this.name.charAt(0); // N
        if (!hasChildren()){
            return result;
        }

        String temp = "" + result;

        for (int i = 0; i < this.children.length; i++) {
            Person currentChild = this.children[i];
            temp += currentChild.name.charAt(0);
            for (int j = 0; j < currentChild.children.length; j++) {
                temp += currentChild.children[j].name.charAt(0);
            }
        }

        // String temp = "NGMKSGSADD"
        //                i^       ^j
        char max = temp.charAt(0); // "N"
        int maxCount = 0;

        for (int i = 0; i < temp.length(); i++) {
            char currentChar = temp.charAt(i); // N
            int currentCount = 0;
            for (int j = i; j < temp.length(); j++) {
                if (temp.charAt(j) == currentChar){
                    currentCount++;
                }
            }
            if (currentCount > maxCount){
                maxCount = currentCount;
                max = currentChar;
            }
        }
        return max;
    }

    private int getGrandChildren(){
        int count = 0;
        for (int i = 0; i < this.children.length; i++) {
            Person current = this.children[i];
            count += current.children.length;
        }
        return count;
    }

    public int compareGrandchildren(Person other){
        if (this.getGrandChildren() > other.getGrandChildren()){
            return 1;
        } else if (this.getGrandChildren() < other.getGrandChildren()) {
            return -1;
        } else {
            return 0;
        }
    }
}
