import java.io.*;

public class LeerObjeto
{
    static int x=3,y=4;

    public static void main(String[] args)
    {

        String sketch = "D:\\codigos\\codigosJava\\mazeObject\\src\\maze4.bin";
        /*Cell b = new Cell(10,10,55);
        //String sketch = sketchPath()+"\\data.bin";
        //print("\n\n"+sketch+"\n\n");


        try
        {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(sketch));
            os.writeObject(b);
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
        }*/
        try
        {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(sketch));
            Cell[][] c = (Cell[][]) is.readObject();
            System.out.println("wall 0: "+ c[x][y].walls[0]+ "\twall 1: "+ c[x][y].walls[1]+ "\twall 2: "+ c[x][y].walls[2]+ "\twall 3: "+ c[x][y].walls[3]);
            is.close();
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
    }
}
