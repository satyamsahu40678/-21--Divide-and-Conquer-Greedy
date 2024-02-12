// Q3. There are n gas stations along a circular route, where the amount of gas at the ith station is 
// gas[i].You have a car with an unlimited gas tank and it costs “cost[i]” of gas to travel from the 
// ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas 
// stations.Given two integer arrays gas and cost, return the starting gas stations index if you can 
// travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a 
// solution, it is guaranteed to be unique. 
// Input
// gas = [1,2,3,4,5], cost = [3,4,5,1,2]
// Output
// 3

import java.io.*;
import java.lang.*;
import java.util.*;

public class GreedyQues3 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        // Initialize totalGas and totalCost to 0
        int totalGas = 0, totalCost = 0;
        // Iterate through all the gas stations
        for (int i = 0; i < gas.length; i++) {
            // Add the gas and cost at each station to the total
            totalGas += gas[i];
            totalCost += cost[i];
        }
        // If totalCost is greater than totalGas, it is not possible to complete the
        // circuit
        if (totalGas < totalCost)
            return -1;

        // Initialize remainsGas and start to 0
        int remainsGas = 0, start = 0;
        // Iterate through all the gas stations
        for (int i = 0; i < gas.length; i++) {
            // Add the difference between gas and cost at each station to remainsGas
            remainsGas = remainsGas + (gas[i] - cost[i]);
            // If remainsGas becomes negative, set start to the next station and reset
            // remainsGas to 0
            if (remainsGas < 0) {
                start = i + 1;
                remainsGas = 0;
            }
        }
        // Return the starting station
        return start;
    }

    public static void main(String[] args) {
        int gas[] = { 1, 2, 3, 4, 5 };
        int cost[] = { 3, 4, 5, 1, 2 };
        System.out.println("The starting station is : " + canCompleteCircuit(gas, cost));
    }
}
