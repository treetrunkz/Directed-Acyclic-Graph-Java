import java.util.*;

public class Node {
      String value;
      String next;
      boolean visited = false;
      int inDegree = 0;
      ArrayList<Node> inNodes = new ArrayList<Node>();
      
      public Node (String value, String next) {
         this.value = value;
         this.next = next;
      }
   }
