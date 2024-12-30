package me.massoudi.ai;

import me.massoudi.ai.activation.ActivationFunction;

import java.util.List;

public class Neuron {
    private List<Connection> inputs;
    private ActivationFunction activationFunction;

    public Neuron(ActivationFunction activationFunction) {
        this.activationFunction = activationFunction;
    }

    public void setInputs(List<Connection> inputs) {
        this.inputs = inputs;
    }

    public void setActivationFunction(ActivationFunction activationFunction) {
        this.activationFunction = activationFunction; // Strategy Pattern: Change behavior dynamically
    }

    public double compute(double[] inputValues) {
        double sum = 0.0;
        for (int i = 0; i < inputs.size(); i++) {
            sum += inputValues[i] * inputs.get(i).getWeight();
        }
        return activationFunction.activate(sum);
    }
}
