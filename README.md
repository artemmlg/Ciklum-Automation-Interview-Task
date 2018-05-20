# Automation API/GUI Task for Ciklum Automation Unit
## Prerequisites

To run this project you need to have Java and Apache Maven installed on your computer. The manuals on how to do it are stored on the [Java website](https://www.java.com/en/download/help/download_options.xml) the [Apache Project website](https://maven.apache.org/install.html).

- Make sure that JAVA_HOME is set as the environment variable,
- and that Maven (M2_HOME) is set to your PATH environment variable.

## How to run tests:
- Clone/Download project from GitHub: [Project Link](https://github.com/artemmlg/Ciklum-Automation-Interview-Task)
- To run FULL suit (tests), execute following from CMD (console) in project root:
```
mvn clean test
```
- To run only API :running: suit (tests), execute following from CMD (console) in project root:
```
mvn test -Dsurefire.suiteXmlFiles=src/test/resources/api_suite.xml
```
- To run only GUI :walking: suit (tests), execute following from CMD (console) in project root:
```
mvn test -Dsurefire.suiteXmlFiles=src/test/resources/gui_suite.xml
```