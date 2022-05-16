 <h2 style="color: green">CaronABC - Um meio mais fácil de ir e voltar  ao campus</h2>

CaronABC é um software desenvolvido pensando no deslocamento dos membros da comunidade acadêmica da UFABC. Pensando num cenário onde desejamos mais segurança para discentes, docentes e técnicos administrativos da universidade, a proposta do aplicativo é a de promover uma forma mais segura de deslocamento por meio de caronas compartilhadas apenas com outros membros da comunidade acadêmica. Isso será possível a partir de um sistema de autenticação onde apenas usuários de login institucional poderão utilizar o software.

A ideia da aplicação é facilitar o deslocamento e compartilhar caronas, a aplicação carrega tabelas com informações desde o nome da pessoa, a modalidade (oferta e requisição de carona), número de telefone para entrar em contato e ponto de partida e destino. Assim, facilitando o contato entre quem busca e quem oferta carona.

<h2>Inspiração para o aplicativo</h2>

Pensando no contexto de segurança e mobilidade nos arredores dos campus da UFABC, vemos que possuímos um cenário com altas taxas de assaltos, baixo número de fretados para transportar membros da comunidade entre os campis e até a estação de trem, necessidade de percorrer trajetos em horários pouco movimentados, dentre tantos outros fatores. Isso fez com que optássemos por desenvolver um aplicativo no estilo "carpool" para uso da comunidade acadêmica, visando facilitar o acesso aos campi, diminuindo custos e aumentando a segurança daqueles que necessitam.

<h2>Integrantes</h2>

#Grupo 13
1. Vinicius Castro
1. Ian Lacerda
1. Andre Balchiumas
1. Guilherme Gonçalves Braz
1. Fernanda Aparecida Barbosa de Araujo

* https://docs.google.com/document/d/1BIX5BvSlgJN9AZu3mExJHMdhMfb_lnKmtDAi8wCTLLA/edit

<h2>Tecnologias utilizadas</h2>

Intellij IDEA Ultimate

Java 11

Maven

Spring Boot 

HTML/CSS

H2 database

<h3>APIs utilizadas</h3>

[Openroute Service](https://openrouteservice.org/)

[MapTiler](https://www.maptiler.com/)


Além disso, algumas da técnicas empregadas no desenvolvimento do projeto foram: testes unitários, singleton, pair-programming, refatoração, controle de versão etc.

<h2>Como baixar</h2>

Basta clonar o repositório.

<h2>Como instalar</h2>

Abrir o repositório local pelo Intellij e executar a classe "CaronabcApplication.java" diretamente pela IDE. Após o servidor de Spring subir, a tela de registro de usuários pode ser acessada através de: localhost:8080/registro. Diretamente pelo navegador de sua preferência.

<h2>Como utilizar</h2>

O usuário deverá acessar a URL, fazer o cadastro utilizando seu e-mail institucional (@aluno.ufabc.edu.br ou @ufabc.edu.br), preenchendo seu nome e demais informações necessárias para utilizar a aplicação. 
Uma vez que os dados são submetidos, abaixo dos campos preenchidos uma tabela pode ser visualizada com as informações de demais corridas. Assim, sendo possível o contato entre quem busca e quem oferta caronas.
Ademais, um botão acompanha cada entrada da tabela, esse botão é responsável por se conectar a uma API de geolocalização e um mapa contendo a rota é rendenizado.

<h2>Tela de registro</h2>

![alt text](https://user-images.githubusercontent.com/74436565/168693717-f248cdba-1e64-4421-8711-cfad08ea023b.png)

<h2>Map API</h2>

![alt text](https://user-images.githubusercontent.com/74436565/168693945-66f9708d-6808-4ebd-83ed-d60a55b1d434.png)


<h2>Diagrama UML</h2>
![alt text](https://user-images.githubusercontent.com/74436565/168693384-a05e41e6-3e92-4707-8458-69de0619bce4.png)
