package za.ac.cput.gui.role;

import za.ac.cput.gui.owner.OwnerHttp;
import za.ac.cput.gui.owner.OwnerMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRole implements ActionListener {

    private JFrame AddRoleFrame;
    private JPanel panelNorth, panelSouth,panelCenter;
    private JLabel lblHeading;
    private JLabel lblRoleId, lblRoleName;
    private JTextField txtRoleId, txtRoleName;
    private JButton btnSave, btnExit, btnClear;
    private Font headingFont, ft3txt;
    Color panAllColor = Color.PINK;
    Color btnColor = Color.LIGHT_GRAY;

    public AddRole(){

        headingFont = new Font("Arial", Font.BOLD, 20);
        ft3txt = new Font("Arial", Font.PLAIN, 24);

        AddRoleFrame = new JFrame("Role: ");
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        panelCenter = new JPanel();
        panelNorth.setBackground(panAllColor);
        panelSouth.setBackground(panAllColor);
        panelCenter.setBackground(panAllColor);

        lblHeading = new JLabel("New Role Registry",JLabel.CENTER);


        lblRoleId = new JLabel("Role ID:");
        lblRoleId.setFont(ft3txt);
        lblRoleName = new JLabel("Role Description:");
        lblRoleName.setFont(ft3txt);


        txtRoleId = new JTextField();
        txtRoleId.setFont(ft3txt);
        txtRoleName = new JTextField();
        txtRoleName.setFont(ft3txt);


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

        panelCenter.add(lblRoleId);
        panelCenter.add(txtRoleId);
        panelCenter.add(lblRoleName);
        panelCenter.add(txtRoleName);

        panelSouth.add(btnSave);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        lblHeading.setFont(headingFont);

        AddRoleFrame.add(panelNorth, BorderLayout.NORTH);
        AddRoleFrame.add(panelSouth, BorderLayout.SOUTH);
        AddRoleFrame.add(panelCenter, BorderLayout.CENTER);

        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);


        AddRoleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        AddRoleFrame.pack();
        AddRoleFrame.setSize(900, 600);
        AddRoleFrame.setLocationRelativeTo(null);
        AddRoleFrame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Save")){

            int roleId = Integer.parseInt(txtRoleId.getText());
            String roleName = txtRoleName.getText();

            RoleHttp roleHttp = new RoleHttp();

            roleHttp.save(roleId,roleName);


        }

        if(e.getActionCommand().equals("Clear")){

            txtRoleId.setText("");
            txtRoleName.setText("");
        }

        if(e.getActionCommand().equals("Exit")){
            AddRoleFrame.dispose();
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setGUI();
        }

    }
}
