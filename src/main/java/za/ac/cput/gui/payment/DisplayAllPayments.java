package za.ac.cput.gui.payment;

import za.ac.cput.gui.employee.EmployeeHttp;
import za.ac.cput.gui.employee.EmployeeMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayAllPayments implements ActionListener {

    private JFrame PaymentsDisplayFrame;
    private JPanel panelNorth, panelSouth,panelCenter;
    private JLabel lblHeading;
    private TextArea taDisplay;
    private JButton btnDisplay, btnExit, btnClear;
    private Font headingFont, ft3txt;
    Color panAllColor = Color.GREEN;
    Color btnColor = Color.LIGHT_GRAY;
    public DisplayAllPayments() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 20);
        ft3txt = new Font("Arial", Font.PLAIN, 24);

        PaymentsDisplayFrame = new JFrame("All Payments: ");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelNorth.setBackground(panAllColor);
        panelCenter.setBackground(panAllColor);
        panelSouth.setBackground(panAllColor);

        lblHeading = new JLabel("List Of All Payments:", JLabel.CENTER);

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

        PaymentsDisplayFrame.add(panelNorth, BorderLayout.NORTH);
        PaymentsDisplayFrame.add(panelSouth, BorderLayout.SOUTH);
        PaymentsDisplayFrame.add(panelCenter, BorderLayout.CENTER);

        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        //Set GUI:
        PaymentsDisplayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        PaymentsDisplayFrame.pack();
        PaymentsDisplayFrame.setSize(900, 600);
        PaymentsDisplayFrame.setLocationRelativeTo(null);
        PaymentsDisplayFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Display")){
            PaymentHttp paymentHttp = new PaymentHttp();
            taDisplay.append(paymentHttp.getAll());
        }

        if(e.getActionCommand().equals("Clear")){
            taDisplay.setText("");
        }

        if(e.getActionCommand().equals("Exit")){
            PaymentsDisplayFrame.dispose();
            PaymentMenu paymentMenu = new PaymentMenu();
            paymentMenu.setGUI();
        }
    }

}
