package skittishsloth.ai.nn;

import skittishsloth.ai.nn.activation.ActivationFunction;

public class Layer {
    private final Neuron[] neurons;

    public Layer(final Neuron[] neurons) {
        this.neurons = neurons;
    }

    public Layer(final ActivationFunction activationFunction, final int numNeurons, final int numInputs) {
        this.neurons = new Neuron[numNeurons];
        for (int i = 0; i < numNeurons; i++) {
            double[] weights = new double[numInputs];
            // Initialize weights randomly (you'll likely want a better initialization strategy)
            for (int j = 0; j < numInputs; j++) {
                weights[j] = Math.random() - 0.5; 
            }
            double bias = Math.random() - 0.5; // Initialize bias randomly
            neurons[i] = new Neuron(activationFunction, weights, bias);
        }
    }
}
