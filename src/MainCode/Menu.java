package MainCode;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import MainCode.dao.InventoryDAO;
import MainCode.dao.MedicationDAO;
import MainCode.dao.SupplierDAO;
import MainCode.mod.Inventory;
import MainCode.mod.Medication;
import MainCode.mod.Supplier;

public class Menu {
    private Scanner scanner;
    private MedicationDAO mDao;
    private SupplierDAO sDao;
    private InventoryDAO iDao;
    public Menu() {
    	try {
    		this.scanner = new Scanner(System.in);
    		this.mDao = new MedicationDAO();
    		this.sDao = new SupplierDAO();
    		this.iDao= new InventoryDAO();    	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }

    public void displayMainMenu() {
        while (true) {
            System.out.println("Inventory Management System");
            System.out.println("1. Manage Medications");
            System.out.println("2. Manage Suppliers");
            System.out.println("3. Manage Inventory");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manageMedications();
                    break;
                case 2:
                    manageSuppliers();
                    break;
                case 3:
                    manageInventory();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void manageMedications() {
        while (true) {
            System.out.println("Medication Management");
            System.out.println("1. Add Medication");
            System.out.println("2. View Medication");
            System.out.println("3. Update Medication");
            System.out.println("4. Delete Medication");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addMedication();
                    break;
                case 2:
                    viewMedication();
                    break;
                case 3:
                    updateMedication();
                    break;
                case 4:
                    deleteMedication();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addMedication() {
        Medication medication = new Medication();
        System.out.print("Enter name: ");
        medication.setName(scanner.nextLine());
        System.out.print("Enter description: ");
        medication.setDescription(scanner.nextLine());
        System.out.print("Enter price: ");
        medication.setPrice(scanner.nextDouble());
        System.out.print("Enter quantity in stock: ");
        medication.setQuantity_in_stock(scanner.nextInt());
        scanner.nextLine();

        mDao.addMedication(medication);
    }

    private void viewMedication() {
        System.out.print("Enter medication ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Medication medication = mDao.getMedication(id);
        if (medication != null) {
            System.out.println("ID: " + medication.getMedication_id());
            System.out.println("Name: " + medication.getName());
            System.out.println("Description: " + medication.getDescription());
            System.out.println("Price: " + medication.getPrice());
            System.out.println("Quantity in stock: " + medication.getQuantity_in_stock());
        } else {
            System.out.println("Medication not found.");
        }
    }

    private void updateMedication() {
        System.out.print("Enter medication ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Medication medication = mDao.getMedication(id);
        if (medication != null) {
            System.out.print("Enter new name (current: " + medication.getName() + "): ");
            medication.setName(scanner.nextLine());
            System.out.print("Enter new price (current: " + medication.getPrice() + "): ");
            medication.setPrice(scanner.nextDouble());
            System.out.print("Enter new quantity in stock (current: " + medication.getQuantity_in_stock() + "): ");
            medication.setQuantity_in_stock(scanner.nextInt());
            scanner.nextLine();

            mDao.updateMedication(medication);
        } else {
            System.out.println("Medication not found.");
        }
    }

    private void deleteMedication() {
        System.out.print("Enter medication ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        mDao.deleteMedication(id);
    }


    private void manageSuppliers() {
        while (true) {
            System.out.println("Supplier Management");
            System.out.println("1. Add Supplier");
            System.out.println("2. View Supplier");
            System.out.println("3. Update Supplier");
            System.out.println("4. Delete Supplier");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addSupplier();
                    break;
                case 2:
                    viewSupplier();
                    break;
                case 3:
                    updateSupplier();
                    break;
                case 4:
                    deleteSupplier();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addSupplier() {
        Supplier supplier = new Supplier();
        System.out.print("Enter name: ");
        supplier.setName(scanner.nextLine());
        System.out.print("Enter email: ");
        supplier.setEmail(scanner.nextLine());
        System.out.print("Enter phone number: ");
        supplier.setPhone_number(scanner.nextLine());
        System.out.print("Enter address: ");
        supplier.setAddress(scanner.nextLine());

        sDao.addSupplier(supplier);
    }

    private void viewSupplier() {
        System.out.print("Enter supplier ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Supplier supplier = sDao.getSupplier(id);
        if (supplier != null) {
            System.out.println("ID: " + supplier.getSupplier_id());
            System.out.println("Name: " + supplier.getName());
            System.out.println("Email: " + supplier.getEmail());
            System.out.println("Phone Number: " + supplier.getPhone_number());
            System.out.println("Address: " + supplier.getAddress());
        } else {
            System.out.println("Supplier not found.");
        }
    }

    private void updateSupplier() {
        System.out.print("Enter supplier ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Supplier supplier = sDao.getSupplier(id);
        if (supplier != null) {
            System.out.print("Enter new name (current: " + supplier.getName() + "): ");
            supplier.setName(scanner.nextLine());
            System.out.print("Enter new email (current: " + supplier.getEmail() + "): ");
            supplier.setEmail(scanner.nextLine());
            System.out.print("Enter new phone number (current: " + supplier.getPhone_number() + "): ");
            supplier.setPhone_number(scanner.nextLine());
            System.out.print("Enter new address (current: " + supplier.getAddress() + "): ");
            supplier.setAddress(scanner.nextLine());

            sDao.updateSupplier(supplier);
        } else {
            System.out.println("Supplier not found.");
        }
    }

    private void deleteSupplier() {
        System.out.print("Enter supplier ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        sDao.deleteSupplier(id);
    }


    private void manageInventory() {
    	while (true) {
            System.out.println("Inventory Management");
            System.out.println("1. Update Inventory Levels");
            System.out.println("2. View Inventory Levels");
            System.out.println("3. Generate Low-Stock Alerts");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    updateInventory();
                    break;
                case 2:
                    viewInventoryLevels();
                    break;
                case 3:
                    generateLowStockAlerts();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void updateInventory() {
        Inventory inventory = new Inventory();
        System.out.print("Enter medication ID: ");
        inventory.setMedication_id(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Enter supplier ID: ");
        inventory.setSupplier_id(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Enter quantity received: ");
        inventory.setQuantity_received(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Enter date received (YYYY-MM-DD): ");
        inventory.setDate_received(Date.valueOf(scanner.nextLine()));

        iDao.updateInventory(inventory);
    }

    private void viewInventoryLevels() {
        List<Inventory> inventoryList = iDao.getInventoryLevels();
        for (Inventory inventory : inventoryList) {
            System.out.println("Inventory ID: " + inventory.getInventory_id());
            System.out.println("Medication ID: " + inventory.getMedication_id());
            System.out.println("Supplier ID: " + inventory.getSupplier_id());
            System.out.println("Quantity Received: " + inventory.getQuantity_received());
            System.out.println("Date Received: " + inventory.getDate_received());
            System.out.println();
        }
    }

    private void generateLowStockAlerts() {
        List<Medication> lowStockMedications = iDao.getLowStockAlerts();
        for (Medication medication : lowStockMedications) {
            System.out.println("Medication ID: " + medication.getMedication_id());
            System.out.println("Name: " + medication.getName());
            System.out.println("Description: " + medication.getDescription());
            System.out.println("Price: " + medication.getPrice());
            System.out.println("Quantity in Stock: " + medication.getQuantity_in_stock());
            System.out.println();
        }
    }
}