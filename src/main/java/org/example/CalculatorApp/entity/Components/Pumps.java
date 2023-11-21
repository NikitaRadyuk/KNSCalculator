package org.example.CalculatorApp.entity.Components;

import org.example.CalculatorApp.entity.Circle;
import org.example.CalculatorApp.entity.Line;
import org.example.CalculatorApp.entity.Point;
import org.example.CalculatorApp.entity.interfaces.IComponent;
import org.example.CalculatorApp.entity.interfaces.IShape;

import java.util.ArrayList;
import java.util.List;

public class Pumps implements IComponent {
    public Boolean pump1Visibility;
    public Boolean pump2Visibility;
    public Integer angle;
    public Double diamPressureLine;

    public final Double AXLE_DISTANCE_PUMPS = 800.0;
    public Double wellToPumpAxes;   //колодец-насос
    public Double pressureToPumpAxes;       //напор-насос
    public Double diamPump;
    public Double diamPipeBranch;   //патрубок
    public Double heightPump;
    public Double heightPumpToPressureFlange;
    public Double heightKNSToBottomPump;
    public Double weightPump;

    //вспомогательные параметры



    private List<IShape> drawPressureLines(){
        List<IShape> pressureLines = new ArrayList<>();
        Double cos = Math.cos(angle);
        Double sin = Math.sin(angle);


        return pressureLines;
    }

    private List<IShape> drawPump(){
        List<IShape> pump = new ArrayList<>();

        List<Point> points = new ArrayList<>();

        points.add(new Point(AXLE_DISTANCE_PUMPS/2 + diamPump/4,wellToPumpAxes + pressureToPumpAxes));                                  //0
        points.add(new Point(AXLE_DISTANCE_PUMPS/2 + diamPump/4,wellToPumpAxes + pressureToPumpAxes - 20));                             //1
        points.add(new Point(AXLE_DISTANCE_PUMPS/2 - diamPump/4,wellToPumpAxes + pressureToPumpAxes));                                  //2
        points.add(new Point(AXLE_DISTANCE_PUMPS/2 - diamPump/4,wellToPumpAxes + pressureToPumpAxes - 20));                             //3

        points.add(new Point(AXLE_DISTANCE_PUMPS/2 + diamPump/4 - 10,wellToPumpAxes + pressureToPumpAxes - 20));                        //4
        points.add(new Point(AXLE_DISTANCE_PUMPS/2 + diamPump/4 - 10,wellToPumpAxes + pressureToPumpAxes - 20 - 40));                   //5
        points.add(new Point(AXLE_DISTANCE_PUMPS/2 - diamPump/4 + 10,wellToPumpAxes + pressureToPumpAxes - 20 - 40));                   //6
        points.add(new Point(AXLE_DISTANCE_PUMPS/2 - diamPump/4 + 10,wellToPumpAxes + pressureToPumpAxes - 20));                        //7

        points.add(new Point(AXLE_DISTANCE_PUMPS/2 + diamPump/4,wellToPumpAxes + pressureToPumpAxes - 20 - 40));                        //8
        points.add(new Point(AXLE_DISTANCE_PUMPS/2 + diamPump/4,wellToPumpAxes + pressureToPumpAxes - 20 - 40 - 40));                   //9
        points.add(new Point(AXLE_DISTANCE_PUMPS/2 - diamPump/4,wellToPumpAxes + pressureToPumpAxes - 20 - 40 - 40));                   //10
        points.add(new Point(AXLE_DISTANCE_PUMPS/2 - diamPump/4,wellToPumpAxes + pressureToPumpAxes - 20 - 40));                        //11

        points.add(new Point(AXLE_DISTANCE_PUMPS/2 + diamPump/4 - 20,wellToPumpAxes + pressureToPumpAxes - 20 - 40 - 40));              //12
        points.add(new Point(AXLE_DISTANCE_PUMPS/2 + diamPump/4 - 20,wellToPumpAxes + pressureToPumpAxes - 20 - 40 - 40 - 40));         //13
        points.add(new Point(AXLE_DISTANCE_PUMPS/2 - diamPump/4 + 20,wellToPumpAxes + pressureToPumpAxes - 20 - 40 - 40 - 40));         //14
        points.add(new Point(AXLE_DISTANCE_PUMPS/2 - diamPump/4 + 20,wellToPumpAxes + pressureToPumpAxes - 20 - 40 - 40));              //15




        pump.add(new Circle(diamPump/2,new Point(AXLE_DISTANCE_PUMPS/2, -wellToPumpAxes)));
        pump.add(new Circle(diamPump/4,new Point(AXLE_DISTANCE_PUMPS/2, -wellToPumpAxes)));
        pump.add(new Line(points.get(0),points.get(1)));
        pump.add(new Line(points.get(1),points.get(2)));
        pump.add(new Line(points.get(2),points.get(3)));
        pump.add(new Line(points.get(3),points.get(0)));

        pump.add(new Line(points.get(4),points.get(5)));
        pump.add(new Line(points.get(5),points.get(6)));
        pump.add(new Line(points.get(6),points.get(7)));
        pump.add(new Line(points.get(7),points.get(4)));

        pump.add(new Line(points.get(8),points.get(9)));
        pump.add(new Line(points.get(9),points.get(10)));
        pump.add(new Line(points.get(10),points.get(11)));
        pump.add(new Line(points.get(11),points.get(8)));

        pump.add(new Line(points.get(12),points.get(13)));
        pump.add(new Line(points.get(13),points.get(14)));
        pump.add(new Line(points.get(14),points.get(15)));
        pump.add(new Line(points.get(15),points.get(12)));




        return pump;
    }

    @Override
    public List<IShape> draw() {
        List<IShape> pumps = new ArrayList<>();
        if(!pump1Visibility){
            return pumps;
        }
        if(!pump2Visibility){
            return pumps;
        }
        //pumps.addAll()
        return pumps;
    }
}
