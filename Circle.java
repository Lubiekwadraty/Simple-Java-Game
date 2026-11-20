package JavaGame;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class Circle extends JPanel {
    public int x = 0;
    public int y = 0;

    @Override 
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillOval(x, y, 50, 50);
    }

    public void moveTo(int x, int y){
        this.x = x;
        this.y = y;
        repaint();
    }
}
