# RentalCarApp

Renatal car app with database based on text file in csv style.
Application allows to Create, Read, Update, Delete cars and do basic sorts on Car collection.

Run program from main method in MockUpGUI.java

Commands that can be insert to app:
* WYN - rent a car
* ODD - return a car
* WW - show all cars in database
* WD - show only available cars
* WN - show unavailable cars (that has been already rented)
* WT - show cars with specific type (KOMBI, VAN, SUV)
* WC - show cars with specific category (SMALL, MID, VIP)
* ADD - add new Car to database (if new car id already existed in database old one with same id will be overwritten)
* DEL - delete car with specific id
* END - close the app and save database to file

Contains
* Builder pattern
* File reading/writing
* CRUD
* Streams
* Contoller - Service - Repository structure
