package za.ac.cput.gui.employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayEmployees implements ActionListener {

    private JFrame EmployeeDisplayFrame;
    private JPanel panelNorth, panelSouth,panelCenter;
    private JLabel lblHeading;
    private TextArea taDisplay;
    private JButton btnDisplay, btnExit, btnClear;
    private Font headingFont, ft3txt;
    Color panAllColor = Color.CYAN;
    Color btnColor = Color.LIGHT_GRAY;
    public DisplayEmployees() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 20);
        ft3txt = new Font("Arial", Font.PLAIN, 24);

        EmployeeDisplayFrame = new JFrame("All Employees: ");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelNorth.setBackground(panAllColor);
        panelCenter.setBackground(panAllColor);
        panelSouth.setBackground(panAllColor);

        lblHeading = new JLabel("List Of All Employees:", JLabel.CENTER);

        taDisplay = new TextArea();

        btnDisplay = new JButton("Display");
        btnExit = new JButton("Exit");
        btnClear = new JButton("Clear");
        btnDisplay.setFont(ft3txt);
        btnExit.setFont(ft3txt);
        btnClear.setFont(ft3txt);
    }

    public void setGUI() {
        panelNorth.setLayout(new GridLayout(1, 1));
        panelCenter.setLayout(new GridLayout(1,1));
        panelSouth.setLayout(new GridLayout(1, 3));

        panelNorth.add(lblHeading);

        panelCenter.add(taDisplay);

        panelSouth.add(btnDisplay);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        lblHeading.setFont(headingFont);

        EmployeeDisplayFrame.add(panelNorth, BorderLayout.NORTH);
        EmployeeDisplayFrame.add(panelSouth, BorderLayout.SOUTH);
        EmployeeDisplayFrame.add(panelCenter, BorderLayout.CENTER);

        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        //Set GUI:
        EmployeeDisplayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        EmployeeDisplayFrame.pack();
        EmployeeDisplayFrame.setSize(900, 600);
        EmployeeDisplayFrame.setLocationRelativeTo(null);
        EmployeeDisplayFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Display")){
            EmployeeHttp employeeHttp = new EmployeeHttp();
            taDisplay.append(employeeHttp.getAll());
        }

        if(e.getActionCommand().equals("Clear")){
            taDisplay.setText("");
        }

        if(e.getActionCommand().equals("Exit")){
            EmployeeDisplayFrame.dispose();
            EmployeeMenu employeeMenu = new EmployeeMenu();
            employeeMenu.setGUI();
        }
    }

}
