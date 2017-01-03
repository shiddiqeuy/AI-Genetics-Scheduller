package com.shiddiq.genetic;

import org.jenetics.BitChromosome;
import org.jenetics.BitGene;
import org.jenetics.EnumGene;
import org.jenetics.Genotype;
import org.jenetics.Optimize;
import org.jenetics.PartiallyMatchedCrossover;
import org.jenetics.PermutationChromosome;
import org.jenetics.SwapMutator;
import org.jenetics.engine.Engine;
import org.jenetics.engine.EvolutionResult;
import org.jenetics.util.Factory;
import org.jenetics.util.ISeq;
 
public class GAMain {
    private static String[] pops;

	// 2.) Definition of the fitness function.
    private static Integer eval(Genotype<BitGene> gt) {
        return ((BitChromosome)gt.getChromosome()).bitCount();
    }
 
    public static void main(String[] args) {
        // 1.) Define the genotype (factory) suitable
        //     for the problem.
        Factory<Genotype<BitGene>> gtf =
            Genotype.of(BitChromosome.of(10, 0.5));
        
        final ISeq<String> alleles = ISeq.of("1","2","2","3","5","3","4","4","4","5","3","3","4","5","4","2","2","3","5","3","4","4","5");
        System.out.println("====================================================================================");
        System.out.println("Tue 16 Aug 2016 Balikpapan");
        System.out.println("initiating Genetic Algorithm");
        System.out.println("initiating Population");
        System.out.println("Create Permutation Chromosome of  Population");
        System.out.println("Create Permutation Chromosome of  Population from "+alleles);
        pops = null;
        System.out.println("====================================================================================");
        System.out.println("Engine Started...");
        for (int i=0;i<20;i++){
        // Create a new randomly permuted chromosome from the given alleles.
        final PermutationChromosome<String> ch = PermutationChromosome.of(alleles);
        //pops[i]=ch.toString();ng
        //System.out.println("Pop ["+i+"] = "+pops[i]);
        System.out.println("Possible Schedule Sequence ["+i+ "]= "+ch);
        }
        System.out.println("Termination..");
        System.out.println("====================================================================================");

       
 
        // 3.) Create the execution environment.
        //final Engine<EnumGene<Integer>,Double> engine = Engine.builder(GAMain::dist, PermutationChromosome.ofInteger(5))
//        final Engine<EnumGene<Integer>,Double> engine = Engine.
//        			builder(
//       					GAMain::dist, 
//        					PermutationChromosome.ofInteger(5))
//        		.optimize(Optimize .MINIMUM)
//        		.maximalPhenotypeAge (11)
//        		.populationSize(500)
//        		.alterers (
//        		new SwapMutator < >(0.2) ,
//        		new PartiallyMatchedCrossover< >(0.35) )
//        		.build( );
//// 
////       // 4.) Start the execution (evolution) and
//       //     collect the result.
//        Genotype<EnumGene<Integer>> result = engine.stream()
//            .limit(100)
//            .collect(EvolutionResult.toBestGenotype());
// 
        //System.out.println("Fitness Result:\n" + result);
        //System.out.println("Fitness Result:\n" + statistics);
    }
}