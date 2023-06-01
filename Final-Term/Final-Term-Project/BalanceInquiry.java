public class BalanceInquiry extends ATMMachine{
    public static double balances;
    public void setBalance(double bal){
        balances=bal;
    }
    public static double getBalance(){
        return balances;
    }
}