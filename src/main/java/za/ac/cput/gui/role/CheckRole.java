package za.ac.cput.gui.role;

import za.ac.cput.gui.owner.OwnerHttp;
import za.ac.cput.gui.owner.OwnerMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckRole implements ActionListener {

    private JFrame RoleDisplayFrame;
    private JPanel panelNorth, panelSouth, panelCenter;
    private JLabel lblHeading, lblRoleId;
    private TextArea taCheck;
    private TextField txtRoleId;
    private JButton btnDisplay, btnExit, btnClear;
    private Font headingFont, ft3txt;
    Color panAllColor = Color.PINK;
    Color btnColor = Color.LIGHT_GRAY;

    public CheckRole() {
        // Text font
        headingFont = new Font("Arial", Font.BOLD, 20);
        ft3txt = new Font("Arial", Font.PLAIN, 19);

        RoleDisplayFrame = new JFrame("Role: ");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelNorth.setBackground(btnColor);
        panelCenter.setBackground(btnColor);
        panelSouth.setBackground(btnColor);

        lblHeading = new JLabel("Requested Role", JLabel.CENTER);
        lblRoleId = new JLabel("Role ID Number:");
        lblRoleId.setFont(ft3txt);

        taCheck = new TextArea("Role_ID\t\tRole_Description\n");

        txtRoleId = new TextField("");
        txtRoleId.setFont(ft3txt);

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

        panelCenter.add(lblRoleId);
        panelCenter.add(txtRoleId);
        panelCenter.add(taCheck);

        panelSouth.add(btnDisplay);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        lblHeading.setFont(headingFont);

        RoleDisplayFrame.add(panelNorth, BorderLayout.NORTH);
        RoleDisplayFrame.add(panelSouth, BorderLayout.SOUTH);
        RoleDisplayFrame.add(panelCenter, BorderLayout.CENTER);

        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);


        //Set GUI
        RoleDisplayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        RoleDisplayFrame.pack();
        RoleDisplayFrame.setSize(900, 600);
        RoleDisplayFrame.setLocationRelativeTo(null);
        RoleDisplayFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Display")) {
            RoleHttp roleHttp = new RoleHttp();
            int roleId = Integer.parseInt(txtRoleId.getText());
            taCheck.append(roleHttp.check(roleId));
        }

        if (e.getActionCommand().equals("Clear")) {
            taCheck.setText("");
            txtRoleId.setText("");
        }

        if (e.getActionCommand().equals("Exit")) {
            RoleDisplayFrame.dispose();
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setGUI();
        }

    }
}
