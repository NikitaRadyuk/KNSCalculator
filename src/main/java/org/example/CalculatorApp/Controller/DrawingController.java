package org.example.CalculatorApp.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.CalculatorApp.entity.Components.Influx;
import org.example.CalculatorApp.entity.Components.Pumps;
import org.example.CalculatorApp.entity.Point;
import org.example.CalculatorApp.entity.interfaces.IShape;
import org.example.CalculatorApp.services.EmptyParamCheck;
import org.example.CalculatorApp.services.SVGBuilder;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/calculator")
public class DrawingController extends HttpServlet {
    private static final String DIAM_KNS_PARAM = "diamKNS";
    private static final String INF1_VISIBILITY_PARAM = "inf1visibility";
    private static final String INF1_ANGLE_PARAM = "inf1Angle";
    private static final String DIAM_INF1_PARAM = "diamInf1";
    private static final String TRASH1_VISIBLE = "trash1Visible";
    private static final String INF2_VISIBILITY_PARAM = "inf2visibility";
    private static final String INF2_ANGLE_PARAM = "inf2Angle";
    private static final String DIAM_INF2_PARAM = "diamInf2";
    private static final String TRASH2_VISIBLE = "trash2Visible";
    private static final String DIAM_PRESSURE_LINES_PARAM = "diamPressureLines";
    private static final String TRASH_LENGTH_PARAM = "trashLength";
    private static final String TRASH_DEPTH_PARAM = "trashDepth";
    private static final String TRASH_HEIGHT_PARAM = "trashHeight";
    private static final String WELL_TO_PUMP_AXES_PARAM = "wellToPumpAxes";
    private static final String PRESSURE_TO_PUMP_AXES_PARAM = "pressureToPumpAxes";
    private static final String DIAM_PUMP_PARAM = "diamPump";
    private static final String DIAM_PIPE_BRANCH_PARAM = "diamPipeBranch";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String diamKNSparam = req.getParameter(DIAM_KNS_PARAM);
        String inf1visibilityParam = req.getParameter(INF1_VISIBILITY_PARAM);
        String inf1AngleParam = req.getParameter(INF1_ANGLE_PARAM);
        String diamInf1Param = req.getParameter(DIAM_INF1_PARAM);
        String trash1VisibilityParam = req.getParameter(TRASH1_VISIBLE);
        String inf2visibilityParam = req.getParameter(INF2_VISIBILITY_PARAM);
        String inf2AngleParam = req.getParameter(INF2_ANGLE_PARAM);
        String diamInf2Param = req.getParameter(DIAM_INF2_PARAM);
        String trash2VisibilityParam = req.getParameter(TRASH2_VISIBLE);
        String diamPressureLinesParam = req.getParameter(DIAM_PRESSURE_LINES_PARAM);
        String trashLengthParam = req.getParameter(TRASH_LENGTH_PARAM);
        String trashDepthParam = req.getParameter(TRASH_DEPTH_PARAM);
        String trashHeightParam = req.getParameter(TRASH_HEIGHT_PARAM);
        String wellToPumpAxesParam = req.getParameter(WELL_TO_PUMP_AXES_PARAM);
        String pressureToPumpAxesParam = req.getParameter(PRESSURE_TO_PUMP_AXES_PARAM);
        String diamPumpParam = req.getParameter(DIAM_PUMP_PARAM);
        String diamPipeBranchParam = req.getParameter(DIAM_PIPE_BRANCH_PARAM);

        Influx influx1 = new Influx();
        Influx influx2 = new Influx();

