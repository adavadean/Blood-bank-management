package controller;
import presentation.AdminView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
public class AdminController implements Controller{
    private static AdminController adminc= new AdminController();
    public static AdminController getInstance(){
        return adminc;
    }
    public AdminView adminv;

    public AdminController(){
        adminv= AdminView.getInstance();
        adminv.bl2.addActionListener(new LogOut1Listener());
        adminv.bm.addActionListener(new ManageListener());
        adminv.bb.addActionListener(new BackListener());
        final CloseAction closeAction = new CloseAction(adminv.framea);
        adminv.framea.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeAction.confirm();
            }
        });
    }
    @Override
    public Object checkInput() {
        return null;
    }
    public class BackListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e)
        {
            adminv.panelm2.setVisible(false);
            adminv.panelm.setVisible(true);
        }
    }

    public class LogOut1Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e)
        {
            LogInController loginController = LogInController.getInstance();
            adminv.framea.setVisible(false);
            loginController.loginv.frame.setVisible(true);
        }
    }
    public class ManageListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e)
        {
            adminv.panelm.setVisible(false);
            adminv.panelm2.setVisible(true);
        }
    }
    public class Adaugare1Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e)
        {
            adminv.panelm2.setVisible(false);

        }
    }
    public class Stergere1Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e)
        {
            adminv.panelm2.setVisible(false);

        }
    }
    public class Modificare1Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e)
        {

            adminv.panelm2.setVisible(false);
        }
    }



}

