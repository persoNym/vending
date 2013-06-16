/** Vending.java
    Emulate a vending machine that sells bus tickets.
    @author    Alice E. F
    @author    Victoria A. C
    @version   January 15, 2013
 */
//  ----------------------------------------------------------------------------
import java.util.*;

public class Vending {
	private final double adult; // Price of one regular ticket.
	private final double child; // Child's ticket is half price.
	private final double senior; // Senior ticket is 80%

	private Scanner sc = new Scanner(System.in);

	/**
	 * Initialize a vending machine to sell tickets at a fixed base price.
	 * Tickets for children are half price, and seniors are 80%.
	 * 
	 * @param price
	 *            The base ticket price, for an adult rider.
	 */
	public Vending(double price) {
		adult = price;
		child = Math.ceil(100 * (0.5 * price)) / 100; // Round the fraction up.
		senior = Math.ceil(100 * (0.8 * price)) / 100; // Round the fraction up.
	}

	/**
	 * Dispense bus tickets to be paid for by a credit card. Adult, child, and
	 * senior tickets may be purchased.
	 */
	public void go() {

		int choice, quantity;
		boolean isUserDone = false;
		int numAdult = 0;
		int numChild = 0;
		int numSenior = 0;

		while (!isUserDone) {
			System.out.println("\nBus Ticket Vending Machine");
			System.out.printf(
					"    1. Adult %.2f\n    2. Child under 12 %.2f\n", adult,
					child);
			System.out.printf("    3. Senior Citizen %.2f\n", senior);

			for (;;) {
				System.out
						.println("Please select 1, 2, 3 and enter the quantity. Select 4 twice to end.\n");
				choice = sc.nextInt();
				if (choice > 0 && choice < 5)
					break;
				String junk = sc.nextLine(); // Discard chars to end of line.
				System.out.printf("Bad menu choice:  %s %s\n", choice, junk);
			}

			quantity = sc.nextInt(); // Should be validated!

			switch (choice) {
			case 1:
				numAdult += quantity;
				break;
			case 2:
				numChild += quantity;
				break;
			case 3:
				numSenior += quantity;
				break;
			case 4:
				isUserDone = true;
				break;
			}

		}

		System.out.printf("You have %d child(ren),", numChild);
		System.out.printf("%d adult(s),", numAdult);
		System.out.printf(" and %d senior(s).", numSenior);
		System.out.printf("Your total price is: %.2f", (numChild * child)
				+ (numAdult * adult) + (numSenior * senior));

		System.out.println("\nPlease swipe your credit card, then take your tickets.");

	}

	// -------------------------------------------------------------------------------------------
	public static void main(String args[]) {
		Vending V = new Vending(2.25);
		V.go();
	}
}

/*
 * -----------------------------------------------------------------------------
 * Bus Ticket Vending Machine
    1. Adult 2.25
    2. Child under 12 1.13
    3. Senior Citizen 1.80
 * Please select 1, 2, 3 and enter the quantity. Select 4 twice to end.
 * ===========================
 * 22
 * Bad menu choice:  22 
 * Please select 1, 2, 3 and enter the quantity. Select 4 twice to end
 * ===========================
 * 2
 * 2
 * Bus Ticket Vending Machine
    1. Adult 2.25
    2. Child under 12 1.13
    3. Senior Citizen 1.80
 * Please select 1, 2, 3 and enter the quantity. Select 4 twice to end.
 * 3
 * 3
 * Bus Ticket Vending Machine
    1. Adult 2.25
    2. Child under 12 1.13
    3. Senior Citizen 1.80
 * Please select 1, 2, 3 and enter the quantity. Select 4 twice to end.
 * 1
 * 2
 * Bus Ticket Vending Machine
    1. Adult 2.25
    2. Child under 12 1.13
    3. Senior Citizen 1.80
 * Please select 1, 2, 3 and enter the quantity. Select 4 twice to end.
 * ===========================
 * 4
 * 4
 * You have 2 child(ren),2 adult(s), and 3 senior(s).Your total price is: 12.16
 * Please swipe your credit card, then take your tickets.
 * ------------------------------------------------------------------------------
 */
