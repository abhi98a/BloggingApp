# Blogging App(Spring Boot)

## Development

## Database Setup

### Postgres

1. Create a postgres database
2. Create a user
3. Create a password
4. Grant access to created database to user

```postgresql
Create DATABASE blog;
Create USER blogadmin with encrypted password 'blogpass';
GRANT all privileges ON DATABASE blog TO blogadmin;
```

