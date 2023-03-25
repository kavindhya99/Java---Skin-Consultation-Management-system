import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class AddConsultation extends JFrame {
    public AddConsultation() {
        WestminsterSkinConsultationManager consultationManager = new WestminsterSkinConsultationManager();
        Patient patient = new Patient();
//        ArrayList<Patient> patientList = new ArrayList<>();

        Consultation consultation = new Consultation();

        //create form
        setLayout(new GridLayout(14, 2));
        setResizable(true);
        add(new JLabel("Doctor Name"));
        ArrayList<Doctor> doctor1 = new ArrayList<Doctor>(WestminsterSkinConsultationManager.doctors);
        JComboBox<String> cb = new JComboBox<String>();
        for (Doctor d1 : doctor1) {
            cb.addItem(d1.getName());
        }

        cb.setVisible(true);
        add(cb);


        add(new JLabel("Date"));
        JTextField date = new JTextField();
        add(date);
        System.out.println("Date text " + date.getText());


        //check availability
        JButton availableDocButton = new JButton("Check Availability");
        add(availableDocButton);

        JTextField dummy = new JTextField();
        add(dummy);
        dummy.setVisible(false);

        availableDocButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                boolean isAvailable = isDoctorAvailable(date.getText(), doctorName.getText());
                boolean isAvailable = isDoctorAvailable(date.getText(), cb.getSelectedItem().toString());
                if (isAvailable == false) {
                    System.out.println("Doc not available");
                    List<String> availableDoctors = getAvailableDoctors(date.getText());
                    for (String s : availableDoctors) {
                        System.out.println(s);
                    }

                    int randomNo = generateRandomNo(availableDoctors.size());
                    System.out.println("RandomNo  " + randomNo);
                    String randomDoc = availableDoctors.get(randomNo);
                    System.out.println("randomDoc  " + randomDoc);
                    cb.setSelectedItem(randomDoc);
                    JOptionPane.showMessageDialog(null, "Selected doctor not available, Doctor " + randomDoc + " is selected.");


                } else {
                    JOptionPane.showMessageDialog(null, "Doctor " + cb.getSelectedItem().toString() + " is available.");

                }
            }
        });

        //patients
        add(new JLabel("Patient Name"));
        JTextField patientName = new JTextField();
        add(patientName);


        add(new JLabel("Patient Surname"));
        JTextField patientSurname = new JTextField();
        add(patientSurname);


        add(new JLabel("Date Of Birth"));
        JTextField dob = new JTextField();
        add(dob);


        add(new JLabel("Mobile Number"));
        JTextField mobileNo = new JTextField();
        add(mobileNo);


        add(new JLabel("Patient ID"));
        JTextField patientId = new JTextField();
        add(patientId);


        //Add Consultation
        add(new JLabel("Duration"));
        JTextField duration = new JTextField();
        add(duration);

        JButton calculateCostButton = new JButton("Calculate Cost");
        JTextField dummy2 = new JTextField();
        add(calculateCostButton);
        add(dummy2);
        dummy2.setVisible(false);

        add(new JLabel("Cost"));
        JTextField cost = new JTextField();
        add(cost);

        calculateCostButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double costDouble = 0.0;
                int durationInt = convertToString(duration);
                if(durationInt == 1) {
                    costDouble = 15.0;
                } else {
                    costDouble = 15.0+ 25.0*(durationInt-1);
                }

                cost.setText(String.valueOf(costDouble));
            }
        });




        add(new JLabel("Notes"));
        JTextField note = new JTextField();
        add(note);
        JButton attachmentButton = new JButton("Attachments");
        JTextField attachment = new JTextField();
        add(attachmentButton);
        add(attachment);
        final String[] imageText = {new String()};

        attachmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.addChoosableFileFilter(new ImageFilter());
                fileChooser.setAcceptAllFileFilterUsed(false);

                int option = fileChooser.showOpenDialog(getParent());
                if (option == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    attachment.setText("File Selected: " + file.getName());
                }

                imageText[0] = fileChooser.getSelectedFile().toString();

            }
        });


        JButton saveButton = new JButton("Save");

        add(saveButton);

        // add(new JButton("View"));
        JButton backButton = new JButton("Back");

        add(backButton);
        //add(new JButton("Back"));


        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Pati N " + patientName.getText());
                patient.setName(patientName.getText());
                patient.setSurName(patientSurname.getText());
                patient.setDate(dob.getText());
                patient.setMobileNumber(Integer.parseInt(mobileNo.getText()));
                patient.setPatientId(patientId.getText());


                WestminsterSkinConsultationManager.patients.add(patient);


                consultation.setPatientId(patientId.getText());
                consultation.setDoctorName(cb.getSelectedItem().toString());

                int durationInt = convertToString(duration);
                consultation.setDuration(durationInt);

                Double costDouble = convertToDouble(cost);
                consultation.setCost(costDouble);

                consultation.setNote(note.getText());
                consultation.setDateTime(date.getText());

                String encryptedImage;
                try {
                    encryptedImage = encrypt(imageText[0]);
                } catch (UnsupportedEncodingException ex) {
                    throw new RuntimeException(ex);
                }

                consultation.setAttachment(encryptedImage);

                WestminsterSkinConsultationManager.consultations.add(consultation);
                JOptionPane.showMessageDialog(null, "Consultation added successfully");
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dispose();
                consultationManager.gui();


            }
        });
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                consultationManager.gui();

            }
        });
    }

    private static int convertToString(JTextField jTextField) {
        String str = jTextField.getText();
        if (str.isEmpty()) {
            str = "0";
        }
        int textInt = Integer.parseInt(str);
        return textInt;
    }

    private static Double convertToDouble(JTextField jTextField) {
        String str = jTextField.getText();
        if (str.isEmpty()) {
            str = "0";
        }
        Double textDouble = Double.parseDouble(str);
        return textDouble;
    }

    private String encrypt(String str) throws UnsupportedEncodingException {
        byte[] encodedBytes = Base64.getEncoder().encode(str.getBytes("UTF-8"));
        return new String(encodedBytes);
    }

    private boolean isDoctorAvailable(String dateTime, String doctorName) {
        boolean flag = true;
        if (WestminsterSkinConsultationManager.consultations.isEmpty() == false) {
            System.out.println("Consultation not null");
            for (Consultation consultation : WestminsterSkinConsultationManager.consultations) {
                System.out.println("DateTime  " + dateTime);
                System.out.println("DateTime C " + consultation.getDateTime());
                System.out.println("DocN  " + doctorName);
                System.out.println("DocN C   " + consultation.getDoctorName());
                if (dateTime.equals(consultation.getDateTime()) && doctorName.equals(consultation.getDoctorName())) {
                    System.out.println("false");
                    flag = false;
                }
            }

        }
        System.out.println("true");
        return flag;
    }

    public int generateRandomNo(int max) {
        //since array min length is 0
        return (int) ((Math.random() * (max - 0)) + 0);
    }

    private ArrayList<String> getAvailableDoctors(String dateTime) {
        System.out.println("DateTime  " + dateTime);
        System.out.println("SSSSS  " + WestminsterSkinConsultationManager.consultations.size());
        ArrayList<String> availableDoctors = new ArrayList<>();
        for (Doctor doctor : WestminsterSkinConsultationManager.doctors) {
            if (isDoctorAvailable(dateTime, doctor.getName())) {
                availableDoctors.add(doctor.getName());
            }
        }


        return availableDoctors;
    }

}