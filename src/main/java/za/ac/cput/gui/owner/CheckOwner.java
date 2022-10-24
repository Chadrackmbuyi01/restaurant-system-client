package za.ac.cput.gui.owner;

import za.ac.cput.gui.payment.PaymentHttp;
import za.ac.cput.gui.payment.PaymentMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckOwner implements ActionListener {

    private JFrame OwnerDisplayFrame;
    private JPanel panelNorth, panelSouth, panelCenter;
    private JLabel lblHeading, lblOwnerId;
    private TextArea taCheck;
    private TextField txtOwnerId;
    private JButton btnDisplay, btnExit, btnClear;
    private Font headingFont, ft3txt;
    Color panAllColor = Color.GREEN;
    Color btnColor = Color.LIGHT_GRAY;

    public CheckOwner() {
        // Text font
        headingFont = new Font("Arial", Font.BOLD, 20);
        ft3txt = new Font("Arial", Font.PLAIN, 19);

        OwnerDisplayFrame = new JFrame("Owner: ");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelNorth.setBackground(btnColor);
        panelCenter.setBackground(btnColor);
        panelSouth.setBackground(btnColor);

        lblHeading = new JLabel("Requested Owner", JLabel.CENTER);
        lblOwnerId = new JLabel("Owner ID Number:");
        lblOwnerId.setFont(ft3txt);

        taCheck = new TextArea("Owner_ID\tFull_Name\n");

        txtOwnerId = new TextField("");
        txtOwnerId.setFont(ft3txt);

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

        panelCenter.add(lblOwnerId);
        panelCenter.add(txtOwnerId);
        panelCenter.add(taCheck);

        panelSouth.add(btnDisplay);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        lblHeading.setFont(headingFont);

        OwnerDisplayFrame.add(panelNorth, BorderLayout.NORTH);
        OwnerDisplayFrame.add(panelSouth, BorderLayout.SOUTH);
        OwnerDisplayFrame.add(panelCenter, BorderLayout.CENTER);

        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);


        //Set GUI
        OwnerDisplayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        OwnerDisplayFrame.pack();
        OwnerDisplayFrame.setSize(900, 600);
        OwnerDisplayFrame.setLocationRelativeTo(null);
        OwnerDisplayFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Display")) {
            OwnerHttp ownerHttp = new OwnerHttp();
            int ownerId = Integer.parseInt(txtOwnerId.getText());
            taCheck.append(ownerHttp.check(ownerId));
        }

        if (e.getActionCommand().equals("Clear")) {
            taCheck.setText("");
            txtOwnerId.setText("");
        }

        if (e.getActionCommand().equals("Exit")) {
            OwnerDisplayFrame.dispose();
            OwnerMenu ownerMenu = new OwnerMenu();
            ownerMenu.setGUI();
        }

    }
}
