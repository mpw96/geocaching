package geocaching.mpw96;

/**
 * Hello world!
 *
 */
public class App 
{
	// (0,0,5)(0,0,2)(1,1,5)(0,0,7)(0,0,6)(3,1,0)(0,0,1)(0,0,3)(2,1,5)(1,1,8)(12,1,END)
	private static Triple[] data = {
			new Triple(0, 0, '5'),
			new Triple(0, 0, '2'),
			new Triple(1, 1, '5'),
			new Triple(0, 0, '7'),
			new Triple(0, 0, '6'),
			new Triple(3, 1, '0'),
			new Triple(0, 0, '1'),
			new Triple(0, 0, '3'),
			new Triple(2, 1, '5'),
			new Triple(1, 1, '8'),
			new Triple(12, 1, '_'),
			
	};
	
	//https://de.wikibooks.org/wiki/Datenkompression:_Verlustfreie_Verfahren:_W%C3%B6rterbuchbasierte_Verfahren:_LZ77
    public static void main( String[] args )
    {
    	StringBuffer output = new StringBuffer();
    	for(int count=0; count<data.length; ++count) {
    		int length = data[count].getLength();
    		int offset = data[count].getOffset();
    		char followchar = data[count].getSymbol();
    		if(length>0) {
    			for(int i=0; i<length; ++i) {
    				int pos = output.length()-offset;
    				char currentchar = output.charAt(pos);
    				output.append(currentchar);
    			}
    		}
    		output.append(followchar);
    	}
        System.out.println(output);
    }
}
