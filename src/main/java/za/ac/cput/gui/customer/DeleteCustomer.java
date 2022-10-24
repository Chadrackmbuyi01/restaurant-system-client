package za.ac.cput.gui.customer;

import za.ac.cput.gui.employee.EmployeeHttp;
import za.ac.cput.gui.employee.EmployeeMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteCustomer implements ActionListener {

    private JFrame CustomerDeleteFrame;
    private JPanel panelNorth, panelSouth,panelCenter;
    private JLabel lblHeading, lblCustomerIdNumber;
    private TextField txtCustomerIdNumber;
    private JButton btnDisplay, btnExit, btnClear;
    private Font headingFont, ft3txt;
    Color panAllColor = Color.PINK;
    Color btnColor = Color.LIGHT_GRAY;
    public DeleteCustomer() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 22);
        ft3txt = new Font("Arial", Font.PLAIN, 24);

        CustomerDeleteFrame = new JFrame("Deleting Customer ");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelNorth.setBackground(panAllColor);
        panelCenter.setBackground(panAllColor);
        panelSouth.setBackground(panAllColor);

        lblHeading = new JLabel("Deleting",JLabel.CENTER);
        lblCustomerIdNumber = new JLabel("Customer ID Number:");

        txtCustomerIdNumber = new TextField("");
        txtCustomerIdNumber.setFont(ft3txt);

        btnDisplay = new JButton("Delete");
        btnExit = new JButton("Exit");
        btnClear = new JButton("Clear");
        btnDisplay.setFont(ft3txt);
        btnExit.setFont(ft3txt);
        btnClear.setFont(ft3txt);
    }

    public void setGUI() {
        panelNorth.setLayout(new GridLayout(1, 1));
        panelCenter.setLayout(new GridLayout(1,2));
        panelSouth.setLayout(new GridLayout(1, 3));

        panelNorth.add(lblHeading);

        panelCenter.add(lblCustomerIdNumber);
        panelCenter.add(txtCustomerIdNumber);

        lblCustomerIdNumber.setFont(ft3txt);

        panelSouth.add(btnDisplay);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        lblHeading.setFont(headingFont);

        CustomerDeleteFrame.add(panelNorth, BorderLayout.NORTH);
        CustomerDeleteFrame.add(panelSouth, BorderLayout.SOUTH);
        CustomerDeleteFrame.add(panelCenter, BorderLayout.CENTER);

        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        //Set GUI:
        CustomerDeleteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        CustomerDeleteFrame.pack();
        CustomerDeleteFrame.setSize(900, 600);
        CustomerDeleteFrame.setLocationRelativeTo(null);
        CustomerDeleteFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Delete")){
            CustomerHttp customerHttp = new CustomerHttp();
            String customerNumber = txtCustomerIdNumber.getText();
            customerHttp.delete(customerNumber);
        }

        if(e.getActionCommand().equals("Clear")){
            txtCustomerIdNumber.setText("");
        }

        if(e.getActionCommand().equals("Exit")){
            CustomerDeleteFrame.dispose();
            CustomerMenu customerMenu = new CustomerMenu();
            customerMenu.setGUI();
        }
    }
}
