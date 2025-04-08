Autocomplete Wikipedia Mini-Website
Description
In this project, I built a simple Wikipedia-like website that provides autocomplete functionality.
I designed a basic HTML page with a centered textbox, similar to Google’s homepage. As the user types into the textbox, suggestions appear automatically based on their input. These suggestions are not generated on the frontend but are fetched in real time from a backend REST API that I developed.

The backend is responsible for managing the data and quickly returning the best autocomplete matches. 
I used a dataset of famous book titles as the basis for the suggestions and made sure the entire flow between the frontend and backend is smooth and responsive.

How It Works
On the frontend, I created a simple webpage with an input field. Whenever the user starts typing, JavaScript captures the input and sends it to the backend using a fetch request. The backend processes the input and returns a list of matching titles.
These results are then displayed just below the textbox, acting like a dynamic dropdown suggestion box.

For the backend, I used Java with Spring Boot. I loaded a list of popular book titles into the server, and I implemented a fast search using a suffix array approach. 
I built a REST API that listens for queries and returns autocomplete suggestions in JSON format.
The Spring Boot application handles incoming HTTP requests, processes the autocomplete logic, and responds quickly to the frontend.

Dataset Used
To create the autocomplete feature, I used a collection of classic book titles. Some examples include "To Kill a Mockingbird", "1984", "The Great Gatsby", "The Catcher in the Rye", "Moby-Dick", "Pride and Prejudice", and "War and Peace".
In total, the dataset contains 20 well-known titles that users can search through.

How to Run It Locally
To run the project locally, I first set up the backend by creating a Spring Boot application. I started the backend server, which exposed the API at http://localhost:8080/api/autocomplete.

On the frontend side, I simply opened the index.html file in a browser. After that, typing anything in the textbox immediately triggered the autocomplete suggestions coming from the backend.

Features
The website offers fast and responsive autocomplete suggestions in real time. The UI is very simple and clean, focusing only on the textbox and results without any distractions. The communication between the frontend and backend is fully dynamic, meaning there are no page reloads.

I made the design scalable, so it’s easy to add more books or even change the dataset completely to movies, famous people, or other categories if needed.

Future Improvements
In the future, I would like to improve the project by adding keyboard navigation through the suggestions (for example, using the up and down arrow keys). It would also be nice to highlight the parts of the text that match the user's input.
Another idea is to expand the dataset and deploy the project online, using platforms like Vercel for the frontend and Render for the backend.

Technologies Used
For the frontend, I used HTML, CSS, and JavaScript. For the backend, I used Java Spring Boot to build the REST API. These technologies helped me create a smooth and functional mini-website with full autocomplete functionality.
