# Weather Forecasting Android App

Weather Forecasting Application for "Programing Test for Cookpad Inc./ TOP CAREER International"


### Dependencies

The following Libraries are used in this project:
1- Glide for loading photos.
2- sqliteassethelper: it is used to store the database of countries and their cities. I downloaded the data from http://openweathermap.org/, I wrote a python script to extract the data provided by openweathermap  into a .db sqllite file and then I put the .db file in the android assets so that cities can be accessed locally when the user needs to change settings (I took only the the first 50 cities of each country).
3- Retrofit: is used to call the APIs.


## Project Sturuture:
The MVP Design Pattern is adopted in this project.
Each project user story is divied into:
1 - The contractor : which includes the blueprint of its view and presenter (just interfaces without implementation).
2- An activity that implements the view.
3- A presenter that implements the presenter interface which is described in the contractor.

The activity (view implmenter) is given a presenter object through presenter factories (so that we can easily change the presentor instance without editing the view when we need this e.g. if we want to test the view with dummy data

In this project we have three user stories:
1- Daily Forecasting in which the user can see the weather forecasting for the current day.
2- Weekly Forecasting in which tthe user can the see the weather forecasting for the next 7 days (including today).
3- Settings in which the user can change his city by selecting the counry and then then the city.

In addition to the view, presenter and contractor there are also the following public components:

1- Models : they were separated because they can be used in more than user story..
2- database : a class to manage the local database: it has two main functions get the list of countries & get the list of cities inside a specific country.
3- Fake Data: this class is used for testing views with dummy data before getting the real data from the APIs.
4- Network Callers: A collection of three classes that is used to work with the external APIs using Retrofit library.
5- DataStores: Data Store is a class used to store/retrive the data. it is a general interface that can have different implementations; in this project there are two implementations : a shared preferences data store and network data store. these classes are used for quering the data (see the data query engine below).
6- Data Query Engine: this class is used to ask for a specific data from more than one data store, it checks the data in  the data store one after another. if the data are valid in any of them, a callback function will be called with the retrived data. otherwise a faluire callback will be called.
for example in this project we have shared preferences data store and a network data store.
First query engine tries to get data from the sharedPreferences, if the data are not valid , it asks the network and when the data come back they are saved in all the data stores in a reverese back manner.
in this program max age is set to 5 mintues so the API update is once every 5 mintues.
Note : when you change settings all the cached data are cleared and then the chosen city is saved.


## Authors

* **Alnour Ahmed Khalifa**


## Acknowledgments

* Some Icons are taken from https://icons8.com/android-icons/
