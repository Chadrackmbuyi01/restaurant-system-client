package za.ac.cput.gui.driver;

import za.ac.cput.gui.customer.CustomerMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckDriver implements ActionListener {

    private JFrame DriversDisplayFrame;
    private JPanel panelNorth, panelSouth, panelCenter;
    private JLabel lblHeading, lblDriverId;
    private TextArea taCheck;
    private TextField txtDriverId;
    private JButton btnDisplay, btnExit, btnClear;
    private Font headingFont, ft3txt;
    Color panAllColor = Color.GRAY;
    Color btnColor = Color.LIGHT_GRAY;

    public CheckDriver() {
        // Text font
        headingFont = new Font("Arial", Font.BOLD, 20);
        ft3txt = new Font("Arial", Font.PLAIN, 19);

        DriversDisplayFrame = new JFrame("Driver: ");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelNorth.setBackground(btnColor);
        panelCenter.setBackground(btnColor);
        panelSouth.setBackground(btnColor);

        lblHeading = new JLabel("Requested Driver", JLabel.CENTER);
        lblDriverId = new JLabel("Driver ID:");
        lblDriverId.setFont(ft3txt);

        taCheck = new TextArea("DriverIDNumber\tDeliveryID\tOrderID\tDriverName\n");

        txtDriverId = new TextField("");
        txtDriverId.setFont(ft3txt);

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

        panelCenter.add(lblDriverId);
        panelCenter.add(txtDriverId);
        panelCenter.add(taCheck);

        panelSouth.add(btnDisplay);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        lblHeading.setFont(headingFont);

        DriversDisplayFrame.add(panelNorth, BorderLayout.NORTH);
        DriversDisplayFrame.add(panelSouth, BorderLayout.SOUTH);
        DriversDisplayFrame.add(panelCenter, BorderLayout.CENTER);

        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);


        //Set GUI
        DriversDisplayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DriversDisplayFrame.pack();
        DriversDisplayFrame.setSize(900, 600);
        DriversDisplayFrame.setLocationRelativeTo(null);
        DriversDisplayFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Display")) {
            DriverHttp driverHttp = new DriverHttp();
            String driverId = txtDriverId.getText();
            taCheck.append(driverHttp.check(driverId));
        }

        if (e.getActionCommand().equals("Clear")) {
            taCheck.setText("");
            txtDriverId.setText("");
        }

        if (e.getActionCommand().equals("Exit")) {
            DriversDisplayFrame.dispose();
            DriverMenu driverMenu = new DriverMenu();
            driverMenu.setGUI();
        }

    }
}
