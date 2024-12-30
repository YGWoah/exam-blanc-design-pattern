package me.massoudi.ai.activation;

public class SoftMaxActivation implements ActivationFunction {
    @Override
    public double activate(double input) {
        return Math.max(1, input);
    }
}
