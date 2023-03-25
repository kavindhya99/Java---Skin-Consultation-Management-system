

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;


public class WestminsterSkinConsultationManager extends JFrame implements SkinConsultationManager {

    //Store all the relevant details about doctors
    static ArrayList<Doctor> doctors = new ArrayList<Doctor>(10);
    //Store all the details about the consultation
    public static ArrayList<Consultation> consultations = new ArrayList<>();
    // Store all the details about the patients
    public static ArrayList<Patient> patients = new ArrayList<>();
    public void Menu() {
       //Display the Menu
        System.out.println("Press 1 to Add a new doctor ");
        System.out.println("Press 2 to Delete a doctor ");
        System.out.println("Press 3 to Print the list of doctors");
        System.out.println("Press 4 to save all details");
        System.out.println("Press 5 to load the data stored previously ");
        System.out.println("Press 6 to GUI ");
        System.out.println("Press 7 to exit ");
        System.out.println(" ");
        System.out.print("Enter your choice : ");
        Scanner scannerone = new Scanner(System.in);
        int choice = scannerone.nextInt();
        switch (choice) {
            case 1:
                addDoctor();
                break;
            case 2:
                deleteDoctor();
                break;
            case 3:
                printDoctor();
                break;
            case 4:
                storeDetails();
                break;
            case 5:
                loadDetails();
                break;
            case 6:
                gui();
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("Please enter a valid input");
                break;

        }
    }


    public void addDoctor() {
        Doctor one = new Doctor();
        Scanner scannertwo = new Scanner(System.in);
        System.out.print("Enter Doctor's name: ");
        String name = scannertwo.nextLine();
        System.out.print("Enter Doctor's Surname: ");
        String Sname = scannertwo.nextLine();
        System.out.print("Enter the date(dd/mm/yyyy) : ");
        String date = scannertwo.nextLine();
        System.out.print("Enter the mobile number: ");
        int mobie = scannertwo.nextInt();
        System.out.print("Enter the MedicalLicenseNumber: ");
        int MediLicenseNumber = scannertwo.nextInt();
        System.out.print("Enter Doctor's Specialisation: ");
        String specialisation = scannertwo.next();


        one.setName(name);
        one.setSurName(Sname);
        one.setDate(date);
        one.setMobileNumber(mobie);
        one.setMedicalLicenseNumber(MediLicenseNumber);
        one.setSpecialisation(specialisation);
        if(doctors.size() >= 10){
            System.out.println("Doctor cannot be added, Center can have maximum 10 doctors");
        } else {
            doctors.add(one);
            System.out.println("....................Doctor added successfully...................");
        }
        System.out.println("\n");
        Menu();

    }


    public void deleteDoctor() {
        System.out.print("Enter the medical licence number: ");
        Scanner scannerone = new Scanner(System.in);
        int mediNumber = scannerone.nextInt();


        for (Doctor obj1 : doctors) {

            if (obj1.getMedicalLicenseNumber() == mediNumber) {
                doctors.remove(obj1);
                System.out.println("Doctor deleted successfully!");
                System.out.println("Now the center has "+doctors.size()+" Doctors available");
                break;
            } else {
                System.out.println("Invalid request!");

            }
        }
        System.out.println("\n");
        Menu();

    }


    public void printDoctor() {

        doctors.sort((o1, o2)
                -> o1.getSurName().compareTo(
                o2.getSurName()));
        for (Doctor doctor1 : doctors) {

            System.out.println("Doctor Name: "+doctor1.getName() + "| Doctor Surname:  " + doctor1.getSurName() + "| Date: " + doctor1.getDate() +
                    "| Mobile Number: " + doctor1.getMobileNumber() + "| MedicalLicenseNumber: " + doctor1.getMedicalLicenseNumber() +
                    "| Specialisation: " + doctor1.getSpecialisation());

        }
        System.out.println("\n");
        Menu();
    }



    public void storeDetails() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("filename.txt")); //Create a file
            writer.write("---Doctor Details---");
            //Input data into file
            for (Doctor doctor1 : doctors) {

                writer.write("\n\nDoctor Name: " + doctor1.getName() + "\nDoctor's Surname: " + doctor1.getSurName() + "\nDate: " + doctor1.getDate()
                        + "\nDoctor's Mobile No: " + doctor1.getMobileNumber() + "\nDoctr's Medical License Number: " + doctor1.getMedicalLicenseNumber() +
                        "\nDoctor's Specialisation: " + doctor1.getSpecialisation());

            }
            writer.close();
            Menu();
        } catch (IOException e) {  //handling errors
            e.printStackTrace();
            Menu();
        }

    }

    public void loadDetails() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("filename.txt"));
            String line;
            while ((line = reader.readLine()) != null) {  //Read the file line by line
                System.out.println(line);
            }
            reader.close();
            System.out.println("\n");
            Menu();
        } catch (IOException e) {       //handling errors
            e.printStackTrace();
            Menu();
        }

    }

   public void gui() {
        WestminsterSkinConsultationManager frame = new WestminsterSkinConsultationManager();
        frame.setTitle("Skin Consultation Center");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setVisible(true);

        JPanel p1 = new JPanel();
        p1.setSize(400, 400);
        JLabel set = new JLabel("Dashboard SkinConsultation");
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        set.setBounds(100, 20, 200, 50);
        set.setFont(font1);
        set.setForeground(Color.red);
        p1.add(set);

        JButton ViewDoctors = new JButton("View Doctors");
        //x Axis, y Axis, Width, Height
        ViewDoctors.setBounds(70, 70, 200, 40);
        p1.add(ViewDoctors);

        JButton SortDoctors = new JButton("Sort Doctors");
        //x Axis, y Axis, Width, Height
        SortDoctors.setBounds(70, 130, 200, 40);
        p1.add(SortDoctors);

        JButton AddConsultation = new JButton("Add Consultation");
        //x Axis, y Axis, Width, Height
        AddConsultation.setBounds(70, 200, 200, 40);
        p1.add(AddConsultation);

       JButton viewConsultationButton = new JButton("View Consultation");
       //x Axis, y Axis, Width, Height
       viewConsultationButton.setBounds(70, 260, 200, 40);
       p1.add(viewConsultationButton);

       JButton viewPatientsButton = new JButton("View Patients");
       //x Axis, y Axis, Width, Height
       viewPatientsButton.setBounds(70, 330, 200, 40);
       p1.add(viewPatientsButton);

        p1.setBackground(Color.pink);
        frame.add(p1);

       ViewDoctors.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                DoctorTable table = new DoctorTable(doctors);
                table.setVisible(true);
                table.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );



            }
        });
       SortDoctors.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               frame.setVisible(true);
               DoctorSortTable table1=new DoctorSortTable(doctors);
               table1.setVisible(true);
               table1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );

           }
       });
       AddConsultation.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               AddConsultation c=new AddConsultation();
               c.setTitle("Add Consultation");
               c.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               c.setSize(500,600);
               c.setResizable(false);
               c.setVisible(true);
               new AddConsultation();
               //frame.setVisible(true);





           }
       });
       viewConsultationButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
//
               ConsultationTable table = new ConsultationTable(consultations);
               table.setVisible(true);
               table.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
           }
       });

       viewPatientsButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
//
               PatientTable table = new PatientTable(patients);
               table.setVisible(true);
               table.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
           }
       });


   }
}
