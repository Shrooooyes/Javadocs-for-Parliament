package Parliament;

/**
 * Represents Members in Parliament in Indian Parliament
 * @author: Shreyash Sawant
 * Roll no.: 45
 */
public class MemberOfParliament {
    private String Name;
    private String Party;

    /**
     * Constructs a new MemberOfParliament with the specified name and party affiliation.
     *
     * @param name The name of the Member of Parliament.Parliament.
     * @param Party The political party of the Member of Parliament.Parliament.
     */
    public MemberOfParliament(String name, String Party) {
        this.Name = name;
        this.Party = Party;
    }

    /**
     * Retrieves the details of the Member of Parliament.Parliament.
     *
     * @return A string containing the name and party of the Member of Parliament.Parliament.
     */
    public String getMPDetails() {
        return "Name: " + this.Name + "\nParty: " + this.Party;
    }
}
