
class Main {

    public static void main(String[] args) {
        // Create a max heap to store planets
        Heap maxHeap = new Heap(8); // Assuming 8 planets in the solar system
       
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

    //include heapify up
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

<<<<<<< Updated upstream:Main.java
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
=======
    public boolean isEmpty() {
        return size == 0;
    }

    //convert the Planet[] to heap
    public void heapify() {
        int n = size;
        for (int i = 1; i < n; i++) {
            Planet x = planets[i];
            int s = i;
            while (s > 0 && x.compareTo(planets[parent(s)]) > 0) {
                planets[s] = planets[parent(s)];
                s = parent(s);
            }
            planets[s] = x;
        }
    }

    private void heapifyDown(int pos) {
        int left = leftChild(pos);
        int right = rightChild(pos);
        int largest = pos;
        //checks if the left child(planets[left]) is greater than the value of the node at largest
        if (left < size && planets[left].compareTo(planets[largest]) > 0) {
            largest = left;
        }
        //similarly
        if (right < size && planets[right].compareTo(planets[largest]) > 0) {
            largest = right;
        }
        //if one of the children has a greater value than the node at pos.
        if (largest != pos) {
            swap(pos, largest);
            heapifyDown(largest);
        }
    }

    //get the top root
    public Planet extractMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        Planet max = planets[0];
        planets[0] = planets[--size];
        heapifyDown(0);
        return max;
    }

    public class Planet implements Comparable<Planet> {

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
>>>>>>> Stashed changes:src/Main.java
}
