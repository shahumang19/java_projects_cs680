package edu.umb.cs680.hw10.fs;

import java.time.LocalDateTime;

import edu.umb.cs680.hw10.Authentication.SecurityContext;

public abstract class FSElement {
    protected String name;
    protected int size;
    protected LocalDateTime creationTime;
    protected Directory parent;


    public FSElement(Directory parent, String name, int size) {
        this.name = name;
        this.size = size;
        this.creationTime = LocalDateTime.now();
        this.parent = parent;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LocalDateTime getCreationTime() {
        return this.creationTime;
    }

    public Directory getParent() {
        return this.parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public abstract boolean isDirectory();

    public abstract void accept(FSVisitor v, SecurityContext ctx) throws Exception;
    
}
