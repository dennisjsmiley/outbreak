Outbreak
----
Determines if a grid of rooms contains an outbreak, meaning five or more connected 
rooms are infected. Rooms which share a common wall are considered connected.  
Rooms that are diagonal from each other are not considered connected. 

Examples:  

(X = Infection, O = No infection)


Outbreak  
|X|X|X|O|O|   
|O|O|X|X|O|  
|O|O|O|O|O|  

No Outbreak  
|O|X|O|O|O|O|  
|O|O|X|O|O|O|  
|O|O|O|X|O|O|  
|O|O|O|O|X|O|  
|O|O|O|O|O|X|  

Code: 

* src/main/java/tech/aircastle/outbreak/Outbreak.java -- Outbreak.isOutbreak and Outbreak.getInfectionSize are of interest
* src/test/java/tech/aircastle/outbreak/OutbreakTest.java