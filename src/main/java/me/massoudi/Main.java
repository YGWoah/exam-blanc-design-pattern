package me.massoudi;


import me.massoudi.ai.NeuralNetwork;
import me.massoudi.ai.activation.IdentityActivation;
import me.massoudi.ai.activation.SigmoidActivation;
import me.massoudi.ai.layers.HiddenLayer;
import me.massoudi.ai.layers.InputLayer;
import me.massoudi.ai.layers.OutputLayer;
import me.massoudi.ascpects.security.SecuredBy;
import me.massoudi.security.SecurityContext;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // Set up the security context
        Set<String> roles = new HashSet<>();
        roles.add("USER");
        SecurityContext.setUser("john_doe", roles);

        // Create an instance of the service
        SomeService service = new SomeService();

        // Call methods with security checks
        try {
            service.userMethod(); // This should pass
            service.adminMethod(); // This should throw a SecurityException
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }

        // Neural network setup and prediction
        NeuralNetwork network = new NeuralNetwork();

        // Create and add layers
        InputLayer inputLayer = new InputLayer(3);
        HiddenLayer hiddenLayer = new HiddenLayer(5, new SigmoidActivation());
        OutputLayer outputLayer = new OutputLayer(2, new IdentityActivation());

        network.addLayer(inputLayer);
        network.addLayer(hiddenLayer);
        network.addLayer(outputLayer);

        // Dynamically change activation functions using Strategy Pattern
        network.setActivationFunctionForLayer(1, new IdentityActivation()); // Hidden Layer
        network.setActivationFunctionForLayer(2, new SigmoidActivation()); // Output Layer

        // Provide inputs
        double[] input = {0.5, 0.8, 0.2};

        double[] output = network.predict(input);

        System.out.println("Output: " + Arrays.toString(output));
    }
}

class SomeService {

    @SecuredBy(roles = {"ADMIN"})
    public void adminMethod() {
        System.out.println("Admin method executed.");
    }

    @SecuredBy(roles = {"USER", "ADMIN"})
    public void userMethod() {
        System.out.println("User method executed.");
    }
}
