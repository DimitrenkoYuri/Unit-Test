import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";

    public static void main(String[] args) {
        System.out.println(ANSI_GREEN + "Программа по выбору системы налообложения" + ANSI_RESET);
        System.out.println();
        int earnings = 0;
        int spendings = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите операцию и введите её номер (или  \"end\" для выхода):");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            int select = Integer.parseInt(input);

            switch (select) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr1 = scanner.nextLine();
                    int money1 = Integer.parseInt(moneyStr1);
                    earnings += Math.abs(money1);
                    if (earnings < 1) System.out.println("Налог точно меньше рубля!");
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String moneyStr2 = scanner.nextLine();
                    int money2 = Integer.parseInt(moneyStr2);
                    spendings += Math.abs(money2);
                    break;
                case 3:
                    int tax6 = TaxUSN.taxIncome(earnings);
                    int tax15 = TaxUSN.taxIncomeExpense(earnings, spendings);
                    if (TaxUSN.compareTax(earnings, spendings)) {
                        System.out.println(ANSI_YELLOW + "Одинаковый налог: для общего дохода " + earnings + " р. и расхода " + spendings + " р. налоги по " + tax6 + " рублей;)" + ANSI_RESET);
                    } else if (tax6 < tax15) {
                        System.out.println(ANSI_GREEN + "Мы советуем вам УСН  6% c доходов" + ANSI_RESET);
                        System.out.println("Для общего дохода " + earnings + " р. и расхода " + spendings + " р. ваш налог составит: " + tax6 + " рублей");
                        System.out.println("Налог на другой системе: " + tax15 + " рублей");
                        System.out.println(ANSI_GREEN + "Экономия: " + (tax15 - tax6) + " рублей" + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_GREEN + "Мы советуем вам УСН 15 % с доходов минус расходы" + ANSI_RESET);
                        System.out.println("Для общего дохода " + earnings + " р. и расхода " + spendings + " р. ваш налог составит: " + tax15 + " рублей");
                        System.out.println("Налог на другой системе: " + tax6 + " рублей");
                        System.out.println(ANSI_GREEN + "Экономия: " + (tax6 - tax15) + " рублей" + ANSI_RESET);
                    }
                    System.out.println();
                    break;
                default:
                    System.out.println(ANSI_RED_BACKGROUND + "Такой операции \"" + input + "\" нет (некорректный ввод)" + ANSI_RESET);
                    System.out.println();
            }
        }
        System.out.println();
        System.out.println(ANSI_PURPLE + "Программа завершена!" + ANSI_RESET);
    }
}