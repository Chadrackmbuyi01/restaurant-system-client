package za.ac.cput.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateEmployee extends JFrame implements ActionListener {

    private JPanel panelNorth;
    private JPanel panelCenter;
    private JPanel panelSouth;

    private JLabel lblEmployeeLogo;
    private JLabel lblHeading;

    private JLabel lblPadding1, lblPadding2, lblPadding3;
    private JLabel lblEmployeeID;
    private JTextField txtEmployeeID;
    private JLabel lblEmployeeErr;

    private JLabel lblFirstName;
    private JTextField txtFirstName;
    private JLabel lblFirstNameErr;

    private JLabel lblLastName;
    private JTextField txtLastName;
    private JLabel lblLastNameErr;

    private JLabel lblAddress;
    private JTextField txtAddress;
    private JLabel lblAddressErr;

    private JButton btnSave, btnDelete, btnExit;
    private Font ft1, ft2, ft3;

    public CreateEmployee(){

        super("Employee App version 1.0");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();

        lblEmployeeLogo = new JLabel(new ImageIcon("employee.png"));
        lblHeading = new JLabel("CREATION OF THE EMPLOYEE");

        lblPadding1 = new JLabel();
        lblPadding2 = new JLabel();
        lblPadding3 = new JLabel();

        lblEmployeeID = new JLabel("Player ID : ");
        txtEmployeeID = new JTextField("auto-generated");
        txtEmployeeID.setEnabled(false);
        lblEmployeeErr = new JLabel("Player ID is required*");

        lblFirstName = new JLabel("First name : ");
        txtFirstName = new JTextField();
        lblFirstNameErr = new JLabel("First name is required*");

        lblLastName = new JLabel("Last name : ");
        txtLastName = new JTextField();
        lblLastNameErr = new JLabel("Last name is required*");

        lblAddress = new JLabel("Address : ");
        txtAddress = new JTextField();
        lblAddressErr = new JLabel("Address is required*");

        btnSave = new JButton("Save");
        btnDelete = new JButton("Delete");
        btnExit = new JButton("Exit");

        ft1 = new Font("Arial", Font.BOLD, 32);
        ft2 = new Font("Arial", Font.PLAIN, 22);
        ft3 = new Font("Arial", Font.PLAIN, 24);
    }

    public void setGUI(){

        panelNorth.setLayout(new FlowLayout());
        panelCenter.setLayout(new GridLayout(7, 2));
        panelSouth.setLayout(new GridLayout(1, 3));

        panelNorth.add(lblEmployeeLogo);
        panelNorth.add(lblHeading);
        lblHeading.setFont(ft1);
        lblHeading.setForeground(Color.WHITE);
        panelNorth.setBackground(new Color(230, 106, 120));

        lblPadding1.setFont(ft1);
        panelCenter.add(lblPadding1);
        lblPadding2.setFont(ft1);
        panelCenter.add(lblPadding2);
        lblPadding3.setFont(ft1);
        panelCenter.add(lblPadding3);

        lblEmployeeID.setFont(ft2);
        lblEmployeeErr.setFont(ft2);
        lblEmployeeErr.setForeground(Color.red);
        lblEmployeeID.setHorizontalAlignment(JLabel.RIGHT);
        txtEmployeeID.setFont(ft2);
        panelCenter.add(lblEmployeeID);
        panelCenter.add(txtEmployeeID);
        panelCenter.add(lblEmployeeErr).setVisible(false);

        lblFirstName.setFont(ft2);
        lblFirstNameErr.setFont(ft2);
        lblFirstNameErr.setForeground(Color.red);
        lblFirstName.setHorizontalAlignment(JLabel.RIGHT);
        txtFirstName.setFont(ft2);
        panelCenter.add(lblFirstName);
        panelCenter.add(txtFirstName);
        panelCenter.add(lblFirstNameErr).setVisible(false);

        lblLastName.setFont(ft2);
        lblLastNameErr.setFont(ft2);
        lblLastNameErr.setForeground(Color.red);
        lblLastName.setHorizontalAlignment(JLabel.RIGHT);
        txtLastName.setFont(ft2);
        panelCenter.add(lblLastName);
        panelCenter.add(txtLastName);
        panelCenter.add(lblLastNameErr).setVisible(false);

        lblAddress.setFont(ft2);
        lblAddressErr.setFont(ft2);
        lblAddressErr.setForeground(Color.red);
        lblAddress.setHorizontalAlignment(JLabel.RIGHT);
        txtAddress.setFont(ft2);
        panelCenter.add(lblAddress);
        panelCenter.add(txtAddress);
        panelCenter.add(lblAddressErr).setVisible(false);

        btnSave.setFont(ft3);
        btnDelete.setFont(ft3);
        btnExit.setFont(ft3);
        panelSouth.add(btnSave);
        panelSouth.add(btnDelete);
        panelSouth.add(btnExit);

        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnSave.addActionListener(this);
        btnDelete.addActionListener(this);
        btnExit.addActionListener(this);

        this.setSize(800, 800);
        this.pack();
        this.setVisible(true);

    }
    public boolean isInputValid(){
        boolean valid = true;
        if (txtAddress.getText().equals("")) {
            lblAddressErr.setVisible(true);
            txtAddress.requestFocus();
            valid = false;
        }
        else
            lblAddressErr.setVisible(false);

        if (txtLastName.getText().equals("")) {
            lblLastNameErr.setVisible(true);
            txtLastName.requestFocus();
            valid = false;
        }
        else
            lblLastNameErr.setVisible(false);

        if (txtFirstName.getText().equals("")) {
            lblFirstNameErr.setVisible(true);
            txtFirstName.requestFocus();
            valid = false;
        }
        else
            lblFirstNameErr.setVisible(false);

        return valid;

    }
    private void clearForm() {
        txtEmployeeID.setText("");
        lblEmployeeErr.setVisible(false);
        txtFirstName.setText("");
        lblFirstNameErr.setVisible(false);
        txtLastName.setText("");
        lblLastNameErr.setVisible(false);
        txtEmployeeID.requestFocus();
    }
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals("Save")){
            if (isInputValid()){
                //save to database

                clearForm();
            }

        }

        if (e.getActionCommand().equals("Delete")){
            if (isInputValid()){
                //delete to database

                clearForm();
            }

        }
        else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }

    }
    public static void main(String[] args) {
        new CreateEmployee().setGUI();
    }


}
