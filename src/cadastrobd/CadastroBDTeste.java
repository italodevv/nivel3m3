package cadastrobd;

import cadastrobd.model.PessoaFisicaDAO;
import cadastrobd.model.PessoaJuridicaDAO;
import cadastro.model.util.ConectorBD;
import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaJuridica;
import java.util.List;


public class CadastroBDTeste {

    public static void main(String[] args) {

        ConectorBD conectorBD = new ConectorBD();



        //a. Instanciar uma pessoa fisica e persistir no banco de dados.
        System.out.println("\n");
        PessoaFisica pessoaFisica = new PessoaFisica();
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO(conectorBD);
        pessoaFisica.setNome("TESTE");;
        pessoaFisica.setLogradouro("RUA DO TESTE");
        pessoaFisica.setCidade("TESTE DO SUL");
        pessoaFisica.setEstado("PA");
        pessoaFisica.setTelefone("33333");
        pessoaFisica.setEmail("TESTE@TESTE.COM");
        pessoaFisica.setCpf("3333333");
        int idRegistro = pessoaFisicaDAO.incluir(pessoaFisica);
        pessoaFisica.exibir();
        System.out.println("Criamos uma Pessoa Fisica com dados acima e ID: " + idRegistro + "\n");
        
        //b. alterar os dados da pessoa fisica no banco.
        //pessoaFisicaDAO.getPessoa(idRegistro);
        pessoaFisica.setIdPessoa(idRegistro);
        pessoaFisica.setNome("TESTE1");
        pessoaFisica.setLogradouro("RUA DO TESTE1");
        pessoaFisica.setCidade("TESTE1 DO SUL");
        pessoaFisica.setEstado("PA");
        pessoaFisica.setTelefone("33333");
        pessoaFisica.setEmail("TESTE1@TESTE1.COM");
        pessoaFisica.setCpf("33333334");
        pessoaFisica.exibir();
        pessoaFisicaDAO.alterar(pessoaFisica);
        System.out.println("Observe que alteramos a Pessoa Fisica criada anteriormente com ID: " + idRegistro + "\n");

        //c. Consultar todas as pessoas físicas do banco de dados e listar no console.
        List<PessoaFisica> pessoasFisicas = pessoaFisicaDAO.getPessoas();
        for (PessoaFisica pf : pessoasFisicas) {
            pf.exibir();
        }

        //d. Excluir a pessoa física criada anteriormente no banco.
        PessoaFisica pessoaExcluir = pessoaFisicaDAO.getPessoa(idRegistro);
        pessoaFisicaDAO.excluir(pessoaExcluir);
        System.out.println("Acima temos todas as Pessoa Física, mas iremos excluir a criada anteriormente com ID: " + idRegistro +"\n");
        pessoaFisicaDAO.getPessoas();
        List<PessoaFisica> pessoasFisicasNovas = pessoaFisicaDAO.getPessoas();
        for (PessoaFisica pf : pessoasFisicasNovas) {
            pf.exibir();
        }
        System.out.println("Observe acima que agora não mais existe Pessoa Física com o ID: " + idRegistro +"\n\n");
        
        //e. Instanciar uma pessoa fisica e persistir no banco de dados.
        System.out.println("\n");
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO(conectorBD);
        pessoaJuridica.setNome("TESTE");;
        pessoaJuridica.setLogradouro("RUA DO TESTE");
        pessoaJuridica.setCidade("TESTE DO SUL");
        pessoaJuridica.setEstado("PA");
        pessoaJuridica.setTelefone("33333");
        pessoaJuridica.setEmail("TESTE@TESTE.COM");
        pessoaJuridica.setCnpj("3333333");
        int idRegistroPJ = pessoaJuridicaDAO.incluir(pessoaJuridica);
        pessoaJuridica.exibir();
        System.out.println("Criamos uma Pessoa Juridica com dados acima e ID: " + idRegistroPJ + "\n");
        
        //f. alterar os dados da pessoa fisica no banco.
        //pessoaJuridicaDAO.getPessoa(idRegistro);
        pessoaJuridica.setIdPessoa(idRegistroPJ);
        pessoaJuridica.setNome("TESTE1");
        pessoaJuridica.setLogradouro("RUA DO TESTE1");
        pessoaJuridica.setCidade("TESTE1 DO SUL");
        pessoaJuridica.setEstado("PA");
        pessoaJuridica.setTelefone("33333");
        pessoaJuridica.setEmail("TESTE1@TESTE1.COM");
        pessoaJuridica.setCnpj("33333334");
        pessoaJuridica.exibir();
        pessoaJuridicaDAO.alterar(pessoaJuridica);
        System.out.println("Observe que alteramos a Pessoa Juridica criada anteriormente com ID: " + idRegistroPJ + "\n");

        //g. Consultar todas as pessoas físicas do banco de dados e listar no console.
        List<PessoaJuridica> pessoasJuridicas = pessoaJuridicaDAO.getPessoas();
        for (PessoaJuridica pj : pessoasJuridicas) {
            pj.exibir();
        }

        //h. Excluir a pessoa física criada anteriormente no banco.
        PessoaJuridica pessoaExcluirPJ = pessoaJuridicaDAO.getPessoa(idRegistroPJ);
        pessoaJuridicaDAO.excluir(pessoaExcluirPJ);
        System.out.println("Acima temos todas as Pessoa Juridica, mas iremos excluir a criada anteriormente com ID: " + idRegistroPJ +"\n");
        pessoaJuridicaDAO.getPessoas();
        List<PessoaJuridica> pessoasJuridicasNovas = pessoaJuridicaDAO.getPessoas();
        for (PessoaJuridica pj : pessoasJuridicasNovas) {
            pj.exibir();
        }
        System.out.println("Observe acima que agora não mais existe Pessoa Juridica com o ID: " + idRegistroPJ +"\n");

        System.out.println("programa encerrado!!");
    }
}
