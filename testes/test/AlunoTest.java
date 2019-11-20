package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modulos.Aluno;

class AlunoTest {
	
	private Aluno aluno;
	
	@BeforeEach
	void setUp() {
		this.aluno = new Aluno(2,6.9);
	}

	@Test
	void testConstrutor() {
		this.aluno = new Aluno(3,8.5);
		
		assertEquals("3o SEMESTRE - 8.5",this.aluno.toString());
	}

	@Test
	void testToString() {
		assertEquals("2o SEMESTRE - 6.9",this.aluno.toString());
	}

	@Test
	void testAlteraEspecialidadeSemestre() {
		this.aluno.alteraEspecialidade("SEMESTRE", "4");
		
		assertEquals(4,this.aluno.getSemestre());
	}
	
	@Test
	void testAlteraEspecialidadeIea() {
		this.aluno.alteraEspecialidade("IEA", "7.0");
		
		assertEquals(7.0,this.aluno.getIea());
	}

}
