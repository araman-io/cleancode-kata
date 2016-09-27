Test Sorting Balls
 
 We use sorting routines all the time; putting customer records in to name order, arranging orders by value. Most of the time we (wisely) use one of the sort routines built in to our language’s library (such as C’s qsort and Java’s java.Collections.sort). After all, very clever folks spent a lot of time getting these library routines tuned for speed and/or memory usage.
 However, there are times when whipping up a sort of our own can outperform these generic routines. 
 Sorting Balls
 In the Pragmatic Lottery (motto: There’s One Born Every Minute, and it Might Just Be You!), we select each week’s winning combination by drawing balls. There are sixty balls, numbered (not surprisingly, as we are programmers) 0 to 59. The balls are drawn by the personable, but somewhat distracted, Daisy Mae. As a result, some weeks five numbers are drawn, while other weeks seven, nine, or even fifteen balls make it to the winner’s rack. Regardless of the number of balls drawn, our viewers need to see the list of winning numbers in sorted order just as soon as possible. So, your challenge is to come up with some code that accepts each number as it is drawn and presents the sorted list of numbers so far. 

Rules
 Don’t use the ELSE keyword
 Wrap all primitives and Strings
 First class collections
 Don’t abbreviate
 Keep all entities small (50 lines)
  
Extending
  Extend your code if required to support multiple draws
  Extend your code to support query of historical draws
  Extend your code to keep the actual and sorted draw ball orders

