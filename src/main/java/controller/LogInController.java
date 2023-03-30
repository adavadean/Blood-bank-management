package controller;
import business.*;
import presentation.LogInView;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;
public class LogInController implements Controller{
    private static LogInController loginc = new LogInController();
    public static LogInController getInstance(){
        return loginc;
    }
    public LogInView loginv;
    private Service d;
    public Donator donatorcurent;
    public LogInController(){

        this.loginv = LogInView.getInstance();
        this.d = Service.getInstance();
        loginv.b.addActionListener(new LoginListener());
        loginv.bs.addActionListener(new SignupListener());

        final CloseAction closeAction = new CloseAction(loginv.frame);
        loginv.frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeAction.confirm();
            }
        });
        d.afisare();
    }
    @Override
    public User checkInput() throws Exception {
        String username = loginv.usert.getText();
        String password = loginv.passt.getText();
        if(username.equals("")){
            JOptionPane.showMessageDialog(null, "Username-ul lipseste!", "Eroare!", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Username field is empty");
        }
        if(password.equals("")){
            JOptionPane.showMessageDialog(null, "Parola lipseste!", "Eroare", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Password field is empty");
        }

        if(username.equals("Ada"))
        {
            if(password.equals("admin"))
            {
                return new Admin();
            }
        }
        if(username.equals("doctor1"))
        {
            if(password.equals("doc"))
            {
                return new Doctor();
            }
        }

        List<Donator> donators = d.getDonatori();
        for(Donator donator : donators){
            if(donator.getUsername().equals(username))
            {
                donatorcurent = donator;
                break;
            }
        }
        if(donatorcurent == null)
        {
            JOptionPane.showMessageDialog(null, "Acest user nu exista!", "Eroare!", JOptionPane.ERROR_MESSAGE);

        }

        if(!donatorcurent.getPassword().equals(password))
        {
            JOptionPane.showMessageDialog(null, "Parola incorecta!", "Eroare!", JOptionPane.ERROR_MESSAGE);

        }

        return donatorcurent;
    }
    class LoginListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e)
        {
            User usercurent= new Donator("ada","aa");

            try {
                usercurent = checkInput();
                if(usercurent!= null)
                {
                    loginv.frame.setVisible(false);
                    if(usercurent instanceof Donator)
                    {
                        DonatorController.getInstance().donatorv.framec.setVisible(true);
                    }else if(usercurent instanceof Admin)
                    {

                        AdminController.getInstance().adminv.framea.setVisible(true);
                    }else if(usercurent instanceof Doctor)
                    {

                        DoctorController.getInstance().doctorv.framea.setVisible(true);
                    }
                }

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
    class SignupListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e)
        {
            SignUpController signupController = SignUpController.getInstance();
            loginv.frame.setVisible(false);
            signupController.signupv.frames1.setVisible(true);
        }
    }
}