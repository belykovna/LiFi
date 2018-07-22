package old;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Priemnik {
    int sens, tochn;
    double x;
    double y;
    Image imgo;
    int type;
    ImageView imgv;
    String img = "img/priemnik.png";
    Priemnik (int c, double xs, double ys, int tochns) {
        sens = c;
        x = xs;
        y = ys;
        tochn = tochns;
        Image imgo = new Image(img);
        imgv = new ImageView(imgo);
    }

    double[] getE(double alpha) {
        double sx = x;
        double sy = y;
        double cx = x;
        double cy = y;
        double s;
        boolean ch = true;
        double[] en={10};
        double dx = Math.cos((alpha*Math.PI/180));
        double dy = Math.sin((alpha*Math.PI/180));
        double dalpha = 0;
        while (ch) {
            cx = cx + dx;
            cy = cy - dy;
            for (int j = 0; j< MainGUI.Obstacles.size(); j++) {
               if (cx>= MainGUI.Obstacles.get(j).x && cx<=(MainGUI.Obstacles.get(j).x+ MainGUI.Obstacles.get(j).w) &&
                        cy>= MainGUI.Obstacles.get(j).y && cy<=(MainGUI.Obstacles.get(j).y+ MainGUI.Obstacles.get(j).h)) {
                    ch = false;
                    //System.out.println("old.Priemnik: Луч под углом "+alpha+" врезался в "+old.MainGUI.Obstacles.get(j).getClass());

                   if (MainGUI.Obstacles.get(j) instanceof Istochnik) {
                        Istochnik ist = (Istochnik) MainGUI.Obstacles.get(j);
                        en = ist.getE(180-alpha,1, cx, cy);
                    }
                    else {
                        en = MainGUI.Obstacles.get(j).getE(180-alpha,1, cx, cy);
                    }
                    //System.out.print(alpha+":\t");
                    //for (int u=1;u<en.length;u++) System.out.print(en[u]+" ");
                    //System.out.println();
                    MainGUI.LeftPanel.addLuch(MainGUI.rootNode, en[1], en[2], en[3], en[4]);
                    s = Math.sqrt((cy-sy)*(cy-sy)+(cx-sx)*(cx-sx));
                    //System.out.println(alpha+": "+sx+" "+sy+" "+cx+" "+cy);
                    return new double[] {en[0],sx,sy,cx,cy,s};
                }
                if (cx>800 || cy>600) {
                    System.out.println("old.Priemnik: Луч под углом "+alpha+" вышел за границы");
                    System.exit(0);
                }
            }
        }
        return new double[] {-1};
    }
}