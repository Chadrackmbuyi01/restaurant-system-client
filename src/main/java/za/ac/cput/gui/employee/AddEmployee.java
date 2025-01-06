package za.ac.cput.gui.employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends Component implements ActionListener {

    private JFrame AddEmployeeFrame;
    private JPanel panelNorth, panelSouth,panelCenter;
    private JLabel lblHeading;
    private JLabel lblEmployeeFirstName, lblEmployeeLastName, lblAddress, lblEmployeeIdNumber;
    private JTextField txtEmployeeFirstName, txtEmployeeLastName, txtAddress, txtEmployeeIdNumber;
    private JButton btnSave, btnExit, btnClear;
    private Font headingFont, ft3txt;
    Color panAllColor = Color.CYAN;
    Color btnColor = Color.red;

    public AddEmployee(){

        headingFont = new Font("Arial", Font.BOLD, 20);
        ft3txt = new Font("Arial", Font.PLAIN, 24);

        AddEmployeeFrame = new JFrame("Employee Dashboard ");
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        panelCenter = new JPanel();
        panelNorth.setBackground(panAllColor);
        panelSouth.setBackground(panAllColor);
        panelCenter.setBackground(panAllColor);

        panelSouth.setBackground(btnColor);
        panelNorth.setBackground(btnColor);

        lblHeading = new JLabel("New Employee Registry",JLabel.CENTER);


        lblEmployeeFirstName = new JLabel("First Name:");
        lblEmployeeFirstName.setFont(ft3txt);
        lblEmployeeLastName = new JLabel("Last Name:");
        lblEmployeeLastName.setFont(ft3txt);
        lblAddress = new JLabel("Address:");
        lblAddress.setFont(ft3txt);


        txtEmployeeFirstName = new JTextField();
        txtEmployeeFirstName.setFont(ft3txt);
        txtEmployeeLastName = new JTextField();
        txtEmployeeLastName.setFont(ft3txt);
        txtAddress = new JTextField();
        txtAddress.setFont(ft3txt);


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
        panelCenter.setLayout(new GridLayout(4, 2));

        panelNorth.add(lblHeading);

        panelCenter.add(lblEmployeeFirstName);
        panelCenter.add(txtEmployeeFirstName);
        panelCenter.add(lblEmployeeLastName);
        panelCenter.add(txtEmployeeLastName);
        panelCenter.add(lblAddress);
        panelCenter.add(txtAddress);

        panelSouth.add(btnSave);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        lblHeading.setFont(headingFont);

        AddEmployeeFrame.add(panelNorth, BorderLayout.NORTH);
        AddEmployeeFrame.add(panelSouth, BorderLayout.SOUTH);
        AddEmployeeFrame.add(panelCenter, BorderLayout.CENTER);

        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);


        AddEmployeeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        AddEmployeeFrame.pack();
        AddEmployeeFrame.setSize(900, 600);
        AddEmployeeFrame.setLocationRelativeTo(null);
        AddEmployeeFrame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String message = "The information is saved successfully";

        if (e.getActionCommand().equals("Save")) {
            try {
                String firstName = txtEmployeeFirstName.getText();
                String lastName = txtEmployeeLastName.getText();
                String address = txtAddress.getText();

                EmployeeHttp employeeHttp = new EmployeeHttp();

                employeeHttp.save(firstName, lastName, address);
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
                JOptionPane.showMessageDialog(null, message, "Result", JOptionPane.INFORMATION_MESSAGE);
        }


        if(e.getActionCommand().equals("Clear")){

            txtEmployeeFirstName.setText("");
            txtEmployeeLastName.setText("");
            txtAddress.setText("");
        }

        if(e.getActionCommand().equals("Exit")){
            AddEmployeeFrame.dispose();
            EmployeeMenu employeeMenu = new EmployeeMenu();
            employeeMenu.setGUI();
            JOptionPane.showMessageDialog(this, "You Pressed Button Exit",
                    "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
