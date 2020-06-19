package com.javamodule.model;
import com.javamodule.object.Dividend;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class EuropeanBlackScholesModel {

    private double K, r, S, q, sigma, t, d1, d2, F;

    public EuropeanBlackScholesModel(double K, double r, double S, double q, double sigma, double t)
    {
        this.K = K;
        this.S = S;
        this.r = r;
        this.q = q;
        this.sigma = sigma;
        this.t = t;
        this.F = S * Math.exp((r - q) * t);
        this.d1 = (Math.log(S / K) + (r - q + 0.5 * sigma * sigma) * t) / (sigma * Math.sqrt(t));
        this.d2 = this.d1 - sigma * Math.sqrt(t);
    }

    public EuropeanBlackScholesModel(double K, double r, double S, double q, double sigma, double t, ArrayList<Dividend> divs)
    {
        for (Dividend div : divs)
        {
            double divDate = div.getDate();
            if (divDate < t)
                S -= div.getAmount() * Math.exp(-(r - q) * divDate);
        }
        this.K = K;
        this.S = S;
        this.r = r;
        this.q = q;
        this.sigma = sigma;
        this.t = t;
        this.F = S * Math.exp((r - q) * t);
        this.d1 = (Math.log(S / K) + (r - q + 0.5 * sigma * sigma) * t) / (sigma * Math.sqrt(t));
        this.d2 = this.d1 - sigma * Math.sqrt(t);
    }

    public double callPrice()
    {
        return Math.exp(-r * t) * (F * JavaMath.cdfNorm(d1) - K * JavaMath.cdfNorm(d2));
    }

    public double putPrice()
    {
        return Math.exp(-r * t) * (K * JavaMath.cdfNorm(-d2) - F * JavaMath.cdfNorm(-d1));
    }

    public static void main(String[] args)
    {
        EuropeanBlackScholesModel EBS = new EuropeanBlackScholesModel(250, 0.03, 300, 0.01, 0.15, 1);
        System.out.println(EBS.callPrice());
        System.out.println(EBS.putPrice());
    }
}

