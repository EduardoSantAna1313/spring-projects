### Exemplos de Injeção de depencia usando Spring

* Construtor
  * Não é necessário utilizar @Autowired
* Setter
  * Usar @Autowired no método setter
* Property
  * Usar @Autowired no field
* Profile
  * spring.profiles.active=EN, irá injetar apenas o Service com o @Profile("EN")

Utilizando Qualifier e Primary para definir a injection.

Na annotation @Service é ṕossível informar o value da annotation para ser recuperada pelo @Qualifier

> @Service("myServiceName") public class MyServiceEn implements MyService{} 

Então na classe onde o service será injetado

> @Qualifier("myServiceName") MyService service;