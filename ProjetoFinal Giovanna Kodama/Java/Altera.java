// Giovanna Kodama Romero - 2101386

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Altera extends JFrame implements ActionListener {
  private StorageArte bd;
  private ButtonGroup grupo1;
  private JRadioButton fotografia;
  private JRadioButton post;
  private JButton confirmar;
  private JButton cancela;
  private JButton altera;
  private JTextField busca;
  private JLabel buscaLabel;
  private JPanel panelEscolhaArte;
  private JPanel panelContainer;
  private JPanel panelSearch;
  private JPanel panelItens;
  private JPanel panelResultados;
  private JLabel valor;
  private JLabel largura;
  private JLabel ano;
  private JLabel altura;
  private JLabel dsgCod;
  private JLabel dsgNome;
  private JLabel especifico1;
  private JLabel especifico2;
  private JLabel resultValor;
  private JLabel resultLargura;
  private JLabel resultAno;
  private JLabel resultAltura;
  private JLabel resultDsgCod;
  private JLabel resultDsgNome;
  private JLabel resultEspecifico1;
  private JLabel resultEspecifico2;
  private JMenuBar menuBar;
  private JMenu menuMain;
  private JMenuItem menuItem;

  public Altera(StorageArte bd) {
    this.bd = bd;
    grupo1 = new ButtonGroup();
    fotografia = new JRadioButton("Fotografia", false);
    post = new JRadioButton("Post", false);
    confirmar = new JButton("Confirmar");
    cancela = new JButton("Sair");
    altera = new JButton("Alterar");
    busca = new JTextField(20);
    buscaLabel = new JLabel("ID");
    panelEscolhaArte = new JPanel();
    panelContainer = new JPanel();
    panelSearch = new JPanel();
    panelItens = new JPanel(new FlowLayout(FlowLayout.LEFT));
    panelResultados = new JPanel(new FlowLayout(FlowLayout.LEFT));
    valor = new JLabel("Valor: ");
    largura = new JLabel("Largura (cm): ");
    ano = new JLabel("Ano: ");
    altura = new JLabel("Altura (cm): ");
    dsgCod = new JLabel("ID Designer: ");
    dsgNome = new JLabel("Designer: ");
    especifico1 = new JLabel("Local da fotografia: ");
    especifico2 = new JLabel("ID: ");
    resultValor = new JLabel("--");
    resultLargura = new JLabel("--");
    resultAno = new JLabel("--");
    resultAltura = new JLabel("--");
    resultDsgCod = new JLabel("--");
    resultDsgNome = new JLabel("--");
    resultEspecifico1 = new JLabel("--");
    resultEspecifico2 = new JLabel("--");
    menuBar = new JMenuBar();
    menuMain = new JMenu("MENU");
    menuItem = new JMenuItem("Voltar");
  }

  public void frame() {
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(500, 600);
    setResizable(false);
    setLocationRelativeTo(null);
    panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
    panelResultados.setLayout(new BoxLayout(panelResultados, BoxLayout.Y_AXIS));
    panelItens.setLayout(new BoxLayout(panelItens, BoxLayout.Y_AXIS));
    fotografia.setSelected(true);
    menuBar.add(menuMain);
    menuMain.add(menuItem);

    grupo1.add(fotografia);
    grupo1.add(post);

    panelEscolhaArte.add(fotografia);
    panelEscolhaArte.add(post);

    panelSearch.add(buscaLabel);
    panelSearch.add(busca);
    panelSearch.add(confirmar);

    panelContainer.add(panelEscolhaArte);
    panelContainer.add(panelSearch);

    panelItens.add(valor);
    panelItens.add(largura);
    panelItens.add(ano);
    panelItens.add(altura);
    panelItens.add(dsgCod);
    panelItens.add(dsgNome);
    panelItens.add(especifico1);
    panelItens.add(especifico2);

    panelResultados.add(resultValor);
    panelResultados.add(resultLargura);
    panelResultados.add(resultAno);
    panelResultados.add(resultAltura);
    panelResultados.add(resultDsgCod);
    panelResultados.add(resultDsgNome);
    panelResultados.add(resultEspecifico1);
    panelResultados.add(resultEspecifico2);

    setJMenuBar(menuBar);
    add(panelContainer);
    add(panelItens);
    add(panelResultados);
    add(cancela, BorderLayout.AFTER_LAST_LINE);
    add(altera);

    fotografia.addActionListener(this);
    post.addActionListener(this);
    confirmar.addActionListener(this);
    cancela.addActionListener(this);
    altera.addActionListener(this);
    menuItem.addActionListener(this);

    setLayout(new FlowLayout());
    setVisible(true);
  }

  public void actionPerformed(ActionEvent evt) {
    if(evt.getSource().equals(post)) {
      buscaLabel.setText("ID Post: ");
      valor.setText("Valor: ");
      largura.setText("Largura (cm): ");
      ano.setText("Ano: ");
      altura.setText("Altura (cm): ");
      dsgCod.setText("ID Designer: ");
      dsgNome.setText("Nome Designer: ");
      especifico1.setText("Nome Arte: ");
      especifico2.setText("ID: ");
      busca.setText("");
      resultValor.setText("--");
      resultLargura.setText("--");
      resultAno.setText("--");
      resultAltura.setText("--");
      resultDsgCod.setText("--");
      resultDsgNome.setText("--");
      resultEspecifico1.setText("--");
      resultEspecifico2.setText("--");

      return;
    }

    if(evt.getSource().equals(fotografia)) {
      buscaLabel.setText("ID Fotografia: ");
      valor.setText("Valor: ");
      largura.setText("Largura (cm): ");
      ano.setText("Ano: ");
      altura.setText("Altura (cm): ");
      dsgCod.setText("ID Designer: ");
      dsgNome.setText("Nome Designer: ");
      especifico1.setText("Local Foto: ");
      especifico2.setText("ID: ");
      busca.setText("");
      resultValor.setText("--");
      resultLargura.setText("--");
      resultAno.setText("--");
      resultAltura.setText("--");
      resultDsgCod.setText("--");
      resultDsgNome.setText("--");
      resultEspecifico1.setText("--");
      resultEspecifico2.setText("--");
      return;
    }

    if(evt.getSource().equals(confirmar)) {
      if(fotografia.isSelected()) {
        Fotografia fotografiaAux = new Fotografia();
        try {
          fotografiaAux.setCodFoto(Integer.parseInt(busca.getText()));
        } catch (NumberFormatException nfe) {
          JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS");
          return;
        }
        Fotografia fotografiaDados = bd.consArte(fotografiaAux);
        if(fotografiaDados != null) {
          resultValor.setText(String.valueOf(fotografiaDados.getValor()));
          resultLargura.setText(String.valueOf(fotografiaDados.getLargura()));
          resultAno.setText(String.valueOf(fotografiaDados.getAno()));
          resultAltura.setText(String.valueOf(fotografiaDados.getAltura()));
          resultDsgCod.setText(String.valueOf(fotografiaDados.getDsg().getCodDesigner()));
          resultDsgNome.setText(String.valueOf(fotografiaDados.getDsg().getNomeDesigner()));
          resultEspecifico1.setText(String.valueOf(fotografiaDados.getLocalFoto()));
          resultEspecifico2.setText(String.valueOf(fotografiaDados.getCodFoto()));
          return;
        } else {
          JOptionPane.showMessageDialog(null, "ID invalido, sem resultados!");
          busca.setText("");
          return;
        }
      } else if(post.isSelected()) {
        Post postAux = new Post();
        postAux.setCodPost(Integer.parseInt(busca.getText()));
        Post postDados = bd.consArte(postAux);
        if (postDados != null) {
          resultValor.setText(String.valueOf(postDados.getValor()));
          resultLargura.setText(String.valueOf(postDados.getLargura()));
          resultAno.setText(String.valueOf(postDados.getAno()));
          resultAltura.setText(String.valueOf(postDados.getAltura()));
          resultDsgCod.setText(String.valueOf(postDados.getDsg().getCodDesigner()));
          resultDsgNome.setText(String.valueOf(postDados.getDsg().getNomeDesigner()));
          resultEspecifico1.setText(String.valueOf(postDados.getNomeArte()));
          resultEspecifico2.setText(String.valueOf(postDados.getCodPost()));
          return;
        } else {
          JOptionPane.showMessageDialog(null, "ID invalido, sem resultados!");
          busca.setText("");
          return;
        }
      }
    }

    if(evt.getSource().equals(cancela) || evt.getSource().equals(menuItem)) {
      dispose();
      return;
    }

    if(evt.getSource().equals(altera)) {
      if(fotografia.isSelected()) {
        Fotografia newFotografia = new Fotografia();
        try{
          newFotografia.setCodFoto(Integer.parseInt(busca.getText()));
        } catch(NumberFormatException nfe) {
          JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS");
          return;
        }
        int index = bd.consArte(newFotografia, 0);
        Fotografia fotografiaAltera = bd.consArte(newFotografia);
        CadasAltera newCadastros = new CadasAltera(bd, fotografiaAltera, index);
        newCadastros.abreJan();
        return;
      } else if(post.isSelected()) {
        Post newPost = new Post();
        try{
          newPost.setCodPost(Integer.parseInt(busca.getText()));
          int index = bd.consArte(newPost, 0);
          Post postAltera = bd.consArte(newPost);
          CadasAltera newCadas = new CadasAltera(bd, postAltera, index);
          newCadas.abreJan();
        } catch (NullPointerException npe) {
          JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS");
          return;
        }
        return;
      }
    }
  }
}
  