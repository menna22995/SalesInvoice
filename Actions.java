/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SIG.Controller;

import SIG.Model.InvoiceHeader;
import SIG.Model.InvoiceLine;
import SIG.View.Invoice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author ProBook G7
 */
public class Actions implements ActionListener, ListSelectionListener {

    private Invoice invoice;

    public Actions(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
            case "Load File":
                Load();
                break;

            case "Save File":
                Save();
                break;

            case "Create New Voice":
                createInvoiceBtn();
                break;

            case "Delete Invoice":
                DeleteButton();
                break;

            case "Save":
                SaveButton();
                break;

            case "Cancel":
                CancelButton();
                break;

        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println("row selected");
    }

    private void Load() {
        try {
            JFileChooser fc = new JFileChooser();
            int result = fc.showOpenDialog(invoice);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fc.getSelectedFile();
                String headerStrPath = headerFile.getAbsolutePath();
                Path headerPath = Paths.get(headerStrPath);
                List<String> headerLines = Files.lines(headerPath).collect(Collectors.toList());
                ArrayList<InvoiceHeader> invoiceHeaderList = new ArrayList<>();
                for (String headerline : headerLines) {
                    String[] parts = headerline.split(",");
                    int id = Integer.parseInt(parts[0]);
                    InvoiceHeader invheader = new InvoiceHeader(id, parts[2], parts[1]);
                    invoiceHeaderList.add(invheader);
                }

                result = fc.showOpenDialog(invoice);
                if (result == JFileChooser.APPROVE_OPTION) {
                    String lineStrPath = fc.getSelectedFile().getAbsolutePath();
                    Path linePath = Paths.get(lineStrPath);
                    List<String> lineLines = Files.lines(linePath).collect(Collectors.toList());
                    for (String lineLine : lineLines) {
                        String[] parts = lineLine.split(",");
                        int invid = Integer.parseInt(parts[0]);
                        double price = Double.parseDouble(parts[2]);
                        int count = Integer.parseInt(parts[3]);
                        InvoiceHeader header = getInvoiceHeaderById(invoiceHeaderList, invid);
                        InvoiceLine invline = new InvoiceLine(parts[1], price, count, header);
                        header.getLines().add(invline);
                    }
                    invoice.setInvoiceHeaderList(invoiceHeaderList);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private InvoiceHeader getInvoiceHeaderById(ArrayList<InvoiceHeader> invoices, int id) {

        for (InvoiceHeader invoice : invoices) {
            if (invoice.getId() == id) {
                return invoice;
            }

        }
        return null;
    }

    private void Save() {
    }

    private void createInvoiceBtn() {
    }

    private void DeleteButton() {
        try  
{  
File file = new File("C:\\Users\\AA\\Desktop\\invoiceheader.csv");             //creates a file instance  
file.deleteOnExit();                 //deletes the file when JVM terminates  
System.out.println("Done");  
Thread.sleep(1000);    
}  
catch(Exception e)  
{  
e.printStackTrace();  
}  
}    
   

    private void SaveButton() {
    }

    private void CancelButton() {
                try  
{  
File file = new File("C:\\Users\\AA\\Desktop\\invoiceline.csv");             //creates a file instance  
file.deleteOnExit();                 //deletes the file when JVM terminates  
System.out.println("Done");  
Thread.sleep(1000);    
}  
catch(Exception e)  
{  
e.printStackTrace();  
}  
}   
    }


