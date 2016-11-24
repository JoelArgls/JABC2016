package biocomputation;

/**
 *
 * @author Joel
 */
public class Run {

    public static void main(String[] args) {

        GA ga = new GA(60, 0.2, 0.95, 2);

        Population population = ga.initPopulation(32);

        ga.evaluate(population);

        int generation = 1;

        while (ga.checkCondition(population) == false) {
            // Print fittest individual from population
            System.out.println("Best solution: " + population.getFittest(0).toString());

            // Apply crossover
            //population = ga.crossoverPopulation(population);

            // Apply mutation
            //population = ga.mutatePopulation(population);

            // Evaluate population
           // ga.evalPopulation(population);

            // Increment the current generation
            generation++;
        }

    }

}
