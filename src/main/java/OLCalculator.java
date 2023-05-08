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
		double holdingCost = (unitCost * interestRate)/100;

		// Next request lead time, lead time demand and lead time standard
		System.out.println("Enter lead time: ");
		double leadTime = scanner.nextDouble();

		System.out.println("Enter lead time demand: ");
		double leadTimeDemand = scanner.nextDouble();

		System.out.println("Enter lead time standard Deviation: ");
		double leadTimeSD = scanner.nextDouble();

		double annualDemand=(12/leadTime)*leadTimeDemand;

		//list of reorder points
		List<Integer> reorderPoints = new ArrayList<>();
		List<Double> lot_size= new ArrayList<>();
		List<Double> f_r= new ArrayList<>();
		int count=-1;
		double z;
		double l_z;
		double n_r;//n(R)
		double Q0=Math.sqrt((2*orderingCost*annualDemand)/holdingCost);

		lot_size.add(Q0);

		//Request z and L(z) values
		int i =-1;
		do{
			i++;

			f_r.add((1-((lot_size.get(i)*holdingCost))/(penaltyCost*annualDemand)));

			System.out.println("Enter z values according to "+ f_r.get(i)+ " value from the table.");
			z= scanner.nextDouble();
			reorderPoints.add((int) (leadTimeDemand +(leadTimeSD*z)));
			System.out.println(reorderPoints.get(i));
			System.out.println("Enter L(z) values for z " +z);
			l_z=scanner.nextDouble();
			n_r=leadTimeSD*l_z;
			System.out.println(n_r);
			lot_size.add(Math.sqrt((2*annualDemand*(orderingCost+(penaltyCost*n_r)))/(holdingCost)));
			System.out.println(lot_size.get(i));
			count++;


		} while(
				i == 0 || ((Math.abs(reorderPoints.get(i)-reorderPoints.get(i - 1))>(reorderPoints.get(i)/100)))
		);


		System.out.println("Optimal lot size and reorder point (Q,R) " + lot_size.get(lot_size.size()-1)+" ; "+ reorderPoints.get(reorderPoints.size()-1));
		System.out.println();
		System.out.println("Number of iterations : " + count);
		System.out.println();
		System.out.println("The safety stock : " + (reorderPoints.get(reorderPoints.size()-1)-leadTimeDemand));
		System.out.println();
		System.out.println("Avarage annual holding cost : " +(holdingCost*((lot_size.get(lot_size.size()-1)/2)+reorderPoints.get(reorderPoints.size()-1)-leadTimeDemand)) );
		System.out.println("Avarage annual ordering cost : " +(orderingCost*annualDemand)/lot_size.get(lot_size.size()-1));
		System.out.println("Avarage annual penalty cost : " + (penaltyCost*annualDemand*n_r)/lot_size.get(lot_size.size()-1));
		System.out.println();
		System.out.println("Average time between the placement of orders : " + lot_size.get(lot_size.size()-1)/annualDemand);
		System.out.println();
		System.out.print("The proportion of order cycles in which no stock out occurs" + f_r.get(f_r.size()-1) +" means %"+ (f_r.get(f_r.size()-1))*100);
		System.out.println();
		System.out.println("The proportion of demands that are not met");
		System.out.println("Expected Expected demand per cycle is Q = "+ (lot_size.get(lot_size.size()-1)+1));
		System.out.println("Expected number of stock outs per cycle is n(R) = "+ n_r);
		System.out.println("Thus, proportion of demands that are not met is " + "2,01/291 = " +  (n_r/(lot_size.get(lot_size.size()-1))));
		scanner.close();
	}
}


