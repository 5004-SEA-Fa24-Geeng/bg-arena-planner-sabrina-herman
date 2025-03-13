# Report

Submitted report to be manually graded. We encourage you to review the report as you read through the provided
code as it is meant to help you understand some of the concepts. 

## Technical Questions

1. What is the difference between == and .equals in java? Provide a code example of each, where they would return different results for an object. Include the code snippet using the hash marks (```) to create a code block.
   
The == operator compares the actual memory address of the two objects while .equals compares the attributes of the object. The .equals method depends on what is implemented and can be overwritten.

2. ```java
   String string1 = "string";
   String string2 = "string";
   System.out.println(string1 == string2); //False!
   System.out.println(string1.equals(string2); //True!
   String string3 = string1;
   System.out.println(string1 == string3); //True because they share the same reference.
   
   ```




2. Logical sorting can be difficult when talking about case. For example, should "apple" come before "Banana" or after? How would you sort a list of strings in a case-insensitive manner? 

This depends what the programmer wants. If we are sorting by ASCII, capital letters should go first alphabetically, and then lowercase. If we are sorting ignoring case, you can use String.CASE_INSENSITIVE_ORDER to sort your list ingnoring case.



3. In our version of the solution, we had the following code (snippet)
    ```java
    public static Operations getOperatorFromStr(String str) {
        if (str.contains(">=")) {
            return Operations.GREATER_THAN_EQUALS;
        } else if (str.contains("<=")) {
            return Operations.LESS_THAN_EQUALS;
        } else if (str.contains(">")) {
            return Operations.GREATER_THAN;
        } else if (str.contains("<")) {
            return Operations.LESS_THAN;
        } else if (str.contains("=="))...
    ```
    Why would the order in which we checked matter (if it does matter)? Provide examples either way proving your point. 

If you were to use the operator >= and the line about containing > came beforehand, then the program would run the if statement for less than equals because > is contained within >=. This also applies to < and <=. < is in <=, so the line for greater than would run rather than greater than or equal to.


4. What is the difference between a List and a Set in Java? When would you use one over the other? 

A list can include multiples of the same elements and set cannot. Lists also keep the order that they are added in and allow indexing, while sets do not.


5. In [GamesLoader.java](src/main/java/student/GamesLoader.java), we use a Map to help figure out the columns. What is a map? Why would we use a Map here? 

A map is similar to the dictionary in python. It represents a collection of key-value pairs. There are no duplicate keys in a map. We use the map here because we want no duplicate keys, that way the index for each position in the CSV is correct.


6. [GameData.java](src/main/java/student/GameData.java) is actually an `enum` with special properties we added to help with column name mappings. What is an `enum` in Java? Why would we use it for this application?

An enum is a class that can contain a finite amount of elements. It is used in GameData because it makes it easy to access the column names throughout the program, even if the class does not know the specific names of the columns.





7. Rewrite the following as an if else statement inside the empty code block.
    ```java
    switch (ct) {
                case CMD_QUESTION: // same as help
                case CMD_HELP:
                    processHelp();
                    break;
                case INVALID:
                default:
                    CONSOLE.printf("%s%n", ConsoleText.INVALID);
            }
    ``` 

    ```java
    // your code here, don't forget the class name that is dropped in the switch block..
    if (ct.equals(CMD_QUESTION) || CMD_HELP) {
      processHelp();
    } else if (ct.equals(INVALID)) {
      CONSOLE.printf("%s%n", ConsoleText.INVALID);
    }
   
    ```

## Deeper Thinking

ConsoleApp.java uses a .properties file that contains all the strings
that are displayed to the client. This is a common pattern in software development
as it can help localize the application for different languages. You can see this
talked about here on [Java Localization – Formatting Messages](https://www.baeldung.com/java-localization-messages-formatting).

Take time to look through the console.properties file, and change some of the messages to
another language (probably the welcome message is easier). It could even be a made up language and for this - and only this - alright to use a translator. See how the main program changes, but there are still limitations in 
the current layout. 

Post a copy of the run with the updated languages below this. Use three back ticks (```) to create a code block. 

```text
*******Bienvenido al planificador de arena de BoardGame.*******

Una herramienta para ayudar a las personas a
planificar los juegos que quieren jugar en Board Game Arena. 
```

Now, thinking about localization - we have the question of why does it matter? The obvious
one is more about market share, but there may be other reasons.  I encourage
you to take time researching localization and the importance of having programs
flexible enough to be localized to different languages and cultures. Maybe pull up data on the
various spoken languages around the world? What about areas with internet access - do they match? Just some ideas to get you started. Another question you are welcome to talk about - what are the dangers of trying to localize your program and doing it wrong? Can you find any examples of that? Business marketing classes love to point out an example of a car name in Mexico that meant something very different in Spanish than it did in English - however [Snopes has shown that is a false tale](https://www.snopes.com/fact-check/chevrolet-nova-name-spanish/).  As a developer, what are some things you can do to reduce 'hick ups' when expanding your program to other languages?


As a reminder, deeper thinking questions are meant to require some research and to be answered in a paragraph for with references. The goal is to open up some of the discussion topics in CS, so you are better informed going into industry.

The Internet Society Foundation says that while 55.0% of websites on the internet are written in English, English is only spoken by 16% of the world population. [^1] This is something that can be improved through localization. Localization is important not only through translating your program, but making sure the correct meaning is gotten across. There are other parts of localization other than just translation to consider. One example is dates and times. In an example given by Lokalise, data is in the Month/Day/Year in the United States. In other places the date can be printed as Day/Month/Year. [^2] Localization matters not just because of translation, but making sure your software formats data correctly to not cause confusion. A software program that causes misunderstanding on correct dates could cause a company much time and confusion.

## References

[^1]: What are the most used languages on the Internet?: 2023. https://www.isocfoundation.org/2023/05/what-are-the-most-used-languages-on-the-internet/. Accessed: 2025-03-12.

[^2]: What is software localization? 10 best practices & examples: 2024. https://lokalise.com/blog/software-localization/. Accessed: 2025-03-12.