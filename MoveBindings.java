package JavaGame;
// package lekcja2;

// import javax.swing.JPanel;
// import javax.swing.KeyStroke;
// import javax.swing.JComponent;


// public class MoveBindings {
//     public JPanel jPanel = new JPanel();
//     public void Bindings(){
        
//         Controls up = Controls.UP_ACTION;
//         Controls down = Controls.DOWN_ACTION;
//         Controls left = Controls.LEFT_ACTION;
//         Controls right = Controls.RIGHT_ACTION;


//         jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), up); //trzeci argument przycisnięty ma wartosc false
//         jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), down);
//         jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), left);
//         jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), right);
        
//         jPanel.getActionMap().put(up, new AbstractAction(){
//             @Override 
//             public void actionPerformed(ActionEvent e){
//                 System.out.println("up");
//             }
//         });
//     }
// }
