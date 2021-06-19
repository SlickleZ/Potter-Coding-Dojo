package Potter;

import java.util.ArrayList;
import java.util.List;

public class BookShelf{

    private final List<Book> bookInShelf;
    private final int[] stock;

    public BookShelf(int numOfBook0, int numOfBook1, int numOfBook2, int numOfBook3, int numOfBook4){
        bookInShelf = new ArrayList<>();

        bookInShelf.add(new Book(0, "Potter Series 1"));
        bookInShelf.add(new Book(1, "Potter Series 2"));
        bookInShelf.add(new Book(2, "Potter Series 3"));
        bookInShelf.add(new Book(3, "Potter Series 4"));
        bookInShelf.add(new Book(4, "Potter Series 5"));

        stock = new int[]{numOfBook0, numOfBook1, numOfBook2, numOfBook3, numOfBook4};

//        System.out.println("Book Shelf created with this stock:" +
//                "\nPotter Series 1 : "+stock[0]+
//                "\nPotter Series 2 : "+stock[1]+
//                "\nPotter Series 3 : "+stock[2]+
//                "\nPotter Series 4 : "+stock[3]+
//                "\nPotter Series 5 : "+stock[4]);
    }

    public BookShelf(){
        this(0, 0, 0, 0, 0);
    }

    public Book addBookToBasket(int id){
        this.decreaseNumOfBooks(id);
        return bookInShelf.get(id);
    }

    public void addBookToShelf(int id, int amount) {
        stock[id] += amount;
    }

    private void decreaseNumOfBooks(int id) {
        stock[id]--;
    }

    public int[] getStock() {
        return stock;
    }
}
