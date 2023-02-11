# Android-app-project
Project Name: Community Center Management System
<p>It is an android application to manage booking system of a community center. The necessary tools used to do this project are:<p>
 <ul>
   <li>Programming Language: Java</li>
   <li>Design: XML</li>
   <li>IDE: Android Studio</li>
   <li>Database: Firebase Firestore</li>
   </ul>
Project demonstration video is availabe <a href="https://www.youtube.com/watch?v=fST_eNgMf7U&ab_channel=MahmudulHasan" target="_blank">here</a>

<h3>Main Features</h3>
<h5>User Home Page</h5>
<ul>
<li>Food Packages (Can see the food packages with price offered by the community center)</li>
<li>Booking (Booking process can be done from this page)</li>
<li>Booking Info. (Booking Information is available here)</li>
<li>Message (Users can send message. Admin’s reply is shown below and users can delete the messaging history)</li>
<li>Rating (Service Rating can be given through this page only after a service is completed successfully by a user)</li>
<li>Contact Us (Contact information of the center)</li>
<li>FAQ (Display frequently asked questions set by admin)</li>
<li>Sign In, Sign Up</li>
<li>Menu Bar (Gallery, Booking History, Update Profile, log out, share, rate app, about)</li>
</ul>

<h5>Admin Home Page</h5>
<ul>
<li>Packages (Update price)</li>
<li>Check booking (Book a date by admin, confirm and cancel booking, delete booking history)</li>
<li>Pending Booking Request (Cancel, Confirm, details show; sort by booked date, sort by request date)</li>
<li>Confirmed Booking Status (Display Upcoming, Current, Previous confirmed booking status list)</li>
<li>Upload Photo (upload photo to display in gallery)</li>
<li>Delete photo (Delete photo from gallery)</li>
<li>Reply message (Users’ messages are displayed; can reply with message, can delete without reply)</li>
<li>Manage FAQ (Add, Update, Delete)</li>
<li>Update rental info (booking cost update)</li>
<li>Log out (log out from app)</li>
</ul>

<h3>1. Git</h3>
<p> I like to use git to upload code to GitHub. Android Studio has built-in support for Git, making it easy to use  Git directly from the IDE. Firstly I wrote almost the full code offline in IDE and uploaded it to GitHub using git. But I also modified the code several times in the IDE and updated it to GitHub pushing the code using git.</p>


<h3>2. UML</h3>
<p>I've created some types of diagram for this project.</p>

<p>Use case diagram is a behavioral UML diagram type. This diagram is used to do analysis on many systems. These diagrams are useful to realize the different types of roles in a system and to detect how those roles interact with system. One of the purposes of a use case diagram is to identify functions and how roles interact with them. Use case diagram is important for a high level view of the system. Internal and external factors can be identified by this. I have created two use case models; one is for admin and the other one is for user(customer).</p>
<ul>
    <li><a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/app/src/main/res/drawable-v21/use_case_user.png" target="_blank">use case diagram (user)</a> </li>
    <li><a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/app/src/main/res/drawable-v21/use_case_admin.jpg" target="_blank">use case diagram (admin)</a> </li>
</ul>
<p>The activity diagram shows the flow between different activity. As my project is a big project, I've shown only the booking process, which is the main feature of the app, in the activity diagram.</p>
<ul>
<li><a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/app/src/main/res/drawable-v24/activity_diagram_updated.png" target="_blank">Activity Diagram</a></li>
</ul>
<p>The sequence diagram shows the user log in system of my project.</p>
<ul>
    <li><a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/folder1/sequence_diagram.jpg" target="_blank">Sequence diagram</a></li>
</ul>
<p>Business Process Model is a very important tool to build a flowing diagram or model. It's a mapping concept. It defines actual flow of data. It is process of creating a structural view of a process or system.</p>
<ul>
<li><a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/app/src/main/res/drawable-v21/business_process_diagram.png" target="_blank">Business Process Model</a></li>
</ul>
<p>The logical data model is used for reporting the database elements of a business sector. The entities and the relationships shared by them are the center elements of ER models. The Entity Relationship Diagram (ERD) is a logical data model. ER diagram of my project can be seen from the provided link below.</p>
<ul>
<li><a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/app/src/main/res/drawable-v24/er_diagram.png" target="_blank">ER Diagram</a></li>
</ul>


