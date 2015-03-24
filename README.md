# Doctor Patient Social Network

This is a web application that allows patients to find doctors based upon the recommendations of other patients. 

### Doctor Interface
Doctors can login to view their profile and read reviews left by patients. 
Doctor profile consists of doctor name, average rating, specialization, work addresses and list of reviews left by patients, with an option to view the individual reviews.




### Patient Interface
Patients interface consists of options to perform doctor search, patient search, add friends and view friend requests. 
* **Patient Search** - One patient searches for another patient by any combination of alias, province and city. For each patient returned the interface shows the alias and home address, the number of reviews written by that patient, and the date of the last review. A link is presented to add the patient as a friend.
* **Doctor Search** - Patient searches for doctors by several criteria: doctor profile attributes (name or part thereof, gender, work address, specialization, and number of years licensed), average star rating greater than a user-specified threshold, whether the doctor has been reviewed by a friend, and review keyword (case insensitive).
* **Patient add friend (accessible form patient search)** - The application tells the patient whether a friendship has been formed (i.e., A added B and B added A) or not yet (i.e., A added B but B has not yet added A).
* **Patient view friend requests** - A patient views a list of other patients who have added them as a friend, but whom this patient has not yet added as a friend. For each patient the alias and e-mail are shown, as well as a link to add that patient as a friend, thus confirming the friendship.
* **View doctor profile (accessible from doctor search)** - Displays profile information (name, gender, work address(es), area(s) of specialization, and number of years licensed), the average star rating, the number of reviews, as well as a list of links to the individual reviews in reverse chronological order (i.e., most recent reviews on top). Also presents a link to write a new review.

### Contributors
* **Abhishek Sisodia**
* **Behroz Saadat**
* **Sabashan Ragavan**
