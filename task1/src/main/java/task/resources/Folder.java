package task.resources;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    private final String name;
    private final List<Folder> subFolders = new ArrayList<>();
    private final List<File> files = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(Folder folder) {
        subFolders.add(folder);
    }

    public void add(File file) {
        files.add(file);
    }

    public String getName() {
        return name;
    }

    public List<Folder> getSubFolders() {
        return subFolders;
    }

    public List<File> getFiles() {
        return files;
    }

    public Folder findSubFolder(String name) {
        for (Folder subFolder : subFolders) {
            if (subFolder.getName().equals(name)) {
                return subFolder;
            }
        }
        return null;
    }
}