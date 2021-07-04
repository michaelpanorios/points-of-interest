class Record {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int id;
    public Point location;
    public double score;

    public Record(int id, Point location, double score) {
        this.id = id;
        this.location = location;
        this.score = score;
    }

    //Returns a copy of a recently added record.
    public Record copy() {
        return new Record(
                this.id,
                this.location.copy(),
                this.score
        );
    }

    @Override
    public String toString() {
        return "Rank[" +
                "Identity Number: " + id +
                ", Location at " + location +
                ", Score: " + score +
                ']';
    }
}
