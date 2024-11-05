users microservice CRUD operations.
add spring boot starter security dependency.
Create SecurityConfig and white list POST /users,POST /authenticate url's
Configure UserDetailsService,BcryptPassword,AuthenticationProvider,AuthenticationManager beans
User Jwts Api to generate JwtToken.