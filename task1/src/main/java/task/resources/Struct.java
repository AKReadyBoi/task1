package task.resources;

import java.util.ArrayList;

public class Struct {
    ArrayList<Folder> folders = new ArrayList<>();
    ArrayList<File> files = new ArrayList<>();
    public void add(Folder folder) {
        folders.add(folder);
    }
    public void add(File file) {
        files.add(file);
    }

    public ArrayList<Folder> getFolders() {
        return folders;
    }
    public ArrayList<File> getFiles() {
        return files;
    }

}