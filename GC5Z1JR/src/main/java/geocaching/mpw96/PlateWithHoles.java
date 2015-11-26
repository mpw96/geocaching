package geocaching.mpw96;

// A very small
// ...
// D big

public class PlateWithHoles {
	private char[][] data = {
		{'B', 'C', 'D', 'A', 'B', 'C', 'C', 'D'},
		{'D', 'D', 'C', 'A', 'C', 'A', 'D', 'A'},
		{'B', 'C', 'D', 'C', 'B', 'C', 'C', 'D'},
		{'D', 'C', 'D', 'C', 'A', 'C', 'D', 'A'},
		{'A', 'D', 'B', 'C', 'D', 'A', 'D', 'C'},
		{'D', 'A', 'D', 'C', 'D', 'A', 'B', 'D'},
		{'B', 'C', 'C', 'D', 'B', 'C', 'D', 'A'},
		{'D', 'C', 'D', 'C', 'D', 'D', 'A', 'D'},
		{'D', 'A', 'B', 'C', 'C', 'A', 'B', 'C'},
		{'D', 'D', 'A', 'D', 'C', 'A', 'D', 'D'},
		{'B', 'C', 'D', 'A', 'D', 'C', 'C', 'D'},
		{'D', 'A', 'D', 'A', 'D', 'D', 'D', 'D'},
		{'D', 'D', 'B', 'C', 'D', 'C', 'B', 'C'},
		{'D', 'C', 'D', 'D', 'C', 'D', 'C', 'D'},
		{'B', 'D', 'C', 'D', 'B', 'C', 'D', 'D'},
		{'D', 'D', 'D', 'A', 'D', 'D', 'D', 'D'},
		{'D', 'A', 'B', 'C', 'D', 'D', 'D', 'C'},
		{'D', 'A', 'D', 'D', 'D', 'D', 'D', 'D'},
		{'B', 'C', 'D', 'A', 'B', 'C', 'D', 'A'},
		{'D', 'D', 'D', 'A', 'D', 'D', 'D', 'B'},
		{'D', 'D', 'B', 'C', 'D', 'D', 'D', 'D'},
		{'D', 'A', 'D', 'D', 'D', 'D', 'D', 'D'},
		{'B', 'C', 'D', 'D', 'D', 'D', 'D', 'D'},
		{'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D'}
	};

	public char getCircleSize(int index) {
		int row = index / 8;
		int column = index % 8;
		
		return data[row][column];
	}
}
