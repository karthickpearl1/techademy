class Account{
    double interesRate;
    double interestBalance;
    double accountBalance;
    public Account(){
        interesRate=0.05;
        interestBalance=0;
        accountBalance=0;
    }

    public double addMoney(double value){
        return accountBalance+=value;
    }
public double calculateInterest(){
    return accountBalance*interesRate;
}

public double addInterestToAccount(){
    return addMoney(calculateInterest());
}

public void showBalance(){
    System.out.println("Balance:" + accountBalance);
}

}