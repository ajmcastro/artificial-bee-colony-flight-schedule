# Using Artificial Bee Colony Algorithm to Optimise Flight Schedules

In this project the Artificial Bee Colony algorithm (ABC) has been applied on flight scheduling resolution, using real data from an European Airline.

ABC was firstly introduced by D. Karaboga in 2005 and proposed for optimizing numerical problems. ABC is the swarm-based meta-heuristic algorithm inspired by intelligent behavior of honey bee colonies. 

The environment and data for experiments are provided by MASDIMA, Multi-Agent System for DIsruption Management developed by LIACC (Laboratory of Artificial Intelligence and Computer Science).

## Conclusions
Initial conclusions show that the ABC algorithm can be successfully used for solving scheduling optimisation problems. Available paper shows results of the experiments performed.

## Improvements to be done
Further modifications are welcome on the implemented solution in order to improve performance. Above all, smart choice of heuristics can contribute in faster reaching of better solutions. Due to the wide solution space, the reduction of random factors in the implementation might be a good idea. For example, strategy for choosing the initial population of solution instead of choosing randomly distributed one, or applying additional methods for smarter choice of neighborhood food sources can be investigated in the future work.

## Authors
Main Author: Tanja Šarčević (ta.sarcevic@gmail.com)

Supervisors: Ana Paula Rocha (arocha@fe.up.pt) and António J. M. Castro (frisky.antonio@gmail.com)

## Application use case and solution
To adapt the ABC algorithm to flight scheduling problem, we represent possible solution as an assignment of aircrafts to all operating flights. Aircrafts are initially at any point of the algorithm execution assigned to a flight if and only if the aircraft is not already assigned to some other flight in the same time in the same schedule. This restriction of the aircraft choice results in all the schedules (i.e. solutions) being feasible, which makes algorithm calculate costs and finding the best one only among the feasible solutions. 

On the other hand, cancellation of the flight is as well possible. If there is such schedule where for some flight the choice of the aircraft is impossible (e.g. because at that time no aircrafts are available according to schedule), then the flight is being cancelled and it is penalized with a high number. Penalisation for cancellation amounts to approximately 10% of the total calculated cost of a random solution.

## Project file structure:
The root of the project comprises two folders and 6 files:
* docs - contains the researcg report and the 2018 PAAMS paper with details about this work
* lib - contains the joda-time-2.3 jar file needed to compile and run the program
* src - with the source code

root files:
* aircrafts: List of aircraft tails and model
* aircraft_models: List of aircraft models including average costs for ATC charges, Maintenance, Fuel and Handling
* airport_charges: Landing and parking charges per airport and aircraft fleet
* city_pairs: list of city-pairs including coordinates and distances (Nm and Km)
* events: 49 events that affect the operational plan
* flights: the operational plan before being disrupted

## Compile and run current code
* Library joda-time-2.3.jar is required (lib folder)
* Compile java project and run class Tester
