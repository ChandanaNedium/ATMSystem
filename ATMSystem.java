package task3;

import java.util.Scanner;

public class ATMSystem {

    static double balance = 10000;
    static String transactionHistory = "";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int userId = 1202;
        int userPin = 1234;

        System.out.println("===== ATM LOGIN =====");

        System.out.print("Enter User ID: ");
        int id = sc.nextInt();

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        if(id == userId && pin == userPin) {

            while(true) {

                System.out.println("\n===== ATM MENU =====");
                System.out.println("1. Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");

                System.out.print("Enter Choice: ");
                int choice = sc.nextInt();

                switch(choice) {

                    case 1:
                        if(transactionHistory.equals("")) {
                            System.out.println("No Transactions Yet.");
                        } else {
                            System.out.println(transactionHistory);
                        }
                        break;

                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdraw = sc.nextDouble();

                        if(withdraw <= balance) {
                            balance -= withdraw;
                            transactionHistory += "Withdraw: " + withdraw + "\n";
                            System.out.println("Please collect your cash.");
                        } else {
                            System.out.println("Insufficient Balance!");
                        }
                        break;

                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        double deposit = sc.nextDouble();

                        balance += deposit;
                        transactionHistory += "Deposit: " + deposit + "\n";
                        System.out.println("Amount Deposited Successfully.");
                        break;

                    case 4:
                        System.out.print("Enter Account Number: ");
                        int acc = sc.nextInt();

                        System.out.print("Enter amount to transfer: ");
                        double transfer = sc.nextDouble();

                        if(transfer <= balance) {
                            balance -= transfer;
                            transactionHistory += "Transfer to " + acc + ": " + transfer + "\n";
                            System.out.println("Transfer Successful.");
                        } else {
                            System.out.println("Insufficient Balance!");
                        }
                        break;

                    case 5:
                        System.out.println("Thank You for Using ATM!");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice!");
                }
            }

        } else {
            System.out.println("Invalid User ID or PIN");
        }

        sc.close();
    }
}
