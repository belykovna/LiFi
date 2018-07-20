import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Diod extends Istochnik {
    Diod (String img, int types, double xs, double ys) {
        super(img, types, 360, xs, ys);
        x = xs;
        y = ys;
        w = 10;
        h = 15;
        type = types;
        tochn = 360;
        int j;
        for (i = 0; i<360; i=i+Math.round(360/tochn) ) {
            j = Math.round(i/tochn*360);
            diag[j] = 10;
        }
    }
}