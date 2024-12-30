package me.massoudi.ai.activation;

public class IdentityActivation implements ActivationFunction {
    @Override
    public double activate(double input) {
//        System.out.println("kk");
        return input;
    }
}
