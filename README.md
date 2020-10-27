![robocode logo](img/robocode_logo.png)

# Solutis Talent Sprint 2020
Robô de batalha criado para o Talent Sprint, programa de seleção de jovens talentos, da empresa Solutis.

## Sobre o Robocode
O robocode é uma engine avançada para simulação de batalha entre robôs.
Foi criado por uma divisão da IBM chamada Alpha Works, com a intenção de tornar mais divertido o apredizado da linguagem de programação Java.
Hoje, o mesmo pode ser utilizado tanto em Java quanto em .Net.

## Tecnologias utilizadas neste projeto
![Java version](https://img.shields.io/badge/Java-1.8.0__271-brightgreen) 
![Git version](https://img.shields.io/badge/Git-2.28.0-brightgreen)

## Distributed Version-Control System
O Git foi a tecnologia utilizada para gerenciar o repositório local deste projeto.

Durante o decorrer do processo não houve necessidade de "3-way merges" apenas "Fast Forward Merges", mas, apesar de não precisar utilizar recursos interessantes como 3-way merge ou precisar resolver conflitos de versionamento mais complexos, eu pude apreder mais sobre criação de páginas README.md e como elas interagem com o navegador.

## Repository Hosting Service
O GitLab foi o sistema escolhido para hospedagem do repositório remoto do nosso Robô Doofy. 

Eu nunca havia utilizado o GitLab anteriormente mas aparentemente ele possui caracteristicas interessantes como a possibilidade de configuração de CI, CD e integração aparentemente melhorada com o Kubernetes.

# Robo Doofy
O nome do Robo criado para este projeto é Doofy e se você pensou no personagem do filme "Todo mundo em pânico" você acertou na mosca! <br>
<br> ![Doofy gif](img/tenor.gif) <br> <br>
Eu sei que parece piada, mas, dentro do contexto que irei apresentar neste documento, a referência faz muito sentido, afinal, o indivíduo "mais tonto" e que parece ter a menor capacidade de ser o culpado é, no final das contas, o real assassino.

## Analise inicial
A primeira analise de performance foi feita utilizando os robôs sample do próprio Robocode.
Durante o processo percebi que dois robôs se destacavam à princípio, um deles pareceu meio tonto, ficava girando sem parar, aparentemente sem rumo, seu nome é "Spinbot".
O outro praticamente não participava dos confrontos mais brutais porém se demonstrou muito eficaz em finalizar seus adiversários, este é o sample "Walls".
Por fim, partindo deste princípio, decidi estudar os códigos e características deles dois para utilizar como fonte principal, mas não única, no desenvolvimento do robô Doofy.
<br> <br> Ao utilizar todos os sample robots ao mesmo tempo, não foi observado queda de FPS.

## Codificação
Utilizando um array de objetos, analisei os resultados obtidos pelo radar num percurso de 360 graus. Muitas vezes, ao completar uma volta inteira, o radar trouxe resultados duplicados, vide imagem abaixo:
<br> ![resultados repetidos](img/duplicidade-radar.png)





## Analise final
Para a análise final decidi fazer uma pesquisa no GitLab dos outros participantes do desafio Talent Sprint de 2020, utilizando seus robôs e consequentemente seus códigos para verificar o desempenho de Doofy, observando assim as chances deste obter sucesso.
<br> <br> Durante este processo presenciei quedas de FPS, possivelmente causadas por má implementação de códigos e funções nos robôs presentes na arena.

# Contribuições
Este repositório está sendo avaliado por [Alex Gamas](https://gitlab.com/alexgamas)

# Referências
[Sing Li - IBM](https://www.ibm.com/developerworks/library/j-robocode/index.html)

[Robocode Wiki](https://robowiki.net/wiki/Main_Page)

# Licença
[EPL](https://robocode.sourceforge.io/license/epl-v10.html)