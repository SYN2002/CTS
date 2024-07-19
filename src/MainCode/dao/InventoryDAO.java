package MainCode.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import MainCode.db.JdbcConnection;
import MainCode.mod.Inventory;
import MainCode.mod.Medication;

public class InventoryDAO {
	private Connection conn;
	public InventoryDAO() throws Exception{
		this.conn=JdbcConnection.getConnection();
	}
	public void updateInventory(Inventory inventory) {
        String sql = "INSERT INTO Inventory (medication_id, supplier_id, quantity_received, date_received) VALUES (?, ?, ?, ?)";
        try {
        	PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, inventory.getMedication_id());
            pstmt.setInt(2, inventory.getSupplier_id());
            pstmt.setInt(3, inventory.getQuantity_received());
            pstmt.setDate(4, new java.sql.Date(inventory.getDate_received().getTime()));
            pstmt.execute();

            String updateMedicationSql = "UPDATE Medication SET quantity_in_stock = quantity_in_stock + ? WHERE medication_id = ?";
            try {
            	PreparedStatement updatePstmt = conn.prepareStatement(updateMedicationSql);
                updatePstmt.setInt(1, inventory.getQuantity_received());
                updatePstmt.setInt(2, inventory.getMedication_id());
                updatePstmt.execute();
            }
            catch (SQLException e) {
				// TODO: handle exception
            	e.printStackTrace();
			}

            System.out.println("Inventory updated successfully.");
        } catch (SQLException e) {
        	// TODO: handle exception
            e.printStackTrace();
        }
    }
	
	public List<Inventory> getInventoryLevels() {
        List<Inventory> inventoryList = new ArrayList<>();
        String sql = "SELECT * FROM Inventory";
        try {
        	Statement stmt = conn.createStatement(); 
        	ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Inventory inventory = new Inventory();
                inventory.setInventory_id(rs.getInt("inventory_id"));
                inventory.setMedication_id(rs.getInt("medication_id"));
                inventory.setSupplier_id(rs.getInt("supplier_id"));
                inventory.setQuantity_received(rs.getInt("quantity_received"));
                inventory.setDate_received(rs.getDate("date_received"));
                inventoryList.add(inventory);
            }
        } catch (SQLException e) {
        	// TODO: handle exception
            e.printStackTrace();
        }
        return inventoryList;
    }
	public List<Medication> getLowStockAlerts() {
        List<Medication> lowStockMedications = new ArrayList<>();
        String sql = "SELECT * FROM Medication WHERE quantity_in_stock < 10";
        try {
        	Statement stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Medication medication = new Medication();
                medication.setMedication_id(rs.getInt("medication_id"));
                medication.setName(rs.getString("name"));
                medication.setDescription(rs.getString("description"));
                medication.setPrice(rs.getDouble("price"));
                medication.setQuantity_in_stock(rs.getInt("quantity_in_stock"));
                lowStockMedications.add(medication);
            }
        } catch (SQLException e) {
        	// TODO: handle exception
            e.printStackTrace();
        }
        return lowStockMedications;
    }
}
