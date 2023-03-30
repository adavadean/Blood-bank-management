package controller;
import business.Donator;
import business.Service;
import presentation.SignUpView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class SignUpController implements Controller {
    private static SignUpController signupc = new SignUpController();
    private Service service;

    public static SignUpController getInstance() {
        return signupc;
    }

    public SignUpView signupv;
    public Service d1 = new Service();

    public SignUpController() {
        signupv = SignUpView.getInstance();

        signupv.bs1.addActionListener(new SignupListener());

        final CloseAction closeAction = new CloseAction(signupv.frames1);
        signupv.frames1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeAction.confirm();
            }
        });

    }

    @Override
    public Object checkInput() throws Exception {
        String username = signupv.usert1.getText();
        String password = signupv.passt1.getText();

        if (username.equals("")) {
            JOptionPane.showMessageDialog(null, "Username-ul lipseste!", "Eroare!", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Username field is empty");
        }
        if (password.equals("")) {
            JOptionPane.showMessageDialog(null, "Parola lipseste!", "Eroare!", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Password field is empty");
        }
        return new Donator(username, password);
    }

    public class SignupListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            Donator donatornou= null;
            try {
                donatornou = (Donator) checkInput();
                System.out.println(donatornou.getUsername());
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            d1.creareUser(donatornou);
            if(donatornou != null)
            {
                JOptionPane.showMessageDialog(null, "User nou creat cu succes!", "Succes!", JOptionPane.INFORMATION_MESSAGE);
                signupv.frames1.setVisible(false);
                LogInController loginController = LogInController.getInstance();
                loginController.loginv.frame.setVisible(true);
            }
        }
    }
}









