package org.example.CalculatorApp.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.CalculatorApp.entity.Components.Influx;
import org.example.CalculatorApp.entity.Point;
import org.example.CalculatorApp.entity.interfaces.IShape;
import org.example.CalculatorApp.services.SVGBuilder;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/calculator")
public class DrawingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Influx influx = new Influx();
        influx.center = new Point(1500,1500);
        influx.angle = 60;
        influx.diam = 250.0;
        influx.diamKNS = 2500.0;
        influx.isVisible = true;
        influx.trashDepth = 450.0;
        influx.trashHeight = 450.0;
        influx.trashLength = 450.0;
        influx.trashVisible = true;

        List<IShape> shapes = influx.draw();

        SVGBuilder svgBuilder = new SVGBuilder();
        for(
                IShape shape: shapes
        ){
            shape.drawToSVG(svgBuilder);
        }

        try{
            String svg = svgBuilder.build();
            req.setAttribute("svgData",svg);
            req.getRequestDispatcher("/ui/Calc.jsp").forward(req, resp);
        }catch (IllegalAccessError e){

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
