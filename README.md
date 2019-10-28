# Project03_CS2334

* The problem:

The problem presented by Project03 requires the use of multiple Classes that deal with time. Specifically, the classes most frequently used were LocalDate, DateTimeFormatter, Date, and Calendar. The methods in these classes enabled us to solve the majority of the problems imposed in the project description.

- Problem-solving approach:

The problem-solving approach was similar to Project 2, in that the Main.java is telling us exactly what methods/classes to write and a description of what that method/class should do. The provided SampleOutput.txt also allowed us to see an example of the full output.



* DayTimeOne class:

The constructor of DayTimeOne initializes the classes local variables, which in this case initializes a Calendar and Date object which gets the current date and allows for manipulation later. The sleepForFiveSec() method uses Thread.sleep() method to sleep for 5 seconds if the program begins execution at 55 seconds in a minute. The dateTimeNow() method uses a DateTimeFormatter and the calendar initialized in the constructor to get the date. The dateTimeOfOtherCity() takes a DateTimeFormatter that prints "k:mm" of a given date and prints the local time. Then, the formatter is changed to the other TimeZones using TimeZone.get("timezone"), and the same process is repeated. The dateTimeDifferentZone() method has similar implementations, but stores the different timezone dates in a HashMap and prints it using the corresponding keys. The timeZoneHashMap() method adds two new timezones to the original hashmap and uses the original hashmap's values as keys to a new hashmap. Next, a LocalDateTime array was made and uses a formatter to parse the date values in the original hashmap to create LocalDateTime objects from those dates. The LocalDateTime objects are then added to the array. The original hashmap is then sorted using a treemap and printed out (sorted by timezone names). The second hashmap is then sorted using a treemap and printed out (sorted by dates). Lastly, the array is sorted using Collections.sort(array,Collections.reverseOrder()) to print out the contents in reverse order by date.

* DayTimeTwo class:

A date and map are initialized in the constructor, the date is initialized to the current date when the program executes. The daysOfCurrentMonth() method uses a YearMonth object, initialized to the current date, to find the tenthDay and eighteenthDay using the atDay() method in the class. The tenthDay and eighteenthDay are stored in LocalDateTime variables and the corresponding String is printed using the xDay.getDayofWeek() method. The daysOfAnyMonth() method is similar in implementation as the previos method, but now the lastDay variable will vary depending on the month. A simple if else loop checks the length of the given month, to see if the lastDay needs to be calculated using 31, 30, 29, or 28. The compareYear() method uses a formatter in the format of the dates in the Dates.txt file. Additionally, a BufferedReader and the formatter are used to read in the data and create LocalDateTime objects. Those LocalDateTime's are stored in a hashmap. Using the Period class, we can calculate difference in time between all the dates using the Period.between() method. Taking Math.abs of those values incase the difference between dates is negative yields the correct results. The dateHashMap() method takes the hashmap and prints the keys. The dateHashMapSorted() method uses a treemap to sort the hashmap and prints the keys.

* MesoAsciiCal class:

The arrays that contain all the Ascii letters and their corresponding values are initialized and filled in the constructor. In the calAverage() method, the String stID passed in is broken up into its 4 characters. These 4 characters are compared to the letters[] array to calculate their ascii value. Once all the values are found, they are added up and divided by 4. Then a test is done to see if the decimal value is >= 0.25 for Math.ceil or < 0.25 for Math.floor. Lastly, that average is added to the ascii value of NRMN, which is always 79, and divided by 2. That value is casted to an int and returned.

* MesoEquivalent class:

The constructor initializes the arrayList, hashmap, and other local variables. A BufferedReader is created to read in the stationID's from the Mesonet.txt file. The calAsciiEqual() uses the passed in stID from main to 1) create a Mesonet object, 2) use that Mesonet object to create a MesoAsciiCal object, and 3) use that MesoAsciiCal object to call the calAverage method. Then a for loop is used to do that exact same process, but with each station in the arrayList. Any stations that share the same average are added to the hashmap and returned when the for loop finishes.

* MesoLexicographical class:

This class simply takes in an unsorted hashmap in its constructor, and calls the sortedMap() method to sort it. The sortedMap() method takes the unsorted hashmap, makes a treemap to sort it, prints the keys, and returns the map.
