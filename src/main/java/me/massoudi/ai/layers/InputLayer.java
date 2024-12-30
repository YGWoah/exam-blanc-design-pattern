package me.massoudi.ai.layers;

import me.massoudi.ai.Neuron;

public class InputLayer extends Layer {

    public InputLayer(int numberOfNeurons) {
        for (int i = 0; i < numberOfNeurons; i++) {
            neurons.add(new Neuron(null)); // No activation function for input neurons
        }
    }

    @Override
    public double[] computeOutputs(double[] inputs) {
        if (inputs.length != neurons.size()) {
            throw new IllegalArgumentException("Input size must match the number of neurons in the input layer.");
        }
        return inputs; // Simply pass the inputs as outputs
    }
}
