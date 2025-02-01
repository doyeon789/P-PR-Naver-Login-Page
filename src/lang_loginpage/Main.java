package lang_loginpage;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Login Page");
        JPanel panel = new JPanel();

        FrameWork.Frame(frame);
        FrameWork.Panel(panel,frame);

        panel.revalidate();
        panel.repaint();
    }
}
