package biocomputation;

/**
 *
 * @author Joel
 */
public class GA {

    private int popSize;
    private double mutationRate;
    private double crossoverRate;
    private int elitism;

    public GA(int popSize, double mutationRate, double crossoverRate, int elitism) {
        this.popSize = popSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.elitism = elitism;
    }

    public Population initPopulation(int geneSize) {
        Population population = new Population(this.popSize, geneSize); 
        return population;
    }
    
    public double calculateFitness(Individual individual) {
        int correctGenes = 0;
        for (int i = 0; i < individual.getGeneSize(); i++) {
            if (individual.getGene(i) == 1) {
                correctGenes += 1;
            }
        }
        
        double fitness = (double) correctGenes / individual.getGeneSize();
        individual.setFitness(fitness);
        
        return fitness;
    } 
    
    //evaluate population fitness
    public void evaluate(Population population) {
        double populationFitness = 0;
        for (Individual individual : population.getIndividuals()) {
            populationFitness += calculateFitness(individual);
        }
        population.setPopulationFitness(populationFitness);
    }
    
    public boolean checkCondition(Population population) {
        for (Individual individual : population.getIndividuals()) {
            if(individual.getFitness() == 1) {
                return true;
            }
        }
        return false;
    }
    
    //crossover
    //public Population crossover(Population population) {
        
  //  }
    
    
}
