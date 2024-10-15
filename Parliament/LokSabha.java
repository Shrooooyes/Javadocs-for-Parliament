package Parliament;

/**
 * Represents Loksabha in Indian Parliament
 *
 * @author: Shreyash Sawant
 * Roll no.: 45
 */
class LokSabha implements INTFParliament {
    private Speaker speaker;
    private MemberOfParliament[] members;
    private boolean makeLaw;
    private int counter = 0;

    /**
     * Constructs a new LokSabha with the specified Speaker.
     *
     * @param speaker The {@link Speaker} who will preside over the Lok Sabha.
     */
    public LokSabha(Speaker speaker) {
        System.out.println("Lok Sabha created....");
        this.speaker = speaker;
        members = new MemberOfParliament[543];
    }

    /**
     * Elects leaders within the Lok Sabha.
     */
    @Override
    public void electLeaders() {
        System.out.println("Lok Sabha is electing members...");
    }

    /**
     * Passes the specified bill in the Lok Sabha.
     *
     * @param bill The {@link Bill} object representing the bill to be passed.
     */
    @Override
    public void passBill(Bill bill) {
        System.out.println("Lok Sabha is passing bill :\n" + bill.getBill());
        this.makeLaw = true;
    }

    /**
     * Adds a Member of Parliament.Parliament to the Lok Sabha.
     *
     * @param member The {@link MemberOfParliament} to be added.
     */
    public void addMember(MemberOfParliament member) {
        if (counter < 543) {   
            members[counter] = member;
            counter++;
            System.out.println(members[counter - 1].getMPDetails() + " added to Lok Sabha...");
        } else {
            System.out.println("Lok Sabha is full...");
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
     * Retrieves the details of the Speaker.
     *
     * @return A string containing the details of the Speaker.
     */
    public String getSpeaker() {
        String sp = this.speaker.getMPDetails();
        return sp;
    } 

    /**
     * Retrieves the list of Members of Parliament.Parliament in the Lok Sabha.
     *
     * @return An array of {@link MemberOfParliament} objects representing the MPs in the Lok Sabha.
     */
    public MemberOfParliament[] getMPsLokSabha() {
        return this.members;
    }
}
