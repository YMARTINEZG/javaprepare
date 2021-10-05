## Most popular question:

1. Explain HashMap:
   hashCode is a Object method that reurnt the int value of an object.
   HashMap implement Map interface.
   it store data in the pair of key,value
   when key-A and key-B has the same index , a link to the node - B is created
   hashCode of null key = 0;
   index= hasCode(key) & (n-1) // n= size of array
   In case of collision:
   if index for key-A == index for key-B 
      if (key-A.Equals(key-B)) -> replace value of key-A with value of key-B
      else
           connect node of key-A to node of key-B.
   node = {hasCode value, key value, value , next address }          
   
2. SOLID means:
   S : SINGLE RESPONSABILITY "one class should have one and only one responsability"
     - developer should write, change and maintain a class for one purpose.
     - each class is responsable for a single problem, task or concern.
     - Person class, Account class.
   O : OPEN CLOSE PRINCIPLE "software component should be open for extension, but closed for modification"
     - class should be designed in such of way whenever any developer want to change the flow control in app, all they
       need to extend the class and override some functions.
     - example is spring framework class DispatcherServlet. This class acts as front controller for spring based web apps.
       To use this class, we are not requiered to modify this class. All we need is to pass initialization parameters and
       we can extend its functionality the way we want.
   L : LISKOVS SUBSTITUTION PRINCIPLE "derived types must be completely substitutable for their base types"
     - It require the objects of the subclases to behave in the same way as the object of the superclass.
     - classes developer create by extending our class , should be able to fit in apps witout failure.  
   I : INTERFACE SEGREGATION "Clients should not be forced to implement unnecessary methods which they will no use"
     - creating two interface by breaking a existing one will give the flexibility to use only the required funcionality.
   D : DEPENDENCY INVERSION PRINCIPLE "depend on abtractions, not on concretions"
     - depeloper should design software in such a way modules can be separated from each other using an abstract layer to
       bind then together.
     - good example is bean configuration in Spring framework. All modules are separate components which can work together by 
       simply injecting dependencies in other modules.This dependency is managed externally in xml files.
       
3. Overiden vs Overloading
       Overriding implements Runtime polymorphism whwreas Overloading implements Compile time polymorphism.
       Overriding: Same method Signature in both superclass and child class.
       Overloading: Same method name but diferents parameters in the same class.
4. What is deep copy and shallow in Java.
       Shallow copy.
       Whenever try to create a copy of an object using shallow copy, all fields of the original objects are copied
       exactly.But if it contains any objets as fields then, only references to those objects are copied not the complete 
       object. if changes are made to the copied object it change the original object also.
       Deep copy.
       Whenever try to create a copy of an object.in the deep copy all fields of the original objects are copied exactly.
       in addition to this, if it contains any objects as fields then copy of those is also created (using the clone method).
5. CI/CD
       Continuos Integration means regulary and frecuently merging and building changes to you software.
       dev->code change->gitlab->automated build->automated test-> [1]
       Continuos Delivery means regulary releasing you software to a destination
       [1]->release->destination(beta server, test server)
       Continuos Deployment is when release goes to customer/end-users (to production)
       Pipeline defines the secuence of the steps (CI pipeline, CD pipeline)
       Pipeline building blocks:
       1. Take from source code repo (gitlab, github) block
       2. build/action block (action could be generate doc using javadoc)
       3. run test block (unit test, integration test, covarage test)
       4. deployment block (the code is deploy in an environment test, beta),AWS Elastick beanstalk,AWS code deploy
       5. aproval block (check to pass the deploy)
       
       