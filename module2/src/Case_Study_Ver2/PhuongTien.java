package Case_Study_Ver2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhuongTien {

    private JPanel panel1;
    private JTextPane CHƯƠNGTRÌNHQUẢNLÝTextPane;
    private JButton thêmMớiPhươngTiệnButton;
    private JButton hiệnThịPhươngTiệnButton;
    private JButton xóaPhươngTiệnButton;
    private JButton thoátButton;

    public PhuongTien() {
        hiệnThịPhươngTiệnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"oto");
            }
        });
    }

    public static void main(String[] args) {
        JFrame jFrame= new JFrame("Phuong Tien");
        jFrame.setContentPane(new PhuongTien().panel1);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
