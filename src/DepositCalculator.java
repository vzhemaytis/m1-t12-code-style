import java.util.Scanner;

public class DepositCalculator {

    public static void main(String[] args) {
        new DepositCalculator().calculateAndPrintDepositSum();
    }

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double depositWithComplexPercent = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundToScale(depositWithComplexPercent, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
         return roundToScale(amount + amount * yearRate * depositPeriod, 2);
    }

    double roundToScale(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateAndPrintDepositSum() {
        int period;
        int action;
        int amount;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double depositOutcome = 0;
        if (action == 1){
            depositOutcome = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            depositOutcome = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + depositOutcome);
    }
}
