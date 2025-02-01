public class CurrentAccount extends Account{
    Double interestRate=0.02;

    @Override
    public double calculateInterest(){
        return accountBalance*interestRate;
    }

    public double addInterestToAccount(){
        return addMoney(calculateInterest());
    }
}
