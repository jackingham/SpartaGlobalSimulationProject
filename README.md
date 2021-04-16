<h1 align="center">Sparta Global Simulation Project</h1>
<img alt="Project Sparta Badge" src="https://img.shields.io/badge/project-sparta-%23e43560?label=project&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACQAAAAkCAMAAADW3miqAAABZVBMVEVAIFHkNWBBH1FDHlHiNmBBH1LON2DlNWBcHVH+/v////3FNmFAHlRAG08/H1A+IFFhIU5BHlL9/fxBH05EHVL///xAHlH9//3//v3Y0dnjNl9LLFhCHVRDG08+IU79//v7//vMwtD4+Pi8scF6ZITjNmLfOF5BI1JDHU/28/ZuV3pGKFZEI1FnH08/HU339veDbI7kNV7iN11NHlE/HEv//////P/7/PrVOGPdN2JiIVE8IVFAHU8/H05UHk1AGU1HHUxNHEy8scCklamjk6iCa4p3YYDRNmbKNmLHNmHBNWHnNGCvMGBTH1NAHFHy7PLt6e/Vy9iwpLWwpLSoma6jkKaXf5t6ZoFvVnpgRG1hS2lYPWW1M11NMFqMLViLJ1iVLFd2KVd7JVR2IFOHKFJeIVFaH009GUjg2ePDuMfAucKzqLqxpbiQeZeMe5HaOGTQN2CqNGCmLF+dLFuEKllJJ1lGKFVpXQQhAAACNUlEQVR42qXQhXajWACAYZyQwmVxSrwtbNzdU7fU3X3c5fmHCHMgDcfmj4ePa9A4XBQ50GBxZzQqAMgW28BpWkYccVwwaDdCMNAreP5zVk+l+rg1CBREAu3HH1cbxKvuWQuJXPdhu2pgGAaT9raw2r1sTdUo3H3F8vkBckRqa3VujJDuXS2XN4xXKKdt9v0jIqI/q8NRdFjXHEjb2i4MEYLLL5ukhuVIUqutrc842rgRhmeA0umn2haskXr16inlcdYu0NCgKN3b1nUsp63dtqMcJ3P0IM7vH3ywAB+OJID2DGZmfO+x/mbw/1HJZBKxH7X8vG4avfoIgLD6YX7Y4uL8SsuOkDqBma0/s+nzt4p3FFVaTkO2xBSBGXltwyMzCxmFokIURalh5diO2EaKMIwcOeMBzMKceZ2vVCp8hT8u2geS6wQJY/oIlVV+cSU76BzYR/L3b75tEl/GKMSfvOl00szODm5HEN7tvaQebgt/UbFYZBgOmghncdBtQaPpIstLS0vLK78mFEv7ab/IscOFU6okSd5S7FNrAiFRVAAox6xmeIoKK4qi8uF3SWhq4HJWMg+yVPKGKG8kMd1ArfjRweHB4ftM2BUFg/5mOtpsFi/2XBBiJiAM0wkEOu4IRdHodXzQ2edddyQyq7uxQRmeHyB5OjrNhFRVCYVUhQ9HfkMuaC4kDfMq/JHggs72Z8ftf7wE0xcuJH1W18kdfPoRQLIcDZhFAyjOOc3kgIMQd/Fv6A8ksVwk6PNPnQAAAABJRU5ErkJggg=="/>

A Java group project completed during Sparta Global training.

## About

An agile Java group project completed during training. The software is required to run a simulation of Sparta Global taking in trainees whilst opening centres. The focus of this project is to introduce the group to agile in practice, specifically SCRUM with use of GitHub's project ticket system. 

