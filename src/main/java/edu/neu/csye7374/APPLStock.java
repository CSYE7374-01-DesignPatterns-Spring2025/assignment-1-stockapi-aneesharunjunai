package edu.neu.csye7374;

public class APPLStock extends StockAPI{
    public APPLStock(String name, double price, String description) {
        super(name, price, description);
    }

    @Override
    public void setPrice(double price) {
        if(price > this.getPrice()) {
            int value = (int) ((price-this.getPrice())*50 / this.getPrice());
            setMetric(getMetric() + value);
        }else {
            int value = (int) ((price-this.getPrice())*20 / this.getPrice());
            setMetric(getMetric() + value);
        }
        this.price = price;
    }

}
