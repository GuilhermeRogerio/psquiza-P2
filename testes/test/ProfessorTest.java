package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modulos.Professor;

class ProfessorTest {
	
	private Professor professor;
	
	@BeforeEach
	void setUp() {
		this.professor = new Professor("Doutorado","DSC","01/01/2011");
	}

	@Test
	void testConstrutor() {
		this.professor = new Professor("Bacharel","CC","01/01/2011");
		
		assertEquals("Bacharel - CC - 01/01/2011",this.professor.toString());
	}

	@Test
	void testToString() {
		assertEquals("Doutorado - DSC - 01/01/2011",this.professor.toString());
	}

	@Test
	void testAlteraEspecialidadeFormacao() {
		this.professor.alteraEspecialidade("FORMACAO","Bacharel");
		
		assertEquals("Bacharel",this.professor.getFormacao());
	}
	
	@Test
	void testAlteraEspecialidadeUnidade() {
		this.professor.alteraEspecialidade("UNIDADE","CC");
		
		assertEquals("CC",this.professor.getUnidade());
	}
	
	@Test
	void testAlteraEspecialidadeData() {
		this.professor.alteraEspecialidade("DATA","02/04/2004");
		
		assertEquals("02/04/2004",this.professor.getData());
	}

}
