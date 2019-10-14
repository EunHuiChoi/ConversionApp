package com.example.conversionapp;

public class Conversion {

    public String ResultToCenti(String sInch, String sFoot, String sMile) {
        try {
            double inch = Double.parseDouble(sInch);
            double foot = Double.parseDouble(sFoot);
            double mile = Double.parseDouble(sMile);

            double centi = (inch * 2.54) + (foot * 30.48) + (mile * 160934.4);

            return String.format("%3.2f", centi);
        } catch (NumberFormatException nfe) {
            return "ERR";
        }
    }
}
