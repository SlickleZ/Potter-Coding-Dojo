package Potter;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private final List<Book> items;
    private final int[] count = {0, 0, 0, 0, 0};
    private final BookShelf shelf;

    public Basket(BookShelf shelf) {
        items = new ArrayList<>();
        this.shelf = shelf;
    }


    private void addBook_0(){
        if(shelf.getStock()[0]!=0){
            items.add(shelf.addBookToBasket(0));
            count[0]++;
        }else{
            System.out.println("No Potter Series 1 on shelf!");
        }
    }

    public void addBook_0(int amount){
        int round = Math.min(amount, shelf.getStock()[0]);
        for (int i = 0; i < round; i++) {
            addBook_0();
        }
        System.out.println("Added "+round+" Potter Series 1 to basket, In shelf: "+shelf.getStock()[0]);
    }

    private void addBook_1(){
        if(shelf.getStock()[1]!=0){
            items.add(shelf.addBookToBasket(1));
            count[1]++;
        }else{
            System.out.println("No Potter Series 2 on shelf!");
        }
    }

    public void addBook_1(int amount){
        int round = Math.min(amount, shelf.getStock()[1]);
        for (int i = 0; i < round; i++) {
            addBook_1();
        }
        System.out.println("Added "+round+" Potter Series 2 to basket, In shelf: "+shelf.getStock()[1]);
    }

    private void addBook_2(){
        if(shelf.getStock()[2]!=0){
            items.add(shelf.addBookToBasket(2));
            count[2]++;
        }else{
            System.out.println("No Potter Series 3 on shelf!");
        }
    }

    public void addBook_2(int amount){
        int round = Math.min(amount, shelf.getStock()[2]);
        for (int i = 0; i < round; i++) {
            addBook_2();
        }
        System.out.println("Added "+round+" Potter Series 3 to basket, In shelf: "+shelf.getStock()[2]);
    }

    private void addBook_3(){
        if(shelf.getStock()[3]!=0){
            items.add(shelf.addBookToBasket(3));
            count[3]++;
        }else{
            System.out.println("No Potter Series 4 on shelf!");
        }
    }

    public void addBook_3(int amount){
        int round = Math.min(amount, shelf.getStock()[3]);
        for (int i = 0; i < round; i++) {
            addBook_3();
        }
        System.out.println("Added "+round+" Potter Series 4 to basket, In shelf: "+shelf.getStock()[3]);
    }

    private void addBook_4(){
        if(shelf.getStock()[4]!=0){
            items.add(shelf.addBookToBasket(4));
            count[4]++;
        }else{
            System.out.println("No Potter Series 5 on shelf!");
        }
    }

    public void addBook_4(int amount){
        int round = Math.min(amount, shelf.getStock()[4]);
        for (int i = 0; i < round; i++) {
            addBook_4();
        }
        System.out.println("Added "+round+" Potter Series 5 to basket, In shelf: "+shelf.getStock()[4]);
    }

    // ===============================================================================

    private void removeBook_0ToShelf(){
        if(this.count[0]!=0){
            int FirstIndex = findIndex(0);
            items.remove(FirstIndex);
            count[0]--;
            shelf.addBookToShelf(0, 1);
        }else{
            System.out.println("No Potter Series 1 on your basket!");
        }
    }

    public void removeBook_0ToShelf(int amount){
        int round = Math.min(amount, this.count[0]);
        for (int i = 0; i < round; i++) {
            removeBook_0ToShelf();
        }
        System.out.println("Remove "+round+" Potter Series 1 from basket, In shelf: "+shelf.getStock()[0]);
    }

    private void removeBook_1ToShelf(){
        if(this.count[1]!=0){
            int FirstIndex = findIndex(1);
            items.remove(FirstIndex);
            count[1]--;
            shelf.addBookToShelf(1, 1);
        }else{
            System.out.println("No Potter Series 2 on your basket!");
        }
    }

    public void removeBook_1ToShelf(int amount){
        int round = Math.min(amount, this.count[1]);
        for (int i = 0; i < round; i++) {
            removeBook_1ToShelf();
        }
        System.out.println("Remove "+round+" Potter Series 2 from basket, In shelf: "+shelf.getStock()[1]);
    }

    private void removeBook_2ToShelf(){
        if(this.count[2]!=0){
            int FirstIndex = findIndex(2);
            items.remove(FirstIndex);
            count[2]--;
            shelf.addBookToShelf(2, 1);
        }else{
            System.out.println("No Potter Series 3 on your basket!");
        }
    }

    public void removeBook_2ToShelf(int amount){
        int round = Math.min(amount, this.count[2]);
        for (int i = 0; i < round; i++) {
            removeBook_2ToShelf();
        }
        System.out.println("Remove "+round+" Potter Series 3 from basket, In shelf: "+shelf.getStock()[2]);
    }

    private void removeBook_3ToShelf(){
        if(this.count[3]!=0){
            int FirstIndex = findIndex(3);
            items.remove(FirstIndex);
            count[3]--;
            shelf.addBookToShelf(3, 1);
        }else{
            System.out.println("No Potter Series 4 on your basket!");
        }
    }

    public void removeBook_3ToShelf(int amount){
        int round = Math.min(amount, this.count[3]);
        for (int i = 0; i < round; i++) {
            removeBook_3ToShelf();
        }
        System.out.println("Remove "+round+" Potter Series 4 from basket, In shelf: "+shelf.getStock()[3]);
    }

    private void removeBook_4ToShelf(){
        if(this.count[4]!=0){
            int FirstIndex = findIndex(4);
            items.remove(FirstIndex);
            count[4]--;
            shelf.addBookToShelf(4, 1);
        }else{
            System.out.println("No Potter Series 5 on your basket!");
        }
    }

    public void removeBook_4ToShelf(int amount){
        int round = Math.min(amount, this.count[4]);
        for (int i = 0; i < round; i++) {
            removeBook_4ToShelf();
        }
        System.out.println("Remove "+round+" Potter Series 5 from basket, In shelf: "+shelf.getStock()[4]);
    }

    public void clearBasket(){
        this.removeBook_0ToShelf(this.count[0]);
        this.removeBook_1ToShelf(this.count[1]);
        this.removeBook_2ToShelf(this.count[2]);
        this.removeBook_3ToShelf(this.count[3]);
        this.removeBook_4ToShelf(this.count[4]);
        items.clear();
        for(int i=0;i<5;i++){
            count[i] = 0;
        }
    }

    // for .indexOf bug
    private int findIndex(int id){
        for(Book book : items){
            if(book.getId() == id){
                return items.indexOf(book);
            }
        }return -1;
    }

    public List<Book> getItems() { return items; }
    public int[] getCount() { return count; }
}
