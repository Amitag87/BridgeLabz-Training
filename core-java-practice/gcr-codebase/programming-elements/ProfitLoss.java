package BridgeLab;

public class ProfitLoss {
	public static void main(String[] args) {
		int CP=129;
		int SP=191;
		
	System.out.println("The Cost Price is INR "+CP + "and Selling Price is INR" +SP );
		int profit=SP-CP;
		double profitP=(profit/CP)*100;
		System.out.println("Profit is INR "+profit + "and profit percentage is " + profitP +"%" );
	}
}
