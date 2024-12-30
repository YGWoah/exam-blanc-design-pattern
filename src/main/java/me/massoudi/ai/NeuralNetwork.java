package me.massoudi.ai;

import me.massoudi.ai.activation.ActivationFunction;
import me.massoudi.ai.layers.Layer;
import me.massoudi.state.State;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork {
    private List<Layer> layers;
    private State state;

    public NeuralNetwork() {
        this.layers = new ArrayList<>();
    }

    public void addLayer(Layer layer) {
        if (!layers.isEmpty()) {
            // Get the last added layer
            Layer previousLayer = layers.get(layers.size() - 1);

            // Connect each neuron in the new layer to each neuron in the previous layer
            for (Neuron neuron : layer.getNeurons()) {
                List<Connection> connections = new ArrayList<>();
                for (Neuron prevNeuron : previousLayer.getNeurons()) {
                    // Create a connection from the previous layer's neuron to the current neuron
                    connections.add(new Connection(prevNeuron, Math.random())); // Random weight
                }
                neuron.setInputs(connections);
            }
        }
        layers.add(layer);
    }

    public void setActivationFunctionForLayer(int layerIndex, ActivationFunction activationFunction) {
        if (layerIndex < 0 || layerIndex >= layers.size()) {
            throw new IllegalArgumentException("Invalid layer index");
        }
        for (Neuron neuron : layers.get(layerIndex).getNeurons()) {
            neuron.setActivationFunction(activationFunction);
        }
    }

    public double[] predict(double[] input) {
        double[] outputs = input;
        for (Layer layer : layers) {
            outputs = layer.computeOutputs(outputs);
        }
        return outputs;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
