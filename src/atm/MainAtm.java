package atm;

import java.util.Map;
import java.util.Scanner;

public class MainAtm {
    public static void main(String[] args) {
        Atm atm = new Atm(10, 10, 10);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму для снятия: ");
        int amount = scanner.nextInt();

        boolean success = atm.withdrawMoney(amount);
        System.out.println("Операция удалась: " + success);

        scanner.close();
    }
}