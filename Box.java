package JavaGame;

import java.awt.*;
import javax.swing.JPanel;

public class Box extends JPanel{
    public int x = 0;
    public int y = 0;
    public int width = 50;
    public int height = 50;
    
    public Box(){
        setOpaque(false);
    }

    @Override 
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, width, height);
    }

    public void moveTo(int x, int y){
        this.x = x;
        this.y = y;
        setBounds(x, y, width, height);
        repaint();
    }
}