## Table of Contents
- [Sprint 0](#sprint0)
- [Sprint 1](#sprint1)
- [Sprint 2](#sprint2)
- [Sprint 3](#sprint3)

## :small_blue_diamond: Sprint 0 <a name="sprint0"></a>

### Our Team

Every member is a developer and a tester.

- **Jack Ingham** - SCRUM Master
- **Alex Sikorski** - Documentation Lead
- **Alasdair Malcolm** - Presentation Lead
- **Jakub Matyjewicz** - Git Lead
- **Golam Choudhury** - Test Lead
- **Teniola Betti** - UI Lead
- **Patrick Walsh** - Other Development
- **Abdul Makba** - Other Development

### Tools

- JDK 11
- Maven
- IntelliJ
- JUnit 5
- Log4j
- Git

### Rules

- Do not touch the **master** branch.
- The **feature branches** include software features that then merge in to the **dev** branch.
- Follow **SOLID** principles.
- Strictly adhere to **OOP** for scalability, maintainability, testability, and general robustness.
- Document the project throughout its entirety.
- You must **pair program** whenever you can.


### Our Definition of Done :heavy_check_mark:

1. Code is peer-reviewed.
2. Code is checked in.
3. Code is deployed to test environment.
4. Sprints are documented.
5. Feature is reviewed by stakeholders

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

## :small_blue_diamond: Sprint 1 <a name="sprint1"></a>

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

## Programming Practices

It had been agreed that every member would initialise the project with **interfaces**. These interfaces would simulate a 'contract' that keeps everyone's code consistent.

Upon interface creations, a **test driven development** approach had been utilised. Unit tests were generated for declared methods in interfaces as to aid in developing certain behaviours.

Whenever possible the members pair programmed, this practice helps keep every member up to date with current software implementations and often leads to more efficient problem solving.

## Requirements to Epics

### Epic 1
As a user, I want to track training consistently so that i can review the centres and trainees over a period of time in a console or file output.

#### Solution Summary - *Patrick Walsh*

> Initially discussed and designed 2 interfaces called Output.java and Filewriter.java. We then made a class and implemented the Output Interface. Following Test Driven Development Framework, we began creating the test we needed to pass to fulfil the requirements for each method. Once we had our failing tests, we began peer programming the methods functionality to pass the tests. 

### Epic 2
As a user, I want to be able to input either months, years or a combination of both so there's flexibility in the amount of time I can input.

#### Solution Summary - *Golam Choudhury*

> There is a InputValidator class which contains two methods, getUserInput() and verifyInteger().
>
> getUserInput() simply asks the user what type of timeframe they will like to use (a choice of months, years or months&years).
> After the user inputs their choice, they then input the amount of time they wants elapsed within the simulation, this must be an integer, any other data type will promt the user to retry their input. 
>
> The verifyInteger() method checks the inputted time (e.g. 5 months), if this input is not an integer, the message: "That's not a number" is printed back to the user and the user will be re-promted to input an integer. 

### Epic 3
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

#### :white_check_mark: Continue
> Delivering the consistent hard work from all in the group. - *Patrick*

> To collaborate and execute on tasks. - *Teniola* 

> To work collaboratively using pair programming. - *Golam*

#### :sparkle: Start

> Integrating different areas of the program together to ensure everyone is aware of the program’s functionality. - *Patrick*

> Using a collaborative tool such as the code together plugin in intellij, so we can make more efficient use of our time. (e.g someone can program the app while the other programs the test). - *Abdul*

> Communicating with grouped programmers to ensure shared code stays consistent. - *Alex*

> Spreading the groups more evenly and that if folk’s area struggling, they really need to ask for help before 5mins prior to the deadline. - *Alasdair*

> More diligence in coding. *Teniola* 

> Being more structured with communication. - *Jakub*

> Consulting other groups when shared code needs to be changed. - *Jack*

> Being more structural in group communication, since there is a large enough number of us for this to be required. - *Golam*

> To determine timings much more in advance, to mitigate any timing issues. - *Golam*


#### :negative_squared_cross_mark: Stop 
> Interruptions during solution explanations. - *Patrick*

> Making changes without consensus. *Teniola*

> Losing time on a task which doesn't involve the whole group. - *Jakub*
 
> Leaving debugging code in the presentable software (use logger.debug instead). This can confuse the product owner when reviewing. - *Alex*

## :small_blue_diamond: Sprint 2 <a name="sprint2"></a>

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

## Requirements to Epics

### Epic 1
As the head trainer, I want centres to close when the attendance is too low so that I do not have unnecessarily open centres

#### Solution Summary - *Patrick Walsh*

> During this sprint, Golam and myself agreed that due to the introduction of different types of training centres, which also had a lot of conditions regarding the closing of the centres, we had to ensure we fully understood the logic before programming. We began by writing the pseudocode to help create a clearer picture of what we were designing.
> 
> Once we had completed the pseudocode and created the nested if statement to close the centres in accordance to the requirement, we began managing the trainees that were removed from the closing centres. Initially they are put into an array list, and from then the list is iterated through to then be enters to the front of the waiting list to then continue to be distributed withing the simulation.
> 
> New Class: 
> CenterManager.java
> 
> New Methods: 
> closeCentre(), 
> addDisplacedTraineesToWaitingList()
> 

### Epic 2
As a head trainer I should receive information if a centre has less than 10 attendees so that the trainees can be transferred to a random centre.

#### Solution Summary -  *Alex Sikorski*
> For this epic we essentially created a new class for the existing OutputManager. Here we utilised HashMaps to store counts of certain centre and course types. These HashMaps were populated by iterating through the trainingCentre ArrayList and waitingList Queue. When populated, we simply obtained the key value pairs and printed them out to the user.

#### Solution Summary - *Teniola Betti*

> During this sprint, we extended the functionality of our ‘OutputManager’ to include the new requirements of creating a report for each training hub which is the ’OutputManager Extension ’. The new feature will utilise the simulation to produce the trainees and training centres.
> 
> The new methods utilises a HashMap to store the name of the training centre and a count for the number of occurrences for each. The ‘TraineesWaiting’ is a special case as although it functions similar to the other methods it will produce a total based on the number of trainees waiting for each course.
>
> getNumberOfOpenCentres(), 
>	getNumberOfFullCentres(), 
>	getNumberOfCurrentTrainees(), 
>	getNumberOfTraineesWaiting()
>		
> The ‘generateReport’ method will operate as a generator to produce the data stored within the HashMaps along with information to make the output more user friendly.

### Epic 3
As the head trainer, I want to create different types of centres AND courses so that I can cater to my training demand. 

#### Solution Summary - *Patrick Walsh*

> During the second sprint, we found the additional requirement of labelling different types of training centres quite a challenge in terms of following correct SOLID principles. there was an initial discussion of whether to introduce a 'centre_type' variable to the training centre or to make the training centre a parent class and design 3 new classes that extended the original training centre as parent class. 
> 
> We discussed further and with the understanding that each different type of centre had different contestant values for 'number of trainees enrolled' we believed designing 3 new classes was the correct way forward. The next step was to create 2 ENUM's - CentreTypes and CourseTypes in order to create objects of the training centres/trainees and assign the relevant types at random. 
> 
> New Classes: 
> CentreTypes.java, 
> CourseTypes.java, 
> Bootcamp.java, 
> TechCentre.java, 
> TrainingHub.java

### Sprint Review

### Sprint Retrospective


## :small_blue_diamond: Sprint 3 <a name="sprint0"></a>

### The Requirements

Richard would like the software to have a simple user interaface to run the simulation.

## Requirements to Epics

### Sprint Review

### Sprint Retrospective

