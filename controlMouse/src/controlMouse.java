import java.awt.*;
import java.awt.event.InputEvent;



public class controlMouse
{


    private static int[] getScreenSize()
    {
        int[] screen = new int[2];
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        screen[0] = d.width;
        screen[1] = d.height;

        return screen;
    }

    private static synchronized void Wait() {
        try {
            controlMouse.class.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args)
    {
        int x,y;
        int[] screenSize;
        screenSize = getScreenSize();
        System.out.println(screenSize[0]);
        System.out.println(screenSize[1]);

        x = (53*screenSize[0]/96);
        y = (109*screenSize[1]/216);
        System.out.println("x: "+x+" y: "+y);
            try {

                Robot robot = new Robot();


                /************************************
                 *MOVER MOUSE
                 ***********************************/
                robot.mouseMove(x, y);

                /************************************
                 *CLICK IZQUIERDO
                 ***********************************/
                Wait();
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);


                /************************************
                 *RUEDITA DEL MOUSE
                 ***********************************/
                robot.mousePress(InputEvent.BUTTON2_MASK);
                robot.mouseRelease(InputEvent.BUTTON2_MASK);

                /************************************
                 *CLICK DERECHO
                 ***********************************/
                robot.mousePress(InputEvent.BUTTON3_MASK);
                robot.mouseRelease(InputEvent.BUTTON3_MASK);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

}
