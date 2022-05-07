class Bank {
    long[] balance;
    int n;
    public Bank(long[] balance) {
        this.balance=balance;
        this.n=balance.length;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(!check(account1,money)){
            return false;
        }
        if(!check(account2)){
            return false;
        }
        balance[account1-1]-=money;
        balance[account2-1]+=money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(!check(account)){
            return false;
        }
        balance[account-1]+=money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(!check(account,money)){
            return false;
        }
        balance[account-1]-=money;
        return true;
    }
    
    private boolean check(int acc,long amt){
        if(!check(acc)){
            return false;
        }
        return balance[acc-1]>=amt;
    }
    
    private boolean check(int acc){
        return acc>0 && acc<=n;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */