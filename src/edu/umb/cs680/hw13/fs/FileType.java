package edu.umb.cs680.hw13.fs;

public enum FileType {
    DIRECTORY("DIRECTORY") , FILE("FILE"), LINK("FILE");

    public final String label;

    private FileType(String label) {
        this.label = label;
    }
}
