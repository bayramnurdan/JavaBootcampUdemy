import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class Transaction implements Comparable<Transaction> {
	public enum Type{ WITHDRAW, DEPOSIT};
	
	private Type type;
	private long timestamp;
	private String id ;
	private double amount;
	
	public Transaction(Type type, long timestamp,String id, double amount) {
		if (id == null || id.isBlank() || amount<0) {
			throw new IllegalArgumentException("INVALID ID or amount");
		}
		this.type =type;
		this.timestamp = timestamp;
		this.id = id;
		this.amount = amount;
		this.id = id;
	}
	public Transaction(Transaction source) {
		this.type =source.type;
		this.timestamp = source.timestamp;
		this.amount = source.amount;
		this.id = source.id;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}
	public void  setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	public long getTimeStamp() {
		return this.timestamp;
	}
	
	public void setID(String id){
		if(id == null || id.isBlank()) {
			throw new IllegalArgumentException("Invalid id");
		}
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setAmount(double amount) {
		if(amount<0) {
			throw new IllegalArgumentException("INVALID AMOUNT");
		}
		this.amount = amount;
	}
	public double getAmount() {
		return this.amount;
	}
	
	public String returnDate() {
		Date date = new Date(this.timestamp*1000);
		return new SimpleDateFormat("dd-MM-yyyy").format(date);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(type, timestamp, id, amount);	
	}
	@Override
	public int compareTo(Transaction o) {
		
		return Double.compare(timestamp, o.timestamp);
	}
	@Override
	public String toString() {
		return (type) + "    " +
	            "\t" + this.returnDate()+ "" +
	            "\t" + this.id + "" +
	            "\t$" + this.amount + "";
		
		
	}

	

}

