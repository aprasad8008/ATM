import java.util.function.Predicate;
import java.util.List;
import java.util.ArrayList;
/**
 * @author aprasad72
 * @version 1.0.0
 * Account class with defined methods
*/
public class Account {
    private List<Transaction> pastTransactions;
    /**
     * @param t is a List of Transaction objects
     * constructor gives instance variables assignments
     * makes pastTransactions into an ArrayList
     * initializes pastTransactions to parameter t
     */
    public Account(List<Transaction> t) {
        pastTransactions = new ArrayList<Transaction>();
        pastTransactions = t;
    }
    /**
     * Getter method for pastTransactions
     * @return pastTransactions (ArrayList of Transaction objects)
     */
    public List<Transaction> getPastTransactions() {
        return pastTransactions;
    }
    /**
     * Getter method for pastTransactions
     * @param n (int)
     * index for retrieving Transaction object from pastTransactions)
     * @return Transaction object from ArrayList
     */
    public Transaction getTransaction(int n) {
        return pastTransactions.get(n);
    }
    /**
     * a method for filtering pastTransactions
     * @param predicate (a Predicate of type Transaction)
     * used for comparison with Transaction objects in List
     * @return List of Transaction objects
     * pertain to a case where the predicate is tested true
     */
    public List<Transaction> findTransactionsByPredicate(
        Predicate<Transaction> predicate) {
        List<Transaction> temp = new ArrayList<Transaction>();
        for (int i = 0; i < pastTransactions.size(); i++) {
            if (predicate.test(pastTransactions.get(i))) {
                temp.add(pastTransactions.get(i));
            }
        }
        return temp;
    }
    /**
     * a method for filtering pastTransactions
     * @param amount (double)
     * used for comparison with Transaction objects in List
     * @return List of Transaction objects
     * case where amount field of objects is equal to amount parameter
     * uses inner class
     */
    public List<Transaction> getTransactionsByAmount(double amount) {
        class NewPredicate implements Predicate<Transaction> {
            public boolean test(Transaction t) {
                return t.getAmount() == amount;
            }
        }
        List<Transaction> temp = findTransactionsByPredicate(
            new NewPredicate());
        return temp;
    }
    /**
     * a method for filtering pastTransactions
     * @return List of Transaction objects
     * pertain to a case where type is equal to enum WITHDRAWAL
     * uses anonymous inner class
     */
    public List<Transaction> getWithdrawals() {
        return findTransactionsByPredicate(new Predicate<Transaction>() {
            public boolean test(Transaction t) {
                return t.getType().equals(TransactionType.WITHDRAWAL);
            }
        });
    }
    /**
     * a method for filtering pastTransactions
     * @return List of Transaction objects
     * pertain to a case where type is equal to enum DEPOSIT
     * uses lambda expression
     */
    public List<Transaction> getDeposits() {
        return findTransactionsByPredicate((Transaction t) ->
            t.getType().equals(TransactionType.DEPOSIT));
    }
     /**
     * a method for filtering pastTransactions
     * @return List of Transaction objects
     * pertain to a case where the comment is not empty
     * uses lambda expression
     */
    public List<Transaction> getTransactionsWithComment() {
        return findTransactionsByPredicate((Transaction t) -> t.hasComment());
    }
    /**
     * a method for filtering pastTransactions
     * @param length (int)
     * used for comparison with Transaction objects in List
     * @return List of Transaction objects
     * case where comment length is greater than parameter length
     * uses anonymous inner class
     */
    public List<Transaction> getTransactionsWithCommentLongerThan(int length) {
        return findTransactionsByPredicate(new Predicate<Transaction>() {
            public boolean test(Transaction t) {
                if (t.hasComment()) {
                    String temp = t.getComment().get();
                    return temp.length() > length;
                }
                return false;
            }
        });
    }
}
