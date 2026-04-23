package Banking_Project_Spandan;


import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
//bank class


class Bank {
    final String name;
    final String password;
    final String accNumber;
    String accType="deposit";
    private double bankBalance=0;



    Bank(String username, String password, String accNumber){
        this.name=username;
        this.password=password;
        this.accNumber=accNumber;

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
        if((amount>0 && amount <=bankBalance)&&(tempBalance>=1000)){
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
        System.out.printf("Account Number: %s\n",this.accNumber);
        System.out.printf("Account Type: %s\n",this.accType);
        System.out.printf("Current Balance: %.2f\n",this.bankBalance);
    }
}




//main class
public class Main {
    public static void main (String[]args){
        Scanner sc= new Scanner(System.in);
        boolean isRunning=true;
        System.out.println("*********************");
        System.out.println("Welcome to PGSR Bank");
        System.out.println("*********************");
        HashMap<String, String> users = new HashMap<>();
        do{
            try {
                String name;
                String username;
                String password;
                String accType;
                String accNumber;

                System.out.println("*********************");
                System.out.println("AUTHENTICATION MENU: ");
                System.out.println("1) Create Account");
                System.out.println("2) Login");
                System.out.println("3) Exit");
                System.out.println("*********************");
                System.out.print("Enter your choice: ");
                int userChoice;
                userChoice = sc.nextInt();

                switch (userChoice) {
                    case 1:
                        sc.nextLine();
                        System.out.println("*********************");
                        System.out.print("Enter Name: ");
                        name = sc.nextLine();
                        username= name.toLowerCase().trim();
                        System.out.print("Enter password: ");
                        password = sc.nextLine();
                        System.out.println("*********************");

                        users.put(username, password);

                        System.out.println("Account created!");
                        break;

                    case 2:
                        boolean userActive=true;
                        boolean login=false;
                        Bank user=null;
                        sc.nextLine();
                        System.out.println("*********************");
                        System.out.print("Enter Name: ");
                        name = sc.nextLine();

                        System.out.print("Enter password: ");
                        password = sc.nextLine();
                        System.out.print("Enter Account Number: ");
                        accNumber=sc.nextLine();
                        System.out.println("*********************");
                        username=name.toLowerCase().trim();
                        for(String key: users.keySet()){
                            if(username.equals(key) && password.equals(users.get(key))){
                                user = new Bank(name,users.get(key),accNumber);
                                login=true;
                            }
                        }
                        if(login) {
                            System.out.println("Login Successfull!");
                            do {
                                //user menu
                                System.out.println("*********************");
                                System.out.println("USER MENU: ");
                                System.out.println("1) Check Balance");
                                System.out.println("2) Deposit");
                                System.out.println("3) Withdraw");
                                System.out.println("4) Change Account Type");
                                System.out.println("5) View Account Details");
                                System.out.println("6) Log-Out");
                                System.out.println("*********************");
                                System.out.print("Enter your choice: ");
                                int userChoice2 = sc.nextInt();
                                switch (userChoice2) {
                                    case 1:
                                        System.out.printf("Name: %s\n", user.name);
                                        System.out.printf("Current Balance: ₹%.2f\n", user.checkBalance());
                                        break;

                                    case 2:
                                        double amount;
                                        System.out.print("Enter amount to deposit: ₹");
                                        amount = sc.nextInt();
                                        user.deposit(amount);
                                        break;

                                    case 3:
                                        System.out.print("Enter amount to withdraw: ₹");
                                        amount = sc.nextInt();
                                        user.withdraw(amount);
                                        break;

                                    case 4:
                                        System.out.println("Select your Account Type: ");
                                        sc.nextLine();
                                        accType = sc.nextLine();
                                        user.changeAccountType(accType);
                                        break;

                                    case 5:
                                        System.out.println("Account Details: ");
                                        user.showAccount();
                                        break;

                                    case 6:
                                        System.out.println("Logged Out Successfully!");
                                        System.out.println("*********************");
                                        userActive = false;
                                        break;

                                    default:
                                        System.out.println("Invalid user choice!");

                                }
                            } while (userActive);
                        }else{
                            System.out.println("Login Failed...Try Again!");
                        }

                        break;

                    case 3:
                        System.out.println("*********************");
                        System.out.println("Exiting....");
                        System.out.println("*********************");
                        isRunning=false;
                        break;


                    default:
                        System.out.println("Invalid User Choice!");

                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input!");
                sc.nextLine();
            }
        }while(isRunning);
        System.out.println("Thanks for using PGSR Banking System!");
    }
}