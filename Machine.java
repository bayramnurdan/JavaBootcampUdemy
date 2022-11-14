
public class Machine {
	private Item[][] items;
	
	public Machine(Item [][] items) {
		this.items = new Item[items.length][items[0].length];
		for (int row=0; row<items.length; row++) {
			for (int column=0; column<items[row].length; column++) {
				this.items[row][column] = items[row][column];
			
				
			}
		}
		
	}
	
	public Item  getItem(int row, int spot) {
		return new Item(this.items[row][spot]);
	}
	
	public void  setItem(Item item, int row, int spot) {
		this.items[row][spot] = new Item(item);
		
	}
	
	public boolean dispense(int row, int spot) {
		if (items[row][spot].getQuantity() >0) {
			items[row][spot].setQuantity(items[row][spot].getQuantity()-1);
			return true;
			
		}else {
			return false;
			
		}	
	}
	
	public String toString() {
		String temp = "";
		
		for (int row=0; row<this.items.length; row++) {
			temp += "\t";
			for (int column =0; column<this.items[row].length; column++) {
				temp += this.items[row][column];
				temp += "   ";
			}
			temp += "\n\n";
		}
		temp+= "\t************************************************";
		return temp;
	}

}
