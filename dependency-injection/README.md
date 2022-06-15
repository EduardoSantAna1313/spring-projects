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


### Properties
Criar arquivo de properties. Na classe de config:
> @PropertySource("classpath:myproperties.properties)
> @COnfiguration
> class MyConfig {
>	MyService nyService(@Value("param.name") String name) {
>		return new MyService(name);
>	}
> }

## Não é necessário criar novo arquivo de properties.
Se utilizar o application.properties não será necessário anotar a classe de configuração com @PropertySource.

## Properties para cada ambiente
É possivel definir um arquivo de properties para cada ambiente.
* application.properties (default)
* application-dev.properties (ambiente dev)
* application-qa.properties (ambiente qa)

O ambiente será selecionado de acordo com o profile (spring.profiles.active=EN,dev)