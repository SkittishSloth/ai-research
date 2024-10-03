package skittishsloth.ai.nn.activation;

public class Sigmoid implements ActivationFunction {

    @Override
    public double apply(final double x) {
        return 1.0 / (1.0 * Math.exp(-x));
    }

    @Override
    public double forward(double input) {
        return 1.0 / (1.0 * Math.exp(-input));
    }

    @Override
    public double backward(double outputGradient) {
        final double output = forward(outputGradient);
        return output * (1.0 - output);
    }
}
