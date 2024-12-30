package me.massoudi.ai.layers;

import me.massoudi.ai.Neuron;
import me.massoudi.ai.activation.ActivationFunction;

public class HiddenLayer extends Layer {

    public HiddenLayer(int numberOfNeurons, ActivationFunction activationFunction) {
        for (int i = 0; i < numberOfNeurons; i++) {
            neurons.add(new Neuron(activationFunction));
        }
    }

    @Override
    public double[] computeOutputs(double[] inputs) {
        double[] outputs = new double[neurons.size()];
        for (int i = 0; i < neurons.size(); i++) {
            outputs[i] = neurons.get(i).compute(inputs);
        }
        return outputs;
    }
}
