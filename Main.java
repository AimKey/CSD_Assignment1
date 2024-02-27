
class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }

}

class Planet {
    String name;
    double equatorialDiameter, mass, semimajorAxis, orbitalPeriod;

    public Planet(String name, double equatorialDiameter, double mass, double semimajorAxis, double orbitalPeriod) {
        this.name = name;
        this.equatorialDiameter = equatorialDiameter;
        this.mass = mass;
        this.semimajorAxis = semimajorAxis;
        this.orbitalPeriod = orbitalPeriod;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", equatorialDiameter: " + equatorialDiameter + ", mass: " + mass
                + ", semimajorAxis: " + semimajorAxis + ", orbitalPeriod: " + orbitalPeriod;
    }

}