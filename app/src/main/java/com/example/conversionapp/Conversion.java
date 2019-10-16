package com.example.conversionapp;

public class Conversion {

    public String ResultToCenti(String sInch, String sFoot, String sMile) {
        try {
            double inch;
            double foot;
            double mile;
            if(sInch.isEmpty()){
                inch = 0.0;
            }else{
                inch = Double.parseDouble(sInch);
            }
            if(sFoot.isEmpty()){
                foot = 0.0;
            }else{
                foot = Double.parseDouble(sFoot);
            }
            if(sMile.isEmpty()){
                mile = 0.0;
            }else{
                mile = Double.parseDouble(sMile);
            }
            double centi = (inch * 2.54) + (foot * 30.48) + (mile * 160934.4);

            return String.format("%3.2f", centi);

        } catch (NumberFormatException nfe) {
            return "ERR";
        }
    }
}
