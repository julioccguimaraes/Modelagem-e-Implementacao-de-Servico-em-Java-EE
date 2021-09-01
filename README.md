# trabalho-dm110
Estrutura de diretórios base para o projeto Java EE.

Executar os scripts no HSQLDB e criar um recurso com JNDI name 'java:/ProductDS'.
Para criar a fila, execute o comando: jms-queue add --queue-address=trabalhodm110queue --durable=true --entries=["java:/jms/queue/trabalhodm110queue"]

CREATE TABLE PRODUCT (
	CODE INTEGER NOT NULL,
	NAME VARCHAR(255) NOT NULL,
	DESCRIPTION LONGVARCHAR NOT NULL,
	PRICE FLOAT NOT NULL,
	CATEGORY VARCHAR(255) NOT NULL,
	PRIMARY KEY (CODE)
);

CREATE TABLE AUDITING (
	ID INTEGER IDENTITY PRIMARY KEY,
	PRODUCTCODE INTEGER NOT NULL,
	OPERATION VARCHAR(10) NOT NULL,
	TIMESTAMP TIMESTAMP DEFAULT NOW,
	FOREIGN KEY(PRODUCTCODE) REFERENCES PRODUCT(CODE)
);
