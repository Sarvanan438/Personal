package financial_projection;

public class FinancialData {
    final int costPrice,sellingPrice,totalUnitsSold;

    public FinancialData(int costPrice, int sellingPrice, int totalUnitsSold) {
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.totalUnitsSold = totalUnitsSold;
    }

    public int getCostPrice() {
        return costPrice;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public int getTotalUnitsSold() {
        return totalUnitsSold;
    }
}
