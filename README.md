# Rio Olympics Fantasy App 2016

The goal of this app is to submit a workable fantasy sports-style Android app in time for the Rio Summer Olympics in August, 2016. 

# Overview

* I plan to assign each country participating in the Olympics a price, based on predicted medal count
  * Gold medal = 10 points
  * Silver medal = 6 point
  * Bronze medal = 3 points
  * Total predicted medal points for Country A / total available medal points = Country A's predicted share of medal points
  * Country A's predicted share of medal points * multiplier = (some price)
* Price could be put in local currency

# Step 1

* Make a "shoping cart" style e-commerce app. Enable users to shop around for different countries by price, population, predicted golds, silver, bronzes, etc. - done, should add sort feature
* Constrain user to select no more than 6 (7? 8?) countries - done, 8 countries
* SQLite database with Country, Users, Results tables (see ERD image) - countries done, users not
* Country class - done
* ListView and Cursor Adapters -done
* Strings to be held as XML resources (as much as possible) to allow for language translatation and global reach - not done
* Flags and images to add color - not done
* carousel view for instructions - done

# Step 2 and brainstorming

* web API to keep track of top user scores (all teams a good next step)
* connect selections/users to database
* play friends in groups
* facilitate Bitcoin payments via multisig
* user Fiverr or related source to add in real-time updates
* notifications
*
