public class Run {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount();
        sa.addMoney(100);
        sa.showBalance();
        System.out.println(sa.calculateInterest());
        sa.addInterestToAccount();
        sa.showBalance();

        CurrentAccount ca = new CurrentAccount();
        ca.addMoney(100);
        ca.showBalance();
        System.out.println(ca.calculateInterest());
        ca.addInterestToAccount();
        ca.showBalance();
    }
}
