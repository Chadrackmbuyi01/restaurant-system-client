package za.ac.cput.gui.customer;

import za.ac.cput.gui.employee.EmployeeHttp;
import za.ac.cput.gui.employee.EmployeeMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckCustomer implements ActionListener {

    private JFrame CustomersDisplayFrame;
    private JPanel panelNorth, panelSouth, panelCenter;
    private JLabel lblHeading, lblCustomerIdNumber;
    private TextArea taCheck;
    private TextField txtCustomerIdNumber;
    private JButton btnDisplay, btnExit, btnClear;
    private Font headingFont, ft3txt;
    Color panAllColor = Color.PINK;
    Color btnColor = Color.LIGHT_GRAY;

    public CheckCustomer() {
        // Text font
        headingFont = new Font("Arial", Font.BOLD, 20);
        ft3txt = new Font("Arial", Font.PLAIN, 19);

        CustomersDisplayFrame = new JFrame("Customer: ");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelNorth.setBackground(btnColor);
        panelCenter.setBackground(btnColor);
        panelSouth.setBackground(btnColor);

        lblHeading = new JLabel("Requested Customer", JLabel.CENTER);
        lblCustomerIdNumber = new JLabel("Customer ID Number:");
        lblCustomerIdNumber.setFont(ft3txt);

        taCheck = new TextArea("EmployeeIDNumber\tFirstname\tLastname\tCellphone number\t\tEmail address\n");

        txtCustomerIdNumber = new TextField("");
        txtCustomerIdNumber.setFont(ft3txt);

        btnDisplay = new JButton("Display");
        btnExit = new JButton("Exit");
        btnClear = new JButton("Clear");
        btnDisplay.setFont(ft3txt);
        btnExit.setFont(ft3txt);
        btnClear.setFont(ft3txt);
    }

    public void setGUI() {
        panelNorth.setLayout(new GridLayout(1, 1));
        panelCenter.setLayout(new GridLayout(3, 1));
        panelSouth.setLayout(new GridLayout(1, 3));

        panelNorth.add(lblHeading);

        panelCenter.add(lblCustomerIdNumber);
        panelCenter.add(txtCustomerIdNumber);
        panelCenter.add(taCheck);

        panelSouth.add(btnDisplay);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        lblHeading.setFont(headingFont);

        CustomersDisplayFrame.add(panelNorth, BorderLayout.NORTH);
        CustomersDisplayFrame.add(panelSouth, BorderLayout.SOUTH);
        CustomersDisplayFrame.add(panelCenter, BorderLayout.CENTER);

        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);


        //Set GUI
        CustomersDisplayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        CustomersDisplayFrame.pack();
        CustomersDisplayFrame.setSize(900, 600);
        CustomersDisplayFrame.setLocationRelativeTo(null);
        CustomersDisplayFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Display")) {
            CustomerHttp custumerHttp = new CustomerHttp();
            String custId = txtCustomerIdNumber.getText();
            taCheck.append(custumerHttp.check(custId));
        }

        if (e.getActionCommand().equals("Clear")) {
            taCheck.setText("");
            txtCustomerIdNumber.setText("");
        }

        if (e.getActionCommand().equals("Exit")) {
            CustomersDisplayFrame.dispose();
            CustomerMenu customerMenu = new CustomerMenu();
            customerMenu.setGUI();
        }

    }

}