<h3>3. DDD</h3>

<p>This DDD(Domain-Driven Design) model provides a structured and organized way to represent the domain and its concepts and relationships, making it easier to understand and develop a Community Center Management System. Most of them I've already implemented in my project and some components aren't implemented yet like payment system and access management. Check my <a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/folder1/ddd.jpg">DDD here.</a> </p>

<h3>4. Metrics</h3>
<p>SonarQube is a popular open-source platform for continuous code quality analysis and improvement. It provides a set of metrics to measure the quality and maintainability of code. These metrics provide valuable insights into the quality and maintainability of code, and can help developers and teams to identify areas for improvement and prioritize their efforts accordingly.</p>
<p>There are some issues as my project is a large project and there are options to improve it in future. Most of the issues shown here suggest to remove the commented line of code and to rename the local variable. However, overall maintainability grade of the whole project is A. I analyzed the project connecting my GitHub repository to SonarCloud.</p>
<p>Here are the metrics I used in SonarQube. I've used badges to show the results of the metrics.</p>
<ul>
    <li> Lines of Code (LOC) : <img src="https://sonarcloud.io/api/project_badges/measure?project=mohammed-mahmudul-hasan_ccms&metric=ncloc" alt=""></li>
    <li>Reliability Rating: <img src="https://sonarcloud.io/api/project_badges/measure?project=mohammed-mahmudul-hasan_ccms&metric=reliability_rating" alt=""></li>
    <li>Bugs: <img src="https://sonarcloud.io/api/project_badges/measure?project=mohammed-mahmudul-hasan_ccms&metric=bugs" alt=""></li>
    <li>Code Smells: <img src="https://sonarcloud.io/api/project_badges/measure?project=mohammed-mahmudul-hasan_ccms&metric=code_smells" alt=""></li>
    <li>Maintainability Rating: <img src="https://sonarcloud.io/api/project_badges/measure?project=mohammed-mahmudul-hasan_ccms&metric=sqale_rating" alt=""> </li>
    <li>Vulnerabilities: <img src="https://sonarcloud.io/api/project_badges/measure?project=mohammed-mahmudul-hasan_ccms&metric=vulnerabilities" alt=""></li>
    <li>Security Rating: <img src="https://sonarcloud.io/api/project_badges/measure?project=mohammed-mahmudul-hasan_ccms&metric=security_rating" alt=""></li>


</ul>
<p>An overview of SonarCloud analysis can be found <a href="https://sonarcloud.io/summary/overall?id=mohammed-mahmudul-hasan_ccms" target="_blank">here</a></p>


