import java.awt.*;
import java.awt.event.InputEvent;



public class controlMouse
{


    private static synchronized void Wait() {
        try {
            controlMouse.class.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args)
    {
            try {

                Robot robot = new Robot();


                /************************************
                 *MOVER MOUSE
                 ***********************************/
                robot.mouseMove(870, 545);

                /************************************
                 *CLICK IZQUIERDO
                 ***********************************/
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
                Wait();

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
