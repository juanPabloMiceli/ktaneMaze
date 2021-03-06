import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;



public class Maze
{
    public static void main(String[] args)
    {

        /*******************************************************
         * VARIABLES LOCALES
         ******************************************************/

        int cols = 6, rows =6;
        String sketch = "D:\\codigos\\codigosJava\\mazeObject\\src\\";
        String[] mazes =
                {
                String.join("",sketch, "maze1.bin"),
                String.join("",sketch, "maze2.bin"),
                String.join("",sketch, "maze3.bin"),
                String.join("",sketch, "maze4.bin"),
                String.join("",sketch, "maze5.bin"),
                String.join("",sketch, "maze6.bin"),
                String.join("",sketch, "maze7.bin"),
                String.join("",sketch, "maze8.bin"),
                String.join("",sketch, "maze9.bin"),
                };
        System.out.println(mazes);


        boolean[][][] maze1 =
                {
                {{true,false,false,true}  ,{true,false,true,false} ,{true,true,false,false}  ,{true,false,false,true}  ,{true,false,true,false} ,{true,true,true,false}},
                {{false,true,false,true}  ,{true,false,false,true} ,{false,true,true,false}  ,{false,false,true,true}  ,{true,false,true,false} ,{true,true,false,false}},
                {{false,true,false,true}  ,{false,false,true,true} ,{true,true,false,false}  ,{true,false,false,true}  ,{true,false,true,false} ,{false,true,false,false}},
                {{false,true,false,true}  ,{true,false,true,true}  ,{false,false,true,false} ,{false,true,true,false}  ,{true,false,true,true}  ,{false,true,false,false}},
                {{false,false,false,true} ,{true,false,true,false} ,{true,true,false,false}  ,{true,false,false,true}  ,{true,true,true,false}  ,{false,true,false,true}},
                {{false,false,true,true}  ,{true,true,true,false}  ,{false,false,true,true}  ,{false,true,true,false}  ,{true,false,true,true}  ,{false,true,true,false}}
                };

        boolean[][][] maze2 =
                {
                {{true,false,true,true}   ,{true,false,false,false},{true,true,true,false}   ,{true,false,false,true}  ,{true,false,false,false} ,{true,true,true,false}},
                {{true,false,false,true}  ,{false,true,true,false} ,{true,false,false,true}  ,{false,true,true,false}  ,{false,false,true,true}  ,{true,true,false,false}},
                {{false,true,false,true}  ,{true,false,false,true} ,{false,true,true,false}  ,{true,false,false,true}  ,{true,false,true,false}  ,{false,true,false,false}},
                {{false,false,false,true} ,{false,true,true,false} ,{true,false,false,true}  ,{false,true,true,false}  ,{true,true,false,true}   ,{false,true,false,true}},
                {{false,true,false,true}  ,{true,true,false,true}  ,{false,true,false,true}  ,{true,false,false,true}  ,{false,true,true,false}  ,{false,true,false,true}},
                {{false,true,true,true}   ,{false,false,true,true} ,{false,true,true,false}  ,{false,false,true,true}  ,{true,false,true,false}  ,{false,true,true,false}}
                };

        boolean[][][] maze3 =
                {
                {{true,false,false,true}  ,{true,false,true,false} ,{true,true,false,false}  ,{true,true,false,true}   ,{true,false,false,true}  ,{true,true,false,false}},
                {{false,true,true,true}   ,{true,true,false,true}  ,{false,true,false,true}  ,{false,false,true,true}  ,{false,true,true,false}  ,{false,true,false,true}},
                {{true,false,false,true}  ,{false,true,false,false},{false,true,false,true}  ,{true,false,false,true}  ,{true,true,false,false}  ,{false,true,false,true}},
                {{false,true,false,true}  ,{false,true,false,true} ,{false,true,false,true}  ,{false,true,false,true}  ,{false,true,false,true}  ,{false,true,false,true}},
                {{false,true,false,true}  ,{false,false,true,true} ,{false,true,true,false}  ,{false,true,false,true}  ,{false,true,false,true}  ,{false,true,false,true}},
                {{false,false,true,true}  ,{true,false,true,false} ,{true,false,true,false}  ,{false,true,true,false}  ,{false,false,true,true}  ,{false,true,true,false}}
                };

        boolean[][][] maze4 =
                {
                {{true,false,false,true}  ,{true,true,false,false} ,{true,false,true,true}  ,{true,false,true,false}   ,{true,false,true,false}  ,{true,true,false,false}},
                {{false,true,false,true}  ,{false,true,false,true} ,{true,false,false,true} ,{true,false,true,false}   ,{true,false,true,false}  ,{false,true,false,false}},
                {{false,true,false,true}  ,{false,false,true,true} ,{false,true,true,false} ,{true,false,false,true}   ,{true,true,true,false}   ,{false,true,false,true}},
                {{false,true,false,true}  ,{true,false,true,true} ,{true,false,true,false} ,{false,false,true,false}  ,{true,false,true,false}  ,{false,true,false,false}},
                {{false,false,false,true} ,{true,false,true,false} ,{true,false,true,false} ,{true,false,true,false}   ,{true,true,false,false}  ,{false,true,false,true}},
                {{false,false,true,true}  ,{true,false,true,false} ,{true,true,true,false}  ,{true,false,true,true}    ,{false,true,true,false}  ,{false,true,true,true}}
                };

        boolean[][][] maze5 =
                {
                {{true,false,true,true}   ,{true,false,true,false} ,{true,false,true,false} ,{true,false,true,false}   ,{true,false,false,false} ,{true,true,false,false}},
                {{true,false,false,true}  ,{true,false,true,false} ,{true,false,true,false} ,{true,false,false,false}  ,{false,true,true,false}  ,{false,false,true,true}},
                {{false,false,false,true} ,{true,true,false,false} ,{true,false,true,true}  ,{false,true,true,false}   ,{true,false,false,true}  ,{true,false,false,false}},
                {{false,true,false,true}  ,{false,false,true,true} ,{true,false,true,false} ,{true,true,false,false}   ,{false,true,true,true}   ,{false,true,false,true}},
                {{false,true,false,true}  ,{true,false,false,true} ,{true,false,true,false} ,{false,false,true,false}  ,{true,true,true,false}   ,{false,true,false,true}},
                {{false,true,true,true}   ,{false,false,true,true} ,{true,false,true,false} ,{true,false,true,false}   ,{true,false,true,false}  ,{false,true,true,false}}
                };

        boolean[][][] maze6 =
                {
                {{true,true,false,true}   ,{true,false,false,true} ,{true,true,false,false} ,{true,false,true,true}    ,{true,false,false,false} ,{true,true,false,false}},
                {{false,true,false,true}  ,{false,true,false,true} ,{false,true,false,true} ,{true,false,false,true}   ,{false,true,true,false}  ,{false,true,false,true}},
                {{false,false,false,true} ,{false,true,true,false} ,{false,true,true,true}  ,{false,true,false,true}   ,{true,false,false,true}  ,{false,true,true,false}},
                {{false,false,true,true}  ,{true,true,false,false} ,{true,false,false,true} ,{false,true,false,false}  ,{false,true,false,true}  ,{true,true,false,true}},
                {{true,false,false,true}  ,{false,true,true,false} ,{false,true,true,true}  ,{false,true,false,true}   ,{false,false,true,true}  ,{false,true,false,false}},
                {{false,false,true,true}  ,{true,false,true,false} ,{true,false,true,false} ,{false,true,true,false}   ,{true,false,true,true}   ,{false,true,true,false}}
                };

        boolean[][][] maze7 =
                {
                {{true,false,false,true}  ,{true,false,true,false} ,{true,false,true,false} ,{true,true,false,false}   ,{true,false,false,true}  ,{true,true,false,false}},
                {{false,true,false,true}  ,{true,false,false,true} ,{true,true,true,false}  ,{false,false,true,true}   ,{false,true,true,false}  ,{false,true,false,true}},
                {{false,false,true,true}  ,{false,true,true,false} ,{true,false,false,true} ,{true,true,true,false}    ,{true,false,false,true}  ,{false,true,true,false}},
                {{true,false,false,true}  ,{true,true,false,false} ,{false,false,false,true},{true,false,true,false}   ,{false,true,true,false}  ,{true,true,false,true}},
                {{false,true,false,true}  ,{false,true,true,true}  ,{false,false,true,true} ,{true,false,true,false}   ,{true,true,false,false}  ,{false,true,false,true}},
                {{false,false,true,true}  ,{true,false,true,false} ,{true,false,true,false} ,{true,false,true,false}   ,{false,false,true,false} ,{false,true,true,false}}
                };

        boolean[][][] maze8 =
                {
                {{true,true,false,true}   ,{true,false,false,true} ,{true,false,true,false} ,{true,true,false,false}   ,{true,false,false,true}  ,{true,true,false,false}},
                {{false,false,false,true} ,{false,false,true,false},{true,true,true,false}  ,{false,false,true,true}   ,{false,true,true,false}  ,{false,true,false,true}},
                {{false,true,false,true}  ,{true,false,false,true} ,{true,false,true,false} ,{true,false,true,false}   ,{true,true,false,false}  ,{false,true,false,true}},
                {{false,true,false,true}  ,{false,false,true,true} ,{true,true,false,false} ,{true,false,true,true}    ,{false,false,true,false} ,{false,true,true,false}},
                {{false,true,false,true}  ,{true,true,false,true}  ,{false,false,true,true} ,{true,false,true,false}   ,{true,false,true,false}  ,{true,true,true,false}},
                {{false,false,true,true}  ,{false,false,true,false},{true,false,true,false} ,{true,false,true,false}   ,{true,false,true,false}  ,{true,true,true,false}}
                };

        boolean[][][] maze9 =
                {
                {{true,true,false,true}   ,{true,false,false,true} ,{true,false,true,false} ,{true,false,true,false}   ,{true,false,false,false} ,{true,true,false,false}},
                {{false,true,false,true}  ,{false,true,false,true} ,{true,false,false,true} ,{true,true,true,false}    ,{false,true,false,true}  ,{false,true,false,true}},
                {{false,false,false,true} ,{false,false,true,false},{false,true,true,false} ,{true,false,false,true}   ,{false,true,true,false}  ,{false,true,false,true}},
                {{false,true,false,true}  ,{true,true,false,true}  ,{true,false,false,true} ,{false,true,true,false}   ,{true,false,true,true}   ,{false,true,false,false}},
                {{false,true,false,true}  ,{false,true,false,true} ,{false,true,false,true} ,{true,false,false,true}   ,{true,true,false,false}  ,{false,true,true,true}},
                {{false,false,true,true}  ,{false,true,true,false} ,{false,false,true,true} ,{false,true,true,false}   ,{false,false,true,true}  ,{true,true,true,false}}
                };

        /*******************************************************
         * DECLARO E INICIALIZO LOS LABERINTOS
         ******************************************************/
        Cell[][] cell = new Cell[cols][rows];



        for(int u = 0; u<mazes.length; u++)
        {
            for(int i = 0; i < cols ; i++)
            {
                for(int j = 0; j < rows ; j++)
                {
                    cell[i][j] = new Cell( i , j);

                    switch(u)
                    {
                        case 0:
                            for(int k = 0; k < cell[i][j].walls.length;k++)
                            {
                                cell[i][j].walls[k] = maze1[j][i][k];
                            }
                            break;
                        case 1:
                            for(int k = 0; k < cell[i][j].walls.length;k++)
                            {
                                cell[i][j].walls[k] = maze2[j][i][k];
                            }
                            break;
                        case 2:
                            for(int k = 0; k < cell[i][j].walls.length;k++)
                            {
                                cell[i][j].walls[k] = maze3[j][i][k];
                            }
                            break;
                        case 3:
                            for(int k = 0; k < cell[i][j].walls.length;k++)
                            {
                                cell[i][j].walls[k] = maze4[j][i][k];
                            }
                            break;
                        case 4:
                            for(int k = 0; k < cell[i][j].walls.length;k++)
                            {
                                cell[i][j].walls[k] = maze5[j][i][k];
                            }
                            break;
                        case 5:
                            for(int k = 0; k < cell[i][j].walls.length;k++)
                            {
                                cell[i][j].walls[k] = maze6[j][i][k];
                            }
                            break;
                        case 6:
                            for(int k = 0; k < cell[i][j].walls.length;k++)
                            {
                                cell[i][j].walls[k] = maze7[j][i][k];
                            }
                            break;
                        case 7:
                            for(int k = 0; k < cell[i][j].walls.length;k++)
                            {
                                cell[i][j].walls[k] = maze8[j][i][k];
                            }
                            break;
                        case 8:
                            for(int k = 0; k < cell[i][j].walls.length;k++)
                            {
                                cell[i][j].walls[k] = maze9[j][i][k];
                            }
                            break;
                    }
                }
            }
            try
            {
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(mazes[u]));
                os.writeObject(cell);
                os.close();
            }
            catch(FileNotFoundException e)
            {
                System.out.println("excepcion 1");
                e.printStackTrace();
            }
            catch(IOException e)
            {
                System.out.println("excepcion 2");
                e.printStackTrace();
            }
            finally
            {
                System.out.println("ready");
            }
        }

    }
}
