package mpw96;

import java.awt.geom.Point2D;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class KMLPath {

	private List<Point2D> points=new ArrayList<Point2D>();
	
	public void addPoint(Point2D point) {
		points.add(point);
	}
	
	private void writePoints(PrintStream out) {
		for (Point2D point2d : points) {
			out.format("%f, %f, %d%n", point2d.getX(), point2d.getY(), 0);
		}
	}
	
	private void writePrefix(PrintStream out) {
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.println("<kml xmlns=\"http://www.opengis.net/kml/2.2\">");
		out.println("    <Document>");
		out.println("        <name>mpw96's path</name>");
		out.println("        <open>1</open>");
		out.println("        <Folder>");
		out.println("            <name>GC44YVP folder name</name>");
		out.println("            <visibility>0</visibility>");
		out.println("            <description>GC44YVP folder description</description>");
		out.println("            <Placemark>");
		out.println("                <name>GC44YVP placemark name</name>");
		out.println("                <visibility>0</visibility>");
		out.println("                <description><![CDATA[GC44YVP placemark description]]></description>");
		out.println("                <LineString>");
		out.println("                    <tessellate>1</tessellate>");
		out.println("                    <extrude>1</extrude>");
		out.println("                    <coordinates>");
		
	}
	
	private void writePostFix(PrintStream out) {
		out.println("                    </coordinates>");
		out.println("                </LineString>");
		out.println("            </Placemark>");
		out.println("        </Folder>");
		out.println("    </Document>");
		out.println("</kml>");
	}
	
	public void generatePath(PrintStream out) {
		writePrefix(out);
		writePoints(out);
		writePostFix(out);
	}
	
}
