package skittishsloth.ai.nn.loss;

@FunctionalInterface
public interface LossFunction {
    double calculate(double predicted, double actual);
}
