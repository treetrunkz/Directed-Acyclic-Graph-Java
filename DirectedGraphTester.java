

public class DirectedGraphTester {

   public static void TestClient() {
      DirectedGraph h = new DirectedGraph();
      String[] array = new String[] {"KittenService: ","Leetmeme: Cyberportal","Cyberportal: Ice","CamelCaser: KittenService","Fraudstream: Leetmeme","Ice: "};
      h.instantiateGraph(array);
   }
   public static void TestClient2() {
      DirectedGraph j = new DirectedGraph();
      String[] array = new String[] {"KittenService: ","Leetmeme: Cyberportal","Cyberportal: Ice","CamelCaser: KittenService","Fraudstream: Leetmeme","Ice: "};
      j.instantiateGraph(array);
      }
   public static void TestClient3() {
      DirectedGraph i = new DirectedGraph();
      String[] array = new String[] {"KittenService: ","Leetmeme: Cyberportal","Cyberportal: Leetmeme","CamelCaser: KittenService","Fraudstream: Leetmeme","Ice: "};
      i.instantiateGraph(array);
      }
   public static void TestClient4() {
      DirectedGraph k = new DirectedGraph();
      String[] array = new String[] {"Crystalpens: ", "Chickencutie: Applejuice", "KittenService: ChickenCutie", "Ice: ","AppleJuice"};
      k.instantiateGraph(array);
      }
}