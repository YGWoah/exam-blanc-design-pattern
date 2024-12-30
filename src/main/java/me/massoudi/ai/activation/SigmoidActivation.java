package me.massoudi.ai.activation;

public class SigmoidActivation implements ActivationFunction {
    @Override
    public double activate(double input) {
        return 1 / (1 + Math.exp(-input));
    }
}
