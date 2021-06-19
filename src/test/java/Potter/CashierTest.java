package Potter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashierTest {

    BookShelf bookShelf = new BookShelf(100, 100, 100, 100, 100);
    Basket basket = new Basket(bookShelf);
    Cashier cashier = new Cashier(basket);

    @Test
    void testBasics() {

        assertEquals(0, cashier.cal_price());

        basket.addBook_1(1);
        assertEquals(8, cashier.cal_price());

        basket.addBook_2(1);
        assertEquals(8, cashier.cal_price());

        basket.addBook_3(1);
        assertEquals(8, cashier.cal_price());

        basket.addBook_4(1);
        assertEquals(8, cashier.cal_price());

        basket.addBook_1(3);
        assertEquals(8 * 3, cashier.cal_price());
    }

    @Test
    void testSimpleDiscounts() {

        basket.addBook_0(1);
        basket.addBook_1(1);
        assertEquals(8 * 2 * 0.95, cashier.cal_price());

        basket.addBook_0(1);
        basket.addBook_2(1);
        basket.addBook_4(1);
        assertEquals(8 * 3 * 0.9, cashier.cal_price());

        basket.addBook_0(1);
        basket.addBook_1(1);
        basket.addBook_2(1);
        basket.addBook_4(1);
        assertEquals(8 * 4 * 0.8, cashier.cal_price());

        basket.addBook_0(1);
        basket.addBook_1(1);
        basket.addBook_2(1);
        basket.addBook_3(1);
        basket.addBook_4(1);
        assertEquals(8 * 5 * 0.75, cashier.cal_price());
    }

    @Test
    void testSeveralDiscount(){

        basket.addBook_0(2);
        basket.addBook_1(1);
        assertEquals(8 + (8 * 2 * 0.95), cashier.cal_price());

        basket.addBook_0(2);
        basket.addBook_1(2);
        assertEquals(2 * (8 * 2 * 0.95), cashier.cal_price());

        basket.addBook_0(2);
        basket.addBook_1(1);
        basket.addBook_2(2);
        basket.addBook_3(1);
        assertEquals((8 * 4 * 0.8) + (8 * 2 * 0.95), cashier.cal_price());

        basket.addBook_0(1);
        basket.addBook_1(2);
        basket.addBook_2(1);
        basket.addBook_3(1);
        basket.addBook_4(1);
        assertEquals(8 + (8 * 5 * 0.75), cashier.cal_price());
    }

    @Test
    void testEdgeCases() {

        basket.addBook_0(2);
        basket.addBook_1(2);
        basket.addBook_2(2);
        basket.addBook_3(1);
        basket.addBook_4(1);
        assertEquals(2 * (8 * 4 * 0.8), cashier.cal_price());

        basket.addBook_0(5);
        basket.addBook_1(5);
        basket.addBook_2(4);
        basket.addBook_3(5);
        basket.addBook_4(4);
        assertEquals(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8), cashier.cal_price());
    }
}