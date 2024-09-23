// FloodFillDemo.java
public class FloodFillDemo {
    public static void main(String[] args) {
        Grid gr = new Grid();
        gr.floodfill(3, 4);
        System.out.println("Flood Fill Result starting at (3,4):");
        System.out.println(gr.toString());
    }
}
