public class BaguenaudierPuzzle {

	int[] state;
	int operations;

	public void setState(int len) {
		state = new int[len];

		for (int i = 0; i < len; i++) {
			state[i] = 1;
		}
	}

	public void printPuzzle() {
		String str = "";
		for (int i = state.length-1; i >= 0; i--) {
			str += state[i];
		}

		System.out.println(str);
	}

	public void flip(int i) {
		if (state[i] == 0) {
			state[i] = 1;
		}
		else {
			state[i] = 0;
		}
		System.out.print("--" + (i+1) + "-> ");
		printPuzzle();
		operations++;
	}

	public void takeOffRings(int n) {
		if (n == 1) {
			flip(0);
		}
		else if (n == 2) {
			flip(1);
			flip(0);
		}
		else {
			takeOffRings(n - 2);
			flip(n - 1);
			putRingsOn(n - 2);
			takeOffRings(n - 1); 
		}
	}

	public void putRingsOn(int n) {
		if (n == 1) {
			flip(0);
		}
		else if (n == 2) {
			flip(0);
			flip(1);
		}
		else {
			putRingsOn(n - 1);
			takeOffRings(n - 2);
			flip(n - 1);
			putRingsOn(n - 2);
		}
	}

	public void testPuzzle(int n) {
		operations = 0;
		setState(n);
		takeOffRings(n);
		System.out.println("n = " + n + " operations: " + operations);
	}



	public static void main(String args[]) {
		BaguenaudierPuzzle myObj = new BaguenaudierPuzzle();
		myObj.testPuzzle(5);
	}
}