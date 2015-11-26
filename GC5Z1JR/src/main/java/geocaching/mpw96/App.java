package geocaching.mpw96;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
    	int[][] permutations = {
    			{0, 1, 2, 3},
    			{0, 1, 3, 2},
    			{0, 2, 1, 3},
    			{0, 2, 3, 1},
    			{0, 3, 1, 2},
    			{0, 3, 2, 1},
    			{1, 0, 2, 3},
    			{1, 0, 3, 2},
    			{1, 2, 0, 3},
    			{1, 2, 3, 0},
    			{1, 3, 0, 2},
    			{1, 3, 2, 0},
    			{2, 0, 1, 3},
    			{2, 0, 3, 1},
    			{2, 1, 0, 3},
    			{2, 1, 3, 0},
    			{2, 3, 0, 1},
    			{2, 3, 1, 0},
    			{3, 0, 1, 2},
    			{3, 0, 2, 1},
    			{3, 1, 0, 2},
    			{3, 1, 2, 0},
    			{3, 2, 0, 1},
    			{3, 2, 1, 0}    			
    	};
    	
    	for(int index=0; index < 24; ++index) {
	    	Onetimepad otp = OnetimepadBuilder.getOnetimepad(
	    			permutations[index][0],
	    			permutations[index][1],
	    			permutations[index][2],
	    			permutations[index][3]);
	    	
    		for(;otp.hasNextPosition(); otp.nextPosition())
    		{
		    	CypherText cypher = new CypherText();
		    	StringBuffer sb = new StringBuffer();
		    	for(int i=0; i<48; ++i) {
		    		int cypherLetter = cypher.getCypherLetter(i);
		    		int otpLetter = otp.getKeyLetter(i);
		    		int cleartextLetter = cypherLetter ^ otpLetter;
		    		
		    		sb.append(Character.toString((char) cleartextLetter));
		    	}
		    	
	    		System.out.println(String.format("================ position %d, permutation %d", otp.getCurrentPosition(), index));
	    		System.out.println(sb.toString().trim());
    		}
    	}
    }
}
