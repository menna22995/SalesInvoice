
package SIG.Model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ProBook G7
 */
public class InvoiceHeaderModel  extends AbstractTableModel{
    private ArrayList<InvoiceHeader>data;
  private String []cols={"id","NAme","Date"};    

    public InvoiceHeaderModel(ArrayList<InvoiceHeader> data) {
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
        InvoiceHeader header =data.get(rowIndex);
        switch (columnIndex){
            case 0:
                return header.getId();
            case 1:
                return header.getCustomerName();
            case 2:
                return header.getDate();
                
        }
        return "empty";
    }
     @Override
    public String getColumnName(int column){
        return cols[column];
    }
    
}