        if(diamKNSparam.isEmpty() || inf1visibilityParam.isEmpty() || inf1AngleParam.isEmpty() ||
        diamInf1Param.isEmpty() || trash1VisibilityParam.isEmpty() || inf2visibilityParam.isEmpty() ||
                inf2AngleParam.isEmpty() || diamInf2Param.isEmpty() || trash2VisibilityParam.isEmpty())
        {
                EmptyParamCheck.checkEmpty(diamKNSparam, inf1visibilityParam,
                inf1AngleParam, diamInf1Param, trash1VisibilityParam, inf2visibilityParam,
                inf2AngleParam, diamInf2Param, trash2VisibilityParam);
        }else{
            System.out.println("Something is wrong");
            //Influx1
            influx1.diamKNS = Double.valueOf(diamKNSparam);
            influx1.center = new Point(0,0);
            influx1.angle = Integer.valueOf(inf1AngleParam);
            influx1.diam = Double.valueOf(diamInf1Param);
            influx1.isVisible = Boolean.valueOf(inf1visibilityParam);
            influx1.trashDepth = Double.valueOf(trashDepthParam);
            influx1.trashHeight = Double.valueOf(trashHeightParam);
            influx1.trashLength = Double.valueOf(trashLengthParam);
            influx1.trashVisible = Boolean.valueOf(trash1VisibilityParam);

            //Influx2
            influx2.diamKNS = Double.valueOf(diamKNSparam);
            influx2.center = new Point(0,0);
            influx2.angle = Integer.valueOf(inf2AngleParam);
            influx2.diam = Double.valueOf(diamInf2Param);
            influx2.isVisible = Boolean.valueOf(inf2visibilityParam);
            influx2.trashDepth = Double.valueOf(trashDepthParam);
            influx2.trashHeight = Double.valueOf(trashHeightParam);
            influx2.trashLength = Double.valueOf(trashLengthParam);
            influx2.trashVisible = Boolean.valueOf(trash2VisibilityParam);
        }

        //Pumps
        Pumps pumps = new Pumps();
        pumps.pump1Visibility = true;
        pumps.pump2Visibility = true;
        pumps.angle = 0.0;
        pumps.diamPressureLine = Double.valueOf(diamPressureLinesParam);
        pumps.wellToPumpAxes = Double.valueOf(wellToPumpAxesParam);
        pumps.pressureToPumpAxes = Double.valueOf(pressureToPumpAxesParam);
        pumps.diamPump = Double.valueOf(diamPumpParam);
        pumps.AXLE_DISTANCE_PUMPS = 800.0;

        Pumps pumps1 = new Pumps();
        pumps1.pump1Visibility = true;
        pumps1.pump2Visibility = true;
        pumps1.angle = 0.0;
        pumps1.diamPressureLine = Double.valueOf(diamPressureLinesParam);
        pumps1.wellToPumpAxes = Double.valueOf(wellToPumpAxesParam);
        pumps1.pressureToPumpAxes = Double.valueOf(pressureToPumpAxesParam);
        pumps1.diamPump = Double.valueOf(diamPumpParam);
        pumps1.AXLE_DISTANCE_PUMPS = -800.0;


        List<IShape> shapes = influx2.draw();
        shapes.addAll(influx1.draw());
        shapes.addAll(pumps.draw());
        shapes.addAll(pumps1.draw());

        SVGBuilder svgBuilder = new SVGBuilder(1000,1000,3000.0,5000.0, new Point(1500,2000));
        for(
                IShape shape: shapes
        ){
            shape.drawToSVG(svgBuilder);
        }

        try{
            String svg = svgBuilder.build();
            req.setAttribute("svgData",svg);
            req.setAttribute("diamKNS",diamKNSparam);
            req.setAttribute("inf1visibility",inf1visibilityParam);
            req.setAttribute("inf1Angle",inf1AngleParam);
            req.setAttribute("diamInf1",diamInf1Param);
            req.setAttribute("trash1Visible",trash1VisibilityParam);
            req.setAttribute("inf2visibility",inf2visibilityParam);
            req.setAttribute("inf2Angle",inf2AngleParam);
            req.setAttribute("diamInf2",diamInf2Param);
            req.setAttribute("trash2Visibility",trash2VisibilityParam);
            req.setAttribute("diamPressureLines",diamPressureLinesParam);
            req.setAttribute("trashLength",trashLengthParam);
            req.setAttribute("trashDepth",trashDepthParam);
            req.setAttribute("trashHeight",trashHeightParam);
            req.setAttribute("wellToPumpAxes",wellToPumpAxesParam);
            req.setAttribute("pressureToPumpAxes",pressureToPumpAxesParam);
            req.setAttribute("diamPump",diamPumpParam);
            req.setAttribute("diamPipeBranch",diamPipeBranchParam);

            req.getRequestDispatcher("/ui/Calc.jsp").forward(req, resp);
        }catch (IllegalAccessError e){
            System.out.println("В контроллере что-то пошло не так");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
