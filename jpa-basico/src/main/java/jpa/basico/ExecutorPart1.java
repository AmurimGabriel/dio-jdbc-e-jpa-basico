package jpa.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.basico.entity.Aluno;
import jpa.basico.entity.Estado;

public class ExecutorPart1 {
	public static void main(String[] args) {

		// OBS: Esse codigo deve executar COM ERROS pois não há ORM que implementem o JPA, há apenas o modelo JPA.
		
		// 1 - Passos iniciais para criar um gerenciador de entidades com o banco de dados especificado no arquivo "persistence.xml"
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("part1-DIO");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// 2.1 - Criar instancias para serem adicionadas no banco de dados
        Estado estadoParaAdicionar = new Estado("Rio de Janeiro", "RJ");
        Aluno alunoParaAdicionar = new Aluno("Danieu", 29, estadoParaAdicionar);

        // 2.2 - Iniciar uma trasacao para adiconar as instancias no banco de dados
        entityManager.getTransaction().begin();

        entityManager.persist(estadoParaAdicionar);
        entityManager.persist(alunoParaAdicionar);

        entityManager.getTransaction().commit();

        // 3 - Encerrar o gerenciador de entidades e encerrar a fabrica de gerenciadores de entidade.
        entityManager.close();
        entityManagerFactory.close();
	}
}
