package skittishsloth.ai.nn.activation;

public class Sigmoid implements ActivationFunction {

    @Override
    public double apply(final double x) {
        return 1.0 / (1.0 * Math.exp(-x));
    }

}
