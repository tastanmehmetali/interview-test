
# Travix Flight API Project  
  
  

This is a project skeleton for the Travix Medusa team interview test. BusyFlights is a flights search solution which aggregates flight results initially from 2 different suppliers (CrazyAir and ToughJet). (README.md)
  
  

# Building & Running  
  

On the root of the project, run:  
  

>  **mvn clean build**  
  
  

## Running tests  
  

Using JUnit for testing:  
  
  

### Unit tests  
  

>  **mvn clean test**  
  
  

### Integration tests  
  

>  **mvn clean verify**  
  
  

### Build  
  

>  **mvn clean install**  

All tests should be run and pass after the project should be build. Then run:
	
	java -jar target/busyflights-0.0.1-SNAPSHOT.jar

## Endpoints  
  

The application will be running on *localhost:8080* (**\<host\>**) and the following endpoints will be available:  
  
  

| Type |Service  
|----------------|-------------------------------  
|POST |`<host>/busy/flights`  
|POST |`<host>/crazyair/flights`  
|POST |`<host>/toughjet/flights`  
|GET |`<host>/swagger-ui.html`  
  
  

You can reach to Swagger UI page (/swagger-ui.html). The page is documentation of the API references. Also, you can try the sample request and show the response.  
  
  

## HOW TO USE  
  

REST service for any clients (*Mobile*, *Web* or external app as like *postman* etc.)  
  
  

**Sample BusyFlightsRequest:**  
  
 
> {  
"origin": "LHR",  
"destination": "AMS",  
"departureDate": "2018-12-17",  
"returnDate": "2019-01-15",  
"numberOfPassenger": "4"  
}  
  
  

**You can get the response:**  
  

>[  
{  
"airline": "toughJet",  
"supplier": "TOUGHJET",  
"fare": 105,  
"departureAirportCode": "LHR",  
"destinationAirportCode": "AMS",  
"departureDate": "2018-12-17",  
"arrivalDate": "2019-01-15"  
},  
{  
"airline": "crazyAir",  
"supplier": "CRAZYAİR",  
"fare": 200,  
"departureAirportCode": "LHR",  
"destinationAirportCode": "AMS",  
"departureDate": "2018-12-17",  
"arrivalDate": "2019-01-15"  
}  
]  
  

## Application  
  

SpringBoot, a famous and commonly used framework, is used to develop for the application. SpringBoot has a lot of advantages as like embedded tomcat (not need to download tomcat) etc.  
  

The logic of the application is located the service layer that based on domain objects and used interfaces for loose coupling etc. Also, developing it used ***TDD culture* (Test Driven Development)**.  
  

## Suggestions for improvement  

The project can be improved.  
  
**Validation:** to validate much more cases  
**Docker:** The application can be run on the container (adding a docker file )  
**Log Management:** to show more details and easy to understand for log systems as like *ELK (Elasticsearch, Logstash, Kibana)*  
**Load Balancer:** The request can distribute the load. 
  
  

## Authors  

Mehmet Ali Taştan