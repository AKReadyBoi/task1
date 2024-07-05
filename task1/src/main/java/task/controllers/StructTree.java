package task.controllers;

import task.resources.File;
import task.resources.Folder;
import task.resources.Struct;
import task.view.StructPrinter;

import java.util.ArrayList;

public class StructTree {
    public static ArrayList<Struct> tree = new ArrayList<>();

    public void add(Struct struct) {
        if (tree.isEmpty()) {
            tree.add(struct);
        } else {
            mergeStructs(tree.get(0), struct);
        }
        new StructPrinter(tree);
    }

    private void mergeStructs(Struct existing, Struct struct) {
        for (Folder newFolder : struct.getFolders()) {
            Folder existingFolder = findFolder(existing, newFolder.getName());
            if (existingFolder == null) {
                existing.add(newFolder);
            } else {
                mergeFolders(existingFolder, newFolder);
            }
        }
        for (File newFile : struct.getFiles()) {
            if (!containsFile(existing, newFile)) {
                existing.add(newFile);
            }
        }
    }

    private void mergeFolders(Folder existingFolder, Folder newFolder) {
        for (Folder subFolder : newFolder.getSubFolders()) {
            Folder existingSubFolder = existingFolder.findSubFolder(subFolder.getName());
            if (existingSubFolder == null) {
                existingFolder.add(subFolder);
            } else {
                mergeFolders(existingSubFolder, subFolder);
            }
        }
        for (File file : newFolder.getFiles()) {
            if (!containsFile(existingFolder, file)) {
                existingFolder.add(file);
            }
        }
    }

    private Folder findFolder(Struct struct, String name) {
        for (Folder folder : struct.getFolders()) {
            if (folder.getName().equals(name)) {
                return folder;
            }
        }
        return null;
    }

    private boolean containsFile(Struct struct, File file) {
        for (File f : struct.getFiles()) {
            if (f.getName().equals(file.getName())) {
                return true;
            }
        }
        return false;
    }

    private boolean containsFile(Folder folder, File file) {
        for (File f : folder.getFiles()) {
            if (f.getName().equals(file.getName())) {
                return true;
            }
        }
        return false;
    }
}
