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

## Application Use Case
One wants to ...

## Project File Structure:
The root of the project comprises two folders and 6 files:
* docs - contains the researcg report and the 2018 PAAMS paper with details about this work
* src - with the source code

root files:
* aircrafts: List of aircraft tails and model
* aircraft_models: List of aircraft models including average costs for ATC charges, Maintenance, Fuel and Handling
* airport_charges: Landing and parking charges per airport and aircraft fleet
* city_pairs: list of city-pairs including coordinates and distances (Nm and Km)
* events: 49 events that affect the operational plan
* flights: the operational plan before being disrupted

## Compile and Run Current Code
* Library joda-time-2.3.jar is required.
* Compile java project and run class Tester.
