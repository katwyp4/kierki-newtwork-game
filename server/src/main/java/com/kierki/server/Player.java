public class Player {
    private String username;
    private int score;
    private boolean isReady;

    public Player(String username) {
        this.username = username;
        this.score = 0;
        this.isReady = false;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    public void addPoints(int points) {
        this.score += points;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }
}
