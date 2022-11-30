import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	private static final String ACCOUNTS_FILE ="/Users/nurdanemin/Desktop/accounts.txt";
	private static final String TRANSACTIONS_FILE = "/Users/nurdanemin/Desktop/transactions.txt";
	public static void main(String[] args) {
		
		Bank bank = new Bank();
		 try{
	            ArrayList<Account> accounts = returnAccounts();
	            loadAccounts(accounts, bank);

	            ArrayList<Transaction> transactions = returnTransactions();
	            runTransactions(transactions, bank);
	            bank.deductTaxes();
	            for (Account account : accounts) {
	                System.out.println("\n\t\t\t\t\t ACCOUNT\n\n\t"+account+"\n\n");  //write accounts's initial version
	                transactionHistory(account.getId(), bank);
	            }
	            
	         } catch (FileNotFoundException e) {
	            System.out.println(e.getMessage());
	        }
		
		
		}
			
		
	public static  Account createObject(String[] values){
		switch(values[0]) {
		case "Chequing": return new Chequing(values[1], values[2], Double.parseDouble(values[3]));
		case "Loan" : return new Loan (values[1], values[2], Double.parseDouble(values[3]));
		case "Savings": return new Savings(values[1], values[2], Double.parseDouble(values[3]));
		}
		return null;
	}
	
	
	public static ArrayList<Account> returnAccounts() throws FileNotFoundException{
		FileInputStream fis = new FileInputStream(ACCOUNTS_FILE);
		Scanner scan = new Scanner(fis);
		ArrayList<Account>accounts = new ArrayList<Account>();
		while(scan.hasNextLine()) {
			accounts.add(createObject(scan.nextLine().split(",")));
		}
		scan.close();
		return accounts;	
}
	
	public static void loadAccounts(ArrayList<Account>accounts, Bank bank) {
		for (Account account:accounts) {
			bank.addAccount(account);	
		}
	}
	
	
	
	public static ArrayList<Transaction> returnTransactions() throws FileNotFoundException{
		FileInputStream fis = new FileInputStream (TRANSACTIONS_FILE);
		Scanner scan = new Scanner(fis);
		
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		while (scan.hasNextLine()) {
			String[] values = (scan.nextLine().split(","));
			transactions.add(new Transaction(Transaction.Type.valueOf(values[1]), Long.parseLong(values[0]), values[2], Double.parseDouble(values[3])));
		}
		Collections.sort(transactions);
		return transactions;
		}
	
	public static void runTransactions(ArrayList<Transaction> transactions,  Bank bank) {
		for (Transaction transaction : transactions) {
			bank.executeTransaction(transaction);
		}	
	}
	
	
	public static void transactionHistory(String id, Bank bank) {
		System.out.println("\t\t\t\t   TRANSACTION HISTORY\n\t");
		for (Transaction transaction : bank.getTransactions(id)){  //loop through all transactions belong to this id
			System.out.println("\t"+transaction+"\n");
		}
		
		System.out.println("\n\t\t\t\t\t AFTER TAX \n");
		System.out.println("\t" + bank.getAccount(id)+"\n\n\n\n");
	}
		
		
	}
