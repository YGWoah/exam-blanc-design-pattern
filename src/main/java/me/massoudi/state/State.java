package me.massoudi.state;

import me.massoudi.ai.NeuralNetwork;

public interface State {
    void train(NeuralNetwork network);
    void predict(NeuralNetwork network, double[] input);
    void fit(NeuralNetwork network);
}


// TrainingState and TrainedState follow a similar structure
