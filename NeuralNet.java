import java.lang.Math;
//https://www.youtube.com/watch?v=omz_NdFgWyU&ab_channel=sentdex
public class NeuralNet{
    
    public static void main(String[] args){
        double[][] inputs = new double[][]{{1.0,2.0,3.0,2.5},
                                           {2.0,5.0,-1.0,2.0},
                                            {-1.5,2.7,3.3,-0.8}};

        Layer layer = new Layer(4,5);
        Layer layer2 = new Layer(5,2);
        ActivationReLU ReLU = new ActivationReLU();
        ActivationSoftmax softMax = new ActivationSoftmax();
        Loss lossC = new Loss();
        layer.forward(inputs);
        ReLU.forward(layer.output);
        layer2.forward(ReLU.output);
        softMax.forward(layer2.output);
        lossC.forward(softMax.probabilites, new double[]{0,1,1});
    
        double[][] bestWeight1 =layer.weights;
        double[][] bestWeight2 =layer2.weights;
        double lowestLoss = 100;
        double[] target = new double[]{0,1,1};//won game or not
        for (int k=0; k< 1000; k++){
            layer.weights = NumJa.add2dArray(bestWeight1,NumJa.rand2dArray(bestWeight1.length, bestWeight1[0].length));  
            layer2.weights = NumJa.add2dArray(bestWeight2,NumJa.rand2dArray(bestWeight2.length, bestWeight2[0].length));  
            layer.forward(inputs);
            ReLU.forward(layer.output);
            layer2.forward(ReLU.output);
            softMax.forward(layer2.output);
            lossC.forward(softMax.probabilites,target);
            double tempLoss = lossC.outputSample;
            if (tempLoss < lowestLoss){
                System.out.println("New Lowest- Iteration:" + k + "Loss: " + tempLoss);
                lowestLoss = tempLoss;
                bestWeight1 = layer.weights;
                bestWeight2 = layer2.weights;
            }
        }
        

    }

}