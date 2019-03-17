package seedu.address.storage;

import seedu.address.model.role.Ogl;

import java.util.ArrayList;

/**
 * Stores the list of OGLs
 */
public class OGLStorage {

    private static ArrayList<String> oglNames = new ArrayList<>();
    private static ArrayList<Ogl> ogls = new ArrayList<>();

    /**
     * Constructs a List for storing ogls.
     */
    public OGLStorage() {
    }

    public static ArrayList<Ogl> getOgls() {
        return ogls;
    }

    /**
     * Adds an OGL
     */
    public static void addOGL(String nameToAdd) {
        oglNames.add(nameToAdd);
    }
    /**
     * Deletes a freshman
     */
    public static void deleteOGL(String nameToDelete) {
        oglNames.remove(nameToDelete);
    }
    /**
     * Checks if a freshman exists
     */
    public static boolean hasOGL (String toFind) {
        return oglNames.contains(toFind);
    }
    /**
     * Prints the list
     */
    public static void listOGL() {
        for (int i = 0; i < ogls.size(); i++) {
            System.out.println(ogls.get(i));
            System.out.println();
        }
    }
}
