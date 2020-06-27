public interface JumpAndGo  {

    boolean run(Treadmill treadmill);
    boolean jump(Wall wall);
    void setToLimit(Age age);

    String getName();


}
