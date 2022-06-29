package main;

public record Record(String name, int score) {
    public String toString() {
        return name + " " + score;
    }
}
