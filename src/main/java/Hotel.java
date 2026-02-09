public class Hotel {

    private String name;
    private Room[] rooms;

    public Hotel() {
        this.name = "";
        this.rooms = new Room[10];
    }

    public Room[] fitRooms(int type, int budget){

        int count = 0;
        for (int i = 0; i < this.rooms.length; i++) {
            if (this.rooms[i].getType() == type
                && this.rooms[i].calculatePrice() <= budget
                && this.rooms[i].isAvailable()){
                count++;
            }
        }

        Room[] result = new Room[count];
        int index = 0;
        for (int i = 0; i < this.rooms.length; i++) {
            if (this.rooms[i].getType() == type
                    && this.rooms[i].calculatePrice() <= budget
                    && this.rooms[i].isAvailable()){
                result[index] = this.rooms[i];
                index++;
            }
        }
        return result;
    }

    public int income(){
        int result = 0;
        for (int i = 0; i < this.rooms.length; i++) {
            if (!this.rooms[i].isAvailable()){
                result += this.rooms[i].calculatePrice();
            }
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }
}
