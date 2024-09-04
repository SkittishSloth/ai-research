package skittishsloth.ai.nn.activation;

public class LeakyReLU implements ActivationFunction {

    @Override
    public double apply(double x) {
        return x > 0 ? x : 0.01 * x;
    }
}
