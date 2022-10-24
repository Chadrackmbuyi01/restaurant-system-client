package za.ac.cput.gui.payment;

import za.ac.cput.gui.employee.EmployeeHttp;
import za.ac.cput.gui.employee.EmployeeMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPayment implements ActionListener {

    private JFrame AddPaymentFrame;
    private JPanel panelNorth, panelSouth,panelCenter;
    private JLabel lblHeading;
    private JLabel lblPaymentId, lblPayCash, lblPayCard, lblPayEft;
    private JTextField txtPaymentId, txtPayCash, txtPayCard, txtPayEft;
    private JButton btnSave, btnExit, btnClear;
    private Font headingFont, ft3txt;
    Color panAllColor = Color.GREEN;
    Color btnColor = Color.LIGHT_GRAY;

    public AddPayment(){

        headingFont = new Font("Arial", Font.BOLD, 20);
        ft3txt = new Font("Arial", Font.PLAIN, 24);

        AddPaymentFrame = new JFrame("Payment: ");
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        panelCenter = new JPanel();
        panelNorth.setBackground(panAllColor);
        panelSouth.setBackground(panAllColor);
        panelCenter.setBackground(panAllColor);

        lblHeading = new JLabel("New Payment Registry",JLabel.CENTER);


        lblPaymentId = new JLabel("Payment ID:");
        lblPaymentId.setFont(ft3txt);
        lblPayCash = new JLabel("Cash Payment Amount:");
        lblPayCash.setFont(ft3txt);
        lblPayCard = new JLabel("Card Payment Amount:");
        lblPayCard.setFont(ft3txt);
        lblPayEft = new JLabel("EFT Payment Amount:");
        lblPayEft.setFont(ft3txt);


        txtPaymentId = new JTextField();
        txtPaymentId.setFont(ft3txt);
        txtPayCash = new JTextField();
        txtPayCash.setFont(ft3txt);
        txtPayCard = new JTextField();
        txtPayCard.setFont(ft3txt);
        txtPayEft = new JTextField();
        txtPayEft.setFont(ft3txt);


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

        panelCenter.add(lblPaymentId);
        panelCenter.add(txtPaymentId);
        panelCenter.add(lblPayCash);
        panelCenter.add(txtPayCash);
        panelCenter.add(lblPayCard);
        panelCenter.add(txtPayCard);
        panelCenter.add(lblPayEft);
        panelCenter.add(txtPayEft);

        panelSouth.add(btnSave);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        lblHeading.setFont(headingFont);

        AddPaymentFrame.add(panelNorth, BorderLayout.NORTH);
        AddPaymentFrame.add(panelSouth, BorderLayout.SOUTH);
        AddPaymentFrame.add(panelCenter, BorderLayout.CENTER);

        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);


        AddPaymentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        AddPaymentFrame.pack();
        AddPaymentFrame.setSize(900, 600);
        AddPaymentFrame.setLocationRelativeTo(null);
        AddPaymentFrame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Save")){

            String paymentId = txtPaymentId.getText();
            String payCash = txtPayCash.getText();
            String payCard = txtPayCard.getText();
            String payEft = txtPayEft.getText();

            PaymentHttp paymentHttp = new PaymentHttp();

            paymentHttp.save(paymentId,payCash,payCard,payEft);


        }

        if(e.getActionCommand().equals("Clear")){

            txtPaymentId.setText("");
            txtPayCash.setText("");
            txtPayCard.setText("");
            txtPayEft.setText("");
        }

        if(e.getActionCommand().equals("Exit")){
            AddPaymentFrame.dispose();
            PaymentMenu paymentMenu = new PaymentMenu();
            paymentMenu.setGUI();
        }

    }
}
