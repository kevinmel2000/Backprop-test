/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaaa;
import java.io.File;
import java.util.Random;
import java.text.DecimalFormat;

/**
 *
 * @author Nanda-PC
 */
public class Backprop {

    /**
     * @param args the command line arguments
     */
    public Backprop(){
        
    }
    
    public final   int INPUT_NEURONS = 6;
    public final   int HIDDEN_NEURONS = 20;
    public final   int OUTPUT_NEURONS = 5;

    public final   double LEARN_RATE = 0.3;    // Rho.
    public final   double NOISE_FACTOR = 0.2;
    public final   int TRAINING_REPS = 100000;

    // Input to Hidden Weights (with Biases).;
    public final  double wih[][] = new double[INPUT_NEURONS + 1][HIDDEN_NEURONS];

    // Hidden to Output Weights (with Biases).
    public final  double who[][] = new double[HIDDEN_NEURONS + 1][OUTPUT_NEURONS];

    // Activations.
    public final  double inputs[] = new double[INPUT_NEURONS];
   
    public final  double hidden[] = new double[HIDDEN_NEURONS];
    public final  double target[] = new double[OUTPUT_NEURONS];
    public final  double actual[] = new double[OUTPUT_NEURONS];

    // Unit errors.
    public final  double erro[] = new double[OUTPUT_NEURONS];
    public final  double errh[] = new double[HIDDEN_NEURONS];

    public static final  int MAX_SAMPLES = 26;
    
    public final  double noiseInputs[][] = new double[MAX_SAMPLES][INPUT_NEURONS];
    public final  float trainInputs[][] = new float[][] {  {1,0,0,0,0,0},
                                                            {1,1,0,0,0,0},
                                                            {1,0,0,1,0,0},
                                                            {1,0,0,1,1,0},
                                                            {1,0,0,0,1,0},
                                                            {1,1,0,1,0,0},
                                                            {1,1,0,1,1,0},
                                                            {1,0,0,1,1,0},
                                                            {0,1,0,1,0,0},
                                                            {0,1,0,1,1,0},
                                                            {1,0,1,0,0,0},
                                                            {1,1,1,0,0,0},
                                                            {1,0,1,1,0,0},
                                                            {1,0,1,1,1,0},
                                                            {1,0,1,0,1,0},
                                                            {1,1,1,1,0,0},
                                                            {1,1,1,1,1,0},
                                                            {1,1,1,0,1,0},
                                                            {0,1,1,1,0,0},
                                                            {0,1,1,1,1,0},
                                                            {1,0,1,0,0,1},
                                                            {1,1,1,0,0,1},
                                                            {0,1,0,1,1,1},
                                                            {1,0,1,1,0,1},
                                                            {1,0,1,1,1,1},
                                                            {1,0,1,0,1,1}
                                                                };

    public final  int trainOutput[][] = new int[][] 
                                        {{0,0,0,0,1},
                                        {0,0,0,1,0},
                                        {0,0,0,1,1},
                                        {0,0,1,0,0},
                                        {0,0,1,0,1},
                                        {0,0,1,1,0},
                                        {0,0,1,1,1},
                                        {0,1,0,0,0},
                                        {0,1,0,0,1},
                                        {0,1,0,1,0},
                                        {0,1,0,1,1},
                                        {0,1,1,0,0},
                                        {0,1,1,0,1},
                                        {0,1,1,1,0},
                                        {0,1,1,1,1},
                                        {1,0,0,0,0},
                                        {1,0,0,0,1},
                                        {1,0,0,1,0},
                                        {1,0,0,1,1},
                                        {1,0,1,0,0},
                                        {1,0,1,0,1},
                                        {1,0,1,1,0},
                                        {1,0,1,1,1},
                                        {1,1,0,0,0},
                                        {1,1,0,0,1},
                                        {1,1,0,1,0} };

    public  void NeuralNetwork()
    {
        
        TrainingNeuron();
        WriteWih();
        WriteWho();
        
       //testNetworkWithNoise1();
       //testNetworkTraining();
       
        System.out.print("Training Selesai\n");
        return;
    }
    
