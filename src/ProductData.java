/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jerusalem
 */

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class ProductData {
    private Product[] products;
    private int count;
    private DefaultTableModel model;

    public ProductData(DefaultTableModel model) {
        this.products = new Product[100];
        this.count = 0;
        this.model = model;
    }

    public void addProduct(String name, int quantity, double price, String id) {
        Product product = new Product(name, quantity, price, id);
        products[count] = product;
        count++;

        String[] rowData = {name, String.valueOf(quantity), String.valueOf(price), id};
        model.addRow(rowData);
    }

    public void searchProduct(String id) {
        for (int i = 0; i < count; i++) {
            if (products[i].getId().equals(id)) {
                model.setRowCount(0);
                String[] rowData = {products[i].getName(), String.valueOf(products[i].getQuantity()), String.valueOf(products[i].getPrice()), products[i].getId()};
                model.addRow(rowData);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Product not found.");
    }

    public void editProduct(String id, String name, int quantity, double price) {
        for (int i = 0; i < count; i++) {
            if (products[i].getId().equals(id)) {
                products[i].setName(name);
                products[i].setQuantity(quantity);
                products[i].setPrice(price);

                String[] rowData = {name, String.valueOf(quantity), String.valueOf(price), id};
                model.setValueAt(name, i, 0);
                model.setValueAt(String.valueOf(quantity), i, 1);
                model.setValueAt(String.valueOf(price), i, 2);
                model.setValueAt(id, i, 3);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Product not found.");
    }

    public void deleteProduct(String id) {
        for (int i = 0; i < count; i++) {
            if (products[i].getId().equals(id)) {
                model.removeRow(i);

                for (int j = i; j < count - 1; j++) {
                    products[j] = products[j + 1];
                }

                count--;
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Product not found.");
    }
}


