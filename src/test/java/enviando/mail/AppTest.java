package enviando.mail;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
  @org.junit.Test
	public void testeEmail() throws Exception{
	  
	  StringBuilder stringBuilderTextoEmail = new StringBuilder();
	  
	  stringBuilderTextoEmail.append("<h1>Olá Programador</h1> <br/><br/>");
	  stringBuilderTextoEmail.append("Você está recenbendo um email de teste em Java<br/>");
	  stringBuilderTextoEmail.append("Para ter acesso ao link clique no BOTÃO ABAIXO<br/><br/><br/><br/>");
	  
	  stringBuilderTextoEmail.append("<a target=\"_blank\" href=\"https://projetojavaweb.com/certificado-aluno/inicio\" style=\"color:#2525a7; padding: 14px 25px; text-align: center; text-decoration:none; display:inline-block; border-radius: 30px; font-size: 20px; font-family:courier; border: 3px solid green; background-color: #99DA39;\" >Acessar Portal</a>");
	  
		ObjetoEnviaEmail enviaEmail = 
				new ObjetoEnviaEmail("joaopaulo.arteagle17@gmail.com",
									"João do Java",
									"Assunto teste",
									stringBuilderTextoEmail.toString());
		
		
		
		enviaEmail.enviarEmail(true);
		
	}
}