<h3>5. Clean Code Development</h3>
<p>Clean code development is a software development practice that emphasizes writing code that is readable, maintainable, and scalable. This approach to coding helps to ensure that the code is easy to understand, debug, and modify.</p>
<p><a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/folder1/cheet_sheet.txt" target="_blank">Here</a> is my personal CCD cheet sheet. I've written it as a text file. Some examples where I've used this cheet sheet are given below:</p>
<ul>
    <li>Readability of the variable and methods name (Cheet Sheet #1): <a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/app/src/main/java/com/example/ccms/login.java" target="_blank">login.java class</a></li>
    <li>Code should be simple and no commented code or dead code (Cheet Sheet #2):<a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/app/src/main/java/com/example/ccms/UpdateProfileActivity.java#L100" target="_blank">UpdateProfileAcivity class</a></li>
    <li>Check text format of user input (Cheet Sheet #4): <a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/app/src/main/java/com/example/ccms/SignupActivity.java#L110" target="_blank">SignUpActivity.java</a></li>
    <li>Write methods in a ctagorised way (Cheet Sheet #3): <a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/app/src/main/java/com/example/ccms/AdminHomePageActivity.java#L35" target="_blank">AdminHomePageActivity</a></li>
    <li>Exception handling (Cheet Sheet #7): <a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/app/src/main/java/com/example/ccms/ContactUsActivity.java#L38">ContactUsActivity</a></li>
</ul>

<h3>6. Build Management</h3>
<p>Android Studio uses the Gradle build system to compile, test, and package your app. Gradle is a powerful and flexible build system that provides a lot of customization options to help you manage your build process.</p>
<p>Check the build.gradle file of my project <a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/app/build.gradle" target="_blank">here.</a> </p>
<p><a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/folder1/build_successful.png" target="_blank">Here</a> is a proof that my project build is successful and apk is generated successfully. Additional <a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/folder1/build_success_message.png" target="_blank">proof</a></p>


<h3>7. Unit-Tests</h3>
<p>Unit testing in Android Studio involves writing tests for individual units of code, such as methods and classes, to ensure that they work as expected. Unit tests are typically run automatically whenever code changes are made, and they provide a fast and convenient way to catch bugs and prevent regressions before they reach users. To write unit tests in Android Studio, you need to create a separate test project, typically within the same repository as the main app project. You can use the JUnit library, which is included with Android Studio, to write and run your tests.</p>


<h3>8. Continuous Delivery</h3>

<p>GitHub Actions is a continuous integration and continuous delivery (CI/CD) platform that allows you to automate your software development workflows. With GitHub Actions, you can create custom workflows to automatically build, test, and deploy your code whenever a code change is pushed to your repository.</p>
<p>For the continuous delivery pipeline I used GitHub Actions. It's Android CI workflow and check the <a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/.github/workflows/android.yml" target="_blank">android.yml file.</a>  Here is the link of the<a href="https://github.com/mohammed-mahmudul-hasan/ccms/actions" target="_blank"> website </a> and a <a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/folder1/github_action.png">screenshot</a> is added to show the workflow of the GitHub Actions.</p>


<h3>9. IDE</h3>
<p>I chose Android Studio as <a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/app/src/main/res/drawable-v24/ide.png" target="_blank"> IDE</a> for doing this project. Though I use Visual Studio Code most of the time to code
    and do small projects, I selected Android Studio as it is very convenient to do android projects. It's also easy
    to use git plugin inside android studio to push and pull code from GitHub.
</p>
<p>Favourite key shorcuts:</p>
<p><li>CTRL + ALT + I : It can auto indent the code with just one press.</li>
    <li>CTRL + Y : It is an option where you can delete the current line where the cursor is at.</li>
    <li>CTRL + D : you can create a duplicate of the current line or the selection by this keyboard shortcut.</li>
    <li>Control+plus or Control+minus : Zoom in/out</li>
    <li>CTRL + SHIFT + E : Recently edited files pop-up.</li>
    <li>CTRL + E : Recently opened files pop-up</li>
    <li>Ctrl + /: Comment/uncomment line or selected text</li></p>


<h3>10. DSL</h3>
<p>DSL stands for Domain-Specific Language, which is a type of computer programming language that is designed to meet the specific needs of a particular domain or problem. DSLs are typically simpler and more focused than general-purpose programming languages, making them easier to learn and use for specific tasks.</p>
<p>My DSL is different from my android project. I've done it seperately. Book fair is held thoughout the country, Bangladesh in february month every year. So, my idea is related to this. The DSL file will list the number of books and diaries sold every day and number of returned books by customers in a book stall. Then the total number of books and diaries sold by a book stall in a week will be calculated by a python code executing this dsl file. The number of returned books will be deducted from the number of sold books.</p>
<p>The <a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/folder1/book_stall.dsl" target="_blank">book_stall.dsl file</a> contains the DSL code and this is converted by a <a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/folder1/dsl_converter.py" target="_blank">python code(.py)</a> that executes each line. Check the <a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/folder1/dsl_output.png" target="_blank">screenshot</a> of the code output. </p>


<h3>11. Functional Programming</h3>
<p>I've tried to do functional programming in my poject as much as possible but as I can do this task outside of my project, I've done this in python programming language seperately for better understanding. Check my code. Specific part or section of the code is linked below to meet the specific requirement.</p>
<ul>
    <li>side effect free functions: <a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/folder1/functional_programming.py#L1" target="_blank">example 1</a> </li>
    <li>the use of higher-order functions: <a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/folder1/functional_programming.py#L18" target="_blank">example 2</a> </li>
    <li>only final data structures: <a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/folder1/functional_programming.py#L67" target="_blank">example 5</a> </li>
    <li>functions as parameters and return values: <a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/folder1/functional_programming.py#L33" target="_blank"> example 3</a></li>
    <li>use closures / anonymous functions: <a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/folder1/functional_programming.py#L47" target="_blank">example 4</a> </li>
</ul>