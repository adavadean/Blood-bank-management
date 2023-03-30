package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DoctorView {
    private static DoctorView doctorView = new DoctorView();
    public static DoctorView getInstance(){
        return doctorView;
    }
    public JFrame framea= new JFrame();
    public JPanel panela = new JPanel();
    public JPanel panel3 = new JPanel();
    public JButton bb = new JButton("Back");
    public JPanel panelm = new JPanel(new GridLayout(2, 2));
    public JButton bl2 = new JButton("Log out");
    public JPanel paneltp2 = new JPanel();
    public JTable tp2= new JTable();


    public DoctorView(){
        framea.setTitle("Doctor");
        framea.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        framea.setSize(1000, 600);
        panelm.add(bl2);
        panelm.setBorder(new EmptyBorder(40, 30, 40, 30));
        bb.setAlignmentX(0.5f);
        panel3.add(panelm);
        panel3.add(bb);
        panel3.setBorder(new EmptyBorder(20, 0, 20, 0));
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panela.add(panel3);
        tp2.setSize(new Dimension(1000, 400));
        paneltp2.add(tp2);
        panela.add(paneltp2);
        framea.add(panela);
        framea.setVisible(true);
    }
}
