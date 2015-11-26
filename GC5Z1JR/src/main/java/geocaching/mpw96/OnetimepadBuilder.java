package geocaching.mpw96;

public class OnetimepadBuilder {
	
	static public Onetimepad getOnetimepad(int A, int B, int C, int D) {
		
		Onetimepad otp = new Onetimepad();
		PlateWithHoles pwh = new PlateWithHoles();

		for(int i=0; i<24; ++i) {
			StringBuffer sb = new StringBuffer();
			for( int j=0; j<4; ++j) {
				char circleSize = pwh.getCircleSize(i*8+j);
				StringBuffer digit = new StringBuffer();
				if('A'==circleSize)
					digit.append(Integer.toBinaryString(A));
				else if('B'==circleSize)
					digit.append(Integer.toBinaryString(B));
				else if('C'==circleSize)
					digit.append(Integer.toBinaryString(C));
				else if('D'==circleSize)
					digit.append(Integer.toBinaryString(D));
				else {
					System.out.println("ERROR");
				}
				
				while( digit.length()<2) {
					digit.insert(0, '0');
				}
				sb.append(digit);
			}

			otp.set(2*i, Integer.parseInt(sb.toString(), 2));
			sb = new StringBuffer();
			for( int j=4; j<8; ++j) {
				char circleSize = pwh.getCircleSize(i*8+j);
				StringBuffer digit = new StringBuffer();
				if('A'==circleSize)
					digit.append(Integer.toBinaryString(A));
				else if('B'==circleSize)
					digit.append(Integer.toBinaryString(B));
				else if('C'==circleSize)
					digit.append(Integer.toBinaryString(C));
				else if('D'==circleSize)
					digit.append(Integer.toBinaryString(D));
				else {
					System.out.println("ERROR");
				}

				while( digit.length()<2) {
					digit.insert(0, '0');
				}
				sb.append(digit);
			}
			otp.set(2*i+1, Integer.parseInt(sb.toString(), 2));
		}		

		return otp;
	}
}
