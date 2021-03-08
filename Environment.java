import java.awt.Font;
import java.util.*;
public class Environment
{
    public void setTree()
    {
        StdDraw.setCanvasSize(800,800);
        StdDraw.setXscale(0,100);
        StdDraw.setYscale(0,100);
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setFont(new Font("Arial",Font.BOLD,26));         
        StdDraw.picture(50,50,"test.gif");
        StdDraw.ellipse(30,75,20,10);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledRectangle(38,66,2,1);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(40,66.3,49,52);
        StdDraw.line(36,65.5,49,52);
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);            
        StdDraw.filledRectangle(50,30,15,5);
        StdDraw.filledRectangle(50,20,15,5);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.02);
        StdDraw.rectangle(50,30,15,5);
        StdDraw.rectangle(50,20,15,5);
        StdDraw.text(50,30,"Yes");
        StdDraw.text(50,20,"No");        
        StdDraw.show();
    }
    
    public void viewHistory(ArrayList moves, ArrayList accuracy)
    {
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setFont(new Font("Arial",Font.BOLD,30)); 
        StdDraw.text(50,90,"History:");
        StdDraw.setFont(new Font("Arial",Font.BOLD,22)); 
        StdDraw.text(30,80,"David's Accuracy:");
        StdDraw.text(70,80,"Number of Moves:");
        for(int i = 1; i < moves.size()+1; i++)
        {
            StdDraw.text(70,80-(i*5),moves.get(i-1)+"");
            StdDraw.text(30,80-(i*5),accuracy.get(i-1)+"");
        }
        StdDraw.show();
    }
}
