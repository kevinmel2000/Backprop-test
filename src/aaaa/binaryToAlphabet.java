/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaaa;

/**
 *
 * @author Nanda-PC
 */
public class binaryToAlphabet {
    String huruf;
    double[] output= new double[5];
    public binaryToAlphabet(){
        
    }
    
    public void setBinary(double[] outputs){
        this.output = outputs;
    }
    
    public void process(){
        if (output[0]==1 && output[1]==0 && output[2]==0 && output[3]==0 && output[4]==0  ) {
            huruf="P";
        }
        else if (output[0]==0 && output[1]==0 && output[2]==1 && output[3]==1 && output[4]==1  ) {
            huruf="G";
        }
        else if (output[0]==0 && output[1]==1 && output[2]==1 && output[3]==1 && output[4]==1  ) {
            huruf="O";
        }
    }
    
    public String getHasil(){
        return huruf;
    }
    
}
