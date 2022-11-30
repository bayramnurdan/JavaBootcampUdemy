import java.text.DecimalFormat;

	public abstract class Account {
		private String id;
		private String name;
		private double balance;
		
		public Account(String id, String name, double balance) {
			if (id==null || id.isBlank() || name==null || name.isBlank()) {
				throw new IllegalArgumentException("INVALID PARAMS");
			}
			this.id = id;
			this.name = name;
			this.balance =balance;
		}
		
		public Account(Account source) {  //copy constructor
			this.id = source.id;
			this.name = source.name;
			this.balance = source.balance;
		}
		
		public void setId(String id) {
			if (id==null || id.isBlank()) {
				throw new IllegalArgumentException("INVALID ID");
			}
			this.id = id;	
		}
		
		public String getId() {
			return this.id;
		}
		
		public void setName(String name) {
			if (name==null || name.isBlank()) {
				throw new IllegalArgumentException("INVALID NAME");
			}
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
		
		public void setBalance(double balance) {
			this.balance = balance;
		}
		
		public double getBalance() {
			return this.balance;
		}
		
		 public abstract void deposit(double amount);
		 public abstract boolean withdraw(double amount);
		 public abstract Account clone();     //cause we can't create copy of account object since it is abstract
		 
		 protected double round(double amount) {
		     DecimalFormat formatter = new DecimalFormat("#.##");
		     return Double.parseDouble(formatter.format(amount));
		 }
		
		@Override
	    public String toString() {
	        return  this.getClass().getSimpleName() +
	            "\t" + this.id + "" +
	            "\t" + this.name + "" +
	            "\t$" + this.balance + "";
	    }
		
		



}
