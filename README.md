# Sparta Global Simulation Project

A Java group project completed during Sparta Global training.

## About

Java 11 group project completed during training. The software is required to run a simulation of Sparta Global taking in trainees whilst opening centres. The main focus of this project is to introduce the group to agile in practice, specifically SCRUM with use of GitHub's project ticket system. 

## Tools Used
- JDK 11
- Maven
- IntelliJ
- JUnit 5
- Log4j
- Git

## Our Team
#### Jack Ingham, SCRUM Master.
#### Alex Sikorski, Documentation Lead.
#### Alasdair Malcolm, Presentation Lead.
#### Jakub Matyjewicz, Git Lead.
#### Golam Choudhury, Test Lead.
#### Teniola Betti, UI Lead.
#### Patrick Walsh, Developer.
#### Abdul Makba, Developer.

## Our Definition of Done &#x2611;

Code is peer-reviewed. Code is checked in. Code is deployed to test environment. Code/feature passes regression testing. Code/feature passes smoke testing. Code is documented. Help documentation is updated. Feature is OK’d by stakeholders

# Project Architecture

This project uses a MVC design pattern.

#### Model (Objects)
- Trainee
- TrainingCentre

#### View (Output)
- OutputManager

#### Controller (The Brains)
- SimulationImpl

# Sprint 1 Requirements

The tracker needs to be able to track time in a consistent way.

The program starts by asking how long the simulation will run for.

Every month, a random number of trainees are generated wanting to be trained (20 -30).

Every 2 months, Sparta global opens a training centre. They open instantly and can take trainees every month.

A centre can train a max of 100 trainees and takes a random number of trainees every month. (0 - 20 trainees per month up to the max capacity).

If a centre is full, trainees can be moved to any other centre which is not full.

If all centres are full, the trainees go onto a waiting list. This list must be served first before new trainees are taken.

At the end of the simulation, output should show:
  - Number of open centres
  - Number of full centres
  - Number of trainees currently training
  - Number of trainees on the waiting list

## Requirements to Epics

## Epic 1
As a user, I want to track training consistently so that i can review the centres and trainees over a period of time in a console or file output.

#### Solution Summary - *Patrick Walsh*

> Initially discussed and designed 2 interfaces called Output.java and Filewriter.java. We then made a class and implemented the Output Interface. Following Test > Driven Development Framework, we began creating the test we needed to pass to fulfil the requirements for each method. Once we had our failing tests, we began peer > programming the methods functionality to pass the tests. 

## Epic 2
As a user, I want to be able to input either months, years or a combination of both so there's flexibility in the amount of time I can input.

#### Solution Summary - *Golam Choudhury*

> There is a InputValidator class which contains two methods, getUserInput() and verifyInteger().
>
> getUserInput() simply asks the user what type of timeframe they will like to use (a choice of months, years or months&years).
> After the user inputs their choice, they then input the amount of time they wants elapsed within the simulation, this must be an
> integer, any other data type will promt the user to retry their input. 
>
> The verifyInteger() method checks the inputted time (e.g. 5 months), if this input is not an integer, the message: "That's not a number" is printed back to the user > and the user will be re-promted to input an integer. 

## Epic 3
As a user, I want to simulate trainee acquisition so I can predict influx and possible upcoming business decisions.

#### Solution Summary - *Alasdair Malcolm*

> Firstly we designed the 2 neccesary Interfaces to give a uniformity to the project, then created several unit tests for the expected scenarios drawn from the > interfaces.
>
> After that was all completed and merged back to the group project, we implamented our 2 classes "Random Generator" and "SimulationImpl". These allowed for repeated > use of a random integer generator and the actual running simulation.
>
> The simulation implamented a main loop, which would run for the input value of months and perform the requirements; generating trainees, generating centers and > populating both the centers and waiting list.
