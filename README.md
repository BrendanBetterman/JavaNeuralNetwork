# JavaNeuralNetwork
Possible works??

Layer layer = new Layer(input dimension,output dimension);
ActivationReLU ReLU = new ActivationReLU();
ActivationSoftmax softMax = new ActivationSoftmax();
Loss lossC = new Loss();
-----
Layer forward process data through the neuron layer
ReLU makes it so the output isn't always linear
Layer2 is the next layer of the network
you have to softMax the final layer and ReLU atleast the first layer but perferably all layers except the last.
lossC is the loss calculation the smaller ther number the better.
---
layer.forward(inputs);
ReLU.forward(layer.output);
layer2.forward(ReLU.output);
softMax.forward(layer2.output);
lossC.forward(softMax.probabilites, new double[]{0,1,1});
