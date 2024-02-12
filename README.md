# Spring Boot Conference Planner Project

Spring Boot Web application to provide REST API in JSON.

<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/TolunayToprakkaya/conference-planner.git
   ```
2. Install NPM packages
   ```sh
   npm install
   ```
3. Build application
   ```sh
   java -jar .\target\ConferencePlanner-0.0.1-SNAPSHOT.jar
   ```
4. Run the test suite
   ```sh
   mvn clean test
   ```
<!-- API DESCRIPTIONS -->
## API Descriptions

### Create conference plan
```
POST /api/conference/createConference
Accept: application/json
Content-Type: application/json

[
    {
        "title": "Architecting Your Codebase",
        "duration": 60
    },
    {
        "title": "Overdoing it in Python",
        "duration": 30
    },
    {
        "title": "Flavors of Concurrency in Java",
        "duration": 30
    },
    {
        "title": "Ruby Errors from Mismatched Gem Versions",
        "duration": 30
    },
    {
        "title": "JUnit 5 - Shaping the Future of Testing on the JVM",
        "duration": 30
    },
    {
        "title": "Cloud Native Java lightning"
    },
    {
        "title": "Communicating Over Distance",
        "duration": 60
    },
    {
        "title": "AWS Technical Essentials",
        "duration": 45
    },
    {
        "title": "Continuous Delivery",
        "duration": 30
    },
    {
        "title": "Monitoring Reactive Applications",
        "duration": 30
    },
    {
        "title": "Pair Programming vs Noise",
        "duration": 45
    },
    {
        "title": "Rails Magic",
        "duration": 60
    },
    {
        "title": "Microservices 'Just Right'",
        "duration": 60
    },
    {
        "title": "Clojure Ate Scala (on my project)",
        "duration": 45
    },
    {
        "title": "Perfect Scalability",
        "duration": 30
    },
    {
        "title": "Apache Spark",
        "duration": 30
    },
    {
        "title": "Async Testing on JVM",
        "duration": 60
    },
    {
        "title": "A World Without HackerNews",
        "duration": 30
    },
    {
        "title": "User Interface CSS in Apps",
        "duration": 30
    }
]

RESPONSE: HTTP 201 (Created)
[
    {
        "id": 1,
        "title": "Architecting Your Codebase",
        "duration": 60
    },
    {
        "id": 2,
        "title": "Overdoing it in Python",
        "duration": 30
    },
    ...
    ...
    ...
]
```
### Fetch conference plan data with get request
```
Get /api/conference
Accept: application/json
Content-Type: application/json

Response: HTTP 200
[
    "Track 1:",
    "09:00 Architecting Your Codebase 60min",
    "10:00 Communicating Over Distance 60min",
    "11:00 Rails Magic 60min",
    "12:00 Lunch",
    "13:00 Microservices 'Just Right' 60min",
    "14:00 Async Testing on JVM 60min",
    "15:00 AWS Technical Essentials 45min",
    "15:45 Pair Programming vs Noise 45min",
    "16:30 Overdoing it in Python 30min",
    "17:00 Networking Event",
    "Track 2:",
    "09:00 Clojure Ate Scala (on my project) 45min",
    "09:45 Flavors of Concurrency in Java 30min",
    "10:15 Ruby Errors from Mismatched Gem Versions 30min",
    "10:45 JUnit 5 - Shaping the Future of Testing on the JVM 30min",
    "11:15 Continuous Delivery 30min",
    "12:00 Lunch",
    "13:00 Monitoring Reactive Applications 30min",
    "13:30 Perfect Scalability 30min",
    "14:00 Apache Spark 30min",
    "14:30 A World Without HackerNews 30min",
    "15:00 User Interface CSS in Apps 30min",
    "15:30 Cloud Native Java lightning 5min",
    "17:00 Networking Event"
]
```
