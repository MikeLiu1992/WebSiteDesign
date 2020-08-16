package com.javamodule.model;

public class VanillaAPIEntry {
    native double EuropeanBlackScholesCall(double K, double r, double S, double q, double sigma, double t);
    native double EuropeanBlackScholesPut(double K, double r, double S, double q, double sigma, double t);
    native double AmericanVanillaCall(double K, double r, double S, double q, double sigma, double t);
    native double AmericanVanillaPut(double K, double r, double S, double q, double sigma, double t);

    static
    {
        System.loadLibrary("QuantModule");
        System.loadLibrary("OptionPricing");
    }

    public static void main(String args[])
    {
        VanillaAPIEntry obj = new VanillaAPIEntry();
        System.out.println(obj.EuropeanBlackScholesCall(250, 0.03, 300, 0, 0.15, 1));
        System.out.println(obj.EuropeanBlackScholesPut(250, 0.03, 300, 0, 0.15, 1));
        System.out.println(obj.AmericanVanillaCall(250, 0.03, 250, 0, 0.15, 1));
        System.out.println(obj.AmericanVanillaPut(250, 0.03, 250, 0, 0.15, 1));
    }
}
