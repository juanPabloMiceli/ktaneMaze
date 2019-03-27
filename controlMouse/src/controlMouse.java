import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Scanner;


public class controlMouse
{


    private static synchronized void Wait(int timeout) {

        try {
            controlMouse.class.wait(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args)
    {
        while(true) {
            int x, y, dX, dY;
            int[] screenSize;
            Scanner input = new Scanner(System.in);

            System.out.println("Ingrese x: ");
            x = input.nextInt();
            System.out.println("Ingrese y: ");
            y = input.nextInt();
            System.out.println("Ingrese delta x: ");
            dX = input.nextInt();
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
                //robot.mousePress(InputEvent.BUTTON1_MASK);
                //robot.mouseRelease(InputEvent.BUTTON1_MASK);


                /************************************
                 *RUEDITA DEL MOUSE
                 ***********************************/
               /* robot.mousePress(InputEvent.BUTTON2_MASK);
                robot.mouseRelease(InputEvent.BUTTON2_MASK);*/

                /************************************
                 *CLICK DERECHO
                 ***********************************/
                robot.mousePress(InputEvent.BUTTON3_MASK);

                Wait(100);
                robot.mouseMove(x,y+dX);

                Wait(2000);
                robot.mouseRelease(InputEvent.BUTTON3_MASK);

                robot.mousePress(InputEvent.BUTTON3_MASK);
                Wait(300);
                robot.mouseMove(x, y-dX);
                robot.mouseRelease(InputEvent.BUTTON3_MASK);
                Wait(2000);
                robot.mousePress(InputEvent.BUTTON3_MASK);
                Wait(150);
                robot.mouseMove(x,y);
                robot.mouseRelease(InputEvent.BUTTON3_MASK);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
