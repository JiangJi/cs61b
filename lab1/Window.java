import java.awt.event.*;
import javax.swing.JFrame;
public class Window extends JFrame {
    public static void main(String[] args)
    {
        Window frame = new Window();
        frame.setSize(220,80);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("TestWindowEvent");
        frame.setVisible(true);
    }
    public Window() {
        addWindowListener(new WindowAdapter(){
           public void windowActivated(WindowEvent event)
           {
               System.out.println("Activated");
           }
        });
    }
}