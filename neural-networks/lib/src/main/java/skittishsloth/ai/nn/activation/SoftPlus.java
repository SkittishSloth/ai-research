package skittishsloth.ai.nn.activation;

public class SoftPlus implements ActivationFunction {

    @Override
    public double apply(double x) {
        return Math.log(1 + Math.exp(x));
    }

}
