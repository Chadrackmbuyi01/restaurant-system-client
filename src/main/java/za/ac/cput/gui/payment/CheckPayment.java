package za.ac.cput.gui.payment;

import za.ac.cput.gui.employee.EmployeeHttp;
import za.ac.cput.gui.employee.EmployeeMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckPayment implements ActionListener {

    private JFrame PaymentDisplayFrame;
    private JPanel panelNorth, panelSouth, panelCenter;
    private JLabel lblHeading, lblPaymentId;
    private TextArea taCheck;
    private TextField txtPaymentId;
    private JButton btnDisplay, btnExit, btnClear;
    private Font headingFont, ft3txt;
    Color panAllColor = Color.GREEN;
    Color btnColor = Color.LIGHT_GRAY;

    public CheckPayment() {
        // Text font
        headingFont = new Font("Arial", Font.BOLD, 20);
        ft3txt = new Font("Arial", Font.PLAIN, 19);

        PaymentDisplayFrame = new JFrame("Payment: ");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelNorth.setBackground(btnColor);
        panelCenter.setBackground(btnColor);
        panelSouth.setBackground(btnColor);

        lblHeading = new JLabel("Requested Payment", JLabel.CENTER);
        lblPaymentId = new JLabel("Payment ID Number:");
        lblPaymentId.setFont(ft3txt);

        taCheck = new TextArea("PaymentID\tCash_Payment_Amount\tCard_Payment_Amount\tEft_Payment_Amount\n");

        txtPaymentId = new TextField("");
        txtPaymentId.setFont(ft3txt);

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

        panelCenter.add(lblPaymentId);
        panelCenter.add(txtPaymentId);
        panelCenter.add(taCheck);

        panelSouth.add(btnDisplay);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        lblHeading.setFont(headingFont);

        PaymentDisplayFrame.add(panelNorth, BorderLayout.NORTH);
        PaymentDisplayFrame.add(panelSouth, BorderLayout.SOUTH);
        PaymentDisplayFrame.add(panelCenter, BorderLayout.CENTER);

        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);


        //Set GUI
        PaymentDisplayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        PaymentDisplayFrame.pack();
        PaymentDisplayFrame.setSize(900, 600);
        PaymentDisplayFrame.setLocationRelativeTo(null);
        PaymentDisplayFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Display")) {
            PaymentHttp paymentHttp = new PaymentHttp();
            String paymentId = txtPaymentId.getText();
            taCheck.append(paymentHttp.check(String.valueOf(paymentId)));
        }

        if (e.getActionCommand().equals("Clear")) {
            taCheck.setText("");
            txtPaymentId.setText("");
        }

        if (e.getActionCommand().equals("Exit")) {
            PaymentDisplayFrame.dispose();
            PaymentMenu paymentMenu = new PaymentMenu();
            paymentMenu.setGUI();
        }

    }
}
