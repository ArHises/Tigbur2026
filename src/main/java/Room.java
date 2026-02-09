public class Room {

    private int number;
    private int type;
    private boolean available;

    public Room(int number, int type) {
        if (number / 100 <= 20 && number / 100 > 0){
            this.number = number;
        }
        this.type = type;
        this.available = true;
    }

    public int floor(){
        return this.number / 100;
    }

    public boolean highFloor(){
        boolean isHighFloor = false;
        if (this.floor() >= 10){
            isHighFloor = true;
        }
        return isHighFloor;
//        return this.floor() >= 10;
    }

    public boolean isPoolView(){
        return this.number % 2 == 0;
    }

    public int calculatePrice(){
        int price = 2000;

        if (this.highFloor()){
            int temp = (this.floor() - 10) * 100;
            price += temp;
        }
        if (this.number % 100 <= 5){
            price += 200;
        }
        if (this.type == 2){
//            price *= 1.5;
            price = (int) (price * 1.5);
        } else if (this.type == 3) {
//            price *= 2.5;
            price = (int) (price * 2.5);
        }
        return price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String toString() {
        // Room {ROOM NUMBER}
        // is on floor {FLOOR_NUMBER}
        // and of type {REGULAR/UPGRADED/SWEET}
        // with view to the pool: true / false
        // room price: {price}

        String result = "";
        result += "Room " + this.number + " is on floor " + this.floor()
                + " and of type ";
        if (this.type == 1){
            result += "regular";
        } else if (this.type == 2) {
            result += "upgraded";
        } else if (this.type == 3) {
            result += "sweet";
        } else {
            result += "error";
        }

        result += " with view to the pool: " + this.isPoolView();
        result += " room price " + calculatePrice();
        return result;
    }
}
