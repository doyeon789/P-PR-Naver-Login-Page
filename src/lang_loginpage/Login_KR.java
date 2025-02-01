package lang_loginpage;

import lang_signuppage_document.AgreeMain;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Login_KR {
    public static void addFindPassword(JPanel panel){

        JLabel findps_kr = new JLabel("비밀번호 찾기");
        findps_kr.setFont(new Font("Dialog",Font.PLAIN,14));
        findps_kr.setForeground(new Color(88,88,88));
        findps_kr.setBounds(137,511,80,15);

        findps_kr.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                System.out.println("비밀번호 찾기");
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                findps_kr.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                findps_kr.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JLabel stick1 = new JLabel("|");
        stick1.setFont(new Font("Dialog",Font.PLAIN,10));
        stick1.setForeground(new Color(160,160,160));
        stick1.setBounds(235,511,17,17);

        panel.add(stick1);
        panel.add(findps_kr);
    }
    public static void addFindid(JPanel panel){
        JLabel findid_kr= new JLabel("아이디 찾기");
        findid_kr.setFont(new Font("Dialog",Font.PLAIN,14));
        findid_kr.setForeground(new Color(88,88,8));
        findid_kr.setBounds(261,511,70,15);

        findid_kr.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                System.out.println("아이디 찾기");
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                findid_kr.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                findid_kr.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JLabel stick2 = new JLabel("|");
        stick2.setFont(new Font("Dialog",Font.PLAIN,10));
        stick2.setForeground(new Color(160,160,160));
        stick2.setBounds(345,511,17,17);

        panel.add(stick2);
        panel.add(findid_kr);
    }
    public static void addSignup(JPanel panel){
        JLabel signup_kr = new JLabel("회원가입");
        signup_kr.setFont(new Font("Dialog",Font.PLAIN,14));
        signup_kr.setForeground(new Color(88,88,8));
        signup_kr.setBounds(368,511,50,15);
        signup_kr.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                AgreeMain.a_main(signup_kr);
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                signup_kr.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                signup_kr.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        panel.add(signup_kr);
    }

    public static void addLoginbutton(JPanel panel) {
        JLabel loginbutton = new JLabel();
        loginbutton.setOpaque(false);
        loginbutton.setBounds(90, 415, 400, 52);

        loginbutton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                String filePath = "DB/" + idBox.getText() + ".txt";
                // File 객체 생성
                // File 객체 생성
                File file = new File(filePath);

                String Get_PW = String.valueOf(psBox.getPassword());
                String expectedContent;

                // Use MD5 to hash the password
                MessageDigest md = null;
                try {
                    md = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException ex) {
                    throw new RuntimeException(ex);
                }

                byte[] hashedData = md.digest(Get_PW.getBytes());

                // Base64 encoding for storing as a string
                expectedContent = Base64.getEncoder().encodeToString(hashedData);

                boolean isID;
                boolean isPW;

                // Check if the file exists
                if (file.exists()) {
                    isID = true;
                } else {
                    isID = false;
                }

                // Compare hashed password with the stored hash
                try {
                    String fileContent = Files.readAllLines(Paths.get(filePath)).get(0);

                    if (expectedContent.equals(fileContent)) {
                        isPW = true;
                    } else {
                        isPW = false;
                    }
                } catch (IOException er) {
                    System.out.println("파일을 읽는 도중 오류 발생: " + er.getMessage());
                    isPW = false;
                } catch (IndexOutOfBoundsException er) {
                    System.out.println("파일이 비어 있거나 예상보다 내용이 적습니다.");
                    isPW = false;
                }

                if (isID && isPW) {
                    System.out.println("로그인 성공");
                } else {
                    System.out.println("로그인 실패");
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                loginbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                loginbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        panel.add(loginbutton);
    }

    public static void addMaker(JPanel panel) {
        final JLabel maker = new JLabel("made by. doyeon");
        maker.setFont(new Font("Arial", Font.BOLD, 14));
        maker.setForeground(new Color(64, 202, 102));
        int maker_width = 130;
        int maker_height = 20;
        maker.setBounds(240, 620, maker_width, maker_height);
        maker.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                String url = "https://www.instagram.com/7._d.yn/";

                try {
                    Desktop.getDesktop().browse(new URI(url));
                } catch (URISyntaxException | IOException var4) {
                    throw new RuntimeException(var4);
                }
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                maker.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                maker.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        panel.add(maker);
    }

    public static void addNaverLabel(JPanel panel) {
        JLabel naver = new JLabel();
        int naver_width = 170;
        int naver_height = 32;
        ImageIcon icon = new ImageIcon("/Users/doyeon/Documents/My Java Work/gui/login/img_Com/logo.png");
        Image naver_img = icon.getImage();
        Image logo = naver_img.getScaledInstance(naver_width, naver_height, 4);
        naver.setIcon(new ImageIcon(logo));
        naver.setBounds(205, 80, naver_width, naver_height);

        naver.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                String url = "https://www.naver.com";

                try {
                    Desktop.getDesktop().browse(new URI(url));
                } catch (URISyntaxException | IOException var4) {
                    throw new RuntimeException(var4);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                naver.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                naver.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        panel.add(naver);
    }

    public static void addLoginBoxLabel(JPanel panel) {
        JLabel loginbox = new JLabel();
        int loginbox_width = 460;
        int loginbox_height = 308;
        ImageIcon login_box_icon = new ImageIcon("/Users/doyeon/Documents/My Java Work/gui/login/img_KR/naverlogin_KR.png");
        Image login_img = login_box_icon.getImage();
        Image login_box = login_img.getScaledInstance(loginbox_width, loginbox_height, 4);
        loginbox.setIcon(new ImageIcon(login_box));
        loginbox.setBounds(60, 180, loginbox_width, loginbox_height);
        panel.add(loginbox);
    }

    static JTextField idBox = new JTextField("아이디");
    static JPasswordField psBox = new JPasswordField("비밀번호");
    static boolean eye_clicked = true;

    static public void addInputSpace(JPanel panel) {
        idBox.setOpaque(true);
        idBox.setFont(new Font("Dialog", Font.PLAIN, 14));
        idBox.setForeground(new Color(160, 160, 160));
        idBox.setBounds(129, 255, 336, 44);


        idBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (idBox.getText().equals("아이디")) {
                    idBox.setText("");
                    idBox.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (idBox.getText().equals("아이디")) {
                    idBox.setText("아이디");
                    idBox.setForeground(new Color(160, 160, 160));
                }
            }
        });

        idBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (idBox.getText().equals("아이디")) {
                    idBox.setText("");
                    idBox.setForeground(Color.BLACK);
                }
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

        idBox.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "escape");
        idBox.getActionMap().put("escape", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (idBox.getText().equals("아이디")) {
                    idBox.setText("아이디");
                    idBox.setForeground(new Color(160, 160, 160));
                }
            }
        });

        JLabel Xbuttonid = getLabel(panel);

        idBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (idBox.getText().equals("아이디")) {
                    idBox.setText("");
                    idBox.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (idBox.getText().isEmpty()) {
                    idBox.setText("아이디");
                    idBox.setForeground(new Color(160, 160, 160));
                }
            }
        });

        idBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (idBox.getText().equals("아이디")) {
                    idBox.setText("");
                    idBox.setForeground(Color.BLACK);
                }
            }
        });

        idBox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    panel.requestFocus();
                }
            }
        });

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                panel.requestFocus();
            }
        });

        panel.add(idBox);
        idBox.setBorder(new LineBorder(Color.gray, 0));
        panel.add(Xbuttonid);

        /* ############################################################################################################## */
        JLabel eye_icon = new JLabel();
        eye_icon.setBounds(425, 311, 24, 24);
        ImageIcon icon_eye = new ImageIcon("img_Com/Signup_img/signup_icon/closed_eye.png");
        Image icon_e = icon_eye.getImage();
        Image logo_eye = icon_e.getScaledInstance(24, 24, 4);
        eye_icon.setIcon(new ImageIcon(logo_eye));
        eye_icon.setVisible(false);

        psBox.setFont(new Font("Dialog", Font.PLAIN, 14));
        psBox.setForeground(new Color(160, 160, 160));
        psBox.setText("비밀번호");
        psBox.setBounds(129, 301, 336, 44);
        psBox.setEchoChar((char) 0); // 기본 상태에서는 힌트 텍스트가 보이도록 설정

        eye_icon.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (eye_clicked) {
                    psBox.setEchoChar((char) 0); // 비밀번호 표시
                    ImageIcon icon_eye = new ImageIcon("img_Com/Signup_img/signup_icon/opened_eye.png");
                    Image icon_e = icon_eye.getImage();
                    Image logo_eye = icon_e.getScaledInstance(26, 26, 4);
                    eye_icon.setIcon(new ImageIcon(logo_eye));
                }
                else {
                    String password = String.valueOf(psBox.getPassword());
                    if (!password.equals("비밀번호")) {
                        psBox.setEchoChar('•'); // 비밀번호 가리기
                        ImageIcon icon_eye = new ImageIcon("img_Com/Signup_img/signup_icon/closed_eye.png");
                        Image icon_e = icon_eye.getImage();
                        Image logo_eye = icon_e.getScaledInstance(26, 26, 4);
                        eye_icon.setIcon(new ImageIcon(logo_eye));
                    }
                }
                eye_clicked = !eye_clicked;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                eye_icon.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                eye_icon.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        psBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                String password = String.valueOf(psBox.getPassword());
                if (password.equals("비밀번호")) {
                    psBox.setText("");
                    psBox.setEchoChar('•'); // 비밀번호 입력 시 보여줄 문자를 설정
                    psBox.setForeground(Color.BLACK);
                    eye_icon.setVisible(true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                String password = String.valueOf(psBox.getPassword());
                if (password.isEmpty()) {
                    psBox.setText("비밀번호");
                    psBox.setEchoChar((char) 0); // 힌트 텍스트를 보여줄 때는 EchoChar를 비활성화
                    psBox.setForeground(new Color(160, 160, 160));
                    eye_icon.setVisible(false);
                }
            }
        });

        psBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                psBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                psBox.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        psBox.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "escape");
        psBox.getActionMap().put("escape", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (String.valueOf(psBox.getPassword()).isEmpty()) {
                    psBox.setText("비밀번호");
                    psBox.setForeground(new Color(160, 160, 160));
                    psBox.setEchoChar((char) 0);
                }
            }
        });

        JLabel Xbuttonpw = getjLabel(panel);
        Xbuttonpw.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                eye_icon.setVisible(false);
            }
        });

        psBox.setBorder(new LineBorder(Color.gray, 0));
        panel.add(eye_icon);
        panel.add(psBox);
        panel.add(Xbuttonpw);
    }

    private static JLabel getLabel(JPanel panel) {
        JLabel Xbuttonid = new JLabel();

        int Xbuttonid_width = 14;
        int Xbuttonid_height = 14;
        ImageIcon iconid = new ImageIcon("img_Com/X.png");
        Image Xbuttonid_img = iconid.getImage();
        Image logoid = Xbuttonid_img.getScaledInstance(Xbuttonid_width, Xbuttonid_height, 4);
        Xbuttonid.setIcon(new ImageIcon(logoid));
        Xbuttonid.setBounds(465, 270, Xbuttonid_width, Xbuttonid_height);

        Xbuttonid.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                idBox.setText("아이디");
                idBox.setFont(new Font("Dialog", Font.PLAIN, 14));
                idBox.setForeground(new Color(160, 160, 160));

                panel.requestFocusInWindow();
            }
        });
        return Xbuttonid;
    }

    private static JLabel getjLabel(JPanel panel) {
        JLabel Xbuttonpw = new JLabel();

        int Xbuttonpw_width = 14;
        int Xbuttonpw_height = 14;
        ImageIcon iconpw = new ImageIcon("img_Com/X.png");
        Image Xbuttonpw_img = iconpw.getImage();
        Image logopw = Xbuttonpw_img.getScaledInstance(Xbuttonpw_width, Xbuttonpw_height, 4);
        Xbuttonpw.setIcon(new ImageIcon(logopw));
        Xbuttonpw.setBounds(465, 317, Xbuttonpw_width, Xbuttonpw_height);

        Xbuttonpw.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                psBox.setText("비밀번호");
                psBox.setEchoChar((char) 0);
                psBox.setFont(new Font("Dialog", Font.PLAIN, 14));
                psBox.setForeground(new Color(160, 160, 160));

                panel.requestFocusInWindow();
            }
        });
        return Xbuttonpw;
    }
}