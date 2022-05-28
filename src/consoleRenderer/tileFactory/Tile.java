package consoleRenderer.tileFactory;

import consoleRenderer.Position;

public abstract class Tile {
    protected char texture;
    protected Position position;

    public Tile(char texture, Position position) {
        this.texture = texture;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return texture + "";
    }
}
