import java.awt.*;
import java.awt.event.InputEvent;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class gitMazeSolver
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

    private static Cell[][] readObject(String s)
    {
        try
        {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(s));
            Cell[][] cell = (Cell[][]) is.readObject();
            return cell;
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return new Cell[0][];
    }

    private static void setStartAndFinish(Cell[][] c, int xS, int yS, int xF, int yF)
    {
        Cell.startPosition[0]=xS;
        Cell.startPosition[1]=yS;
        Cell.finalPosition[0]=xF;
        Cell.finalPosition[1]=yF;
        Cell.currentPosition[0]=xF;
        Cell.currentPosition[1]=yF;
        c[xF][yF].cost = 0;

    }

    private static boolean[] checkNeighbors(Cell[][] c, int x, int y)
    {
        boolean[] neighbors = {false, false, false, false};

        for(int i = 0; i<c[0][0].walls.length ; i++)
        {
            neighbors[i] = c[x][y].walls[i];
        }

        return neighbors;
    }


    private static void changeCost(Cell[][] c, boolean[] neighbors, int x, int y, int cost, int cols, int rows)
    {
        if((neighbors[0] == false) && (y != 0) && (c[x][y-1].cost == 99))
            c[x][y-1].cost = cost+1;
        if((neighbors[1] == false) && (x != (cols-1)) && (c[x+1][y].cost == 99))
            c[x+1][y].cost = cost+1;
        if((neighbors[2] == false) && (y != (rows-1)) && (c[x][y+1].cost == 99))
            c[x][y+1].cost = cost+1;
        if((neighbors[3] == false) && (x != 0) && (c[x-1][y].cost == 99))
            c[x-1][y].cost = cost+1;
    }


    private static synchronized void Wait(int timeout) {
        try {
            gitMazeSolver.class.wait(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void controlMouse(int dir, int[] screenSize)
    {
        int x, y;
        try {
            Robot robot = new Robot();

            switch (dir)
            {
                case 0:
                    x = (193*screenSize[0])/396;
                    y = (5*screenSize[1])/12;
                    break;
                case 1:
                    x = (53*screenSize[0])/96;
                    y = (109*screenSize[1])/216;
                    break;
                case 2:
                    x = (193*screenSize[0])/384;
                    y = (65*screenSize[1])/108;
                    break;
                case 3:
                    x = (29*screenSize[0])/64;
                    y = (109*screenSize[1])/216;
                    break;
                default:
                    x = (193*screenSize[0])/384;
                    y = (109*screenSize[1])/216;
            }
            robot.mouseMove(x, y);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            Wait(25);

        } catch (AWTException e) {
            e.printStackTrace();
        }

    }

    private static int[] moveCell(Cell[][] c, boolean[] neighbors, int x, int y, int cols, int rows ,int[] screenSize)
    {
        int[] newPosition = new int[2];

        if((neighbors[0] == false) && (y != 0) && (c[x][y-1].cost < c[x][y].cost))
        {
            newPosition[0] = x;
            newPosition[1] = y-1;
            System.out.println("arriba");
            controlMouse(0, screenSize);
        }

        if((neighbors[1] == false) && (x != rows) && (c[x+1][y].cost < c[x][y].cost))
        {
            newPosition[0] = x+1;
            newPosition[1] = y;
            System.out.println("derecha");
            controlMouse(1, screenSize);
        }

        if((neighbors[2] == false) && (y != cols) && (c[x][y+1].cost < c[x][y].cost))
        {
            newPosition[0] = x;
            newPosition[1] = y+1;
            System.out.println("abajo");
            controlMouse(2, screenSize);
        }

        if((neighbors[3] == false) && (x != 0) && (c[x-1][y].cost < c[x][y].cost))
        {
            newPosition[0] = x-1;
            newPosition[1] = y;
            System.out.println("izquierda");
            controlMouse(3, screenSize);
        }

        return newPosition;
    }


    private static int[] askForData(int cols, int rows, int[][] coordinates)
    {
        int[] mazeData = {-1,-1,-1,-1,-1,-1,-1};
        Scanner input = new Scanner(System.in);
        boolean whileflag = false;

        clearScreen();

        while(!whileflag)
        {
            System.out.println("Ingrese la columna de cualquiera de los 2 puntos del laberinto: ");
            mazeData[0] = input.nextInt()-1;
            System.out.println("Ingrese la fila de cualquiera de los 2 puntos del laberinto: ");
            mazeData[1] = input.nextInt()-1;
            System.out.println("Ingrese columna de salida: ");
            mazeData[2] = input.nextInt()-1;
            System.out.println("Ingrese fila de salida: ");
            mazeData[3] = input.nextInt()-1;
            System.out.println("Ingrese columna de llegada: ");
            mazeData[4] = input.nextInt()-1;
            System.out.println("Ingrese fila de llegada: ");
            mazeData[5] = input.nextInt()-1;

            mazeData[6] = chooseTheMaze(mazeData[0], mazeData[1], coordinates);

            if( (mazeData[0] > (cols - 1)) || (mazeData[1] > (rows-1)) || (mazeData[2] > (cols - 1)) || (mazeData[3] > (rows-1)) || (mazeData[4] > (cols - 1)) || (mazeData[5] > (rows - 1)) || (mazeData[0] < 0) || (mazeData[1] < 0) || (mazeData[2] < 0) || (mazeData[3] < 0) ||(mazeData[4] < 0) || (mazeData[5] < 0) )
            {
                clearScreen();
                System.out.println("Algun dato fue mayor a 6 o menor a 1.");
                System.out.println("Recuerde que las filas y columnas están numeradas del 1 al 6.");
                System.out.println("Por favor, ingrese TODOS los datos nuevamente.\n");
            }
            else
            {
                if(mazeData[6] == -1)
                {
                    clearScreen();
                    System.out.println("No se encontro ningun laberinto con un punto en esas coordenadas");
                    System.out.println("Recuerde que las filas y columnas están numeradas del 1 al 6.");
                    System.out.println("Por favor, ingrese TODOS los datos nuevamente.\n");
                }
                else
                {
                    whileflag = true;
                }

            }
        }

        return mazeData;
    }

    private static void clearScreen(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

    private static int chooseTheMaze(int x, int y, int[][] coordinates)
    {
        int mazeNumber;

        if((x == coordinates[0][0] && y == coordinates[0][1]) || (x == coordinates[1][0] && y == coordinates[1][1]))
        {
            mazeNumber = 0;
        }
        else if((x == coordinates[2][0] && y == coordinates[2][1]) || (x == coordinates[3][0] && y == coordinates[3][1]))
        {
            mazeNumber = 1;
        }
        else if((x == coordinates[4][0] && y == coordinates[4][1]) || (x == coordinates[5][0] && y == coordinates[5][1]))
        {
            mazeNumber = 2;
        }
        else if((x == coordinates[6][0] && y == coordinates[6][1]) || (x == coordinates[7][0] && y == coordinates[7][1]))
        {
            mazeNumber = 3;
        }
        else if((x == coordinates[8][0] && y == coordinates[8][1]) || (x == coordinates[9][0] && y == coordinates[9][1]))
        {
            mazeNumber = 4;
        }
        else if((x == coordinates[10][0] && y == coordinates[10][1]) || (x == coordinates[11][0] && y == coordinates[11][1]))
        {
            mazeNumber = 5;
        }
        else if((x == coordinates[12][0] && y == coordinates[12][1]) || (x == coordinates[13][0] && y == coordinates[13][1]))
        {
            mazeNumber = 6;
        }
        else if((x == coordinates[14][0] && y == coordinates[14][1]) || (x == coordinates[15][0] && y == coordinates[15][1]))
        {
            mazeNumber = 7;
        }
        else if((x == coordinates[16][0] && y == coordinates[16][1]) || (x == coordinates[17][0] && y == coordinates[17][1]))
        {
            mazeNumber = 8;
        }
        else
        {
            mazeNumber = -1;
        }

        return mazeNumber;

    }

    private static void printFinalMessage()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Gran programa gran. Presiona cualquier tecla para cerrar esta ventana.");
        input.next();
    }

    public static void main(String[] args)
    {
        /*************************************
         *       DEFINO OBJETOS
         ************************************/
        Cell[][] cell;



        /*************************************
         *       VARIABLES LOCALES
         ************************************/
        int cols = 6, rows = 6, cost = 0;
        int[][] dotCoordinates =
                {
                        {0,1},
                        {5,2},
                        {1,3},
                        {4,1},
                        {3,3},
                        {5,3},
                        {0,0},
                        {0,3},
                        {4,2},
                        {3,5},
                        {2,4},
                        {4,0},
                        {1,0},
                        {1,5},
                        {3,0},
                        {2,3},
                        {0,4},
                        {2,1},
                };


        int[] mazeData = {-1,-1,-1,-1,-1,-1};
        boolean[] neighbors = new boolean[4];
        int[] screenSize;

        /*********************************************************************
         *  ASI CONSIGO EL PATH PARA EL ARCHIVO .JAR
         ********************************************************************/

        String path = gitMazeSolver.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        path = path.replace("gitMazeSolver.jar","");
        path = path.replace("%20"," ");

        String[] mazes =
                {
                        String.join("",path,"\\maze1.bin"),
                        String.join("",path,"\\maze2.bin"),
                        String.join("",path,"\\maze3.bin"),
                        String.join("",path,"\\maze4.bin"),
                        String.join("",path,"\\maze5.bin"),
                        String.join("",path,"\\maze6.bin"),
                        String.join("",path,"\\maze7.bin"),
                        String.join("",path,"\\maze8.bin"),
                        String.join("",path,"\\maze9.bin"),
                };


        /*********************************************************************
         *  ASI CONSIGO EL PATH PARA COMPILARLO LOCALMENTE
         ********************************************************************/
/*
        String path = "D:\\codigos\\codigosJava\\mazeObject\\src";

        String[] mazes =
                {
                        String.join("",path,"\\maze1.bin"),
                        String.join("",path,"\\maze2.bin"),
                        String.join("",path,"\\maze3.bin"),
                        String.join("",path,"\\maze4.bin"),
                        String.join("",path,"\\maze5.bin"),
                        String.join("",path,"\\maze6.bin"),
                        String.join("",path,"\\maze7.bin"),
                        String.join("",path,"\\maze8.bin"),
                        String.join("",path,"\\maze9.bin"),
                };

*/


        int mazeNumber = -1;
        boolean whileFlag = false;

        screenSize = getScreenSize();

        /***************************************************************************************************************************************************
         * mazeData ES UN ARRAY CON LO QUE SE PIDEN LOS DATOS DEL LABERINTO EN EL SIGUIENTE ORDEN: xCirculo, yCirculo, xSalida, ySalida, xLlegada, yLlegada
         * Se piden los datos hasta que se haya encontrado un laberinto y todos los datos ingresados sean validos
         **************************************************************************************************************************************************/

        mazeData = askForData(cols, rows, dotCoordinates);

        /*************************************
         *ACA GUARDO EL LABERINTO EN "cell"
         ************************************/

        cell = readObject(mazes[mazeData[6]]);



        /*****************************************************************************************************************
         *  GUARDO LOS DATOS INGRESADOS EN LAS VARIABLES currentPosition, finishPosition y startPosition del objeto "cell"
         *  también seteo el cost del final a 0
         ****************************************************************************************************************/
        setStartAndFinish(cell,mazeData[2],mazeData[3],mazeData[4],mazeData[5]);


        /*****************************************************************************************************************
         *  ESTE WHILE SE EJECUTE SIEMPRE Y CUANDO NO SE HAYA CAMBIADO EL COST DE LA CELDA DE INICIO
         *  ACA SE HACE LA PARTE DE CHEQUEAR LOS VECINOS DISPONIBLES Y CAMBIAR EL COST DE CADA UNA DE LAS CELDAS VISITADAS
         ****************************************************************************************************************/
        while(cell[Cell.startPosition[0]][Cell.startPosition[1]].cost == 99)
        {
            for(int x = 0 ; x < cols ; x++ )
            {
                for(int y = 0 ; y < rows ; y++ )
                {
                    if(cell[x][y].cost == cost)
                    {
                        neighbors = checkNeighbors(cell, x, y);
                        changeCost(cell, neighbors, x, y, cost, cols, rows);
                    }
                }
            }
            cost++;
        }



        /*****************************************************************************************************************
         *  HAGO QUE "currentPosition" "SE PARE" EN EL PRINCIPIO DEL LABERINTO, PARA IR ACERCANDOSE AL FINAL
         *  SIEMPRE MOVIENDOSE A CASILLAS CUYA VARIABLE COST SEA MENOR A LA ACTUAL
         *  ESTO SE HACE HASTA QUE "currentPosition" ES IGUAL A "fianlPosition"
         ****************************************************************************************************************/
        Cell.currentPosition = Cell.startPosition.clone();

        clearScreen();
        while(!Arrays.equals(Cell.currentPosition,Cell.finalPosition))
        {
            neighbors = checkNeighbors(cell, Cell.currentPosition[0], Cell.currentPosition[1]);
            Cell.currentPosition = moveCell(cell,neighbors, Cell.currentPosition[0], Cell.currentPosition[1], cols, rows, screenSize);
        }

        printFinalMessage();
        /********************
         * IMPRIMO LABERINTO
         *******************/
        /*
        for(int x = 0; x<cols ; x++)
        {
            for(int y = 0; y<rows ; y++)
            {
                System.out.printf("%s\t\t",cell[y][x].cost);
            }
            System.out.println();
        }
        */

    }
}
