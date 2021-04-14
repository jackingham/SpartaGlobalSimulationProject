# Sparta Global Simulation Project

A Java group project completed during Sparta Global training.

## About

An agile Java group project completed during training. The software is required to run a simulation of Sparta Global taking in trainees whilst opening centres. The focus of this project is to introduce the group to agile in practice, specifically SCRUM with use of GitHub's project ticket system. 

## Table of Contents
1. [Sprint 0](#sprint0)
2. [Sprint 1](#sprint1)
3. [Sprint 2](#sprint2)

## Sprint 0 <a name="sprint0"></a>

### Our Team

Every member is a developer and a tester.

**Jack Ingham** - SCRUM Master
**Alex Sikorski** - Documentation Lead
**Alasdair Malcolm** - Presentation Lead
**Jakub Matyjewicz** - Git Lead
**Golam Choudhury** - Test Lead
**Teniola Betti** - UI Lead
**Patrick Walsh**
**Abdul Makba**

### Our Definition of Done &#x2611;

1. Code is peer-reviewed.
2. Code is checked in.
3. Code is deployed to test environment.
4. Code is documented.
5. Feature is reviewed by stakeholders

### Tools Used

- JDK 11
- Maven
- IntelliJ
- JUnit 5
- Log4j
- Git

### Estimation

It had been decided to use the Planning Poker technique to collectively decide how difficult certain user stories/epics are. With this the team assigned the right people to the right tasks, those with more experience in certain programming methods such as logging, user interface and iterations.

### Project Architecture

This project uses a MVC design pattern.

#### Model (Objects)
- Trainee
- TrainingCentre

#### View (Output)
- OutputManager

#### Controller (The Brains)
- SimulationImpl

### Sprint Review

After relevant planning and user stories generation, the product owner had a meeting with the whole team. At this stage the product owner had the opportunity to assess if all requirements had been covered in the user stories created by the team. Once satisfied, the team had the all clear to start working on the project in Sprint 1.

## Sprint 1 <a name="sprint1"></a>

### The Requirements

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

> Initially discussed and designed 2 interfaces called Output.java and Filewriter.java. We then made a class and implemented the Output Interface. Following Test Driven Development Framework, we began creating the test we needed to pass to fulfil the requirements for each method. Once we had our failing tests, we began peer programming the methods functionality to pass the tests. 

## Epic 2
As a user, I want to be able to input either months, years or a combination of both so there's flexibility in the amount of time I can input.

#### Solution Summary - *Golam Choudhury*

> There is a InputValidator class which contains two methods, getUserInput() and verifyInteger().
>
> getUserInput() simply asks the user what type of timeframe they will like to use (a choice of months, years or months&years).
> After the user inputs their choice, they then input the amount of time they wants elapsed within the simulation, this must be an integer, any other data type will promt the user to retry their input. 
>
> The verifyInteger() method checks the inputted time (e.g. 5 months), if this input is not an integer, the message: "That's not a number" is printed back to the user and the user will be re-promted to input an integer. 

## Epic 3
As a user, I want to simulate trainee acquisition so I can predict influx and possible upcoming business decisions.

#### Solution Summary - *Alasdair Malcolm*

> Firstly, we designed the 2 neccesary Interfaces to give a uniformity to the project, then created several unit tests for the expected scenarios drawn from the interfaces.
>
> After that was all completed and merged back to the group project, we implamented our 2 classes "Random Generator" and "SimulationImpl". These allowed for repeated use of a random integer generator and the actual running simulation.
>
> The simulation implamented a main loop, which would run for the input value of months and perform the requirements, generating trainees, generating centres and populating both the centres and waiting list.

### Sprint Review

After an initial attempt, the product had not been fully completed to the product owner’s desire. The out-put modules of the software had not been correctly set up for a demonstration but after clear communication the product owner had been reassured that the current software can be easily fixed. The more technical aspects had been succesfully completed. As a result, the group had organised teams to hot fix the issues as to move on to Sprint 2.

### Sprint Retrospective

#### Continue
> Delivering the consistent hard work from all in the group. - *Patrick*

> To collaborate and execute on tasks. - *Teniola* 

> To work collaboratively using pair programming. - *Golam*

#### Start

> Integrating different areas of the program together to ensure everyone is aware of the program’s functionality. - *Patrick*

> Using a collaborative tool such as the code together plugin in intellij, so we can make more efficient use of our time. (e.g someone can program the app while the other programs the test). - *Abdul*

> Communicating with grouped programmers to ensure shared code stays consistent. - *Alex*

> Spreading the groups more evenly and that if folk’s area struggling, they really need to ask for help before 5mins prior to the deadline. - *Alasdair*

> More diligence in coding. *Teniola* 

> Being more structured with communication. - *Jakub*

> Consulting other groups when shared code needs to be changed. - *Jack*

> Being more structural in group communication, since there is a large enough number of us for this to be required. - *Golam*

> To determine timings much more in advance, to mitigate any timing issues. - *Golam*


#### Stop
> Interruptions during solution explanations. - *Patrick*

> Making changes without consensus. *Teniola*

> Losing time on a task which doesn't involve the whole group. - *Jakub*

## Sprint 2 <a name="sprint2"></a>

### The Requirements

Richard will now check centres each month. If a centre has less than 10 trainees, it will close. The trainees will be randomly moved to another suitable centre

The simulation should now offer the choice of data at the end of the simulation or a running output updated each month

Trainees will now have a course type (Java, C#, Data, DevOps or Business). A trainee will be randomly assigned a course when they are created. This will never change

Sparta now has 3 different types of centre. When a new centre can be opened, one of the following will be randomly chosen

Training Hub: can train a maximum of 100 trainees but 3 can be opened at a time each month

Bootcamp: can train a maximum of 500 trainees but can remain open for 3 months if there are less than 10 trainees in attendance. If a Bootcamp has 3 consecutive months of low attendance, it will close. For the lifetime of the simulation, only 2 Bootcamps can ever exist

Tech Centre: Can train 200 trainees but only teaches one course per centre. This is chosen randomly when a Tech Centre is open

The simulation should report on the following:
- number of open centres (breakdown for each type)
- number of closed centres (breakdown for each type)
- number of full centres (breakdown for each type)
- number of trainees currently training (breakdown for each type)
- number of trainees on the waiting list (breakdown for each type)
