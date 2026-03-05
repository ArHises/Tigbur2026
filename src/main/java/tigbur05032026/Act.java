package tigbur05032026;

public class Act {
    private String name;
    private int length;
    private Actor[] actors;
    private int level;

    public Act(String name, int length, int level) {
        this.name = name;
        this.length = length;
        this.level = level;
        this.actors = new Actor[0];
    }
    
    private boolean checkExist(Actor actor){
        for (int i = 0; i < this.actors.length; i++) {
            if (this.actors[i].getName().equals(actor.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean addActor(Actor actor){
        if (checkExist(actor)){
            return false;
        }

        Actor[] result = new Actor[this.actors.length + 1];
        boolean passed = false;

        for (int i = 0; i < this.actors.length; i++) {
            result[i] = this.actors[i];
        }

        if (this.level == 0){
            passed = true;
        } else if (actor.getActs() >= 3 && actor.getAge() >= 16) {
            passed = true;
        } else if (actor.getActs() >= 5 && actor.getAge() >= 25) {
            passed = true;
        }

        if (passed){
            result[result.length - 1] = actor;
            return true;
        }

        return false;
    }
}
