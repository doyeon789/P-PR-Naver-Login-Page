package lang_signuppage.KR;

import lang_signuppage.KR.signup_func.Signup_Function;
import lang_signuppage.SignupMain;

import javax.swing.*;
import java.awt.*;

public class SignUp_KR extends SignupMain {

    public static void addNaverLabel(JPanel panel) {

        JLabel naver = new JLabel();
        int naver_width = 80;
        int naver_height = 15;
        ImageIcon icon = new ImageIcon("img_Com/logo.png");
        Image naver_img = icon.getImage();
        Image logo = naver_img.getScaledInstance(naver_width, naver_height, 4);
        naver.setIcon(new ImageIcon(logo));
        naver.setBounds(95, 20, naver_width, naver_height);

        panel.add(naver);

        panel.revalidate();
        panel.repaint();
    }
    public static void addBackGround(JPanel panel) {

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS)); // area에 BoxLayout을 적용
        Blank1(contentPane);
        Input(addWithLeftMargin(contentPane));

        JScrollPane scrollPane = new JScrollPane(contentPane); // JScrollPane로 변경
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // 수직 스크롤 항상 표시
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(0, 45, 580, 655);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.white));
        panel.add(scrollPane);

        panel.revalidate();
        panel.repaint();
    }
    public static JPanel addWithLeftMargin(JPanel parentPanel) {
        JPanel panelWithMargin = new JPanel();
        panelWithMargin.setLayout(new BorderLayout()); // 왼쪽 정렬을 위해 BorderLayout 사용
        panelWithMargin.add(Box.createHorizontalStrut(70), BorderLayout.WEST); // 왼쪽 여백 추가
        panelWithMargin.setBackground(Color.white);
        parentPanel.add(panelWithMargin);
        return panelWithMargin;
    }
    public static void Blank1(JPanel contentPane){
        JPanel blank = new JPanel();
        blank.setPreferredSize(new Dimension(580,30));
        blank.setBackground(Color.white);
        contentPane.add(blank);
    }
    public static void Input(JPanel contentPane){

        JPanel first_input = new JPanel();
        first_input.setPreferredSize(new Dimension(580, 150));
        first_input.setBackground(Color.white); // 배경색 설정
        first_input.setLayout(null);

        JLabel signupframe1 = new JLabel();
        signupframe1.setBounds(0, 0, 440, 135); // 위치 및 크기 설정
        ImageIcon icon = new ImageIcon("img_Com/Signup_img/signup_one_frame.png"); // 이미지 경로 수정
        Image signup_one = icon.getImage();
        Image logo = signup_one.getScaledInstance(440, 135, 4);
        signupframe1.setIcon(new ImageIcon(logo)); // 이미지 설정

        new Signup_Function(first_input);

        first_input.add(signupframe1);
        contentPane.add(first_input);
        contentPane.revalidate();
        contentPane.repaint();
    }
}