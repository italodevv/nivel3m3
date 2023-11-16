package cadastrobd;


import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaFisicaDAO;
import cadastrobd.model.PessoaJuridica;
import cadastrobd.model.PessoaJuridicaDAO;
import java.util.List;
import java.util.Scanner;
import cadastro.model.util.ConectorBD;

public class CadastroBD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConectorBD conectorBD = new ConectorBD();

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO(conectorBD);
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO(conectorBD);

        int opcao;
        do {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Selecione uma opção:");
            System.out.println("1. Incluir");
            System.out.println("2. Alterar");
            System.out.println("3. Excluir");
            System.out.println("4. Exibir pelo ID");
            System.out.println("5. Exibir todos");
            System.out.println("0. Sair");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.println("Escolha o tipo (F - Física, J - Jurídica):");
                    String tipo = scanner.nextLine().toUpperCase();

                    if (tipo.equalsIgnoreCase("F")) {
                        PessoaFisica pessoaFisica = new PessoaFisica();
                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
                        System.out.print("Nome: ");
                        pessoaFisica.setNome(scanner.nextLine());

                        System.out.print("Logradouro: ");
                        pessoaFisica.setLogradouro(scanner.nextLine());

                        System.out.print("Cidade: ");
                        pessoaFisica.setCidade(scanner.nextLine());

                        System.out.print("Estado: ");
                        pessoaFisica.setEstado(scanner.nextLine());

                        System.out.print("Telefone: ");
                        pessoaFisica.setTelefone(scanner.nextLine());

                        System.out.print("E-mail: ");
                        pessoaFisica.setEmail(scanner.nextLine());

                        System.out.print("CPF: ");
                        pessoaFisica.setCpf(scanner.nextLine());
                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");

                        pessoaFisicaDAO.incluir(pessoaFisica);
                        System.out.println("Pessoa Física incluída com sucesso!");

                    } else if (tipo.equalsIgnoreCase("J")) {
                        PessoaJuridica pessoaJuridica = new PessoaJuridica();
                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
                        System.out.print("Nome: ");
                        pessoaJuridica.setNome(scanner.nextLine());

                        System.out.print("Logradouro: ");
                        pessoaJuridica.setLogradouro(scanner.nextLine());

                        System.out.print("Cidade: ");
                        pessoaJuridica.setCidade(scanner.nextLine());

                        System.out.print("Estado: ");
                        pessoaJuridica.setEstado(scanner.nextLine());

                        System.out.print("Telefone: ");
                        pessoaJuridica.setTelefone(scanner.nextLine());

                        System.out.print("E-mail: ");
                        pessoaJuridica.setEmail(scanner.nextLine());

                        System.out.print("CNPJ: ");
                        pessoaJuridica.setCnpj(scanner.nextLine());
                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");

                        pessoaJuridicaDAO.incluir(pessoaJuridica);
                        System.out.println("Pessoa Jurídica incluída com sucesso!");

                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 2:
                    System.out.println("Escolha o tipo (F - Física, J - Jurídica):");
                    String tipoAlterar = scanner.nextLine().toUpperCase();

                    System.out.print("Informe o ID da pessoa: ");
                    int idAlterar = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    if (tipoAlterar.equalsIgnoreCase("F")) {
                        PessoaFisica pessoaFisica = pessoaFisicaDAO.getPessoa(idAlterar);
                        if (pessoaFisica != null) {
                            // Exibir dados atuais da pessoa
                            pessoaFisica.exibir();

                            // Receber novos dados
                            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
                            System.out.print("Novo Nome: ");
                            pessoaFisica.setNome(scanner.nextLine());

                            System.out.print("Novo Logradouro: ");
                            pessoaFisica.setLogradouro(scanner.nextLine());

                            System.out.print("Nova Cidade: ");
                            pessoaFisica.setCidade(scanner.nextLine());

                            System.out.print("Novo Estado: ");
                            pessoaFisica.setEstado(scanner.nextLine());

                            System.out.print("Novo Telefone: ");
                            pessoaFisica.setTelefone(scanner.nextLine());

                            System.out.print("Novo E-mail: ");
                            pessoaFisica.setEmail(scanner.nextLine());

                            System.out.print("Novo CPF: ");
                            pessoaFisica.setCpf(scanner.nextLine());
                            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");

                            // Alterar no banco de dados
                            pessoaFisicaDAO.alterar(pessoaFisica);
                            System.out.println("Pessoa Física alterada com sucesso!");

                        } else {
                            System.out.println("Pessoa Física não encontrada.");
                        }
                    } else if (tipoAlterar.equalsIgnoreCase("J")) {
                        PessoaJuridica pessoaJuridica = pessoaJuridicaDAO.getPessoa(idAlterar);
                        if (pessoaJuridica != null) {
                            // Exibir dados atuais da pessoa jurídica
                            pessoaJuridica.exibir();

                            // Receber novos dados
                            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
                            System.out.print("Novo Nome: ");
                            pessoaJuridica.setNome(scanner.nextLine());

                            System.out.print("Novo Logradouro: ");
                            pessoaJuridica.setLogradouro(scanner.nextLine());

                            System.out.print("Nova Cidade: ");
                            pessoaJuridica.setCidade(scanner.nextLine());

                            System.out.print("Novo Estado: ");
                            pessoaJuridica.setEstado(scanner.nextLine());

                            System.out.print("Novo Telefone: ");
                            pessoaJuridica.setTelefone(scanner.nextLine());

                            System.out.print("Novo E-mail: ");
                            pessoaJuridica.setEmail(scanner.nextLine());

                            System.out.print("Novo "
                                    + "CNPJ: ");
                            pessoaJuridica.setCnpj(scanner.nextLine());
                            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");

                            // Alterar no banco de dados
                            pessoaJuridicaDAO.alterar(pessoaJuridica);
                            System.out.println("Pessoa Jurídica alterada com sucesso!");
                        } else {
                            System.out.println("Pessoa Jurídica não encontrada.");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 3:
                    System.out.println("Escolha o tipo (F - Física, J - Jurídica):");
                    String tipoExcluir = scanner.nextLine().toUpperCase();

                    System.out.print("Informe o ID da pessoa: ");
                    int idExcluir = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    if (tipoExcluir.equalsIgnoreCase("F")) {
                        PessoaFisica pessoaFisica = pessoaFisicaDAO.getPessoa(idExcluir);
                        if (pessoaFisica != null) {
                            pessoaFisicaDAO.excluir(pessoaFisica);
                            System.out.println("Pessoa Física excluída com sucesso!");
                        } else {
                            System.out.println("Pessoa Física não encontrada.");
                        }
                    } else if (tipoExcluir.equalsIgnoreCase("J")) {
                        PessoaJuridica pessoaJuridica = pessoaJuridicaDAO.getPessoa(idExcluir);
                        if (pessoaJuridica != null) {
                            pessoaJuridicaDAO.excluir(pessoaJuridica);
                            System.out.println("Pessoa Jurídica excluída com sucesso!");
                        } else {
                            System.out.println("Pessoa Jurídica não encontrada.");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 4:
                    System.out.println("Escolha o tipo (F - Física, J - Jurídica):");
                    String tipoExibirId = scanner.nextLine().toUpperCase();

                    System.out.print("Informe o ID da pessoa: ");
                    int idExibirId = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    if (tipoExibirId.equalsIgnoreCase("F")) {
                        PessoaFisica pessoaFisica = pessoaFisicaDAO.getPessoa(idExibirId);
                        if (pessoaFisica != null) {
                            pessoaFisica.exibir();
                        } else {
                            System.out.println("Pessoa Física não encontrada.");
                        }
                    } else if (tipoExibirId.equalsIgnoreCase("J")) {
                        PessoaJuridica pessoaJuridica = pessoaJuridicaDAO.getPessoa(idExibirId);
                        if (pessoaJuridica != null) {
                            pessoaJuridica.exibir();
                        } else {
                            System.out.println("Pessoa Jurídica não encontrada.");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 5:
                    System.out.println("Escolha o tipo (F - Física, J - Jurídica):");
                    String tipoExibirTodos = scanner.nextLine().toUpperCase();

                    if (tipoExibirTodos.equalsIgnoreCase("F")) {
                        System.out.println("Exibindo dados de Pessoa Fisica...");
                        List<PessoaFisica> pessoasFisicas = pessoaFisicaDAO.getPessoas();
                        for (PessoaFisica pf : pessoasFisicas) {
                            pf.exibir();
                        }
                    } else if (tipoExibirTodos.equalsIgnoreCase("J")) {
                        System.out.println("Exibindo dados de Pessoa Juridica...");
                        List<PessoaJuridica> pessoasJuridicas = pessoaJuridicaDAO.getPessoas();
                        for (PessoaJuridica pj : pessoasJuridicas) {
                            pj.exibir();
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa.");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}
