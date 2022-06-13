Coverage: 71.1%
# Inventory Management System

An inventory management system which implements CRUD functionality, the purpose of this project is to be able to create an application which has a command line interface and allows a user, in this instance a data admin, to:
* Create Customer information, an invetory of items, an Order which is assigned to customer.
* Read all information, in an informative and clean manor.
* Update details of Customers, Items and Orders.
* Delete records of Customers, Items and Orders.
* Add and remove Items purchased by a customer
* Find the total cost of an order.


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

## Planning
### Database ERD
* Initial ERD:


![ERD version 1](https://user-images.githubusercontent.com/105277382/173213745-b3d36518-d6f6-42c4-8d41-4c2535f9ab10.png)


* Final ERD:


![ERD version 2](https://user-images.githubusercontent.com/105277382/173213750-7a327caf-78a0-4faf-aaa4-7889291b90a6.png)



The initial design consists of only 3 tables, which would create a very basic IMS. In order to create an application which allowed a user to add and delete items from an order, a 4th table 'Order_items' was created to prevent a many-to-many relationship.

### Jira
Project management was implemented through Jira: [Project IMS](https://msrqa.atlassian.net/jira/software/projects/IMS/boards/4/roadmap?shared=&atlOrigin=eyJpIjoiNDc2ZDU4OWRlMzAwNGYyYzk2ZjliNzY4ZTI1ZDEyMTgiLCJwIjoiaiJ9)
The use of user stories and epics allowed myself to effectively carry out tasks and stay on track.
![image](https://user-images.githubusercontent.com/105277382/173213782-8d4114f9-cfab-4435-bec7-2023ab1161c4.png)


### Prerequisites

What things you need to install the software and how to install them

* Version Control System - [Git](https://git-scm.com/downloads)
* Source Code Management - [GitHub](https://github.com/)
* Kanban Board - [Jira](https://www.atlassian.com/software/jira)
* Database - [MySQL Server 5.7+](https://www.mysql.com/products/workbench/)
* Back-end Programming Language - [Java](https://www.oracle.com/java/technologies/downloads/)
* Build Tool - [Maven](https://maven.apache.org/download.cgi)
* Unit Testing - [JUnit](https://junit.org/junit4/)

Information on how to install can be found by using the links provided.

### Installing

* In order to run the application, the user must first clone the repository [IMS-22EnableMay2](https://github.com/MuhammadShayekurRahman/IMS-22EnableMay2).

In Git Bash, the user may enter `git clone git@github.com:MuhammadShayekurRahman/IMS-22EnableMay2.git` this will download the project locally.

* The user should create a database in a local host or server by using the code for schema.
The path for the required .sql file: `IMS-22EnableMay2\src\main\resources\sql-schema.sql`
By doing so, the user creates a new database in which information can be added.

* Running Application:
The executable file which the user requires is run on Command Line, and here they will be able to use the application.
The path for the required .jar file: `IMS-22EnableMay2\ims-0.0.1-jar-with-dependencies.jar`

The Command Line should be opened in the parent directory, and the following line input to run the file: `java -jar ims-0.0.1-jar-with-dependencies.jar`

Welcome! You should now have the invetory management system running and ready to use.

![image](https://user-images.githubusercontent.com/105277382/173213885-d26b61a7-9dfc-4509-ad44-01f3129ec1ee.png)

The application is seperated into 4 sections: CUSTOMER, ITEM, ORDER, ORDER_ITEMS. The user can interact by typing in Command Line to choose a feature.
The user will then face a choice of Create, Read, Update and Delete functions. 

* [CUSTOMER] -> Creating Customer example:

![image](https://user-images.githubusercontent.com/105277382/173213988-754a9bfd-acb7-45fa-9dd2-5978b66109f7.png)

* [ITEM] -> Creating Item example:

![image](https://user-images.githubusercontent.com/105277382/173214029-a764e849-2083-4048-a2e2-a35658928025.png)


* [ORDER] -> Creating order example:

![image](https://user-images.githubusercontent.com/105277382/173214067-961c7a55-994e-4ad4-81a1-80602dcbabb0.png)

*The default order cost is 0 as there are no items assigned to the order.*

* [ORDER_ITEM] -> Adding item to order example:

![image](https://user-images.githubusercontent.com/105277382/173214107-643d3ac8-0e24-4c63-b97d-1abaee246efa.png)


* The following shows Total Order Cost, after adding a new item to the order: [HOME] -> [ORDER] -> [READ]


![image](https://user-images.githubusercontent.com/105277382/173214239-2649562a-a703-4749-becf-540699383771.png)

* The following shows list of items in (all) orders: [HOME] -> [ORDER_ITEMS] -> [READ]


![image](https://user-images.githubusercontent.com/105277382/173214287-e8cd57bf-f664-4dfd-a04c-fffe2b492613.png)


## Running the tests

In order to run the tests for the project, In eclipse, the user would right click the project folder -> Coverage As -> JUnit Test.

* There are 53 tests in total, Using JUnit Testing for Domain and DAO classes, and Mockito for Controller Classes.


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [GitHub](https://github.com/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Jordan Benbelaid** - *Forked Repository* - [jordanbenbelaid](https://github.com/jordanbenbelaid)
* **Muhammad Shayekur Rahman** - *Final Project* - [muhammadshayekurrahman](https://github.com/MuhammadShayekurRahman)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Thank you to Cameron Guthrie and Jordan Benbelaid for providing me knowledge to complete this project.
