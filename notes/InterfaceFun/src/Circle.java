public class Circle extends Object implements Comparable<Circle>, Shape {
    // can have one super class, can have multiple interfaces we implement
    // <T> parametrized type (AKA generics)
    private Point center;
    private double radius;

    // DVC
    public Circle() {
        center = new Point();
        radius = 1.0;
    }

    // EVC
    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    // EVC
    public Circle(int x, int y, double radius) {
        this.center = new Point(x, y);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }

    @Override
    public int compareTo(Circle o) {
        // compare circles by the size of their radius
        // can write this shorter...
        if (this.radius < o.radius) {
            return -1;
        }
        if (this.radius > o.radius) {
            return 1;
        }
        return 0;

    }

    @Override
    public double computePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double computeArea() {
        return Math.PI * Math.pow(radius, 2.0);
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // NESTED CLASSES
    // a class defined inside another class
    // outer class: these are not nested, "normal" classes we have been working with
    // outer classes can be public or package-private

    // 4 types of nested classes
    // 1. static nested class (we will make Point a static nested class of Circle)
    // 2. non-static nested class (AKA inner class)
    // 3. local inner class (non-static nested class defined inside a method)
    // 4. anonymous inner class (local inner class without a name)

    // 1. static nested class
    public static class Point {
        private int x;
        private int y;


        // DVC
        public Point() {
            this.x = 0;
            this.y = 0;
        }

        // EVC
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }



        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

}