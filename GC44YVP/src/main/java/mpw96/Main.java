package mpw96;

import java.awt.geom.Point2D;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.geotools.referencing.GeodeticCalculator;

public class Main {
	public static void main(final String[] args) {
		GeodeticCalculator calc = new GeodeticCalculator();
		KMLPath mypath = new KMLPath();
		
		boolean mustClose = false;
		PrintStream ps = null;
		try {
			File f = new File(args[0]);
			if(f.exists()) {
				f.delete();
			}
			ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(f, false)));
			mustClose=true;
		}
		catch(Exception e) {
			ps = System.out;
		}
		
		Point2D start = new Point2D.Double(13.25197, 52.44378);
		for(double A=0.0; A<=180.0; ++A) {
			calc.setStartingGeographicPoint(start);
			calc.setDirection(A, A*30);
			Point2D mypoint = calc.getDestinationGeographicPoint();
			mypath.addPoint(mypoint);
		}

		mypath.generatePath(ps);
		
		if(mustClose) {
			ps.close();
		}
	}
}