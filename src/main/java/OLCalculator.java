import java.util.Scanner;

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

		System.out.println("Enter lead time standard: ");
		double leadTimeStandard = scanner.nextDouble();

		//Request z and L(z) values

		System.out.println("Enter z value: ");
		double z = scanner.nextDouble();

		System.out.println("Enter L(z) value: ");
		double Lz = scanner.nextDouble();

		System.out.println("Hello World!");
		scanner.close();
	}
}
