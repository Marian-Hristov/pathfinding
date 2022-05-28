package consoleRenderer;

import consoleRenderer.tileFactory.NormalTile;
import consoleRenderer.tileFactory.Tile;
import consoleRenderer.tileFactory.TileFactory;

import java.util.List;
import java.util.ArrayList;

public class TileMap {
    private final int WIDTH;
    private final int HEIGHT;
    private final TileFactory tileFactory;
    List<List<Tile>> tiles; // 2D array of tiles for the map

    public TileMap (int width, int height){
        this.WIDTH = width;
        this.HEIGHT = height;
        this.tileFactory = new TileFactory();
        // Setting the capacity of each the arrays
        this.tiles = new ArrayList<>(height);
        for(List<Tile> row : this.tiles){
            row = new ArrayList<>(width);
        }
    }

    public void setTile(Tile newTile) {
        int tileX = newTile.getPosition().getX();
        int tileY = newTile.getPosition().getY();
        if(tileX - 1 < 0 || tileX - 1 > this.WIDTH ){
            throw new IndexOutOfBoundsException("Cannot set tile to outside of x values of map");
        }
        if(tileY - 1 < 0 || tileY - 1 > this.HEIGHT){
            throw new IndexOutOfBoundsException("Cannot set tile to outside of y values of map");
        }
        List<Tile> row = this.tiles.get(tileY - 1);
        row.set(tileX - 1, newTile);
    }

    public void fillWithNormal(){
        for(int x = 0; x < this.WIDTH; x++){
            for(int y = 0; y < this.HEIGHT; y++){
                this.tiles.get(x).set(y, this.tileFactory.getTile("normal", new Position(x + 1, y + 1)));
            }
        }
    }

    public void print(){
        System.out.flush();
        String printedString = "";
        String horizontalPipe = "─";
        String verticalPipe = "│";
        String[] corners = {"┌", "┐", "┘", "└"};
        // Add the top row with numbering
        printedString += corners[0] + 1; // Adding top left corner and first step
        int stepCounter = 1;
        for(int i = 2; i < this.WIDTH + 1; i++){
            // Printing steps of 5
            if(i % 5 == 0) {
                printedString += (stepCounter * 5);
                stepCounter++;
            } else {
                printedString += horizontalPipe;
            }
        }
        printedString += corners[1]; // Adding top right corner
        // Printing out rows
        for(int i = 0; i < this.HEIGHT; i++ ){
            printedString += verticalPipe;
            for(int j = 0; j < this.WIDTH; j++){
                printedString += this.tiles.get(i).get(j);
            }
            printedString += verticalPipe;
        }
        // Printing out
        System.out.println(printedString);
    }
}
