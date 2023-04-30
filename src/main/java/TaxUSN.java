public class TaxUSN {
    public static int taxIncome(int earnings) {
        return earnings * 6 / 100;
    }
    public static int taxIncomeExpense(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        return ((tax >= 0) ? tax : 0);
    }
    public static boolean compareTax(int earnings, int spendings) {
        return (earnings * 6 / 100) == ((earnings - spendings) * 15 / 100);
    }
}
