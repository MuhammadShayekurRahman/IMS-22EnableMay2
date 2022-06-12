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
INSERT PICTURE

* Final ERD:
INSERT PICTURE

The initial design consists of only 3 tables, which would create a very basic IMS. In order to create an application which allowed a user to add and delete items from an order, a 4th table 'Order_items' was created to prevent a many-to-many relationship.

### Jira
Project management was implemented through Jira: [Project IMS](https://msrqa.atlassian.net/jira/software/projects/IMS/boards/4/roadmap?shared=&atlOrigin=eyJpIjoiNDc2ZDU4OWRlMzAwNGYyYzk2ZjliNzY4ZTI1ZDEyMTgiLCJwIjoiaiJ9)
The use of user stories and epics allowed myself to effectively carry out tasks and stay on track.


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

INSERT PICTURE OF MENU

The application is seperated into 4 sections: CUSTOMER, ITEM, ORDER, ORDER_ITEMS. The user can interact by typing in Command Line to choose a feature.
The user will then face a choice of Create, Read, Update and Delete functions. 

* [Customer] -> Creating Customer example:
INSERT CREATE PICTURE
INSERT READ PICTURE

* [Item] -> Creating Item example:

* [Order] -> Creating order example:

* [Order_ITEMS] -> Adding item to order example:



End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system. Break down into which tests and what they do

### Unit Tests 

Explain what these tests test, why and how to run them

```
Give an example
```

### Integration Tests 
Explain what these tests test, why and how to run them

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

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
