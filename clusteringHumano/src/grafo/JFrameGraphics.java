package grafo;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameGraphics extends JPanel{
    public void paint(Graphics g){
        int xValues[] = {25, 145, 25, 145, 25};
        int yValues[] = {25, 25, 145, 145, 25};
        int points = 5;        
        g.drawPolygon(xValues, yValues, points);
    }
    
    public static void main(String[] args){
        JFrame frame= new JFrame("JavaTutorial.net");    
        frame.getContentPane().add(new JFrameGraphics());
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);        
    }
}