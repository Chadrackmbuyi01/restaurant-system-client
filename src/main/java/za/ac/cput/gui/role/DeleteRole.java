package za.ac.cput.gui.role;

import za.ac.cput.gui.owner.OwnerHttp;
import za.ac.cput.gui.owner.OwnerMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteRole implements ActionListener {

    private JFrame RoleDeleteFrame;
    private JPanel panelNorth, panelSouth,panelCenter;
    private JLabel lblHeading, lblRoleId;
    private TextField txtRoleName;
    private JButton btnDisplay, btnExit, btnClear;
    private Font headingFont, ft3txt;
    Color panAllColor = Color.PINK;
    Color btnColor = Color.LIGHT_GRAY;
    public DeleteRole() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 22);
        ft3txt = new Font("Arial", Font.PLAIN, 24);

        RoleDeleteFrame = new JFrame("Deleting Role ");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelNorth.setBackground(panAllColor);
        panelCenter.setBackground(panAllColor);
        panelSouth.setBackground(panAllColor);

        lblHeading = new JLabel("Deleting",JLabel.CENTER);
        lblRoleId = new JLabel("Role ID Number:");

        txtRoleName = new TextField("");
        txtRoleName.setFont(ft3txt);

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

        panelCenter.add(lblRoleId);
        panelCenter.add(txtRoleName);

        lblRoleId.setFont(ft3txt);

        panelSouth.add(btnDisplay);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        lblHeading.setFont(headingFont);

        RoleDeleteFrame.add(panelNorth, BorderLayout.NORTH);
        RoleDeleteFrame.add(panelSouth, BorderLayout.SOUTH);
        RoleDeleteFrame.add(panelCenter, BorderLayout.CENTER);

        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        //Set GUI:
        RoleDeleteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        RoleDeleteFrame.pack();
        RoleDeleteFrame.setSize(900, 600);
        RoleDeleteFrame.setLocationRelativeTo(null);
        RoleDeleteFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Delete")){
            RoleHttp roleHttp = new RoleHttp();
            int roleId = Integer.parseInt(txtRoleName.getText());
            roleHttp.delete(roleId);
        }

        if(e.getActionCommand().equals("Clear")){
            txtRoleName.setText("");
        }

        if(e.getActionCommand().equals("Exit")){
            RoleDeleteFrame.dispose();
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setGUI();
        }
    }
}
