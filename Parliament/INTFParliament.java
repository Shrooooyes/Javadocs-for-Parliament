package Parliament;

/**
 * Provide Interface for Parliament Bodies
 * @author: Shreyash Sawant
 * Roll no.: 45
 * title: Implementation of Parliament.Parliament
 * descp: Interface for Parliament.Parliament entities.
 */
interface INTFParliament {

    /**
     * Elects leaders within the parliament.
     */
    void electLeaders();

    /**
     * Passes the specified bill through the parliament.
     *
     * @param bill The {@link Bill} object representing the bill to be passed.
     */
    void passBill(Bill bill);
}
