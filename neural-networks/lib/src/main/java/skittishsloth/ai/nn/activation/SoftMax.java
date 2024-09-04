package skittishsloth.ai.nn.activation;

public class SoftMax implements ActivationFunction {

    @Override
    public double apply(double x) {
        final double exp = Math.exp(x);
        
        return Math.exp(x) / (1 + exp);
    }

}
