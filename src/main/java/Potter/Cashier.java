package Potter;

public class Cashier {

    private Basket basket;

    public Cashier(Basket basket){
        this.basket = basket;
    }

    public double cal_price() {
        double totalPrice = 0.0;
        int diff_book, max_count = this.getCountMaxValue();

        for (int i = 0; i < max_count; i++) {
            diff_book=0;
            for (int j = 0; j < 5; j++) {
                if (this.basket.getCount()[j] > 0) {
                    diff_book++;
                    this.basket.getItems().remove(new Book(j, "Potter Series "+j+1));
                    this.basket.getCount()[j]--;
                }
            }
            double discount = getDiscount(diff_book);
            totalPrice += 8*diff_book*discount;

            // for edge case
            if(max_count > 1 && i==max_count-1 && diff_book==3){
                totalPrice -= 0.4;
            }
        }System.out.println("Total price: "+totalPrice);
        return totalPrice;
    }

    private double getDiscount(int diffOfBook){
        double[] discount ={1.0, 1.0, 0.95, 0.90, 0.80, 0.75};
        return discount[diffOfBook];
    }

    public void setBasket(Basket basket){
        this.basket = basket;
    }

    private int getCountMaxValue() {
        return getMaxValue(this.basket.getCount());
    }
    private int getMaxValue(int[] numbers){
        int maxValue = numbers[0];
        for(int i=1;i < numbers.length;i++){
            if(numbers[i] > maxValue){
                maxValue = numbers[i];
            }
        }
        return maxValue;
    }
}
