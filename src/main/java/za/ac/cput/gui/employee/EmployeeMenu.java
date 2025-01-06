package za.ac.cput.gui.employee;

import za.ac.cput.gui.main.MainGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeMenu implements ActionListener {

    private JFrame MenuFrame;
    private JPanel panelNorth, panelSouth, panelEast, panelWest, panelCenter;
    private JLabel lblHeading;
    private JButton btnAdd, btnDelete, btnCheck, btnGetAll, btnExit;
    private Font headingFont, ft3txt;
    Color panAllColor = Color.CYAN;
    Color btnColor = Color.LIGHT_GRAY;
    public EmployeeMenu(){
        //Font
        headingFont = new Font("Arial", Font.BOLD, 30);
        ft3txt = new Font("Arial", Font.PLAIN, 24);

        MenuFrame = new JFrame("Employee ");
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        panelEast = new JPanel();
        panelWest = new JPanel();
        panelCenter = new JPanel();
        panelNorth.setBackground(panAllColor);
        panelEast.setBackground(panAllColor);
        panelSouth.setBackground(panAllColor);
        panelWest.setBackground(panAllColor);
        panelCenter.setBackground(panAllColor);

        //Heading
        lblHeading = new JLabel("Employee Menu",JLabel.CENTER);
        lblHeading.setFont(headingFont);

        //Buttons:
        btnAdd = new JButton("Add New Employee");
        btnAdd.setBackground(btnColor);
        btnAdd.setFont(ft3txt);
        btnCheck = new JButton("Check An Employee");
        btnCheck.setBackground(btnColor);
        btnCheck.setFont(ft3txt);
        btnDelete = new JButton("Delete Employee");
        btnDelete.setBackground(btnColor);
        btnDelete.setFont(ft3txt);
        btnGetAll = new JButton("Display All Employees");
        btnGetAll.setBackground(btnColor);
        btnGetAll.setFont(ft3txt);
        btnExit = new JButton("Exit");
        btnExit.setFont(ft3txt);
    }

    public void setGUI() {
        panelNorth.setLayout(new GridLayout(2, 1));
        panelEast.setLayout(new GridLayout(4, 1));
        panelSouth.setLayout(new GridLayout(1, 3));
        panelWest.setLayout(new GridLayout(5, 1));
        panelCenter.setLayout(new GridLayout(7, 1));

        panelNorth.add(lblHeading);

        panelCenter.add(btnAdd);
        panelCenter.add(btnCheck);
        panelCenter.add(btnDelete);
        panelCenter.add(btnGetAll);

        panelSouth.add(btnExit);

        lblHeading.setFont(headingFont);

        MenuFrame.add(panelNorth, BorderLayout.NORTH);
        MenuFrame.add(panelSouth, BorderLayout.SOUTH);
        MenuFrame.add(panelEast, BorderLayout.EAST);
        MenuFrame.add(panelCenter, BorderLayout.CENTER);
        MenuFrame.add(panelWest, BorderLayout.WEST);

        btnAdd.addActionListener(this);
        btnCheck.addActionListener(this);
        btnDelete.addActionListener(this);
        btnGetAll.addActionListener(this);
        btnExit.addActionListener(this);

        MenuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        MenuFrame.pack();
        MenuFrame.setSize(900, 600);
        MenuFrame.setLocationRelativeTo(null);
        MenuFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Add New Employee")){
            AddEmployee addEmployee = new AddEmployee();
            JFrame jFrame;
            jFrame = new JFrame();
            String user = JOptionPane.showInputDialog(jFrame, "Enter Password: ");
            if(user.equals("1234")){
                addEmployee.setGUI();
            } else {
                JOptionPane.showInputDialog(null,"You do not have access to this option", "Warning", JOptionPane.OK_OPTION);
            }
            MenuFrame.dispose();
        }
        if(e.getActionCommand().equals("Check An Employee")){
            CheckEmployee checkEmployee = new CheckEmployee();
            JFrame jFrame;
            jFrame = new JFrame();
            String user = JOptionPane.showInputDialog(jFrame, "Enter Password: ");
            if (user.equals("1234")){
                checkEmployee.setGUI();
            } else {
                JOptionPane.showInputDialog(null,"You do not have access to this option", "Warning", JOptionPane.OK_OPTION);
            }
            MenuFrame.dispose();
        }
        if(e.getActionCommand().equals("Delete Employee")){
            DeleteEmployee deleteEmployee = new DeleteEmployee();
            JFrame jFrame;
            jFrame = new JFrame();
            String user = JOptionPane.showInputDialog(jFrame, "Enter Password: ");
            if (user.equals("1234")){
                deleteEmployee.setGUI();
            } else {
                JOptionPane.showInputDialog(null,"You do not have access to this option", "Warning", JOptionPane.OK_OPTION);
            }
            MenuFrame.dispose();
        }
        if(e.getActionCommand().equals("Display All Employees")){
            DisplayEmployees displayEmployees = new DisplayEmployees();
            JFrame jFrame;
            jFrame = new JFrame();
            String user = JOptionPane.showInputDialog(jFrame, "Enter Password: ");
            if (user.equals("4321")){
                displayEmployees.setGUI();
            } else {
                JOptionPane.showInputDialog(null,"You do not have access to this option", "Warning", JOptionPane.OK_OPTION);
            }
            MenuFrame.dispose();
        }
        if(e.getActionCommand().equals("Exit")){
            MenuFrame.dispose();
            MainGUI mainGUI = new MainGUI();
            mainGUI.setGUI();
        }

    }
}
