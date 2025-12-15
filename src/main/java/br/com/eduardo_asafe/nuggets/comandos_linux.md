# Guia de Comandos Linux

---

## 1. Listagem e identificação de arquivos

```bash
ls -lha --color=auto
```

Exibe os arquivos do diretório atual com detalhes.

- **-l** → mostra detalhes (permissões, dono, grupo, tamanho, data, etc.)  
- **-h** → deixa tamanhos legíveis (1K, 2M, 3G)  
- **-a** → inclui arquivos ocultos (os que começam com `.`)  
- **--color=auto** → mostra cores para diferenciar tipos de arquivos  

---

## 2. Requisições HTTP e Handshake

```bash
curl -X -v GET https://www.google.com.br
```

Ou, utilizando `wget`:

```bash
wget --debug -O- https://www.google.com.br
```

Esses comandos servem para **testar requisições HTTP** e verificar detalhes do **Handshake TLS/SSL**.

---

## 3. Monitoramento de arquivos de log

```bash
tail -f -n server.log
```

Perfeito para **acompanhar em tempo real** as últimas linhas de um arquivo de log.

---
