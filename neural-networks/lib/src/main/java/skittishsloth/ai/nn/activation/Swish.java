package skittishsloth.ai.nn.activation;

public class Swish implements ActivationFunction {

    @Override
    public double apply(double x) {
        return x / (1.0 + Math.exp(-x));
    }

}
