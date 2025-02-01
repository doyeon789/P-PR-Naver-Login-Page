package lang_signuppage_document;

import lang_signuppage_document.KR.Agreement_KR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AgreeFrameWork {
    public static void aFrame(JFrame a_frame, JLabel signup_kr) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int frameWidth = 580;
        int frameHeight = 700;

        a_frame.setSize(frameWidth, frameHeight);
        int x = (screenWidth - frameWidth) / 2;
        int y = (screenHeight - frameHeight) / 2;
        a_frame.setLocation(x, y);

        a_frame.setResizable(false);
        a_frame.setVisible(true);
        a_frame.getContentPane();
        a_frame.setLayout(null);
        a_frame.setVisible(true);
        a_frame.setResizable(false);
    }

    public static void aPanel(JFrame aframe, JPanel a_panel1, JPanel a_panel2, JPanel a_panel3) {

        a_panel1.setLayout(null);
        a_panel1.setBackground(Color.white);
        a_panel1.setBounds(0, 0, 585, 45);

        aframe.add(a_panel1);

        handleKorean(a_panel1, a_panel2, a_panel3);


        a_panel2.setLayout(null);
        a_panel2.setBackground(Color.white);
        a_panel2.setBounds(0, 45, 580, 538);
        aframe.add(a_panel2);


        a_panel3.setLayout(null);
        a_panel3.setBackground(Color.white);
        a_panel3.setBounds(0, 583, 580, 95);
        aframe.add(a_panel3);

    }

    public static void handleKorean(JPanel a_panel1, JPanel a_panel2, JPanel a_panel3) {

        a_panel1.removeAll();

        Agreement_KR.addNaverLabel(a_panel1);
        Agreement_KR.addBackGround(a_panel2);
        Agreement_KR.aNextButton(a_panel3);

        a_panel1.revalidate();
        a_panel1.repaint();

        a_panel2.revalidate();
        a_panel2.repaint();

        a_panel3.revalidate();
        a_panel3.repaint();
    }
}