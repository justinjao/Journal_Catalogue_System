# Journal Article Cataloguing System

##### A cataloguing system specifcally designed for organizing scientific writing. Think Goodreads, but for researchers.


## Introduction

**What will the application do?**
 
Scientists read thousands of journal articles over the course of their career. As a result, it can be hard to organize 
the papers that you have previously read (or are planning on reading). The idea for this application is a simple 
cataloguing system for scientific writing. There exist many reference managers like Mendeley whose purpose is to keep 
a record of papers you are using/reading for your research. However, these services are often paid, and usually only 
contain basic functionality for organizing papers by topic (e.g. manually placing papers in folders/subfolders, thus 
only allowing "one category") which are not as helpful to researchers for keeping track of the papers they read and 
how they all relate to each other. This can make it harder to find that "one paper" with the obscure technique you 
read about years ago.

Thus, the primary goal of this project is to design a free application for users to store records of the different 
articles they have/plan to read, and organize them by category, etc. 

If time and skill permits, I would ideally like to implement a more complex structure for assigning category hierarchies 
between topics, as well as maybe implement some interesting summaries and visualizations to get an overview of the 
papers you have read (e.g. what percentage of the papers have you read fall into each category? How have your reading 
topics changed over time?), as well as to allow exporting of this data to make it easier  share your catalogue of papers 
to recommend to others.

**Who will use it?**

Potential users include university students, research scientists, or anyone who consumes a lot of scientific writing 
and seeks a way to organize their readings.

**Why is this project of interest to you?**

Coming from a previous life science background, I have spent *a lot of time* searching through folders of papers I've 
stored to find a certain paper I read about. And I have often wondered about what a summary of the papers I read would 
look like. These all centered around the idea of creating an application centered around organizing papers by topic, 
which is how this idea came to mind.

## User Stories

For base functionality, users should be able to:
- **Add a record of a journal article to the cataloging system** - users should be able to add multiple records of 
different types of articles that they read. 
- **Delete a record of a journal article** - similarly, they should be able to remove any articles they have added.
- **Mark a journal article as read** - every paper should instantiate as unread, but users should be able to mark
them with a "read" status when they have finished reading it, to keep track of which articles they have yet to read.
- **View a list of all the journal articles added** - users should be able to see a list of all the articles they have
added so far.
- **View a list of currently unread journal articles in the system** - users should be able to see a list of all 
articles, filtered for only unread articles.

- **Save records of entered journal articles** - users should be able to save the journal article records entered into
 the system.

- **Re-open cataloging system with previously open state** - after closing and re-opening the application, users should 
be able to resume where they left off, with their article records intact.

## Phase 4: Task 2

I chose to implement build upon my main class to make it more robust. 

One concern with entering in article titles from scientific journals is that they can 
sometimes be very long, which doesn't look great when trying to view all the other papers in the system.

Therefore, I desired to ensure that they can only input strings of a certain length. 

The **Article** class (the main object class in my program) now throws a **StringTooLongException** if a user tries to
 call **setTitle** with a string parameter that is too long. 



