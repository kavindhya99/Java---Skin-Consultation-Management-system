import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DoctorSortTable extends JFrame {
    JTable myTable;
    DoctorTableModel tableModel;
    ArrayList<Doctor> doctors;
    public DoctorSortTable(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
        tableModel = new DoctorTableModel(doctors);
        myTable = new JTable(tableModel);

        setBounds(10, 10, 700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        myTable.setAutoCreateRowSorter(true);

        JScrollPane scrollPane = new JScrollPane(myTable);
        scrollPane.setPreferredSize(new Dimension(680,480));

        JPanel panel = new JPanel();
        panel.add(scrollPane);
        add(panel,BorderLayout.CENTER);
    };
}
