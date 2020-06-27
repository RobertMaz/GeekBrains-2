public class Robot implements JumpAndGo {

    double limitForRun;
    double limitForJump;
    String name;

    public Robot(String name, Age age){
        this.name = name;
        setToLimit(age);
    }

    public Robot(String name){
        this.name = name;
        setToLimit(Age.DEFAULT);
    }

    public String getName() {
        return name;
    }

    public void setToLimit(Age age) {
        switch (age){
            case YOUNG:
                limitForJump = 2;
                limitForRun = 500;
                break;
            case OLD:
                limitForJump = 1;
                limitForRun = 100;
                break;
            default:
                limitForJump = 1.5;
                limitForRun = 30;
        }
    }

    public boolean run(Treadmill treadmill) {
        return treadmill.getSize() <= limitForRun;
    }

    public boolean jump(Wall wall) {
        return wall.getSize() <= limitForJump;
    }
}
