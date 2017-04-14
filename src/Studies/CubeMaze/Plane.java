package Studies.CubeMaze;

/**
 * Created by CAD5124 on 3/7/2017.
 */
public class Plane
{
    private Node[][] dimensions;
    private int myId;
    private int northId;
    private int southId;
    private int eastId;
    private int westId;

    Plane(int myId, int d, int northId, int southId, int eastId, int westId)
    {
        this.myId = myId;
        this.dimensions = new Node[d][d];
        this.northId = northId;
        this.southId = southId;
        this.eastId = eastId;
        this.westId = westId;
    }

    public void display()
    {
        for(int i = 0; i < dimensions.length; i++)
        {
            for(int j = 0; j < dimensions.length; j++)
            {
                System.out.print(myId);
            }
            System.out.println();
        }
    }
}
