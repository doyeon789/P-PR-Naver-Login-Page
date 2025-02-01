package lang_signuppage.KR.signup_func;

import lang_signuppage.SignupMain;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Random;
import java.io.*;
import java.util.Base64;

public class Signup_Function extends SignupMain {

    static int idS = 4;
    static int passwordS = 2;
    static int emailS = 2;

    static String Verify_Number;

    static boolean eye_clicked = false;

    static JLabel danger;
    static JLabel normal;
    static JLabel safety;
    static JLabel cantuse;

    static boolean all_check = false;
    static boolean[] V_checks = {false, false, false, false, false};

    static boolean ActingMod = false;

    static JTextField emBox;

    static JLabel C_check_box;
    static JLabel EtPolicy_Button1;
    static JLabel EtPolicy_Button2;
    static JLabel EtPolicy_Button3;
    static JLabel EtPolicy_Button4;
    static JLabel EtPolicy_Button5;
    static JLabel SC_B;

    static JLabel greenNum;
    static JTextField NumBox;

    static String NumBoxText;

    static JLabel C_vertify = new JLabel("인증하기");

    static boolean NotMatch;
    static boolean Match;
    static boolean Send;
    static boolean SignIn;

    static String Get_ID;
    static String Get_PW;

    static Timer timer;

    public Signup_Function(JPanel firstInput) {
        firstInput.setLayout(null);
        idPanel(firstInput);
        PasswordPanel(firstInput);
        EmailPanel(firstInput);
        WarningPanel(firstInput);
    }

