import java.text.DecimalFormat;

public class BankAccount {
    private static int counter = 1;

    private final int id;
    private String ownerName;
    private Currency currency;
    private double sold = 0.0;

    DecimalFormat numberFormat = new DecimalFormat("#.000");

    public BankAccount(Currency currency, double sold, String ownerName) {
        this.ownerName = ownerName;
        id = counter;
        counter++;
        this.currency = currency;
        this.sold = sold;
    }


    public void withdrawMoney(double sum) {
        if (sum <= this.sold) {
            System.out.println("You can withdraw: " + sum + this.currency.name());
            this.sold = this.sold - sum;
        } else {
            System.out.println("Insufficient funds. Please choose an amount properly.");
        }
    }
    public void withdrawMoney(double sum, Currency currency) {
        double sumInit = sum;
        switch (currency) {
            case EUR: sum = sum * currency.getCurrency(); break;
            case RON: sum = sum * currency.getCurrency(); break;
            case YEN: sum = sum * currency.getCurrency(); break;
            default: sum = sum; break;
        }
        if (sum <= this.sold) {
            System.out.println("You can withdraw: " + numberFormat.format(sum) + " " + this.currency.name() + "(" + sumInit + " " + currency.name() + ")");
            this.sold = this.sold - sum;
        } else {
            System.out.println("Insufficient funds. Please choose an amount properly.");
        }

    }
    public void depositMoney(double sum) {
        System.out.println("You deposited " + numberFormat.format(sum) + " " + this.currency.name());
        this.sold = this.sold + sum;

    }

    public void depositMoney(double sum, Currency currency) {
        double sumInit = sum;
        switch (currency) {
            case EUR: sum = sum * currency.getCurrency(); break;
            case RON: sum = sum * currency.getCurrency(); break;
            case YEN: sum = sum * currency.getCurrency(); break;
            default: sum = sum; break;
        }
        System.out.println("You deposited " + sum + " " + this.currency.name() + "(" + sumInit + " " + currency.name() + ")");
        this.sold = this.sold + sum;
    }

    public int getId() {
        return id;
    }


    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", ownerName=" + ownerName +
                ", sold=" + numberFormat.format(sold) +
                " " + currency +
                '}';
    }
}
