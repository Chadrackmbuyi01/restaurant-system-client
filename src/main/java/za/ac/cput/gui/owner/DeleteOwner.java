package za.ac.cput.gui.owner;

import za.ac.cput.gui.payment.PaymentHttp;
import za.ac.cput.gui.payment.PaymentMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteOwner implements ActionListener {

    private JFrame OwnerDeleteFrame;
    private JPanel panelNorth, panelSouth,panelCenter;
    private JLabel lblHeading, lblOwnerId;
    private TextField txtOwnerName;
    private JButton btnDisplay, btnExit, btnClear;
    private Font headingFont, ft3txt;
    Color panAllColor = Color.GREEN;
    Color btnColor = Color.LIGHT_GRAY;
    public DeleteOwner() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 22);
        ft3txt = new Font("Arial", Font.PLAIN, 24);

        OwnerDeleteFrame = new JFrame("Deleting Owner ");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelNorth.setBackground(panAllColor);
        panelCenter.setBackground(panAllColor);
        panelSouth.setBackground(panAllColor);

        lblHeading = new JLabel("Deleting",JLabel.CENTER);
        lblOwnerId = new JLabel("Owner ID Number:");

        txtOwnerName = new TextField("");
        txtOwnerName.setFont(ft3txt);

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

        panelCenter.add(lblOwnerId);
        panelCenter.add(txtOwnerName);

        lblOwnerId.setFont(ft3txt);

        panelSouth.add(btnDisplay);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        lblHeading.setFont(headingFont);

        OwnerDeleteFrame.add(panelNorth, BorderLayout.NORTH);
        OwnerDeleteFrame.add(panelSouth, BorderLayout.SOUTH);
        OwnerDeleteFrame.add(panelCenter, BorderLayout.CENTER);

        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        //Set GUI:
        OwnerDeleteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        OwnerDeleteFrame.pack();
        OwnerDeleteFrame.setSize(900, 600);
        OwnerDeleteFrame.setLocationRelativeTo(null);
        OwnerDeleteFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Delete")){
            OwnerHttp ownerHttp = new OwnerHttp();
            int ownerId = Integer.parseInt(txtOwnerName.getText());
            ownerHttp.delete(ownerId);
        }

        if(e.getActionCommand().equals("Clear")){
            txtOwnerName.setText("");
        }

        if(e.getActionCommand().equals("Exit")){
            OwnerDeleteFrame.dispose();
            OwnerMenu ownerMenu = new OwnerMenu();
            ownerMenu.setGUI();
        }
    }
}
