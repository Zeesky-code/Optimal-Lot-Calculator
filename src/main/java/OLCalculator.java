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

		System.out.println("Enter interest rate: ");
		double interestRate = scanner.nextDouble();

		System.out.println("Hello World!");
		scanner.close();
	}
}
