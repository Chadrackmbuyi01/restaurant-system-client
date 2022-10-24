package za.ac.cput.gui.owner;

import za.ac.cput.gui.payment.PaymentHttp;
import za.ac.cput.gui.payment.PaymentMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayAllOwners implements ActionListener {

    private JFrame OwnersDisplayFrame;
    private JPanel panelNorth, panelSouth,panelCenter;
    private JLabel lblHeading;
    private TextArea taDisplay;
    private JButton btnDisplay, btnExit, btnClear;
    private Font headingFont, ft3txt;
    Color panAllColor = Color.GREEN;
    Color btnColor = Color.LIGHT_GRAY;
    public DisplayAllOwners() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 20);
        ft3txt = new Font("Arial", Font.PLAIN, 24);

        OwnersDisplayFrame = new JFrame("All Owners: ");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelNorth.setBackground(panAllColor);
        panelCenter.setBackground(panAllColor);
        panelSouth.setBackground(panAllColor);

        lblHeading = new JLabel("List Of All Owners:", JLabel.CENTER);

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

        OwnersDisplayFrame.add(panelNorth, BorderLayout.NORTH);
        OwnersDisplayFrame.add(panelSouth, BorderLayout.SOUTH);
        OwnersDisplayFrame.add(panelCenter, BorderLayout.CENTER);

        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        //Set GUI:
        OwnersDisplayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        OwnersDisplayFrame.pack();
        OwnersDisplayFrame.setSize(900, 600);
        OwnersDisplayFrame.setLocationRelativeTo(null);
        OwnersDisplayFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Display")){
            OwnerHttp ownerHttp = new OwnerHttp();
            taDisplay.append(ownerHttp.getAll());
        }

        if(e.getActionCommand().equals("Clear")){
            taDisplay.setText("");
        }

        if(e.getActionCommand().equals("Exit")){
            OwnersDisplayFrame.dispose();
            OwnerMenu ownerMenu = new OwnerMenu();
            ownerMenu.setGUI();
        }
    }
}
