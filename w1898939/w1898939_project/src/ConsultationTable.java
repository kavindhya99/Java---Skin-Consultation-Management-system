
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConsultationTable extends JFrame {

    JTable myTable;
    ConsultationModel tableModel;
    ArrayList<Consultation> consultations;
    public ConsultationTable(ArrayList<Consultation> consultations) {
        this.consultations = consultations;
        tableModel = new ConsultationModel(consultations);
        myTable = new JTable(tableModel);
        myTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        JButton button = new JButton("Cancel Consultation");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // check for selected row first
                if(myTable.getSelectedRow() != -1) {
                    // remove selected row from the model

                    int row = myTable.getSelectedRow();
                    String value = myTable.getValueAt(myTable.getSelectedRow(),0).toString();
                    CancelConsultation.cancelConsultation( myTable.getValueAt(myTable.getSelectedRow(),0).toString());
                    tableModel.fireTableDataChanged();
                    JOptionPane.showMessageDialog(null, "Selected consultation is cancelled successfully");
                }
            }
        });

        setBounds(10, 10, 700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //myTable.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(myTable);
        scrollPane.setPreferredSize(new Dimension(680,480));
        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(scrollPane);

        add(panel,BorderLayout.CENTER);
    };
}
