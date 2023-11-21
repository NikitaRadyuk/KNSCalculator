package org.example.CalculatorApp.services;

public class SVGBuilder {
    StringBuilder builder;

    public SVGBuilder() {
        builder = new StringBuilder("<svg id=\"container\" style=\"width:5000; height:5000\" onload=\"init(evt)\">\n"
        );
    }

    public String build(){
        return builder.append(
                "</svg>").toString();
    }

    public void append(String line){
        builder.append(line);
    }
}
