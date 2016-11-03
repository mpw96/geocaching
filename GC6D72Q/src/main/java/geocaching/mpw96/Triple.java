package geocaching.mpw96;

public class Triple {
	private int m_offset = 0;
	private int m_length = 0;
	private char m_symbol = '_';

	public int getOffset() {
		return m_offset;
	}

	public int getLength() {
		return m_length;
	}

	public char getSymbol() {
		return m_symbol;
	}

    public Triple(int offset, int length, char symbol) {
    	m_offset = offset;
    	m_length = length;
    	m_symbol = symbol;
    }
}
