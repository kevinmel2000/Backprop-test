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
public class Aaaa {

    /**
     * @param args the command line arguments
     */
    
     private static final int INPUT_NEURONS = 6;
    private static final int HIDDEN_NEURONS = 10;
    private static final int OUTPUT_NEURONS = 5;

    private static final double LEARN_RATE = 0.5;    // Rho.
    private static final double NOISE_FACTOR = 2;
    private static final int TRAINING_REPS = 1000000;

    // Input to Hidden Weights (with Biases).;
    private static double wih[][] = new double[INPUT_NEURONS + 1][HIDDEN_NEURONS];

    // Hidden to Output Weights (with Biases).
    private static double who[][] = new double[HIDDEN_NEURONS + 1][OUTPUT_NEURONS];

    // Activations.
    private static double inputs[] = new double[INPUT_NEURONS];
   
    private static double hidden[] = new double[HIDDEN_NEURONS];
    private static double target[] = new double[OUTPUT_NEURONS];
    private static double actual[] = new double[OUTPUT_NEURONS];

    // Unit errors.
    private static double erro[] = new double[OUTPUT_NEURONS];
    private static double errh[] = new double[HIDDEN_NEURONS];

    private static final int MAX_SAMPLES = 26;
    
     private static double noiseInputs[][] = new double[MAX_SAMPLES][INPUT_NEURONS];
    private static float trainInputs[][] = new float[][] {  {1,0,0,0,0,0},
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

    private static int trainOutput[][] = new int[][] 
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

    private static void NeuralNetwork()
    {
        
        TrainingNeuron();
        WriteWih();
        WriteWho();
        
        //System.out.println("\nTest Jaingan syaraf tiruan dengan  input training :");
        //testNetworkTraining();           
        //System.out.println("\nTest Jaingan syaraf tiruan dengan  input pecahan desimal :");
        //testNetworkWithNoise1();
        
        System.out.print("Training Selesai\n");
        return;
    }
    
    private static void WriteWih(){
       String wihString[]= new String[ (INPUT_NEURONS+1) * HIDDEN_NEURONS];
       int count=0;
     
		      for (int i = 0; i < INPUT_NEURONS +1 ; i++) {
                            for (int j = 0; j < HIDDEN_NEURONS; j++) {
                             // System.out.print(wih[i][j]+"\n");
                             wihString[count] =String.valueOf(wih[i][j]);
                             count++;
                          }
                        }
                      
                      //System.out.print("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO \n");
                  for (int i = 0; i < count; i++) {
                   //System.out.print(wihString[i]+"\n");
                     }
                  
             File file = FileUtil.setFile("wih.txt");
             FileUtil.fileWrite(wihString, file);
             
             //cek isi bobot 
             /*
             String [] hasil = FileUtil.fileRead(file);
             count=0;
              for (int i = 0; i < INPUT_NEURONS +1 ; i++) {
                for (int j = 0; j < HIDDEN_NEURONS; j++) {
                         wih[i][j]=  Float.valueOf (hasil[count]);
                         count++;
                  }
             }
              System.out.print("HASIL DR FILE OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO \n");
             for (int i = 0; i < INPUT_NEURONS +1 ; i++) {
                 for (int j = 0; j < HIDDEN_NEURONS; j++) {
                    System.out.print(wih[i][j]+"\n");
                 }
            
        }*/
              
              
                      
        
    }
    
    private static void WriteWho(){
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
    
    private static void TrainingNeuron(){
        System.out.print("Training....\n");
     int sample = 0;

        assignRandomWeights();

        // Train the network.
        for(int epoch = 0; epoch < TRAINING_REPS; epoch++)
        {
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

    private static void getTrainingStats()
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
    
    

    private static void testNetworkTraining()
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

    private static void testNetworkWithNoise1()
    {
        // This function adds a random fractional value to all the training
        // inputs greater than zero.
        DecimalFormat dfm = new java.text.DecimalFormat("###0.0");
        
        for(int i = 0; i < MAX_SAMPLES; i++)
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
    
    private static int pembulatan(final double actual){
        int hasil=0;
        if (actual >= 0.5) {
            hasil=1;
        }
        return hasil;
    }

    private static int maximum(final double[] vector)
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

    private static void feedForward()
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
    
    private static void feedForwardFile(){
        
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
    
    private static void readWih(){
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
    
     private static void readWho(){
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
    
    private static void backPropagate()
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

    private static void assignRandomWeights()
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

    private static double sigmoid(final double val)
    {
        return (1.0 / (1.0 + Math.exp(-val)));
    }

    private static double sigmoidDerivative(final double val)
    {
        return (val * (1.0 - val));
    }

    public static void main(String[] args) {
        // TODO code application logic here
        //NeuralNetwork();
        //testNetworkWithNoise1();
       //testNetworkTraining();
      
        return;

    }
    
}
