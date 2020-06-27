public class Cat implements JumpAndGo {

    double limitForRun;
    double limitForJump;
    String name;

    public Cat(String name, Age age){
        this.name = name;
        setToLimit(age);
    }

    public Cat(String name){
        this.name = name;
        setToLimit(Age.DEFAULT);
    }

    public String getName() {
        return name;
    }

    public void setToLimit(Age age) {
        switch (age){
            case YOUNG:
                limitForJump = 1;
                limitForRun = 100;
                break;
            case OLD:
                limitForJump = 0.2;
                limitForRun = 50;
                break;
            default:
                limitForJump = 0.5;
                limitForRun = 80;
        }
    }

    public boolean run(Treadmill treadmill) {
        return treadmill.getSize() <= limitForRun;
    }

    public boolean jump(Wall wall) {
        return wall.getSize() <= limitForJump;
    }
}
