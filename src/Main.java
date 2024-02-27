import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Heap planets = new Heap(8);
        planets.insert(new Planet("Mercury", 0.383, 0.06, 0.39, 0.24));
        planets.insert(new Planet("Venus", 0.949, 0.81, 0.72, 0.62));
        planets.insert(new Planet("Earth", 1.000, 1.00, 1.00, 1.00));
        planets.insert(new Planet("Mars", 0.532, 0.11, 1.52, 1.88));
        planets.insert(new Planet("Jupiter", 11.209, 317.83, 5.20, 11.86));
        planets.insert(new Planet("Saturn", 9.449, 95.16, 9.54, 29.45));
        planets.insert(new Planet("Uranus", 4.007, 14.54, 19.19, 84.02));
        planets.insert(new Planet("Neptune", 3.883, 17.15, 30.07, 164.79));
        planets.traverse();
        System.out.println(Arrays.toString(planets.getSortedArray()));
        
    }

}

class Heap {
    private Planet[] planets;
    private int size = 0;

    public Heap(int n) {
        planets = new Planet[n];
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

    public void traverse() {
    System.out.println("size: " + size);
    for (int i = 0; i < planets.length / 2; i++) {
    System.out.printf("Parrent:%10s%s\n", " ", planets[i]);
    if (leftChild(i) < size)
    System.out.printf("Left Child:%7s%s\n", " ", planets[leftChild(i)]);
    if (rightChild(i) < size)
    System.out.printf("Right child:%6s%s\n", " ", planets[rightChild(i)]);
    }
    }

    public boolean isLeaf(int pos) {
        // Try with size >= 2
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    public void heapify() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    public void heapSort() {
        heapify();
    
        for (int i = size - 1; i > 0; i--) {
            swap(0, i);
            size--;
            heapifyDown(0);
        }
    }
    
    public void heapifyDown(int pos) {
        if (isLeaf(pos)) {
            return;
        }
        
        int left = leftChild(pos);
        int right = rightChild(pos);
        int largest = pos;
    
        if (left < size && planets[left].compareTo(planets[largest]) > 0) {
            largest = left;
        }
    
        if (right < size && planets[right].compareTo(planets[largest]) > 0) {
            largest = right;
        }
    
        if (largest != pos) {
            swap(pos, largest);
            heapifyDown(largest);
        }
    }

    public Planet[] getSortedArray() {
        Planet[] sortedPlanets = new Planet[planets.length];
        int index = 0;
        while (size > 0) {
            sortedPlanets[index++] = remove();
        }
        return sortedPlanets;
    }

    public Planet remove(){
        if (size == 0) {
            return null;
        }

        Planet removedPlanet = planets[0];
        planets[0] = planets[--size];
        heapifyDown(0);
        return removedPlanet;
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
    // TODO: Use this instead
    // @Override
    // public String toString() {
    // return "Name: " + name + ", equatorialDiameter: " + equatorialDiameter + ",
    // mass: " + mass
    // + ", semimajorAxis: " + semimajorAxis + ", orbitalPeriod: " + orbitalPeriod;
    // }

    @Override
    public int compareTo(Planet o) {
        return (int) Math.ceil(this.mass - o.mass);
    }

    @Override
    public String toString() {
        return "Planet name: " + name + ", mass: " + mass;
    }

}