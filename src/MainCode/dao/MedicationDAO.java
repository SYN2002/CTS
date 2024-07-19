package MainCode.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import MainCode.db.JdbcConnection;
import MainCode.mod.Medication;

public class MedicationDAO {
	private Connection con;
	public MedicationDAO() throws Exception{
		this.con=JdbcConnection.getConnection();
	}
	public void addMedication(Medication medication) {
		try {
			String query="INSERT INTO Medication (name, description, price, quantity_in_stock) VALUES (?, ?, ?, ?)";
			PreparedStatement ptmt = con.prepareStatement(query);
			ptmt.setString(1, medication.getName());
			ptmt.setString(2, medication.getDescription());
			ptmt.setDouble(3, medication.getPrice());
			ptmt.setInt(4, medication.getQuantity_in_stock());
			ptmt.execute();
			System.out.println("Medication Added Successfully!");
		} catch (SQLException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		
	}
	public Medication getMedication(int medication_id) {
        String sql = "SELECT * FROM Medication WHERE medication_id = ?";
        try {
        	PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, medication_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Medication medication = new Medication();
                medication.setMedication_id(rs.getInt("medication_id"));
                medication.setName(rs.getString("name"));
                medication.setDescription(rs.getString("description"));
                medication.setPrice(rs.getDouble("price"));
                medication.setQuantity_in_stock(rs.getInt("quantity_in_stock"));
                return medication;
            }
        } catch (SQLException e) {
        	// TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }
	public void updateMedication(Medication medication) {
        String sql = "UPDATE Medication SET name = ?, price = ?, quantity_in_stock = ? WHERE medication_id = ?";
        try {
        	PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, medication.getName());
            pstmt.setDouble(2, medication.getPrice());
            pstmt.setInt(3, medication.getQuantity_in_stock());
            pstmt.setInt(4, medication.getMedication_id());
            pstmt.executeUpdate();
            System.out.println("Medication updated successfully.");
        } catch (SQLException e) {
        	// TODO: handle exception
            e.printStackTrace();
        }
    }
	public void deleteMedication(int medication_id) {
        String sql = "DELETE FROM Medication WHERE medication_id = ?";
        try {
        	PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, medication_id);
            pstmt.executeUpdate();
            System.out.println("Medication deleted successfully.");
        } catch (SQLException e) {
        	// TODO: handle exception
            e.printStackTrace();
        }
    }
}
