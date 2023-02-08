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
<p> I like to use git to upload code to GitHub. Firstly I wrote almost the full code offline and uploaded it to
     GitHub using git. But I also modified the code several times in the IDE and updated it in GitHub pushing the code
      using git.</p>


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
<p>Business Process Model is a very important tool to build a flowing diagram or model. It's a mapping concept. It defines actual flow of data. It is process of creating a structural view of a process or system.</p>
<ul>
<li><a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/app/src/main/res/drawable-v21/business%20process%20diagram.png" target="_blank">Business Process Model</a></li>
</ul>
<p>The logical data model is used for reporting the database elements of a business sector. The entities and the relationships shared by them are the center elements of ER models. The Entity Relationship Diagram (ERD) is a logical data model. ER diagram of my project can be seen from the provided link below.</p>
<ul>
<li><a href="https://github.com/mohammed-mahmudul-hasan/ccms/blob/main/app/src/main/res/drawable-v21/er%20diagram.png" target="_blank">ER Diagram</a></li>
</ul>


<h3>3. DDD</h3>

<p>This DDD model provides a structured and organized way to represent the domain and its concepts and relationships, making it easier to understand and develop a Community Center Management System. Most of them I've already implemented in my project and some components aren't implemented yet like payment system and access management. Check my DDD here.</p>

<h3>4. Metrics</h3>
<p>SonarQube is a popular open-source platform for continuous code quality analysis and improvement. It provides a set of metrics to measure the quality and maintainability of code. These metrics provide valuable insights into the quality and maintainability of code, and can help developers and teams to identify areas for improvement and prioritize their efforts accordingly.</p>
<p>There are some issues as my project is a large project and there are options to improve it in future. Most of the issues shown here suggest to remove the commented line of code and to rename the local variable. However, overall maintainability grade of the whole project is A. I analyzed the project connecting my GitHub repository to SonarCloud.</p>
<p>Here are the metrics I used in SonarQube</p>
<ul>
    <li>Lines of Code (LOC) : 13k</li>
    <li>Reliability Rating: A [0 bugs]</li>
    <li>Code Smells: 663</li>
    <li>Maintainability: A</li>
    <li>Vulnerabilities: 0</li>
    <li>Security Review: A</li>
    <li>Duplications: 17.2%</li>
</ul>
<p>An overview of SonarCloud analysis can be found <a href="https://sonarcloud.io/summary/overall?id=mohammed-mahmudul-hasan_ccms" target="_blank">here</a></p>


<h3>5. Clean Code Development</h3>


<h3>6. Build Management</h3>

<h3>7. Unit-Tests</h3>

<h3>8. Continuous Delivery</h3>




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


<h3>11. Functional Programming</h3>