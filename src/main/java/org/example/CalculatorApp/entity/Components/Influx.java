package org.example.CalculatorApp.entity.Components;

import org.example.CalculatorApp.entity.Circle;
import org.example.CalculatorApp.entity.Line;
import org.example.CalculatorApp.entity.Point;
import org.example.CalculatorApp.entity.interfaces.IComponent;
import org.example.CalculatorApp.entity.interfaces.IShape;

import java.util.ArrayList;
import java.util.List;

public class Influx implements IComponent {
    public Point center;
    public Boolean isVisible;
    public Integer angle;
    public Double diam;
    public Double diamKNS;
    private final Double INFLUX_LENGTH = 900.0;
    public Double trashLength;
    public Double trashHeight;
    public Double trashDepth;
    public final Double TRASH_FASTENING = 125.0;
    public Boolean trashVisible;

    public Influx() {
    }

    public Influx(Boolean isVisible, Integer angle, Double diam, Double diamKNS, Double trashLength, Double trashHeight, Double trashDepth, Boolean trashVisible) {
        this.isVisible = isVisible;
        this.angle = angle;
        this.diam = diam;
        this.diamKNS = diamKNS;
        this.trashLength = trashLength;
        this.trashHeight = trashHeight;
        this.trashDepth = trashDepth;
        this.trashVisible = trashVisible;
    }

    private List<IShape> drawWell(){
        List<IShape> well = new ArrayList<>();
        well.add(new Circle(diamKNS,new Point(0,0)));
        well.add(new Circle(diamKNS-75,new Point(0,0)));
        return well;
    }

    private List<IShape> drawTrash(){
        List<IShape> musor = new ArrayList<>();

        List<Point> points = new ArrayList<>();

        Double cos = Math.cos(-angle * Math.PI/180);
        Double sin = Math.sin(-angle * Math.PI/180);

        points.add(new Point(diamKNS - 125, trashHeight/2));
        points.add(new Point(diamKNS - 125, -trashHeight/2));
        points.add(new Point(diamKNS - trashLength - 125, -trashHeight/2));
        points.add(new Point(diamKNS - trashLength - 125, trashHeight/2));
        points.add(new Point(diamKNS - TRASH_FASTENING - 125, trashHeight/2));
        points.add(new Point(diamKNS - TRASH_FASTENING - 125, -trashHeight/2));

        for (var p:
             points) {
            Double x = p.x;
            Double y = p.y;
            p.x = x * cos - y * sin + center.x;
            p.y = x*sin + y*cos + center.y;
        }
        musor.add(new Line(points.get(0), points.get(1)));
        musor.add(new Line(points.get(1), points.get(2)));
        musor.add(new Line(points.get(2), points.get(3)));
        musor.add(new Line(points.get(3), points.get(0)));
        musor.add(new Line(points.get(4), points.get(5)));


        return musor;
    }

    private List<IShape> drawInflux(){
        List<IShape> influx = new ArrayList<>();
        Double cos = Math.cos(-angle * Math.PI/180);
        Double sin = Math.sin(-angle * Math.PI/180);

        List<Point> points = new ArrayList<>();

        points.add(new Point(diamKNS - TRASH_FASTENING - 125, -diam/2));
        points.add(new Point(diamKNS - TRASH_FASTENING - 125, diam/2));
        points.add(new Point(diamKNS - TRASH_FASTENING + INFLUX_LENGTH - 125, diam/2));
        points.add(new Point(diamKNS - TRASH_FASTENING + INFLUX_LENGTH - 125, -diam/2));

        for (var p:
                points) {
            Double x = p.x;
            Double y = p.y;
            p.x = x * cos - y * sin + center.x;
            p.y = x*sin + y*cos + center.y;
        }

        influx.add(new Line(points.get(0), points.get(1)));
        influx.add(new Line(points.get(1), points.get(2)));
        influx.add(new Line(points.get(2), points.get(3)));
        influx.add(new Line(points.get(3), points.get(0)));

        return influx;
    }

    @Override
    public List<IShape> draw() {
        List<IShape> influx = new ArrayList<>();
        if(!isVisible){
            return influx;
        }
        if(trashVisible){
            influx.addAll(drawTrash());
        }

        influx.addAll(drawWell());

        influx.addAll(drawInflux());

        return influx;
    }
}
