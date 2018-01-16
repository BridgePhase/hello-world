<h1 align="center">
  <br>
  <a href="https://user-images.githubusercontent.com/10728023/35013746-57c91e78-fadc-11e7-959b-619355e625c4.png" alt="logo" width="200"></a>
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

- [About](#about)
- [AWS Infrastructure](#aws)	 
- [CI/CD](#ci-cd)
- [Tests](#tests)

## <a name="about"></a>About

### Overview
This is a single page application that utilizes the latest version of Angular to perform a single HTTP request to a REST endpoint exposed by a Tomcat server embedded within a Spring Boot JAR that runnig in a Docker container on an EC2 instance within an ECS cluster.   

We could have simply served a static web page with no REST call but who wants to read about that?
    
__The application is highly available__. The ECS cluster contains EC2 instances running in separate availability zones (AZ). If hardware fails or an an issue arises in one availability zone the application containues to service requests in the other AZ.

#### Automation
__Automation is critical__ to delivering new functionality quickly and reliably. The DevOps model utilzied for this application includes a fully automated solution that allows changes to be deployed to the AWS cloud in a matter of minutes __with zero service interruption__ thanks to the use of load balancing and ECS.  
![automation-flow](https://user-images.githubusercontent.com/10728023/28594276-62a0d0c4-715d-11e7-86b0-4f5c4c0c4118.png)

#### Worklow
1. Commit to the CI-DEV branch either locally or through pull request.
2. Github webhooks publish the event to Jenkins.
3. A [Git webhook job](http://jenkins.bridgephase-demo.com/job/helloworld-ci-githook/) receives the event and triggers a [CI job](http://jenkins.bridgephase-demo.com/job/helloworld-ci-pipeline/).
4. The Jenkins job:   
	a. Builds the app   
    b. Executes tests   
    c. Performs quality checks   
    d. Builds/pushes a Docker image   
    e. Initiates a [deployment job](http://jenkins.bridgephase-demo.com/job/helloworld-deploy/)   
5. Changes are deployed to ECS. The application is available at all times.
    

### Running Locally
Be up and running in three steps:   
1. `git clone git@github.com:BridgePhase/hello-world.git`   
2. `cd hello-world`   
3. `./gradlew bootRun`   

## <a name="aws"></a>AWS Infrastructure   
All of the computing, networking, and storage resources that are used to build, test, deploy, and host this application are provided by AWS. Specific resources include: 

### Cloud Formation   
Cloud Formation is a flexible and powerful way to manage Infrastructure as code (IaC). All infrastructure needed for the Jenkins stack was created using a single Cloud Formation Template.   

[View the template.](https://github.com/BridgePhase/hello-world/blob/master/cloud_formation/jenkins-resources.json)   

### Elastic Cloud Compute (EC2)
Elastic Cloud Compute instances are the backbone of AWS bound applications. Both the Jenkins stack and the ECS cluster are backed by EC2.   

### Elastic Load Balancer (ELB)
Synchronous decoupling of web requests from resource locations for this application is acheived through the use an Elastic Load Balancer instance. The ELB distributes traffic to EC2 instances within the ECS cluster; allowing for EC2 instances to be created and destroyed without the need for remapping IP addresses or URLs.

### EC2 Container Registry (ECR)
Docker images utilized by ECS for the Hello World app are stored in an ECR repository. ECR provides seamless integration with ECS in addition to compatibility with standard Docker push/pull specifications.

*pull spec -->*`<...>/bridgephase-demo/helloworld:<tag>`

### EC2 Container Service (ECS)
Container orchestration is acheived through ECS. A cluster, service, and task definitions are used to manage deployments, scaling, and versions of the containerized application.

### Identity & Access Management (IAM)
Access to infrastructure for the application and Jenkins is managed through IAM groups, users, and roles. [AWS security best practices](https://aws.amazon.com/whitepapers/aws-security-best-practices/) are utilized to ensure that resources are accessed and exposed securely. VPC subnets are private by default and only made public for external facing resources.

### Route 53
The `bridgephase-demo.com` domain name is registered and maintained through Route 53. Route 53 record sets are utilized for the `jenkins` and `helloworld` subdomains.

#### Simple Storage Service (S3)
Jenkins backups are stored in a dedicated S3 bucket. The S3 bucket reference is specified in the [Jenkins Cloud Formation Template](https://github.com/BridgePhase/hello-world/blob/master/cloud_formation/jenkins-resources.json).

## <a name="ci-cd"></a>CI/CD
Git, Gradle, Jenkins, and the AWS CLI are all utilized to automate the integration of new code into the master branch of the repository as well as the automated deployment of newly integrated code.

### Continuous Integration
Code changes are integrated with the master branch after undergoing automated testing and quality checks. Automated CI steps for this project include:
* SCM checkout from Github
* Compilation of source code and resources
* Automated testing (unit, integration, client) and code coverage reporting
* Git tagging, merging, and pushing of newly integration changes

### Continuous Delivery
Automated CD steps for this project include:
* Docker image builds, tags, and pushes
* ECS task definition registration through the AWS CLI and Cloud Formation Templates
* ECS deployments of newly pushed containers through the AWS CLI

## <a name="tests"></a>Tests
Automated testing is critical to ensuring that an application remains production ready at all times. Well written
tests with high code coverage empower developers to deliver new functionality early and often by ensuring that
all aspects of the application are working as intended. This application utilizes a combination of unit, 
integration, and client testing.

### Running the Tests
- Unit Tests --> `./gradlew test`
- Integration Tests --> `./gradlew intTest`

Alternatively, to build the app and run all of the tests in a single step --> `./gradlew clean build`
