package skittishsloth.ai.nn;

import java.util.Arrays;

import skittishsloth.ai.nn.activation.Sigmoid;
import skittishsloth.ai.nn.loss.LossFunction;
import skittishsloth.ai.nn.loss.MeanSquaredError;
import skittishsloth.ai.nn.opt.OptimizationFunction;
import skittishsloth.ai.nn.opt.GradientDescent;

public class Driver {

    public static void main(String[] args) {
        final double[] weights = { 0.2, 0.8, -0.5 };
        double bias = 0.1;

        Neuron neuron = new Neuron(new Sigmoid(), weights, bias);
        double[] inputs = {1.0, 2.0, 3.0};
        double actual = 0.5;

        LossFunction lossFunction = new MeanSquaredError();
        OptimizationFunction optimizer = new GradientDescent();
        double learningRate = 0.01;

        neuron.train(inputs, actual, learningRate, lossFunction, optimizer);
        System.out.println("Updated Weights: " + Arrays.toString(neuron.weights()));
        System.out.println("Updated Bias: " + neuron.bias());
    }
}
