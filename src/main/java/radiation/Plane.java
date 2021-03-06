package radiation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Plane<T> {

    private HashMap<String, Coordinate<T>> coordinates = new HashMap<>();

    private int sizeX;
    private int sezeY;

    public Plane(int sizeX, int sezeY) {
        this.sizeX = sizeX;
        this.sezeY = sezeY;
    }

    //Запись в плоскость источника/приемника
    public void setObject(int x, int y, T object) {
        coordinates.put("" + x + "_" + y, new Coordinate(x, y, object));
    }

    //Получение из массива источника/приемника
    public T getObject (int x, int y){
        return coordinates.get("" + x + "_" + y).getObject();
    }

    //получение множества координат
    public Set<String> getCoordinates() {
        return coordinates.keySet();
    }
}