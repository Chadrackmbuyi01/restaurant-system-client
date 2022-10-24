package za.ac.cput.gui.customer;

import za.ac.cput.gui.employee.AddEmployee;
import za.ac.cput.gui.employee.CheckEmployee;
import za.ac.cput.gui.employee.DeleteEmployee;
import za.ac.cput.gui.employee.DisplayEmployees;
import za.ac.cput.gui.main.MainGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerMenu implements ActionListener {

    private JFrame MenuFrame;
    private JPanel panelNorth, panelSouth, panelEast, panelWest, panelCenter;
    private JLabel lblHeading;
    private JButton btnAdd, btnDelete, btnCheck, btnGetAll, btnExit;
    private Font headingFont, ft3txt;
    Color panAllColor = Color.PINK;
    Color btnColor = Color.LIGHT_GRAY;

    public CustomerMenu(){
        //Font
        headingFont = new Font("Arial", Font.BOLD, 30);
        ft3txt = new Font("Arial", Font.PLAIN, 24);

        MenuFrame = new JFrame("Customer");
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
        lblHeading = new JLabel("Customer Menu",JLabel.CENTER);
        lblHeading.setFont(headingFont);

        //Buttons:
        btnAdd = new JButton("Add New Customer");
        btnAdd.setBackground(btnColor);
        btnAdd.setFont(ft3txt);
        btnCheck = new JButton("Check A Customer");
        btnCheck.setBackground(btnColor);
        btnCheck.setFont(ft3txt);
        btnDelete = new JButton("Delete Customer");
        btnDelete.setBackground(btnColor);
        btnDelete.setFont(ft3txt);
        btnGetAll = new JButton("Display All Customers");
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

        if(e.getActionCommand().equals("Add New Customer")){
            AddCustomer addCustomer = new AddCustomer();
            addCustomer.setGUI();
            MenuFrame.dispose();
        }
        if(e.getActionCommand().equals("Check A Customer")){
            CheckCustomer checkCustomer = new CheckCustomer();
            checkCustomer.setGUI();
            MenuFrame.dispose();
        }
        if(e.getActionCommand().equals("Delete Customer")){
            DeleteCustomer deleteCustomer = new DeleteCustomer();
            deleteCustomer.setGUI();
            MenuFrame.dispose();
        }
        if(e.getActionCommand().equals("Display All Customers")){
            DisplayCustomers displayCustomers = new DisplayCustomers();
            displayCustomers.setGUI();
            MenuFrame.dispose();
        }
        if(e.getActionCommand().equals("Exit")){
            MenuFrame.dispose();
            MainGUI mainGUI = new MainGUI();
            mainGUI.setGUI();
        }

    }
}
