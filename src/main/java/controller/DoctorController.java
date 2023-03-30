package controller;
import presentation.AdminView;
import presentation.DoctorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DoctorController implements Controller{
    private static  DoctorController doctorc= new DoctorController();
    public static  DoctorController getInstance(){
        return doctorc;
    }
    public DoctorView doctorv;

    public DoctorController(){
        doctorv= DoctorView.getInstance();
        doctorv.bl2.addActionListener(new LogOut1Listener());
        doctorv.bb.addActionListener(new BackListener());
        final CloseAction closeAction = new CloseAction(doctorv.framea);
        doctorv.framea.addWindowListener(new WindowAdapter() {
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

            doctorv.panelm.setVisible(true);
        }
    }

    public class LogOut1Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e)
        {
            LogInController loginController = LogInController.getInstance();
            doctorv.framea.setVisible(false);
            loginController.loginv.frame.setVisible(true);
        }
    }
    public class ManageListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e)
        {
            doctorv.panelm.setVisible(false);

        }
    }


}