package MainCode.mod;

import java.util.Date;

public class Inventory {
	private int inventory_id;
    private int medication_id;
    private int supplier_id;
    private int quantity_received;
    private Date date_received;
    
	public int getInventory_id() {
		return inventory_id;
	}
	public void setInventory_id(int inventory_id) {
		this.inventory_id = inventory_id;
	}
	public int getMedication_id() {
		return medication_id;
	}
	public void setMedication_id(int medication_id) {
		this.medication_id = medication_id;
	}
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public int getQuantity_received() {
		return quantity_received;
	}
	public void setQuantity_received(int quantity_received) {
		this.quantity_received = quantity_received;
	}
	public Date getDate_received() {
		return date_received;
	}
	public void setDate_received(Date date_received) {
		this.date_received = date_received;
	}
	
}
