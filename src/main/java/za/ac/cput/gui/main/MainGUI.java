package za.ac.cput.gui.main;

import za.ac.cput.gui.customer.CustomerMenu;
import za.ac.cput.gui.driver.DriverMenu;
import za.ac.cput.gui.employee.EmployeeMenu;
import za.ac.cput.gui.owner.OwnerMenu;
import za.ac.cput.gui.payment.PaymentMenu;
import za.ac.cput.gui.role.RoleMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI implements ActionListener {

    private JFrame mainframe;
    private JPanel panelNorth, panelSouth, panelEast, panelWest, panelCenter;
    private JLabel lblHeading;
    private JButton btnEmp, btnCust, btnDriver, btnPay, btnOwner, btnRole, btnAddress;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5, Filler6, Filler7, Filler8, Filler9, Filler10;
    Color panAllColor = Color.CYAN;
    Color btnColor = Color.LIGHT_GRAY;
    private Font headingFont, ft1, ft2, ft3txt;

    public MainGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 35);
        ft1 = new Font("Arial", Font.BOLD, 32);
        ft2 = new Font("Arial", Font.PLAIN, 22);
        ft3txt = new Font("Arial", Font.PLAIN, 24);

        mainframe = new JFrame("Restaurant System");
        panelWest = new JPanel();
        panelNorth = new JPanel();
        panelEast = new JPanel();
        panelSouth = new JPanel();
        panelCenter = new JPanel();
        panelNorth.setBackground(panAllColor);
        panelEast.setBackground(panAllColor);
        panelSouth.setBackground(panAllColor);
        panelWest.setBackground(panAllColor);
        panelCenter.setBackground(panAllColor);


        //Fillers
        Filler1 = new JLabel("======");
        Filler2 = new JLabel("======");
        Filler3 = new JLabel("======");
        Filler4 = new JLabel("======");
        Filler1.setForeground(panAllColor);
        Filler2.setForeground(panAllColor);
        Filler3.setForeground(panAllColor);
        Filler4.setForeground(panAllColor);

        //Buttons
        btnEmp = new JButton("1. Human Resource");
        btnEmp.setBackground(btnColor);
        btnEmp.setFont(ft3txt);
        btnEmp.getIconTextGap();
        btnCust = new JButton("2. Customers");
        btnCust.setBackground(btnColor);
        btnCust.setFont(ft3txt);
        btnDriver = new JButton("3. Drivers");
        btnDriver.setBackground(btnColor);
        btnDriver.setFont(ft3txt);
        btnOwner = new JButton("4. Finance Dept");
        btnOwner.setBackground(btnColor);
        btnOwner.setFont(ft3txt);
        btnPay = new JButton("5. Owner Dept");
        btnPay.setBackground(btnColor);
        btnPay.setFont(ft3txt);
        btnRole = new JButton("6. Role Position");
        btnRole.setBackground(btnColor);
        btnRole.setFont(ft3txt);
        btnAddress = new JButton("7. Address");
        btnAddress.setBackground(btnColor);
        btnAddress.setFont(ft3txt);
    }

    public void setGUI() {
        panelNorth.setLayout(new GridLayout(1, 1));
        panelSouth.setLayout(new GridLayout(1, 1));
        panelWest.setLayout(new GridLayout(7, 1));
        panelCenter.setLayout(new GridLayout(7, 1));
        panelEast.setLayout(new GridLayout(7, 1));

        panelNorth.add(Filler4);

        panelWest.add(Filler1);

        panelEast.add(Filler2);

        panelSouth.add(Filler3);

        panelCenter.add(btnEmp);
        panelCenter.add(btnCust);
        panelCenter.add(btnDriver);
        panelCenter.add(btnOwner);
        panelCenter.add(btnPay);
        panelCenter.add(btnRole);
        panelCenter.add(btnAddress);

        //Adding panels to mainframe:
        mainframe.add(panelNorth, BorderLayout.NORTH);
        mainframe.add(panelSouth, BorderLayout.SOUTH);
        mainframe.add(panelEast, BorderLayout.EAST);
        mainframe.add(panelCenter, BorderLayout.CENTER);
        mainframe.add(panelWest, BorderLayout.WEST);

        //Adding actions to buttons
        btnCust.addActionListener(this);
        btnEmp.addActionListener(this);
        btnDriver.addActionListener(this);
        btnOwner.addActionListener(this);
        btnPay.addActionListener(this);
        btnRole.addActionListener(this);
        btnAddress.addActionListener(this);

        // Set GUI:
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setSize(900,600);
        mainframe.setLocationRelativeTo(null);
        mainframe.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("1. Human Resource"))
        {
            EmployeeMenu employeeMenu = new EmployeeMenu();
            employeeMenu.setGUI();
            mainframe.dispose();
        }
        if(e.getActionCommand().equals("2. Customers"))
        {
            CustomerMenu customerMenu = new CustomerMenu();
            customerMenu.setGUI();
        }
        if(e.getActionCommand().equals("3. Drivers"))
        {
            DriverMenu driverMenu = new DriverMenu();
            driverMenu.setGUI();
        }
        if(e.getActionCommand().equals("4. Finance Dept"))
        {
            PaymentMenu paymentMenu = new PaymentMenu();
            paymentMenu.setGUI();
        }
        if(e.getActionCommand().equals("5. Owner Dept"))
        {
            OwnerMenu ownerMenu = new OwnerMenu();
            ownerMenu.setGUI();
        }
        if(e.getActionCommand().equals("6. Role Position"))
        {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setGUI();
        }


    }

}
