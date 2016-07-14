# Rio Olympics Fantasy App 2016

A daily fantasy sports-style Android app for the Rio Summer Olympics in August, 2016. 

![alt text]( http://i.imgur.com/RM9gpvy.png "Instructions")

![alt text](http://i.imgur.com/2SK2fL3.png "")

![alt text](http://i.imgur.com/cTISjJZ.png "Instructions")

# Overview

* Assign each country participating in the Olympics a price, based on predicted medal count
  * Gold medal = 10 points
  * Silver medal = 6 point
  * Bronze medal = 3 points
 * (Total predicted medal points for Country A) / (total available medal points) = Country A's predicted share of medal points
 * Country A's predicted share of medal points * some multiplier = (some price) - &#10003; Complete

# Step 1

* "Shopping cart" style e-commerce app. Enable users to shop around for different countries by price, population, predicted golds, silver, bronzes, etc. - &#10003; Complete	
* Constrain user to select no more than 6 (7? 8?) countries - &#10003; Complete with instructional formatting
* SQLite database with Country, Users, Results tables (see ERD image) - Countries &#10003; Complete
* Country class - &#10003; Complete
* ListView and Cursor Adapters -&#10003; Complete
* Strings to be held as XML resources (as much as possible) to allow for language translatation and global reach
* Flags and images to add color 
* Carousel view for instructions &#10003; Complete

# Step 2 

* Integrate a Team class (extends ArrayList) with selected countries, name, whenCreated attributes with Firebase
* Integrate a Results table with Teams in Firebase
* Add in "hashtags" to sort teams based on tags
* Add in all teams view and filter by Hashtag
* Use Fiverr or related source to add in real-time updates
* Notifications?
