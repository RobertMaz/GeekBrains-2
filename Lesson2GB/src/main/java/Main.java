import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String text = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        //System.out.println(text);
        try {
            String[][] one = refactor(text, 16);
            for (int i = 0; i < one.length; i++) {
                for (int j = 0; j < one.length; j++) {
                    System.out.print(one[i][j] + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Длина переданной строки не соответсвует условию");
        } catch (NotMatrixException e) {
            e.printStackTrace();
        }

    }
        /*1.Есть строка вида: "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; (другими словами матрица 4x4)
        Написать метод, на вход которого подаётся такая строка,
        метод должен преобразовать строку в двумерный массив типа String[][];*/

    public static String[][] refactor(String text, int limit) throws IOException, NotMatrixException {
        String[] charArray = text.split("( \\b|\\n)");
        double size = charArray.length;

        /*3. Ваши методы должны бросить исключения в случаях:
        Если размер матрицы, полученной из строки, не равен 4x4;
        IOException - просто что бы было хотя бы одно checked исключение*/
        if (size != limit) throw new IOException();

        /* Написать собственные классы исключений для каждого из случаев*/
        if (Math.sqrt(size) % 1 != 0) throw new NotMatrixException();

        String[][] readyString = new String[(int) Math.sqrt(size)][(int) Math.sqrt(size)];
        int count = 0;
        for (int i = 0; i < readyString.length; i++) {
            for (int j = 0; j < readyString.length; j++) {
                readyString[i][j] = charArray[count++];

                /*3. Ваши методы должны бросить исключения в случаях:
                Если в одной из ячеек полученной матрицы не число; (например символ или слово)*/
                if (readyString[i][j].matches("\\D")) throw new NumberFormatException();
            }
        }
        return readyString;
    }

    /*2. Преобразовать все элементы массива в числа типа int,
    просуммировать, поделить полученную сумму на 2, и вернуть результат;*/
    public static int result(String[][] text) {
        int sum = 0;
        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < text.length; j++) {
                sum += Integer.parseInt(text[i][j]);
            }
        }
        return sum / 2;
    }
}
