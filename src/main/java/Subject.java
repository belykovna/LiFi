import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Subject {
    double k_otr, k_pogl, k_prelom;
    double x,y,z;
    double l,w,h;
    Image imgo;
    ImageView imgv;
    Subject (String img, double k_otr1, double k_pogl1, double k_prelom1, double x1, double y1, double z1,
             double l1, double w1, double h1) {
        k_otr = k_otr1;
        k_pogl = k_pogl1;
        k_prelom = k_prelom1;
        x = x1;
        y = y1;
        z = z1;
        l = l1;
        w = w1;
        h = h1;
        imgo = new Image(img);
        imgv = new ImageView(imgo);
    }
    Subject (double k_otr1, double k_pogl1, double k_prelom1) {
        k_otr = k_otr1;
        k_pogl = k_pogl1;
        k_prelom = k_prelom1;
    }
    Subject () {
    }
    Subject (String img, double xs, double ys) {
        imgo = new Image(img);
        imgv = new ImageView(imgo);
        x = xs;
        y = ys;
    }
    double[] getE (double alpha, double k, double x1, double y1) {
        double ck = k*k_otr;
        if (ck<=0.3) return new double[] {0,0,0,0,0,0};
        double sx = x1;
        double sy = y1;
        double cx = x1;
        double cy = y1;
        double s;
        boolean ch = true;
        double[] en ={10};
        double dx = Math.cos((alpha*Math.PI/180));
        double dy = Math.sin((alpha*Math.PI/180));
        while (ch) {
            cx = cx + dx;
            cy = cy - dy;
            for (int j = 0; j< MainGUI.Obstacles.size(); j++) {
                if (cx>= MainGUI.Obstacles.get(j).x && cx<=(MainGUI.Obstacles.get(j).x+ MainGUI.Obstacles.get(j).w) &&
                        cy>= MainGUI.Obstacles.get(j).y && cy<=(MainGUI.Obstacles.get(j).y+ MainGUI.Obstacles.get(j).h)) {
                    ch = false;
                    //System.out.println(getClass()+": Луч под углом "+alpha+" врезался");
                    if (MainGUI.Obstacles.get(j) instanceof Istochnik) {
                        Istochnik ist = (Istochnik) MainGUI.Obstacles.get(j);
                        en = ist.getE(180 - alpha, ck, cx, cy);
                    }
                    else {
                        en = MainGUI.Obstacles.get(j).getE(180 - alpha, ck, cx, cy);
                    }
                    s = Math.sqrt((cy-sy)*(cy-sy)+(cx-sx)*(cx-sx));
                    MainGUI.LeftPanel.addLuch(MainGUI.rootNode, en[1], en[2], en[3], en[4]);
                    return new double[] {en[0],sx,sy,cx,cy,s};
                }
                if (cx>800 || cy>600) {
                    System.out.println(getClass()+": Луч под углом "+alpha+" вышел за границы");

                    System.exit(0);
                }
            }
        }
        return new double[] {-1};
    }
}
