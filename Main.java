package JavaGame;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;



public class Main {
    static JPanel jPanel = new JPanel();
    static Circle circle = new Circle();

    static boolean upPressed = false;
    static boolean downPressed = false;
    static boolean leftPressed = false;
    static boolean rightPressed = false;


    static void main(){
        // SwingUtilities.invokeLater(() -> {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Game");
        jFrame.setSize(1280, 720);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.add(jPanel);
        // jFrame.setLayout(null);
        jFrame.add(circle);
        circle.moveTo(100, 200);
        jFrame.setVisible(true);
        // });
        UpdateBackground();

    }

    static void Update(){
        if(upPressed){
            circle.moveTo(circle.x, circle.y - 4);
        }
        if(downPressed){
            circle.moveTo(circle.x, circle.y + 4);
        }
        if(leftPressed){
            circle.moveTo(circle.x - 4, circle.y);
        }
        if(rightPressed){
            circle.moveTo(circle.x + 4, circle.y);
        }
        Bounds();
    }

    static final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    static void UpdateBackground(){
        MoveBindings();

        new javax.swing.Timer(16, e -> Update()).start();
    }

    static void MoveBindings(){
        Controls up = Controls.UP_ACTION;
        Controls down = Controls.DOWN_ACTION;
        Controls left = Controls.LEFT_ACTION;
        Controls right = Controls.RIGHT_ACTION;
        
        jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), up); //trzeci argument przycisnięty ma wartosc false
        jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), down);
        jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), left);
        jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), right);

        
        jPanel.getActionMap().put(up, new AbstractAction(){
            @Override 
            public void actionPerformed(ActionEvent e){
                upPressed = true;
            }
        });
        jPanel.getActionMap().put(down, new AbstractAction(){
            @Override 
            public void actionPerformed(ActionEvent e){
                downPressed = true;
            }
        });
        jPanel.getActionMap().put(left, new AbstractAction(){
            @Override 
            public void actionPerformed(ActionEvent e){
                leftPressed = true;
            }
        });
        jPanel.getActionMap().put(right, new AbstractAction(){
            @Override 
            public void actionPerformed(ActionEvent e){
                rightPressed = true;
            }
        });

        Controls releaseUp = Controls.UP_RELEASE;
        Controls releaseDown = Controls.DOWN_RELEASE;
        Controls releaseLeft = Controls.LEFT_RELEASE;
        Controls releaseRight = Controls.RIGHT_RELEASE;

        jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), releaseUp); //trzeci argument przycisnięty ma wartosc false
        jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), releaseDown);
        jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), releaseLeft);
        jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), releaseRight);

        jPanel.getActionMap().put(releaseUp, new AbstractAction(){
            @Override 
            public void actionPerformed(ActionEvent e){
                upPressed = false;
            }
        });
        jPanel.getActionMap().put(releaseDown, new AbstractAction(){
            @Override 
            public void actionPerformed(ActionEvent e){
                downPressed = false;
            }
        });
        jPanel.getActionMap().put(releaseLeft, new AbstractAction(){
            @Override 
            public void actionPerformed(ActionEvent e){
                leftPressed = false;
            }
        });
        jPanel.getActionMap().put(releaseRight, new AbstractAction(){
            @Override 
            public void actionPerformed(ActionEvent e){
                rightPressed = false;
            }
        });
    }

    static void Bounds(){
        int maxX = Math.max(0, circle.getWidth() - 50);
        int maxY = Math.max(0, circle.getHeight() - 50);

        int boundedX = Math.max(0, Math.min(circle.x, maxX));
        int boundedY = Math.max(0, Math.min(circle.y, maxY));

        if (boundedX != circle.x || boundedY != circle.y) {
            circle.moveTo(boundedX, boundedY);
        }
    }
}



