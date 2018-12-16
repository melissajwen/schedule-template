Schedule Template forked from CodyHouse

[Article on CodyHouse](https://codyhouse.co/gem/schedule-template/)

[Demo](https://codyhouse.co/demo/schedule-template/index.html)

[Terms](https://codyhouse.co/terms/)

=========

Used to create the programming schedule for USC's student run radio station, KXSC. Can be found at kxsc.org/schedule.

TO USE:

1. Clone the repository. This copies all the files here to your local computer. To do this, open up Terminal on your Mac. When you open this up, you're in the root directory, and it's advisable to navigate to a different directory to store this folder, for example, Desktop, or Documents. Say you want to navigate to Documents. In your Terminal, type in the following command:

    `cd Documents/`

      This navigates you to the Documents directory. You can use cd to move in and out of directories. To go in a folder, type `cd` followed by the directory name. To go out, type `cd ..`.
      
      Then, clone the repository. In Terminal, type `git clone git@github.com:melissajwen/schedule-template.git`. This creates a folder schedule-template/ in Documents.
      
      Finally, enter the folder schedule-template/ by typing `cd schedule-template/` in Terminal. You'll see all of the files here copied to that folder.
      
      
2. Next, generate the necessary JSON files for each day. You can write these in a text editor like TextEdit. I personally use Sublime Text, which can conveniently open a variety of files and is pretty lightweight. Once you're done, add those files to the input/ folder. Sample files can be found in the input/sample-fall2018shows/ folder.


3. Then, execute the JAR file. I've compiled all of my Java code into this format so it can be run from the terminal. This JAR file basically takes all of the JSON files in the input/ folder, generates the HTML and JS code needed for the programming schedule, and writes them to two files, htmloutput.html and jsoutput.js, in the output/folder. 

      First, make sure you're in the schedule-template/ directory in Terminal, and you have all the valid JSON files in the input/ directory.
      
      Then, type in the command `java -jar createShowSchedule.jar`. This starts the execution of the JAR file.
      
      You'll see a prompt on the screen asking you to type in the name of a JSON file. Go ahead and type in the JSON name. For example, if you followed the naming conventions I did for the Fall 2018 shows, to generate Friday shows type in `friday.json`.
      
      If the generation was successful, you should get a success message. htmloutput.html and jsoutput.js can be found in the output/ directory.


4. Yay, you generated the code! Copy paste the code right after you generate it into the HTML and JS sections marked with "TO DO" in schedule-template/empty.html. If you open up empty.html in your browser, you should be able to see all the shows taking place on that day.

      Do this for every JSON file.


5. Finally, you have a complete HTML file with all the shows! The last step is to host your custom HTML programming schedule code on Squarespace. Once you're logged into Squarespace, navigate to the Programming Schedule tab, click on 'Edit Page Content', and edit the code block. Copy paste all the code in your populated HTML file into this code block, and save. That's it! 
