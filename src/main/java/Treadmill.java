public class Treadmill implements Obstacle{

    private double length;

    Treadmill(int length){
        this.length = length;
    }

    public double getSize() {
        return length;
    }
}
