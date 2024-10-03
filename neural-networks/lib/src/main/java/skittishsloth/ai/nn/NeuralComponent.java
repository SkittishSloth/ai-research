package skittishsloth.ai.nn;

public interface NeuralComponent {
    double forward(double input);

    double backward(double outputGradient);
}
