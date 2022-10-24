package za.ac.cput.gui.payment;

import za.ac.cput.gui.employee.EmployeeHttp;
import za.ac.cput.gui.employee.EmployeeMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeletePayment implements ActionListener {

    private JFrame PaymentDeleteFrame;
    private JPanel panelNorth, panelSouth,panelCenter;
    private JLabel lblHeading, lblPaymentId;
    private TextField txtPaymentId;
    private JButton btnDisplay, btnExit, btnClear;
    private Font headingFont, ft3txt;
    Color panAllColor = Color.GREEN;
    Color btnColor = Color.LIGHT_GRAY;
    public DeletePayment() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 22);
        ft3txt = new Font("Arial", Font.PLAIN, 24);

        PaymentDeleteFrame = new JFrame("Deleting Payment ");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelNorth.setBackground(panAllColor);
        panelCenter.setBackground(panAllColor);
        panelSouth.setBackground(panAllColor);

        lblHeading = new JLabel("Deleting",JLabel.CENTER);
        lblPaymentId = new JLabel("Payment ID Number:");

        txtPaymentId = new TextField("");
        txtPaymentId.setFont(ft3txt);

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

        panelCenter.add(lblPaymentId);
        panelCenter.add(txtPaymentId);

        lblPaymentId.setFont(ft3txt);

        panelSouth.add(btnDisplay);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        lblHeading.setFont(headingFont);

        PaymentDeleteFrame.add(panelNorth, BorderLayout.NORTH);
        PaymentDeleteFrame.add(panelSouth, BorderLayout.SOUTH);
        PaymentDeleteFrame.add(panelCenter, BorderLayout.CENTER);

        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        //Set GUI:
        PaymentDeleteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        PaymentDeleteFrame.pack();
        PaymentDeleteFrame.setSize(900, 600);
        PaymentDeleteFrame.setLocationRelativeTo(null);
        PaymentDeleteFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Delete")){
            PaymentHttp paymentHttp = new PaymentHttp();
            String paymentId = txtPaymentId.getText();
            paymentHttp.delete(paymentId);
        }

        if(e.getActionCommand().equals("Clear")){
            txtPaymentId.setText("");
        }

        if(e.getActionCommand().equals("Exit")){
            PaymentDeleteFrame.dispose();
            PaymentMenu paymentMenu = new PaymentMenu();
            paymentMenu.setGUI();
        }
    }
}
