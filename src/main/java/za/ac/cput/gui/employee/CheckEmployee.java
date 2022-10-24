package za.ac.cput.gui.employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLDataException;

public class CheckEmployee extends Component implements ActionListener {

    private JFrame EmployeesDisplayFrame;
    private JPanel panelNorth, panelSouth, panelCenter;
    private JLabel lblHeading, lblEmployeeIdNumber;
    private TextArea taCheck;
    private TextField txtEmployeeIdNumber;
    private JButton btnDisplay, btnExit, btnClear;
    private Font headingFont, ft3txt;
    Color panAllColor = Color.CYAN;
    Color btnColor = Color.LIGHT_GRAY;

    public CheckEmployee() {
        // Text font
        headingFont = new Font("Arial", Font.BOLD, 20);
        ft3txt = new Font("Arial", Font.PLAIN, 19);

        EmployeesDisplayFrame = new JFrame("Employee: ");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelNorth.setBackground(btnColor);
        panelCenter.setBackground(btnColor);
        panelSouth.setBackground(btnColor);

        lblHeading = new JLabel("Requested Employee", JLabel.CENTER);
        lblEmployeeIdNumber = new JLabel("Employee ID Number:");
        lblEmployeeIdNumber.setFont(ft3txt);

        taCheck = new TextArea("EmployeeIDNumber\tFirstname\tLastname\tAddress\n");

        txtEmployeeIdNumber = new TextField("");
        txtEmployeeIdNumber.setFont(ft3txt);

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

        panelCenter.add(lblEmployeeIdNumber);
        panelCenter.add(txtEmployeeIdNumber);
        panelCenter.add(taCheck);

        panelSouth.add(btnDisplay);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        lblHeading.setFont(headingFont);

        EmployeesDisplayFrame.add(panelNorth, BorderLayout.NORTH);
        EmployeesDisplayFrame.add(panelSouth, BorderLayout.SOUTH);
        EmployeesDisplayFrame.add(panelCenter, BorderLayout.CENTER);

        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);


        //Set GUI
        EmployeesDisplayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        EmployeesDisplayFrame.pack();
        EmployeesDisplayFrame.setSize(900, 600);
        EmployeesDisplayFrame.setLocationRelativeTo(null);
        EmployeesDisplayFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String message = "The Employee requested is here.";
        String error = "The Employee ID does not exist into the Database";
        if (e.getActionCommand().equals("Display")) {
            try {
                EmployeeHttp employeeHttp = new EmployeeHttp();
                int empId = Integer.parseInt(txtEmployeeIdNumber.getText());
                taCheck.append(employeeHttp.check(String.valueOf(empId)));
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(this, "The Employee record does not exist into the Database", "NOT FOUND", JOptionPane.INFORMATION_MESSAGE);
            }
            JOptionPane.showMessageDialog(null, message, "Result", JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getActionCommand().equals("Clear")) {
            taCheck.setText("");
            txtEmployeeIdNumber.setText("");
        }

        if (e.getActionCommand().equals("Exit")) {
            EmployeesDisplayFrame.dispose();
            EmployeeMenu employeeMenu = new EmployeeMenu();
            employeeMenu.setGUI();
            JOptionPane.showMessageDialog(this, "You Pressed Button Exit",
                    "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
