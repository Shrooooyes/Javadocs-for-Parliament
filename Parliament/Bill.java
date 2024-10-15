package Parliament;

/**
 * Represents Bill in Indian Parliament
 * @author: Shreyash Sawant
 * Roll no.: 45
 */
public class Bill {
    private String billId;
    private String title;
    private String description;
    private boolean loksabhaPass;
    private boolean rajyasabhaPass;

    /**
     * Constructs a new Bill with the specified ID, title, and description.
     *
     * @param billID The unique identifier for the bill.
     * @param title The title of the bill.
     * @param description A brief description of the bill.
     */
    public Bill(String billID, String title, String description) {
        this.billId = billID;
        this.title = title;
        this.description = description;
    }

    /**
     * Sets whether the bill has passed in the Lok Sabha.
     *
     * @param loksabhaPass {@code true} if the bill has passed in the Lok Sabha; {@code false} otherwise.
     */
    public void billLokSabha(boolean loksabhaPass) {
        this.loksabhaPass = loksabhaPass;
    }

    /**
     * Sets whether the bill has passed in the Rajya Sabha.
     *
     * @param rajyasabhaPass {@code true} if the bill has passed in the Rajya Sabha; {@code false} otherwise.
     */
    public void billRajyaSabha(boolean rajyasabhaPass) {
        this.rajyasabhaPass = rajyasabhaPass;
    }

    /**
     * Determines if the bill can be passed based on its status in both houses.
     *
     * @return {@code true} if the bill has passed in both the Lok Sabha and Rajya Sabha; {@code false} otherwise.
     */
    public boolean billCanBePassed() {
        return this.loksabhaPass && this.rajyasabhaPass;
    }

    /**
     * Gets the unique identifier of the bill.
     *
     * @return The bill ID.
     */
    public String getBillID() {
        return this.billId;
    }

    /**
     * Provides a string representation of the bill, including its ID, title, and description.
     *
     * @return A formatted string containing the bill ID, title (in uppercase), and description.
     */
    public String getBill() {
        return this.billId + "\n" + this.title.toUpperCase() + "\n" + this.description;
    }
}
