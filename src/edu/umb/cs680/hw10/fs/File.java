package edu.umb.cs680.hw10.fs;

import java.util.Iterator;

import edu.umb.cs680.hw10.Authentication.SecurityContext;

public class File extends FSElement {

    public File(Directory parent, String name, int size) {
        super(parent, name, size);
        parent.appendChildren(this);
    }

    @Override
    public boolean isDirectory() {
        return false;
    }
    
    protected static File search(Directory dir, String name){
        Iterator<FSElement> feIterator = dir.getChildren().iterator();
        while (feIterator.hasNext()){
            FSElement currentElement = (FSElement)feIterator.next();
            if (currentElement.isDirectory()){
                currentElement = search((Directory)currentElement, name);
                if (currentElement != null){
                    return (File)currentElement;
                }
            }else{
                if (currentElement.name == name){
                    return (File)currentElement;
                }
            }  
        }
        return null;
    }

    public static File searchAndReturnFirstFile(FileSystem fs, String name){
        Directory child=null;
        File f = null;
        Iterator<Directory> fsIterator = fs.getRootDirectories().iterator();

        while (fsIterator.hasNext()){
            child = (Directory)fsIterator.next();
            f = search(child, name);
            if (f != null){
                return f;
            }
        }
        return f;
    }

    public void accept(FSVisitor v, SecurityContext ctx) throws Exception{
        if(ctx.isActive()){
            v.visit(this);
          }else{
            throw new RuntimeException("Login required!!!");
        }
    }

}
