package financial_projection.projection.strategies;

import financial_projection.FinancialData;
import financial_projection.FinancialProjectors;

public class PLProjection  implements FinancialProjectors {
    FinancialData data ;
    PLProjection(FinancialData data){
        this.data=data;
    }

    private double getProfit(){
        return this.data.getSellingPrice() - this.data.getCostPrice();
    }

    private double getProfitPercent(){
        return this.getProfit()/this.data.getCostPrice();
    }
    private void printProfitForIteration(int iteration){
        double profit = this.getProfit();
        String profitLossString = profit>0 ?"Profit":"Loss";

        System.out.println(String.format("Projected %s for the %d year is %f  ",profitLossString,iteration,profit));
    }
    @Override
    public void project(int iteration) {
        for(int i=0;i<iteration;i++){


        }
    }
}
