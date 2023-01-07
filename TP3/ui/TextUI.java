package ui;

import buisness.*;
import java.util.*;
import java.util.stream.Collectors;
import buisness.Racing.*;


/**
 * Exemplo de interface em modo texto.
 *
 * @author JFC
 * @version 20220919
 */
public class TextUI {
    // O model tem a 'lógica de negócio'.
    private RacingSimFacade model;

    // Menus da aplicação
    private Menu menuAdim;
    // Menus da aplicação
    private Menu menuUtilizador;
    // Menus da aplicação
    private Menu menuCampeonato;

    // Scanner para leitura
    private Scanner scin;

    /**
     * Construtor.
     *
     * Cria os menus e a camada de negócio.
     */
    public TextUI() {
        // Criar o menu
        this.menuAdim = new Menu(new String[]{
                "Adicionar Campeonato",
                "Adicionar Circuito",
                "Adicionar Carro",
                "Adicionar Piloto",
                "Editar Campeonato",
                "Editar Circuito",
                "Editar Carro",
                "Editar Piloto",
                "Remover Campeonato",
                "Remover Circuito",
                "Remover Carro",
                "Remover Piloto",
        });
        this.menuAdim.setHandler(1, this::AdicionarCampeonato);
        this.menuAdim.setHandler(2, this::AdicionarCircuito);
        this.menuAdim.setHandler(3, this::AdicionarCarro);
        this.menuAdim.setHandler(4, this::trataAdicionarTurma);
        this.menuAdim.setHandler(5, this::trataMudarSalaTurma);
        this.menuAdim.setHandler(6, this::trataListarTurmas);
        this.menuAdim.setHandler(7, this::trataAdicionarAlunoATurma);
        this.menuAdim.setHandler(8, this::trataRemoverAlunoDaTurma);
        this.menuAdim.setHandler(9, this::trataListarAlunosTurma);
        this.menuUtilizador = new Menu(new String[]{
            "Criar Campeonato",
            "Juntar Campeonato",
            "Mostrar Pontos",
        });
        this.menuUtilizador.setHandler(1, this::trataAdicionarAluno);
        this.menuUtilizador.setHandler(2, this::trataAdicionarAluno);
        this.menuUtilizador.setHandler(3, this::trataAdicionarAluno);
        this.menuCampeonato = new Menu(new String[]{
            "Proxima Corrida",
            "Alterar Carro",
            "Mostrar Pontos",
        });
        this.menuCampeonato.setHandler(1, this::trataAdicionarAluno);
        this.menuCampeonato.setHandler(2, this::trataAdicionarAluno);
        this.menuCampeonato.setHandler(3, this::trataAdicionarAluno);
        this.model = new RacingSimFacade();
        scin = new Scanner(System.in);
    }

    /**
     * Executa o menu principal e invoca o método correspondente à opção seleccionada.
     */
    public void run() {
        this.menuAdim.run();
        System.out.println("Até breve!...");
    }

