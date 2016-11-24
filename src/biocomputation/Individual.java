package biocomputation;


import java.io.File;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Joel
 */
public class Individual {
   
    private int[] gene;
    private double fitness = -1;
    Random rand = new Random();
    
    //initialize individual
    public Individual(int[] gene) {
        this.gene = gene;
    }
    
    //initialize random individual
    public Individual(int geneSize) {
        this.gene = new int[geneSize];
        for (int i=0; i<geneSize; i++){
            if (0.5 < rand.nextInt()) {
                this.setGene(i, 1);
            }
            else {
                this.setGene(i, 0);
            }
        }
    }

//    Individual() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public int[] getGene() {
        return this.gene;
    }

    public void setGene(int offset, int g) {
        this.gene[offset] = g;
    }
    
    public int getGene(int offset) {
        return this.gene[offset];
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }
    
    public int getGeneSize() {
        return this.gene.length;
    }
    
    public String toString() {
	String output = "";
	for (int gene = 0; gene < this.gene.length; gene++) {
		output += this.gene[gene];
	}
	return output;
	}
    
    
}
