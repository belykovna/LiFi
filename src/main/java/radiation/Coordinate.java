package radiation;

public class Coordinate <T> {

    //координаты источника/приемника
    private int x;
    private int y;

    //источник/приемник
    private T object;

    public Coordinate(int x, int y, T object) {
        this.x = x;
        this.y = y;
        this.object = object;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    //Получение из объекта источника/приемника
    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
