package ifpb.edu.br.entidades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaCadastro extends JPanel {
    private JLabel labelMatricula;
    private JLabel labelNome;
    private JLabel labelSenha;
    private JLabel labelDisciplina;
    private JLabel labelProfessor;
    private JTextField textDisciplina;
    private JTextField textProfessor; // Campo para o nome do professor
    private List<Disciplina> disciplinas;
    private JTextField textMatricula;
    private JTextField textNome;
    private JPasswordField textSenha;
    private JButton btnCadastrar;
    private JButton btnAdicionar;
    private JTextArea areaDescricao;

    public TelaCadastro() {
        disciplinas = new ArrayList<>();
        configurar();
    }

    public void configurar() {
        this.setBackground(new Color(0xFFF8B8D9, true));
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel labelTitulo = new JLabel("Cadastro");

        labelNome = new JLabel("Nome:");
        textNome = new JTextField(15);

        labelMatricula = new JLabel("Matrícula:");
        textMatricula = new JTextField(15);

        labelSenha = new JLabel("Senha:");
        textSenha = new JPasswordField(15);

        labelDisciplina = new JLabel("Disciplina:");
        textDisciplina = new JTextField(15);

        labelProfessor = new JLabel("Professor:"); // Novo rótulo para o nome do professor
        textProfessor = new JTextField(15); // Novo campo para o nome do professor

        btnAdicionar = new JButton("+");
        btnAdicionar.setBackground(new Color(0x9D1888));
        btnAdicionar.setForeground(new Color(0xFFFFFF));

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBackground(new Color(0x9D1888));
        btnCadastrar.setForeground(new Color(0xFFFFFF));

        areaDescricao = new JTextArea(10, 20);
        areaDescricao.setEditable(false);
        areaDescricao.setLineWrap(true);
        areaDescricao.setWrapStyleWord(true);

        // Configuração do título
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        this.add(labelTitulo, c);

        // Configuração do nome
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.LINE_END;
        this.add(labelNome, c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        this.add(textNome, c);

        // Configuração da matrícula
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.LINE_END;
        this.add(labelMatricula, c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        this.add(textMatricula, c);

        // Configuração da senha
        c.gridx = 0;
        c.gridy = 3;
        c.anchor = GridBagConstraints.LINE_END;
        this.add(labelSenha, c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        this.add(textSenha, c);

        // Configuração da disciplina
        c.gridx = 0;
        c.gridy = 4;
        c.anchor = GridBagConstraints.LINE_END;
        this.add(labelDisciplina, c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        this.add(textDisciplina, c);

        // Configuração do professor
        c.gridx = 0;
        c.gridy = 5;
        c.anchor = GridBagConstraints.LINE_END;
        this.add(labelProfessor, c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        this.add(textProfessor, c);

        // Configuração do botão adicionar
        c.gridx = 2;
        c.gridy = 4;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.LINE_START;
        this.add(btnAdicionar, c);

        // Configuração da área de descrição
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 3;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.BOTH;
        this.add(new JScrollPane(areaDescricao), c);

        // Configuração do botão cadastrar
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        this.add(btnCadastrar, c);

        // Adicionar ação ao botão adicionar
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeDisciplina = textDisciplina.getText().trim();
                String nomeProfessor = textProfessor.getText().trim(); // Obtém o nome do professor

                if (!nomeDisciplina.isEmpty() && !nomeProfessor.isEmpty()) {
                    // Criação de um Professor com matrícula padrão
                    Professor professor = new Professor("MATRICULA_PADRAO", nomeProfessor);
                    Disciplina novaDisciplina = new Disciplina(nomeDisciplina, professor);
                    disciplinas.add(novaDisciplina);
                    areaDescricao.append(novaDisciplina.getNomeDisciplina() + " - " + professor.getNome() + "\n");
                    textDisciplina.setText("");
                    textProfessor.setText("");
                } else {
                    JOptionPane.showMessageDialog(TelaCadastro.this, "Por favor, insira o nome da disciplina e do professor.");
                }
            }
        });
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void addCadastrarListener(ActionListener listener) {
        btnCadastrar.addActionListener(listener);
    }
}
