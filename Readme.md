# Project Title

This is an aromatherapy app that would let user book a therapy session and purchase aromatherapy products online.

## Project Focus

It is a maven project with focus on creating following automation test suite. All tests run against local app on localhost:3000.  
```
1) API test suite - using Junit, Rest Assured and Hamcrest Assertion Library 
2) User Interface test suite - using Cucumber BDD framework, Junit and  Selenium WebDriver
```

## Selenium Features Added

```
1) Page Object Model for easy maintainence, so each page is responsible for webelements available on it and step file simply calls those methods
2) Cucumber feature file implementing BDD approach
3) Uitlity library for common functions  such as captureScreenshot that can be reused
4) Capture Screenshot on failure
5) Get all cookies or search by specific cookie
6) Tests run on desktop and on mobile
7) Use javascript executor for scrolling on page
8) Use of webdriver wait to avoid unncessary failures
9) Junit assertions used
10) Runner file implemented
```

## API Tests Features Added

```
1) All tests run against 'json-server' created API (locations.json)
2) This api is called in frontend using ajax calls, which is triggered when user selects ' store location' from drop down
3) Base Class (FunctionalAPITest) which configures port and baseUrl
4) LocationAPITest.java contains tests for 'Post','Get','Delete'
5) ParameterizedLocationAPITest tests adding a new shop location using combination of data

```

##Frontend Technology
```
 Html, CSS, Javascript, JQuery, Ajax   
```

##Design Considerations
```
Responsive web design
```

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes

### Prerequisites 

All dependencies in pom.xml should be imported
```
Build Tool - Maven
mvn should be available on command line
Programming Language - Java
Testing Framework - Junit
BDD Tool - Cucumber
IDE - Atom
Automation Library - Selenium WebDriver
API Test Library - Rest Assured
API Assertion Library - Hamcrest
```

### Installing

Simulate a backend server and a REST API 
```
Go to src/main/resources/sampleJSON annd run 
json-server --watch locations.json --port 5000
```
Start local web browser 
```
Open Atom IDE > package menu > atom-live-server

```

## Running the tests

Selenium GUI Tests 

```
mvn  test

We can also run selenium test by right clicking on runner file
```

Rest Assured API Tests

```
mvn test

We can also run the api test by right clicking on api tests
```



