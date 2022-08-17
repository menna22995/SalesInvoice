/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SIG.Model;

/**
 *
 * @author ProBook G7
 */
public class InvoiceLine {
    private String itemName ;
    private double unitPrice;
    private int count;
   
   private InvoiceHeader header;

    public InvoiceLine(String itemName, double unitPrice, int count, InvoiceHeader header) {
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.count = count;
        this.header = header;
    }

    public InvoiceHeader getHeader() {
        return header;
    }

    public void setHeader(InvoiceHeader header) {
        this.header = header;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getLineTotal() {
        return count * unitPrice;
    }

    @Override
    public String toString() {
        return "InvoiceLine{" + "itemName=" + itemName + ", unitPrice=" + unitPrice + ", count=" + count + '}';
    }

   
   
    
}
