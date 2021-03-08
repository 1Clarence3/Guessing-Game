import java.util.*;
import java.io.*;
public class Node
{
    public String data;
    public Node left;
    public Node right;
    public int index;

    public Node(String name)
    {
        data = name;
        left = null;
        right = null;
    }
    
    public void inorder(Node parent)
    {
        if(parent == null)
        {
            return;
        }             
        inorder(parent.left);
        System.out.println(parent.data);
        inorder(parent.right);
    }

    public void postorder(Node parent)
    {
        if(parent == null)
        {
            return;
        }
        postorder(parent.left);
        postorder(parent.right);
        System.out.println(parent.data);        
    }

    public List<String> readFileAsListOfStrings(String filename) throws Exception
    {
        List<String> records = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null)
        {
            records.add(line);
        }
        reader.close();
        return records;
    }
    
    public Node buildTree(List<String> in, List<String> post, int n) 
    { 
        index = n - 1;
        return buildUtil(in, post, 0, n - 1, index); 
    }
    
    public Node buildUtil(List<String> in, List<String> post, int inStrt, int inEnd, int pIndex) 
    { 
        // Base case 
        if (inStrt > inEnd) 
        {
            return null; 
        }          
        Node node = new Node(post.get(index)); 
        (index)--;  
        // If this node has no children then return 
        if (inStrt == inEnd) 
        {
            return node; 
        }  
        int iIndex = search(in, inStrt, inEnd, node.data);   
        // Using index in Inorder traversal, construct left and right subtress 
        node.right = buildUtil(in, post, iIndex + 1, inEnd, pIndex); 
        node.left = buildUtil(in, post, inStrt, iIndex - 1, pIndex);   
        return node; 
    }
    
    public int search(List<String> arr, int strt, int end, String value) 
    { 
        int i; 
        for (i = strt; i <= end; i++) 
        { 
            if (arr.get(i).equals(value)) 
            {
                break; 
            }
        } 
        return i; 
    }
}
