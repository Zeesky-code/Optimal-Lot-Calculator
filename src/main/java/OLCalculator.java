import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;
public class OLCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// First request costs and interest rate
		System.out.println("Enter unit cost: ");
		double unitCost = scanner.nextDouble();

		System.out.println("Enter ordering cost: ");
		double orderingCost = scanner.nextDouble();

		System.out.println("Enter penalty cost: ");
		double penaltyCost = scanner.nextDouble();

		System.out.println("Enter interest rate in percentage: ");
		double interestRate = scanner.nextDouble();

		//Calculate holding cost
		double holdingCost = (unitCost * interestRate) / 100;

		// Next request lead time, lead time demand and lead time standard
		System.out.println("Enter lead time: ");
		double leadTime = scanner.nextDouble();

		System.out.println("Enter lead time demand: ");
		double leadTimeDemand = scanner.nextDouble();

		System.out.println("Enter lead time standard Deviation: ");
		double leadTimeSD = scanner.nextDouble();

		double annualDemand = (12 / leadTime) * leadTimeDemand;

		int reorderPoint = 0;
		double prevReorderPoint = 0;

		double lotSize = Math.sqrt((2 * orderingCost * annualDemand) / holdingCost);

		// Request z and L(z) values
		int i = 0;
		int count = 0;
		double z;
		double l_z;
		double n_r; //n(R)
		double Q0 = lotSize;
		do {
			prevReorderPoint = reorderPoint;
			double f_r = (1 - (lotSize * holdingCost) / (penaltyCost * annualDemand));
			System.out.println("Enter z values according to " + f_r + " value from the table.");
			z = scanner.nextDouble();
			reorderPoint = (int) (leadTimeDemand + (leadTimeSD * z));
			System.out.println(reorderPoint);
			System.out.println("Enter L(z) values for z " + z);
			l_z = scanner.nextDouble();
			n_r = leadTimeSD * l_z;
			System.out.println(n_r);
			lotSize = Math.sqrt((2 * annualDemand * (orderingCost + (penaltyCost * n_r))) / (holdingCost));
			System.out.println(lotSize);
			count++;
			i++;
		} while (i == 1 || (Math.abs(reorderPoint - prevReorderPoint) > (reorderPoint / 100)));

		scanner.close();

		System.out.println("Optimal lot size and reorder point (Q,R) " + lotSize + " : " + reorderPoint);
		System.out.println();
		System.out.println("Number of iterations : " + count);
		System.out.println();
		System.out.println("The safety stock : " + (reorderPoint - leadTimeDemand));
		System.out.println();
		System.out.println("Average annual holding cost : " + (holdingCost * ((lotSize / 2) + reorderPoint - leadTimeDemand)));
		System.out.println("Average annual ordering cost : " + (orderingCost * annualDemand) / lotSize);
		System.out.println("Average annual penalty cost : " + (penaltyCost * annualDemand * n_r) / lotSize);
		System.out.println();
		System.out.println("Average time between the placement of orders : " + lotSize / annualDemand);
		System.out.println();
		System.out.println("The proportion of order cycles in which no stock out occurs " + (1 - (lotSize * holdingCost) / (penaltyCost * annualDemand)) * 100 + "%");
		System.out.println();
		System.out.println("The proportion of demands that are not met");
		System.out.println("Expected demand per cycle is Q = " + (lotSize + 1));
		System.out.println("Expected number of stock outs per cycle is n(R) = " + n_r);
		System.out.println("Thus, proportion of demands that are not met is " + "= " + ((n_r/lotSize) * 100));
		scanner.close();
	}
}


