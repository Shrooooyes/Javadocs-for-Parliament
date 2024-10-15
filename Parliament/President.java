package Parliament;

import java.util.Scanner;

/**
 * Represents President in Indian Parliament
 * @author: Shreyash Sawant
 * Roll no.: 45
 */
public class President {
    private String Name;

    /**
     * Constructs a new President with the specified name.
     *
     * @param Name The name of the President.
     */
    public President(String Name) {
        this.Name = Name;
    }

    /**
     * Determines whether the President wants to sign the bill into law.
     * The method interacts with the user to get the President's decision.
     *
     * @param bill The {@link Bill} object representing the bill to be signed.
     * @return {@code true} if the President agrees to sign the bill into law; {@code false} otherwise.
     */
    public boolean makeLaw(Bill bill) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n\nDoes the President want to sign the bill?");
            String President_MakeLaw = sc.nextLine();
            if (President_MakeLaw.equalsIgnoreCase("yes")) {
                System.out.println("Bill: \n" + bill.getBill() + "\nMade into Law...");
                // sc.close();
                return true;
            } else if (President_MakeLaw.equalsIgnoreCase("no")) {
                System.out.println("\nPresident doesn't want to sign, so the bill cannot be passed....\n");
                // sc.close();
                return false;
            } else {
                System.out.println("Invalid Input");
            }
        }
    }

    /**
     * Retrieves the name of the President.
     *
     * @return The name of the President.
     */
    public String getName() {
        return Name;
    }
}