    public static void idPanel(JPanel firstInput) {
        JTextField idBox = new JTextField("아이디"); //아이디 이름 적기
        idBox.setOpaque(true);
        idBox.setFont(new Font("Dialog", Font.PLAIN, 14));
        idBox.setForeground(new Color(160, 160, 160));
        idBox.setBounds(37, 4, 300, 40);
        firstInput.setComponentZOrder(idBox, 0);

        JLabel emailadress = new JLabel("@naver.com"); // @naver.com 이름 적기
        emailadress.setFont(new Font("Dialog", Font.PLAIN, 14));
        emailadress.setForeground(new Color(160, 160, 160));
        emailadress.setBounds(340, 3, 90, 41);

        JLabel person_icon = new JLabel(); // 사람 모양 아이콘
        person_icon.setBounds(12, 13, 20, 20);
        ImageIcon icon_person = new ImageIcon("img_Com/Signup_img/signup_icon/person.png");
        Image person_p = icon_person.getImage();
        Image logo_person = person_p.getScaledInstance(20, 20, 4);
        person_icon.setIcon(new ImageIcon(logo_person));
        person_icon.setVisible(true);

        JLabel person_icon_r = new JLabel(); // 빨간색 사람 모양 아이콘
        person_icon_r.setBounds(12, 13, 20, 20);
        ImageIcon icon_person_r = new ImageIcon("img_Com/Signup_img/signup_icon/red/red_person.png");
        Image person_p_r = icon_person_r.getImage();
        Image logo_person_r = person_p_r.getScaledInstance(20, 20, 4);
        person_icon_r.setIcon(new ImageIcon(logo_person_r));
        person_icon_r.setVisible(false);

        JLabel greenID = new JLabel(); // 파란색 프레임 설정
        greenID.setBounds(0, 0, 440, 48);
        ImageIcon icong = new ImageIcon("img_Com/Signup_img/greenid.png");
        Image greenid = icong.getImage();
        Image logog = greenid.getScaledInstance(440, 48, 4);
        greenID.setIcon(new ImageIcon(logog));
        greenID.setVisible(false);

        JLabel redID = new JLabel(); // 빨간색 프레임 설정
        redID.setBounds(0, 0, 440, 48);
        ImageIcon iconr = new ImageIcon("img_Com/Signup_img/redid.png");
        Image redid = iconr.getImage();
        Image logor = redid.getScaledInstance(440, 48, 4);
        redID.setIcon(new ImageIcon(logor));
        redID.setVisible(false);

        idBox.addFocusListener(new FocusAdapter() {
            int first_click = 0;

            @Override
            public void focusGained(FocusEvent e) {
                boolean id_rule_Checker = isValidInputID(idBox.getText());
                first_click++;
                if (first_click == 1) {
                    idBox.setForeground(Color.BLACK);
                    redID.setVisible(false);
                    greenID.setVisible(true);
                    person_icon_r.setVisible(false);
                    person_icon.setVisible(true);
                } else {
                    if (id_rule_Checker) {
                        Get_ID = idBox.getText();

                        String filePath = "DB/" + Get_ID + ".txt";

                        File file = new File(filePath);
                        if (!file.exists()) {
                            idS = 2;

                            redID.setVisible(false);
                            person_icon.setVisible(true);
                            person_icon_r.setVisible(false);
                            idBox.setForeground(Color.BLACK);

                            idS = 0;
                            if (idS == 0 && passwordS == 0 && emailS == 0 && all_check) {
                                ImageIcon iconG = new ImageIcon("img_Com/Next_B/check_Next_B.png");
                                Image UncheckedBG = iconG.getImage();
                                Image logoG = UncheckedBG.getScaledInstance(400, 48, Image.SCALE_SMOOTH);
                                SC_B.setIcon(new ImageIcon(logoG));
                                ActingMod = true;
                            }
                        } else {
                            idS = 3;
                            redID.setVisible(true);
                            person_icon.setVisible(false);
                            person_icon_r.setVisible(true);
                            idBox.setForeground(new Color(252, 37, 49));
                            if (idBox.getText().isEmpty()) {
                                idBox.setText("아이디");
                            }

                            ImageIcon iconR = new ImageIcon("img_Com/Next_B/uncheck_Next_B.png");
                            Image UncheckedBR = iconR.getImage();
                            Image logoR = UncheckedBR.getScaledInstance(400, 48, Image.SCALE_SMOOTH);
                            SC_B.setIcon(new ImageIcon(logoR));
                        }
                    } else { // red
                        redID.setVisible(true);
                        person_icon.setVisible(false);
                        person_icon_r.setVisible(true);
                        idBox.setForeground(new Color(252, 37, 49));
                        if (idBox.getText().isEmpty()) {
                            idBox.setText("아이디");
                        }

                        idS = 1;
                        ImageIcon iconR = new ImageIcon("img_Com/Next_B/uncheck_Next_B.png");
                        Image UncheckedBR = iconR.getImage();
                        Image logoR = UncheckedBR.getScaledInstance(400, 48, Image.SCALE_SMOOTH);
                        SC_B.setIcon(new ImageIcon(logoR));

                    }
                    firstInput.setComponentZOrder(idBox, 0);
                }

                firstInput.setComponentZOrder(idBox, 0);
            }

            @Override
            public void focusLost(FocusEvent e) {
                boolean id_rule_Checker = isValidInputID(idBox.getText());
                greenID.setVisible(false);

                if (id_rule_Checker) {
                    Get_ID = idBox.getText();

                    String filePath = "DB/" + Get_ID + ".txt";

                    File file = new File(filePath);
                    if (!file.exists()) {
                        idS = 2;

                        redID.setVisible(false);
                        person_icon.setVisible(true);
                        person_icon_r.setVisible(false);
                        idBox.setForeground(Color.BLACK);

                        idS = 0;
                        if (idS == 0 && passwordS == 0 && emailS == 0 && all_check) {
                            ImageIcon iconG = new ImageIcon("img_Com/Next_B/check_Next_B.png");
                            Image UncheckedBG = iconG.getImage();
                            Image logoG = UncheckedBG.getScaledInstance(400, 48, Image.SCALE_SMOOTH);
                            SC_B.setIcon(new ImageIcon(logoG));
                            ActingMod = true;
                        }
                    } else {
                        idS = 3;

                        redID.setVisible(true);
                        person_icon.setVisible(false);
                        person_icon_r.setVisible(true);
                        idBox.setForeground(new Color(252, 37, 49));
                        if (idBox.getText().isEmpty()) {
                            idBox.setText("아이디");
                        }

                        ImageIcon iconR = new ImageIcon("img_Com/Next_B/uncheck_Next_B.png");
                        Image UncheckedBR = iconR.getImage();
                        Image logoR = UncheckedBR.getScaledInstance(400, 48, Image.SCALE_SMOOTH);
                        SC_B.setIcon(new ImageIcon(logoR));
                    }
                } else { // red
                    redID.setVisible(true);
                    person_icon.setVisible(false);
                    person_icon_r.setVisible(true);
                    idBox.setForeground(new Color(252, 37, 49));
                    if (idBox.getText().isEmpty()) {
                        idBox.setText("아이디");
                    }

                    idS = 1;
                    ImageIcon iconR = new ImageIcon("img_Com/Next_B/uncheck_Next_B.png");
                    Image UncheckedBR = iconR.getImage();
                    Image logoR = UncheckedBR.getScaledInstance(400, 48, Image.SCALE_SMOOTH);
                    SC_B.setIcon(new ImageIcon(logoR));

                }
                firstInput.setComponentZOrder(idBox, 0);
            }
        });

        idBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (idBox.getText().equals("아이디")) {
                    idBox.setText("");
                    idBox.setForeground(Color.BLACK);
                }
                firstInput.setComponentZOrder(idBox, 0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                idBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                idBox.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        idBox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    firstInput.requestFocus();
                }
            }
        });

        firstInput.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                firstInput.requestFocus();
            }
        });

        person_icon.setName("person_icon");
        person_icon_r.setName("person_icon_r");
        emailadress.setName("emailadress");
        greenID.setName("greenID");
        redID.setName("redID");
        idBox.setName("idBox");

        firstInput.add(person_icon);
        firstInput.add(person_icon_r);
        firstInput.add(emailadress);
        firstInput.add(greenID);
        firstInput.add(redID);
        firstInput.add(idBox);
        idBox.setBorder(new LineBorder(Color.gray, 0));
    }

    public static void PasswordPanel(JPanel firstInput) {
        JPasswordField psBox = new JPasswordField("비밀번호");
        psBox.setFont(new Font("Dialog", Font.PLAIN, 14));
        psBox.setForeground(new Color(160, 160, 160));
        psBox.setBounds(37, 49, 336, 40);

        firstInput.add(psBox);

        JLabel lock_icon = new JLabel();
        lock_icon.setBounds(12, 57, 21, 21);
        ImageIcon icon_lock = new ImageIcon("img_Com/Signup_img/signup_icon/lock.png");
        Image icon_l = icon_lock.getImage();
        Image logo_lock = icon_l.getScaledInstance(21, 21, 4);
        lock_icon.setIcon(new ImageIcon(logo_lock));

        JLabel eye_icon = new JLabel();
        eye_icon.setBounds(400, 57, 26, 26);
        ImageIcon icon_eye = new ImageIcon("img_Com/Signup_img/signup_icon/opened_eye.png");
        Image icon_e = icon_eye.getImage();
        Image logo_eye = icon_e.getScaledInstance(24, 24, 4);
        eye_icon.setIcon(new ImageIcon(logo_eye));

        firstInput.add(eye_icon);

        JLabel greenP = new JLabel();
        greenP.setBounds(0, 44, 440, 48);
        ImageIcon iconp = new ImageIcon("img_Com/Signup_img/green_password.png");
        Image greenp = iconp.getImage();
        Image logop = greenp.getScaledInstance(440, 48, 4);
        greenP.setIcon(new ImageIcon(logop));
        greenP.setVisible(false);

        JLabel redP = new JLabel();
        redP.setBounds(0, 44, 440, 48);
        ImageIcon iconp_r = new ImageIcon("img_Com/Signup_img/red_password.png");
        Image redp_r = iconp_r.getImage();
        Image logop_r = redp_r.getScaledInstance(440, 48, 4);
        redP.setIcon(new ImageIcon(logop_r));
        redP.setVisible(false);

        passwordS = 0;

        if (idS == 0 && passwordS == 0 && emailS == 0 && all_check) {
            ImageIcon iconG = new ImageIcon("img_Com/Next_B/check_Next_B.png");
            Image UncheckedBG = iconG.getImage();
            Image logoG = UncheckedBG.getScaledInstance(400, 48, Image.SCALE_SMOOTH);
            SC_B.setIcon(new ImageIcon(logoG));
            ActingMod = true;
        }

        firstInput.add(redP);
        firstInput.add(greenP);

        danger = new JLabel();
        danger.setBounds(365, 59, 31, 21);
        ImageIcon icon_danger = new ImageIcon("img_Com/Signup_img/password_status/danger.png");
        Image danger_icon = icon_danger.getImage();
        Image logo_danger = danger_icon.getScaledInstance(31, 21, 4);
        danger.setIcon(new ImageIcon(logo_danger));
        danger.setVisible(false);

        normal = new JLabel();
        normal.setBounds(365, 59, 31, 21);
        ImageIcon icon_normal = new ImageIcon("img_Com/Signup_img/password_status/normal.png");
        Image normal_icon = icon_normal.getImage();
        Image logo_normal = normal_icon.getScaledInstance(31, 21, 4);
        normal.setIcon(new ImageIcon(logo_normal));
        normal.setVisible(false);

        safety = new JLabel();
        safety.setBounds(365, 59, 31, 21);
        ImageIcon icon_safety = new ImageIcon("img_Com/Signup_img/password_status/safety.png");
        Image safety_icon = icon_safety.getImage();
        Image logo_safety = safety_icon.getScaledInstance(31, 21, 4);
        safety.setIcon(new ImageIcon(logo_safety));
        safety.setVisible(false);

        cantuse = new JLabel();
        cantuse.setBounds(342, 59, 52, 21);
        ImageIcon icon_cantuse = new ImageIcon("img_Com/Signup_img/password_status/cantuse.png");
        Image cantuse_icon = icon_cantuse.getImage();
        Image logo_cantuse = cantuse_icon.getScaledInstance(52, 21, 4);
        cantuse.setIcon(new ImageIcon(logo_cantuse));
        cantuse.setVisible(false);

        firstInput.add(danger);
        firstInput.add(normal);
        firstInput.add(safety);
        firstInput.add(cantuse);

        eye_icon.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                eye_clicked = !eye_clicked;
                if (eye_clicked) {
                    psBox.setEchoChar((char) 0); // 비밀번호 표시
                    ImageIcon icon_eye = new ImageIcon("img_Com/Signup_img/signup_icon/closed_eye.png");
                    Image icon_e = icon_eye.getImage();
                    Image logo_eye = icon_e.getScaledInstance(26, 26, 4);
                    eye_icon.setIcon(new ImageIcon(logo_eye));
                } else {
                    String password = String.valueOf(psBox.getPassword());
                    if (!password.equals("비밀번호")) {
                        psBox.setEchoChar('•'); // 비밀번호 가리기
                        ImageIcon icon_eye = new ImageIcon("img_Com/Signup_img/signup_icon/opened_eye.png");
                        Image icon_e = icon_eye.getImage();
                        Image logo_eye = icon_e.getScaledInstance(26, 26, 4);
                        eye_icon.setIcon(new ImageIcon(logo_eye));
                    }
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                eye_icon.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                eye_icon.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

        });
        psBox.setEchoChar((char) 0);

        psBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                String password = String.valueOf(psBox.getPassword());
                boolean pw_rule_check = isValidInputPassword(password);

                if (pw_rule_check) {
                    redP.setVisible(false);
                    greenP.setVisible(true);

                    passwordS = 0;

                    if (idS == 0 && passwordS == 0 && emailS == 0 && all_check) {
                        ImageIcon iconG = new ImageIcon("img_Com/Next_B/check_Next_B.png");
                        Image UncheckedBG = iconG.getImage();
                        Image logoG = UncheckedBG.getScaledInstance(400, 48, Image.SCALE_SMOOTH);
                        SC_B.setIcon(new ImageIcon(logoG));
                        ActingMod = true;
                    }

                    psBox.setForeground(Color.BLACK);
                    if (password.equals("비밀번호")) {
                        psBox.setText("");
                        psBox.setEchoChar('•');
                    }
                } else { //red
                    greenP.setVisible(false);
                    redP.setVisible(true);

                    passwordS = 1;
                    ActingMod = false;
                    ImageIcon iconR = new ImageIcon("img_Com/Next_B/uncheck_Next_B.png");
                    Image UncheckedBR = iconR.getImage();
                    Image logoR = UncheckedBR.getScaledInstance(400, 48, Image.SCALE_SMOOTH);
                    SC_B.setIcon(new ImageIcon(logoR));
                    psBox.setForeground(new Color(252, 37, 49));

                }

                if (password.equals("비밀번호")) {
                    psBox.setText("");
                    psBox.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                String password = String.valueOf(psBox.getPassword());
                boolean pw_rule_check = isValidInputPassword(password);

                Get_PW = password;

                if (password.matches("[a-zA-Z]{8,16}")) { // 위험
                    firstInput.setComponentZOrder(danger, 0);
                    danger.setVisible(true);
                    normal.setVisible(false);
                    safety.setVisible(false);
                    cantuse.setVisible(false);
                } else if (password.matches("[a-zA-Z0-9]{8,16}")) { //보통
                    firstInput.setComponentZOrder(normal, 0);
                    danger.setVisible(false);
                    normal.setVisible(true);
                    safety.setVisible(false);
                    cantuse.setVisible(false);
                } else if (password.matches("[\\p{Alnum}_!@#\\$%^&*\\(\\)-+=~`{}\\[\\]\\|:;\"'<>,.?/]{8,16}")) { //안전
                    firstInput.setComponentZOrder(safety, 0);
                    danger.setVisible(false);
                    normal.setVisible(false);
                    safety.setVisible(true);
                    cantuse.setVisible(false);
                } else { // 시용 불가
                    firstInput.setComponentZOrder(cantuse, 0);
                    danger.setVisible(false);
                    normal.setVisible(false);
                    safety.setVisible(false);
                    cantuse.setVisible(true);
                    psBox.setForeground(new Color(252, 37, 49));
                }


                if (pw_rule_check) {
                    redP.setVisible(false);
                    greenP.setVisible(false);

                    passwordS = 0;

                    if (idS == 0 && passwordS == 0 && emailS == 0 && all_check) {
                        ImageIcon iconG = new ImageIcon("img_Com/Next_B/check_Next_B.png");
                        Image UncheckedBG = iconG.getImage();
                        Image logoG = UncheckedBG.getScaledInstance(400, 48, Image.SCALE_SMOOTH);
                        SC_B.setIcon(new ImageIcon(logoG));
                        ActingMod = true;
                    }

                    psBox.setForeground(Color.BLACK);
                    if (password.equals("비밀번호")) {
                        psBox.setText("");
                        psBox.setEchoChar('•');
                    }
                } else {
                    greenP.setVisible(false);
                    redP.setVisible(true);

                    passwordS = 1;
                    ActingMod = false;
                    ImageIcon iconR = new ImageIcon("img_Com/Next_B/uncheck_Next_B.png");
                    Image UncheckedBR = iconR.getImage();
                    Image logoR = UncheckedBR.getScaledInstance(400, 48, Image.SCALE_SMOOTH);
                    SC_B.setIcon(new ImageIcon(logoR));
                    psBox.setForeground(new Color(252, 37, 49));
                }

                String password_V = String.valueOf(psBox.getPassword());
                if (password_V.isEmpty()) {
                    psBox.setText("비밀번호");
                    psBox.setEchoChar((char) 0);

                    ImageIcon iconR = new ImageIcon("img_Com/Next_B/uncheck_Next_B.png");
                    Image UncheckedBR = iconR.getImage();
                    Image logoR = UncheckedBR.getScaledInstance(400, 48, Image.SCALE_SMOOTH);
                    SC_B.setIcon(new ImageIcon(logoR));
                }
            }
        });
        psBox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    firstInput.requestFocus();
                }
            }
        });

        firstInput.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                firstInput.requestFocus();
            }
        });

        psBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String password = String.valueOf(psBox.getPassword());
                if (password.equals("비밀번호")) {
                    psBox.setText("");
                    psBox.setEchoChar('•');
                    psBox.setForeground(Color.BLACK);
                }
                if (String.valueOf(psBox.getPassword()).equals("비밀번호")) {
                    psBox.setText("");
                    psBox.setForeground(Color.BLACK);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                psBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                psBox.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        psBox.setBorder(new LineBorder(Color.gray, 0));

        redP.setName("redP");
        greenP.setName("greenP");
        eye_icon.setName("eye_icon");
        lock_icon.setName("lockicon");
        psBox.setName("psBox");

        firstInput.add(lock_icon);
    }

    private static boolean isValidInputID(String input) {
        return input.matches("[a-zA-Z0-9_]{5,20}");
    }

    private static boolean isValidInputPassword(String input) {
        return input.matches("[\\p{Alnum}_!@#\\$%^&*\\(\\)-+=~`{}\\[\\]\\|:;\"'<>,.?/]{8,16}");
    }

    public static void EmailPanel(JPanel firstInput) {

        emBox = new JTextField("이메일 주소 (인증 번호 전송 용)");
        emBox.setFont(new Font("Dialog", Font.PLAIN, 14));
        emBox.setForeground(new Color(160, 160, 160));
        emBox.setBounds(37, 94, 336, 40);

        JLabel email_icon = new JLabel();
        email_icon.setBounds(12, 101, 21, 21);
        ImageIcon email_lock = new ImageIcon("img_Com/Signup_img/signup_icon/email.png");
        Image email_l = email_lock.getImage();
        Image logo_email = email_l.getScaledInstance(21, 21, 4);
        email_icon.setIcon(new ImageIcon(logo_email));

        JLabel email_icon_r = new JLabel();
        email_icon_r.setBounds(12, 101, 21, 21);
        ImageIcon email_lock_r = new ImageIcon("img_Com/Signup_img/signup_icon/red/red_email.png");
        Image email_l_r = email_lock_r.getImage();
        Image logo_email_r = email_l_r.getScaledInstance(21, 21, 4);
        email_icon_r.setIcon(new ImageIcon(logo_email_r));
        email_icon_r.setVisible(false);

        JLabel greenE = new JLabel();
        greenE.setBounds(0, 90, 440, 48);
        ImageIcon icongE = new ImageIcon("img_Com/Signup_img/green_email.png");
        Image Egreen = icongE.getImage();
        Image logogE = Egreen.getScaledInstance(440, 48, 4);
        greenE.setIcon(new ImageIcon(logogE));
        greenE.setVisible(false);

        JLabel redE = new JLabel();
        redE.setBounds(0, 90, 440, 48);
        ImageIcon iconrE = new ImageIcon("img_Com/Signup_img/red_email.png");
        Image Ered = iconrE.getImage();
        Image logorE = Ered.getScaledInstance(440, 48, 4);
        redE.setIcon(new ImageIcon(logorE));
        redE.setVisible(false);

        emBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (emBox.getText().equals("이메일 주소 (인증 번호 전송 용)")) {
                    emBox.setText("");
                    emBox.setForeground(Color.BLACK);
                }

                String Email = emBox.getText();
                boolean em_r_checker = isValidInputEmail(Email);

                if (Email.isEmpty()) {
                    redE.setVisible(false);
                    greenE.setVisible(true);
                    emBox.setForeground(Color.BLACK);
                    emailS = 0;

                    ActingMod = false;
                    ImageIcon iconR = new ImageIcon("img_Com/Next_B/uncheck_Next_B.png");
                    Image UncheckedBR = iconR.getImage();
                    Image logoR = UncheckedBR.getScaledInstance(400, 48, Image.SCALE_SMOOTH);
                    SC_B.setIcon(new ImageIcon(logoR));

                    email_icon_r.setVisible(false);
                    email_icon.setVisible(true);

                    firstInput.setComponentZOrder(emBox, 0);
                } else if (em_r_checker) {
                    redE.setVisible(false);
                    greenE.setVisible(true);
                    emBox.setForeground(Color.BLACK);

                    emailS = 0;
                    if (idS == 0 && passwordS == 0 && emailS == 0 && all_check) {
                        ImageIcon iconG = new ImageIcon("img_Com/Next_B/check_Next_B.png");
                        Image UncheckedBG = iconG.getImage();
                        Image logoG = UncheckedBG.getScaledInstance(400, 48, Image.SCALE_SMOOTH);
                        SC_B.setIcon(new ImageIcon(logoG));
                        ActingMod = true;
                    }

                    email_icon_r.setVisible(false);
                    email_icon.setVisible(true);


                    firstInput.setComponentZOrder(emBox, 0);
                } else { //red
                    greenE.setVisible(false);
                    redE.setVisible(true);
                    emBox.setForeground(new Color(252, 37, 49));
                    emailS = 1;

                    email_icon.setVisible(false);
                    email_icon_r.setVisible(true);

                    firstInput.setComponentZOrder(emBox, 0);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

                if (emBox.getText().isEmpty() || emBox.getText().equals("이메일 주소 (본인 확인 용)")) {
                    emBox.setText("이메일 주소 (본인 확인 용)");
                    emBox.setForeground(new Color(160, 160, 160));
                }

                String Email = emBox.getText();
                boolean em_r_checker = isValidInputEmail(Email);

                if (em_r_checker) {
                    redE.setVisible(false);
                    greenE.setVisible(false);
                    emBox.setForeground(Color.BLACK);

                    emailS = 0;
                    email_icon_r.setVisible(false);
                    email_icon.setVisible(true);

                    firstInput.setComponentZOrder(emBox, 0);
                } else {
                    greenE.setVisible(false);
                    redE.setVisible(true);
                    emBox.setForeground(new Color(252, 37, 49));
                    emailS = 1;

                    ActingMod = false;
                    ImageIcon iconR = new ImageIcon("img_Com/Next_B/uncheck_Next_B.png");
                    Image UncheckedBR = iconR.getImage();
                    Image logoR = UncheckedBR.getScaledInstance(400, 48, Image.SCALE_SMOOTH);
                    SC_B.setIcon(new ImageIcon(logoR));


                    email_icon.setVisible(false);
                    email_icon_r.setVisible(true);

                    firstInput.setComponentZOrder(emBox, 0);
                }
            }
        });

        emBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (emBox.getText().equals("이메일 주소 (본인 확인 용)")) {
                    emBox.setText("");
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                emBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                emBox.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        emBox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    firstInput.requestFocus();
                }
            }
        });

        firstInput.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                firstInput.requestFocus();
            }
        });

        emBox.setBorder(new LineBorder(Color.gray, 0));

        firstInput.add(emBox);
        firstInput.add(email_icon);
        firstInput.add(email_icon_r);
        firstInput.add(redE);
        firstInput.add(greenE);
    }

    private static boolean isValidInputEmail(String input) {
        return input.matches("[a-zA-Z0-9_@.]{5,28}");
    }

    public static void WarningPanel(JPanel firstInput) {
        JLabel Overlap = new JLabel("다른 사용자가 사용중인 아이디입니다.");
        Overlap.setForeground(new Color(252, 37, 49));
        Overlap.setFont(new Font("Dialog", Font.PLAIN, 14));
        Overlap.setBounds(0, 0, 440, 14);
        Overlap.setVisible(false);

        JPanel warninglabel = new JPanel();
        warninglabel.setOpaque(true);
        warninglabel.setLayout(new BoxLayout(warninglabel, BoxLayout.Y_AXIS));
        warninglabel.setBackground(Color.white);
        warninglabel.setBounds(0, 145, 440, 500);

        JLabel idWarning = new JLabel("아이디: 필수 정보입니다.");
        idWarning.setForeground(new Color(252, 37, 49));
        idWarning.setFont(new Font("Dialog", Font.PLAIN, 14));
        idWarning.setBounds(0, 0, 440, 14);
        idWarning.setVisible(false);

        JLabel pwWarning = new JLabel("비밀번호: 8~16자의 영문 대/소문자, 숫자, 특수문자를 사용해 주세요.");
        pwWarning.setForeground(new Color(252, 37, 49));
        pwWarning.setFont(new Font("Dialog", Font.PLAIN, 14));
        pwWarning.setBounds(0, 0, 440, 14);
        pwWarning.setVisible(false);

        JLabel emWarning = new JLabel("이메일: 이메일 주소가 정확한지 확인해 주세요.");
        emWarning.setForeground(new Color(252, 37, 49));
        emWarning.setFont(new Font("Dialog", Font.PLAIN, 14));
        emWarning.setBounds(0, 0, 440, 14);
        emWarning.setVisible(false);

        JLabel Blank1 = new JLabel("Blank");
        Blank1.setForeground(Color.white);
        Blank1.setFont(new Font("Dialog", Font.PLAIN, 14));
        Blank1.setBounds(0, 0, 440, 14);
        Blank1.setVisible(true);

        JLabel Blank2 = new JLabel("Blank");
        Blank2.setForeground(Color.white);
        Blank2.setFont(new Font("Dialog", Font.PLAIN, 14));
        Blank2.setBounds(0, 0, 440, 14);
        Blank2.setVisible(true);

        warninglabel.add(Overlap);
        warninglabel.add(idWarning);
        warninglabel.add(pwWarning);
        warninglabel.add(emWarning);
        warninglabel.add(Blank1);

        PolicyAgree(warninglabel);
        warninglabel.add(Blank2);
        VerifyNumber(warninglabel);
        Timer3(warninglabel);

        Runnable task = () -> {
            while (true) {
                if (idS == 1) {
                    idWarning.setVisible(true);
                }
                if (idS == 0) {
                    idWarning.setVisible(false);
                }
                if (idS == 2) {
                    Overlap.setVisible(false);
                }
                if (idS == 3) {
                    Overlap.setVisible(true);
                }
                if (passwordS == 1) {
                    pwWarning.setVisible(true);
                }
                if (passwordS == 0) {
                    pwWarning.setVisible(false);
                }
                if (emailS == 1) {
                    emWarning.setVisible(true);
                }
                if (emailS == 0) {
                    emWarning.setVisible(false);
                }
            }
        };

        Thread thread = new Thread(task);
        thread.start();

        firstInput.add(warninglabel);
    }

    public static void PolicyAgree(JPanel policyPanel) {
        JLabel Policy = new JLabel();
        Policy.setBounds(0, 0, 440, 171);
        ImageIcon iconP = new ImageIcon("img_Com/Signup_img/signup_icon/policy_frame.png");
        Image Picon = iconP.getImage();
        Image logoP = Picon.getScaledInstance(440, 151, 4);
        Policy.setIcon(new ImageIcon(logoP));

        C_check_box = new JLabel();
        ImageIcon iconB = new ImageIcon("img_Com/unchecked_checkbox.png");
        Image UnckeckedB = iconB.getImage();
        Image logo = UnckeckedB.getScaledInstance(22, 22, 4);
        C_check_box.setIcon(new ImageIcon(logo));
        C_check_box.setBounds(12, 13, 22, 22);
        C_check_box.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                all_check = !all_check;
                if (all_check) {
                    ImageIcon iconB = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = iconB.getImage();
                    Image logo = UnckeckedB.getScaledInstance(22, 22, 4);
                    C_check_box.setIcon(new ImageIcon(logo));

                    all_check = true;
                    if (idS == 0 && passwordS == 0 && emailS == 0 && all_check) {
                        ImageIcon iconG = new ImageIcon("img_Com/Next_B/check_Next_B.png");
                        Image UncheckedBG = iconG.getImage();
                        Image logoG = UncheckedBG.getScaledInstance(400, 48, Image.SCALE_SMOOTH);
                        SC_B.setIcon(new ImageIcon(logoG));
                        ActingMod = true;
                    }

                    Arrays.fill(V_checks, true);

                    ImageIcon iconB_1 = new ImageIcon("img_Com/Signup_img/signup_icon/green_V.png");
                    Image UnckeckedB_1 = iconB_1.getImage();
                    Image logo_1 = UnckeckedB_1.getScaledInstance(15, 15, 4);
                    EtPolicy_Button1.setIcon(new ImageIcon(logo_1));

                    ImageIcon iconB_2 = new ImageIcon("img_Com/Signup_img/signup_icon/green_V.png");
                    Image UnckeckedB_2 = iconB_2.getImage();
                    Image logo_2 = UnckeckedB_2.getScaledInstance(15, 15, 4);
                    EtPolicy_Button2.setIcon(new ImageIcon(logo_2));

                    ImageIcon iconB_3 = new ImageIcon("img_Com/Signup_img/signup_icon/green_V.png");
                    Image UnckeckedB_3 = iconB_3.getImage();
                    Image logo_3 = UnckeckedB_3.getScaledInstance(15, 15, 4);
                    EtPolicy_Button3.setIcon(new ImageIcon(logo_3));

                    ImageIcon iconB_4 = new ImageIcon("img_Com/Signup_img/signup_icon/green_V.png");
                    Image UnckeckedB_4 = iconB_4.getImage();
                    Image logo_4 = UnckeckedB_4.getScaledInstance(15, 15, 4);
                    EtPolicy_Button4.setIcon(new ImageIcon(logo_4));

                    ImageIcon iconB_5 = new ImageIcon("img_Com/Signup_img/signup_icon/green_V.png");
                    Image UnckeckedB_5 = iconB_5.getImage();
                    Image logo_5 = UnckeckedB_5.getScaledInstance(15, 15, 4);
                    EtPolicy_Button5.setIcon(new ImageIcon(logo_5));
                } else {
                    ImageIcon iconB = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image UnckeckedB = iconB.getImage();
                    Image logo = UnckeckedB.getScaledInstance(22, 22, 4);
                    C_check_box.setIcon(new ImageIcon(logo));
                    all_check = false;

                    ActingMod = false;
                    ImageIcon iconR = new ImageIcon("img_Com/Next_B/uncheck_Next_B.png");
                    Image UncheckedBR = iconR.getImage();
                    Image logoR = UncheckedBR.getScaledInstance(400, 48, Image.SCALE_SMOOTH);
                    SC_B.setIcon(new ImageIcon(logoR));

                    Arrays.fill(V_checks, false);

                    ImageIcon iconB_1 = new ImageIcon("img_Com/Signup_img/signup_icon/uncheck_V.png");
                    Image UnckeckedB_1 = iconB_1.getImage();
                    Image logo_1 = UnckeckedB_1.getScaledInstance(15, 15, 4);
                    EtPolicy_Button1.setIcon(new ImageIcon(logo_1));

                    ImageIcon iconB_2 = new ImageIcon("img_Com/Signup_img/signup_icon/uncheck_V.png");
                    Image UnckeckedB_2 = iconB_2.getImage();
                    Image logo_2 = UnckeckedB_2.getScaledInstance(15, 15, 4);
                    EtPolicy_Button2.setIcon(new ImageIcon(logo_2));

                    ImageIcon iconB_3 = new ImageIcon("img_Com/Signup_img/signup_icon/uncheck_V.png");
                    Image UnckeckedB_3 = iconB_3.getImage();
                    Image logo_3 = UnckeckedB_3.getScaledInstance(15, 15, 4);
                    EtPolicy_Button3.setIcon(new ImageIcon(logo_3));

                    ImageIcon iconB_4 = new ImageIcon("img_Com/Signup_img/signup_icon/uncheck_V.png");
                    Image UnckeckedB_4 = iconB_4.getImage();
                    Image logo_4 = UnckeckedB_4.getScaledInstance(15, 15, 4);
                    EtPolicy_Button4.setIcon(new ImageIcon(logo_4));

                    ImageIcon iconB_5 = new ImageIcon("img_Com/Signup_img/signup_icon/uncheck_V.png");
                    Image UnckeckedB_5 = iconB_5.getImage();
                    Image logo_5 = UnckeckedB_5.getScaledInstance(15, 15, 4);
                    EtPolicy_Button5.setIcon(new ImageIcon(logo_5));
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                C_check_box.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                C_check_box.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JLabel Policy_string = new JLabel("인증 약관 전체동의");
        Policy_string.setOpaque(true);
        Policy_string.setBackground(Color.white);
        Policy_string.setBounds(73, 16, 120, 15);
        Policy_string.setFont(new Font("Dialog", Font.BOLD, 14));
        Policy_string.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                all_check = !all_check;
                if (all_check) {
                    ImageIcon iconB = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = iconB.getImage();
                    Image logo = UnckeckedB.getScaledInstance(22, 22, 4);
                    C_check_box.setIcon(new ImageIcon(logo));
                    all_check = true;


                    if (idS == 0 && passwordS == 0 && emailS == 0 && all_check) {
                        ImageIcon iconG = new ImageIcon("img_Com/Next_B/check_Next_B.png");
                        Image UncheckedBG = iconG.getImage();
                        Image logoG = UncheckedBG.getScaledInstance(400, 48, Image.SCALE_SMOOTH);
                        SC_B.setIcon(new ImageIcon(logoG));
                        ActingMod = true;
                    }
                } else {
                    ImageIcon iconB = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image UnckeckedB = iconB.getImage();
                    Image logo = UnckeckedB.getScaledInstance(22, 22, 4);
                    C_check_box.setIcon(new ImageIcon(logo));
                    all_check = false;

                    ActingMod = false;
                    ImageIcon iconR = new ImageIcon("img_Com/Next_B/uncheck_Next_B.png");
                    Image UncheckedBR = iconR.getImage();
                    Image logoR = UncheckedBR.getScaledInstance(400, 48, Image.SCALE_SMOOTH);
                    SC_B.setIcon(new ImageIcon(logoR));
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Policy_string.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                Policy_string.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JLabel Force_Button = new JLabel("[필수]");
        Force_Button.setOpaque(true);
        Force_Button.setBackground(Color.white);
        Force_Button.setFont(new Font("Dialog", Font.BOLD, 14));
        Force_Button.setForeground(new Color(23, 158, 74));
        Force_Button.setBounds(37, 16, 53, 15);
        Force_Button.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                all_check = !all_check;
                if (all_check) {
                    ImageIcon iconB = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = iconB.getImage();
                    Image logo = UnckeckedB.getScaledInstance(22, 22, 4);
                    C_check_box.setIcon(new ImageIcon(logo));
                    all_check = true;
                } else {
                    ImageIcon iconB = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image UnckeckedB = iconB.getImage();
                    Image logo = UnckeckedB.getScaledInstance(22, 22, 4);
                    C_check_box.setIcon(new ImageIcon(logo));
                    all_check = false;
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Force_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                Force_Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JLabel Blank = new JLabel("Blank");
        Blank.setForeground(Color.white);
        Blank.setFont(new Font("Dialog", Font.PLAIN, 14));
        Blank.setBounds(0, 0, 440, 14);
        Blank.setVisible(true);

        small_Poicy_agree1(Policy);
        small_Poicy_agree2(Policy);
        small_Poicy_agree3(Policy);
        small_Poicy_agree4(Policy);
        small_Poicy_agree5(Policy);

        Policy.add(Policy_string);
        Policy.add(Force_Button);
        Policy.add(C_check_box);

        policyPanel.add(Policy);
    }

    public static void small_Poicy_agree1(JLabel Policy) {
        EtPolicy_Button1 = new JLabel();
        EtPolicy_Button1.setBounds(16, 65, 15, 15);
        ImageIcon iconB_1 = new ImageIcon("img_Com/Signup_img/signup_icon/uncheck_V.png");
        Image UnckeckedB_1 = iconB_1.getImage();
        Image logo_1 = UnckeckedB_1.getScaledInstance(15, 15, 4);
        EtPolicy_Button1.setIcon(new ImageIcon(logo_1));
        EtPolicy_Button1.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                V_checks[0] = !V_checks[0];
                if (V_checks[0]) {
                    ImageIcon iconB_1 = new ImageIcon("img_Com/Signup_img/signup_icon/green_V.png");
                    Image UnckeckedB_1 = iconB_1.getImage();
                    Image logo_1 = UnckeckedB_1.getScaledInstance(15, 15, 4);
                    EtPolicy_Button1.setIcon(new ImageIcon(logo_1));
                    V_checks[0] = true;
                } else {
                    ImageIcon iconB_1 = new ImageIcon("img_Com/Signup_img/signup_icon/uncheck_V.png");
                    Image UnckeckedB_1 = iconB_1.getImage();
                    Image logo_1 = UnckeckedB_1.getScaledInstance(15, 15, 4);
                    EtPolicy_Button1.setIcon(new ImageIcon(logo_1));
                    V_checks[0] = false;
                }

                if (areAllTrue(V_checks)) {
                    ImageIcon iconB = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = iconB.getImage();
                    Image logo = UnckeckedB.getScaledInstance(22, 22, 4);
                    C_check_box.setIcon(new ImageIcon(logo));
                    all_check = true;
                } else {
                    ImageIcon iconB = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image UnckeckedB = iconB.getImage();
                    Image logo = UnckeckedB.getScaledInstance(22, 22, 4);
                    C_check_box.setIcon(new ImageIcon(logo));
                    all_check = false;
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                EtPolicy_Button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                EtPolicy_Button1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        Policy.add(EtPolicy_Button1);
    }

    public static void small_Poicy_agree2(JLabel Policy) {
        EtPolicy_Button2 = new JLabel();
        EtPolicy_Button2.setBounds(220, 65, 15, 15);
        ImageIcon iconB_2 = new ImageIcon("img_Com/Signup_img/signup_icon/uncheck_V.png");
        Image UnckeckedB_2 = iconB_2.getImage();
        Image logo_2 = UnckeckedB_2.getScaledInstance(15, 15, 4);
        EtPolicy_Button2.setIcon(new ImageIcon(logo_2));
        EtPolicy_Button2.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                V_checks[1] = !V_checks[1];
                if (V_checks[1]) {
                    ImageIcon iconB_2 = new ImageIcon("img_Com/Signup_img/signup_icon/green_V.png");
                    Image UnckeckedB_2 = iconB_2.getImage();
                    Image logo_2 = UnckeckedB_2.getScaledInstance(15, 15, 4);
                    EtPolicy_Button2.setIcon(new ImageIcon(logo_2));
                    V_checks[1] = true;
                } else {
                    ImageIcon iconB_2 = new ImageIcon("img_Com/Signup_img/signup_icon/uncheck_V.png");
                    Image UnckeckedB_2 = iconB_2.getImage();
                    Image logo_2 = UnckeckedB_2.getScaledInstance(15, 15, 4);
                    EtPolicy_Button2.setIcon(new ImageIcon(logo_2));
                    V_checks[2] = false;
                }
                if (areAllTrue(V_checks)) {
                    ImageIcon iconB = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = iconB.getImage();
                    Image logo = UnckeckedB.getScaledInstance(22, 22, 4);
                    C_check_box.setIcon(new ImageIcon(logo));
                    all_check = true;
                } else {
                    ImageIcon iconB = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image UnckeckedB = iconB.getImage();
                    Image logo = UnckeckedB.getScaledInstance(22, 22, 4);
                    C_check_box.setIcon(new ImageIcon(logo));
                    all_check = false;
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                EtPolicy_Button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                EtPolicy_Button2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        Policy.add(EtPolicy_Button2);
    }

    public static void small_Poicy_agree3(JLabel Policy) {
        EtPolicy_Button3 = new JLabel();
        EtPolicy_Button3.setBounds(16, 91, 15, 15);
        ImageIcon iconB_3 = new ImageIcon("img_Com/Signup_img/signup_icon/uncheck_V.png");
        Image UnckeckedB_3 = iconB_3.getImage();
        Image logo_3 = UnckeckedB_3.getScaledInstance(15, 15, 4);
        EtPolicy_Button3.setIcon(new ImageIcon(logo_3));
        EtPolicy_Button3.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                V_checks[2] = !V_checks[2];
                if (V_checks[2]) {
                    ImageIcon iconB_3 = new ImageIcon("img_Com/Signup_img/signup_icon/green_V.png");
                    Image UnckeckedB_3 = iconB_3.getImage();
                    Image logo_3 = UnckeckedB_3.getScaledInstance(15, 15, 4);
                    EtPolicy_Button3.setIcon(new ImageIcon(logo_3));
                    V_checks[2] = true;
                } else {
                    ImageIcon iconB_3 = new ImageIcon("img_Com/Signup_img/signup_icon/uncheck_V.png");
                    Image UnckeckedB_3 = iconB_3.getImage();
                    Image logo_3 = UnckeckedB_3.getScaledInstance(15, 15, 4);
                    EtPolicy_Button3.setIcon(new ImageIcon(logo_3));
                    V_checks[2] = false;
                }
                if (areAllTrue(V_checks)) {
                    ImageIcon iconB = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = iconB.getImage();
                    Image logo = UnckeckedB.getScaledInstance(22, 22, 4);
                    C_check_box.setIcon(new ImageIcon(logo));
                    all_check = true;
                } else {
                    ImageIcon iconB = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image UnckeckedB = iconB.getImage();
                    Image logo = UnckeckedB.getScaledInstance(22, 22, 4);
                    C_check_box.setIcon(new ImageIcon(logo));
                    all_check = false;
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                EtPolicy_Button3.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                EtPolicy_Button3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        Policy.add(EtPolicy_Button3);
    }

    public static void small_Poicy_agree4(JLabel Policy) {
        EtPolicy_Button4 = new JLabel();
        EtPolicy_Button4.setBounds(220, 91, 15, 15);
        ImageIcon iconB_4 = new ImageIcon("img_Com/Signup_img/signup_icon/uncheck_V.png");
        Image UnckeckedB_4 = iconB_4.getImage();
        Image logo_4 = UnckeckedB_4.getScaledInstance(15, 15, 4);
        EtPolicy_Button4.setIcon(new ImageIcon(logo_4));
        EtPolicy_Button4.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                V_checks[3] = !V_checks[3];
                if (V_checks[3]) {
                    ImageIcon iconB_4 = new ImageIcon("img_Com/Signup_img/signup_icon/green_V.png");
                    Image UnckeckedB_4 = iconB_4.getImage();
                    Image logo_4 = UnckeckedB_4.getScaledInstance(15, 15, 4);
                    EtPolicy_Button4.setIcon(new ImageIcon(logo_4));
                    V_checks[3] = true;
                } else {
                    ImageIcon iconB_4 = new ImageIcon("img_Com/Signup_img/signup_icon/uncheck_V.png");
                    Image UnckeckedB_4 = iconB_4.getImage();
                    Image logo_4 = UnckeckedB_4.getScaledInstance(15, 15, 4);
                    EtPolicy_Button4.setIcon(new ImageIcon(logo_4));
                    V_checks[3] = false;
                }
                if (areAllTrue(V_checks)) {
                    ImageIcon iconB = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = iconB.getImage();
                    Image logo = UnckeckedB.getScaledInstance(22, 22, 4);
                    C_check_box.setIcon(new ImageIcon(logo));
                    all_check = true;
                } else {
                    ImageIcon iconB = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image UnckeckedB = iconB.getImage();
                    Image logo = UnckeckedB.getScaledInstance(22, 22, 4);
                    C_check_box.setIcon(new ImageIcon(logo));
                    all_check = false;
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                EtPolicy_Button4.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                EtPolicy_Button4.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        Policy.add(EtPolicy_Button4);
    }

    public static void small_Poicy_agree5(JLabel Policy) {
        EtPolicy_Button5 = new JLabel();
        EtPolicy_Button5.setBounds(16, 116, 15, 15);
        ImageIcon iconB_5 = new ImageIcon("img_Com/Signup_img/signup_icon/uncheck_V.png");
        Image UnckeckedB_5 = iconB_5.getImage();
        Image logo_5 = UnckeckedB_5.getScaledInstance(15, 15, 4);
        EtPolicy_Button5.setIcon(new ImageIcon(logo_5));
        EtPolicy_Button5.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                V_checks[4] = !V_checks[4];
                if (V_checks[4]) {
                    ImageIcon iconB_5 = new ImageIcon("img_Com/Signup_img/signup_icon/green_V.png");
                    Image UnckeckedB_5 = iconB_5.getImage();
                    Image logo_5 = UnckeckedB_5.getScaledInstance(15, 15, 4);
                    EtPolicy_Button5.setIcon(new ImageIcon(logo_5));
                    V_checks[4] = true;
                } else {
                    ImageIcon iconB_5 = new ImageIcon("img_Com/Signup_img/signup_icon/uncheck_V.png");
                    Image UnckeckedB_5 = iconB_5.getImage();
                    Image logo_5 = UnckeckedB_5.getScaledInstance(15, 15, 4);
                    EtPolicy_Button5.setIcon(new ImageIcon(logo_5));
                    V_checks[4] = false;
                }
                if (areAllTrue(V_checks)) {
                    ImageIcon iconB = new ImageIcon("img_Com/checked_checkbox.png");
                    Image UnckeckedB = iconB.getImage();
                    Image logo = UnckeckedB.getScaledInstance(22, 22, 4);
                    C_check_box.setIcon(new ImageIcon(logo));
                    all_check = true;
                } else {
                    ImageIcon iconB = new ImageIcon("img_Com/unchecked_checkbox.png");
                    Image UnckeckedB = iconB.getImage();
                    Image logo = UnckeckedB.getScaledInstance(22, 22, 4);
                    C_check_box.setIcon(new ImageIcon(logo));
                    all_check = false;
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                EtPolicy_Button5.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                EtPolicy_Button5.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        Policy.add(EtPolicy_Button5);
    }

    public static boolean areAllTrue(boolean[] array) {
        for (boolean element : array) {
            if (!element) {
                return false;
            }
        }
        return true;
    }

    public static void VerifyNumber(JPanel NumberPane) {
        JLabel Number = new JLabel();
        Number.setBounds(0, 0, 440, 48);
        ImageIcon iconN = new ImageIcon("img_Com/verifynumber_Gr.png");
        Image Nicon = iconN.getImage();
        Image logoN = Nicon.getScaledInstance(440, 48, 4);
        Number.setIcon(new ImageIcon(logoN));

        JLabel lock_icon = new JLabel();
        lock_icon.setBounds(12, 12, 21, 21);
        ImageIcon icon_lock = new ImageIcon("img_Com/Signup_img/signup_icon/lock.png");
        Image icon_l = icon_lock.getImage();
        Image logo_lock = icon_l.getScaledInstance(21, 21, 4);
        lock_icon.setIcon(new ImageIcon(logo_lock));

        NumBox = new JTextField("인증번호 6자리 입력"); //아이디 이름 적기
        NumBox.setOpaque(true);
        NumBox.setFont(new Font("Dialog", Font.PLAIN, 14));
        NumBox.setForeground(new Color(160, 160, 160));
        NumBox.setBounds(37, 4, 300, 40);
        Number.setComponentZOrder(NumBox, 0);

        greenNum = new JLabel(); // 파란색 프레임 설정
        greenNum.setBounds(0, 0, 440, 48);
        ImageIcon icong = new ImageIcon("img_Com/verifynumber_G.png");
        Image greenid = icong.getImage();
        Image logog = greenid.getScaledInstance(440, 48, 4);
        greenNum.setIcon(new ImageIcon(logog));
        greenNum.setVisible(false);


        NumBox.addFocusListener(new FocusAdapter() {
            int first_click = 0;

            @Override
            public void focusGained(FocusEvent e) {
                boolean num_rule_Checker = isValidEmailNumber(NumBox.getText());
                first_click++;
                if (first_click == 1) {
                    NumBox.setForeground(Color.BLACK);
                    greenNum.setVisible(true);
                } else {
                    if (num_rule_Checker) {
                        NumBox.setForeground(Color.BLACK);
                        greenNum.setVisible(true);

                    } else { //red
                        greenNum.setVisible(false);

                        if (NumBox.getText().equals("인증번호 6자리 입력")) {
                            NumBox.setText("");
                        }
                    }
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                NumBoxText = NumBox.getText();
                boolean num_rule_Checker = isValidEmailNumber(NumBoxText);
                greenNum.setVisible(false);

                if (num_rule_Checker) {
                    NumBox.setForeground(Color.black);
                    Match = true;
                    NotMatch = false;
                } else { // red
                    if (NumBox.getText().isEmpty()) {
                        NumBox.setText("인증번호 6자리 입력");
                        NumBox.setForeground(new Color(160, 160, 160));
                    }
                    Match = false;
                    NotMatch = true;
                    C_vertify.setText("인증하기");
                }
                Number.setComponentZOrder(NumBox, 0);
            }
        });

        NumBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (NumBox.getText().equals("인증번호 6자리 입력")) {
                    NumBox.setText("");
                    NumBox.setForeground(Color.BLACK);
                }
                Number.setComponentZOrder(NumBox, 0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                NumBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                NumBox.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        NumBox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    NumberPane.requestFocus();
                }
            }
        });

        NumberPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                NumberPane.requestFocus();
            }
        });

        Number.add(greenNum);
        Number.add(NumBox);
        NumBox.setBorder(new LineBorder(Color.gray, 0));

        Number.add(lock_icon);

        NumberPane.add(Number);
    }

    public static void SendCode(JPanel contentPane) {

        SC_B = new JLabel();
        SC_B.setVisible(true);
        ImageIcon icon = new ImageIcon("img_Com/Next_B/uncheck_Next_B.png");
        Image UncheckedB = icon.getImage();
        Image logo = UncheckedB.getScaledInstance(400, 48, Image.SCALE_SMOOTH);
        SC_B.setIcon(new ImageIcon(logo));
        SC_B.setBounds(90, 17, 400, 48);
        SC_B.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (ActingMod) {
                    naverMailSendOrSignUp();
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                SC_B.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                SC_B.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        C_vertify.setForeground(Color.white);
        C_vertify.setFont(new Font("Dialog", Font.BOLD, 18));
        C_vertify.setBounds(260, 30, 80, 20);
        C_vertify.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                C_vertify.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                C_vertify.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        contentPane.add(C_vertify);
        contentPane.add(SC_B);
        contentPane.revalidate();
        contentPane.repaint();
    }

    public static void naverMailSendOrSignUp() {
        String Cv = C_vertify.getText();

        if (Cv.equals("인증하기")) {
            Random random = new Random();

            // 100000 이상 999999 이하의 랜덤 정수 생성
            int randomNumber = random.nextInt(900000) + 100000;
            String randomString = Integer.toString(randomNumber);
            Verify_Number = randomString;

            String host = "smtp.naver.com";
            String user = "ldyeon2789@naver.com";
            String password = "dlehdus789><"; // 생성된 애플리케이션 비밀번호 사용

            // SMTP 서버 정보를 설정한다.
            Properties props = new Properties();
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true"); // TLS 사용 설정
            props.put("mail.smtp.ssl.protocols", "TLSv1.2 TLSv1.1 TLSv1"); // 허용할 TLS 프로토콜 설정

            // 세션을 생성한다
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, password);
                }
            });

            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(user));
                // 받는 사람의 이메일 주소 설정
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(emBox.getText()));

                // 메일 제목
                message.setSubject("인증번호");

                // 메일 내용
                message.setText("인증 번호 : " + randomString);
                System.out.println(randomString);


                // 메일을 전송한다
                Transport.send(message);
                Send = true;


            } catch (MessagingException e) {
                e.printStackTrace();
            }
            C_vertify.setText("가입하기");
        } else if (Match && Cv.equals("가입하기")) {
            SignIn = true;
        }
    }

    public static boolean isValidEmailNumber(String input) {
        if (input.equals(Verify_Number)) {
            return true;
        } else {
            return false;
        }
    }

    public static void Timer3(JPanel NumberPane) {
        JLabel timer3 = new JLabel();
        timer3.setForeground(Color.WHITE);
        timer3.setVisible(false);

        JLabel StatusText = new JLabel();
        StatusText.setForeground(new Color(252, 37, 49));
        StatusText.setVisible(false);
        NumberPane.add(StatusText);
        NumberPane.add(timer3);

        // Create a Timer that updates the label every second
        int delay = 1000; // milliseconds
        timer = new Timer(delay, new ActionListener() {
            int remainingSeconds = 180; // 3 minutes in seconds

            @Override
            public void actionPerformed(ActionEvent e) {

                if (Match) {
                    StatusText.setVisible(true);
                    StatusText.setForeground(new Color(27, 201, 75));
                    StatusText.setText("인증번호 일치");
                }
                if (NotMatch) {
                    StatusText.setVisible(true);
                    StatusText.setForeground(new Color(252, 37, 49));
                    StatusText.setText("인증번호 불일치");
                }
                if (Send) {
                    timer3.setVisible(true);
                    timer3.setForeground(new Color(252, 37, 49));
                    if (remainingSeconds >= 0) {
                        int minutes = remainingSeconds / 60;
                        int seconds = remainingSeconds % 60;
                        timer3.setText(String.format("%d:%02d", minutes, seconds));
                        remainingSeconds--;
                    } else {
                        timer3.setVisible(false);
                        StatusText.setVisible(false);

                        C_vertify.setText("인증하기");
                        Match = false;
                        NotMatch = false;
                        Send = false;
                        remainingSeconds = 180;
                    }

                }
                if (SignIn) {

                    String filePath = "DB/" + Get_ID + ".txt"; // 생성할 파일의 경로

                    MessageDigest md = null;
                    try {
                        md = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException ex) {
                        throw new RuntimeException(ex);
                    }

                    byte[] hashedData = md.digest(Get_PW.getBytes());

                    try (FileWriter writer = new FileWriter(filePath)) {
                        writer.write(Base64.getEncoder().encodeToString(hashedData));
                    } catch (IOException er) {
                        System.err.println("파일 작성 중 오류가 발생했습니다: " + er.getMessage());
                    }

                    disposeSignupPage();
                }
            }
        });

        timer.start();
    }

    public static void disposeSignupPage() {
        if (SignupMain.signup_Page != null) {
            SignupMain.signup_Page.dispose();
        }
        if (timer != null) {
            timer.stop();
        }
    }
}