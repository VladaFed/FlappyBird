package controller;

public sealed interface GameObject {
    record BirdModel(int x, int y) implements GameObject {}
    record PipeModel(int x, int yBottom, int yTop) implements GameObject {}
}
