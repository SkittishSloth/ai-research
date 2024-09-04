package skittishsloth.ai.nn.activation;

public class ReLU implements ActivationFunction {

    @Override
    public double apply(double x) {
        return Math.max(0.0, x);
    }

}
