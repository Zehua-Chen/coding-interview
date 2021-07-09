package cci.s3.p6;

public record Animal(int id, Kind kind) {
    public enum Kind {
        CAT,
        DOG,
    }
}
