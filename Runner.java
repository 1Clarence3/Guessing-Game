import javax.swing.*;   
import java.io.*;
import java.util.*;
import sun.audio.*;
import java.awt.Font;
public class Runner
{
    public static void main(String [] args) throws IOException {   
        javax.swing.JOptionPane.showMessageDialog(null,"Welcome to the AI Akinator! \nPlease think of a CS related Subject" +
        "\n Here are some Rules: \n 1. Once you have beaten David (reached null), you will tell David what you were thinking and how it was different" +
        "\n 2. The new item gets placed on the right subleaf, the old answer gets placed on the left subleaf" +
        "and \"how it was different\" replaces the original question");
        Double mouseX, mouseY;
        String response = "Yes";
        String playAgain = "Yes";
        String saveFile = "Yes";
        String binaryTree;
        String history;
        List<String> inorder = new ArrayList<String>();
        List<String> postorder = new ArrayList<String>();
        String newItem;
        String howDiff;
        Object[] possibilities = {"Yes","No"};
        JFrame frame = new JFrame(); 
        Node parent = new Node("a course in TAS");
        parent.right = new Node("AP CS");
        parent.left = new Node("Java");   
        Node curr = parent;
        Environment david = new Environment();
        david.setTree();        
        Node load = new Node("");
        ArrayList moves = new ArrayList();   
        ArrayList acc = new ArrayList();
        while(playAgain.equals("Yes"))
        {   
            StdDraw.clear();
            david.setTree();
            StdDraw.setFont(new Font("Arial",Font.BOLD,20));            
            StdDraw.setPenRadius();            
            try            
            {
                inorder = parent.readFileAsListOfStrings("BinaryTreeInorder.txt");
                postorder = parent.readFileAsListOfStrings("BinaryTreePostorder.txt");
            }
            catch(Exception e)
            {
            }
            int n = inorder.size();
            parent = load.buildTree(inorder, postorder, n);                
            curr = parent;     
            int count = 0;
            String correct;
            while(true)
            {                                
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.filledRectangle(30,75,20,10);
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.ellipse(30,75,20,10);
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.filledRectangle(38,66,2,1);
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.line(40,66.3,49,52);
                StdDraw.line(36,65.5,49,52);
                StdDraw.text(30,75,"Is it " + curr.data + " ?");
                StdDraw.show();
                mouseX = StdDraw.mouseX();
                mouseY = StdDraw.mouseY();
                if(StdDraw.mousePressed())
                {
                    count++;
                    if((mouseX > 35 && mouseX < 65) && (mouseY > 25 && mouseY < 35))
                    {
                        StdDraw.pause(500);
                        if(curr.right.right == null)
                        {
                            curr = curr.right;
                            StdDraw.setPenColor(StdDraw.WHITE);
                            StdDraw.filledRectangle(30,75,20,10);
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.ellipse(30,75,20,10);
                            StdDraw.setPenColor(StdDraw.WHITE);
                            StdDraw.filledRectangle(38,66,2,1);
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.line(40,66.3,49,52);
                            StdDraw.line(36,65.5,49,52);
                            StdDraw.text(30,75,"Final Guess: Is it " + curr.data + " ?");                        
                            StdDraw.show();
                            while(true)
                            {
                                mouseX = StdDraw.mouseX();
                                mouseY = StdDraw.mouseY();
                                if(StdDraw.mousePressed())
                                {
                                    count++;
                                    if((mouseX > 35 && mouseX < 65) && (mouseY > 25 && mouseY < 35))
                                    {
                                        StdDraw.pause(500);
                                        StdDraw.setPenColor(StdDraw.WHITE);
                                        StdDraw.filledRectangle(30,75,20,10);
                                        StdDraw.setPenColor(StdDraw.BLACK);
                                        StdDraw.ellipse(30,75,20,10);
                                        StdDraw.setPenColor(StdDraw.WHITE);
                                        StdDraw.filledRectangle(38,66,2,1);
                                        StdDraw.setPenColor(StdDraw.BLACK);
                                        StdDraw.line(40,66.3,49,52);
                                        StdDraw.line(36,65.5,49,52);
                                        StdDraw.text(30,75,"I got it correct!");
                                        StdDraw.show();
                                        correct = "Correct";
                                        playMusic("victory.wav");
                                        break;
                                    }
                                    else if((mouseX > 35 && mouseX < 65) && (mouseY > 15 && mouseY < 25))
                                    {
                                        StdDraw.pause(500);
                                        newItem = JOptionPane.showInputDialog("What were you thinking?");
                                        howDiff = JOptionPane.showInputDialog("How is it different?");
                                        parent.right = new Node(howDiff);
                                        parent.right.left = curr;
                                        parent.right.right = new Node(newItem);
                                        correct = "Incorrect";
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                        else
                        {
                            curr = curr.right;
                        }
                    }
                    else if((mouseX > 35 && mouseX < 65) && (mouseY > 15 && mouseY < 25))
                    { 
                        StdDraw.pause(500);
                        if(curr.left.left == null)
                        {
                            curr = curr.left;
                            StdDraw.setPenColor(StdDraw.WHITE);
                            StdDraw.filledRectangle(30,75,20,10);
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.ellipse(30,75,20,10);
                            StdDraw.setPenColor(StdDraw.WHITE);
                            StdDraw.filledRectangle(38,66,2,1);
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.line(40,66.3,49,52);
                            StdDraw.line(36,65.5,49,52);
                            StdDraw.text(30,75,"Final Guess: Is it " + curr.data + " ?");                        
                            StdDraw.show();
                            while(true)
                            {
                                mouseX = StdDraw.mouseX();
                                mouseY = StdDraw.mouseY();
                                if(StdDraw.mousePressed())
                                {
                                    count++;
                                    if((mouseX > 35 && mouseX < 65) && (mouseY > 25 && mouseY < 35))
                                    {
                                        StdDraw.pause(500);
                                        StdDraw.setPenColor(StdDraw.WHITE);
                                        StdDraw.filledRectangle(30,75,20,10);
                                        StdDraw.setPenColor(StdDraw.BLACK);
                                        StdDraw.ellipse(30,75,20,10);
                                        StdDraw.setPenColor(StdDraw.WHITE);
                                        StdDraw.filledRectangle(38,66,2,1);
                                        StdDraw.setPenColor(StdDraw.BLACK);
                                        StdDraw.line(40,66.3,49,52);
                                        StdDraw.line(36,65.5,49,52);
                                        StdDraw.text(30,75,"I got it correct!");
                                        StdDraw.show();
                                        correct = "Correct";
                                        playMusic("victory.wav");                                        
                                        break;
                                    }
                                    else if((mouseX > 35 && mouseX < 65) && (mouseY > 15 && mouseY < 25))
                                    {
                                        StdDraw.pause(500);
                                        newItem = JOptionPane.showInputDialog("What were you thinking?");
                                        howDiff = JOptionPane.showInputDialog("How is it different?");
                                        parent.left = new Node(howDiff);
                                        parent.left.left = curr;
                                        parent.left.right = new Node(newItem);
                                        correct = "Incorrect";
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                        else
                        {
                            curr = curr.left;
                        }
                    }                    
                }
            }
            saveFile = (String)JOptionPane.showInputDialog(frame,"Would you like to save this past binary tree?","UserInput",JOptionPane.PLAIN_MESSAGE,null,possibilities,"Yes");
            if(saveFile.equals("Yes"))
            {
                File fileIn = new File("BinaryTreeInorder.txt");
                PrintStream printStreamIn = new PrintStream(new FileOutputStream(fileIn));
                System.setOut(printStreamIn);
                load.inorder(parent);
                File filePost = new File("BinaryTreePostorder.txt");
                PrintStream printStreamPost = new PrintStream(new FileOutputStream(filePost));
                System.setOut(printStreamPost);
                load.postorder(parent);
                System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
            }
            history = (String)JOptionPane.showInputDialog(frame,"Would you like to view your history?","UserInput",JOptionPane.PLAIN_MESSAGE,null,possibilities,"Yes");
            moves.add(count);
            acc.add(correct);
            if(history.equals("Yes"))
            {
                david.viewHistory(moves,acc);
            }            
            playAgain = (String)JOptionPane.showInputDialog(frame,"Would you like to play again? \n Note: The binary tree updates itself every time you play","UserInput",JOptionPane.PLAIN_MESSAGE,null,possibilities,"Yes");
        }
    }    
    
    public static void playMusic(String filePath)
    {        
        InputStream music;
        try
        {
            music = new FileInputStream(new File(filePath));
            AudioStream audio = new AudioStream(music);
            AudioPlayer.player.start(audio);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Let's Begin!");
        }        
    }
}
