# AHOY EV-Charging-Spots (unfinished)

# Overview

Create an android to show you nearby electric vehicles charging spots.

# Explanation for being unfinished

I tried a lot to find an API that would help me with getting the positions of Charging stations but couldn't find any free API that could help.
Even google maps don't have a charging station type yet. 
I was planning to get the positions and send them back to Distance API (by Google) to get the distance between my current position and the stations'.
Some of tried APIs:
```
● https://developer.tomtom.com/extended-search-api/documentation/extended-search-api/ev-charging-stations-availability
● https://developer.here.com/documentation/charging-stations/dev_guide/topics/overview.html
● https://developers.google.com/maps/documentation/places/web-service
● https://rapidapi.com/rsafaya/api/edrv-ev-charging/
● https://rapidapi.com/enode-enode-default/api/enode-api/
● https://rapidapi.com/zoal21301/api/electric-vehicle-charging-station-and-point/details
```

# features
```
● Display the nearby charging spots based on the user's current location.
● First you should display a list of the spots ordered by how close they are to the user’s current location.
● The list should have a minimum thumbnail view (up to you to decide what’s important to show).
● There should be a details view when clicking on a specific spot showing the rest of the info.
● To compat the possibly large number of results you may set a max number of results.
● Add appropriate filters to the list view (up to you to decide what’s appropriate).
● A settings view to specify how far the user would like to see results. 
- Add a permission dialog to get the user's current location.
- Made a list-details view for tablets and foldables.(with drag and drop in the details screen) 
```
# What we want you to achieve technical wise
```
1. Your Application must be written in kotlin.
2. Employ proper architectures and patterns as you see fit.
  - MVVM with clean architecture.
3. make your code clean and reusable.
  - Applying SOLID principles.
4. Caching the charging spots info in the local DB and syncing it for user experience.
  - Using room DB to cache the data after fetching it and showing it when there's no Internet.
5. Multiple variants for different environments (staging/production) 
(show how you would handle when there are different environments you don’t actually have now).
  - I have 3 variants Debug\Qa, Staging, Prod.
6. Use multi-module architecture. 
  - Used simple multi Module app and core only there was no need to separate the settings as a module as it was very small.
7. Add some unit tests.
8. Implement Dependency injection in your code 
  - Used Hilt for DI.
```
# Notes
```
● Feel free to make any assumptions, but you may need to justify them.
● Push your work to a GitHub repo and share the link with us
● A short Readme explaining your approach and project parts will be appreciated
● You are also free to prioritize functional and technical requirements (functional and technical) if you think the time is insufficient.
(Note that you may be asked to justify your choices after the task is reviewed).
● Please be prepared to answer questions regarding the work you provided and your approach to completing this project.
```
