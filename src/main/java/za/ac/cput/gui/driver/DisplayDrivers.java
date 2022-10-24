package za.ac.cput.gui.driver;

import za.ac.cput.gui.customer.CustomerHttp;
import za.ac.cput.gui.customer.CustomerMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayDrivers implements ActionListener {

    private JFrame DriverDisplayFrame;
    private JPanel panelNorth, panelSouth,panelCenter;
    private JLabel lblHeading;
    private TextArea taDisplay;
    private JButton btnDisplay, btnExit, btnClear;
    private Font headingFont, ft3txt;
    Color panAllColor = Color.GRAY;
    Color btnColor = Color.LIGHT_GRAY;
    public DisplayDrivers() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 20);
        ft3txt = new Font("Arial", Font.PLAIN, 24);

        DriverDisplayFrame = new JFrame("All Drivers: ");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelNorth.setBackground(panAllColor);
        panelCenter.setBackground(panAllColor);
        panelSouth.setBackground(panAllColor);

        lblHeading = new JLabel("List Of All Drivers:", JLabel.CENTER);

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

        DriverDisplayFrame.add(panelNorth, BorderLayout.NORTH);
        DriverDisplayFrame.add(panelSouth, BorderLayout.SOUTH);
        DriverDisplayFrame.add(panelCenter, BorderLayout.CENTER);

        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        //Set GUI:
        DriverDisplayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DriverDisplayFrame.pack();
        DriverDisplayFrame.setSize(900, 600);
        DriverDisplayFrame.setLocationRelativeTo(null);
        DriverDisplayFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Display")){
            DriverHttp driverHttp = new DriverHttp();
            //taDisplay.append(driverHttp.getAll());
        }

        if(e.getActionCommand().equals("Clear")){
            taDisplay.setText("");
        }

        if(e.getActionCommand().equals("Exit")){
            DriverDisplayFrame.dispose();
            DriverMenu driverMenu = new DriverMenu();
            driverMenu.setGUI();
        }
    }
}
