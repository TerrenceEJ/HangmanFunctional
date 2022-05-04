public class Player {
    private String name = "";
    private int score = 0;
    private int fail = 0;


    Player(){
        this.name = name;
        this.score = score;
        this.fail = fail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getFail() {
        return fail;
    }

    public void setFail(int fail) {
        this.fail = fail;
    }

    public Player getPlayer(){
        return this;
    }
}
