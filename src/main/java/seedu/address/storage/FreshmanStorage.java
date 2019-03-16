package seedu.address.storage;

import seedu.address.model.role.Participant;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores the list of Houses that have been created, with its (if any) constituent groups.
 */
public class FreshmanStorage {

    private static ArrayList<String> FreshmenNames = new ArrayList<>();
    private static ArrayList<Participant> freshmen = new ArrayList<>();

    /**
     * Constructs a HouseStorage object.
     */
    public FreshmanStorage() {
    }

    public static ArrayList<Participant> getFreshmen() {
        return freshmen;
    }

    /**
     * Adds a house that does not yet exist
     */
    public static void addFreshman(String nameToAdd) {
        FreshmenNames.add(nameToAdd);
    }

    public static void deleteFreshman(String nameTODelete) {
        FreshmenNames.remove(nameTODelete);
    }

    public static boolean hasFreshman (String toFind) {
        return FreshmenNames.contains(toFind);
    }

    public static void listFreshmen() {
        for (int i = 0; i < freshmen.size(); i++) {
            System.out.println(freshmen.get(i));
            System.out.println();
        }
    }
}
