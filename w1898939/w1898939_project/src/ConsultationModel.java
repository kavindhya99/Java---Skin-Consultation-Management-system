
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ConsultationModel extends AbstractTableModel {
    private String[] columnNames = {"ConsultationId","DoctorName","PatientId","Date","Duration","Cost","Note","Attachments"};
    private ArrayList<Consultation> consultations;
    public ConsultationModel(ArrayList<Consultation> personList){
        consultations = personList;
    }

    public static DefaultTableModel def = new DefaultTableModel();

    @Override
    public int getRowCount() {
        return consultations.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        if (columnIndex == 0) {
            temp = consultations.get(rowIndex).getConsultationId();
        }
        else if (columnIndex == 1) {
            temp = consultations.get(rowIndex).getDoctorName();
        }
        else if (columnIndex == 2) {
            temp = consultations.get(rowIndex).getPatientId();
        }
        else if (columnIndex == 3) {
            temp = consultations.get(rowIndex).getDateTime();
        }
        else if (columnIndex == 4) {
            temp = consultations.get(rowIndex).getDuration();
        }
        else if (columnIndex == 5) {
            temp = consultations.get(rowIndex).getCost();
        }
        else if (columnIndex == 6) {
            temp = consultations.get(rowIndex).getNote();
        }
        else if (columnIndex == 7) {
            temp = consultations.get(rowIndex).getAttachment();
        }
        return temp;
    }
    public String getColumnName(int col) {
        return columnNames[col];
    }

}


