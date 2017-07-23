<h1 align="center">
  <br>
  <a href="http://www.bridgephase.com/"><img src="http://www.bridgephase.com/wp-content/themes/bridgephase/images/logo.png" alt="logo" width="200"></a>
  <br>
  <br>
  Hello World!!
  <br>
</h1>

<h4 align="center">A sample REST application powered by Angular 4 + Spring Boot that is built, tested, and deployed in the AWS cloud with Docker containers using <a href="https://aws.amazon.com/ecs/">ECS</a>.</h4>

<h5 align="center">
Take a tour!

<a href="http://helloworld.bridgephase-demo.com">Application</a>
|
<a href="http://jenkins.bridgephase-demo.com">CI/CD Pipeline</a>
</h5>

[![Build Status](http://jenkins.bridgephase-demo.com/buildStatus/icon?job=helloworld-ci-pipeline)](http://jenkins.bridgephase-demo.com/job/helloworld-ci-pipeline)

## Table of contents

- [Running Locally](#run-locally)
- [AWS Infrastructure](#aws)	 
- [CI/CD](#ci-cd)
    - [Continuous Integration](#continuous-integration)
    - [Continous Delivery](#continuous-delivery)
- [Tests](#tests)

## Running Locally
Be up and running in three steps:   
1. `git clone git@github.com:BridgePhase/hello-world.git`   
2. `cd hello-world`   
3. `./gradlew bootRun`   

## AWS Infrastructure

- Cloud Formation
- EC2
- ELB
- EC2 Container Registry
- EC2 Container Service
- IAM
- Route 53
- S3

## CI/CD

### Continuous Integration

### Continuous Delivery

## Tests
Automated testing is critical to ensuring that an application remains production ready at all times. Well written
tests with high code coverage empower developers to deliver new functionality early and often by ensuring that
all aspects of the application are working as intended. This application utilizes a combination of unit, 
integration, and client testing.

### Running the Tests
- Unit Tests --> `./gradlew test`
- Integration Tests --> `./gradlew intTest`
- Client Tests --> `??`

Or, to build the app and run all of the tests in a single step --> `./gradlew clean build`

## Links
Take a tour!
- [Deployed App](http://helloworld.bridgephase-demo.com)
- [CI/CD Pipeline](http://jenkins.bridgephase-demo.com)