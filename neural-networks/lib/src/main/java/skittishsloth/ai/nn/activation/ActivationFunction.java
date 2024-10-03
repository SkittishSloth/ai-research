package skittishsloth.ai.nn.activation;

import skittishsloth.ai.nn.NeuralComponent;

public interface ActivationFunction extends NeuralComponent {
    default double apply(double x) {
        return forward(x);
    }

    double backward(double outputGradient);
}