    // Métodos auxiliares
    private void AdicionarCampeonato() {
        try {
            System.out.println("Nome do Campeonato: ");
            String nomeCampeonato = scin.nextLine();
            if (!this.model.existeCampeonato(nomeCampeonato)) {
                ArrayList<String> listaCircuitos = new ArrayList<String>();
                //dar print a lista de circuitos
                String circuito = scin.nextLine();
                while(!(circuito.equals("f")) || !(circuito.equals("F"))){
                    listaCircuitos.add(circuito);
                    circuito = scin.nextLine();
                }
                this.model.addCampeonato(listaCircuitos, circuito);
            } else {
                System.out.println("Esse Campeonato já existe!");
            }
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    private void AdicionarCircuito() {
        try {
            //String nome, int dist, int voltas, int n_retas, int n_chicanes
            System.out.println("Nome do Circuito: ");
            String nomeCircuito = scin.nextLine();
            if (!this.model.existeCircuito(nomeCircuito)) {
                System.out.println("Distancia: ");
                int distancia = scin.nextInt();
                System.out.println("Numero de voltas: ");
                int numVoltas = scin.nextInt();
                System.out.println("Numero de retas: ");
                int numRetas = scin.nextInt();
                System.out.println("Numero de chicanas: ");
                int numChicanas = scin.nextInt();
                this.model.addCircuito(nomeCircuito, distancia, numVoltas, numRetas, numChicanas);
            } else {
                System.out.println("Esse Campeonato já existe!");
            }
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

     private void AdicionarCarro() {
        //tipo
		//c1 -> marca,modelo,potencia,cilindrada,pa
		//c1h -> marca,modelo,potencia,cilindarda,pa,potenciaE
		//c2 -> marca,modelo,potencia,cilindrada,pa,afinacao
		//c2h->marca,modelo,potencia,cilindrada,pa,afinacao,potenciaE
		//gt->marca,modelo,potencia,cilindrada,pa
		//gth->marca,modelo,potencia,cilindrada,pa,potenciaE
		//sc->marca,modelo,potencia,cilindrada,pa
        System.out.println("tipo do Carro: ");
        System.out.println("C1 -> 1 ");
        System.out.println("C2 -> 2 ");
        System.out.println("GT -> 3 ");
        System.out.println("SC -> 4 ");
        try {
            int tipoCarro = scin.nextInt();
            System.out.println("Marca do Carro: ");
            String marcaCarro = scin.nextLine();
            System.out.println("Modelo do Carro: ");
            String modeloCarro = scin.nextLine();
            System.out.println("Hibrido: 0->sim; 1->nao");
            int hibrido = scin.nextInt();
            System.out.println("Potencia do Carro: ");
            int potencia = scin.nextInt();
            System.out.println("Perfil Aerodinamico do Carro(0 a 1): ");
            float pa = scin.nextFloat();
            int potenciaE = 0;
            if(hibrido==0){
                System.out.println("Potencia Motor Eletrico: ");
                potenciaE = scin.nextInt();
            }
            if(!this.model.existeCarro(modeloCarro)){
                switch(tipoCarro){
                    case(1):
                        int cilindrada = 6000;
                        if(hibrido==0)
                            this.model.addCarrohibridro(tipoCarro, marcaCarro, modeloCarro, cilindrada, potencia, pa, potenciaE);
                        else
                            this.model.addCarro(tipoCarro, marcaCarro, modeloCarro, cilindrada, potenciaE, pa);
                        break;
                    case(2):
                        System.out.println("Cilindrada: ");
                        cilindrada = scin.nextInt();
                        if(hibrido==0)
                            this.model.addCarrohibridro(tipoCarro, marcaCarro, modeloCarro, cilindrada, potencia, pa, potenciaE);
                        else
                            this.model.addCarro(tipoCarro, marcaCarro, modeloCarro, cilindrada, potenciaE, pa);
                        break;
                    case(3):
                        System.out.println("Cilindrada: ");
                        cilindrada = scin.nextInt();
                        if(hibrido==0)
                            this.model.addCarrohibridro(tipoCarro, marcaCarro, modeloCarro, cilindrada, potencia, pa, potenciaE);
                        else
                            this.model.addCarro(tipoCarro, marcaCarro, modeloCarro, cilindrada, potenciaE, pa);
                        break;
                    case(4):
                        int cilindarda = 2500;
                        if(hibrido==0)
                            this.model.addCarrohibridro(tipoCarro, marcaCarro, modeloCarro, cilindrada, potencia, pa, potenciaE);
                        else
                            this.model.addCarro(tipoCarro, marcaCarro, modeloCarro, cilindrada, potenciaE, pa);
                        break;
                    default:
                        break;
                }
            }else{
                System.out.println("Esse Carro já existe!");
            }
        }catch(NullPointerException e)
        {
            e.printStackTrace();
        }
    }


    private void trataMudarSalaTurma() {
        try {
            System.out.println("Número da turma: ");
            String tid = scin.nextLine();
            if (this.model.existeTurma(tid)) {
                System.out.println("Sala: ");
                String sala = scin.nextLine();
                System.out.println("Edifício: ");
                String edif = scin.nextLine();
                System.out.println("Capacidade: ");
                int cap = scin.nextInt();
                scin.nextLine();    // Limpar o buffer depois de ler o inteiro
                this.model.alteraSalaDeTurma(tid, new Sala(sala, edif, cap));
                System.out.println("Sala da turma alterada");
            } else {
                System.out.println("Esse número de turma não existe!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void trataListarTurmas() {
        try {
            System.out.println(this.model.getTurmas().toString());
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    private void trataAdicionarAlunoATurma() {
        try {
            System.out.println("Número da turma: ");
            String tid = scin.nextLine();
            if (this.model.existeTurma(tid)) {
                System.out.println("Número do aluno: ");
                String num = scin.nextLine();
                if (this.model.existeAluno(num)) {
                    this.model.adicionaAlunoTurma(tid, num);
                    System.out.println("Aluno adicionado à turma");
                } else {
                    System.out.println("Esse número de aluno não existe!");
                }
            } else {
                System.out.println("Esse número de turma não existe!");
            }
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    private void trataRemoverAlunoDaTurma() {
        try {
            System.out.println("Número da turma: ");
            String tid = scin.nextLine();
            if (this.model.existeTurma(tid)) {
                System.out.println("Número do aluno: ");
                String num = scin.nextLine();
                if (this.model.existeAlunoEmTurma(tid,num)) {
                    this.model.removeAlunoTurma(tid, num);
                    System.out.println("Aluno removido da turma");
                } else {
                    System.out.println("Esse número de aluno não existe na turma!");
                }
            } else {
                System.out.println("Esse número de turma não existe!");
            }
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    private void trataListarAlunosTurma() {
        try {
            System.out.println("Número da turma: ");
            String tid = scin.nextLine();
            List<Aluno> als = this.model.getAlunos(tid).stream()
                                                       .map((na)->this.model.procuraAluno(na))
                                                       .collect(Collectors.toList());
            System.out.println(als);
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}