package me.massoudi.state;

import me.massoudi.ai.NeuralNetwork;

public class ConstructionState implements State {
    @Override
    public void train(NeuralNetwork network) {
        network.setState(new TrainingState());
        System.out.println("Network is now training.");
    }

    @Override
    public void predict(NeuralNetwork network, double[] input) {
        throw new IllegalStateException("Cannot predict in Construction state.");
    }

    @Override
    public void fit(NeuralNetwork network) {
        network.setState(new TrainedState());
        System.out.println("Network is now trained.");
    }
}
