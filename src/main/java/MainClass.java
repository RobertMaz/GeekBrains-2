public class MainClass {
    public static void main(String[] args) {

        JumpAndGo[] jumpAndGos = new JumpAndGo[9];
        jumpAndGos[0] = new Human("Human1",Age.YOUNG);
        jumpAndGos[1] = new Human("Human2",Age.OLD);
        jumpAndGos[2] = new Human("Human3",Age.DEFAULT);
        jumpAndGos[3] = new Cat("Cat1", Age.YOUNG);
        jumpAndGos[4] = new Cat("Cat2", Age.OLD);
        jumpAndGos[5] = new Cat("Cat3", Age.DEFAULT);
        jumpAndGos[6] = new Robot("Robot1", Age.YOUNG);
        jumpAndGos[7] = new Robot("Robot2", Age.OLD);
        jumpAndGos[8] = new Robot("Robot3", Age.DEFAULT);

        Obstacle[] obstacles = new Obstacle[8];
        obstacles[0] = new Wall(0.5);
        obstacles[1]= new Treadmill(20);
        obstacles[2] = new Wall(1);
        obstacles[3]= new Treadmill(50);
        obstacles[4] = new Wall(1.5);
        obstacles[5]= new Treadmill(100);
        obstacles[6] = new Wall(2);
        obstacles[7]= new Treadmill(500);

        /*Тут проходим через препятствия*/
        for (int i = 0; i < obstacles.length; i++) {
            System.out.println("\nLevel " + ((i / 3) + 1));

            /*Тут пробегаемся по каждому персонажу*/
            for (int j = 0; j < jumpAndGos.length; j++) {

                /*Если персонаж выбывает из гонок, тогда его делаем null, и здесь проверяем, есть данный персонаж или нет*/
                if(jumpAndGos[j] != null) {

                    /*Если наше препятсвие стена*/
                    if (obstacles[i] instanceof Wall) {
                        if (jumpAndGos[j].jump((Wall) obstacles[i])) {
                            System.out.println(jumpAndGos[j].getName() + " прыгнул на " + obstacles[i].getSize());
                        } else {
                            System.out.println(jumpAndGos[j].getName() + " выбывает из соревнований.");
                            jumpAndGos[j] = null;
                        }

                        /*Если наше препятсвие беговая дорожка*/
                    } else if (obstacles[i] instanceof Treadmill) {
                        if (jumpAndGos[j].run((Treadmill) obstacles[i])) {
                            System.out.println(jumpAndGos[j].getName() + " пробежал " + obstacles[i].getSize() + " метров.");
                        } else {
                            System.out.println(jumpAndGos[j].getName() + " выбывает из соревнований.");
                            jumpAndGos[j] = null;
                        }
                    }
                }
            }
        }
    }
}
