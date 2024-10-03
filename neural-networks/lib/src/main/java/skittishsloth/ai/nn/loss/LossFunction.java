package skittishsloth.ai.nn.loss;

public interface LossFunction {
    double calculate(double predicted, double actual);
}
