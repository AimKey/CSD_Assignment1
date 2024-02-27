
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

    public boolean isLeaf(int pos) {
        // Try with size >= 2
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    public void swap(int first, int second) {
        Planet tmp;
        tmp = planets[first];
        planets[first] = planets[second];
        planets[second] = tmp;
    }

    public void insert(Planet planet) {
        planets[size] = planet;
        // Traverse up and fix violated property
        int current = size;
        while (planets[current].compareTo(planets[parent(current)]) > 0) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    // public void traverse() {
    // System.out.println("size: " + size);
    // for (int i = 0; i < planets.length / 2; i++) {
    // System.out.printf("Parrent:%10s%s\n", " ", planets[i]);
    // if (leftChild(i) < size)
    // System.out.printf("Left Child:%7s%s\n", " ", planets[leftChild(i)]);
    // if (rightChild(i) < size)
    // System.out.printf("Right child:%6s%s\n", " ", planets[rightChild(i)]);
    // }
    // }
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