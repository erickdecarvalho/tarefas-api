package tarefas.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import tarefas.api.entity.Tarefa;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TarefasApiApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testeCreateTodoSuccess() {
		var tarefa = new Tarefa("Tarefa 1", "Desc Tarefa 1", false, 1);

		webTestClient
				.post()
				.uri("/tarefas")
				.bodyValue(tarefa)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$[0].nome").isEqualTo(tarefa.getNome())
				.jsonPath("$[0].descricao").isEqualTo(tarefa.getDescricao())
				.jsonPath("$[0].realizada").isEqualTo(tarefa.isRealizada())
				.jsonPath("$[0].prioridade").isEqualTo(tarefa.getPrioridade());

	}

	@Test
	void testeCreateTodoFailure() {
		webTestClient
				.post()
				.uri("/tarefas")
				.bodyValue(
						new Tarefa("", "", false, 0)
				)
				.exchange()
				.expectStatus().isBadRequest();
	}

}
