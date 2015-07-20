import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MoveMessage extends JFrame{
    public MoveMessage()
    {
        MovableMessagePanel p = new MovableMessagePanel("Welcome to China");
        setLayout(new BorderLayout());
        add(p);
    }
    public static void main(String[] args)
    {
        MoveMessage demo = new MoveMessage();
        demo.setTitle("Demo");
        demo.setSize(200,100);
        demo.setLocationRelativeTo(null);
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        demo.setVisible(true);
    }
    static class MovableMessagePanel extends JPanel
    {
        private String message = "Welcome to Java";
        private int x = 20;
        private int y = 20;
        public MovableMessagePanel(String s)
        {
            message = s;
            addMouseMotionListener(new MouseMotionAdapter(){
               public void mouseDragged(MouseEvent e)
               {
                   x = e.getX();
                   y = e.getY();
                   repaint();
               }
            });
        }
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.drawString(message, x, y);
        }
                
    }
}
