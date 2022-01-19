# Integration API

1 POST endpoint, accepts JSON ([example](postman/integration-application.json)). 
Can be requested with some HTTP client ([Postman](https://www.postman.com/), ...).<br/>
Converts incoming payload to the format that the [Bank API](https://github.com/staffsterr2000/test-assignment-bank-api) understands.<br/>
Posts the converted JSON to the [Bank API](https://github.com/staffsterr2000/test-assignment-bank-api). 
Converts [Bank API](https://github.com/staffsterr2000/test-assignment-bank-api) response to the HTTP client response:<br/>
`200 or 400 HTTP code, id {}, status {}`

### Build
Use `gradle build` to build \*.jar<br/>
Run it with [Bank API](https://github.com/staffsterr2000/test-assignment-bank-api) \*.jar and enjoy!
