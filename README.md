# FOMODORO API

## User data
    Endpoint: /api/user

    1. GET request
        returns the User with the username specified (JSON Obj).
        JSON object has fields for (id, username, password, points, ownedLocations [JSON Array of names of locations])

        https://server.com/api/user?username=admin

    2. POST request REQUIRED [id, username, password]. JSON Response body format.
        Adds a new user
        Takes in a JSON object. Required fields (id, username, password). Fields not enforced for NotNull but will be initialized
        to null if not initialized.

        https://server.com/api/user

    3. DELETE request REQUIRED [username, location]. Request url param formatting 
                    i.e. .../user?username=[username]&location=[location's name]
        Deletes an owned location from user's owned location list. If location does not exist,
        returns a message that location does not exist. If user does not exist, null pointer exception?
    
    Endpoint: /api/user/points
    1. PUT request REQUIRED ...api/user?username=[username]&points=[points value]
        Updates user's stored points value.

    Endpoint: /api/user/location
    1. PUT request REQUIRED .../api/user?username=[username]&location=[location name]
        Adds a location to a user's ownedLocations JSON array attribute.

## Location data
    Endpoint: /api/location

    1. getLocationInfo(String description)
        GET request
        Takes in the name of the building (description)
        returns the Location JSON Obj

        https://server.com/api/location?description=sexy%20building

    2. addLocation(Location loc)
        POST request JSON Request Body format. REQUIRED fields [latitude, longitude, description] OPTIONAL [ownerUsername]
        Taken in the location JSON obj
        Adds a new location to server.