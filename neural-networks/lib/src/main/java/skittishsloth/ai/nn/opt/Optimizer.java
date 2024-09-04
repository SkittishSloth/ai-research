package skittishsloth.ai.nn.opt;

import skittishsloth.ai.nn.Neuron;

@FunctionalInterface
public interface Optimizer {
    void updateWeights(Neuron neuron, double[] inputs, double error, double learningRate);
}
