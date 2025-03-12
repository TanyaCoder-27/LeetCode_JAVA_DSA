Greedy is an algorithmic paradigm that builds up a solution piece by piece, always choosing the next piece that offers the most obvious and immediate benefit. Greedy algorithms are used for optimization problems. 

An optimization problem can be solved using Greedy if the problem has the following property: 

At every step, we can make a choice that looks best at the moment, and we get the optimal solution to the complete problem. 
Some popular Greedy Algorithms are Fractional Knapsack, Dijkstra’s algorithm, Kruskal’s algorithm, Huffman coding and Prim’s Algorithm
The greedy algorithms are sometimes also used to get an approximation for Hard optimization problems. For example, the Traveling Salesman Problem is an NP-Hard problem.
A Greedy choice for this problem is to pick the nearest unvisited city from the current city at every step. 
These solutions don’t always produce the best optimal solution but can be used to get an approximately optimal solution.
However, it’s important to note that not all problems are suitable for greedy algorithms. They work best when the problem exhibits the following properties:

## Greedy Choice Property:
The optimal solution can be constructed by making the best local choice at each step.
Optimal Substructure: The optimal solution to the problem contains the optimal solutions to its subproblems.
## Characteristics of Greedy Algorithm
Here are the characteristics of a greedy algorithm:

Greedy algorithms are simple and easy to implement.
They are efficient in terms of time complexity, often providing quick solutions. Greedy Algorithms are typically preferred over Dynamic Programming for the problems where both are applied. For example, Jump Game problem and Single Source Shortest Path Problem (Dijkstra is preferred over Bellman Ford where we do not have negative weights).
These algorithms do not reconsider previous choices, as they make decisions based on current information without looking ahead.
