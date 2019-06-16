public class Main {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount(Currency.USD,100.0,"Vasile", "4388576018402626");
        BankAccount b2 = new BankAccount(Currency.USD,1000.0,"Nicu", "48902");
        BankAccount b3 = new BankAccount(Currency.USD,50.4,"Andreea", "358576018402626");
        BankAccount b4 = new BankAccount(Currency.USD,0,"Ion", "4388576018402621");

        b1.verifyCreditCard(b1.getCreditCardNumber());
        System.out.println("*********");
        b2.verifyCreditCard(b2.getCreditCardNumber());
        System.out.println("*********");
        b3.verifyCreditCard(b3.getCreditCardNumber());
        System.out.println("*********");
        b4.verifyCreditCard(b4.getCreditCardNumber());
        System.out.println("*********");

        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(b3.toString());

        System.out.println(b1.getId());
        System.out.println(b2.getId());
        System.out.println(b3.getId());

        b1.withdrawMoney(140.8);
        b1.depositMoney(100);
        b1.withdrawMoney(140.8);
        b2.depositMoney(1200, Currency.EUR);
        b3.withdrawMoney(20, Currency.RON);

        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(b3.toString());
        System.out.println(b4.toString());

        Bank.BANK.registerBannkAccount(b1);
        Bank.BANK.registerBannkAccount(b2);
        Bank.BANK.registerBannkAccount(b3);
        Bank.BANK.deleteBankAccount(b4);
        Bank.BANK.deleteBankAccount(b2);
        Bank.BANK.deleteBankAccount(b2);
        Bank.BANK.registerBannkAccount(b4);
        System.out.println(b4.getId());

        System.out.println("Number of accounts is: " + Bank.BANK.getNumberOfTotalAccounts());
    }
}
