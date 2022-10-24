package za.ac.cput.gui.owner;

import za.ac.cput.gui.payment.PaymentHttp;
import za.ac.cput.gui.payment.PaymentMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddOwner implements ActionListener {

    private JFrame AddOwnerFrame;
    private JPanel panelNorth, panelSouth,panelCenter;
    private JLabel lblHeading;
    private JLabel lblOwnerId, lblOwnerName;
    private JTextField txtOwnerId, txtOwnerName;
    private JButton btnSave, btnExit, btnClear;
    private Font headingFont, ft3txt;
    Color panAllColor = Color.GREEN;
    Color btnColor = Color.LIGHT_GRAY;

    public AddOwner(){

        headingFont = new Font("Arial", Font.BOLD, 20);
        ft3txt = new Font("Arial", Font.PLAIN, 24);

        AddOwnerFrame = new JFrame("Owner: ");
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        panelCenter = new JPanel();
        panelNorth.setBackground(panAllColor);
        panelSouth.setBackground(panAllColor);
        panelCenter.setBackground(panAllColor);

        lblHeading = new JLabel("New Owner Registry",JLabel.CENTER);


        lblOwnerId = new JLabel("Owner ID:");
        lblOwnerId.setFont(ft3txt);
        lblOwnerName = new JLabel("Owner Full Name:");
        lblOwnerName.setFont(ft3txt);


        txtOwnerId = new JTextField();
        txtOwnerId.setFont(ft3txt);
        txtOwnerName = new JTextField();
        txtOwnerName.setFont(ft3txt);


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
        panelCenter.setLayout(new GridLayout(3, 2));

        panelNorth.add(lblHeading);

        panelCenter.add(lblOwnerId);
        panelCenter.add(txtOwnerId);
        panelCenter.add(lblOwnerName);
        panelCenter.add(txtOwnerName);

        panelSouth.add(btnSave);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        lblHeading.setFont(headingFont);

        AddOwnerFrame.add(panelNorth, BorderLayout.NORTH);
        AddOwnerFrame.add(panelSouth, BorderLayout.SOUTH);
        AddOwnerFrame.add(panelCenter, BorderLayout.CENTER);

        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);


        AddOwnerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        AddOwnerFrame.pack();
        AddOwnerFrame.setSize(900, 600);
        AddOwnerFrame.setLocationRelativeTo(null);
        AddOwnerFrame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Save")){

            int ownerId = Integer.parseInt(txtOwnerId.getText());
            String ownerName = txtOwnerName.getText();

            OwnerHttp ownerHttp = new OwnerHttp();

            ownerHttp.save(ownerId,ownerName);


        }

        if(e.getActionCommand().equals("Clear")){

            txtOwnerId.setText("");
            txtOwnerName.setText("");
        }

        if(e.getActionCommand().equals("Exit")){
            AddOwnerFrame.dispose();
            OwnerMenu ownerMenu = new OwnerMenu();
            ownerMenu.setGUI();
        }

    }
}
