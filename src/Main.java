
class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}


class Account {
    private String owner;
    private int balance;
    private String accountNumber;

    public Account(String owner, int balance, String accountNumber) {
        this.owner = owner;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }


    public String getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }


    public void transfer(int amount) throws NotEnoughMoneyException {
        if (balance < amount) {
            throw new NotEnoughMoneyException("Not enough money in the account to make the transfer");
        }
        balance -= amount;
        System.out.println("Transfer successful. Remaining balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        Account acc = new Account("Anouar Moussaid", 20000, "436638827648");

        try {
            acc.transfer(600);
        } catch (NotEnoughMoneyException e) {
            System.out.println("NotEnoughMoneyException caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected exception occurred: " + e.getMessage());
        } finally {

            System.out.println("Current balance: " + acc.getBalance());
        }
    }
}
