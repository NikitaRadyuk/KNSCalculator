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
    public Double angle;
    public Double AXLE_DISTANCE_PUMPS;
    public Double wellToPumpAxes;   //колодец-насос
    public Double pressureToPumpAxes;       //напор-насос
    public Double diamPump;
    public Double diamPressureLine;
    //public Double offsetPressureLine;
    public Boolean pressure1Visibility;
    public Boolean pressure2Visibility;
    public Double anglePressure1;
    public Double anglePressure2;

    //public Double diamPipeBranch;   //патрубок
    //public Double heightPump;
    //public Double heightPumpToPressureFlange;
    //public Double heightKNSToBottomPump;
    //public Double weightPump;


    private List<IShape> drawPump(){
        List<IShape> pump = new ArrayList<>();

        List<Point> points = new ArrayList<>();

        points.add(new Point(AXLE_DISTANCE_PUMPS/2 + diamPump/4,wellToPumpAxes + pressureToPumpAxes));                                                                  //0
        points.add(new Point(AXLE_DISTANCE_PUMPS/2 + diamPump/4,wellToPumpAxes + pressureToPumpAxes - 20));                                                             //1
        points.add(new Point(AXLE_DISTANCE_PUMPS/2 - diamPump/4,wellToPumpAxes + pressureToPumpAxes - 20));                                                             //2
        points.add(new Point(AXLE_DISTANCE_PUMPS/2 - diamPump/4,wellToPumpAxes + pressureToPumpAxes));                                                                  //3

        points.add(new Point(AXLE_DISTANCE_PUMPS/2 + diamPump/4 - 10,wellToPumpAxes + pressureToPumpAxes - 20));                                                        //4
        points.add(new Point(AXLE_DISTANCE_PUMPS/2 + diamPump/4 - 10,wellToPumpAxes + pressureToPumpAxes - 20 - 40));                                                   //5
        points.add(new Point(AXLE_DISTANCE_PUMPS/2 - diamPump/4 + 10,wellToPumpAxes + pressureToPumpAxes - 20 - 40));                                                   //6
        points.add(new Point(AXLE_DISTANCE_PUMPS/2 - diamPump/4 + 10,wellToPumpAxes + pressureToPumpAxes - 20));                                                        //7

        points.add(new Point(AXLE_DISTANCE_PUMPS/2 + diamPump/4,wellToPumpAxes + pressureToPumpAxes - 20 - 40));                                                        //8
        points.add(new Point(AXLE_DISTANCE_PUMPS/2 + diamPump/4,wellToPumpAxes + pressureToPumpAxes - 20 - 40 - 40));                                                   //9
        points.add(new Point(AXLE_DISTANCE_PUMPS/2 - diamPump/4,wellToPumpAxes + pressureToPumpAxes - 20 - 40 - 40));                                                   //10
        points.add(new Point(AXLE_DISTANCE_PUMPS/2 - diamPump/4,wellToPumpAxes + pressureToPumpAxes - 20 - 40));                                                        //11

        points.add(new Point(AXLE_DISTANCE_PUMPS/2 + diamPump/4 - 20,wellToPumpAxes + pressureToPumpAxes - 20 - 40 - 40));                                              //12
        points.add(new Point(AXLE_DISTANCE_PUMPS/2 + diamPump/4 - 20,wellToPumpAxes + pressureToPumpAxes - 20 - 40 - 40 - 40));                                         //13
        points.add(new Point(AXLE_DISTANCE_PUMPS/2 - diamPump/4 + 20,wellToPumpAxes + pressureToPumpAxes - 20 - 40 - 40 - 40));                                         //14
        points.add(new Point(AXLE_DISTANCE_PUMPS/2 - diamPump/4 + 20,wellToPumpAxes + pressureToPumpAxes - 20 - 40 - 40));                                              //15

        points.add(new Point(AXLE_DISTANCE_PUMPS/2, wellToPumpAxes + diamPump/2));                                                                                      //16

        Double angTangent = Math.PI/2 - Math.atan((points.get(13).x - AXLE_DISTANCE_PUMPS/2)/(wellToPumpAxes + pressureToPumpAxes - 20 - 40 - 40 - 40))
                            - Math.acos((diamPump/2)/(Math.sqrt(Math.pow(points.get(13).x - AXLE_DISTANCE_PUMPS/2,2)
                            + Math.pow((wellToPumpAxes + pressureToPumpAxes - 20 - 40 - 40 - 40),2))));

        points.add(new Point(AXLE_DISTANCE_PUMPS/2 + diamPump/2 * Math.cos(angTangent),wellToPumpAxes + diamPump/2 * Math.sin(angTangent)));                            //17

        points.add(new Point(AXLE_DISTANCE_PUMPS/2,wellToPumpAxes + pressureToPumpAxes + diamPressureLine));                                                            //18
        points.add(new Point(AXLE_DISTANCE_PUMPS/5,wellToPumpAxes + pressureToPumpAxes + diamPressureLine));                                                            //19
        points.add(new Point(AXLE_DISTANCE_PUMPS/5,wellToPumpAxes + pressureToPumpAxes));                                                                               //20
        points.add(new Point(AXLE_DISTANCE_PUMPS/2,wellToPumpAxes + pressureToPumpAxes));                                                                               //21

        points.add(new Point(AXLE_DISTANCE_PUMPS/5,wellToPumpAxes + pressureToPumpAxes + diamPressureLine + 50));                                                       //22
        points.add(new Point(AXLE_DISTANCE_PUMPS/5,wellToPumpAxes + pressureToPumpAxes - 50));                                                                          //23

        points.add(new Point(AXLE_DISTANCE_PUMPS/5 - AXLE_DISTANCE_PUMPS/15,wellToPumpAxes + pressureToPumpAxes - 50));                                                 //24
        points.add(new Point(AXLE_DISTANCE_PUMPS/5 - AXLE_DISTANCE_PUMPS/15,wellToPumpAxes + pressureToPumpAxes + diamPressureLine + 50));                              //25

        points.add(new Point(AXLE_DISTANCE_PUMPS/5 - AXLE_DISTANCE_PUMPS/15,wellToPumpAxes + pressureToPumpAxes - 25));                                                 //26
        points.add(new Point(AXLE_DISTANCE_PUMPS/5 - AXLE_DISTANCE_PUMPS/15,wellToPumpAxes + pressureToPumpAxes + diamPressureLine + 25));                              //27
        points.add(new Point(0,wellToPumpAxes + pressureToPumpAxes - 25));                                                                                              //28
        points.add(new Point(0,wellToPumpAxes + pressureToPumpAxes + diamPressureLine + 25));                                                                           //29

        points.add(new Point(AXLE_DISTANCE_PUMPS/5 - AXLE_DISTANCE_PUMPS/15,wellToPumpAxes + pressureToPumpAxes + diamPressureLine/2));                                 //30
        points.add(new Point(0,wellToPumpAxes + pressureToPumpAxes + diamPressureLine/2));                                                                              //31




        pump.add(new Circle(diamPump/2,new Point(AXLE_DISTANCE_PUMPS/2, wellToPumpAxes)));
        pump.add(new Circle(diamPump/4,new Point(AXLE_DISTANCE_PUMPS/2, wellToPumpAxes)));
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

        pump.add(new Line(points.get(14),points.get(16)));
        pump.add(new Line(points.get(13),points.get(17)));

        pump.add(new Line(points.get(18),points.get(19)));
        pump.add(new Line(points.get(20),points.get(21)));
        pump.add(new Circle(diamPressureLine/2, new Point(AXLE_DISTANCE_PUMPS/2, wellToPumpAxes + pressureToPumpAxes + diamPressureLine/2)));
        pump.add(new Circle(diamPressureLine/4, new Point(AXLE_DISTANCE_PUMPS/2, wellToPumpAxes + pressureToPumpAxes + diamPressureLine/2)));

        pump.add(new Line(points.get(22),points.get(23)));
        pump.add(new Line(points.get(25),points.get(24)));
        pump.add(new Line(points.get(22),points.get(25)));
        pump.add(new Line(points.get(24),points.get(23)));
        pump.add(new Line(points.get(26),points.get(28)));
        pump.add(new Line(points.get(27),points.get(29)));
        pump.add(new Line(points.get(30),points.get(31)));





        pump.add(new Line(new Point(20,0),new Point(-20,0)));
        pump.add(new Line(new Point(0,20),new Point(0,-20)));

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
        pumps.addAll(drawPump());
        return pumps;
    }
}
