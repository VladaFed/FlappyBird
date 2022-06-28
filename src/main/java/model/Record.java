package model;

public record Record(String name, int score) {
    public String name() {
        return name;
    }

    public int score() {
        return score;
    }

    public String toString() {
        return name + " " + score;
    }
}
