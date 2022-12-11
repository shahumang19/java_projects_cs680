package edu.umb.cs680.hw13.fs;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

import edu.umb.cs680.hw13.Authentication.SecurityContext;

public class Directory extends FSElement {
    LinkedList<FSElement> children;

    public Directory(Directory parent, String name) {
        super(parent, name, 0);
        if (parent != null){
            parent.appendChildren(this);
        }
        this.children = new LinkedList<FSElement>();
    }

    public LinkedList<FSElement> getChildren() {
        Collections.sort(this.children, new AlphabeticalComparator());
        return this.children;
    }

    public LinkedList<FSElement> getChildren(Comparator<FSElement> comparator) {
        Collections.sort(this.children, comparator);
        return this.children;
    }

    public void appendChildren(FSElement child){
        this.children.add(child);
        Collections.sort(this.children, new AlphabeticalComparator());
    }

    public int countChildren(){
        int count = 0;
        Iterator<FSElement> it = this.children.iterator();

        while(it.hasNext()) {
            count++;
            it.next();
        }
        return count;
    }

    public LinkedList<Directory> getSubDirectories(){
        LinkedList<Directory> directories = new LinkedList<Directory>();
        FSElement temp;
        
        Iterator<FSElement> it = this.children.iterator();

        while(it.hasNext()) {
            temp = (FSElement) it.next();
            if (temp.getFileType() == FileType.DIRECTORY){
                directories.add((Directory)temp);
            }

        }
        Collections.sort(directories, new AlphabeticalComparator());
        return directories;
    }

    public LinkedList<Directory> getSubDirectories(Comparator<FSElement> comparator){
        LinkedList<Directory> directories = new LinkedList<Directory>();
        FSElement temp;
        
        Iterator<FSElement> it = this.children.iterator();

        while(it.hasNext()) {
            temp = (FSElement) it.next();
            if (temp.getFileType() == FileType.DIRECTORY){
                directories.add((Directory)temp);
            }

        }

        Collections.sort(directories, comparator);
        return directories;
    }

    public LinkedList<File> getFiles(){
        LinkedList<File> files = new LinkedList<File>();
        FSElement temp;
        
        Iterator<FSElement> it = this.children.iterator();

        while(it.hasNext()) {
            temp = (FSElement) it.next();
            if (temp.getFileType() == FileType.FILE){
                files.add((File)temp);
            }

        }
        Collections.sort(files, new AlphabeticalComparator());
        return files;
    }

    public LinkedList<File> getFiles(Comparator<FSElement> comparator){
        LinkedList<File> files = new LinkedList<File>();
        FSElement temp;
        
        Iterator<FSElement> it = this.children.iterator();

        while(it.hasNext()) {
            temp = (FSElement) it.next();
            if (temp.getFileType() == FileType.FILE){
                files.add((File)temp);
            }

        }
        
        Collections.sort(files, comparator);
        return files;
    }

    public int getTotalSize(){
        int totalSize=0;
        FSElement temp;
        
        Iterator<FSElement> it = this.children.iterator();

        while(it.hasNext()) {
            temp = (FSElement)it.next();
            if (temp.getFileType() == FileType.DIRECTORY){
                totalSize += ((Directory)temp).getTotalSize();
            }
            else{
                totalSize += temp.getSize();
            }
        }

        return totalSize;
    }

    protected static Directory search(Directory dir, String name){
        if (dir.name == name){
            return dir;
        }
        else{
            Iterator<Directory> dirIterator = dir.getSubDirectories().iterator();
            while (dirIterator.hasNext()){
                Directory currentDir = (Directory)dirIterator.next();
                currentDir = search(currentDir, name);
                if (currentDir != null){
                    return currentDir;
                }
            }
        }
        return null;
    }

    public static Directory searchAndReturnFirstDirectory(FileSystem fs, String name){
        Directory child=null;
        Iterator<Directory> fsIterator = fs.getRootDirectories().iterator();

        while (fsIterator.hasNext()){
            child = (Directory)fsIterator.next();
            child = search(child, name);
            if (child != null){
                return child;
            }
        }
        return child;
    }

    public void accept(FSVisitor v, SecurityContext ctx) throws Exception{
        if(ctx.isActive()){
            v.visit(this);

            for(FSElement e: children){
                e.accept(v, ctx); 
            }
          }else{
            throw new RuntimeException("Login required!!!");
        }
    }

    @Override
    public FileType getFileType() {
        return FileType.DIRECTORY;
    }
    
}
