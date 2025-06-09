# Boas Práticas para Escrita de Métodos

## 1 - Cuidado com a utilização de fluxos condicionais e estruturas de repetição
Utilizar `ifs`, `elses` e `fors` dentro de um método aumenta a complexidade ciclomática.

## 2 - Mantenha sempre um método simples e com uma única responsabilidade
Relacionado à dica número 1.  
Como regra geral, tente sempre manter um método o mais simples possível. 
Referencia a os principios de OO com SOLID.

## 3 - Cuidado com métodos que possuem muitas linhas de código
É difícil dizer exatamente quantas linhas um método deve ter, mas, se ele já ultrapassou 10 linhas, comece a considerar se não é o caso de refatorá-lo.

## 4 - Métodos com muitos parâmetros são tão ruins quanto métodos com muitas linhas
Fazendo um paralelo com a dica número 3: se seu método tem muitos parâmetros, é um sinal de que ele está assumindo responsabilidades demais.

## 5 - Só porque uma linguagem permite, não significa que deva ser utilizado
Isso vale para herança, polimorfismo e sobrecarga de métodos.  
É sempre importante refletir sobre quando e por que utilizar determinado recurso, e se ele realmente é necessário.
