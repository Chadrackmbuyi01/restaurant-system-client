package za.ac.cput.gui.role;

import za.ac.cput.gui.owner.OwnerHttp;
import za.ac.cput.gui.owner.OwnerMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayAllRoles implements ActionListener {

    private JFrame RolesDisplayFrame;
    private JPanel panelNorth, panelSouth,panelCenter;
    private JLabel lblHeading;
    private TextArea taDisplay;
    private JButton btnDisplay, btnExit, btnClear;
    private Font headingFont, ft3txt;
    Color panAllColor = Color.PINK;
    Color btnColor = Color.LIGHT_GRAY;
    public DisplayAllRoles() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 20);
        ft3txt = new Font("Arial", Font.PLAIN, 24);

        RolesDisplayFrame = new JFrame("All Roles Description: ");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelNorth.setBackground(panAllColor);
        panelCenter.setBackground(panAllColor);
        panelSouth.setBackground(panAllColor);

        lblHeading = new JLabel("List Of All Roles Description:", JLabel.CENTER);

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

        RolesDisplayFrame.add(panelNorth, BorderLayout.NORTH);
        RolesDisplayFrame.add(panelSouth, BorderLayout.SOUTH);
        RolesDisplayFrame.add(panelCenter, BorderLayout.CENTER);

        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        //Set GUI:
        RolesDisplayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        RolesDisplayFrame.pack();
        RolesDisplayFrame.setSize(900, 600);
        RolesDisplayFrame.setLocationRelativeTo(null);
        RolesDisplayFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Display")){
            RoleHttp roleHttp = new RoleHttp();
            taDisplay.append(roleHttp.getAll());
        }

        if(e.getActionCommand().equals("Clear")){
            taDisplay.setText("");
        }

        if(e.getActionCommand().equals("Exit")){
            RolesDisplayFrame.dispose();
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setGUI();
        }
    }
}
