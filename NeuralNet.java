import java.lang.Math;
public class NeuralNet{
    public static double[][] expValue(double[][] in){
        double E = 2.71828182846;
        double[][]expValue = new double[in.length][in[0].length];
        for (int i=0; i<in.length; i++){
            for(int k=0; k< in[0].length; k++){
                expValue[i][k] = Math.pow(E,in[i][k]);
            }
        }
        return expValue;
    }
    public static double[][] normalize(double[][] in){
        double[][] output = new double[in.length][in[0].length];
        double normBase = NumJa.sum(in);
        for(int i =0; i<in.length; i++){
            for(int k=0;k<in[0].length;k++){
                output[i][k] = in[i][k]/normBase;
            }
        }
        return output;
    }
    public static void main(String[] args){
        int nodesInLayer = 3;
        
        double[] bias = new double[]{2,3,0.5};
        double[] bias2 = new double[]{-1,2,-0.5};
        double[][] inputs = new double[][]{{1.0,2.0,3.0,2.5},
                                           {2.0,5.0,-1.0,2.0},
                                            {-1.5,2.7,3.3,-0.8}};

        Layer layer = new Layer(4,5);
        Layer layer2 = new Layer(5,2);
        ActivationReLU ReLU = new ActivationReLU();
        layer.forward(inputs);
        ReLU.forward(layer.output);
        //ReLU.dump();
        //layer.dumpweight();
        layer2.forward(ReLU.output);
        //ReLU.dump();
        //NumJa.printArray(expValue(layer.output));
        NumJa.printArray(normalize(expValue(layer.output)));
        System.out.println(NumJa.sum(normalize(expValue(layer.output))));
    }

}