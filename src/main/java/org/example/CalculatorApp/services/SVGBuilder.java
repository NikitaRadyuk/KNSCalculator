package org.example.CalculatorApp.services;

import org.example.CalculatorApp.entity.Point;

public class SVGBuilder {
    StringBuilder builder;

    public Double scale;

    public SVGBuilder(
    Integer widthPx,
    Integer heightPx,
    Double widthMM,
    Double heightMM,
    Point center) {
        scale = Math.max(widthPx,heightPx)/(Math.max(widthMM,heightMM));
        builder = new StringBuilder("<svg id=\"container\" style=\"width:" + widthPx + "; height:" + heightPx +"\" onload=\"init(evt)\"><g transform=\"translate(" + center.x * scale +
                ", " + center.y * scale + ")\">\n"
        );

    }

    public String build(){
        return builder.append(
                "</g></svg>").toString();
    }

    public void append(String line){
        builder.append(line);
    }
}
