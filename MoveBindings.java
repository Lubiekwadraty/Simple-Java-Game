package JavaGame;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MoveBindings {
    public static void Bindings(JPanel jPanel){
        Controls up = Controls.UP_ACTION;
        Controls down = Controls.DOWN_ACTION;
        Controls left = Controls.LEFT_ACTION;
        Controls right = Controls.RIGHT_ACTION;

        jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), up);
        jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), down);
        jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), left);
        jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), right);

        jPanel.getActionMap().put(up, new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                Main.upPressed = true;
            }
        });
        jPanel.getActionMap().put(down, new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                Main.downPressed = true;
            }
        });
        jPanel.getActionMap().put(left, new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                Main.leftPressed = true;
            }
        });
        jPanel.getActionMap().put(right, new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                Main.rightPressed = true;
            }
        });

        Controls releaseUp = Controls.UP_RELEASE;
        Controls releaseDown = Controls.DOWN_RELEASE;
        Controls releaseLeft = Controls.LEFT_RELEASE;
        Controls releaseRight = Controls.RIGHT_RELEASE;

        jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), releaseUp);
        jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), releaseDown);
        jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), releaseLeft);
        jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), releaseRight);

        jPanel.getActionMap().put(releaseUp, new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                Main.upPressed = false;
            }
        });
        jPanel.getActionMap().put(releaseDown, new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                Main.downPressed = false;
            }
        });
        jPanel.getActionMap().put(releaseLeft, new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                Main.leftPressed = false;
            }
        });
        jPanel.getActionMap().put(releaseRight, new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                Main.rightPressed = false;
            }
        });
    }
}
