
public class Istochnik extends Subject {
    int i;
    int tochn;
    int type;
    double[] diag;
    Istochnik (String img, int types, int tochns, double xs, double ys) {
        super(img, xs, ys);
        type = types;
        tochn = tochns;
        diag = new double[tochn];
    }
    Istochnik () {
    }
    double[] getE(double alpha, double k, double x1, double y1) {
        System.out.println("Источник под входящим углом "+alpha+" выдал "+(10*k)+" энергии");
        return new double[] {10*k,x1,y1,x,y,(Math.sqrt((x1-x)*(x1-x)+(y1-y)*(y1-y)))};
    }
}