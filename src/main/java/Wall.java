public class Wall extends Subject {
    Wall (double x,double y,double z, double l, double w, double h) {
        super("img/wall.png", 1, 0, 1, x,  y,  z,  l,  w,  h);
        k_otr = 0.7;
        k_pogl = 0.3;
    }
}
