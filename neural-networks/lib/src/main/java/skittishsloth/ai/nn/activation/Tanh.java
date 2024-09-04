package skittishsloth.ai.nn.activation;

public class Tanh implements ActivationFunction {

    @Override
    public double apply(double x) {
        return Math.tanh(x);
    }

}
