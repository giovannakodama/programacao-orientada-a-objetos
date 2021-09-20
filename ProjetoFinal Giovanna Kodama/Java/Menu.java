//Giovanna Kodama Romero - 2101386

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class Menu extends JFrame implements ActionListener {
    private JButton bt1;
    private JButton bt2;
    private JButton bt3;
    private JButton bt4;
    private JButton bt5;
    private StorageArte bd;
    private JMenuBar menuBar;
    private JMenu menuMain;
    private JMenuItem menuItem;
    private JPanel panelContainer;

    public Menu(StorageArte bd) {
        bt1 = new JButton("Sair");
        bt2 = new JButton("Cadastrar Arte");
        bt3 = new JButton("Consultar Arte");
        bt4 = new JButton("Alterar Arte");
        bt5 = new JButton("Excluir Arte");
        menuBar = new JMenuBar();
        menuMain = new JMenu("MENU");
        menuItem = new JMenuItem("Sair");
        panelContainer = new JPanel();
        this.bd = bd;
      }

    public void jan() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        panelContainer.setLayout(new GridLayout(5,1));
        panelContainer.setSize(500, 500);

        menuBar.add(menuMain);
        menuMain.add(menuItem);
        panelContainer.add(bt2);
        panelContainer.add(bt3);
        panelContainer.add(bt4);
        panelContainer.add(bt5);
        panelContainer.add(bt1);

        setJMenuBar(menuBar);
        add(panelContainer);

        bt1.addActionListener(this);
    bt2.addActionListener(this);
    bt3.addActionListener(this);
    bt4.addActionListener(this);
    bt5.addActionListener(this);
    menuItem.addActionListener(this);

    setLayout(new GridLayout(1,6));
    setVisible(true);
  }

  public void actionPerformed(ActionEvent evt) {
    if(evt.getSource().equals(bt1) || evt.getSource().equals(menuItem)) {
      setVisible(false);
      dispose();
      return;
    }
    if(evt.getSource().equals(bt2)) {
      Cadas cad = new Cadas(bd);
      cad.abreJan();
      return;
    }

    if(evt.getSource().equals(bt3)) {
      Consulta con = new Consulta(bd);
      con.frame();
      return;
    }
    if(evt.getSource().equals(bt5)) {
      Exclui exc = new Exclui(bd);
      exc.frame();
      return;
    }

    if(evt.getSource().equals(bt4)) {
      Altera alterar = new Altera(bd);
      alterar.frame();
      return;
    }
    
  }
} 