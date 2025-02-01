public class SavingsAccount extends Account{
    Double interestRate=0.08;

    @Override
    public double calculateInterest(){
        return accountBalance*interesRate;
    }

    public double addInterestToAccount(){
        return addMoney(calculateInterest());
    }
}
