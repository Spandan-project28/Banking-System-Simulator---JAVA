package Banking_Project_Spandan;

public class Bank {
    String name;
    final String password;
    String accType="deposit";
    private double bankBalance=0;
    final double minimumBaalance=10000;
    Bank(String username, String password){
        this.name=username;
        this.password=password;

    }

    public double checkBalance(){
        return bankBalance;
    }

    public void deposit(double amount){
        bankBalance+=amount;
        System.out.printf("Successfully deposited amount ₹%.2f\n", amount);
    }

    public void withdraw(double amount){
        double tempBalance=bankBalance-amount;
        if((amount>0 && amount <=bankBalance)&&(tempBalance>=10000)){
            bankBalance-=amount;
            System.out.printf("Successfully withdrawn amount ₹%.2f\n", amount);
        }
        else{
            System.out.println("Invalid withdrawl!");
        }
    }

    public void changeAccountType(String accType){
        this.accType=accType;
    }

    public void showAccount(){
        System.out.printf("Name: %s\n",this.name);
        System.out.printf("Account Type: %s\n",this.accType);
        System.out.printf("Current Balance: %.2f\n",this.bankBalance);
    }
}
