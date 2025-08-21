## Projeto Help Desk - Backend (Java + Spring Boot)

Projeto desenvolvido no curso "Spring Boot + Angular" da Udemy(curso atualizado na plataforma em 2021).

Utilização de Java + Spring Boot com acesso a banco de dados MySQL, implementado com Spring Security autenticação e autorização.

Alguns desafios foram surgindo durante o desenvolvimento(julho/2025) da aplicação por conta das versões dos recursos utilizados.

Meu maior desafio no backend foi na construção da autenticação e autorização JWT.

Alguns problemas em relação a versão e solução:

1. A classe WebSecurityConfigurerAdapter ficou obsoleta na minha versão(classe SecurityConfig), resolvido com muita pesquisa na internet.

2. Anotação @EnableGlobalMethodSecurity(prePostEnabled = true) ficou obsoleta sendo necessário a substituição por @EnableMethodSecurity(prePostEnabled = true) responsável pelo controle de acesso aos endpoints levando em consideração o usuário/autorização(classe SecurityConfig).

3. No curso é utilizado o a plataforma "Heroku" para implantação nas nuvens do backend, porém essa não oferece mais serviços gratuitos, foi necessário implantar na RailWay.

O banco de dados utilizado pelo professor no curso foi o H2, porém decidir usar o MySQL, sendo necessário alguns ajustes no desenvolvimento e na implantação nas nuvens.

Foram realizados vários testes atráves de requisições no POSTMAN depois da implantação nas nuvens, tudo funcionando corretamente.💪😄 

Rumo ao desenvolvimento do frontend com Angular...

**Atualizando informações: O período de teste na RailWay expirou, conseguir implantar o backend na AWS no EC2.**




