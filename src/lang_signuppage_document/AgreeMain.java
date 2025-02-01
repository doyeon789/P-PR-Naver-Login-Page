package lang_signuppage_document;

import javax.swing.*;

public class AgreeMain {

    static JFrame agree_page;

    public static void a_main(JLabel signup_kr) {

        agree_page= new JFrame("Agreement Page");
        JPanel agree_panel1 = new JPanel();
        JPanel agree_panel2 = new JPanel();
        JPanel agree_panel3 = new JPanel();

        AgreeFrameWork.aFrame(agree_page, signup_kr);
        AgreeFrameWork.aPanel(agree_page,agree_panel1,agree_panel2,agree_panel3);

        agree_panel1.revalidate();
        agree_panel1.repaint();

        agree_panel2.revalidate();
        agree_panel2.repaint();

        agree_panel3.revalidate();
        agree_panel3.repaint();
    }
    public static void dispose_Frame(){
        agree_page.dispose();
    }
}
