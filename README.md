<a name="readme-top"></a>

# Parcial 

> Este proyecto implementa un sistema de detección de mutantes basado en secuencias de ADN.

## Hecho con

- Java 
- Spring Boot
- Gradle

### Uso de la Api

1. Para verificar una secuencia de ADN, envía una solicitud POST a /mutant/ con el siguiente formato JSON:
   
  ```json
{
  "dna": ["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
   ```


### La API responderá con:

. 200 OK si la secuencia es de un mutante
. 403 Forbidden si la secuencia no es de un mutante



