public class Wall implements Obstacle{

    double height;

    Wall(double height){
        this.height = height;
    }

    public double getSize() {
        return height;
    }
}
