package task.view;

import task.resources.File;
import task.resources.Folder;
import task.resources.Struct;

import java.util.ArrayList;

public class StructPrinter {
  static StringBuilder builder = new StringBuilder();
    public StructPrinter(ArrayList<Struct> tree) {
        for (Struct struct : tree) {
            displayStruct(struct);
        }
    }

    private void displayStruct(Struct struct) {
        for (Folder folder : struct.getFolders()) {
            displayFolder(folder);
        }
        for (File file : struct.getFiles()) {
            builder.append("\t").append(file.getName());
            System.out.println(builder.toString());
        }
    }

    private void displayFolder(Folder folder) {
        builder.append(folder.getName()).append("/").append("\n").append("\t");
        for (Folder subFolder : folder.getSubFolders()) {
            displayFolder(subFolder);
        }
        for (File file : folder.getFiles()) {
            builder.append(file.getName());
        }
    }
}
