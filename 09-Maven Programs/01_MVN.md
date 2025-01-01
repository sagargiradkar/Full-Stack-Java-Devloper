Here's a summary and expansion of the notes you've shared, with additional details for clarity:

---

## **Download and Setup Maven**

### 1. **Download Maven**
   - Visit the [Maven download page](https://maven.apache.org/download.cgi).
   - Download the binary zip archive suitable for your operating system.

### 2. **Extract the Archive**
   - Extract the zip file to a directory, such as:
     - Windows: `C:\Program Files\Apache\Maven`
     - Linux/Mac: `/usr/local/apache-maven`

### 3. **Set Up Environment Variables**
   - **On Windows:**
     1. Open System Properties (`Win + Pause` -> Advanced system settings -> Environment Variables).
     2. Under "System Variables":
        - Click `New`, set `Variable name` as `MAVEN_HOME`, and `Variable value` as your Maven directory (e.g., `C:\Program Files\Apache\Maven`).
        - Edit the `Path` variable, adding `%MAVEN_HOME%\bin`.

   - **On Linux/Mac:**
     1. Open the terminal and edit the shell configuration file (`~/.bashrc` or `~/.zshrc`):
        ```bash
        export MAVEN_HOME=/path/to/maven
        export PATH=$MAVEN_HOME/bin:$PATH
        ```
     2. Save and reload the shell configuration:
        ```bash
        source ~/.bashrc
        ```

### 4. **Verify Maven Installation**
   - Open a terminal or command prompt and run:
     ```bash
     mvn -version
     ```
   - A successful setup displays Maven version details.

---

## **Steps to Create a Maven Project Using Command Line**

### 1. **Open Command Line Interface**
   - Use the terminal/command prompt.

### 2. **Navigate to the Desired Directory**
   - Move to the directory where you want to create the project:
     ```bash
     cd path/to/your/directory
     ```

### 3. **Generate a New Maven Project**
   - Use the following command:
     ```bash
     mvn archetype:generate \
       -DgroupId=com.example \
       -DartifactId=my-app \
       -DarchetypeArtifactId=maven-archetype-quickstart \
       -DinteractiveMode=false
     ```
   - Replace:
     - `com.example` with your group ID.
     - `my-app` with your artifact ID.

### 4. **Navigate to the Project Directory**
   ```bash
   cd my-app
   ```

### 5. **Build the Project**
   ```bash
   mvn package
   ```

### 6. **Run the Project**
   - Run the main class:
     ```bash
     mvn exec:java -Dexec.mainClass="com.example.App"
     ```
   - Replace `com.example.App` with your main class name.

---

## **Compile and Execute the Code**

### 1. **Compile the Code**
   ```bash
   mvn compile
   ```

### 2. **Execute the Code**
   ```bash
   mvn exec:java -Dexec.mainClass="com.example.App"
   ```

---

## **Clean the Project**
   ```bash
   mvn clean
   ```
   - Removes temporary files (e.g., `target` directory).

---

## **Install Project Dependencies**
   ```bash
   mvn install
   ```
   - Installs project dependencies and builds artifacts in the local Maven repository.

---

## **Run the Project from the JAR File**

1. **Package the JAR File**
   ```bash
   mvn package
   ```

2. **Run the JAR File**
   ```bash
   java -cp target/my-app-1.0-SNAPSHOT.jar com.example.App
   ```
   - Replace `com.example.App` with your main class.

---

## **Clean and Package the Project**

1. **Clean and Package**
   ```bash
   mvn clean package
   ```

---

## **Default Lifecycle of Maven**

Maven's default lifecycle consists of **phases**, each performing specific tasks:

1. **validate**: Validates project structure and configuration.
2. **compile**: Compiles the source code.
3. **test**: Executes unit tests.
4. **package**: Packages compiled code into distributable formats (e.g., JAR, WAR).
5. **verify**: Verifies package integrity.
6. **install**: Installs the package into the local Maven repository.
7. **deploy**: Uploads the package to a remote repository for sharing.

By following these steps, you can manage your Maven projects efficiently. Let me know if you want more details on any part!

Here are the Maven commands corresponding to each phase of the default lifecycle:

### **1. Validate**
Validates the project structure and configuration.
```bash
mvn validate
```

### **2. Compile**
Compiles the source code.
```bash
mvn compile
```

### **3. Test**
Executes unit tests using the appropriate testing framework (e.g., JUnit).
```bash
mvn test
```

### **4. Package**
Packages the compiled code into a distributable format, such as a JAR or WAR.
```bash
mvn package
```

### **5. Verify**
Verifies the integrity of the package, ensuring it meets quality criteria.
```bash
mvn verify
```

### **6. Install**
Installs the package into the local Maven repository for use in other projects.
```bash
mvn install
```

### **7. Deploy**
Deploys the package to a remote repository, making it available to other developers or projects.
```bash
mvn deploy
```

You can execute these commands in sequence as needed, or run a specific phase to execute that and all preceding phases automatically. For example:

- Running `mvn package` will execute `validate`, `compile`, `test`, and `package`.
- Running `mvn install` will execute all preceding phases, up to and including `install`.