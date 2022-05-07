class Bank {
        final long[] accounts;
 
        public Bank(long[] balance) {accounts = balance;}
 
        public boolean transfer(int i1, int i2, long money) {
            if (i2 <= accounts.length && withdraw(i1, money))
                return deposit(i2, money);
            else return false;
        }
 
        public boolean deposit(int i, long money) {
            if (i <= accounts.length) {
                accounts[i - 1] += money;
                return true;
            } else return false;
        }
 
        public boolean withdraw(int i, long money) {
            if (i <= accounts.length && accounts[i - 1] >= money) {
                accounts[i - 1] -= money;
                return true;
            } else return false;
        }
    }
 


/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */