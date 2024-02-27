
class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }

}

class Heap {
    private Planet[] planets;
    private int size = 0;
    private int maxSize = 0;

    // Arr[(i-1)/2] Returns the parent node.
    // Arr[(2*i)+1] Returns the left child node.
    // Arr[(2*i)+2] Returns the right child node.

    public Heap(int n) {
        planets = new Planet[n];
        maxSize = n;
    }

    // Since this is int, which means that the number is already floor-ed
    public int parent(int pos) {
        return (pos - 1) / 2;
    }

    public int leftChild(int pos) {
        return (2 * pos) + 1;
    }

    public int rightChild(int pos) {
        return (2 * pos) + 2;
    }

    public void swap(int first, int second) {
        Planet tmp;
        tmp = planets[first];
        planets[first] = planets[second];
        planets[second] = tmp;
    }

    public void insert(Planet planet) {
        planets[size] = planet;
        // Traverse up and fix
        int current = size;
        while (planets[current].compareTo(planets[parent(current)]) > 0) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    public void heapify() {
        int i, s, f;
        int x;
        for (i = 1; i < planets.length; i++) {
            x = a[i];
            s = i; // s is a son, f=(s-1)/2 is father
            while (s > 0 && x > a[(s - 1) / 2]) {
                a[s] = a[(s - 1) / 2];
                s = (s - 1) / 2;
            }
            ;
            a[s] = x;
        }
    }
}

class Planet implements Comparable<Planet> {
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

    @Override
    public int compareTo(Planet o) {
        return (int) (this.mass - o.mass);
    }

}