package za.ac.cput.gui.employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteEmployee implements ActionListener {

    private JFrame EmployeeDeleteFrame;
    private JPanel panelNorth, panelSouth,panelCenter;
    private JLabel lblHeading, lblEmployeeIdNumber;
    private TextField txtEmployeeIdNumber;
    private JButton btnDisplay, btnExit, btnClear;
    private Font headingFont, ft3txt;
    Color panAllColor = Color.CYAN;
    Color btnColor = Color.LIGHT_GRAY;
    public DeleteEmployee() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 22);
        ft3txt = new Font("Arial", Font.PLAIN, 24);

        EmployeeDeleteFrame = new JFrame("Deleting Employee ");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelNorth.setBackground(panAllColor);
        panelCenter.setBackground(panAllColor);
        panelSouth.setBackground(panAllColor);

        lblHeading = new JLabel("Deleting",JLabel.CENTER);
        lblEmployeeIdNumber = new JLabel("Employee ID Number:");

        txtEmployeeIdNumber = new TextField("");
        txtEmployeeIdNumber.setFont(ft3txt);

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

        panelCenter.add(lblEmployeeIdNumber);
        panelCenter.add(txtEmployeeIdNumber);

        lblEmployeeIdNumber.setFont(ft3txt);

        panelSouth.add(btnDisplay);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        lblHeading.setFont(headingFont);

        EmployeeDeleteFrame.add(panelNorth, BorderLayout.NORTH);
        EmployeeDeleteFrame.add(panelSouth, BorderLayout.SOUTH);
        EmployeeDeleteFrame.add(panelCenter, BorderLayout.CENTER);

        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        //Set GUI:
        EmployeeDeleteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        EmployeeDeleteFrame.pack();
        EmployeeDeleteFrame.setSize(900, 600);
        EmployeeDeleteFrame.setLocationRelativeTo(null);
        EmployeeDeleteFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Delete")){
            EmployeeHttp employeeHttp = new EmployeeHttp();
            String employeeNumber = txtEmployeeIdNumber.getText();
            employeeHttp.delete(employeeNumber);
        }

        if(e.getActionCommand().equals("Clear")){
            txtEmployeeIdNumber.setText("");
        }

        if(e.getActionCommand().equals("Exit")){
            EmployeeDeleteFrame.dispose();
            EmployeeMenu employeeMenu = new EmployeeMenu();
            employeeMenu.setGUI();
        }
    }
}
