public class Human implements JumpAndGo{

    double limitForRun;
    double limitForJump;
    String name;

    public Human(String name, Age age){
        this.name = name;
        setToLimit(age);
    }

    public Human(String name){
        this.name = name;
        setToLimit(Age.DEFAULT);
    }

    public void setToLimit(Age age) {
        switch (age){
            case YOUNG:
                limitForJump = 1.5;
                limitForRun = 500;
                break;
            case OLD:
                limitForJump = 0.5;
                limitForRun = 200;
                break;
            default:
                limitForJump = 1;
                limitForRun = 350;
        }
    }

    public boolean run(Treadmill treadmill) {
        return treadmill.getSize() <= limitForRun;
    }

    public boolean jump(Wall wall) {
        return wall.getSize() <= limitForJump;
    }

    public String getName() {
        return name;
    }
}
