# ROVERS SOLUTION BY JCACERES847

In the first commit I will do a refactor to create Unit test and try to coverage
the actual code provided. I applied Factory method design pattern and I used lombok which have annotation to create
Builder pattern and use complex objects.
During refactor I noticed that sizex and sizey was not used on the code so the condition 
(if the Position disappears over the edge of the map (the horizon), continue on the other side 
(remember, Mars is a sphere)) was not working properly in actual implementation.

## New implementation
I applied in the new implementation several refactoring with SOLID principles generating several POJOS and
Factory method to do the abstraction of the movements and changes of Rover and composition instead of
inheritance. 
Also was applied TDD generating the necessary test cases to coverage almost one hundred percent of the code.

After that was applying the obstacles feature.

## Add Bonus point
The new feature obstacle was introduced. It was modified the receiver class RoverMoveImpl 
and used the static factory method to initialize the necessary objects and RoverPosition to 
check if rover has obstacles that prevent to move.