package skittishsloth.ai.nn.loss;

public class MeanSquaredError implements LossFunction {

    @Override
    public double calculate(double predicted, double actual) {
        return Math.pow(predicted - actual, 2);
    }

}
