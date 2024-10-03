package skittishsloth.ai.nn;

public class Layer implements NeuralComponent {
    private final Neuron[] neurons;
    private final int numNeurons;

    public Layer(final int numNeurons) {
        this.neurons = new Neuron[numNeurons];
        this.numNeurons = numNeurons;
    }

    public void setNeuron(final Neuron neuron, final int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index (" + index + ") cannot be negative");
        }

        if (index >= numNeurons) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is out of bounds (numNeurons = " + numNeurons + ")");
        }

        neurons[index] = neuron;
    }

    @Override
    public double forward(double input) {
        double output = 0.0;

        for (int i = 0; i < numNeurons; i++) {
            output += neurons[i].forward(input);
        }

        return output;
    }

    @Override
    public double backward(double outputGradient) {
        double gradient = 0.0;

        for (int i = 0; i < numNeurons; i++) {
            gradient += neurons[i].backward(outputGradient);
        }

        return gradient;
    }

    public void train(double[] inputs, double[] outputs, double learningRate) {
        for (int i = 0; i < numNeurons; i++) {
            neurons[i].train(inputs, outputs, learningRate);
        }
    }
}
