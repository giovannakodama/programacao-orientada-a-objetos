// Giovanna Kodama Romero - 2101386

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cadas extends JFrame implements ActionListener {
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
  private JLabel localFoto;
  private JLabel codFoto;
  private JLabel nomeArte;
  private JLabel codPost;
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
  private JMenuBar menuBar;
  private JMenu menuMain;
  private JMenuItem menuItem;

  public Cadas(StorageArte bd) {
    this.bd = bd;
    grupo1 = new ButtonGroup();
    fotografia = new JRadioButton("Fotografia", false);
    post = new JRadioButton("Post", false);
    confirmar = new JButton("Confirmar");
    cancelar = new JButton("Cancelar");
    valor = new JLabel("Valor");
    largura = new JLabel("Largura(cm)");
    ano = new JLabel("Ano");
    altura = new JLabel("Altura (cm)");
    dsgCod = new JLabel("ID Designer");
    dsgNome = new JLabel("Designer");
    codFoto = new JLabel("ID Foto");
    localFoto = new JLabel("Local da foto");
    codPost = new JLabel("ID Post");
    nomeArte = new JLabel("Nome da Arte");
    anoField = new JTextField(40);
    valorField = new JTextField(40);
    larguraField = new JTextField(40);
    alturaField = new JTextField(40);
    dsgCodField = new JTextField(40);
    dsgNomeField = new JTextField(40);
    codFotoField = new JTextField(40);
    localFotoField = new JTextField(40);
    codPostField = new JTextField(40);
    nomeArteField = new JTextField(40);
    panelEscolhaArte = new JPanel();
    panelMenuGeral = new JPanel();
    panelMenuFotografia = new JPanel();
    panelMenuPost = new JPanel();
    menuBar = new JMenuBar();
    menuMain = new JMenu("MENU");
    menuItem = new JMenuItem("Voltar");
  }

  public void abreJan() {
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(500, 600);
    setResizable(false);
    setLocationRelativeTo(null);
    panelMenuGeral.setLayout(new BoxLayout(panelMenuGeral, BoxLayout.Y_AXIS));
    panelMenuFotografia.setLayout(new BoxLayout(panelMenuFotografia, BoxLayout.Y_AXIS));
    panelMenuPost.setLayout(new BoxLayout(panelMenuPost, BoxLayout.Y_AXIS));
    panelMenuFotografia.setVisible(true);
    panelMenuPost.setVisible(false);
    fotografia.setSelected(true);
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

    panelMenuFotografia.add(codFoto);
    panelMenuFotografia.add(codFotoField);
    panelMenuFotografia.add(localFoto);
    panelMenuFotografia.add(localFotoField);

    panelMenuPost.add(codPost);
    panelMenuPost.add(codPostField);
    panelMenuPost.add(nomeArte);
    panelMenuPost.add(nomeArteField);

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
        try{
          fotografiaAux.setValor(Double.parseDouble(valorField.getText()));
          fotografiaAux.setLargura(Integer.parseInt(larguraField.getText()));
          fotografiaAux.setAno(Integer.parseInt(anoField.getText()));
          fotografiaAux.setAltura(Integer.parseInt(alturaField.getText()));
          fotografiaAux.getDsg().setCodDesigner(Integer.parseInt(dsgCodField.getText()));
          fotografiaAux.getDsg().setNomeDesigner(dsgNomeField.getText());
          fotografiaAux.setCodFoto(Integer.parseInt(codFotoField.getText()));
          fotografiaAux.setLocalFoto(localFotoField.getText());
        }catch(NumberFormatException nfe) {
          JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS");
          return;
        }
        if(bd.insArte(fotografiaAux)) {
          JOptionPane.showMessageDialog(null, "A fotografia foi inserida com sucesso!");
          anoField.setText(null);
          valorField.setText(null);
          larguraField.setText(null);
          alturaField.setText(null);
          dsgCodField.setText(null);
          dsgNomeField.setText(null);
          codFotoField.setText(null);
          localFotoField.setText(null);
          return;
        } else {
          JOptionPane.showMessageDialog(null, "Ocorreu um erro e a fotografia nao foi inserida.");
          return;
        }
      } else {
        Post postAux = new Post();
        try{
          postAux.setValor(Double.parseDouble(valorField.getText()));
          postAux.setLargura(Integer.parseInt(larguraField.getText()));
          postAux.setAno(Integer.parseInt(anoField.getText()));
          postAux.setAltura(Integer.parseInt(alturaField.getText()));
          postAux.getDsg().setCodDesigner(Integer.parseInt(dsgCodField.getText()));
          postAux.getDsg().setNomeDesigner(dsgNomeField.getText());
          postAux.setNomeArte(nomeArteField.getText());
          postAux.setCodPost(Integer.parseInt(codPostField.getText()));
        }catch(NumberFormatException nfe) {
          JOptionPane.showMessageDialog(null, "PREENCHA OS CAMPOS ABAIXO");
          return;
        }
        if(bd.insArte(postAux)) {
          JOptionPane.showMessageDialog(null, "O post foi inserido com sucesso!");
          anoField.setText(null);
          valorField.setText(null);
          larguraField.setText(null);
          alturaField.setText(null);
          dsgCodField.setText(null);
          dsgNomeField.setText(null);
          codPostField.setText(null);
          nomeArteField.setText(null);
          return;
        } else {
          JOptionPane.showMessageDialog(null, "Ocorreu um erro e o post nao foi inserido");
          return;
        }
      }
    }
  }
}