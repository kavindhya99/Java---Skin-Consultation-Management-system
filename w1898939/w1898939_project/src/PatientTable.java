import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PatientTable extends JFrame {
    JTable myTable;
    PatientTableModel tableModel;
    ArrayList<Patient> patient;
    public PatientTable(ArrayList<Patient> patient) {
        this.patient = patient;
        tableModel = new PatientTableModel(patient);
        myTable = new JTable(tableModel);

        setBounds(10, 10, 700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //myTable.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(myTable);
        scrollPane.setPreferredSize(new Dimension(680,480));

        JPanel panel = new JPanel();
        panel.add(scrollPane);
        add(panel,BorderLayout.CENTER);
    };
}
