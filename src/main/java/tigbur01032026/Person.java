package tigbur01032026;

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

    public boolean hasChildren(){
        return this.children != null && this.children.length > 0;
    }

    public boolean isGrandfather(){
        if (!hasChildren()){
            return false;
        }
        for (int i = 0; i < this.children.length; i++) {
            if (this.children[i].hasChildren()){
                return true;
            }
        }
        return false;
    }

    public boolean addChild(Person child){
        if (child.age > this.age - 18){ // 10 > (30 - 18) = 12
            return false;
        }
        int size = 1;
        if (this.hasChildren()){
            size = this.children.length + 1;
        }
        Person[] result = new Person[size];

        if (!this.hasChildren()){
            result[0] = child;
        } else {
            for (int i = 0; i < this.children.length; i++) {
                result[i] = this.children[i]; // [p1,p2,p3,_]
            }
            result[result.length - 1] = child; // [p1,p2,p3,child]
        }
        this.children = result;
        return true;
    }

    public Person getYoungestChild(){
        if (!this.hasChildren()){
            return null;
        }
        Person youngestChild = this.children[0];
        for (int i = 1; i < this.children.length; i++) {
            if (youngestChild.age > this.children[i].age){
                youngestChild = this.children[i];
            }
        }
        return youngestChild;
    }

    // String chars = "";
    // chars += this.name.charAt(0);

    public char mostCommonStartingLetter(){
        if (!this.hasChildren()){
            return name.charAt(0);
        }
        String chars = "" + this.name.charAt(0);

        for (int i = 0; i < this.children.length; i++) {

            Person currentChild = this.children[i];
            chars += currentChild.name.charAt(0);

            if (!currentChild.hasChildren()){
                continue;
            }
            for (int j = 0; j < currentChild.children.length; j++) {
                chars += currentChild.children[j].name.charAt(0);
            }
        }

        int maxCount = 0;
        char maxChar = chars.charAt(0);

        for (int i = 0; i < chars.length(); i++) { // "adlwndml"
            int currentCount = 1;
            for (int j = i + 1; j < chars.length(); j++) {
                if (chars.charAt(i) == chars.charAt(j)){
                    currentCount++;
                }
            }
            if (currentCount > maxCount){
                maxCount = currentCount;
                maxChar = chars.charAt(i);
            }
        }
        return maxChar;
    }

    private int getGrandChildren(){
        int count = 0;
        for (int i = 0; i < this.children.length; i++) {
            for (int j = 0; j < this.children[i].children.length; j++) {
                count++;
            }
        }
        return count;
    }

    public int compareGrandchildren(Person other){
        int result = 0;
        if (this.getGrandChildren() > other.getGrandChildren()){
            result = 1;
        } else if (this.getGrandChildren() < other.getGrandChildren()) {
            result = -1;
        }
        return result;
    }

}