    public void testWithImage( double[] Inputbinary  ){
        for(int i = 0; i < 1; i++)
        {
            for(int j = 0; j < INPUT_NEURONS; j++)
            {
                inputs[j] = Inputbinary[j];
            } // j
            
            feedForwardFile();
            
            for(int j = 0; j < INPUT_NEURONS; j++)
            {
               System.out.print(inputs[j] + "\t");
            } // j
            
            System.out.print("Output: " + pembulatan(actual[0])+","+ pembulatan(actual[1])+","+pembulatan(actual[2])+","+pembulatan(actual[3])+","+pembulatan(actual[4])+"\n");
        } // i 
    }
    
    public double[] setArrOutput(){
        actual[0]= pembulatan(actual[0]);
        actual[1]= pembulatan(actual[1]);
        actual[2]= pembulatan(actual[2]);
        actual[3]= pembulatan(actual[3]);
        actual[4]= pembulatan(actual[4]);
        return actual;
    }
    
    public  void WriteWih(){
       String wihString[]= new String[ (INPUT_NEURONS+1) * HIDDEN_NEURONS];
       int count=0;
		      for (int i = 0; i < INPUT_NEURONS +1 ; i++) {
                            for (int j = 0; j < HIDDEN_NEURONS; j++) {
                             wihString[count] =String.valueOf(wih[i][j]);
                             count++;
                          }
                        }
             File file = FileUtil.setFile("wih.txt");
             FileUtil.fileWrite(wihString, file);
    }
    
    public  void WriteWho(){
       String whoString[]= new String[ (HIDDEN_NEURONS+1) * OUTPUT_NEURONS];
       int count=0;
       //System.out.print("bobot who \n");
		      for (int i = 0; i < HIDDEN_NEURONS +1 ; i++) {
                            for (int j = 0; j < OUTPUT_NEURONS; j++) {
                             // System.out.print(who[i][j]+"\n");
                             whoString[count] = String.valueOf(who[i][j]);
                             count++;
                          }
                        }
                      
          File file = FileUtil.setFile("who.txt");
          FileUtil.fileWrite(whoString, file);
    }
    
    public  void TrainingNeuron(){
        System.out.print("Training....\n");
     int sample = 0;

        assignRandomWeights();


        for(int epoch = 0; epoch < TRAINING_REPS; epoch++)
        {
           // System.out.print("iterasi ke: " +epoch+" \n");
            sample += 1;
            if(sample == MAX_SAMPLES){
                sample = 0;
            }

            for(int i = 0; i < INPUT_NEURONS; i++)
            {
                inputs[i] = trainInputs[sample][i];
            } // i

            for(int i = 0; i < OUTPUT_NEURONS; i++)
            {
                target[i] = trainOutput[sample][i];
            } // i

            feedForward();

            backPropagate();

        } // epoch

         getTrainingStats();
    }

    public  void getTrainingStats()
    {
        double sum = 0.0;
        for(int i = 0; i < MAX_SAMPLES; i++)
        {
            for(int j = 0; j < INPUT_NEURONS; j++)
            {
                inputs[j] = trainInputs[i][j];
            } // j

            for(int j = 0; j < OUTPUT_NEURONS; j++)
            {
                target[j] = trainOutput[i][j];
            } // j

            feedForward();

            /*if(maximum(actual) == maximum(target)){
                sum += 1;
            }else{
                System.out.print(inputs[0] + "\t" + inputs[1] + "\t" + inputs[2] + "\t" + inputs[3] );
                System.out.print(" actual: "+maximum(actual) + "\t" + "target: "+ maximum(target)+"\n");
            }*/
            
            if ( pembulatan(actual[0])== pembulatan(target[0]) && pembulatan(actual[1])== pembulatan(target[1]) && pembulatan(actual[2])== pembulatan(target[2]) && pembulatan(actual[3])== pembulatan(target[3]) && pembulatan(actual[4])== pembulatan(target[4])) {
                sum+=1;
            }
            else{
                  System.out.print(inputs[0] + "\t" + inputs[1] + "\t" + inputs[2] + "\t" + inputs[3] + "\t" + inputs[4] + "\t" + inputs[5] + "\t"  );
                 System.out.print("Output yg tdk sesuai : " + pembulatan(actual[0])+","+ pembulatan(actual[1])+","+pembulatan(actual[2])+","+pembulatan(actual[3])+","+pembulatan(actual[4])+"\n");
            }
            
        } // i

        System.out.println("hasil  training benar sebanyak " + ((double)sum / (double)MAX_SAMPLES * 100.0) + "%");

        return;
    }
    
