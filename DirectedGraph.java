import java.util.*;
import java.io.*;

public class DirectedGraph {

   Hashtable<Node, ArrayList<Node>> adjList = new Hashtable<Node, ArrayList<Node>>();
   ArrayList<Node> nodes = new ArrayList<>();
   LinkedList<Node> topoSorted;
   HashMap<String,String> sm = new HashMap<String, String>();
   Stack<String> stk = new Stack<String>();

public DirectedGraph() {}

   //utilities
   //adding util.
   public void add(Node node) {
     if (adjList.contains(node)) {
         return;
        } else {
         adjList.put(node, new ArrayList<Node>());
         nodes.add(node);
         }
      }
   //neighbor add **to**

public void addNeighbor(Node x, ArrayList<Node> list) {
      for (Node y: list) {
         addNeighbor(x, y);
         }
   }
//neighbor add ** && fro' **
public void addNeighbor(Node x, Node y){
      if  (!adjList.containsKey(x)) {
           add(x);
      }
      if  (!adjList.containsKey(y)) {
           add(y);
      }
      //if x and y exist for addNeighbor add y to x in adjList (adjacent)
           adjList.get(x).add(y);
      //add degree of edge weight
      y.inDegree++;
      //of inNodes add the degree weight to x from y (weight of x)
      y.inNodes.add(x);
   }
//delete utility
public void remove (Node node) {
      for (Node n: nodes) {
      for (Node m: adjList.get(n)) {
         if (m.equals(node)) removeNeighbor(n, m);
         }
      }
         //recursively remove each node
      adjList.remove(node);
      nodes.remove(node);
      }


public void removeNeighbor(Node x, Node y) {
      adjList.get(x).remove(y);
      y.inDegree--;
      y.inNodes.remove(x);
      }
      // reset nodes to not visited boolean
      public void resetVisited() {
      for (Node node: nodes) {
           node.visited = false;
          }
      }
//if item has an edge
public boolean hasEdge(Node x, Node y) {
         return adjList.get(x).contains(y) ? true : false;
      }

//topological sort Directed Acyclic Graph (Graph)
public void topologicalSort() throws Exception {
      
      topoSorted = new LinkedList<Node>();
      HashSet<Node> visited = new HashSet<Node>();
      for (Node n : nodes) {
      if (!visited.contains(n)) visit(n, visited);
      }
      
      }
//create logic for visited:unvisited nodes from a HashSet
public void visit(Node node, HashSet<Node> set)throws Exception {
      if (node.visited) {
            throw new Exception("Graph is not acyclic");
      }else {
         node.visited = true;
         for (Node o: adjList.get(node)) {
         //another comparator n ~ o
            if (!set.contains(o)) visit(o, set);
         }
         set.add(node);
         node.visited = false;
         topoSorted.addFirst(node);
         }
      }

//print graph toString
public void printGraph() {
   for (Node node : nodes) {
        System.out.print("from: " + node.value + " | to: ");
        for (Node o: adjList.get(node)) {
        System.out.print(o.value + " ");
        }
        System.out.println();
   }
}


//create graph
public void instantiateGraph(String[] array) {
// logic to parse string array into pairs and to define new items..
      
   HashMap<String,String> sm = new HashMap<String, String>();
   for(String item : array)
      {
          String[] pairs = item.split(": ");
            if(pairs.length == 2) {sm.put(pairs[0],pairs[1]); }
            if(pairs.length < 2){sm.put(pairs[0], null); }
      }

   int nsize = sm.size();
      Node[] origin = new Node[nsize];
      Node[] originx = new Node[nsize];
   //reset pointers
   int x = 0;
   int y = 0;
   // create set and collection of keys and value of sm
   Set<String> keys = sm.keySet();
   Collection<String> values = sm.values();
      while(x <= nsize - 1) 
      {  
            for (String key : keys){
               origin [x] = new Node(key, sm.get(key));
               x++;}       
               x=0;
          while(x <= nsize - 1){    
               y=0;
          // for every x and y nest node value and next
          while(y <= nsize - 1){
            String vaa = origin [y].value;
            String baa = origin [x].next;
          if(origin [y].value.equals(origin [x].next)) {
          //add weight
               addNeighbor(origin [x], origin [y]);
          //create neighbors via object value + next (x and y)
             }
               y++;
             }
               x++;
             }
    
      }
   //topological sort, empty nodes are in front unless dependency weight exists  
try { topologicalSort(); } 

catch (Exception e) { e.printStackTrace(); }

for (Node node : topoSorted) {
   //Stack<String> stk = new Stack<String>();
   stk.push(node.value);
   }
   while(!stk.isEmpty()){
   System.out.print(stk.pop() + " ");
   }
   // end of instantiate graph
   System.out.println("");
}

}
