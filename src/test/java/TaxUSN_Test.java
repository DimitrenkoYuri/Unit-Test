import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaxUSN_Test {

    @Test
    public void testTaxIncome() {
        int earnings = 1000;
        int actual = TaxUSN.taxIncome(earnings);
        int expected = earnings * 6 / 100;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testTaxIncomeExpense() {
        int earnings = 1000;
        int spendings = 500;
        int actual = TaxUSN.taxIncomeExpense(earnings, spendings);
        int expected = 0;
        Assertions.assertNotSame(expected, actual);
    }

    @Test
    public void testCompareTax() {
        int earnings = 1000;
        int spendings = 600;
        Assertions.assertTrue(TaxUSN.compareTax(earnings, spendings));
    }
}