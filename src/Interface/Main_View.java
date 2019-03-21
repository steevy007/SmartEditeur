/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Code_java.*;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.lang.ProcessBuilder.Redirect;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.tree.DefaultMutableTreeNode;
/**
 *
 * @author Sanon
 */
public class Main_View extends JFrame {
 
//  Execution e=new Execution(this,true);
  String path="";
  String path1="";
  String error="";
  String name=System.getProperty("os.name");
   Color coul;
    /**
     * Creates new form Main_View
     */
    public Main_View() throws IOException{
        initComponents();
       
        this.setTitle("Smart-Editeur");
        this.setSize(1000,700);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Icone/text_wrangler_19155.png")).getImage());
        this.setVisible(true);
  jScrollPane2.hide();
         jButton6.hide();
            jButton7.hide();
             jTabbedPane1.setIconAt(0, new ImageIcon(getClass().getResource("/Icone/icons8_File_30px.png")));
             //jTabbedPane1.add("Nouveau",jScrollPane4);
     
       if(name.startsWith("Windows")){
         
      try {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
          //UIManager.setLookAndFeel(new NimbusLookAndFeel());
      } catch (UnsupportedLookAndFeelException ex) {
          Logger.getLogger(Main_View.class.getName()).log(Level.SEVERE, null, ex);
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(Main_View.class.getName()).log(Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
          Logger.getLogger(Main_View.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
          Logger.getLogger(Main_View.class.getName()).log(Level.SEVERE, null, ex);
      }
           }else{
            try {
          UIManager.setLookAndFeel(new NimbusLookAndFeel());
      } catch (UnsupportedLookAndFeelException ex) {
          Logger.getLogger(Main_View.class.getName()).log(Level.SEVERE, null, ex);
      }
       }
        //jScrollPane1.hide();
//        jTabbedPane2.hide();
//jTabbedPane1.hide();


jTabbedPane1.setTitleAt(0,"texte.java"); 
close();
Line();
 fontStyle();
 
//   jFileChooser1.hide();
 // code.setText(d.ouvrir());
 //code.setText("1234");
 
    }

public void Line(){
    ImpLineNumModel l=new ImpLineNumModel();
    l.getingLineNumber(code, jScrollPane4);
}
    public void save() throws FileNotFoundException, IOException{
        
        comp.setText("");
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
    
    
    public void copy(){
        comp.setText("");
       code.copy();
    }
    
    public void paste(){
         comp.setText("");
        code.paste();
    }
    
    public void cut(){
         comp.setText("");
        code.cut();
    }
    public String enregistrer(){
         comp.setText("");
        Dialog d=new Dialog(this,true);
        path1=d.enr();
         File fichier=new File(path1);
         //System.out.println(path1);
        try{
        if(!fichier.exists()){
            fichier.createNewFile();
            String texte=code.getText();
            File f=new File(path1);
            String nom=f.getName();
             jTabbedPane1.setTitleAt(0,nom);
                         if(nom.equals("")){
                jTabbedPane1.setTitleAt(0,"texte.java");
             }
                     if(nom.substring(nom.length()-5, nom.length()).equals(".java")){
            jButton6.show();
            jButton7.show();
        }
           
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
            
            JOptionPane.showMessageDialog(null,"Fichier Enregistrer avec succes","Succès",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("/Icone/icons8_Ok_35px.png")));
        }
        else{
            JOptionPane.showMessageDialog(null,"Ce fichier existe deja","Echec",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("/Icone/icons8_Cancel_35px_1.png")));
        }
        }catch(IOException e){
            //jTabbedPane1.setTitleAt(0,"texte.java");
            JOptionPane.showMessageDialog(this,"Echec D'enregistrement");
             
        }
           String nom=fichier.getName();
        

     
        
        return path1;
   }
//    String path1=d.ouvrir();
    
    public String load() throws IOException{
         comp.setText("");
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
             String nom1=jTabbedPane1.getTitleAt(0);
                     if(nom1.substring(nom1.length()-5, nom1.length()).equals(".java")){
            jButton6.show();
            jButton7.show();
        }
                     if(!nom1.substring(nom1.length()-5, nom1.length()).equals(".java")){
                     jButton6.hide();
                  jButton7.hide();
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
    
    public void fontStyle(){
        String[] font=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for(int i=0;i<font.length;i++){
            tex.addItem(font[i]);
           
        }
        tex.setSelectedIndex(1);
    }

    
   
    
    public void nouveau() throws IOException{
          comp.setText("");
    if(jTabbedPane1.getTitleAt(0).equals("texte.java")  && !jTabbedPane1.isShowing()){
        
       code.setText(null);
       
         jTabbedPane1.setVisible(true);
         comp.setText(null);
    }
    
       
    
    if(jTabbedPane1.getTitleAt(0).equals("texte.java") && !code.getText().equals("") ){
           int choix= JOptionPane.showConfirmDialog(this,"Voulez vous Enregistrer ce fichier");
       
       if(choix==JOptionPane.NO_OPTION){
           jTabbedPane1.setTitleAt(0,"texte.java");
         jTabbedPane1.setVisible(true);
         
        code.setText(null);
         comp.setText(null);
       }
       
       else if(choix==JOptionPane.OK_OPTION){
           enregistrer();
            jTabbedPane1.setTitleAt(0,"texte.java");
         jTabbedPane1.setVisible(true);
         code.setText(null);
         comp.setText(null);
         
       }
       else if(choix==JOptionPane.CANCEL_OPTION){
           
       }
    }
    else{}
    if(!jTabbedPane1.getTitleAt(0).equals("texte.java") && code.getText().equals("")){
        
        int val=JOptionPane.showConfirmDialog(this,"Sauvegarder le fichier");
        
        if(val==JOptionPane.OK_OPTION){
            save();
                jTabbedPane1.setTitleAt(0,"texte.java");
         jTabbedPane1.setVisible(true);
         code.setText(null);
         comp.setText(null);
        }
        else if(val==JOptionPane.NO_OPTION){
                     jTabbedPane1.setTitleAt(0,"texte.java");
         jTabbedPane1.setVisible(true);
         code.setText(null);
         comp.setText(null);
        }
      
        
    }else{}
    
     if(!jTabbedPane1.getTitleAt(0).equals("texte.java") && !code.getText().equals("")){
        
        int val=JOptionPane.showConfirmDialog(this,"Sauvegarder le fichier");
        
        if(val==JOptionPane.OK_OPTION){
            save();
                jTabbedPane1.setTitleAt(0,"texte.java");
         jTabbedPane1.setVisible(true);
         code.setText(null);
         comp.setText(null);
        }
        else if(val==JOptionPane.NO_OPTION){
                     jTabbedPane1.setTitleAt(0,"texte.java");
         jTabbedPane1.setVisible(true);
         code.setText(null);
         comp.setText(null);
        }
      
        
    }else{}
    }
    

  
    public String  compiler(){
         comp.setText("");
         
        File fich1=new File(path);
    File fich2=new File(path1);
      /* if(path1.isEmpty() && !jTabbedPane1.getTitleAt(0).equals(fich2.getName())){
            enregistrer();
        }*/
           
           
         
         
      // else{
    String nom=jTabbedPane1.getTitleAt(0);
    /*
        if(!jTabbedPane1.isShowing()){
                JOptionPane.showMessageDialog(this,"Veuillez Charger votre fichier");
        }*/
        
        
        //System.out.println(nom.substring(nom.length()-5, nom.length()));

        
       

        
        
        if(fich1.getName().equals(jTabbedPane1.getTitleAt(0))){
          String direc=path.substring(0,path.lastIndexOf(File.separator));
            try{
                
           System.out.println();   
   //ProcessBuilder processbuilder = new ProcessBuilder ("cmd","/c"," javac "+jTabbedPane1.getTitleAt(0));
       //processbuilder.directory(new File(direc));          
  //Process process = processbuilder.redirectErrorStream(true).start();
  Process process=Runtime.getRuntime().exec("javac " +path);
   BufferedReader bread = new BufferedReader(new InputStreamReader(process.getInputStream()));
     BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

   String ligne;
   String text="";
   
    if((ligne = bread.readLine())==null && (ligne = stdError.readLine())==null){
      comp.setText("Compilation Reussi");
  
    }

        while((ligne = bread.readLine())!= null){
      text+=ligne+"\n";
       comp.setText(text);
     
      // JOptionPane.showMessageDialog(this,text);
   }
        
        while ((ligne = stdError.readLine()) != null) {
            text+=ligne+"\n";
       comp.setText(text);
        }
         error=text;
}catch(IOException ex){
    System.err.println("Error"+ex.getMessage());
     }
        }   
       
        
       

        if(fich2.getName().equals(jTabbedPane1.getTitleAt(0))){      
           String pa=path1.substring(0,path1.lastIndexOf(File.separator));
                      try{
   /*ProcessBuilder processbuilder = new ProcessBuilder ("cmd","/c"," javac "+jTabbedPane1.getTitleAt(0));
     processbuilder.directory(new File(pa));  */
   Process process=Runtime.getRuntime().exec("javac " +path1);
   //Process process = processbuilder.redirectErrorStream(true).start();
   BufferedReader bread = new BufferedReader(new InputStreamReader(process.getInputStream()));
   BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
   String ligne;
   String text="";
   if((ligne = bread.readLine())==null && (ligne = stdError.readLine())==null){
      comp.setText("Compilation Reussi");
  
    }
        while((ligne = bread.readLine())!= null){
      text+=ligne+"\n";
       comp.setText(text);
       
   }
        
                while ((ligne = stdError.readLine()) != null) {
            text+=ligne+"\n";
       comp.setText(text);
        }
                
                error=text;
}catch(IOException ex){
    System.err.println("Error"+ex.getMessage());
     }
        }
        
        
        
      // }
        
        /*if(path1.isEmpty() || path.isEmpty() || jTabbedPane1.getTitleAt(0).equals("texte.java")|| jTabbedPane1.isShowing()){
            JOptionPane.showMessageDialog(this,"Veuillez Enregistrer votre Fichier");
        }*/
      return error;
    }
    
    
     public void executer() throws IOException, InterruptedException,NoSuchElementException{
         //compiler();
         comp.setText("");
         
           File fich1=new File(path);
             File fich2=new File(path1);
            /* String direc=path.substring(0,path.lastIndexOf(File.separator));
         int lon=direc.length();
         
         String c=direc.substring(2,lon);*/
         String n=jTabbedPane1.getTitleAt(0);
        
           
        if(name.startsWith("Windows")){
            
       if(error.isEmpty()){
         
         //System.out.println(nom);
         if(fich1.getName().equals(jTabbedPane1.getTitleAt(0))){
         String direc=path.substring(0,path.lastIndexOf(File.separator));
         int lon=direc.length();
        // System.out.println(direc);
        // String c=direc.substring(3,lon);
         
         //Execution direct
          try{
            ProcessBuilder processbuilder = new ProcessBuilder ("cmd","/c"," java "+n.substring(0,n.length()-5));
            processbuilder.directory(new File(direc));
         
            Process process = processbuilder.redirectErrorStream(true).start();
            //process.waitFor();
            BufferedReader bread = new BufferedReader(new InputStreamReader(process.getInputStream()));
             BufferedReader err= new BufferedReader(new InputStreamReader(process.getErrorStream()));
             BufferedWriter ec = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            String ligne;
            String text="";
            
            
                 while((ligne = bread.readLine())!= null){
                     
               text+=ligne+"\n";
               comp.setText(text);
               if(ec!=null){
                   try{
                   comp.setText(text);
              ec.append(reps.getText());
              ec.close();
              
              comp.setText(text);
                   }catch(NoSuchElementException  e){}
               }
               
              
                //compi=text;
            }
                 
                  bread.close();
           err.close();
               
                 
                 
         }catch(IOException ex){
             System.err.println("Error"+ex.getMessage());
              }catch(NoSuchElementException  e){
         
         }
         
        
         }
          
          
          if(fich2.getName().equals(jTabbedPane1.getTitleAt(0))){
           String direc=path1.substring(0,path1.lastIndexOf(File.separator));
         int lon=direc.length();
         
         String c=direc.substring(3,lon);
          try{
            ProcessBuilder processbuilder = new ProcessBuilder ("cmd","/c"," java "+n.substring(0,n.length()-5));
            processbuilder.directory(new File(direc));
        
            Process process = processbuilder.redirectErrorStream(true).start();
            BufferedReader bread = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String ligne;
            String text="";
            
            
                 while((ligne = bread.readLine())!= null){
               text+=ligne+"\n";
               
                comp.setText(text);
                //compi=text;
            }
                /* EC e=new EC(this,true);
                 e.setExec("Steeve");*/
         }catch(IOException ex){
             System.err.println("Error"+ex.getMessage());
              }
         

                      }
        }else{
            comp.setText("Veuillez corrigez vos Erreur et Recompile\n"+error);
        }
        }else{
            
              
       if(error.isEmpty()){
         
         //System.out.println(nom);
         if(fich1.getName().equals(jTabbedPane1.getTitleAt(0))){
         String direc=path.substring(0,path.lastIndexOf(File.separator));
         int lon=direc.length();
        // System.out.println(direc);
        // String c=direc.substring(3,lon);
         
         //Execution direct
          try{
            ProcessBuilder processbuilder = new ProcessBuilder ("cmd","/c"," java "+n.substring(0,n.length()-5));
            processbuilder.directory(new File(direc));
         
            Process process = processbuilder.redirectErrorStream(true).start();
            //process.waitFor();
            BufferedReader bread = new BufferedReader(new InputStreamReader(process.getInputStream()));
             
            String ligne;
            String text="";
            
            
                 while((ligne = bread.readLine())!= null){
               text+=ligne+"\n";
               
                comp.setText(text);
               
                //compi=text;
            }
           
                /* EC e=new EC(this,true);
                 e.setExec("Steeve");*/
         }catch(IOException ex){
             System.err.println("Error"+ex.getMessage());
              }
         
        
         }
          
          
          if(fich2.getName().equals(jTabbedPane1.getTitleAt(0))){
           String direc=path1.substring(0,path1.lastIndexOf(File.separator));
         int lon=direc.length();
         
         String c=direc.substring(3,lon);
          try{
            ProcessBuilder processbuilder = new ProcessBuilder ("cmd","/c"," java "+n.substring(0,n.length()-5));
            processbuilder.directory(new File(direc));
        
            Process process = processbuilder.redirectErrorStream(true).start();
            BufferedReader bread = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String ligne;
            String text="";
            
            
                 while((ligne = bread.readLine())!= null){
               text+=ligne+"\n";
               
                comp.setText(text);
                //compi=text;
            }
                /* EC e=new EC(this,true);
                 e.setExec("Steeve");*/
         }catch(IOException ex){
             System.err.println("Error"+ex.getMessage());
              }
         

                      }
        }else{
            comp.setText("Veuillez corrigez vos Erreur et Recompile\n"+error);
        }  
        }
    }
     
     
     public void WebView(){
          try{
            System.out.println( path=new File("index.html").getAbsolutePath());
            String f=new File("/Fich_Ex/index.html").getAbsolutePath();
            System.out.println();
      ProcessBuilder processbuilder = new ProcessBuilder (" start "+f);
   Process process = processbuilder.redirectErrorStream(true).start();
  
}catch(IOException ex){
    System.err.println("Error"+ex.getMessage());
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
        jSeparator1 = new javax.swing.JSeparator();
        TBar = new javax.swing.JToolBar();
        btn_save = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        tex = new javax.swing.JComboBox<>();
        taile = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        arbre = new javax.swing.JTree();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        code = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        comp = new javax.swing.JTextArea();
        reps = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        Fich = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        M_enr = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        TBar.setBackground(new java.awt.Color(204, 204, 255));
        TBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TBar.setRollover(true);
        TBar.setMargin(new java.awt.Insets(1, 0, 0, 0));

        btn_save.setBackground(new java.awt.Color(204, 204, 255));
        btn_save.setForeground(new java.awt.Color(0, 0, 0));
        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Save_as_50px_3.png"))); // NOI18N
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
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_File_48px_2.png"))); // NOI18N
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
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Add_File_48px.png"))); // NOI18N
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
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Play_48px.png"))); // NOI18N
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
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Settings_48px.png"))); // NOI18N
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

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        tex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        tex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texActionPerformed(evt);
            }
        });

        taile.setEditable(true);
        taile.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "14", "16", "18", "20", "22", "24", "26", "28", "30", "32", "34", "36" }));
        taile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taileActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Text_30px_1.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Bold_30px.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Italic_30px_1.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(17, 17, 17)
                .addComponent(tex, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(taile, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(436, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tex, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(taile, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        TBar.add(jPanel3);

        arbre.setBackground(new java.awt.Color(255, 255, 255));
        arbre.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(51, 51, 51)));
        arbre.setForeground(new java.awt.Color(255, 255, 255));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Projet");
        arbre.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(arbre);

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));

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
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab1", jLayeredPane1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );

        comp.setEditable(false);
        comp.setBackground(new java.awt.Color(204, 204, 255));
        comp.setColumns(1);
        comp.setForeground(new java.awt.Color(51, 51, 51));
        comp.setRows(1);
        comp.setTabSize(1);
        comp.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Console", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(51, 51, 51))); // NOI18N
        comp.setDragEnabled(true);
        comp.setMargin(new java.awt.Insets(10, 10, 0, 0));
        jScrollPane1.setViewportView(comp);

        reps.setBackground(new java.awt.Color(51, 51, 51));
        reps.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        reps.setForeground(new java.awt.Color(204, 204, 255));
        reps.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        reps.setMargin(new java.awt.Insets(0, 0, 10, 10));
        reps.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                repsKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reps)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reps, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 255));
        jMenuBar1.setForeground(new java.awt.Color(204, 204, 255));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(100, 23));

        Fich.setForeground(new java.awt.Color(0, 0, 0));
        Fich.setMnemonic('f');
        Fich.setText("Fichier");
        Fich.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FichMouseExited(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem1.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_New_File_30px.png"))); // NOI18N
        jMenuItem1.setText("Nouveau Fichier");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Fich.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem2.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Add_File_30px_1.png"))); // NOI18N
        jMenuItem2.setText("Ouvrir Fichier");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Fich.add(jMenuItem2);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem4.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Open_30px.png"))); // NOI18N
        jMenuItem4.setText("Ouvrir un projet");
        jMenuItem4.setToolTipText("Fonction Non Disponible");
        jMenuItem4.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Open_30px.png"))); // NOI18N
        jMenuItem4.setEnabled(false);
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        Fich.add(jMenuItem4);
        Fich.add(jSeparator5);

        M_enr.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        M_enr.setBackground(new java.awt.Color(204, 204, 255));
        M_enr.setForeground(new java.awt.Color(0, 0, 0));
        M_enr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Save_Archive_30px.png"))); // NOI18N
        M_enr.setText("Enregistrer Fichier Sous");
        M_enr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_enrActionPerformed(evt);
            }
        });
        Fich.add(M_enr);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem3.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Save_30px.png"))); // NOI18N
        jMenuItem3.setText("Sauvegarder");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        Fich.add(jMenuItem3);
        Fich.add(jSeparator3);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem5.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Delete_File_30px.png"))); // NOI18N
        jMenuItem5.setText("Fermer Fichier");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        Fich.add(jMenuItem5);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem9.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Delete_30px.png"))); // NOI18N
        jMenuItem9.setText("Quitter");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        Fich.add(jMenuItem9);

        jMenuBar1.add(Fich);

        jMenu5.setForeground(new java.awt.Color(0, 0, 0));
        jMenu5.setMnemonic('e');
        jMenu5.setText("Edition");

        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem13.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem13.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Copy_30px.png"))); // NOI18N
        jMenuItem13.setText("Copy");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem13);

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem14.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem14.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Paste_30px.png"))); // NOI18N
        jMenuItem14.setText("Paste");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem14);

        jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem15.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem15.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Cut_30px.png"))); // NOI18N
        jMenuItem15.setText("Cut");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem15);

        jMenuItem16.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem16.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem16.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Undo_30px.png"))); // NOI18N
        jMenuItem16.setText("Undo");
        jMenuItem16.setToolTipText("Fonction Non Disponible");
        jMenuItem16.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Undo_30px.png"))); // NOI18N
        jMenuItem16.setEnabled(false);
        jMenu5.add(jMenuItem16);

        jMenuItem17.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem17.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem17.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Redo_30px.png"))); // NOI18N
        jMenuItem17.setText("Redo");
        jMenuItem17.setToolTipText("Fonction Non Disponible");
        jMenuItem17.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Redo_30px.png"))); // NOI18N
        jMenuItem17.setEnabled(false);
        jMenu5.add(jMenuItem17);

        jMenuBar1.add(jMenu5);

        jMenu1.setForeground(new java.awt.Color(0, 0, 0));
        jMenu1.setMnemonic('E');
        jMenu1.setText("Execution");

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem6.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem6.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Play_30px_1.png"))); // NOI18N
        jMenuItem6.setText("Compiler");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem7.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Settings_30px.png"))); // NOI18N
        jMenuItem7.setText("Executer");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuBar1.add(jMenu1);

        jMenu6.setForeground(new java.awt.Color(0, 0, 0));
        jMenu6.setMnemonic('u');
        jMenu6.setText("Equipes");

        jMenuItem18.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem18.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem18.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_GitHub_30px.png"))); // NOI18N
        jMenuItem18.setText("Contribuer Au Codage");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem18);

        jMenuBar1.add(jMenu6);

        jMenu2.setForeground(new java.awt.Color(0, 0, 0));
        jMenu2.setMnemonic('o');
        jMenu2.setText("Preferences");

        jMenu4.setBackground(new java.awt.Color(204, 204, 255));
        jMenu4.setForeground(new java.awt.Color(51, 51, 51));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Color_Wheel_30px.png"))); // NOI18N
        jMenu4.setText("Couleur");

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        jMenuItem8.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem8.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Color_Dropper_30px.png"))); // NOI18N
        jMenuItem8.setText("Modifier La couleur de fond");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        jMenuItem10.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem10.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Choose_Font_30px_1.png"))); // NOI18N
        jMenuItem10.setText("Modifier La Couleur d'ecriture");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuItem19.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem19.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem19.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Synchronize_30px.png"))); // NOI18N
        jMenuItem19.setText("Renitialiser les Couleur");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem19);

        jMenu2.add(jMenu4);

        jMenuBar1.add(jMenu2);

        jMenu3.setForeground(new java.awt.Color(0, 0, 0));
        jMenu3.setMnemonic('A');
        jMenu3.setText("Aide");

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem11.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem11.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_Geography_30px.png"))); // NOI18N
        jMenuItem11.setText("Document Web");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem12.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem12.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_GIF_30px.png"))); // NOI18N
        jMenuItem12.setText("Gif Video");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

        jMenuItem20.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        jMenuItem20.setBackground(new java.awt.Color(204, 204, 255));
        jMenuItem20.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/icons8_About_30px_2.png"))); // NOI18N
        jMenuItem20.setText("A propos");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem20);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TBar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
         comp.setText("");
          if(jTabbedPane1.getTitleAt(0).equals("texte.java") && code.getText().equals("")){
          code.setText(null);
         jTabbedPane1.setVisible(false);
         comp.setText(null);
        }
          
        if(jTabbedPane1.getTitleAt(0).equals("texte.java") && !code.getText().equals("")  && jTabbedPane1.isShowing()){
             int choix= JOptionPane.showConfirmDialog(this,"Voulez vous Enregistrer ce fichier");
       
       if(choix==JOptionPane.NO_OPTION){
           jTabbedPane1.setTitleAt(0,"texte.java");
         jTabbedPane1.setVisible(true);
         
         code.setText(null);
         comp.setText(null);
       }
       
       else if(choix==JOptionPane.OK_OPTION){
         
         enregistrer();
           
         jTabbedPane1.setVisible(true);
         code.setText(null);
         comp.setText(null);
       }
       else{
            
        }
        }
       
         if(!jTabbedPane1.getTitleAt(0).equals("texte.java") && !code.getText().equals("")){
           int choix= JOptionPane.showConfirmDialog(this,"Voulez vous Sauvegarder ce fichier");
       
       if(choix==JOptionPane.NO_OPTION){
           jTabbedPane1.setTitleAt(0,"texte.java");
         jTabbedPane1.setVisible(true);
         
         code.setText(null);
         comp.setText(null);
       }
       
       else if(choix==JOptionPane.OK_OPTION){
           save();
            jTabbedPane1.setTitleAt(0,"texte.java");
         jTabbedPane1.setVisible(true);
         code.setText(null);
         comp.setText(null);
         
       }
    }
          if(!jTabbedPane1.getTitleAt(0).equals("texte.java") && code.getText().equals("")){
              save();
               jTabbedPane1.setVisible(true);
         code.setText(null);
         comp.setText(null);
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
      } catch (InterruptedException ex) {
          Logger.getLogger(Main_View.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      try {
          // TODO add your handling code here:7
          save();

          compiler();
      } catch (IOException ex) {
          Logger.getLogger(Main_View.class.getName()).log(Level.SEVERE, null, ex);
      }
//        compiler();
        //jScrollPane1.setVisible(true);
      
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
      try {
          close();
              
                        Dialog d=new Dialog(this,true);
         jTabbedPane1.setVisible(true);
          load();
         
         //}
          
      } catch (IOException ex) {
          Logger.getLogger(Main_View.class.getName()).log(Level.SEVERE, null, ex);
      }
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
      try {
          // TODO add your handling code here:
          save();
      } catch (IOException ex) {
          Logger.getLogger(Main_View.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      try {
          // TODO add your handling code here:
          nouveau();
      } catch (IOException ex) {
          Logger.getLogger(Main_View.class.getName()).log(Level.SEVERE, null, ex);
      }
     
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
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
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here
       // JOptionPane.showMessageDialog(this,"Desole Cette Fonction n'est pas encore disponible","Non disponible",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("/Icone/icons8_Do_Not_Disturb_35px.png")));
     
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

    public void closeF() throws IOException{
         comp.setText("");
          if(!jTabbedPane1.isShowing()){
                    System.exit(0);
                }  
          
            int val=JOptionPane.showConfirmDialog(this,"Vouler vous vraiment fermer cette fenetre","Femer",JOptionPane.NO_OPTION);
       
          
        if(val==JOptionPane.OK_OPTION){
            if(jTabbedPane1.isShowing() && !code.getText().equals("") && !jTabbedPane1.getTitleAt(0).equals("texte.java")){
            int c=JOptionPane.showConfirmDialog(this,"Voulez vous Sauvegarder le fichier "+jTabbedPane1.getTitleAt(0));
            
                if(c==JOptionPane.OK_OPTION){
                    save();
                       System.exit(0);
                }
                else if(c==JOptionPane.CANCEL_OPTION){
                    
                }
                else{
                       System.exit(0);
                }
            }
            
              if(jTabbedPane1.isShowing() && code.getText().equals("")&& !jTabbedPane1.getTitleAt(0).equals("texte.java")){
            int c=JOptionPane.showConfirmDialog(this,"Voulez vous Enregistrer le fichier "+jTabbedPane1.getTitleAt(0));
            
                if(c==JOptionPane.OK_OPTION){
                    enregistrer();
                }
                
                else if(c==JOptionPane.CANCEL_OPTION){
                    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
                else{
                       System.exit(0);
                }
                
               
            }
              
                if(jTabbedPane1.isShowing() && !code.getText().equals("") && jTabbedPane1.getTitleAt(0).equals("texte.java")){
            int c=JOptionPane.showConfirmDialog(this,"Voulez vous Enregistre le fichier avant la fermeture "+jTabbedPane1.getTitleAt(0));
            
                if(c==JOptionPane.OK_OPTION){
                    enregistrer();
                    System.exit(0);
                }
                
                else if(c==JOptionPane.CANCEL_OPTION){
                     this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
                else{
                       System.exit(0);
                }
            }
                
                   if(jTabbedPane1.isShowing() && code.getText().equals("") && jTabbedPane1.getTitleAt(0).equals("texte.java")){
                      int c=JOptionPane.showConfirmDialog(this,"Voulez vous Enregistre le fichier avant la fermeture "+jTabbedPane1.getTitleAt(0));
            
                if(c==JOptionPane.OK_OPTION){
                    enregistrer();
                    System.exit(0);
                }
                
                else if(c==JOptionPane.CANCEL_OPTION){
                     this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
                else{
                       System.exit(0);
                }
                    }
         
        }
       
        else if(val==JOptionPane.NO_OPTION){
            
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
        else{
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
            
    }
    public void style(){
               String tai=taile.getSelectedItem().toString();
       String tex1=tex.getSelectedItem().toString();
        //System.out.println(Integer.parseInt(tai));
        code.setFont(new Font(tex1,Font.BOLD,Integer.parseInt(tai)));
        comp.setFont(new Font(tex1,Font.BOLD,Integer.parseInt(tai)));
    }
    private void taileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taileActionPerformed
        // TODO add your handling code here:
        style();
        
    }//GEN-LAST:event_taileActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        Color coul=JColorChooser.showDialog(null,"Changer la couleur de fond", TBar.getForeground());
        jTabbedPane1.setForegroundAt(0, coul);
        code.setForeground( coul);
        comp.setForeground( coul);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:

        Color coul=JColorChooser.showDialog(null,"Changer la couleur de fond", TBar.getBackground());
        
        TBar.setBackground(coul);
        btn_save.setBackground(coul);
        jButton4.setBackground(coul);
        jButton5.setBackground(coul);
        jButton7.setBackground(coul);
        jButton6.setBackground(coul);
        code.setBackground(coul);
        comp.setBackground(coul);
        jPanel3.setBackground(coul);
        jMenuItem1.setBackground(coul);
        jMenuItem2.setBackground(coul);
        jMenuItem3.setBackground(coul);
        jMenu4.setBackground(coul);
        jMenuItem4.setBackground(coul);
          jMenuItem5.setBackground(coul);
            jMenuItem6.setBackground(coul);
          jMenuItem7.setBackground(coul);
            jMenuItem8.setBackground(coul);
            jMenuItem9.setBackground(coul);
              jMenuItem10.setBackground(coul);
            jMenuItem11.setBackground(coul);
              jMenuItem12.setBackground(coul);
               M_enr.setBackground(coul);
             jMenuItem13.setBackground(coul);
             jMenuItem14.setBackground(coul);
             jMenuItem15.setBackground(coul);
             jMenuItem16.setBackground(coul);
             jMenuItem17.setBackground(coul);
             jMenu4.setBackground(coul);
             jMenuItem19.setBackground(coul);
             jMenuItem18.setBackground(coul);
             jMenuItem20.setBackground(coul);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
      try {
          // TODO add your handling code here:
          executer();
      } catch (IOException ex) {
          Logger.getLogger(Main_View.class.getName()).log(Level.SEVERE, null, ex);
      } catch (InterruptedException ex) {
          Logger.getLogger(Main_View.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
      try {
          // TODO add your handling code here:
          closeF();
      } catch (IOException ex) {
          Logger.getLogger(Main_View.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void FichMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FichMouseExited
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_FichMouseExited

    public void source() throws URISyntaxException, IOException{
        Desktop.getDesktop().browse(new URI("https://github.com/steevy007/SmartEditeur"));
    }
    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
      
          // TODO add your handling code here:
          WebView(); 
     
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        copy();
        
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        paste();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
        cut();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void texActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texActionPerformed
        // TODO add your handling code here:
       style();
    }//GEN-LAST:event_texActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      try {
          // TODO add your handling code here:

          closeF();
      } catch (IOException ex) {
          Logger.getLogger(Main_View.class.getName()).log(Level.SEVERE, null, ex);
      }
    
    }//GEN-LAST:event_formWindowClosing

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        String tai=taile.getSelectedItem().toString();
        String tex1=tex.getSelectedItem().toString();
        //System.out.println(Integer.parseInt(tai));
        code.setFont(new Font(tex1,Font.PLAIN,Integer.parseInt(tai)));
        comp.setFont(new Font(tex1,Font.PLAIN,Integer.parseInt(tai)));
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        String tai=taile.getSelectedItem().toString();
        String tex1=tex.getSelectedItem().toString();
        //System.out.println(Integer.parseInt(tai));
        code.setFont(new Font(tex1,Font.BOLD,Integer.parseInt(tai)));
        comp.setFont(new Font(tex1,Font.BOLD,Integer.parseInt(tai)));
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        String tai=taile.getSelectedItem().toString();
        String tex1=tex.getSelectedItem().toString();
        //System.out.println(Integer.parseInt(tai));
        code.setFont(new Font(tex1,Font.ITALIC,Integer.parseInt(tai)));
        comp.setFont(new Font(tex1,Font.ITALIC,Integer.parseInt(tai)));
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
      try {
          // TODO add your handling code here:
          source();
      } catch (URISyntaxException ex) {
          Logger.getLogger(Main_View.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
          Logger.getLogger(Main_View.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:
        TBar.setBackground(new Color(204, 204, 255));
        btn_save.setBackground(new Color(204, 204, 255));
        jButton4.setBackground(new Color(204, 204, 255));
        jButton5.setBackground(new Color(204, 204, 255));
        jButton7.setBackground(new Color(204, 204, 255));
        jButton6.setBackground(new Color(204, 204, 255));
        code.setBackground(new Color(204, 204, 255));
        jMenuItem20.setBackground(new Color(204, 204, 255));
        comp.setBackground(new Color(204, 204, 255));
        jPanel3.setBackground(new Color(204, 204, 255));
        jMenuItem1.setBackground(new Color(204, 204, 255));
        jMenuItem2.setBackground(new Color(204, 204, 255));
        jMenuItem3.setBackground(new Color(204, 204, 255));
        jMenu4.setBackground(new Color(204, 204, 255));
        jMenuItem4.setBackground(new Color(204, 204, 255));
          jMenuItem5.setBackground(new Color(204, 204, 255));
            jMenuItem6.setBackground(new Color(204, 204, 255));
          jMenuItem7.setBackground(new Color(204, 204, 255));
            jMenuItem8.setBackground(new Color(204, 204, 255));
            jMenuItem9.setBackground(new Color(204, 204, 255));
              jMenuItem10.setBackground(new Color(204, 204, 255));
            jMenuItem11.setBackground(new Color(204, 204, 255));
              jMenuItem12.setBackground(new Color(204, 204, 255));
               M_enr.setBackground(new Color(204, 204, 255));
             jMenuItem13.setBackground(new Color(204, 204, 255));
             jMenuItem14.setBackground(new Color(204, 204, 255));
             jMenuItem15.setBackground(new Color(204, 204, 255));
             jMenuItem16.setBackground(new Color(204, 204, 255));
             jMenuItem17.setBackground(new Color(204, 204, 255));
             jMenu4.setBackground(new Color(204, 204, 255));
             jMenuItem19.setBackground(new Color(204, 204, 255));
             jMenuItem18.setBackground(new Color(204, 204, 255));
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        // TODO add your handling code here:
        About a=new About(this,true);
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void repsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_repsKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
		{
            try {
                executer();
            } catch (IOException ex) {
                Logger.getLogger(Main_View.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main_View.class.getName()).log(Level.SEVERE, null, ex);
            }
		}
      
    }//GEN-LAST:event_repsKeyPressed

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
    private javax.swing.JTree arbre;
    private javax.swing.JButton btn_save;
    private javax.swing.JTextArea code;
    private javax.swing.JTextArea comp;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField reps;
    private javax.swing.JComboBox<String> taile;
    private javax.swing.JComboBox<String> tex;
    // End of variables declaration//GEN-END:variables
}
