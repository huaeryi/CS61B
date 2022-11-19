/**
 *  Test the force between two Planets.
 */
public class TestPlanet {

    public static void main(String[] args) {
        printForce();
    }

    /**
     *  Print the force between two Planets.
     */
    private static void printForce() {
        Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Planet p2 = new Planet(4.0, 5.0, 3.0, 4.0, 5.0, "jupiter.gif");

        double f = p1.calcForceExertedBy(p2);
        System.out.println("The force between p1 and p2 is " + f + ".");
    }
}