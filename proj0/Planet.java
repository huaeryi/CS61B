/**
 *  Planet Class
 */
public class Planet {

    /**
     *  The attribute of Planet.
     */
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    /**
     *  Scientific constant.
     */
    private static double G = 6.67e-11;


    /**
     *  Constructor of Planet.
     */
    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    /**
     *  Calculates the distance between two Planets.
     */
    public double calcDistance(Planet rocinante) {
        double dx = xxPos - rocinante.xxPos;
        double dy = yyPos - rocinante.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }
    
    /**
     *  Return the force to rocinante.
     */
    public double calcForceExertedBy(Planet rocinante) {
        return G * mass * rocinante.mass / 
               (this.calcDistance(rocinante) * this.calcDistance(rocinante));
    }
    
    /**
     *  Return the X, Y component of force.
     */
    public double calcForceExertedByX(Planet rocinante) {
        double dx = rocinante.xxPos - xxPos;
        double r = this.calcDistance(rocinante);
        double F = this.calcForceExertedBy(rocinante);
        return F * dx / r;
    }
    public double calcForceExertedByY(Planet rocinante) {
        double dy = rocinante.yyPos - yyPos;
        double r = this.calcDistance(rocinante);
        double F = this.calcForceExertedBy(rocinante);
        return F * dy / r;
    }

    /**
     *  calculate the net X and net Y force exerted by all planets 
     *  in that array upon the current Planet.
     */
    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double sumX = 0;
        for (int i = 0; i < allPlanets.length; i += 1) {
            if (this.equals(allPlanets[i])) continue;
            sumX += this.calcForceExertedByX(allPlanets[i]);
        }
        return sumX;
    }
    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double sumY = 0;
        for (int i = 0; i < allPlanets.length; i += 1) {
            if (this.equals(allPlanets[i])) continue;
            sumY += this.calcForceExertedByY(allPlanets[i]);
        }
        return sumY;
    }
    
    /**
     *  Update the planet’s position and velocity instance variables.
     */
    public void update(double dt, double fX, double fY) {
        double aX = fX / mass;
        double aY = fY / mass;

        xxVel = xxVel + aX * dt;
        yyVel = yyVel + aY * dt;

        xxPos = xxPos + xxVel * dt;
        yyPos = yyPos + yyVel * dt;
    }

    /**
     *  Draw a Planet.
     */
    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    } 


}