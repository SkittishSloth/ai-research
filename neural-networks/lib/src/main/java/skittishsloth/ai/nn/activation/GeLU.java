package skittishsloth.ai.nn.activation;

public class GeLU implements ActivationFunction {
    private static final double normalization = Math.sqrt(2 / Math.PI);

    @Override
    public double apply(double x) {
        return 0.5 * x * (1 + Math.tanh(normalization * (x + 0.044715 * Math.pow(x, 3))));
    }

}
