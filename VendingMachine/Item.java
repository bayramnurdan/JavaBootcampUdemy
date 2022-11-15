
public class Item {
	private String name;
	private double price;
	private int quantity;
	
	public Item(String name, double price, int quantity){
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("name cannot be null/blank.");
		}else if (price<0) {
			throw new IllegalArgumentException("price cannot be less than zero.");
			
		}else if(quantity<0) {
			throw new IllegalArgumentException("quantity cannot be less than zero.");	
		}else
		{
			this.name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
			this.price = price;
			this.quantity = quantity;
		}
	}
	
	public Item(Item item) {
		this.name = item.name;
		this.price = item.price;
		this.quantity = item.quantity;
	}
	
	
	public String getName() {
		return this.name;
	}

	
	public void setName(String name) {
		if (name == null || name.isBlank() ) {
			throw new IllegalArgumentException("Name is blank or null");
		}else {
			this.name =name;
		}

	}
	
	
	public double getPrice() {
		return this.price;
	}
	
	
	public void setPrice(double price) {
		if (price<0) {
			throw new IllegalArgumentException("Price cannot be smaller than zero.");
		}else {
			this.price = price;	
		}	
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	
	public void setQuantity(int quantity) {
		if (quantity<0) {
			throw new IllegalArgumentException("Quantity can not be smaller than zero");
		}else {
			this.quantity = quantity;	
		}
	}
	
	public String toString() {
		return this.getName() + ": "  + this.getPrice()  + " " + "(" + this.getQuantity() +")";
		
		
	}
	}

