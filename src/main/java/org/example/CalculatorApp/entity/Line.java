package org.example.CalculatorApp.entity;

import org.example.CalculatorApp.entity.interfaces.IShape;
import org.example.CalculatorApp.services.SVGBuilder;

import java.util.Objects;

public class Line implements IShape {
    private Point point1;
    private Point point2;

    public Line() {
    }

    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(point1, line.point1) && Objects.equals(point2, line.point2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point1, point2);
    }

    @Override
    public String toString() {
        return "Line{" +
                "point1=" + point1 +
                ", point2=" + point2 +
                '}';
    }

   /* @Override
    public void drawToDXF(DXFDocument dxfDocument) {
        DXFLine line = new DXFLine();
        line.setStartPoint(point1.convert());
        line.setEndPoint(point2.convert());
        dxfDocument.addDXFEntity(line);
    }*/

    @Override
    public void drawToSVG(SVGBuilder svgBuilder) {

        String line = "<line x1=\"" + point1.x * svgBuilder.scale
                + "\" y1=\"" + point1.y * svgBuilder.scale + "\" x2=\"" + point2.x * svgBuilder.scale
                + "\" y2=\"" + point2.y * svgBuilder.scale+ "\" stroke-width=\"2\" vector-effect=\"non-scaling-stroke\" stroke=\"#b38600\"></line>";
        svgBuilder.append(line);
    }
}
