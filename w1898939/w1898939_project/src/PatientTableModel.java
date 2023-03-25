import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class PatientTableModel extends AbstractTableModel {
    private String[] columnNames = {"Date","Name","Surname","DOB","Mobile Number","Patient ID"};
    private ArrayList<Patient> patient;
    public PatientTableModel(ArrayList<Patient> personList){
        patient = personList;
    }


    @Override
    public int getRowCount() {
        return patient.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        if (columnIndex == 0) {
            temp = patient.get(rowIndex).getDate();
        }
        else if (columnIndex == 1) {
            temp = patient.get(rowIndex).getName();
        }
        else if (columnIndex == 2) {
            temp = patient.get(rowIndex).getSurName();
        }
        else if (columnIndex == 3) {
            temp = patient.get(rowIndex).getDate();
        }
        else if (columnIndex == 4) {
            temp = patient.get(rowIndex).getMobileNumber();
        }
        else if (columnIndex == 5) {
            temp = patient.get(rowIndex).getPatientId();
        }

        return temp;
    }
    public String getColumnName(int col) {
        return columnNames[col];
    }
}
