package presentation;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class DonatorView {
    private static DonatorView donatorView = new DonatorView();
    public static DonatorView getInstance(){
        return donatorView;
    }
    public JFrame framec= new JFrame();
    public JPanel panelc = new JPanel();
    public JButton br = new JButton("Refresh");
    public JButton bl = new JButton("Log out");
    public JPanel panel2= new JPanel();
    public JPanel panela = new JPanel();
    JLabel edit = new JLabel("Editare cont");
    JPanel panelid = new JPanel();
    JLabel idl = new JLabel("Id:");
    public JComboBox<Integer> c = new JComboBox<>();
    public JButton ba = new JButton("Stergere cont");
    public JButton bf = new JButton("Vizulizare locatii");
    public JPanel panels= new JPanel();

    public DonatorView(){

        framec.setTitle("Donator");
        framec.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        framec.setSize(1000, 500);
        panels.setBorder(new EmptyBorder(40, 30, 40, 30));
        panels.setLayout(new BoxLayout(panels, BoxLayout.Y_AXIS));
        edit.setAlignmentX(0.5f);
        panelid.add(idl);
        panelid.add(c);
        panela.add(edit);
        panela.add(panelid);
        panela.add(ba);
        panela.add(bf);
        panela.setBorder(new EmptyBorder(40, 30, 40, 30));
        panela.setLayout(new BoxLayout(panela, BoxLayout.Y_AXIS));
        panel2.add(panels);
        panel2.add(panela);
        panel2.add(br);
        panel2.add(bl);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panelc.add(panel2);
        framec.add(panelc);
        framec.setVisible(true);
        br.setAlignmentX(0.5f);
        bl.setAlignmentX(0.5f);

    }
}
