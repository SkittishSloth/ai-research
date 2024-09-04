package skittishsloth.ai.nn.activation;

public class Elu implements ActivationFunction {

    @Override
    public double apply(double x) {
        return apply(x, 1.0);
    }

    public double apply(final double x, final double alpha) {
        return x >= 0 ? x : alpha * (Math.exp(x) - 1);
    }

}
