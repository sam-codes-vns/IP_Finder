
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IP_Finder {
    public static void main(String[] args) {

        JFrame jFrame= new JFrame("IP FInder Program");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(600, 200);
        jFrame.setLayout(null);
//        jFrame.setBounds(100, 100, 1000, 100);
        jFrame.setVisible(true);

        JLabel label = new JLabel("Enter URL:");
        label.setBounds(20,30,100,30);
        jFrame.add(label);

        JTextField textField = new JTextField();
        textField.setBounds(100,30,200,30);
        jFrame.add(textField);

        JButton button = new JButton("Find IP");
        button.setBounds(310,30,90,30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String url = textField.getText();
                try{
                    InetAddress ia= InetAddress.getByName(url);
                    String ip = ia.getHostAddress();
                    JOptionPane.showMessageDialog(jFrame, "IP Address: " + ip, "IP Result", JOptionPane.INFORMATION_MESSAGE);

                }catch(UnknownHostException unknownHostException){
                    JOptionPane.showMessageDialog(jFrame, "Invalid URL or host not found", "Error", JOptionPane.ERROR_MESSAGE);
                    unknownHostException.printStackTrace();
                }
            }
        } );

        jFrame.add(button);
        jFrame.setLocationRelativeTo(null);
//        jFrame.setLayout(new GridLayout());

    }
}
