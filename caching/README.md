# Getting Started

Projeto para testar o uso de cache com a lib [Caffeine](https://github.com/ben-manes/caffeine/wiki/Testing).

## Setup

Este projeto utiliza as seguintes bibliotecas:
- Spring 3.1.1
- Caffeine 3.1.6
- spotless 2.37.0
- lombok

## Rodando o projeto local

A aplicação irá subir na porta 8888. Teste via cURL:

```bash
curl --request POST \
  --url http://localhost:8888/token \
  --header 'Content-Type: application/x-www-form-urlencoded' \
  --data client_id=59ad9061-01d2-45fd-8262-47c47a045a0a
```

## Código

- `CacheConfig`:
Define uma configuração para o cache.
Nela podemos setar a duração do cache e tamanho, por exemplo.
Foi utilizado expireAfterWrite de apenas 2 segundos para tester o funcionamento correto do cache. 
- `OAuthService`:
Classe responsável por gerar um token. Faz uso do cache para reaproveitar um token não expirado.
- `TokenController`:
Endpoint para teste do funcionamento do token via chamada rest.