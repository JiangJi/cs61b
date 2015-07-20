import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.color.*;
import java.awt.*;
public class ControlCircle extends JFrame {
    private JButton jbtEnlarge = new JButton("Enlarge");
    private JButton jbtShrink = new JButton("Shrink");
    private CirclePanel canvas = new CirclePanel();
    public ControlCircle()
    {
        JPanel panel = new JPanel();
        jbtEnlarge.addActionListener(new Enlarger());
        jbtShrink.addActionListener(new Shrinker());
        panel.add(jbtEnlarge);
        panel.add(jbtShrink);
        this.add(canvas,BorderLayout.CENTER);
        this.add(panel,BorderLayout.SOUTH);
    }
    class Enlarger implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            canvas.enlarge();
        }
    }
    class Shrinker implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            canvas.shrink();
        }
    }
    public static void main(String[] args)
    {
        JFrame frame = new ControlCircle();
        frame.setTitle("ControlCircle");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,200);
        frame.setVisible(true);
    }
    class CirclePanel extends JPanel
    {
        private int radius = 5;
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.drawOval(getWidth()/2-radius, getHeight()/2-radius, 2*radius, 2*radius);
        }
        public void enlarge()
        {
            radius+=10;
            repaint();
        }
        public void shrink()
        {
            radius-=10;
            repaint();
        }
    }
}
