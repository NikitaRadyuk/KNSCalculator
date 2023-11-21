package org.example.CalculatorApp.entity.interfaces;

import org.example.CalculatorApp.services.SVGBuilder;

public interface IShape {
     //void drawToDXF(DXFDocument dxfDocument);
     void drawToSVG(SVGBuilder svgBuilder);
}
