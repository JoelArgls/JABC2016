package biocomputation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author Joel
 */
public class Population {

    int popSize;
    int ITERATIONS;
    double MUTATION;
    double CROSSOVER;
    int ELITISM;

    private Individual population[];
    private double populationFitness = -1;
    private double totalFitness;
    Random random = new Random();

    //start blank population
    public Population(int popSize) {
        this.population = new Individual[popSize];
    }

    //start population of individuals
    public Population(int popSize, int geneSize) {
        this.population = new Individual[popSize];

        for (int i = 0; i < popSize; i++) {
            Individual individual = new Individual(geneSize);
            this.population[i] = individual;
        }

    }

    //get individuals from population
    public Individual[] getIndividuals() {
        return this.population;
    }

    public void setPopulation(Individual[] population) {
        this.population = population;
    }

    public double getPopulationFitness() {
        return this.populationFitness;
    }

    public void setPopulationFitness(double fitness) {
        this.populationFitness = fitness;
    }

    public int size() {
        return this.population.length;
    }

    public Individual setIndividual(int offset, Individual individual) {
        return population[offset] = individual;
    }

    public Individual getIndividual(int offset) {
        return population[offset];
    }

    public Individual getFittest(int offset) {
        // Order population by fitness
        Arrays.sort(this.population, (Individual o1, Individual o2) -> {
            if (o1.getFitness() > o2.getFitness()) {
                return -1;
            } else if (o1.getFitness() < o2.getFitness()) {
                return 1;
            }
            return 0;
        });
        return this.population[offset];
    }

    // shuffle 
    public void shuffle() {
        for (int i = population.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            Individual a = population[index];
            population[index] = population[i];
            population[i] = a;
        }
    }

}
