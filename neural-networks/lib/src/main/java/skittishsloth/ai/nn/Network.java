package skittishsloth.ai.nn;

public class Network {
    private final Layer[] layers;
    private final double learningRate;

    public Network(Layer[] layers, double learningRate) {
        this.layers = new Layer[layers.length];
        System.arraycopy(layers, 0, this.layers, 0, layers.length);

        this.learningRate = learningRate;
    }

    public void train(double[] inputs, double[] targets) {
        for (int i = 0; i < layers.length; i++) {
            layers[i].train(inputs, targets, learningRate);
        }
    }
}
