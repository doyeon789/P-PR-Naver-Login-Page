package lang_loginpage;

import javax.swing.*;
import java.awt.*;

public class FrameWork {
    public static void Frame(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int frameWidth = 580;
        int frameHeight = 700;

        frame.setSize(frameWidth, frameHeight);
        int x = (screenWidth - frameWidth) / 2;
        int y = (screenHeight - frameHeight) / 2;
        frame.setLocation(x, y);

        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void Panel(JPanel panel, JFrame frame) {
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        frame.add(panel);

        panel.removeAll();

        Login_KR.addFindid(panel);
        Login_KR.addFindPassword(panel);
        Login_KR.addSignup(panel);
        Login_KR.addInputSpace(panel);
        Login_KR.addLoginbutton(panel);
        Login_KR.addMaker(panel);
        Login_KR.addNaverLabel(panel);
        Login_KR.addLoginBoxLabel(panel);

        panel.revalidate();
        panel.repaint();
    }
}