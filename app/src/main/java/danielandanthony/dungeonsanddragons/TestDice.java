package danielandanthony.dungeonsanddragons;

import java.util.Scanner;

/**
 * Based on an input value, creates and rolls a die, returning the value of the die roll.
 */
public class TestDice {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		Dice dX = new Dice(i);
		int roll = dX.rollDice();
		System.out.println("You rolled a " + roll);
	}
}