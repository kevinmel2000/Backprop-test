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
        
  
             if (output[0]==0 && output[1]==0 && output[2]==0 && output[3]==0 && output[4]==1  ) {
            huruf="A";
        }
        else if (output[0]==0 && output[1]==0 && output[2]==0 && output[3]==1 && output[4]==0  ) {
            huruf="B";
        }
        else if (output[0]==0 && output[1]==0 && output[2]==0 && output[3]==1 && output[4]==1  ) {
            huruf="C";
        }
        else if (output[0]==0 && output[1]==0 && output[2]==1 && output[3]==0 && output[4]==0  ) {
            huruf="D";
        }
        else if (output[0]==0 && output[1]==0 && output[2]==1 && output[3]==0 && output[4]==1  ) {
            huruf="E";
        }
        else if (output[0]==0 && output[1]==0 && output[2]==1 && output[3]==1 && output[4]==0  ) {
            huruf="F";
        }
        else if (output[0]==0 && output[1]==0 && output[2]==1 && output[3]==1 && output[4]==1  ) {
            huruf="G";
        }
        else if (output[0]==0 && output[1]==1 && output[2]==0 && output[3]==0 && output[4]==0  ) {
            huruf="H";
        }
        else if (output[0]==0 && output[1]==1 && output[2]==0 && output[3]==0 && output[4]==1  ) {
            huruf="I";
        }
        else if (output[0]==0 && output[1]==1 && output[2]==0 && output[3]==1 && output[4]==0  ) {
            huruf="J";
        }
        else if (output[0]==0 && output[1]==1 && output[2]==0 && output[3]==1 && output[4]==1  ) {
            huruf="K";
        }
        else if (output[0]==0 && output[1]==1 && output[2]==1 && output[3]==0 && output[4]==0  ) {
            huruf="L";
        }
        else if (output[0]==0 && output[1]==1 && output[2]==1 && output[3]==0 && output[4]==1  ) {
            huruf="M";
        }
        else if (output[0]==0 && output[1]==1 && output[2]==1 && output[3]==1 && output[4]==0  ) {
            huruf="N";
        }
        else if (output[0]==0 && output[1]==1 && output[2]==1 && output[3]==1 && output[4]==1  ) {
            huruf="O";
        }
        else if (output[0]==1 && output[1]==0 && output[2]==0 && output[3]==0 && output[4]==0  ) {
            huruf="P";
        }
        else if (output[0]==1 && output[1]==0 && output[2]==0 && output[3]==0 && output[4]==1  ) {
            huruf="Q";
        }
        else if (output[0]==1 && output[1]==0 && output[2]==0 && output[3]==1 && output[4]==0  ) {
            huruf="R";
        }
        else if (output[0]==1 && output[1]==0 && output[2]==0 && output[3]==1 && output[4]==1  ) {
            huruf="S";
        }
        else if (output[0]==1 && output[1]==0 && output[2]==1 && output[3]==0 && output[4]==0  ) {
            huruf="T";
        }
        else if (output[0]==1 && output[1]==0 && output[2]==1 && output[3]==0 && output[4]==1  ) {
            huruf="U";
        }
        else if (output[0]==1 && output[1]==0 && output[2]==1 && output[3]==1 && output[4]==0  ) {
            huruf="V";
        }
        else if (output[0]==1 && output[1]==0 && output[2]==1 && output[3]==1 && output[4]==1  ) {
            huruf="W";
        }
        else if (output[0]==1 && output[1]==1 && output[2]==0 && output[3]==0 && output[4]==0  ) {
            huruf="X";
        }
        else if (output[0]==1 && output[1]==1 && output[2]==0 && output[3]==0 && output[4]==1  ) {
            huruf="Y";
        }
        else if (output[0]==1 && output[1]==1 && output[2]==0 && output[3]==1 && output[4]==0  ) {
            huruf="Z";
        }
    }
    
    public String getHasil(){
        return huruf;
    }
    
}
