import java.util.Optional;
/**
 * @author aprasad72
 * @version 1.0.0
 * Transaction class with defined methods
*/
public class Transaction {

    private TransactionType type;
    private double amount;
    private Optional<String> comment;
    /**
     * @param type (TransactionType)
     * enum (either withdrawals or deposits)
     * @param amount (double)
     * sets amount for Transaction object field
     * constructor gives instance variables assignments
     * sets comment to an empty Optional
     */
    public Transaction(TransactionType type, double amount) {
        this.type = type;
        this.amount = amount;
        comment = Optional.empty();
    }
    /**
     * @param type (TransactionType)
     * enum (either withdrawals or deposits)
     * @param amount (double)
     * sets amount for Transaction object field
     * @param value (String)
     * sets comment to String parameter (with check on null inputs)
     * constructor gives instance variables assignments
     */
    public Transaction(TransactionType type, double amount, String value) {
        this.type = type;
        this.amount = amount;
        comment = Optional.ofNullable(value);
    }
    /**
     * Getter method for type field
     * @return type field (TransactionType enum (withdrawals or deposits))
     */
    public TransactionType getType() {
        return this.type;
    }
    /**
     * Getter method for amount field
     * @return amount (double)
     */
    public double getAmount() {
        return this.amount;
    }
    /**
     * Getter method for comment field
     * @return comment (Optional of type String)
     */
    public Optional<String> getComment() {
        return this.comment;
    }
    /**
     * @return boolean (true or false)
     * if comment is present returns true or false if not
     */
    public boolean hasComment() {
        if (comment.isPresent()) {
            return true;
        }
        return false;
    }
}
