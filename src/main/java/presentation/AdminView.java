package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AdminView {
    private static AdminView adminView = new AdminView();
    public static AdminView getInstance(){
        return adminView;
    }
    public JFrame framea= new JFrame();
    public JPanel panela = new JPanel();
    public JPanel panel3 = new JPanel();
    public JButton bb = new JButton("Back");
    public JPanel panelm = new JPanel(new GridLayout(2, 2));
    public JButton bm = new JButton("Create");
    public JButton bm2 = new JButton("Read");
    public JButton br2 = new JButton("Update");
    public JButton d = new JButton("Delete");
    public JButton bl2 = new JButton("Log out");
    public JPanel paneltp2 = new JPanel();
    public JTable tp2= new JTable();
    public JPanel panelm2 = new JPanel();

    public AdminView(){
        framea.setTitle("Administrator");
        framea.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        framea.setSize(1000, 600);
        panelm.add(bm);
        panelm.add(bm2);
        panelm.add(br2);
        panelm.add(d);
        panelm.add(bl2);
        panelm.setBorder(new EmptyBorder(40, 30, 40, 30));
        panelm2.setLayout(new BoxLayout(panelm2, BoxLayout.Y_AXIS));
        panelm2.setBorder(new EmptyBorder(40, 30, 40, 30));
        panelm2.setVisible(false);
        bb.setAlignmentX(0.5f);
        panel3.add(panelm);
        panel3.add(panelm2);
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
