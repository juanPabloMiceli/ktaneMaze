import java.io.Serializable;

public class Cell implements Serializable
{

    int i, j;
    boolean[] walls = {true, true, true, true};
    static int[] currentPosition = new int[2];
    static int[] startPosition = new int[2];
    static int[] finalPosition = new int[2];
    int cost = 99;

    Cell(int i, int j)
    {
        this.i = i;
        this.j = j;
    }
}