# SpringBoot based Sample REST API project.

## Important 
Controllers in this will require a valid JWT token. 

Sample token to use:
`Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyLCJleHAiOjE3NTUyMDg3NjF9.cdrePNDjet1NOPGwWZZuFZcSdanBUfC3lXEu5zQepfk`

The above token has a subject of "1234567890" which is treated as customerId and will be checked in nz.co.bnz.lapworkshop.rest.CustomerAccountController before returning response.
This token expires in 2025.
Use https://jwt.io/ to generate your own testing token. 
When generating a new token, you'll need to put a base64 encoded key: `aHR0cHM6Ly93d3cuZGVsb2l0dGUuY29tL256L2VuLmh0bWxodHRwczovL3d3dy5kZWxvaXR0ZS5jb20vbnovZW4uaHRtbA==` and a `exp` field (expiry time).


## Sample API URL:
### Sample 1
```
GET http://localhost:8080/v1/clientaccounts/1234567890
Header: Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyLCJleHAiOjE3NTUyMDg3NjF9.cdrePNDjet1NOPGwWZZuFZcSdanBUfC3lXEu5zQepfk
Response:
{
    "customerId": "1234567890",
    "accounts": [
        {
            "balance": 100.00,
            "accountName": "Dummy Account - $100.00"
        },
        {
            "balance": 500.00,
            "accountName": "Dummy Account - $500.00"
        }
    ],
    "movies": [
        {
            "id": 1,
            "name": "The Shawshank Redemption",
            "rating": 9.2
        },
        ...
    ]
}
```

### Sample 2
```
GET http://localhost:8080/v1/clientaccounts/123
Header: Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyLCJleHAiOjE3NTUyMDg3NjF9.cdrePNDjet1NOPGwWZZuFZcSdanBUfC3lXEu5zQepfk
Response:
{
    "errorMessage": "You're not allowed to access this resource."
}
```
