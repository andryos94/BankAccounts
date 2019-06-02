public enum Bank {
    BANK;

    private int counter = 0;

    private BankAccount[] accounts = new BankAccount[2];

    void registerBannkAccount(BankAccount account) {
        if (counter + 1 > accounts.length) {
            dubleazaArray();
        }
        System.out.println("A bank account was registered " + account.getId());
        accounts[counter] = account;
        counter++;
        System.out.println(counter);
    }
    private void dubleazaArray() {
        BankAccount[] nouArray = new BankAccount[accounts.length * 2];

        for (int i = 0; i < accounts.length; i++) {
            nouArray[i] = accounts[i];
        }
        accounts = nouArray;

    }
    void deleteBankAccount(BankAccount account) {
        int i = findIdBankAccount(account);
        if (i == -1) {
            System.out.println("This account doesn't exist " + account.getId());
            return;
        }
        for (int j = i; j < counter - 1; j++) {
            accounts[j] = accounts[j + 1];
        }
        System.out.println("A bank account was deleted " + account.getId());
        accounts[counter - 1] = null;
        counter--;

        System.out.println(counter);
    }

    public int findIdBankAccount(BankAccount account) {
        for (int i = 0; i < counter; i++) {
            if (account.getId() == accounts[i].getId()) {
                return i;
            }
        }
        return -1;
    }

    int getNumberOfTotalAccounts(){
        return counter;
    }
}
