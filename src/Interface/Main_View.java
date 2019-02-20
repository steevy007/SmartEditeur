/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Code_java.*;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author Sanon
 */
public class Main_View extends JFrame {
 
  Execution e=new Execution(this,true);
  String path="";
  String path1="";
  String compi="";
    /**
     * Creates new form Main_View
     */
    public Main_View() throws IOException {
        initComponents();
        this.setTitle("Smart-Editeur");
        this.setSize(1000,700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        //jScrollPane1.hide();
//        jTabbedPane2.hide();
jTabbedPane1.hide();
jSeparator2.hide();
jTabbedPane1.setTitleAt(0,"texte.java"); 
//   jFileChooser1.hide();
 // code.setText(d.ouvrir());
 //code.setText("1234");
 
    }


    public void save() throws FileNotFoundException, IOException{
        
        
        File f=new File(path);
        File f1=new File(path1);
        
        /*if(path.isEmpty() || path1.isEmpty()){
            JOptionPane.showMessageDialog(this,"Veuillez D'abord Enregistrer votre Fichier");
        }*/
        if(f.getName().equals(jTabbedPane1.getTitleAt(0))){
               FileOutputStream save=new FileOutputStream(f);
            save.write("".getBytes());
            String texte=code.getText();
            String nomP=path+jTabbedPane1.getTitleAt(0);
            Reader texte1=new StringReader(texte);
            BufferedReader bread = new BufferedReader(texte1);
            while((texte=bread.readLine())!=null){
                BufferedWriter fin=new BufferedWriter(new FileWriter(f,true));
                fin.write(texte);
                fin.newLine();
		fin.close();
                //System.out.println(texte);
            }
        }
        
        else if(f1.getName().equals(jTabbedPane1.getTitleAt(0))){
                       FileOutputStream save=new FileOutputStream(f1);
            save.write("".getBytes());
            String texte=code.getText();
            String nomP=path+jTabbedPane1.getTitleAt(0);
            Reader texte1=new StringReader(texte);
            BufferedReader bread = new BufferedReader(texte1);
            while((texte=bread.readLine())!=null){
                BufferedWriter fin=new BufferedWriter(new FileWriter(f1,true));
                fin.write(texte);
                fin.newLine();
		fin.close();
                //System.out.println(texte);
            }
        }
    
    }
    
    public String enregistrer(){
        Dialog d=new Dialog(this,true);
        path1=d.enr();
         File fichier=new File(path1);
         
        try{
        if(!fichier.exists()){
            fichier.createNewFile();
            String texte=code.getText();
            String nomP=path1+jTabbedPane1.getTitleAt(0);
            Reader texte1=new StringReader(texte);
            BufferedReader bread = new BufferedReader(texte1);
            while((texte=bread.readLine())!=null){
                BufferedWriter fin=new BufferedWriter(new FileWriter(fichier,true));
                fin.write(texte);
                fin.newLine();
		fin.close();
                //System.out.println(texte);
            }
            //System.out.println(texte1);
            //String path1= new File(nomP).getAbsolutePath();
            //System.out.println(path);
            //BufferedWriter fin=new BufferedWriter(new FileWriter(fichier,true));
            
            //fin.write("je suis steeve sanon");
            //System.out.println(texte);
            
            JOptionPane.showMessageDialog(null,"Fichier Enregistrer avec succes");
        }
        else{
            JOptionPane.showMessageDialog(null,"Ce fichier existe deja");
        }
        }catch(IOException e){
            jTabbedPane1.setTitleAt(0,"texte.java");
            JOptionPane.showMessageDialog(this,"Echec D'enregistrement");
             
        }
           String nom=fichier.getName();
        
        if(!nom.equals("")){
            jTabbedPane1.setTitleAt(0,nom);
        }
     
        
        return path1;
   }
//    String path1=d.ouvrir();
    
    public String load() throws IOException{
       // try{
       
      try {
 
           Dialog d=new Dialog(this,true);
           //jTabbedPane1.setTitleAt(0,"texte.java");
             path=d.ouvrir();
             
             File f=new File(path);
             String nom=f.getName();
             if(nom.equals("")){
                 jTabbedPane1.setTitleAt(0,"texte.java");
             }
             else{
                 jTabbedPane1.setTitleAt(0, nom);
             }
             
       String texte="";
       FileReader lecture;
          lecture = new FileReader(path);
           BufferedReader read=new BufferedReader(lecture);
       String ligne;
       while((ligne=read.readLine())!=null){
           texte+=ligne+"\n";
          
       }
      code.setText(texte);
      } catch (FileNotFoundException ex) {
          JOptionPane.showMessageDialog(this,"Fichier non trouve");
          jTabbedPane1.setTitleAt(0,"texte.java");
          jTabbedPane1.hide();
      }
      
        return path;
    }
    
    public void projet(){
        try {
        Dialog d=new Dialog(this,true);
        File f=new File(d.ouvrir1());
        String nom=f.getAbsolutePath();
        System.out.println(f.getName());
        }catch(Exception ex){}
    }
    
   
    
    public void nouveau() throws IOException{
         
    if(jTabbedPane1.getTitleAt(0).equals("texte.java") && code.getText().equals("")){
        code.setText(null);
         jTabbedPane1.setVisible(true);
         comp.setText(null);
    }
    if(jTabbedPane1.getTitleAt(0).equals("texte.java") && !code.getText().isEmpty()){
       int choix= JOptionPane.showConfirmDialog(this,"Voulez vous Enregistrer ce fichier");
       
       if(choix==1){
           jTabbedPane1.setTitleAt(0,"texte.java");
         jTabbedPane1.setVisible(true);
         
         code.setText(null);
         comp.setText(null);
       }
       
       else{
         
         enregistrer();
            jTabbedPane1.setTitleAt(0,"texte.java");
         jTabbedPane1.setVisible(true);
         code.setText(null);
         comp.setText(null);
       }
    }
    
    if(!jTabbedPane1.getTitleAt(0).equals("texte.java") && !code.getText().equals("")){
           int choix= JOptionPane.showConfirmDialog(this,"Voulez vous Sauvegarder ce fichier");
       
       if(choix==1){
           jTabbedPane1.setTitleAt(0,"texte.java");
         jTabbedPane1.setVisible(true);
         
         code.setText(null);
         comp.setText(null);
       }
       
       else{
           save();
            jTabbedPane1.setTitleAt(0,"texte.java");
         jTabbedPane1.setVisible(true);
         code.setText(null);
         comp.setText(null);
         
       }
    }
    }
  
    public String compiler(){
        File fich1=new File(path);
    File fich2=new File(path1);
      /* if(path1.isEmpty() && !jTabbedPane1.getTitleAt(0).equals(fich2.getName())){
            enregistrer();
        }*/
       
      // else{
    String nom=jTabbedPane1.getTitleAt(0);
    
        if(!jTabbedPane1.isShowing()){
                JOptionPane.showMessageDialog(this,"Veuillez Charger votre fichier");
        }
        if(fich1.getName().equals(jTabbedPane1.getTitleAt(0))){
            try{
   ProcessBuilder processbuilder = new ProcessBuilder ("cmd","/c"," javac "+path);
   Process process = processbuilder.redirectErrorStream(true).start();
   BufferedReader bread = new BufferedReader(new InputStreamReader(process.getInputStream()));
   String ligne;
   String text="";
   if((ligne = bread.readLine())==null){
      comp.setText("Compilation Reussi");
  
    }
        while((ligne = bread.readLine())!= null){
      text+=ligne+"\n";
       comp.setText(text);
       compi=text;
      // JOptionPane.showMessageDialog(this,text);
   }
}catch(IOException ex){
    System.err.println("Error"+ex.getMessage());
     }
        }   
       
        
       

        if(fich2.getName().equals(jTabbedPane1.getTitleAt(0))){
                      try{
   ProcessBuilder processbuilder = new ProcessBuilder ("cmd","/c"," javac "+path1);
   Process process = processbuilder.redirectErrorStream(true).start();
   BufferedReader bread = new BufferedReader(new InputStreamReader(process.getInputStream()));
   String ligne;
   String text="";
   if((ligne = bread.readLine())==null){
      comp.setText("Compilation Reussi");
  
    }
        while((ligne = bread.readLine())!= null){
      text+=ligne+"\n";
       comp.setText(text);
       compi=text;
   }
}catch(IOException ex){
    System.err.println("Error"+ex.getMessage());
     }
        }
        
      // }
        
        /*if(path1.isEmpty() || path.isEmpty() || jTabbedPane1.getTitleAt(0).equals("texte.java")|| jTabbedPane1.isShowing()){
            JOptionPane.showMessageDialog(this,"Veuillez Enregistrer votre Fichier");
        }*/
        return compi;
    }
    
    
     public void executer() throws IOException{
         save();
         compiler();
           File fich1=new File(path);
             File fich2=new File(path1);
             
             if(compi.isEmpty()){
         if(fich1.getName().equals(jTabbedPane1.getTitleAt(0))){
         String direc=path.substring(0,path.lastIndexOf(File.separator));
         int lon=direc.length();
         
         String c=direc.substring(3,lon);
        
        String p=new File("exec.bat").getAbsolutePath();
         File f=new File(p);
         String n=jTabbedPane1.getTitleAt(0);
         
         if(!f.exists()){
             f.createNewFile();
             BufferedWriter fin=new BufferedWriter(new FileWriter(f,true));
             fin.write("cd/");
             fin.newLine();
             fin.write("cd "+c);
             fin.newLine();
             fin.write("java "+n.substring(0,n.length()-5));
             fin.newLine();
             fin.write("exit /b");
             fin.close();
             
            /* ProcessBuilder processbuilder = new ProcessBuilder ("cmd","/c"," start "+p);
              Process process = processbuilder.redirectErrorStream(true).start();*/
         }
         else{
              FileOutputStream save=new FileOutputStream(f);
            save.write("".getBytes());
             BufferedWriter fin=new BufferedWriter(new FileWriter(f,true));
             fin.write("cd/");
             fin.newLine();
             fin.write("cd "+c);
             fin.newLine();
             fin.write("java "+n.substring(0,n.length()-5));
             fin.newLine();
             fin.write("exit /b");
             fin.close();
             
            ProcessBuilder processbuilder = new ProcessBuilder ("cmd","/c"," start "+p);
              Process process = processbuilder.redirectErrorStream(true).start();
         }
         }
          
          
          if(fich2.getName().equals(jTabbedPane1.getTitleAt(0))){
           String direc=path1.substring(0,path1.lastIndexOf(File.separator));
         int lon=direc.length();
         
         String c=direc.substring(3,lon);
        
        String p=new File("exec.bat").getAbsolutePath();
         File f=new File(p);
         String n=jTabbedPane1.getTitleAt(0);
         
         if(!f.exists()){
             f.createNewFile();
             BufferedWriter fin=new BufferedWriter(new FileWriter(f,true));
             fin.write("cd/");
             fin.newLine();
             fin.write("cd "+c);
             fin.newLine();
             fin.write("java "+n.substring(0,n.length()-5));
             fin.newLine();
             fin.write("exit /b");
             fin.close();
             
             /*ProcessBuilder processbuilder = new ProcessBuilder ("cmd","/c"," start "+p);
              Process process = processbuilder.redirectErrorStream(true).start();*/
         }
         else{
              FileOutputStream save=new FileOutputStream(f);
            save.write("".getBytes());
             BufferedWriter fin=new BufferedWriter(new FileWriter(f,true));
             fin.write("cd/");
             fin.newLine();
             fin.write("cd "+c);
             fin.newLine();
             fin.write("java "+n.substring(0,n.length()-5));
             fin.newLine();
             fin.write("exit /b");
             fin.close();
             
             ProcessBuilder processbuilder = new ProcessBuilder ("cmd","/c"," start "+p);
              Process process = processbuilder.redirectErrorStream(true).start();
         }
          
          }
          }
             else{
                 comp.setText(compi);
             }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        TBar = new javax.swing.JToolBar();
        btn_save = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        code = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        comp = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        Fich = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        M_enr = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TBar.setBackground(new java.awt.Color(204, 204, 255));
        TBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TBar.setRollover(true);
        TBar.setMargin(new java.awt.Insets(1, 0, 0, 0));

        btn_save.setBackground(new java.awt.Color(204, 204, 255));
        btn_save.setForeground(new java.awt.Color(0, 0, 0));
        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Entypo_d83d(0)_48.png"))); // NOI18N
        btn_save.setToolTipText("Sauvegarder Fichier");
        btn_save.setBorder(null);
        btn_save.setFocusable(false);
        btn_save.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_save.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_saveMouseEntered(evt);
            }
        });
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        TBar.add(btn_save);

        jButton4.setBackground(new java.awt.Color(204, 204, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Entypo_d83d(4)_48.png"))); // NOI18N
        jButton4.setToolTipText("Nouveau Fichier");
        jButton4.setBorder(null);
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        TBar.add(jButton4);

        jButton5.setBackground(new java.awt.Color(204, 204, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Entypo_e740(3)_48.png"))); // NOI18N
        jButton5.setToolTipText("Ouvrir Fichier");
        jButton5.setBorder(null);
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        TBar.add(jButton5);

        jButton7.setBackground(new java.awt.Color(204, 204, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Entypo_25b6(2)_48.png"))); // NOI18N
        jButton7.setToolTipText("Executer Fichier");
        jButton7.setBorder(null);
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        TBar.add(jButton7);

        jButton6.setBackground(new java.awt.Color(204, 204, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Entypo_25b8(1)_48.png"))); // NOI18N
        jButton6.setToolTipText("Compiler Fichier");
        jButton6.setBorder(null);
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        TBar.add(jButton6);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jTree1.setBackground(new java.awt.Color(255, 255, 255));
        jTree1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(51, 51, 51)));
        jTree1.setForeground(new java.awt.Color(255, 255, 255));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Projet");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(jTree1);

        code.setBackground(new java.awt.Color(204, 204, 255));
        code.setColumns(1);
        code.setFont(new java.awt.Font("Franklin Gothic Book", 3, 18)); // NOI18N
        code.setForeground(new java.awt.Color(51, 51, 51));
        code.setRows(1);
        code.setTabSize(1);
        code.setMargin(new java.awt.Insets(10, 10, 0, 0));
        code.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        code.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane4.setViewportView(code);

        jLayeredPane1.setLayer(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab1", jLayeredPane1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE))
        );

        comp.setEditable(false);
        comp.setBackground(new java.awt.Color(51, 51, 51));
        comp.setColumns(1);
        comp.setForeground(new java.awt.Color(204, 204, 255));
        comp.setRows(1);
        comp.setTabSize(1);
        comp.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Console", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(204, 204, 255))); // NOI18N
        jScrollPane1.setViewportView(comp);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenuBar1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuBar1.setForeground(new java.awt.Color(204, 204, 255));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(100, 23));

        Fich.setForeground(new java.awt.Color(204, 204, 255));
        Fich.setMnemonic('f');
        Fich.setText("Fichier");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem1.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Entypo_e731(0)_24.png"))); // NOI18N
        jMenuItem1.setText("Nouveau Fichier");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Fich.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem2.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Entypo_e740(0)_24.png"))); // NOI18N
        jMenuItem2.setText("Ouvrir Fichier");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Fich.add(jMenuItem2);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem4.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem4.setText("Ouvrir un projet");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        Fich.add(jMenuItem4);

        M_enr.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        M_enr.setBackground(new java.awt.Color(204, 204, 255));
        M_enr.setForeground(new java.awt.Color(51, 51, 51));
        M_enr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Entypo_d83d(0)_24.png"))); // NOI18N
        M_enr.setText("Enregistrer Fichier Sous");
        M_enr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_enrActionPerformed(evt);
            }
        });
        Fich.add(M_enr);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem3.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/FontAwesome_f02f(0)_24.png"))); // NOI18N
        jMenuItem3.setText("Sauvegarder");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        Fich.add(jMenuItem3);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem5.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem5.setText("Fermer Fichier");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        Fich.add(jMenuItem5);

        jMenuBar1.add(Fich);

        jMenu1.setForeground(new java.awt.Color(204, 204, 255));
        jMenu1.setMnemonic('E');
        jMenu1.setText("Execution");

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem6.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem6.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem6.setText("Compiler");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem7.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem7.setText("Executer");
        jMenu1.add(jMenuItem7);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(204, 204, 255));
        jMenu2.setMnemonic('o');
        jMenu2.setText("Outils");

        jMenu4.setForeground(new java.awt.Color(0, 51, 255));
        jMenu4.setText("Couleur");

        jMenuItem8.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem8.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem8.setText("Modifier La couleur");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenu2.add(jMenu4);

        jMenu5.setForeground(new java.awt.Color(0, 51, 255));
        jMenu5.setText("Police");

        jMenuItem9.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem9.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem9.setText("Modifier La Taille D'Ecriture");
        jMenu5.add(jMenuItem9);

        jMenu2.add(jMenu5);

        jMenuBar1.add(jMenu2);

        jMenu3.setForeground(new java.awt.Color(204, 204, 255));
        jMenu3.setMnemonic('A');
        jMenu3.setText("Aide");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TBar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

    
      try {
          nouveau();
      } catch (IOException ex) {
          Logger.getLogger(Main_View.class.getName()).log(Level.SEVERE, null, ex);
      }

    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    public void close() throws IOException{
        
          if(jTabbedPane1.getTitleAt(0).equals("texte.java") && code.getText().equals("")){
          code.setText(null);
         jTabbedPane1.setVisible(false);
         comp.setText(null);
        }
        if(jTabbedPane1.getTitleAt(0).equals("texte.java") && !code.getText().isEmpty()){
             int choix= JOptionPane.showConfirmDialog(this,"Voulez vous Enregistrer ce fichier");
       
       if(choix==1){
           jTabbedPane1.setTitleAt(0,"texte.java");
         jTabbedPane1.setVisible(true);
         
         code.setText(null);
         comp.setText(null);
       }
       
       else{
         
         enregistrer();
            jTabbedPane1.setTitleAt(0,"texte.java");
         jTabbedPane1.setVisible(true);
         code.setText(null);
         comp.setText(null);
       }
        }
       
         if(!jTabbedPane1.getTitleAt(0).equals("texte.java") && !code.getText().equals("")){
           int choix= JOptionPane.showConfirmDialog(this,"Voulez vous Sauvegarder ce fichier");
       
       if(choix==1){
           jTabbedPane1.setTitleAt(0,"texte.java");
         jTabbedPane1.setVisible(true);
         
         code.setText(null);
         comp.setText(null);
       }
       
       else{
           save();
            jTabbedPane1.setTitleAt(0,"texte.java");
         jTabbedPane1.setVisible(true);
         code.setText(null);
         comp.setText(null);
         
       }
    }
     
    }
    private void M_enrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_enrActionPerformed
        // TODO add your handling code here:
        
        if(jTabbedPane1.isShowing()){
           Dialog d=new Dialog(this,true);
          enregistrer();
        }
        else{
            JOptionPane.showMessageDialog(this,"Veuillez Creer un nouveau Fichier");
        }
    }//GEN-LAST:event_M_enrActionPerformed

    private void btn_saveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMouseEntered
        // TODO add your handling code here:
        //jButton3.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_btn_saveMouseEntered

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
      try {
          // TODO add your handling code here:
        
          executer();
          
          //e.setVisible(true);
      } catch (IOException ex) {
          Logger.getLogger(Main_View.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      try {
          // TODO add your handling code here:7
          save();
          if(path1.equals("") ){
          enregistrer();
          compiler();
          }
          else{
          compiler();
          }
      } catch (IOException ex) {
          Logger.getLogger(Main_View.class.getName()).log(Level.SEVERE, null, ex);
      }
//        compiler();
        //jScrollPane1.setVisible(true);
      
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
      try {
          if(jTabbedPane1.isShowing()){
             int choix= JOptionPane.showConfirmDialog(this,"Voulez vous Sauvegarder ce fichier");
     
            if(choix==1){
                
                        Dialog d=new Dialog(this,true);
         jTabbedPane1.setVisible(true);
          load();
            }
          }
          else{
              
                        Dialog d=new Dialog(this,true);
         jTabbedPane1.setVisible(true);
          load();
          }
         //}
          
      } catch (IOException ex) {
          Logger.getLogger(Main_View.class.getName()).log(Level.SEVERE, null, ex);
      }
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_saveActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here
        
        projet();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
      try {
          // TODO add your handling code here:
          close();
      } catch (IOException ex) {
          Logger.getLogger(Main_View.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
      try {
          // TODO add your handling code here:
          save();
      } catch (IOException ex) {
          Logger.getLogger(Main_View.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
          try {
          // TODO add your handling code here:7
          save();
          compiler();
      } catch (IOException ex) {
          Logger.getLogger(Main_View.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
     col c=new col(this,true);
        
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Fich;
    private javax.swing.JMenuItem M_enr;
    private javax.swing.JToolBar TBar;
    private javax.swing.JButton btn_save;
    private javax.swing.JTextArea code;
    private javax.swing.JTextArea comp;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
