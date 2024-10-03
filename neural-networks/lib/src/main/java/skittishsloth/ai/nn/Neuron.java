package skittishsloth.ai.nn;

import skittishsloth.ai.nn.activation.ActivationFunction;
import skittishsloth.ai.nn.loss.LossFunction;
import skittishsloth.ai.nn.opt.OptimizationFunction;

public class Neuron implements NeuralComponent {
    private final double[] weights;
    private final ActivationFunction activationFunction;
    private final LossFunction lossFunction;
    private final OptimizationFunction optimizationFunction;
    
    private double input;
    private double bias;

    public Neuron(final double[] weights, final double bias, final ActivationFunction activationFunction, final LossFunction lossFunction, final OptimizationFunction optimizationFunction) {
        this.activationFunction = activationFunction;

        int length = weights.length;
        this.weights = new double[length];
        System.arraycopy(weights, 0, this.weights, 0, length);

        this.bias = bias;

        this.lossFunction = lossFunction;
        this.optimizationFunction = optimizationFunction;
    }

    @Override
    public double forward(double input) {
        this.input = input;
        double sum = 0.0;
        
        for (int i = 0; i < weights.length; i++) {
            sum += activationFunction.forward(input * weights[i]);
        
        }

        return sum + bias;
    }

    @Override
    public double backward(double outputGradient) {
        return activationFunction.backward(input * sumWeights()) * outputGradient;
    }

    public void train(double[] inputs, double[] outputs, double learningRate) {
        for (int i = 0; i < weights.length; i++) {
            final double loss = error(inputs[i], outputs[i]);

            weights[i] = optimizationFunction.optimize(weights[i], loss, learningRate);
        }

        bias -= optimizationFunction.optimize(bias, error(inputs[0], outputs[0]), learningRate);
    }

    private double sumWeights() {
        double sum = 0.0;

        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
        }

        return sum;
    }

    private double error(final double input, final double output) {
        final double calculated = lossFunction.calculate(input, output);

        return backward(calculated);
    }
}
