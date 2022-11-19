/**
 *  A class that will actually run your simulation.
 */
public class NBody {

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double r = readRadius(filename);
        Planet[] p = readPlanets(filename);

        StdDraw.setXscale(-r, r);
        StdDraw.setYscale(-r, r);
        StdDraw.enableDoubleBuffering();

        double now = 0;

        while (now < T) {
            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (int i = 0; i < p.length; i++) {
                double fX = p[i].calcNetForceExertedByX(p);
                double fY = p[i].calcNetForceExertedByY(p);
                p[i].update(dt, fX, fY);
                p[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            now += dt;
        }

        StdOut.printf("%d\n", p.length);
        StdOut.printf("%.2e\n", r);
        for (int i = 0; i < p.length; i += 1) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          p[i].xxPos, p[i].yyPos, p[i].xxVel, p[i].yyVel,
                          p[i].mass, p[i].imgFileName);
        }

    }

    

    /**
     *  Return radius of the universe.
     */
    public static double readRadius(String file) {
        In in = new In(file);

        int number = in.readInt();
        double radius = in.readDouble();

        return radius;
    }

    /**
     *  Return Planets of universe.
     */
    public static Planet[] readPlanets(String file) {
        In in = new In(file);

        int number = in.readInt();
        double radius = in.readDouble();

        Planet[] ret = new Planet[number];

        for (int i = 0; i < number; i += 1) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            Planet p = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
            ret[i] = p;
        }

        return ret;
    }
    
}