package controller;
import presentation.DonatorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DonatorController implements Controller{
    private static DonatorController donatorc = new DonatorController();
    public static DonatorController getInstance(){
        return donatorc;
    }
    public DonatorView donatorv;
    public DonatorController(){
        donatorv = DonatorView.getInstance();
        donatorv.bl.addActionListener(new LogOutListener());
        final CloseAction closeAction = new CloseAction(donatorv.framec);
        donatorv.framec.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeAction.confirm();
            }
        });
    }

    @Override
    public Object checkInput() throws Exception {
        return null;
    }


    public class SearchListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try {
                checkInput();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
    public class LogOutListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e)
        {
            LogInController loginController = LogInController.getInstance();
            donatorv.framec.setVisible(false);
            loginController.loginv.frame.setVisible(true);
        }
    }

}