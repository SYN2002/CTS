package MainCode.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import MainCode.db.JdbcConnection;
import MainCode.mod.Supplier;

public class SupplierDAO {
	private Connection conn;
	public SupplierDAO() throws Exception{
		this.conn=JdbcConnection.getConnection();
	}
	public void addSupplier(Supplier supplier) {
        String sql = "INSERT INTO Supplier (name, email, phone_number, address) VALUES (?, ?, ?, ?)";
        try {
        	PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, supplier.getName());
            pstmt.setString(2, supplier.getEmail());
            pstmt.setString(3, supplier.getPhone_number());
            pstmt.setString(4, supplier.getAddress());
            pstmt.executeUpdate();
            System.out.println("Supplier added successfully.");
        } catch (SQLException e) {
        	// TODO: handle exception
            e.printStackTrace();
        }
    }
	
	public Supplier getSupplier(int supplier_id) {
        String sql = "SELECT * FROM Supplier WHERE supplier_id = ?";
        try {
        	PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, supplier_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Supplier supplier = new Supplier();
                supplier.setSupplier_id(rs.getInt("supplier_id"));
                supplier.setName(rs.getString("name"));
                supplier.setEmail(rs.getString("email"));
                supplier.setPhone_number(rs.getString("phone_number"));
                supplier.setAddress(rs.getString("address"));
                return supplier;
            }
        } catch (SQLException e) {
        	// TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }
	
	public void updateSupplier(Supplier supplier) {
        String sql = "UPDATE Supplier SET name = ?, email = ?, phone_number = ?, address = ? WHERE supplier_id = ?";
        try {
        	PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, supplier.getName());
            pstmt.setString(2, supplier.getEmail());
            pstmt.setString(3, supplier.getPhone_number());
            pstmt.setString(4, supplier.getAddress());
            pstmt.setInt(5, supplier.getSupplier_id());
            pstmt.executeUpdate();
            System.out.println("Supplier updated successfully.");
        } catch (SQLException e) {
        	// TODO: handle exception
            e.printStackTrace();
        }
    }
	
	public void deleteSupplier(int supplier_id) {
        String sql = "DELETE FROM Supplier WHERE supplier_id = ?";
        try {
        	PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, supplier_id);
            pstmt.executeUpdate();
            System.out.println("Supplier deleted successfully.");
        } catch (SQLException e) {
        	// TODO: handle exception
            e.printStackTrace();
        }
    }
}
