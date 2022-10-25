package za.ac.cput.gui.driver;

import za.ac.cput.gui.customer.CustomerHttp;
import za.ac.cput.gui.customer.CustomerMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver implements ActionListener {

    private JFrame AddDriverFrame;
    private JPanel panelNorth, panelSouth,panelCenter;
    private JLabel lblHeading;
    private JLabel lblDriverId, lblDeliveryId, lblOrderId, lblDriverName;
    private JTextField txtDriverId, txtDeliveryId, txtOrderId, txtDriverName;
    private JButton btnSave, btnExit, btnClear;
    private Font headingFont, ft3txt;
    Color panAllColor = Color.GRAY;
    Color btnColor = Color.LIGHT_GRAY;

    public AddDriver(){

        headingFont = new Font("Arial", Font.BOLD, 20);
        ft3txt = new Font("Arial", Font.PLAIN, 24);

        AddDriverFrame = new JFrame("Driver: ");
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        panelCenter = new JPanel();
        panelNorth.setBackground(panAllColor);
        panelSouth.setBackground(panAllColor);
        panelCenter.setBackground(panAllColor);

        lblHeading = new JLabel("New Driver Registry",JLabel.CENTER);


        lblDriverId = new JLabel("Driver ID:");
        lblDriverId.setFont(ft3txt);
        lblDeliveryId = new JLabel("Delivery ID:");
        lblDeliveryId.setFont(ft3txt);
        lblOrderId = new JLabel("Order ID:");
        lblOrderId.setFont(ft3txt);
        lblDriverName = new JLabel("Full Name");
        lblDriverName.setFont(ft3txt);


        txtDriverId = new JTextField("auto-generated");
        txtDriverId.setFont(ft3txt);
        txtDriverId.setEnabled(false);
        txtDeliveryId = new JTextField();
        txtDeliveryId.setFont(ft3txt);
        txtDeliveryId.requestFocus();
        txtOrderId = new JTextField();
        txtOrderId.setFont(ft3txt);
        txtDriverName = new JTextField();
        txtDriverName.setFont(ft3txt);



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
        panelCenter.setLayout(new GridLayout(5, 2));

        panelNorth.add(lblHeading);

        panelCenter.add(lblDriverId);
        panelCenter.add(txtDriverId);
        panelCenter.add(lblDeliveryId);
        panelCenter.add(txtDeliveryId);
        panelCenter.add(lblOrderId);
        panelCenter.add(txtOrderId);
        panelCenter.add(lblDriverName);
        panelCenter.add(txtDriverName);

        panelSouth.add(btnSave);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        lblHeading.setFont(headingFont);

        AddDriverFrame.add(panelNorth, BorderLayout.NORTH);
        AddDriverFrame.add(panelSouth, BorderLayout.SOUTH);
        AddDriverFrame.add(panelCenter, BorderLayout.CENTER);

        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);


        AddDriverFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        AddDriverFrame.pack();
        AddDriverFrame.setSize(900, 600);
        AddDriverFrame.setLocationRelativeTo(null);
        AddDriverFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String message = "This driver has been saved to the system";
        if (e.getActionCommand().equals("Save")) {
         try{
            String driverId = txtDriverId.getText();
            String deliveryId = txtDeliveryId.getText();
            String orderId = txtOrderId.getText();
            String driverName = txtDriverName.getText();

            DriverHttp driverHttp = new DriverHttp();

            driverHttp.save(deliveryId, orderId, driverName);
        }
             catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);

        }


        if(e.getActionCommand().equals("Clear")){

            txtDriverId.setText("");
            txtDeliveryId.setText("");
            txtOrderId.setText("");
            txtDriverName.setText("");
        }

        if(e.getActionCommand().equals("Exit")){
            AddDriverFrame.dispose();
            DriverMenu driverMenu = new DriverMenu();
            driverMenu.setGUI();
        }

    }

}
