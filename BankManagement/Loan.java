
	public class Loan extends Account {
		private static final double DEBT_LIMIT = 10.000;
		private static final double INTEREST_RATE = 0.02;
		
		public Loan(String id, String name, double balance) {
			super(id, name, balance);
		}
		
		public Loan(Loan source) {
			super(source);
		}
		
		@Override
		public Account clone() {
			return new Loan(this);
		}

		@Override
		public void deposit(double amount) {
			super.setBalance(super.round(super.getBalance() - amount));
			
		}

		@Override
		public boolean withdraw(double amount) {
			if((super.getBalance() + amount) >= DEBT_LIMIT) {
				return false;
		}else {
			super.setBalance(super.getBalance() + amount + (amount * INTEREST_RATE ));
			return true;
		}
			
		

}
		
			
		}
