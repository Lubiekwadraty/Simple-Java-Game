package JavaGame;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class Circle extends JPanel {
    public int x = 0;
    public int y = 0;
    public int width = 50;
    public int height = 50;
    
    public Circle(){
        setOpaque(false);
    }
    
    @Override 
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillOval(0, 0, width, height);
    }

    public void moveTo(int x, int y){
        this.x = x;
        this.y = y;
        setBounds(x, y, width, height);
        repaint();
    }

    public boolean Collides(Box box){
        double radius = width / 2;
        double centerX = x + radius;
        double centerY = y + radius;

        double closestX = Math.max(box.x, Math.min(centerX, box.x + box.width));
        double closestY = Math.max(box.y, Math.min(centerY, box.y + box.height));

        double dx = centerX - closestX;
        double dy = centerY - closestY;

        return dx * dx + dy * dy <= radius * radius;
    }
}

