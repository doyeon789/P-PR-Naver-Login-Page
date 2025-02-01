package lang_signuppage;

import lang_signuppage.KR.SignUp_KR;
import lang_signuppage.KR.signup_func.Signup_Function;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class SignupFrameWork extends Signup_Function {

    public SignupFrameWork(JPanel firstInput) {
        super(firstInput);
    }

    public static void sFrame(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int frameWidth = 580;
        int frameHeight = 700;

        frame.setSize(frameWidth, frameHeight);
        int x = (screenWidth - frameWidth) / 2;
        int y = (screenHeight - frameHeight) / 2;
        frame.setLocation(x, y);

        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void sPanel(JFrame sframe, JPanel s_panel1, JPanel s_panel2, JPanel s_panel3) {

        s_panel1.setLayout(null);
        s_panel1.setBackground(Color.white);
        s_panel1.setBounds(0, 0, 585, 45);

        sframe.add(s_panel1);


        try {
            handleKorean(s_panel1, s_panel2, s_panel3);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }


        s_panel2.setLayout(null);
        s_panel2.setBackground(Color.white);
        s_panel2.setBounds(0, 45, 580, 538);
        sframe.add(s_panel2);

        s_panel3.setLayout(null);
        s_panel3.setBackground(Color.white);
        s_panel3.setBounds(0, 583, 580, 117);
        sframe.add(s_panel3);
    }

    public static void handleKorean(JPanel s_panel1, JPanel s_panel2, JPanel s_panel3) {

        s_panel1.removeAll();

        SignUp_KR.addNaverLabel(s_panel1);
        SignUp_KR.addBackGround(s_panel2);
        Signup_Function.SendCode(s_panel3);

        s_panel1.revalidate();
        s_panel1.repaint();

        s_panel2.revalidate();
        s_panel2.repaint();

        s_panel3.revalidate();
        s_panel3.repaint();
    }
}