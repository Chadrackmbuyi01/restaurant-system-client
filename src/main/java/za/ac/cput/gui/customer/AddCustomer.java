package za.ac.cput.gui.customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomer implements ActionListener {

    private JFrame AddCustomerFrame;
    private JPanel panelNorth, panelSouth,panelCenter;
    private JLabel lblHeading;
    private JLabel lblCustFirstName, lblCustLastName, lblEmail, lblCustomerIdNumber, lblCustCellNum;
    private JTextField txtCustomerFirstName, txtCustomerLastName, txtEmail, txtCustomerIdNumber, txtCustCellNum;
    private JButton btnSave, btnExit, btnClear;
    private Font headingFont, ft3txt;
    Color panAllColor = Color.PINK;
    Color btnColor = Color.LIGHT_GRAY;

    public AddCustomer(){

        headingFont = new Font("Arial", Font.BOLD, 20);
        ft3txt = new Font("Arial", Font.PLAIN, 24);

        AddCustomerFrame = new JFrame("Customer: ");
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        panelCenter = new JPanel();
        panelNorth.setBackground(panAllColor);
        panelSouth.setBackground(panAllColor);
        panelCenter.setBackground(panAllColor);

        lblHeading = new JLabel("New Customer Registry",JLabel.CENTER);


        lblCustomerIdNumber = new JLabel("Customer ID");
        lblCustomerIdNumber.setFont(ft3txt);
        lblCustFirstName = new JLabel("First Name:");
        lblCustFirstName.setFont(ft3txt);
        lblCustLastName = new JLabel("Last Name:");
        lblCustLastName.setFont(ft3txt);
        lblEmail = new JLabel("Email Address:");
        lblEmail.setFont(ft3txt);
        lblCustCellNum = new JLabel("Cellphone number");
        lblCustCellNum.setFont(ft3txt);

        txtCustomerIdNumber = new JTextField();
        txtCustomerIdNumber.setFont(ft3txt);
        txtCustomerFirstName = new JTextField();
        txtCustomerFirstName.setFont(ft3txt);
        txtCustomerLastName = new JTextField();
        txtCustomerLastName.setFont(ft3txt);
        txtEmail = new JTextField();
        txtEmail.setFont(ft3txt);
        txtCustCellNum = new JTextField();
        txtCustCellNum.setFont(ft3txt);


        btnSave = new JButton("Save");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");
        btnSave.setFont(ft3txt);
        btnExit.setFont(ft3txt);
        btnClear.setFont(ft3txt);
    }

    public void setGUI() {
        panelNorth.setLayout(new GridLayout(2, 1));
        panelSouth.setLayout(new GridLayout(1, 3));
        panelCenter.setLayout(new GridLayout(6, 2));

        panelNorth.add(lblHeading);

        panelCenter.add(lblCustomerIdNumber);
        panelCenter.add(txtCustomerIdNumber);
        panelCenter.add(lblCustFirstName);
        panelCenter.add(txtCustomerFirstName);
        panelCenter.add(lblCustLastName);
        panelCenter.add(txtCustomerLastName);
        panelCenter.add(lblCustCellNum);
        panelCenter.add(txtCustCellNum);
        panelCenter.add(lblEmail);
        panelCenter.add(txtEmail);

        panelSouth.add(btnSave);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        lblHeading.setFont(headingFont);

        AddCustomerFrame.add(panelNorth, BorderLayout.NORTH);
        AddCustomerFrame.add(panelSouth, BorderLayout.SOUTH);
        AddCustomerFrame.add(panelCenter, BorderLayout.CENTER);

        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);


        AddCustomerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        AddCustomerFrame.pack();
        AddCustomerFrame.setSize(900, 600);
        AddCustomerFrame.setLocationRelativeTo(null);
        AddCustomerFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Save")){

            String custId = txtCustomerIdNumber.getText();
            String firstName = txtCustomerFirstName.getText();
            String lastName = txtCustomerLastName.getText();
            int cellNumber = Integer.parseInt(txtCustCellNum.getText());
            String email = txtEmail.getText();

            CustomerHttp customerHttp = new CustomerHttp();

            customerHttp.save(custId,cellNumber,email,firstName,lastName);


        }

        if(e.getActionCommand().equals("Clear")){

            txtCustomerIdNumber.setText("");
            txtCustomerFirstName.setText("");
            txtCustomerLastName.setText("");
            txtCustCellNum.setText("");
            txtEmail.setText("");
        }

        if(e.getActionCommand().equals("Exit")){
            AddCustomerFrame.dispose();
            CustomerMenu customerMenu = new CustomerMenu();
            customerMenu.setGUI();
        }

    }
}
