ContainerRequestFilter(JAX-RS) + CDI @Inject SAMPLE
============================================================

## Build WAR and Deploy to GlassFish 4

```sh
gradlew build
$GLASSFISH_HOME/bin/asadmin deploy --name=sample --contextroot=sample build/libs/jaxrs-cd-filter-injection-sample-1.0-SNAPSHOT.war
```

## Try access to URL

1. [http://localhost:8080/sample/](http://localhost:8080/sample/) (401 Unauthorized)
2. [http://localhost:8080/sample/?username=xxx](http://localhost:8080/sample/?username=xxx) (401 Unauthorized)
3. [http://localhost:8080/sample/?username=sample](http://localhost:8080/sample/?username=sample) (200 OK)
4. [http://localhost:8080/sample/](http://localhost:8080/sample/) (200 OK)

## License

[Apache License Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.txt)
