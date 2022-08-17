
package SIG.Model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ProBook G7
 */
public class InvoiceLineModel extends AbstractTableModel {
    private ArrayList<InvoiceLine>data;
    private String[] cols ={"Item Name ","unit Price","Count"};

    public InvoiceLineModel(ArrayList<InvoiceLine> data) {
        this.data = data;
    }
    

    @Override
    public int getRowCount() {
 return data.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLine line=data.get(rowIndex);
        switch (columnIndex){
            case 0:
                return line.getItemName();
            case 1 :
                return line.getUnitPrice();
            case 2 :
                return line.getLineTotal();
        }
         return "empty";
        
    }
    
    @Override
    public String getColumnName(int column){
        return cols[column];
    }
}
