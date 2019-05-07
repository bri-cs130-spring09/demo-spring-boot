# Demo Spring Boot Project
## Building
```sh
mvn clean install
```

## Running Locally
```sh
mvn spring-boot:run
```

## Endpoints
### Get All Merchants
`http://localhost:8080/merchants`

### Get Merchant By Id
`http://localhost:8080/merchant/{id}`

### Get Merchants By Name
`http://localhost:8080/merchant?name={name}`

### Add/Update Merchant
`curl -X POST -H "content-type: application/json" -d "{\"id\":1, \"name\":\"Test Merchant\"}" http://localhost:8080/merchants`
