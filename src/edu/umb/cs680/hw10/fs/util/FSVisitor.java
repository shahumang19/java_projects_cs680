package edu.umb.cs680.hw10.fs.util;

import edu.umb.cs680.hw10.fs.*;

public interface FSVisitor {
    public void visit(Link link);
    public void visit(Directory dir);
    public void visit(File file);
}
