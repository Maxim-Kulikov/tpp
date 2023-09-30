package atm;

public class Atm {
    private int num20;
    private int num50;
    private int num100;

    public Atm(int num20, int num50, int num100) {
        this.num20 = num20;
        this.num50 = num50;
        this.num100 = num100;
    }

    public void depositMoney(int num20, int num50, int num100) {
        this.num20 += num20;
        this.num50 += num50;
        this.num100 += num100;
    }

    public boolean withdrawMoney(int amount) {
        int remainingAmount = amount;

        int num100ToWithdraw = Math.min(remainingAmount / 100, num100);
        remainingAmount -= num100ToWithdraw * 100;

        int num50ToWithdraw = Math.min(remainingAmount / 50, num50);
        remainingAmount -= num50ToWithdraw * 50;

        int num20ToWithdraw = Math.min(remainingAmount / 20, num20);
        remainingAmount -= num20ToWithdraw * 20;

        if (remainingAmount == 0) {
            num20 -= num20ToWithdraw;
            num50 -= num50ToWithdraw;
            num100 -= num100ToWithdraw;
            System.out.println("Выдано " + num100ToWithdraw + " купюр номиналом 100, "
                    + num50ToWithdraw + " купюр номиналом 50 и " + num20ToWithdraw
                    + " купюр номиналом 20.");
            return true;
        } else {
            System.out.println("Не удалось снять указанную сумму.");
            return false;
        }
    }
}