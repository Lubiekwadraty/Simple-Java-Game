package JavaGame;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;



public class Main {
    static JPanel jPanel = new JPanel();
    static Circle circle = new Circle();
    static Box box = new Box();
    static boolean upPressed = false;
    static boolean downPressed = false;
    static boolean leftPressed = false;
    static boolean rightPressed = false;


    static void main(){
        // SwingUtilities.invokeLater(() -> {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Game");
        jFrame.setSize(1280, 720);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jPanel.setLayout(null);
        jFrame.add(jPanel);

        jPanel.add(circle);
        jPanel.add(box);
        circle.moveTo(100, 200);

        box.moveTo(200, 300);
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

        if(circle.Collides(box)){
            System.out.println("collides");
        }
        else{
            System.out.println("not collides");
        }
    }

    static final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    static void UpdateBackground(){
        MoveBindings.Bindings(jPanel);

        new javax.swing.Timer(16, e -> Update()).start();
    }

    static void Bounds(){
        int maxX = Math.max(0, jPanel.getWidth() - circle.width);
        int maxY = Math.max(0, jPanel.getHeight() - circle.height);

        int boundedX = Math.max(0, Math.min(circle.x, maxX));
        int boundedY = Math.max(0, Math.min(circle.y, maxY));

        if (boundedX != circle.x || boundedY != circle.y) {
            circle.moveTo(boundedX, boundedY);
        }
    }
}



