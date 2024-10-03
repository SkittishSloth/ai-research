package skittishsloth.ai.nn.opt;

import skittishsloth.ai.nn.Neuron;

public class GradientDescent implements OptimizationFunction {

    // @Override
    // public void updateWeights(Neuron neuron, double[] inputs, double error, double learningRate) {
    //     final double adjustment = learningRate * error;
    //     final int numberOfWeights = neuron.numberOfWeights();

    //     for (int i = 0; i < numberOfWeights; ++i) {
    //         neuron.incrementWeight(i, adjustment);
    //     }

    //     neuron.bias(neuron.bias() + adjustment);
    // }

    @Override
    public double optimize(double weight, double error, double learningRate) {
        final double adjustment = learningRate * error;
        return weight + adjustment;
    }

}
