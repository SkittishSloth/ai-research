package skittishsloth.ai.nn;

import skittishsloth.ai.nn.activation.ActivationFunction;
import skittishsloth.ai.nn.loss.LossFunction;
import skittishsloth.ai.nn.opt.Optimizer;

public class Neuron {
    private final ActivationFunction activationFunction;
    private final double[] weights;
    private double bias;
    private double output;

    public Neuron(final ActivationFunction activationFunction, final double[] weights, final double bias) {
        this.activationFunction = activationFunction;

        int length = weights.length;
        this.weights = new double[length];
        System.arraycopy(weights, 0, this.weights, 0, length);

        this.bias = bias;
    }

    public double activate(double[] inputs) {
        double sum = bias;
        final int length = inputs.length;

        for (int i = 0; i < length; ++i) {
            sum += inputs[i] * weights[i];
        }
        
        output = activationFunction.apply(sum);

        return output;
    }

    public void train(final double[] inputs, final double actual, final double learningRate, final LossFunction lossFunction, final Optimizer optimizer) {
        final double predicted = activate(inputs);
        final double error = lossFunction.calculate(predicted, actual);
        optimizer.updateWeights(this, inputs, error, learningRate);
    }

    public int numberOfWeights() {
        return weights.length;
    }

    public double[] weights() {
        return weights;
    }

    public void incrementWeight(final int index, final double adjustment) {
        weights[index] += adjustment;
    }

    public void bias(final double bias) {
        this.bias = bias;
    }

    public double bias() {
        return bias;
    }

    public double output() {
        return output;
    }
}