    public  void testNetworkTraining()
    {
       
        for(int i = 0; i < MAX_SAMPLES; i++)
        {
            for(int j = 0; j < INPUT_NEURONS; j++)
            {
                inputs[j] = trainInputs[i][j];
            } // j
            
            feedForwardFile();
            
            for(int j = 0; j < INPUT_NEURONS; j++)
            {
                System.out.print(inputs[j] + "\t");
            } // j
            
            System.out.print("Output: " + pembulatan(actual[0])+","+ pembulatan(actual[1])+","+pembulatan(actual[2])+","+pembulatan(actual[3])+","+pembulatan(actual[4])+"\n");
        } // i
        
        return;
    }

    public  void testNetworkWithNoise1()
    {
        // This function adds a random fractional value to all the training
        // inputs greater than zero.
        DecimalFormat dfm = new java.text.DecimalFormat("###0.0");
        
        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < INPUT_NEURONS; j++)
            {
               // noiseInputs[j]=(new Random().nextDouble() * NOISE_FACTOR);
                inputs[j] = trainInputs[i][j] + (new Random().nextDouble() * NOISE_FACTOR);
                noiseInputs[i][j]=inputs[j];
                //System.out.print(inputs[j]);
            } // j
            
            feedForwardFile();
            
            for(int j = 0; j < INPUT_NEURONS; j++)
            {
                System.out.print(dfm.format(((inputs[j] * 1000.0) / 1000.0)) + "\t");
            } // j
              System.out.print("Output: " + pembulatan(actual[0])+","+ pembulatan(actual[1])+","+pembulatan(actual[2])+","+pembulatan(actual[3])+","+pembulatan(actual[4])+"\n");
        } // i

        return;
    }
    
    private  int pembulatan( double actual){
        int hasil=0;
        if (actual >= 0.5) {
            hasil=1;
        }
        return hasil;
    }

    private  int maximum( double[] vector)
    {
        // This function returns the index of the maximum of vector().
        int sel = 0;
        double max = vector[sel];

        for(int index = 0; index < OUTPUT_NEURONS; index++)
        {
            if(vector[index] > max){
                max = vector[index];
                sel = index;
            }
        }
        return sel;
    }

    private  void feedForward()
    {
        double sum = 0.0;

        // Calculate input to hidden layer.
        for(int hid = 0; hid < HIDDEN_NEURONS; hid++)
        {
            sum = 0.0;
            for(int inp = 0; inp < INPUT_NEURONS; inp++)
            {
                sum += inputs[inp] * wih[inp][hid];
            } // inp

            sum += wih[INPUT_NEURONS][hid]; // Add in bias.
            hidden[hid] = sigmoid(sum);
        } // hid

        // Calculate the hidden to output layer.
        for(int out = 0; out < OUTPUT_NEURONS; out++)
        {
            sum = 0.0;
            for(int hid = 0; hid < HIDDEN_NEURONS; hid++)
            {
                sum += hidden[hid] * who[hid][out];
            } // hid

            sum += who[HIDDEN_NEURONS][out]; // Add in bias.
            actual[out] = sigmoid(sum);
        } // out
        return;
    }
    
    public  void feedForwardFile(){
        
        double sum = 0.0;
        readWih();
        readWho();
        
        // Calculate input to hidden layer.
        for(int hid = 0; hid < HIDDEN_NEURONS; hid++)
        {
            sum = 0.0;
            for(int inp = 0; inp < INPUT_NEURONS; inp++)
            {
                sum += inputs[inp] * wih[inp][hid];
            } // inp

            sum += wih[INPUT_NEURONS][hid]; // Add in bias.
            hidden[hid] = sigmoid(sum);
        } // hid

        // Calculate the hidden to output layer.
        for(int out = 0; out < OUTPUT_NEURONS; out++)
        {
            sum = 0.0;
            for(int hid = 0; hid < HIDDEN_NEURONS; hid++)
            {
                sum += hidden[hid] * who[hid][out];
            } // hid

            sum += who[HIDDEN_NEURONS][out]; // Add in bias.
            actual[out] = sigmoid(sum);
        } // out
        return;
    
    }
    
    private  void readWih(){
        //cek isi bobot 
             
             File file = FileUtil.setFile("wih.txt");
             String [] hasil = FileUtil.fileRead(file);
             int count=0;
              for (int i = 0; i < INPUT_NEURONS +1 ; i++) {
                for (int j = 0; j < HIDDEN_NEURONS; j++) {
                         wih[i][j]=  Float.valueOf (hasil[count]);
                         count++;
                  }
             }
              
 
    }
    
     private  void readWho(){
        //cek isi bobot 
             
             File file = FileUtil.setFile("who.txt");
             String [] hasil = FileUtil.fileRead(file);
             int count=0;
              for (int i = 0; i < HIDDEN_NEURONS +1 ; i++) {
                for (int j = 0; j < OUTPUT_NEURONS; j++) {
                         who[i][j]=  Float.valueOf (hasil[count]);
                         count++;
                  }
             }
             
    }
    
    private  void backPropagate()
    {
        // Calculate the output layer error (step 3 for output cell).
        for(int out = 0; out < OUTPUT_NEURONS; out++)
        {
            erro[out] = (target[out] - actual[out]) * sigmoidDerivative(actual[out]);
        }

        // Calculate the hidden layer error (step 3 for hidden cell).
        for(int hid = 0; hid < HIDDEN_NEURONS; hid++)
        {
            errh[hid] = 0.0;
            for(int out = 0; out < OUTPUT_NEURONS; out++)
            {
                errh[hid] += erro[out] * who[hid][out];
            }
            errh[hid] *= sigmoidDerivative(hidden[hid]);
        }

        // Update the weights for the output layer (step 4).
        for(int out = 0; out < OUTPUT_NEURONS; out++)
        {
            for(int hid = 0; hid < HIDDEN_NEURONS; hid++)
            {
                who[hid][out] += (LEARN_RATE * erro[out] * hidden[hid]);
            } // hid
            who[HIDDEN_NEURONS][out] += (LEARN_RATE * erro[out]); // Update the bias.
        } // out

        // Update the weights for the hidden layer (step 4).
        for(int hid = 0; hid < HIDDEN_NEURONS; hid++)
        {
            for(int inp = 0; inp < INPUT_NEURONS; inp++)
            {
                wih[inp][hid] += (LEARN_RATE * errh[hid] * inputs[inp]);
            } // inp
            wih[INPUT_NEURONS][hid] += (LEARN_RATE * errh[hid]); // Update the bias.
        } // hid
        return;
    }

    private  void assignRandomWeights()
    {
        for(int inp = 0; inp <= INPUT_NEURONS; inp++) // Do not subtract 1 here.
        {
            for(int hid = 0; hid < HIDDEN_NEURONS; hid++)
            {
                // Assign a random weight value between -0.5 and 0.5
                wih[inp][hid] = new Random().nextDouble() - 0.5;
            } // hid
        } // inp

        for(int hid = 0; hid <= HIDDEN_NEURONS; hid++) // Do not subtract 1 here.
        {
            for(int out = 0; out < OUTPUT_NEURONS; out++)
            {
                // Assign a random weight value between -0.5 and 0.5
                who[hid][out] = new Random().nextDouble() - 0.5;
            } // out
        } // hid
        return;
    }

    private static double sigmoid( double val)
    {
        return (1.0 / (1.0 + Math.exp(-val)));
    }

    private static double sigmoidDerivative(final double val)
    {
        return (val * (1.0 - val));
    }
    
}
