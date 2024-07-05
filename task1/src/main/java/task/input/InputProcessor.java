package task.input;

import task.controllers.StructTree;
import task.resources.File;
import task.resources.Folder;
import task.resources.Struct;
import java.util.Scanner;
public class InputProcessor {
    public InputProcessor() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            String query = sc.nextLine();
            if(query==null || query.isEmpty()) {
                break;
            }
            String[] foldersAndFiles = query.split("/");
            StructTree structTree = new StructTree();
            Struct struct = new Struct();
            for (String entityName : foldersAndFiles) {
                if (entityName.contains(".")) {
                    struct.add(new File(entityName));
                    break;
                } else {
                    struct.add(new Folder(entityName));
                }
            }
            structTree.add(struct);
        }
    }
}
