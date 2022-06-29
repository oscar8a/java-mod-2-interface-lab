import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        boolean loopFlag = true;
        Scanner scanner = new Scanner(System.in);

        while (loopFlag) {
            System.out.println("*** This is Bird Escape Game");
            System.out.println("==> Select a type of Bird:\n    1-Pigeon\n    2-Puffin");

            try {
                int type = scanner.nextInt();
                CanFly bird = createBird(type);

                System.out.println("==> How fast can the Monster fly? (use mph & whole numbers)");
                int monsterSpeed = scanner.nextInt();
                int birdSpeed = bird.fly();
                if (birdSpeed > monsterSpeed) {
                    System.out.println("==> Bird Escaped!");
                } else {
                    System.out.println("==> Bird became lunch... couldn't escape");
                }

                System.out.println("==> Quit? type '0' to exit game");
                int answ = scanner.nextInt();
                if (answ == 0) {
                    loopFlag = false;
                }
            } catch (Exception e) {
                System.out.println("ENTER A VALID NUMBER! game will restart...");
                scanner.nextLine();
                e.printStackTrace();
            }
        }
        scanner.close();
    }

    public static CanFly createBird(int selection) {
        if (selection == 1) {
            return new Pigeon();
        } else if (selection == 2) {
            return new Puffin();
        } else {
            throw new InputMismatchException("Enter option 1 or 2");
        }
    }
}

interface CanFly {
    int fly();
}

class Pigeon implements CanFly {
    public int fly() {
        System.out.println("==> I'm a pigeon and I can fly up to 90 miles an hour!");
        return 90;
    }
}

class Puffin implements CanFly {
    public int fly() {
        System.out.println("==> I'm a puffin and I can fly up to 50 miles an hour!");
        return 50;
    }
}