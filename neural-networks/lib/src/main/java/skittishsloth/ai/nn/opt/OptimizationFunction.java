package skittishsloth.ai.nn.opt;

public interface OptimizationFunction {
    // void updateWeights(Neuron neuron, double[] inputs, double error, double learningRate);

    double optimize(double weight, double error, double learningRate);
}
