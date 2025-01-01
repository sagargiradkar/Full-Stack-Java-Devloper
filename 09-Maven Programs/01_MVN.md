# Download and Setup Maven

1. **Download Maven**
    - Go to the [Maven download page](https://maven.apache.org/download.cgi) and download the binary zip archive.

2. **Extract the Archive**
    - Extract the downloaded zip file to a directory of your choice, for example, `C:\Program Files\Apache\Maven`.

3. **Set Up Environment Variables**
    - Add the `MAVEN_HOME` environment variable:
        - Open the System Properties dialog (`Win + Pause` -> Advanced system settings -> Environment Variables).
        - Click on `New` under System variables and add `MAVEN_HOME` with the path to your Maven directory, e.g., `C:\Program Files\Apache\Maven`.

    - Add Maven to the `PATH` environment variable:
        - Find the `Path` variable under System variables, select it, and click `Edit`.
        - Add a new entry with `%MAVEN_HOME%\bin`.

4. **Verify Maven Installation**
    - Open a new command prompt and run:
    ```sh
    mvn -version
    ```
    - You should see Maven version information displayed.

# Steps to Create a Maven Project Using Command Line

1. **Open Command Line Interface (CLI)**
    - Open your terminal or command prompt.

2. **Navigate to the Desired Directory**
    - Use the `cd` command to navigate to the directory where you want to create your Maven project.
    ```sh
    cd path/to/your/directory
    ```

3. **Generate a New Maven Project**
    - Use the following Maven command to generate a new project:
    ```sh
    mvn archetype:generate -DgroupId=com.example -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
    ```
    - Replace `com.example` with your desired group ID and `my-app` with your desired artifact ID.

4. **Navigate to the Project Directory**
    - Change to the newly created project directory:
    ```sh
    cd my-app
    ```

5. **Build the Project**
    - Run the following command to build the project:
    ```sh
    mvn package
    ```

6. **Run the Project**
    - Execute the project using the following command:
    ```sh
    mvn exec:java -Dexec.mainClass="com.example.App"
    ```
    - Replace `com.example.App` with the fully qualified name of your main class.

7. **Verify the Project Structure**
    - Ensure that your project structure looks like this:
    ```
    my-app
    ├── pom.xml
    └── src
         ├── main
         │   └── java
         │       └── com
         │           └── example
         │               └── App.java
         └── test
              └── java
                    └── com
                         └── example
                              └── AppTest.java
    ```

You have successfully created and run a Maven project using the command line.

# Compile and Execute the Code

1. **Compile the Code**
    - Navigate to the project directory if you are not already there:
    ```sh
    cd my-app
    ```
    - Run the following command to compile the code:
    ```sh
    mvn compile
    ```

2. **Execute the Code**
    - Use the following command to execute the compiled code:
    ```sh
    mvn exec:java -Dexec.mainClass="com.example.App"
    ```
    - Replace `com.example.App` with the fully qualified name of your main class if it is different.

You have successfully compiled and executed your Maven project.
# Clean the Project

1. **Clean the Project**
    - Navigate to the project directory if you are not already there:
    ```sh
    cd my-app
    ```
    - Run the following command to clean the project:
    ```sh
    mvn clean
    ```
    - This command removes the `target` directory, which contains the compiled classes and built packages.

You have successfully cleaned your Maven project.

# Install Project Dependencies

1. **Install Dependencies**
    - Navigate to the project directory if you are not already there:
    ```sh
    cd my-app
    ```
    - Run the following command to install the project dependencies:
    ```sh
    mvn install
    ```
    - This command will download and install all the dependencies specified in the `pom.xml` file.

You have successfully installed the project dependencies.
# Run the Project from the JAR File

1. **Run the Project**
    - Navigate to the project directory if you are not already there:
    ```sh
    cd my-app
    ```
    - Use the following command to run the project from the JAR file:
    ```sh
    java -cp target\MathProj1-1.0.jar in.ineuron.App
    ```
    - Replace `in.ineuron.App` with the fully qualified name of your main class if it is different.

You have successfully run your Maven project from the JAR file.
