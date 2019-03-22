import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Scanner;


public class controlMouse
{


    private static synchronized void Wait() {
        try {
            controlMouse.class.wait(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args)
    {
        while(true) {
            int x, y;
            int[] screenSize;
            Scanner input = new Scanner(System.in);

            System.out.println("Ingrese x: ");
            x = input.nextInt();
            System.out.println("Ingrese y: ");
            y = input.nextInt();
            try {

                Robot robot = new Robot();


                /************************************
                 *MOVER MOUSE
                 ***********************************/
                robot.mouseMove(x, y);

                /************************************
                 *CLICK IZQUIERDO
                 ***********************************/
                //Wait();
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);


                /************************************
                 *RUEDITA DEL MOUSE
                 ***********************************/
              /*  robot.mousePress(InputEvent.BUTTON2_MASK);
                robot.mouseRelease(InputEvent.BUTTON2_MASK);*/

                /************************************
                 *CLICK DERECHO
                 ***********************************/
                /*robot.mousePress(InputEvent.BUTTON3_MASK);
                robot.mouseRelease(InputEvent.BUTTON3_MASK);*/
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
