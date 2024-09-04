package skittishsloth.ai.nn.activation;

public class SeLU implements ActivationFunction {
    private static final double alpha = 1.6732632423543772848170429916717;
    private static final double scale = 1.0507009873554804934193349852946;

    @Override
    public double apply(double x) {
        return scale * (x >= 0 ? x : alpha * (Math.exp(x) - 1));
    }

}
