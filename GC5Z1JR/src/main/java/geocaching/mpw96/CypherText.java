package geocaching.mpw96;

public class CypherText {

private int[][] data = {
	{Integer.parseInt("00111011", 2), Integer.parseInt("00001110", 2)},
	{Integer.parseInt("10010100", 2), Integer.parseInt("11100000", 2)},
	{Integer.parseInt("01001110", 2), Integer.parseInt("00001111", 2)},
	{Integer.parseInt("10000001", 2), Integer.parseInt("01000010", 2)},
	{Integer.parseInt("01010011", 2), Integer.parseInt("11101111", 2)},
	{Integer.parseInt("11101110", 2), Integer.parseInt("10010100", 2)},
	{Integer.parseInt("01011000", 2), Integer.parseInt("01011000", 2)},
	{Integer.parseInt("11001110", 2), Integer.parseInt("11000110", 2)},
	{Integer.parseInt("11110011", 2), Integer.parseInt("10101000", 2)},
	{Integer.parseInt("11000110", 2), Integer.parseInt("10111100", 2)},
	{Integer.parseInt("01011001", 2), Integer.parseInt("11001011", 2)},
	{Integer.parseInt("10001001", 2), Integer.parseInt("11001110", 2)},
	{Integer.parseInt("11000101", 2), Integer.parseInt("11011110", 2)},
	{Integer.parseInt("11001111", 2), Integer.parseInt("10001000", 2)},
	{Integer.parseInt("01001110", 2), Integer.parseInt("01000001", 2)},
	{Integer.parseInt("11001000", 2), Integer.parseInt("11001101", 2)},
	{Integer.parseInt("11110110", 2), Integer.parseInt("11011110", 2)},
	{Integer.parseInt("10001000", 2), Integer.parseInt("10010000", 2)},
	{Integer.parseInt("00000011", 2), Integer.parseInt("00001000", 2)},
	{Integer.parseInt("11011100", 2), Integer.parseInt("10010001", 2)},
	{Integer.parseInt("10000011", 2), Integer.parseInt("10011100", 2)},
	{Integer.parseInt("10100100", 2), Integer.parseInt("11011111", 2)},
	{Integer.parseInt("01010101", 2), Integer.parseInt("11010110", 2)},
	{Integer.parseInt("11111111", 2), Integer.parseInt("11111111", 2)}
};

public int getCypherLetter(int index) {
	int row = index / 2;
	int column = index % 2;
	
	return data[row][column];
}

}
