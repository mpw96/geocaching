package geocaching.mpw96;



public class App 
{
    private String[] data = {
        "1.4o3.4o2.10o3.7o9.7o5.2o8.7o5.7o3.7o5.4B3.2B",
        "3.3B8.1o2B5.3B5.1o2B5.3B1.1o3B7.3B4.2B1o1.1o2",
        "B7.1o2B5.3B3.2B1.3B1.2B3.9B1o7.1o3B12.1o3B3.3",
        "B8.3B2o4B1.9B1o6.1o3B4.2B3.4B3.3o4.1o3B3.1o3B",
        "3.1o8.1o3B3.1o2.3B3.3o7.3B2.2B1o4.1o3B2.1o3B3",
        ".1o2.1o2B1o4.2B1o4.2B3o2B2.1o4B4o2B5.1o4B4o2B",
        "1.1o3B1o2.3B4.1o3B6.2B3o2B1.1o4B4o2B99.11O4.2",
        "o8.1o2B11.7o9.1o2B11.2o3.7o5.7o5.3B4.2B3.1o3B",
        "6.1o4B9.1o3B2.4B1o5.1o4B9.1o3B1.1o2B9.1o3B2.4",
        "B1o3.3B4o6.3B4.1o2B1.3B9.3B2.1B2.3B3.1o2B1.3B",
        "10.3B1.9B1o2.3B2.1B2.3B3.3B4.2o4.3B2.1o3B2o3B",
        "2o7.3B1o1B2.1o3B1.1o3B2o3B2o2.3o3.3B1.2B1o4.1",
        "o3B1.3B1o1B2.1o3B2.1o3B3o4B2.1o3B1o6.1o3B1o10",
        ".2B3o2B8.1o3B1o3.3B2.1o3B1o2.2B3o2B5.2B3o2B3.",
    };

    public void run()
    {
    	for(int linelength=50; linelength<100; ++linelength) {
    		System.out.println();
    		System.out.println("Length: " + String.valueOf(linelength));
    	
	    	int gesamtBuchstaben = 0;
	    	StringBuffer countString = new StringBuffer();
	        for(int i=0; i<data.length; ++i) {
	            for(int index=0; index<data[i].length(); ++index) {
	            	if(Character.isDigit(data[i].charAt(index))) {
	            		countString.append(data[i].charAt(index));
	            	}
	            	else {
	            		int count = Integer.valueOf(countString.toString());
	            		for(int p=0; p<count; ++p) {
	            			System.out.print(data[i].charAt(index));
	                		++gesamtBuchstaben;
	                		if( 0 == gesamtBuchstaben % (linelength+1) ) {
	                			System.out.println();
	                		}
	                		
	            		}
	            		countString = new StringBuffer();
	            	}
	            }
	        }
    	}
    }
}
