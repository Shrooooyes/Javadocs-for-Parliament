package Parliament;

/**
 * Represent Rajyasabha in Indian Parliament
 * @author: Shreyash Sawant
 * Roll no.: 45
 */
class RajyaSabha implements INTFParliament {
    private Chairman chairman;
    private MemberOfParliament[] members;
    private int counter = 0;
    private boolean makeLaw;

    /**
     * Constructs a new RajyaSabha with the specified Chairman.
     *
     * @param chairman The {@link Chairman} who will preside over the Rajya Sabha.
     */
    public RajyaSabha(Chairman chairman) {
        this.chairman = chairman;
        members = new MemberOfParliament[250];
    }

    /**
     * Elects leaders within the Rajya Sabha.
     */
    @Override
    public void electLeaders() {
        System.out.println("Rajya Sabha is electing members...");
    }

    /**
     * Passes the specified bill in the Rajya Sabha.
     *
     * @param bill The {@link Bill} object representing the bill to be passed.
     */
    @Override
    public void passBill(Bill bill) {
        System.out.println("Rajya Sabha is passing bill :\n" + bill.getBill());
        this.makeLaw = true;
    }

    /**
     * Adds a Member of Parliament.Parliament to the Rajya Sabha.
     *
     * @param member The {@link MemberOfParliament} to be added.
     */
    public void addMember(MemberOfParliament member) {
        if (counter < 250) {   
            members[counter] = member;
            counter++;
            System.out.println("Member: " + member.getMPDetails() + " added to Rajya Sabha...");
        } else {
            System.out.println("Rajya Sabha is full...");
        }
    }

    /**
     * Rejects the current bill.
     */
    public void rejectBill() {
        this.makeLaw = false;
        System.out.println("Bill rejected....\n");
    }

    /**
     * Retrieves the status of the law-making process.
     *
     * @return {@code true} if a bill has been passed and is in the process of becoming law; {@code false} otherwise.
     */
    public boolean get_makeLawStatus() {
        return this.makeLaw;
    }

    /**
     * Retrieves the details of the Chairman.
     *
     * @return A string containing the details of the Chairman.
     */
    public String getChairman() {
        String sp = this.chairman.getMPDetails();
        return sp;
    } 

    /**
     * Retrieves the list of Members of Parliament.Parliament in the Rajya Sabha.
     *
     * @return An array of {@link MemberOfParliament} objects representing the MPs in the Rajya Sabha.
     */
    public MemberOfParliament[] getMPsRajyaSabha() {
        return this.members;
    }
}
