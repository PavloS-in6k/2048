import com.in6k.game2048.Command;
import com.in6k.game2048.Controller;
import com.in6k.game2048.Field;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Sup, this is 2048 game!\n");


        Field field = new Field();
        Controller controller = new Controller(field);
        String command;
        System.out.print(field.getFieldView());
        while (true) {
            System.out.println("Enter w,a,s,or d for slide : \"s\" for down slide, \"w\" - up slide, \"d\" - right slide, " +
                    "\"a\" - left slide or \"e\" for exit: ");
            command = sc.next();
            if (command.equals("e"))
                break;
            if (command.equals("w")) {
                controller.doSlide(Command.SLIDE_UP);
            }
            if (command.equals("a")) {
                controller.doSlide(Command.SLIDE_LEFT);
            }
            if (command.equals("s")) {
                controller.doSlide(Command.SLIDE_DOWN);
            }
            if (command.equals("d")) {
                controller.doSlide(Command.SLIDE_RIGTH);
            }
            System.out.print(field.getFieldView());
        }
    }
}
