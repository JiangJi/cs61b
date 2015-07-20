import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Animation extends JFrame{
    public Animation()
    {
        add(new MovieMessagePane("message moving"));
    }
    public  static void main(String[] args)
    {
        Animation frame = new Animation();
        frame.setTitle("Animation");
        frame.setSize(280,100);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    static class MovieMessagePane extends JPanel{
        private String message = "Welcome to JAVA";
        private int x =0;
        private int y =20;
        public MovieMessagePane(String message)
        {
            this.message = message;
            Timer timer = new Timer(1000,new TimerListener());
            timer.start();
        }
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            if(x>getWidth())
            {
                x -= 20;
            }
            x+=5;
            g.drawString(message, x, y);
        }
        class TimerListener implements ActionListener{
            public void actionPerformed(ActionEvent e)
            {
                repaint();
            }
        }
    }
}
