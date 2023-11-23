package org.example.CalculatorApp.entity;

import org.example.CalculatorApp.entity.interfaces.IShape;
import org.example.CalculatorApp.services.SVGBuilder;

import java.util.Objects;

public class Arc implements IShape {

    private int radius;
    private Point startPoint;
    private Point endPoint;

    public Arc() {
    }

    public Arc(int radius, Point startPoint, Point endPoint) {
        this.radius = radius;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arc arc = (Arc) o;
        return radius == arc.radius && endPoint == arc.endPoint && Objects.equals(startPoint, arc.startPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, startPoint, endPoint);
    }

    @Override
    public String toString() {
        return "Arc{" +
                "radius=" + radius +
                ", pointCenter=" + startPoint +
                ", degr=" + endPoint +
                '}';
    }

    /*@Override
    public void drawToDXF(DXFDocument dxfDocument) {
        DXFArc arc = new DXFArc();
        arc.setCenterPoint(pointCenter.convert());
        arc.setRadius(radius);
        arc.setStartAngle();
        dxfDocument.addDXFEntity(arc);
    }*/

    @Override
    public void drawToSVG(SVGBuilder svgBuilder) {
        String arc;
            arc = "<path d=\"M" + startPoint.x * svgBuilder.scale
                    + "," + startPoint.y* svgBuilder.scale
                    +"A" + radius * svgBuilder.scale
                    + "," + radius * svgBuilder.scale
                    + " 0 0,1 " + endPoint.x * svgBuilder.scale
                    + ", " + endPoint.y * svgBuilder.scale
                    + "\" fill=\"none\" stroke=\"#b38600\" vector-effect=\"non-scaling-stroke\" stroke-width=\"2\"></path>";
        svgBuilder.append(arc);
    }
}
