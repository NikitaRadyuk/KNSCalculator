package org.example.CalculatorApp.services;

public class EmptyParamCheck {
    public static void checkEmpty(String diamKNSparam,
        String inf1visibilityParam,
        String inf1AngleParam,
        String diamInf1Param,
        String trash1Visibility,
        String inf2visibilityParam,
        String inf2AngleParam,
        String diamInf2Param,
        String trash2Visibility){
        if(diamKNSparam.isEmpty() ){
            diamKNSparam = "1250.0";
        }
        if(inf1visibilityParam.isEmpty()){
            inf1visibilityParam = "true";
        }
        if(inf1AngleParam.isEmpty()){
            inf1AngleParam = "60";
        }
        if(diamInf1Param.isEmpty()){
            diamInf1Param = "250.0";
        }
        if (trash1Visibility.isEmpty()){
            trash1Visibility = "true";
        }
        if (inf2visibilityParam.isEmpty()){
            inf2visibilityParam = "true";
        }
        if(inf2AngleParam.isEmpty()){
            inf2AngleParam = "120";
        }
        if(diamInf2Param.isEmpty()){
            diamInf2Param = "250.0";
        }
        if(trash2Visibility.isEmpty()){
            trash2Visibility = "true";
        }
    }
}
