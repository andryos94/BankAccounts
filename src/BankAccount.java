import java.text.DecimalFormat;

public class BankAccount {
    private static int counter = 1;
    private String creditCardNumber;
    private final int id;
    private String ownerName;
    private Currency currency;
    private double sold = 0.0;

    DecimalFormat numberFormat = new DecimalFormat("#.000");

    public BankAccount(Currency currency, double sold, String ownerName, String creditCardNumber) {
        this.ownerName = ownerName;
        id = counter;
        counter++;
        this.currency = currency;
        this.sold = sold;
        this.creditCardNumber = creditCardNumber;
    }

    public boolean verifyCreditCard(String creditCardNumber){
        this.creditCardNumber = creditCardNumber;
        char[] creditCardNumberarray = creditCardNumber.toCharArray();
        boolean b = false;
        if (creditCardNumberarray.length >= 13 && creditCardNumberarray.length <=16){
            switch (creditCardNumberarray[0]){
                case '4': System.out.println("You use a Visa card"); b = true; break;
                case '5': System.out.println("You use a Master card"); b = true; break;
                case '3': if (creditCardNumberarray[1] == '7') {
                    System.out.println("You use an Amerrican Express card"); b = true; break;
                } else {
                    System.out.println("The second digit is incorrect"); break;
                }
                case '6': System.out.println("You use a Discover card"); b = true; break;
                default: System.out.println("Your credit card number should start with 4, 5, 37 or 6"); break;
            }
        } else {
            System.out.println("Please insert a valid credit card");
            return b;
        }
        char arrayReversed[] = new char[creditCardNumberarray.length];
        if (b == true) {
            for (int i = creditCardNumberarray.length - 1, j = 0; i >=0 && j < arrayReversed.length; i--, j++ ){
                arrayReversed[j] = creditCardNumberarray[i];
            }
            System.out.println(arrayReversed);
            int s, sum1 = 0, sum2 = 0;
            for (int k = 0; k < arrayReversed.length; k++) {
                int digit = Character.getNumericValue(arrayReversed[k]);
                if(k%2 != 0) {
                    int prod = digit * 2;
                    if (prod >= 10){
                        s = (prod/10) + (prod%10);
                    } else {
                        s = prod;
                    }
                    sum1 += s;
                } else {
                    sum2 += digit;
                }

            }
            System.out.println(sum1);
            System.out.println(sum2);

            double total = sum1 + sum2;
            if (total%10 == 0){
                System.out.println("The credit card is valid");
            } else {
                System.out.println("The credit card is invalid");
            }

        }
        return b;
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
            case USD: withdrawMoney(sum); break;
            case RON: sum = sum * currency.getCurrency(); break;
            case YEN: sum = sum * currency.getCurrency(); break;
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
            case USD: withdrawMoney(sum); break;
            case RON: sum = sum * currency.getCurrency(); break;
            case YEN: sum = sum * currency.getCurrency(); break;

        }
        System.out.println("You deposited " + sum + " " + this.currency.name() + "(" + sumInit + " " + currency.name() + ")");
        this.sold = this.sold + sum;
    }

    public int getId() {
        return id;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
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
