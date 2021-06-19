package Potter;

import java.util.List;

public class Customer {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(5, 5, 5, 5, 5);
        Basket basket = new Basket(bookShelf);

        System.out.println("\n\nAdding to basket..");
        basket.addBook_0(6);
        basket.addBook_1(2);
        basket.addBook_2(2);
        basket.addBook_3(1);
        basket.addBook_4(1);

        System.out.println("\n\nRemove from basket..");
        basket.removeBook_0ToShelf(1);
        basket.removeBook_1ToShelf(1);
        basket.removeBook_2ToShelf(1);
        basket.removeBook_3ToShelf(1);
        basket.removeBook_4ToShelf(1);

        basket.clearBasket();

        System.out.print("\n[ ");
        List<Book> items = basket.getItems();
        for (Book item : items) {
            System.out.print(item.getId()+" ");
        }System.out.println("]");

        Cashier cashier = new Cashier(basket);
        cashier.cal_price();
    }
}
