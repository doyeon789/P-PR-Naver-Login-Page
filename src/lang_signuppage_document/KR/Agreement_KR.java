package lang_signuppage_document.KR;

import lang_signuppage.SignupMain;
import lang_signuppage_document.KR.Text_Doc_KR.PP_Agreement_KR;
import lang_signuppage_document.KR.Text_Doc_KR.TOLBS_Agreement_KR;
import lang_signuppage_document.KR.Text_Doc_KR.TOS_Agreement_KR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class Agreement_KR extends SignupMain {

    static boolean[] check_count = {false, false, false, false, false, false, false, false};
    static boolean[] VITAL = {false, false};

    static JLabel all_agree_B;
    static JLabel TOS_agree_B;
    static JLabel PP_agree_B;
    static JLabel SURN_agree_B;
    static JLabel TOLBS_agree_B;
    static JLabel PP2_agree_B1;
    static JLabel PP2_agree_B;
    static JLabel Next_B;

    static JLabel C_Daum;

    public static void addNaverLabel(JPanel panel) {
        Arrays.fill(check_count, false);
        Arrays.fill(VITAL,false);


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

        all_agree_B = new JLabel();
        TOS_agree_B = new JLabel();
        PP_agree_B = new JLabel();
        SURN_agree_B = new JLabel();
        TOLBS_agree_B = new JLabel();
        PP2_agree_B1 = new JLabel();
        PP2_agree_B = new JLabel();
        Next_B = new JLabel();
        C_Daum  = new JLabel("다음");

        agreement_all(addWithLeftMargin(contentPane));
        TermsOfService(addWithLeftMargin(contentPane));
        PrivacyPolicy(addWithLeftMargin(contentPane));
        SignUpRealName(addWithLeftMargin(contentPane));
        TermsOfLocationBasedServices(addWithLeftMargin(contentPane));
        PrivacyPolicy2(addWithLeftMargin(contentPane));

        JScrollPane scrollPane = new JScrollPane(contentPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // 수직 스크롤 항상 표시
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(0, 0, 580, 530);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.white));
        panel.add(scrollPane);

        panel.revalidate();
        panel.repaint();
    }
    public static void aNextButton(JPanel panel) {
        ImageIcon icon = new ImageIcon("img_Com/Next_B/uncheck_Next_B.png");
        Image UnckeckedB = icon.getImage();
        Image logo = UnckeckedB.getScaledInstance(400, 48, 4);
        Next_B.setIcon(new ImageIcon(logo));
        Next_B.setBounds(90, 17, 400, 48);
        Next_B.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e){
                if(VITAL[0] && VITAL[1]){
                    try {
                        NextStep();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Next_B.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                Next_B.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        C_Daum.setForeground(Color.white);
        C_Daum.setFont(new Font("Dialog", Font.BOLD, 18));
        C_Daum.setBounds(275, 30, 80, 20);
        C_Daum.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                C_Daum.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                C_Daum.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        panel.add(C_Daum);
        panel.add(Next_B);
    }

    public static JPanel addWithLeftMargin(JPanel parentPanel) {
        JPanel panelWithMargin = new JPanel();
        panelWithMargin.setLayout(new BorderLayout()); // 왼쪽 정렬을 위해 BorderLayout 사용
        panelWithMargin.add(Box.createHorizontalStrut(97), BorderLayout.WEST); // 왼쪽 여백 추가
        panelWithMargin.setBackground(Color.white);
        parentPanel.add(panelWithMargin);
        return panelWithMargin;
    }

    public static void agreement_all(JPanel contentPane) {

        JPanel all_agree = new JPanel();
        all_agree.setPreferredSize(new Dimension(580, 90));
        all_agree.setBackground(Color.white);
        all_agree.setLayout(null);

        ImageIcon icon = new ImageIcon("img_Com/unchecked_checkbox.png");
        Image UnckeckedB = icon.getImage();
        Image logo = UnckeckedB.getScaledInstance(27, 27, 4);
        all_agree_B.setIcon(new ImageIcon(logo));
        all_agree_B.setBounds(10, 10, 27, 27);
        all_agree_B.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                for (int i = 0; i < check_count.length; ++i) {
                    check_count[i] = !check_count[i];
                }
                VITAL[0] = !VITAL[0];
                VITAL[1] = !VITAL[1];

                if (check_count[0]) {
                    ImageIcon icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);
                    all_agree_B.setIcon(new ImageIcon(logo));
                    all_agree_B.setBounds(10, 10, 27, 27);
                    Arrays.fill(check_count, true);
                    Arrays.fill(VITAL,true);

                    ImageIcon TOS_icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image TOS_UnckeckedB = TOS_icon.getImage();
                    Image TOS_logo = TOS_UnckeckedB.getScaledInstance(27, 27, 4);
                    TOS_agree_B.setIcon(new ImageIcon(TOS_logo));

                    ImageIcon PP_icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image PP_UnckeckedB = PP_icon.getImage();
                    Image PP_logo = PP_UnckeckedB.getScaledInstance(27, 27, 4);
                    PP_agree_B.setIcon(new ImageIcon(PP_logo));

                    ImageIcon SURN_icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image SURN_UnckeckedB = SURN_icon.getImage();
                    Image SURN_logo = SURN_UnckeckedB.getScaledInstance(27, 27, 4);
                    SURN_agree_B.setIcon(new ImageIcon(SURN_logo));

                    ImageIcon TOLBS_icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image TOLBS_UnckeckedB = TOLBS_icon.getImage();
                    Image TOLBS_logo = TOLBS_UnckeckedB.getScaledInstance(27, 27, 4);
                    TOLBS_agree_B.setIcon(new ImageIcon(TOLBS_logo));

                    ImageIcon PP2_B1_icon = new ImageIcon("img_Com/green_check.png");
                    Image PP2_B1_UnckeckedB = PP2_B1_icon.getImage();
                    Image PP2_B1_logo = PP2_B1_UnckeckedB.getScaledInstance(13, 13, 4);
                    PP2_agree_B1.setIcon(new ImageIcon(PP2_B1_logo));

                    ImageIcon PP2_B_icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image PP2_B_UnckeckedB = PP2_B_icon.getImage();
                    Image PP2_B_logo = PP2_B_UnckeckedB.getScaledInstance(27, 27, 4);
                    PP2_agree_B.setIcon(new ImageIcon(PP2_B_logo));

                    ImageIcon Next_B_icon = new ImageIcon("img_Com/Next_B/check_Next_B.png");
                    Image Next_B_UnckeckedB = Next_B_icon.getImage();
                    Image Next_B_logo = Next_B_UnckeckedB.getScaledInstance(400, 48, 4);
                    Next_B.setIcon(new ImageIcon(Next_B_logo));

                } else {
                    ImageIcon Aicon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image AUnckeckedB = Aicon.getImage();
                    Image Alogo = AUnckeckedB.getScaledInstance(27, 27, 4);
                    all_agree_B.setIcon(new ImageIcon(Alogo));
                    all_agree_B.setBounds(10, 10, 27, 27);
                    Arrays.fill(check_count, false);
                    Arrays.fill(VITAL,false);

                    ImageIcon TOS_icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image TOS_UnckeckedB = TOS_icon.getImage();
                    Image TOS_logo = TOS_UnckeckedB.getScaledInstance(27, 27, 4);
                    TOS_agree_B.setIcon(new ImageIcon(TOS_logo));

                    ImageIcon PP_icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image PP_UnckeckedB = PP_icon.getImage();
                    Image PP_logo = PP_UnckeckedB.getScaledInstance(27, 27, 4);
                    PP_agree_B.setIcon(new ImageIcon(PP_logo));

                    ImageIcon SURN_icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image SURN_UnckeckedB = SURN_icon.getImage();
                    Image SURN_logo = SURN_UnckeckedB.getScaledInstance(27, 27, 4);
                    SURN_agree_B.setIcon(new ImageIcon(SURN_logo));

                    ImageIcon TOLBS_icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image TOLBS_UnckeckedB = TOLBS_icon.getImage();
                    Image TOLBS_logo = TOLBS_UnckeckedB.getScaledInstance(27, 27, 4);
                    TOLBS_agree_B.setIcon(new ImageIcon(TOLBS_logo));

                    ImageIcon PP2_B1_icon = new ImageIcon("img_Com/white.png");
                    Image PP2_B1_UnckeckedB = PP2_B1_icon.getImage();
                    Image PP2_B1_logo = PP2_B1_UnckeckedB.getScaledInstance(13, 13, 4);
                    PP2_agree_B1.setIcon(new ImageIcon(PP2_B1_logo));

                    ImageIcon PP2_B_icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image PP2_B_UnckeckedB = PP2_B_icon.getImage();
                    Image PP2_B_logo = PP2_B_UnckeckedB.getScaledInstance(27, 27, 4);
                    PP2_agree_B.setIcon(new ImageIcon(PP2_B_logo));

                    ImageIcon Next_B_icon = new ImageIcon("img_Com/Next_B/uncheck_Next_B.png");
                    Image Next_B_UnckeckedB = Next_B_icon.getImage();
                    Image Next_B_logo = Next_B_UnckeckedB.getScaledInstance(400, 48, 4);
                    Next_B.setIcon(new ImageIcon(Next_B_logo));
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                all_agree_B.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                all_agree_B.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JLabel all_agree_T = new JLabel("전체 동의하기");
        all_agree_T.setFont(new Font("Dialog", Font.BOLD, 16));
        all_agree_T.setForeground(Color.BLACK);
        all_agree_T.setBounds(44, 17, 100, 15);
        all_agree_T.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (check_count[0]) {
                    ImageIcon icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);
                    all_agree_B.setIcon(new ImageIcon(logo));
                    all_agree_B.setBounds(10, 10, 27, 27);
                    Arrays.fill(check_count, true);

                    ImageIcon TOS_icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image TOS_UnckeckedB = TOS_icon.getImage();
                    Image TOS_logo = TOS_UnckeckedB.getScaledInstance(27, 27, 4);
                    TOS_agree_B.setIcon(new ImageIcon(TOS_logo));

                    ImageIcon PP_icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image PP_UnckeckedB = PP_icon.getImage();
                    Image PP_logo = PP_UnckeckedB.getScaledInstance(27, 27, 4);
                    PP_agree_B.setIcon(new ImageIcon(PP_logo));

                    ImageIcon SURN_icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image SURN_UnckeckedB = SURN_icon.getImage();
                    Image SURN_logo = SURN_UnckeckedB.getScaledInstance(27, 27, 4);
                    SURN_agree_B.setIcon(new ImageIcon(SURN_logo));

                    ImageIcon TOLBS_icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image TOLBS_UnckeckedB = TOLBS_icon.getImage();
                    Image TOLBS_logo = TOLBS_UnckeckedB.getScaledInstance(27, 27, 4);
                    TOLBS_agree_B.setIcon(new ImageIcon(TOLBS_logo));

                    ImageIcon PP2_B1_icon = new ImageIcon("img_Com/green_check.png");
                    Image PP2_B1_UnckeckedB = PP2_B1_icon.getImage();
                    Image PP2_B1_logo = PP2_B1_UnckeckedB.getScaledInstance(13, 13, 4);
                    PP2_agree_B1.setIcon(new ImageIcon(PP2_B1_logo));

                    ImageIcon PP2_B_icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image PP2_B_UnckeckedB = PP2_B_icon.getImage();
                    Image PP2_B_logo = PP2_B_UnckeckedB.getScaledInstance(27, 27, 4);
                    PP2_agree_B.setIcon(new ImageIcon(PP2_B_logo));

                    ImageIcon Next_B_icon = new ImageIcon("img_Com/Next_B/check_Next_B.png");
                    Image Next_B_UnckeckedB = Next_B_icon.getImage();
                    Image Next_B_logo = Next_B_UnckeckedB.getScaledInstance(400, 48, 4);
                    Next_B.setIcon(new ImageIcon(Next_B_logo));


                } else {
                    ImageIcon Aicon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image AUnckeckedB = Aicon.getImage();
                    Image Alogo = AUnckeckedB.getScaledInstance(27, 27, 4);
                    all_agree_B.setIcon(new ImageIcon(Alogo));
                    all_agree_B.setBounds(10, 10, 27, 27);
                    Arrays.fill(check_count, false);

                    ImageIcon TOS_icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image TOS_UnckeckedB = TOS_icon.getImage();
                    Image TOS_logo = TOS_UnckeckedB.getScaledInstance(27, 27, 4);
                    TOS_agree_B.setIcon(new ImageIcon(TOS_logo));

                    ImageIcon PP_icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image PP_UnckeckedB = PP_icon.getImage();
                    Image PP_logo = PP_UnckeckedB.getScaledInstance(27, 27, 4);
                    PP_agree_B.setIcon(new ImageIcon(PP_logo));

                    ImageIcon SURN_icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image SURN_UnckeckedB = SURN_icon.getImage();
                    Image SURN_logo = SURN_UnckeckedB.getScaledInstance(27, 27, 4);
                    SURN_agree_B.setIcon(new ImageIcon(SURN_logo));

                    ImageIcon TOLBS_icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image TOLBS_UnckeckedB = TOLBS_icon.getImage();
                    Image TOLBS_logo = TOLBS_UnckeckedB.getScaledInstance(27, 27, 4);
                    TOLBS_agree_B.setIcon(new ImageIcon(TOLBS_logo));

                    ImageIcon PP2_B1_icon = new ImageIcon("img_Com/white.png");
                    Image PP2_B1_UnckeckedB = PP2_B1_icon.getImage();
                    Image PP2_B1_logo = PP2_B1_UnckeckedB.getScaledInstance(13, 13, 4);
                    PP2_agree_B1.setIcon(new ImageIcon(PP2_B1_logo));

                    ImageIcon PP2_B_icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image PP2_B_UnckeckedB = PP2_B_icon.getImage();
                    Image PP2_B_logo = PP2_B_UnckeckedB.getScaledInstance(27, 27, 4);
                    PP2_agree_B.setIcon(new ImageIcon(PP2_B_logo));

                    ImageIcon Next_B_icon = new ImageIcon("img_Com/Next_B/uncheck_Next_B.png");
                    Image Next_B_UnckeckedB = Next_B_icon.getImage();
                    Image Next_B_logo = Next_B_UnckeckedB.getScaledInstance(400, 48, 4);
                    Next_B.setIcon(new ImageIcon(Next_B_logo));
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                all_agree_T.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                all_agree_T.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });


        JLabel all_agree_b = new JLabel();
        all_agree_b.setText("<html>실명 인증된 아이디로 가입, 위치기반서비스 이용약관(선택), <br>이벤트・혜택 정보 수신(선택) 동의를 포함합니다</html>");
        all_agree_b.setFont(new Font("Dialog", Font.BOLD, 13));
        all_agree_b.setForeground(Color.GRAY);
        all_agree_b.setBounds(44, 26, 300, 50);

        all_agree.add(all_agree_b);
        all_agree.add(all_agree_T);
        all_agree.add(all_agree_B);

        contentPane.add(all_agree);
    }
    public static void TermsOfService(JPanel contentPane) {
        JPanel TOS = new JPanel();
        TOS.setPreferredSize(new Dimension(580, 170));
        TOS.setBackground(Color.white);
        TOS.setLayout(null);

        ImageIcon icon = new ImageIcon("img_Com/unchecked_checkbox.png");
        Image UnckeckedB = icon.getImage();
        Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

        TOS_agree_B.setIcon(new ImageIcon(logo));
        TOS_agree_B.setBounds(10, 10, 27, 27);
        TOS_agree_B.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                check_count[1] = !check_count[1];
                VITAL[0] = !VITAL[0];
                if (check_count[1]) {
                    ImageIcon icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);
                    TOS_agree_B.setIcon(new ImageIcon(logo));

                    TOS_agree_B.setBounds(10, 10, 27, 27);
                    VITAL[0] = true;
                    check_count[1] = true;

                    if (VITAL[1]) {
                        ImageIcon Cicon = new ImageIcon("img_Com/Next_B/check_Next_B.png");
                        Image CUnckeckedB = Cicon.getImage();
                        Image Clogo = CUnckeckedB.getScaledInstance(400, 48, 4);

                        Next_B.setIcon(new ImageIcon(Clogo));
                        Next_B.setBounds(90, 17, 400, 48);

                        C_Daum.setForeground(Color.white);
                        C_Daum.setFont(new Font("Dialog", Font.BOLD, 18));
                        C_Daum.setBounds(275, 30, 80, 20);
                    }
                } else { // on
                    ImageIcon icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);
                    TOS_agree_B.setIcon(new ImageIcon(logo));
                    TOS_agree_B.setBounds(10, 10, 27, 27);
                    // 모든 요소를 1로 초기화
                    VITAL[0] = false;
                    check_count[1] = false;

                    ImageIcon UCicon = new ImageIcon("img_Com/Next_B/uncheck_Next_B.png");
                    Image UCUnckeckedB = UCicon.getImage();
                    Image UClogo = UCUnckeckedB.getScaledInstance(400, 48, 4);
                    Next_B.setIcon(new ImageIcon(UClogo));
                    Next_B.setBounds(90, 17, 400, 48);

                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                TOS_agree_B.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                TOS_agree_B.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JLabel TOS_agreement_status_T = new JLabel("[필수]");
        TOS_agreement_status_T.setFont(new Font("Dialog", Font.BOLD, 14));
        TOS_agreement_status_T.setForeground(new Color(23, 158, 74));
        TOS_agreement_status_T.setBounds(45, 16, 100, 15);
        TOS_agreement_status_T.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                check_count[1] = !check_count[1];
                VITAL[0] = !VITAL[0];

                if (check_count[1]) {
                    ImageIcon icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    TOS_agree_B.setIcon(new ImageIcon(logo));
                    TOS_agree_B.setBounds(10, 10, 27, 27);
                    VITAL[0] = true;
                    check_count[1] = true;

                    if (VITAL[1]) {
                        ImageIcon Cicon = new ImageIcon("img_Com/Next_B/check_Next_B.png");
                        Image CUnckeckedB = Cicon.getImage();
                        Image Clogo = CUnckeckedB.getScaledInstance(400, 48, 4);
                        Next_B.setIcon(new ImageIcon(Clogo));
                        Next_B.setBounds(90, 17, 400, 48);

                        C_Daum.setForeground(Color.white);
                        C_Daum.setFont(new Font("Dialog", Font.BOLD, 18));
                        C_Daum.setBounds(275, 30, 80, 20);
                    }
                } else {
                    ImageIcon icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);
                    TOS_agree_B.setIcon(new ImageIcon(logo));
                    TOS_agree_B.setBounds(10, 10, 27, 27);
                    // 모든 요소를 1로 초기화
                    VITAL[1] = false;
                    check_count[2] = false;

                    ImageIcon UCicon = new ImageIcon("img_Com/Next_B/uncheck_Next_B.png");
                    Image UCUnckeckedB = UCicon.getImage();
                    Image UClogo = UCUnckeckedB.getScaledInstance(400, 48, 4);
                    Next_B.setIcon(new ImageIcon(UClogo));
                    Next_B.setBounds(90, 17, 400, 48);
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                TOS_agreement_status_T.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                TOS_agreement_status_T.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JLabel TOS_agree_T = new JLabel("네이버 이용약관");
        TOS_agree_T.setFont(new Font("Dialog", Font.BOLD, 15));
        TOS_agree_T.setForeground(Color.BLACK);
        TOS_agree_T.setBounds(82, 17, 100, 15);
        TOS_agree_T.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                check_count[1] = !check_count[1];
                VITAL[0] = !VITAL[0];
                if (check_count[1]) {
                    ImageIcon icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);
                    TOS_agree_T.setIcon(new ImageIcon(logo));

                    TOS_agree_T.setBounds(10, 10, 27, 27);
                    VITAL[0] = true;
                    check_count[1] = true;

                    if (VITAL[1]) {
                        ImageIcon Cicon = new ImageIcon("img_Com/Next_B/check_Next_B.png");
                        Image CUnckeckedB = Cicon.getImage();
                        Image Clogo = CUnckeckedB.getScaledInstance(400, 48, 4);

                        Next_B.setIcon(new ImageIcon(Clogo));
                        Next_B.setBounds(90, 17, 400, 48);

                        C_Daum.setForeground(Color.white);
                        C_Daum.setFont(new Font("Dialog", Font.BOLD, 18));
                        C_Daum.setBounds(275, 30, 80, 20);
                    }
                } else { // on

                    ImageIcon icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    TOS_agree_T.setIcon(new ImageIcon(logo));
                    TOS_agree_T.setBounds(10, 10, 27, 27);
                    // 모든 요소를 1로 초기화
                    VITAL[0] = false;
                    check_count[1] = false;

                    ImageIcon Aicon = new ImageIcon("img_Com/NEx/unchecked_Next_B.png");
                    Image AUnckeckedB = Aicon.getImage();
                    Image Alogo = AUnckeckedB.getScaledInstance(27, 27, 4);
                    Next_B.setIcon(new ImageIcon(Alogo));
                    Next_B.setBounds(10, 10, 27, 27);

                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                TOS_agree_B.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                TOS_agree_B.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JPanel TOS_agree_document = new JPanel();
        TOS_agree_document.setLayout(new BoxLayout(TOS_agree_document, BoxLayout.X_AXIS));
        TOS_agree_document.setBackground(Color.white);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(TOS_agree_document);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(45, 48, 325, 100);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(194, 194, 194), 2, true));

        new TOS_Agreement_KR(TOS_agree_document);

        TOS.add(scrollPane);
        TOS.add(TOS_agreement_status_T);
        TOS.add(TOS_agree_T);
        TOS.add(TOS_agree_B);
        TOS.revalidate();
        TOS.repaint();
        contentPane.add(TOS);

        contentPane.revalidate();
        contentPane.repaint();

    }
    public static void PrivacyPolicy(JPanel contentPane) {
        JPanel PP = new JPanel();
        PP.setPreferredSize(new Dimension(580, 170));
        PP.setBackground(Color.white);
        PP.setLayout(null);

        ImageIcon icon = new ImageIcon("img_Com/unchecked_checkbox.png");
        Image UnckeckedB = icon.getImage();
        Image logo = UnckeckedB.getScaledInstance(27, 27, 4);
        PP_agree_B.setIcon(new ImageIcon(logo));
        PP_agree_B.setBounds(10, 10, 27, 27);
        PP_agree_B.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                check_count[2] = !check_count[2];
                VITAL[1] = !VITAL[1];
                if (check_count[2]) {
                    ImageIcon icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    PP_agree_B.setIcon(new ImageIcon(logo));
                    PP_agree_B.setBounds(10, 10, 27, 27);
                    VITAL[1] = true;
                    check_count[2] = true;

                    if (VITAL[0]) {
                        ImageIcon Cicon = new ImageIcon("img_Com/Next_B/check_Next_B.png");
                        Image CUnckeckedB = Cicon.getImage();
                        Image Clogo = CUnckeckedB.getScaledInstance(400, 48, 4);
                        Next_B.setIcon(new ImageIcon(Clogo));
                        Next_B.setBounds(90, 17, 400, 48);

                        C_Daum.setForeground(Color.white);
                        C_Daum.setFont(new Font("Dialog", Font.BOLD, 18));
                        C_Daum.setBounds(275, 30, 80, 20);
                    }
                }
                else {
                    ImageIcon icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);
                    PP_agree_B.setIcon(new ImageIcon(logo));
                    PP_agree_B.setBounds(10, 10, 27, 27);
                    // 모든 요소를 1로 초기화
                    VITAL[1] = false;
                    check_count[2] = false;

                    ImageIcon UCicon = new ImageIcon("img_Com/Next_B/uncheck_Next_B.png");
                    Image UCUnckeckedB = UCicon.getImage();
                    Image UClogo = UCUnckeckedB.getScaledInstance(400, 48, 4);
                    Next_B.setIcon(new ImageIcon(UClogo));
                    Next_B.setBounds(90, 17, 400, 48);
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                PP_agree_B.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                PP_agree_B.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JLabel PP_agreement_status_T = new JLabel("[필수]");
        PP_agreement_status_T.setFont(new Font("Dialog", Font.BOLD, 14));
        PP_agreement_status_T.setForeground(new Color(23, 158, 74));
        PP_agreement_status_T.setBounds(45, 16, 100, 15);
        PP_agreement_status_T.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                check_count[2] = !check_count[2];
                VITAL[1] = !VITAL[1];

                if (check_count[2]) {
                    ImageIcon icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    PP_agree_B.setIcon(new ImageIcon(logo));
                    PP_agree_B.setBounds(10, 10, 27, 27);
                    VITAL[1] = true;
                    check_count[2] = true;

                    if (VITAL[0]) {
                        ImageIcon Cicon = new ImageIcon("img_Com/Next_B/check_Next_B.png");
                        Image CUnckeckedB = Cicon.getImage();
                        Image Clogo = CUnckeckedB.getScaledInstance(400, 48, 4);
                        Next_B.setIcon(new ImageIcon(Clogo));
                        Next_B.setBounds(90, 17, 400, 48);

                        C_Daum.setForeground(Color.white);
                        C_Daum.setFont(new Font("Dialog", Font.BOLD, 18));
                        C_Daum.setBounds(275, 30, 80, 20);
                    }
                } else {
                    ImageIcon icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);
                    PP_agree_B.setIcon(new ImageIcon(logo));
                    PP_agree_B.setBounds(10, 10, 27, 27);
                    // 모든 요소를 1로 초기화
                    VITAL[1] = false;
                    check_count[2] = false;

                    ImageIcon UCicon = new ImageIcon("img_Com/Next_B/uncheck_Next_B.png");
                    Image UCUnckeckedB = UCicon.getImage();
                    Image UClogo = UCUnckeckedB.getScaledInstance(400, 48, 4);
                    Next_B.setIcon(new ImageIcon(UClogo));
                    Next_B.setBounds(90, 17, 400, 48);
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                PP_agreement_status_T.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                PP_agreement_status_T.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JLabel PP_agree_T = new JLabel("개인정보 수집 및 이용");
        PP_agree_T.setFont(new Font("Dialog", Font.BOLD, 15));
        PP_agree_T.setForeground(Color.BLACK);
        PP_agree_T.setBounds(82, 17, 134, 15);
        PP_agree_T.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                check_count[2] = !check_count[2];
                VITAL[1] = !VITAL[1];

                if (check_count[2]) {
                    ImageIcon icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    PP_agree_B.setIcon(new ImageIcon(logo));
                    PP_agree_B.setBounds(10, 10, 27, 27);
                    VITAL[1] = true;
                    check_count[2] = true;

                    if (VITAL[0]) {
                        ImageIcon Cicon = new ImageIcon("img_Com/Next_B/check_Next_B.png");
                        Image CUnckeckedB = Cicon.getImage();
                        Image Clogo = CUnckeckedB.getScaledInstance(400, 48, 4);
                        Next_B.setIcon(new ImageIcon(Clogo));
                        Next_B.setBounds(90, 17, 400, 48);

                        C_Daum.setForeground(Color.white);
                        C_Daum.setFont(new Font("Dialog", Font.BOLD, 18));
                        C_Daum.setBounds(275, 30, 80, 20);
                    }
                } else {
                    ImageIcon icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);
                    PP_agree_B.setIcon(new ImageIcon(logo));
                    PP_agree_B.setBounds(10, 10, 27, 27);
                    // 모든 요소를 1로 초기화
                    VITAL[1] = false;
                    check_count[2] = false;

                    ImageIcon UCicon = new ImageIcon("img_Com/Next_B/uncheck_Next_B.png");
                    Image UCUnckeckedB = UCicon.getImage();
                    Image UClogo = UCUnckeckedB.getScaledInstance(400, 48, 4);
                    Next_B.setIcon(new ImageIcon(UClogo));
                    Next_B.setBounds(90, 17, 400, 48);
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                PP_agree_T.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                PP_agree_T.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JPanel PP_agree_document = new JPanel();
        PP_agree_document.setLayout(new BoxLayout(PP_agree_document, BoxLayout.X_AXIS));
        PP_agree_document.setBackground(Color.white);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(PP_agree_document);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(45, 48, 325, 100);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(194, 194, 194), 2, true));

        new PP_Agreement_KR(PP_agree_document);

        PP.add(scrollPane);
        PP.add(PP_agreement_status_T);
        PP.add(PP_agree_T);
        PP.add(PP_agree_B);
        PP.revalidate();
        PP.repaint();
        contentPane.add(PP);

        contentPane.revalidate();
        contentPane.repaint();

    }
    public static void SignUpRealName(JPanel contentPane) {
        JPanel SURN = new JPanel();
        SURN.setPreferredSize(new Dimension(580, 120));
        SURN.setBackground(Color.white);
        SURN.setLayout(null);

        ImageIcon icon = new ImageIcon("img_Com/unchecked_checkbox.png");
        Image UnckeckedB = icon.getImage();
        Image logo = UnckeckedB.getScaledInstance(27, 27, 4);
        SURN_agree_B.setIcon(new ImageIcon(logo));
        SURN_agree_B.setBounds(10, 10, 27, 27);
        SURN_agree_B.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                check_count[3] = !check_count[3];
                if (check_count[3]) {
                    ImageIcon icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    SURN_agree_B.setIcon(new ImageIcon(logo));
                    SURN_agree_B.setBounds(10, 10, 27, 27);
                    check_count[3] = true;
                } else {
                    ImageIcon icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    SURN_agree_B.setIcon(new ImageIcon(logo));
                    SURN_agree_B.setBounds(10, 10, 27, 27);
                    // 모든 요소를 1로 초기화
                    check_count[3] = false;
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                SURN_agree_B.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                SURN_agree_B.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JLabel SURN_agreement_status_T = new JLabel("[선택]");
        SURN_agreement_status_T.setFont(new Font("Dialog", Font.BOLD, 14));
        SURN_agreement_status_T.setForeground(new Color(128, 128, 130));
        SURN_agreement_status_T.setBounds(45, 16, 100, 15);
        SURN_agreement_status_T.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                check_count[3] = !check_count[3];
                if (check_count[3]) {
                    ImageIcon icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    SURN_agree_B.setIcon(new ImageIcon(logo));
                    SURN_agree_B.setBounds(10, 10, 27, 27);
                    check_count[3] = true;
                } else {
                    ImageIcon icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    SURN_agree_B.setIcon(new ImageIcon(logo));
                    SURN_agree_B.setBounds(10, 10, 27, 27);
                    // 모든 요소를 1로 초기화
                    check_count[3] = false;
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                SURN_agreement_status_T.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                SURN_agreement_status_T.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        //네이버 이용약관
        JLabel SURN_agree_T = new JLabel("실명 인증된 아이디로 가입");
        SURN_agree_T.setFont(new Font("Dialog", Font.BOLD, 15));
        SURN_agree_T.setForeground(Color.BLACK);
        SURN_agree_T.setBounds(82, 17, 163, 15);
        SURN_agree_T.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                check_count[3] = !check_count[3];
                if (check_count[3]) {
                    ImageIcon icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    SURN_agree_B.setIcon(new ImageIcon(logo));
                    SURN_agree_B.setBounds(10, 10, 27, 27);
                    check_count[3] = true;
                } else {
                    ImageIcon icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    SURN_agree_B.setIcon(new ImageIcon(logo));
                    SURN_agree_B.setBounds(10, 10, 27, 27);
                    // 모든 요소를 1로 초기화
                    check_count[3] = false;
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                SURN_agree_T.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                SURN_agree_T.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JPanel SURN_agree_document = new JPanel();
        SURN_agree_document.setLayout(new BoxLayout(SURN_agree_document, BoxLayout.X_AXIS));
        SURN_agree_document.setBackground(Color.white);

        JLabel scrollPane = new JLabel(
                "<html>&nbsp;실명 인증된 아이디로 가입하시면 본인인증이 필요한 서비스"
                        + "<br>&nbsp;(네이버 페이, 쇼핑, 멤버십 등)를 가입 후 바로 이용하실 수 있"
                        + "<br>&nbsp;어요."
        );
        scrollPane.setForeground(new Color(99, 99, 101));
        scrollPane.setFont(new Font("Dialog", Font.PLAIN, 13));
        scrollPane.setBounds(45, 48, 325, 60);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(194, 194, 194), 2, true));

        SURN.add(scrollPane);
        SURN.add(SURN_agreement_status_T);
        SURN.add(SURN_agree_T);
        SURN.add(SURN_agree_B);
        SURN.revalidate();
        SURN.repaint();
        contentPane.add(SURN);

        contentPane.revalidate();
        contentPane.repaint();

    }
    public static void TermsOfLocationBasedServices(JPanel contentPane) {
        JPanel TOLBS = new JPanel();
        TOLBS.setPreferredSize(new Dimension(580, 170));
        TOLBS.setBackground(Color.white);
        TOLBS.setLayout(null);

        ImageIcon icon = new ImageIcon("img_Com/unchecked_checkbox.png");
        Image UnckeckedB = icon.getImage();
        Image logo = UnckeckedB.getScaledInstance(27, 27, 4);
        TOLBS_agree_B.setIcon(new ImageIcon(logo));
        TOLBS_agree_B.setBounds(10, 10, 27, 27);
        TOLBS_agree_B.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                check_count[4] = !check_count[4];
                if (check_count[4]) {

                    ImageIcon icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    TOLBS_agree_B.setIcon(new ImageIcon(logo));
                    TOLBS_agree_B.setBounds(10, 10, 27, 27);
                    check_count[4] = true;
                } else {
                    ImageIcon icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    TOLBS_agree_B.setIcon(new ImageIcon(logo));
                    TOLBS_agree_B.setBounds(10, 10, 27, 27);
                    check_count[4] = false;
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                TOLBS_agree_B.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                TOLBS_agree_B.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JLabel TOS_agreement_status_T = new JLabel("[선택]");
        TOS_agreement_status_T.setFont(new Font("Dialog", Font.BOLD, 14));
        TOS_agreement_status_T.setForeground(new Color(128, 123, 130));
        TOS_agreement_status_T.setBounds(45, 16, 100, 15);
        TOS_agreement_status_T.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                check_count[4] = !check_count[4];
                if (!check_count[4]) {
                    ImageIcon icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    TOLBS_agree_B.setIcon(new ImageIcon(logo));
                    TOLBS_agree_B.setBounds(10, 10, 27, 27);
                    check_count[4] = true;
                } else {
                    ImageIcon icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    TOLBS_agree_B.setIcon(new ImageIcon(logo));
                    TOLBS_agree_B.setBounds(10, 10, 27, 27);
                    check_count[4] = false;
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                TOS_agreement_status_T.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                TOS_agreement_status_T.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JLabel TOLBS_agree_T = new JLabel("위치기반서비스 이용약관");
        TOLBS_agree_T.setFont(new Font("Dialog", Font.BOLD, 15));
        TOLBS_agree_T.setForeground(Color.BLACK);
        TOLBS_agree_T.setBounds(82, 17, 170, 15);
        TOLBS_agree_T.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                check_count[4] = !check_count[4];
                if (!check_count[4]) {
                    ImageIcon icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    TOLBS_agree_B.setIcon(new ImageIcon(logo));
                    TOLBS_agree_B.setBounds(10, 10, 27, 27);
                    check_count[4] = true;
                } else {
                    ImageIcon icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    TOLBS_agree_B.setIcon(new ImageIcon(logo));
                    TOLBS_agree_B.setBounds(10, 10, 27, 27);
                    check_count[4] = false;
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                TOLBS_agree_T.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                TOLBS_agree_T.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JPanel TOLBS_agree_document = new JPanel();
        TOLBS_agree_document.setLayout(new BoxLayout(TOLBS_agree_document, BoxLayout.X_AXIS));
        TOLBS_agree_document.setBackground(Color.white);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(TOLBS_agree_document);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(45, 48, 325, 100);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(194, 194, 194), 2, true));

        new TOLBS_Agreement_KR(TOLBS_agree_document);

        TOLBS.add(scrollPane);
        TOLBS.add(TOS_agreement_status_T);
        TOLBS.add(TOLBS_agree_T);
        TOLBS.add(TOLBS_agree_B);
        TOLBS.revalidate();
        TOLBS.repaint();
        contentPane.add(TOLBS);

        contentPane.revalidate();
        contentPane.repaint();
    }
    public static void PrivacyPolicy2(JPanel contentPane) {
        JPanel PP2 = new JPanel();
        PP2.setPreferredSize(new Dimension(580, 120));
        PP2.setBackground(Color.white);
        PP2.setLayout(null);

        ImageIcon icon2 = new ImageIcon("img_Com/white_check.png");
        Image UnckeckedB2 = icon2.getImage();
        Image logo2 = UnckeckedB2.getScaledInstance(13, 13, 4);
        PP2_agree_B1.setIcon(new ImageIcon(logo2));
        PP2_agree_B1.setBounds(45, 38, 13, 13);

        ImageIcon icon = new ImageIcon("img_Com/unchecked_checkbox.png");
        Image UnckeckedB = icon.getImage();
        Image logo = UnckeckedB.getScaledInstance(27, 27, 4);
        PP2_agree_B.setIcon(new ImageIcon(logo));
        PP2_agree_B.setBounds(10, 10, 27, 27);

        PP2_agree_B1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                check_count[5] = !check_count[5];
                check_count[6] = !check_count[6];
                if (check_count[5]) {
                    ImageIcon icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    PP2_agree_B.setIcon(new ImageIcon(logo));
                    PP2_agree_B.setBounds(10, 10, 27, 27);
                    check_count[5] = true;

                    ImageIcon icon2 = new ImageIcon("img_Com/green_check.png");
                    Image UnckeckedB2 = icon2.getImage();
                    Image logo2 = UnckeckedB2.getScaledInstance(13, 13, 4);

                    PP2_agree_B1.setIcon(new ImageIcon(logo2));
                    PP2_agree_B1.setBounds(45, 38, 13, 13);
                    check_count[6] = true;

                } else {

                    ImageIcon icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    PP2_agree_B.setIcon(new ImageIcon(logo));
                    PP2_agree_B.setBounds(10, 10, 27, 27);
                    check_count[5] = false;

                    ImageIcon icon2 = new ImageIcon("img_Com/white_check.png");
                    Image UnckeckedB2 = icon2.getImage();
                    Image logo2 = UnckeckedB2.getScaledInstance(13, 13, 4);
                    PP2_agree_B1.setIcon(new ImageIcon(logo2));
                    PP2_agree_B1.setBounds(45, 38, 13, 13);
                    check_count[6] = false;
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                PP2_agree_B1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                PP2_agree_B1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        PP2_agree_B.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                check_count[5] = !check_count[5];
                check_count[6] = !check_count[6];
                if (check_count[5]) {
                    ImageIcon icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    PP2_agree_B.setIcon(new ImageIcon(logo));
                    PP2_agree_B.setBounds(10, 10, 27, 27);
                    check_count[5] = true;

                    ImageIcon icon2 = new ImageIcon("img_Com/green_check.png");
                    Image UnckeckedB2 = icon2.getImage();
                    Image logo2 = UnckeckedB2.getScaledInstance(13, 13, 4);

                    PP2_agree_B1.setIcon(new ImageIcon(logo2));
                    PP2_agree_B1.setBounds(45, 38, 13, 13);
                    check_count[6] = true;

                } else {

                    ImageIcon icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    PP2_agree_B.setIcon(new ImageIcon(logo));
                    PP2_agree_B.setBounds(10, 10, 27, 27);
                    check_count[5] = false;

                    ImageIcon icon2 = new ImageIcon("img_Com/white_check.png");
                    Image UnckeckedB2 = icon2.getImage();
                    Image logo2 = UnckeckedB2.getScaledInstance(13, 13, 4);
                    PP2_agree_B1.setIcon(new ImageIcon(logo2));
                    PP2_agree_B1.setBounds(45, 38, 13, 13);
                    check_count[6] = false;
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                PP2_agree_B.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                PP2_agree_B.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JLabel PP2_agreement_status_T = new JLabel("[선택]");
        PP2_agreement_status_T.setFont(new Font("Dialog", Font.BOLD, 14));
        PP2_agreement_status_T.setForeground(new Color(128, 128, 130));
        PP2_agreement_status_T.setBounds(45, 16, 100, 15);
        PP2_agreement_status_T.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                check_count[5] = !check_count[5];
                check_count[6] = !check_count[6];
                if (check_count[5]) {
                    ImageIcon icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    PP2_agree_B.setIcon(new ImageIcon(logo));
                    PP2_agree_B.setBounds(10, 10, 27, 27);
                    check_count[5] = true;

                    ImageIcon icon2 = new ImageIcon("img_Com/green_check.png");
                    Image UnckeckedB2 = icon2.getImage();
                    Image logo2 = UnckeckedB2.getScaledInstance(13, 13, 4);

                    PP2_agree_B1.setIcon(new ImageIcon(logo2));
                    PP2_agree_B1.setBounds(45, 38, 13, 13);
                    check_count[6] = true;

                } else {

                    ImageIcon icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    PP2_agree_B.setIcon(new ImageIcon(logo));
                    PP2_agree_B.setBounds(10, 10, 27, 27);
                    check_count[5] = false;

                    ImageIcon icon2 = new ImageIcon("img_Com/white_check.png");
                    Image UnckeckedB2 = icon2.getImage();
                    Image logo2 = UnckeckedB2.getScaledInstance(13, 13, 4);
                    PP2_agree_B1.setIcon(new ImageIcon(logo2));
                    PP2_agree_B1.setBounds(45, 38, 13, 13);
                    check_count[6] = false;
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                PP2_agreement_status_T.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                PP2_agreement_status_T.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        //네이버 이용약관
        JLabel PP2_agree_T = new JLabel("개인정보 수집 및 이용");
        PP2_agree_T.setFont(new Font("Dialog", Font.BOLD, 15));
        PP2_agree_T.setForeground(Color.BLACK);
        PP2_agree_T.setBounds(82, 17, 163, 15);
        PP2_agree_T.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                check_count[5] = !check_count[5];
                check_count[6] = !check_count[6];
                if (check_count[5]) {
                    ImageIcon icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    PP2_agree_B.setIcon(new ImageIcon(logo));
                    PP2_agree_B.setBounds(10, 10, 27, 27);
                    check_count[5] = true;

                    ImageIcon icon2 = new ImageIcon("img_Com/green_check.png");
                    Image UnckeckedB2 = icon2.getImage();
                    Image logo2 = UnckeckedB2.getScaledInstance(13, 13, 4);

                    PP2_agree_B1.setIcon(new ImageIcon(logo2));
                    PP2_agree_B1.setBounds(45, 38, 13, 13);
                    check_count[6] = true;

                } else {

                    ImageIcon icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    PP2_agree_B.setIcon(new ImageIcon(logo));
                    PP2_agree_B.setBounds(10, 10, 27, 27);
                    check_count[5] = false;

                    ImageIcon icon2 = new ImageIcon("img_Com/white_check.png");
                    Image UnckeckedB2 = icon2.getImage();
                    Image logo2 = UnckeckedB2.getScaledInstance(13, 13, 4);
                    PP2_agree_B1.setIcon(new ImageIcon(logo2));
                    PP2_agree_B1.setBounds(45, 38, 13, 13);
                    check_count[6] = false;
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                PP2_agree_T.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                PP2_agree_T.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JPanel PP2_agree_document = new JPanel();
        PP2_agree_document.setLayout(new BoxLayout(PP2_agree_document, BoxLayout.X_AXIS));
        PP2_agree_document.setBackground(Color.white);

        JLabel scrollPane = new JLabel("이벤트・혜택 정보 수신");
        scrollPane.setForeground(new Color(99, 99, 101));
        scrollPane.setFont(new Font("Dialog", Font.PLAIN, 13));
        scrollPane.setBounds(60, 38, 120, 12);
        scrollPane.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                check_count[5] = !check_count[5];
                check_count[6] = !check_count[6];
                if (check_count[5]) {
                    ImageIcon icon = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    PP2_agree_B.setIcon(new ImageIcon(logo));
                    PP2_agree_B.setBounds(10, 10, 27, 27);
                    check_count[5] = true;

                    ImageIcon icon2 = new ImageIcon("img_Com/green_check.png");
                    Image UnckeckedB2 = icon2.getImage();
                    Image logo2 = UnckeckedB2.getScaledInstance(13, 13, 4);

                    PP2_agree_B1.setIcon(new ImageIcon(logo2));
                    PP2_agree_B1.setBounds(45, 38, 13, 13);
                    check_count[6] = true;

                } else {

                    ImageIcon icon = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image UnckeckedB = icon.getImage();
                    Image logo = UnckeckedB.getScaledInstance(27, 27, 4);

                    PP2_agree_B.setIcon(new ImageIcon(logo));
                    PP2_agree_B.setBounds(10, 10, 27, 27);
                    check_count[5] = false;

                    ImageIcon icon2 = new ImageIcon("img_Com/white_check.png");
                    Image UnckeckedB2 = icon2.getImage();
                    Image logo2 = UnckeckedB2.getScaledInstance(13, 13, 4);
                    PP2_agree_B1.setIcon(new ImageIcon(logo2));
                    PP2_agree_B1.setBounds(45, 38, 13, 13);
                    check_count[6] = false;
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                scrollPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                scrollPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        PP2.add(scrollPane);
        PP2.add(PP2_agreement_status_T);
        PP2.add(PP2_agree_T);
        PP2.add(PP2_agree_B);
        PP2.add(PP2_agree_B1);
        PP2.revalidate();
        PP2.repaint();
        contentPane.add(PP2);

        contentPane.revalidate();
        contentPane.repaint();

    }
    public static void NextStep() {
        s_main();
        dis();
    }
}