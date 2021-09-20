// Giovanna Kodama Romero - 2101386

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CadasAltera extends JFrame implements ActionListener {
  private StorageArte bd;
  private ButtonGroup grupo1; 
  private JRadioButton fotografia;
  private JRadioButton post;
  private JButton confirmar;
  private JButton cancelar;
  private JLabel valor;
  private JLabel largura;
  private JLabel ano;
  private JLabel altura;
  private JLabel dsgCod;
  private JLabel dsgNome;
  private JLabel codFoto;
  private JLabel localFoto;
  private JLabel codPost;
  private JLabel nomeArte;
  private JTextField anoField;
  private JTextField valorField;
  private JTextField larguraField;
  private JTextField alturaField;
  private JTextField dsgCodField;
  private JTextField dsgNomeField;
  private JTextField codFotoField;
  private JTextField localFotoField;
  private JTextField codPostField;
  private JTextField nomeArteField;
  private JPanel panelEscolhaArte;
  private JPanel panelMenuGeral;
  private JPanel panelMenuFotografia;
  private JPanel panelMenuPost;
  private int index;
  private JMenuBar menuBar;
  private JMenu menuMain;
  private JMenuItem menuItem;

  public CadasAltera(StorageArte bd, Fotografia oldFotografia, int index) {
    this.bd = bd;
    this.index = index;
    grupo1 = new ButtonGroup();
    fotografia = new JRadioButton("Fotografia", false);
    post = new JRadioButton("Post", false);
    confirmar = new JButton("Confirmar");
    cancelar = new JButton("Cancelar");
    valor = new JLabel("Valor");
    largura = new JLabel("Largura (cm)");
    ano = new JLabel("Ano");
    altura = new JLabel("Altura (cm)");
    dsgCod = new JLabel("ID Designer");
    dsgNome = new JLabel("Designer");
    codFoto = new JLabel("ID Fotografia");
    localFoto = new JLabel("Local fotografia");
    codPost = new JLabel("ID Post");
    nomeArte = new JLabel("Nome da arte");
    anoField = new JTextField(String.valueOf(oldFotografia.getAno()), 40);
    valorField = new JTextField(String.valueOf(oldFotografia.getValor()), 40);
    larguraField = new JTextField(String.valueOf(oldFotografia.getLargura()), 40);
    alturaField = new JTextField(String.valueOf(oldFotografia.getAltura()), 40);
    dsgCodField = new JTextField(String.valueOf(oldFotografia.getDsg().getCodDesigner()), 40);
    dsgNomeField = new JTextField(String.valueOf(oldFotografia.getDsg().getNomeDesigner()), 40);
    codFotoField = new JTextField(String.valueOf(oldFotografia.getCodFoto()), 40);
    localFotoField = new JTextField(String.valueOf(oldFotografia.getLocalFoto()), 40);
    panelEscolhaArte = new JPanel();
    panelMenuGeral = new JPanel();
    panelMenuFotografia = new JPanel();
    panelMenuPost = new JPanel();
    menuBar = new JMenuBar();
    menuMain = new JMenu("MENU");
    menuItem = new JMenuItem("Voltar");
    panelMenuFotografia.setVisible(true);
    panelMenuPost.setVisible(false);
    fotografia.setSelected(true);
    post.setEnabled(false);
    panelMenuFotografia.add(codFoto);
    panelMenuFotografia.add(codFotoField);
    panelMenuFotografia.add(localFoto);
    panelMenuFotografia.add(localFotoField);
  }

  public CadasAltera(StorageArte bd, Post oldPost, int index) {
    this.bd = bd;
    this.index = index;
    grupo1 = new ButtonGroup();
    fotografia = new JRadioButton("Fotografia", false);
    post = new JRadioButton("Post", false);
    confirmar = new JButton("Confirmar");
    cancelar = new JButton("Cancelar");
    valor = new JLabel("Valor");
    largura = new JLabel("Largura (cm)");
    ano = new JLabel("Ano");
    altura = new JLabel("Altura (cm)");
    dsgCod = new JLabel("ID Designer");
    dsgNome = new JLabel("Nome Designer");
    codFoto = new JLabel("ID Fotografia");
    localFoto = new JLabel("Local fotografia");
    codPost = new JLabel("ID Post");
    nomeArte = new JLabel("Nome da Arte");
    anoField = new JTextField(String.valueOf(oldPost.getAno()), 40);
    valorField = new JTextField(String.valueOf(oldPost.getValor()), 40);
    larguraField = new JTextField(String.valueOf(oldPost.getLargura()), 40);
    alturaField = new JTextField(String.valueOf(oldPost.getAltura()), 40);
    dsgCodField = new JTextField(String.valueOf(oldPost.getDsg().getCodDesigner()), 40);
    dsgNomeField = new JTextField(String.valueOf(oldPost.getDsg().getNomeDesigner()), 40);
    codPostField = new JTextField(String.valueOf(oldPost.getCodPost()), 40);
    nomeArteField = new JTextField(String.valueOf(oldPost.getNomeArte()), 40);
    panelEscolhaArte = new JPanel();
    panelMenuGeral = new JPanel();
    panelMenuFotografia = new JPanel();
    panelMenuPost = new JPanel();
    menuBar = new JMenuBar();
    menuMain = new JMenu("MENU");
    menuItem = new JMenuItem("Voltar");
    panelMenuFotografia.setVisible(false);
    panelMenuPost.setVisible(true);
    post.setSelected(true);
    fotografia.setEnabled(false);
    panelMenuPost.add(codPost);
    panelMenuPost.add(codPostField);
    panelMenuPost.add(nomeArte);
    panelMenuPost.add(nomeArteField);
  }

  public void abreJan() {
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(500, 600);
    setResizable(false);
    setLocationRelativeTo(null);
    panelMenuGeral.setLayout(new BoxLayout(panelMenuGeral, BoxLayout.Y_AXIS));
    panelMenuFotografia.setLayout(new BoxLayout(panelMenuFotografia, BoxLayout.Y_AXIS));
    panelMenuPost.setLayout(new BoxLayout(panelMenuPost, BoxLayout.Y_AXIS));
    menuBar.add(menuMain);
    menuMain.add(menuItem);


    
    grupo1.add(fotografia);
    grupo1.add(post);

    panelEscolhaArte.add(fotografia);
    panelEscolhaArte.add(post);

    panelMenuGeral.add(valor);
    panelMenuGeral.add(valorField);
    panelMenuGeral.add(largura);
    panelMenuGeral.add(larguraField);
    panelMenuGeral.add(ano);
    panelMenuGeral.add(anoField);
    panelMenuGeral.add(altura);
    panelMenuGeral.add(alturaField);
    panelMenuGeral.add(dsgCod);
    panelMenuGeral.add(dsgCodField);
    panelMenuGeral.add(dsgNome);
    panelMenuGeral.add(dsgNomeField);

    setJMenuBar(menuBar);
    add(panelEscolhaArte, BorderLayout.NORTH);
    add(panelMenuGeral, BorderLayout.CENTER);
    add(panelMenuFotografia, BorderLayout.SOUTH);
    add(panelMenuPost, BorderLayout.SOUTH);
    add(confirmar);
    add(cancelar);


    fotografia.addActionListener(this);
    post.addActionListener(this);
    cancelar.addActionListener(this);
    confirmar.addActionListener(this);
    menuItem.addActionListener(this);

    setLayout(new FlowLayout());
    setVisible(true);
  }

  public void actionPerformed(ActionEvent evt) {
    if(evt.getSource().equals(fotografia)) {
      panelMenuFotografia.setVisible(true);
      panelMenuPost.setVisible(false);
      return;
    }

    if(evt.getSource().equals(post)) {
      panelMenuFotografia.setVisible(false);
      panelMenuPost.setVisible(true);
      return;
    }
    if(evt.getSource().equals(cancelar) || evt.getSource().equals(menuItem)) {
      setVisible(false);
      dispose();
      return;
    }
    if(evt.getSource().equals(confirmar)) {
      if(fotografia.isSelected()) {
        Fotografia fotografiaAux =  new Fotografia();
        fotografiaAux.setValor(Double.parseDouble(valorField.getText()));
        fotografiaAux.setLargura(Integer.parseInt(larguraField.getText()));
        fotografiaAux.setAno(Integer.parseInt(anoField.getText()));
        fotografiaAux.setAltura(Integer.parseInt(alturaField.getText()));
        fotografiaAux.getDsg().setCodDesigner(Integer.parseInt(dsgCodField.getText()));
        fotografiaAux.getDsg().setNomeDesigner(dsgNomeField.getText());
        fotografiaAux.setCodFoto(Integer.parseInt(codFotoField.getText()));
        fotografiaAux.setLocalFoto(localFotoField.getText());
        
        if(bd.alteraArte(fotografiaAux, index)) {
          JOptionPane.showMessageDialog(null, "A fotografia foi alterada com sucesso");
          anoField.setText(null);
          valorField.setText(null);
          larguraField.setText(null);
          alturaField.setText(null);
          dsgCodField.setText(null);
          dsgNomeField.setText(null);
          codFotoField.setText(null);
          localFotoField.setText(null);
          dispose();
          return;
        } else {
          JOptionPane.showMessageDialog(null, "Ocorreu um erro e a fotografia nao foi alterada");
          return;
        }
      } else {
        Post postAux = new Post();
        postAux.setValor(Double.parseDouble(valorField.getText()));
        postAux.setLargura(Integer.parseInt(larguraField.getText()));
        postAux.setAno(Integer.parseInt(anoField.getText()));
        postAux.setAltura(Integer.parseInt(alturaField.getText()));
        postAux.getDsg().setCodDesigner(Integer.parseInt(dsgCodField.getText()));
        postAux.getDsg().setNomeDesigner(dsgNomeField.getText());
        postAux.setNomeArte(nomeArteField.getText());
        postAux.setCodPost(Integer.parseInt(codPostField.getText()));

        if(bd.alteraArte(postAux, index)) {
          JOptionPane.showMessageDialog(null, "O post foi alterado com sucesso!");
          anoField.setText(null);
          valorField.setText(null);
          larguraField.setText(null);
          alturaField.setText(null);
          dsgCodField.setText(null);
          dsgNomeField.setText(null);
          codPostField.setText(null);
          nomeArteField.setText(null);
          dispose();
          return;
        } else {
          JOptionPane.showMessageDialog(null, "Ocorreu um erro e o post nao foi alterado");
          return;
        }
      }
      
    }
  }
}