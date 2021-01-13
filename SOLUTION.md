# ROVERS SOLUTION BY JCACERES847

In the first commit I will do a refactor to create Unit test and try to coverage
the actual code provided. I applied Factory method design pattern and I used lombok which have annotation to create
Builder pattern and use complex objects.
During refactor I noticed that sizex and sizey was not used on the code so the condition 
(if the Rover disappears over the edge of the map (the horizon), continue on the other side 
(remember, Mars is a sphere)) was not working properly in actual implementation.

