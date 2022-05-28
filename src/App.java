import consoleRenderer.TileMap;

public class App {
    public static void main(String[] args) {
        TileMap map = new TileMap(30, 30);
        map.fillWithNormal();
        map.print();
    }
}
