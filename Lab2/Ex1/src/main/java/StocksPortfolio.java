import java.util.*;

public class StocksPortfolio {
    private String name;
    private IStockMarket sm;
    private List<Stock> stocks = null;

    public StocksPortfolio(IStockMarket market) {
        this.sm=market;
        stocks = new ArrayList<>();
    }

    public IStockMarket getMarketService(){
        return sm;
    }

    public void SetMarketService(IStockMarket sm){
        this.sm = sm;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name=name;
    }

    public double getTotalValue() {
        double total = 0;
        for (Stock s : stocks){
            total = total + sm.getprice(s.getName())*s.getQuantity();
        }
        return total;
    }

    public void addStock(Stock s){
        stocks.add(s);
    }
}
