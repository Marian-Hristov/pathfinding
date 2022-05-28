package consoleRenderer.tileFactory;

import consoleRenderer.Position;

public class TileFactory {

    public Tile getTile(String type, Position position){
        if(type == null) return null;
        if(type.equalsIgnoreCase("normal")) return new NormalTile(Textures.NORMAL, position);
        if(type.equalsIgnoreCase("normal")) return new NormalTile(Textures.WALL, position);
        return null;
    }
}
