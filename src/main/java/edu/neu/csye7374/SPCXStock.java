package edu.neu.csye7374;

public class SPCXStock extends StockAPI {

    public SPCXStock(String name, double price, String description) {
        super(name, price, description);
    }
    @Override
    public void setPrice(double price) {
        if(price > this.getPrice()) {
            int value = (int) ((price-this.getPrice())*80 / this.getPrice());
            setMetric(getMetric() + value);
        }else {
            int value = (int) ((price-this.getPrice())*15 / this.getPrice());
            setMetric(getMetric() + value);
        }
        this.price = price;
    }
}
