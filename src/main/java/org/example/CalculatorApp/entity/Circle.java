package org.example.CalculatorApp.entity;

import org.example.CalculatorApp.entity.interfaces.IShape;
import org.example.CalculatorApp.services.SVGBuilder;

import java.util.Objects;

public class Circle implements IShape {
    private Double radius;
    private Point centerPoint;

    public Circle() {
    }

    public Circle(Double radius, Point centerPoint) {
        this.radius = radius;
        this.centerPoint = centerPoint;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius && Objects.equals(centerPoint, circle.centerPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, centerPoint);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", centerPoint=" + centerPoint +
                '}';
    }

    /*@Override
    public void drawToDXF(DXFDocument dxfDocument) {
        DXFCircle circle = new DXFCircle();
        circle.setCenterPoint(centerPoint.convert());
        circle.setRadius(radius);
        dxfDocument.addDXFEntity(circle);
    }*/

    @Override
    public void drawToSVG(SVGBuilder svgBuilder) {
        String circle = "<circle cx=\"" + centerPoint.x * svgBuilder.scale
                + "\" cy=\"" + centerPoint.y * svgBuilder.scale
                + "\" r=\"" + radius * svgBuilder.scale + "\" fill=\"none\" stroke=\"#b38600\" vector-effect=\"non-scaling-stroke\" stroke-width=\"2\"></circle>";
        svgBuilder.append(circle);
    }
}
