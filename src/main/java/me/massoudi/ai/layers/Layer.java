package me.massoudi.ai.layers;

import me.massoudi.ai.Neuron;

import java.util.ArrayList;
import java.util.List;

public abstract class Layer {
    protected List<Neuron> neurons;

    public Layer() {
        this.neurons = new ArrayList<>();
    }

    public List<Neuron> getNeurons() {
        return neurons;
    }

    public void addNeuron(Neuron neuron) {
        neurons.add(neuron);
    }

    public abstract double[] computeOutputs(double[] inputs);
}
