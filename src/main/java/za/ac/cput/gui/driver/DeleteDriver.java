package za.ac.cput.gui.driver;

import za.ac.cput.gui.customer.CustomerHttp;
import za.ac.cput.gui.customer.CustomerMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteDriver implements ActionListener {

    private JFrame DriverDeleteFrame;
    private JPanel panelNorth, panelSouth,panelCenter;
    private JLabel lblHeading, lblDriverId;
    private TextField txtDriverId;
    private JButton btnDisplay, btnExit, btnClear;
    private Font headingFont, ft3txt;
    Color panAllColor = Color.GRAY;
    Color btnColor = Color.LIGHT_GRAY;
    public DeleteDriver() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 22);
        ft3txt = new Font("Arial", Font.PLAIN, 24);

        DriverDeleteFrame = new JFrame("Deleting Driver ");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelNorth.setBackground(panAllColor);
        panelCenter.setBackground(panAllColor);
        panelSouth.setBackground(panAllColor);

        lblHeading = new JLabel("Deleting",JLabel.CENTER);
        lblDriverId = new JLabel("Driver ID Number:");

        txtDriverId = new TextField("");
        txtDriverId.setFont(ft3txt);

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

        panelCenter.add(lblDriverId);
        panelCenter.add(txtDriverId);

        lblDriverId.setFont(ft3txt);

        panelSouth.add(btnDisplay);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        lblHeading.setFont(headingFont);

        DriverDeleteFrame.add(panelNorth, BorderLayout.NORTH);
        DriverDeleteFrame.add(panelSouth, BorderLayout.SOUTH);
        DriverDeleteFrame.add(panelCenter, BorderLayout.CENTER);

        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        //Set GUI:
        DriverDeleteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DriverDeleteFrame.pack();
        DriverDeleteFrame.setSize(900, 600);
        DriverDeleteFrame.setLocationRelativeTo(null);
        DriverDeleteFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Delete")){
            DriverHttp driverHttp = new DriverHttp();
            String driverId = txtDriverId.getText();
            //driverHttp.delete(driverId);
        }

        if(e.getActionCommand().equals("Clear")){
            txtDriverId.setText("");
        }

        if(e.getActionCommand().equals("Exit")){
            DriverDeleteFrame.dispose();
            DriverMenu driverMenu = new DriverMenu();
            driverMenu.setGUI();
        }
    }
}
