// sample test case

Description : Returns the list of all shops
Endpoint : http://localhost:3000/shops
Request : GET
Format: json
Params: no params required
Response:
[
    {
        "id": "Brisbane",
        "address": "23 Lanchester street, Croydon",
        "contact": "Mrs Lee Wonder",
        "email": "brisbane001@cleanwater.com",
        "phone": "(07)-2380002",
        "timeslots": [
            "9:00",
            "10:00",
            "11:00"
        ]
    }, ....

    Scenario 1 :
    Verify status code 200 ok is returned when I hit the above endpoint.
    Steps :
    a) Given test environment is set up correctly and user is authenticated
    b) When user send GET request to endpoint
    c) Then user gets status code 200 ok
    d) And response data is same as above  
