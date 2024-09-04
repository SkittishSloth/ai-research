package skittishsloth.ai.nn.activation;

public class HardSigmoid implements ActivationFunction {

    @Override
    public double apply(double x) {
        return Math.max(0, Math.min(1, 0.2 * x + 0.5));
    }

}
