package me.massoudi.ai.activation;

public class OldActivationAdapter implements ActivationFunction {
    private OldActivation oldActivation;

    public OldActivationAdapter(OldActivation oldActivation) {
        this.oldActivation = oldActivation;
    }

    @Override
    public double activate(double input) {
        return oldActivation.calculate(input);
    }
}
