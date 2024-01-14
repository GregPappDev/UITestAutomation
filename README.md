![Selenium](https://img.shields.io/badge/-selenium-%43B02A?style=for-the-badge&logo=selenium&logoColor=white) 
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
# UI Test Automation Project 
<ul>
  <li>written in Java</li>
  <li>run on <strong>Selenium Grid</strong></li>
  <li>and <strong>Docker</strong> containers</li>
  <li>in three types of browsers</li>
</ul> 

## Project Description

The primary goal of this demo app is to showcase how to run automated tests in Selenium Grid using Docker containers. For this I used Sauce Labs' demo website: [https://www.saucedemo.com/](https://www.saucedemo.com/) 

The project uses Java and TestNG for the automated tests. Three different browsers (Chrome, Firefox, Edge) run in three separate containers orchestrated by the fourth container running Selenium Grid. When launching the tests, they run parallel in all three browsers.

## Installation and Usage Instructions
<ol>
  <li>clone the project</li>
  <li>to start Selenium Grid with the three nodes run docker-compose-selenium-grid.yml with the following command</li>
  <ul>
    <li>docker-compose -f docker-compose-selenium-grid.yml up</li>
    <li>this step will download Docker images if necessary and will start the Grid in the containers</li>
    <li>you can access the Selenium Grid UI at http://localhost:4445/</li>
  </ul>
  <li>run the test suite in testng.xml in your preferred IDE</li>
  <li>you can observe the tests in the individual containers:</li>
  <ul>
    <li>Chrome - http://localhost:4447/</li>
    <li>Firefox - http://localhost:4448/</li>
    <li>Edge - http://localhost:4449/</li>
    <li>the password for all three instances is 'secret'</li>
  </ul>
</ol>
