```markdown
# WishApp

This project was generated using Maven Archetype.

## Project Information

- **Group ID**: iNeuron
- **Artifact ID**: WishApp
- **Version**: 1.0
- **Packaging**: war

## Maven Command Used

```sh
mvn archetype:generate -DgroupId=iNeuron -DartifactId=WishApp -Dversion=1.0 -Dpackaging=war -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
```

## Description

WishApp is a web application project created using the Maven archetype for web applications. This project is configured to use the `war` packaging type.

## Directory Structure

```
WishApp/
├── src/
│   ├── main/
│   │   ├── java/
│   │   ├── resources/
│   │   └── webapp/
│   │       ├── WEB-INF/
│   │       └── index.jsp
│   └── test/
│       ├── java/
│       └── resources/
├── pom.xml
└── target/
```

## How to Build

To build the project, navigate to the project directory and run the following command:

```sh
mvn clean install
```

## How to Run

To run the project, deploy the generated WAR file to a servlet container like Apache Tomcat.

## License

This project is licensed under the MIT License.
```