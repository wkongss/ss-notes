## Maven Notes

 - Maven is a build tool, bundler, and package manager all in one that helps you build, test, and deploy Java packages.
 - Upon creation, the tool will prompt you with:
    - GroupID - a "reversed URL" that determines your package name and layering structure.
    - ArtifactID - the name of your project
    - Version - the production version of the project (defaults to 1.0.0)

 - The package manager side of maven creates a local library (.m2 directory) of all installed internal and remote repositories. Remote repositories (like JUnit) are also installed locally here. These are then refereced using the project coordinates (groupID, artifactID, version).

 - The build process of Maven follows the following sequential steps. If it fails at any point, terminates at that step and outputs an error stack trace:
    0. Clean
    > Cleans up unecessary dependancies
    1. Validate
    > Makes sure your project is complete (i.e. not missing project coordinates)
    2. Compile
    > Compiles your code.
    3. Test
    > Runs unit tests on your project
    4. Package
    > Bundles your project into a .jar or .war executable
    5. Verify
    > Runs integration tests (program-wide tests)
    6. Install
    > Copies the package into your local repository
    7. Deploy
    > Pushes the package into a remote repository


 - The project structure and configuration is controlled through a single file: [pom.xml](pom.xml) (Project Object Model). Uses the Extensible Markup Language (XML) to declare coordinates, dependancies, etc.


57:00