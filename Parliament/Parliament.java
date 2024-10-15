package Parliament;

import java.util.Scanner;

/**
 * Main File for working with all bodies
 *
 * @author: Shreyash Sawant
 * Roll no.: 45
 */
public class Parliament {

    private LokSabha loksabha = null;
    private RajyaSabha rajyaSabha = null;
    private President president = null;
    private Bill[] bills = new Bill[50];
    private int billCount = 0;

    /**
     * Creates a LokSabha with a new Speaker.
     * Prompts user for the Speaker's name and party affiliation.
     */
    public void createLoksabha() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Speaker Name: ");
        String speakerName = sc.nextLine();
        System.out.println("Enter Speaker Party: ");
        String speakerParty = sc.nextLine();

        loksabha = new LokSabha(new Speaker(speakerName, speakerParty));
        // sc.close();
    }

    /**
     * Creates a RajyaSabha with a new Chairman.
     * Prompts user for the Chairman's name and party affiliation.
     */
    public void createRasabha() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Chairman Name: ");
        String chairmanName = sc.nextLine();
        System.out.println("Enter Chairman Party: ");
        String chairmanParty = sc.nextLine();

        rajyaSabha = new RajyaSabha(new Chairman(chairmanName, chairmanParty));
        // sc.close();
    }

    /**
     * Elects a President.
     * Prompts user for the President's name.
     */
    public void electPresident() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter President Name: ");
        String presidentName = sc.nextLine();

        president = new President(presidentName);
        // sc.close();
    }

    /**
     * Adds a Member of Parliament.Parliament to the Lok Sabha.
     * Prompts user for the member's name and party affiliation.
     */
    public void addLokSabhaMembers() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Member's Name");
        String memberName = sc.nextLine();
        System.out.println("Enter Member's Party");
        String memberParty = sc.nextLine();

        MemberOfParliament member = new MemberOfParliament(memberName, memberParty);
        loksabha.addMember(member);
        // sc.close();
    }

    /**
     * Adds a Member of Parliament.Parliament to the Rajya Sabha.
     * Prompts user for the member's name and party affiliation.
     */
    public void addRajyaSabhaMembers() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Member's Name");
        String memberName = sc.nextLine();
        System.out.println("Enter Member's Party");
        String memberParty = sc.nextLine();

        MemberOfParliament member = new MemberOfParliament(memberName, memberParty);
        rajyaSabha.addMember(member);
        // sc.close();
    }

    /**
     * Processes a bill through the Lok Sabha and Rajya Sabha.
     * Prompts user for bill details and whether the bill should be passed by each house.
     */
    public void loksabhaPassBill() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Bill ID: ");
        String billId = sc.nextLine();
        System.out.println("Enter Bill Title: ");
        String billTitle = sc.nextLine();
        System.out.println("Enter Bill Description: ");
        String billDescription = sc.nextLine();

        Bill bill = new Bill(billId, billTitle, billDescription);
        bill.billLokSabha(true);

        // Edit Here
        if (billCount < bills.length) {
            bills[billCount] = bill;
            billCount++;
            loksabha.passBill(bill);

            while (true) {
                System.out.println("\n\nDoes Rajya Sabha want to pass the bill?");
                String passLaw = sc.nextLine();
                if (passLaw.equalsIgnoreCase("yes")) {
                    System.out.println("Bill: \n" + bill.getBill() + "\npassed by both parties...");
                    bill.billRajyaSabha(true);
                    break;
                } else if (passLaw.equalsIgnoreCase("no")) {
                    System.out.println("\nRajya Sabha doesn't want to pass the bill...\n");
                    bill.billRajyaSabha(false);
                    break;
                } else {
                    System.out.println("Invalid Input");
                }
            }
        } else {
            System.out.println("50 Bills are pending....");
        }
        // sc.close();
    }

    /**
     * Processes a bill through the Rajya Sabha and Lok Sabha.
     * Prompts user for bill details and whether the bill should be passed by each house.
     */
    public void rajyasabhaPassBill() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Bill ID: ");
        String billId = sc.nextLine();
        System.out.println("Enter Bill Title: ");
        String billTitle = sc.nextLine();
        System.out.println("Enter Bill Description: ");
        String billDescription = sc.nextLine();

        Bill bill = new Bill(billId, billTitle, billDescription);
        bill.billRajyaSabha(true);

        if (billCount < bills.length) {
            bills[billCount] = bill;
            billCount++;
            rajyaSabha.passBill(bill);

            while (true) {
                System.out.println("\n\nDoes Lok Sabha want to pass the bill?");
                String passLaw = sc.nextLine();
                if (passLaw.equalsIgnoreCase("yes")) {
                    System.out.println("Bill: \n" + bill.getBill() + "\npassed by both parties...");
                    bill.billLokSabha(true);
                    break;
                } else if (passLaw.equalsIgnoreCase("no")) {
                    System.out.println("\nLok Sabha doesn't want to pass the bill...\n");
                    bill.billLokSabha(false);
                    break;
                } else {
                    System.out.println("Invalid Input");
                }
            }
        } else {
            System.out.println("50 Bills are pending....");
        }
        // sc.close();
    }

    /**
     * Allows the President to pass a bill into law.
     * Prompts user for the bill ID and determines if the bill can be passed.
     */
    public void presidentPassBill() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Bill ID");
        String billId = sc.nextLine();
        Bill thisBill = null;

        for (Bill billObject : bills) {
            if (billObject != null && billObject.getBillID().equalsIgnoreCase(billId)) {
                thisBill = billObject;
                break;
            }
        }

        if (thisBill != null) {    
            if (thisBill.billCanBePassed()) {
                president.makeLaw(thisBill);
            } else {
                System.out.println("Bill cannot be passed...");
            }
        } else {
            System.out.println("Bill not found...");
        }
    }

    /**
     * Displays the details of the Lok Sabha, including its Speaker and members.
     */
    public void displayLokSabha() {
        System.out.println("Lok Sabha: ");
        System.out.println("Speaker: " + loksabha.getSpeaker());

        System.out.println("Members of Lok Sabha:");

        MemberOfParliament[] members = loksabha.getMPsLokSabha();
        int i = 0;
        for (MemberOfParliament member : members) {
            if (member != null) {
                System.out.println(i + ". " + member.getMPDetails());
                i++;
            }
        }
    }

    /**
     * Displays the details of the Rajya Sabha, including its Chairman and members.
     */
    public void displayRajyaSabha() {
        System.out.println("Rajya Sabha: ");
        System.out.println("Chairman: " + rajyaSabha.getChairman());

        System.out.println("Members of Rajya Sabha:");

        MemberOfParliament[] members = rajyaSabha.getMPsRajyaSabha();
        int i = 0;
        for (MemberOfParliament member : members) {
            if (member != null) {
                System.out.println(i + ". " + member.getMPDetails());
                i++;
            }
        }
    }

    /**
     * Displays the details of the President.
     */
    public void displayPresident() {
        System.out.println("President: " + president.getName());
    }

    /**
     * Displays the list of bills.
     */
    public void displayBills() {
        System.out.println("Bills: ");
        for (Bill billObject : bills) {
            if (billObject != null) {
                System.out.println(billObject.getBill());
            }
        }
    }

    /**
     * Main method to run the Parliament.Parliament system.
     * Provides a menu for the user to interact with the system.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parliament parliament = new Parliament();

        int input;
        do { 
            System.out.println("\n\nEnter Option");
            System.out.println("1. Create Lok Sabha");
            System.out.println("2. Create Rajya Sabha");
            System.out.println("3. Elect President");
            System.out.println("4. Add Lok Sabha members");
            System.out.println("5. Add Rajya Sabha members");
            System.out.println("6. Pass bill by Lok Sabha");
            System.out.println("7. Pass bill by Rajya Sabha");
            System.out.println("8. Pass Bill to Law by President");
            System.out.println("9. Display Lok Sabha");
            System.out.println("10. Display Rajya Sabha");
            System.out.println("11. Display President");
            System.out.println("12. Display Bills");
            System.out.println("13. Exit");

            System.out.println("\n\nEnter Your Choice: ");
            input = Integer.parseInt(scanner.nextLine());

            if (input == 13) {
                System.out.println("Thank you for using the Parliament.Parliament System");
                break;
            }

            switch (input) {
                case 1:
                    parliament.createLoksabha();
                    break;
                case 2:
                    parliament.createRasabha();
                    break;
                case 3:
                    parliament.electPresident();
                    break;
                case 4:
                    if (parliament.loksabha != null) {
                        parliament.addLokSabhaMembers();
                        break;
                    }
                    System.out.println("Create Lok Sabha to Add Members...");
                    break;
                case 5:
                    if (parliament.rajyaSabha != null) {
                        parliament.addRajyaSabhaMembers();
                        break;
                    }
                    System.out.println("Create Rajya Sabha to Add Members...");
                    break;
                case 6:
                    if (parliament.loksabha != null) {
                        parliament.loksabhaPassBill();
                        break;
                    }
                    System.out.println("Create Lok Sabha to pass bill...");
                    break;
                case 7:
                    if (parliament.rajyaSabha != null) {
                        parliament.rajyasabhaPassBill();
                        break;
                    }
                    System.out.println("Create Rajya Sabha to pass bill...");
                    break;
                case 8:
                    if (parliament.loksabha != null && parliament.rajyaSabha != null && parliament.billCount != 0) {
                        parliament.presidentPassBill();
                        break;
                    }
                    System.out.println("Legislative bodies not properly defined...");
                    break;
                case 9:
                    if (parliament.loksabha != null) {
                        parliament.displayLokSabha();
                        break;
                    }
                    System.out.println("Create Lok Sabha...");
                    break;
                case 10:
                    if (parliament.rajyaSabha != null) {
                        parliament.displayRajyaSabha();
                        break;
                    }
                    System.out.println("Create Rajya Sabha...");
                    break;
                case 11:
                    if (parliament.president != null) {
                        parliament.displayPresident();
                        break;
                    }
                    System.out.println("Elect President...");
                    break;
                case 12:
                    if (parliament.billCount == 0) {
                        System.out.println("No bills to display...");
                        break;
                    }
                    parliament.displayBills();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        } while (input != 13);

        scanner.close();
    }
}
