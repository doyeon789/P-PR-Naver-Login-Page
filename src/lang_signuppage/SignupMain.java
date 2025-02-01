package lang_signuppage;

import lang_signuppage_document.AgreeMain;

import javax.swing.*;

public class SignupMain extends AgreeMain {

    protected static JFrame signup_Page;

    public static void s_main()  {

        signup_Page = new JFrame("SignUp Page");

        JPanel signup_panel1 = new JPanel();
        JPanel signup_panel2 = new JPanel();
        JPanel signup_panel3 = new JPanel();

        SignupFrameWork.sFrame(signup_Page);
        SignupFrameWork.sPanel(signup_Page,signup_panel1,signup_panel2,signup_panel3);

        signup_panel1.revalidate();
        signup_panel1.repaint();

        signup_panel2.revalidate();
        signup_panel2.repaint();

        signup_panel3.revalidate();
        signup_panel3.repaint();
    }
    public static void dis(){
        dispose_Frame();
    }
}
