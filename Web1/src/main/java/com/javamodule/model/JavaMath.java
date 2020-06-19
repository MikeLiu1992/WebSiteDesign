package com.javamodule.model;

public class JavaMath {

    final static double SQRT2 = 1.4142135623730950488016887;

    public static double errIntegration(double x, double t)
    {
        return t * Math.exp(- x * x  - 1.26551223 + t * (1.00002368 + t * (0.37409196
                + t * (0.09678418 - t * (0.18628806 - t * (0.27886807
                - t * (1.13520398 - t * (1.48851587 - t * (0.82215223 - t * 0.17087277)))))))));
    }
    public static double erfunc(double x)
    {
        double t = 0;
        if (x >= 0)
        {
            t = 1 / (1 + 0.5 * x);
            return 1 - errIntegration(x, t);
        }
        else
        {
            t = 1 / (1 - 0.5 * x);
            return errIntegration(x, t) - 1;
        }
    }

    public static double cdfNorm(double x)
    {
        return (erfunc(x / SQRT2) + 1) / 2;
    }
}
