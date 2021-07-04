class Point {
    public double x, y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    //Calculating the distance between two pointers.
    public double dist(Point p) {
        return Math.sqrt((this.x-p.x)*(this.x-p.x)+(this.y-p.y)*(this.y-p.y));
    }

    //Returns a copy of a recently added point.
    public Point copy() {
        return new Point(this.x, this.y);
    }
    @Override
    public String toString() {
        return "point: "+x+","+y;
    }

}
