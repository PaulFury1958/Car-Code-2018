package br.com.carcode.telas;


import br.com.carcode.controller.ClienteController;
import br.com.carcode.modelo.Cliente;
import br.com.carcode.platescanner.PlateCarClient;
import java.awt.Cursor;
import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.bytedeco.javacv.*;

import org.bytedeco.javacpp.opencv_core.IplImage;
import static org.bytedeco.javacpp.opencv_core.cvFlip;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvSaveImage;


/**
 *
 * @author RODRIGO
 */
public class TelaCadCliente extends javax.swing.JFrame implements Runnable {
    final int INTERVAL = 100;///you may use interval
    CanvasFrame canvas = new CanvasFrame("Web Cam");
    Thread th;
    
    @Override
    public void run() {

        FrameGrabber grabber = new VideoInputFrameGrabber(0); // 1 for next camera
        OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
        IplImage img;
       
        int i = 0;
        try {
            grabber.start();
            while (true) {
                Frame frame = grabber.grab();
                
                img = converter.convert(frame);

                //the grabbed frame will be flipped, re-flip to make it right
            //    cvFlip(img, img, 1);// l-r = 90_degrees_steps_anti_clockwise

                //save
                cvSaveImage((++i) + "-aa.jpg", img);
                //cvSaveImage("aa.jpg", img);
                
                PlateCarClient plateCarClient = new PlateCarClient();
                if (img != null) {
                    System.out.println("A imagem não é vazia");
                    try{
                        
                        //fotoPlaca1.setIcon(new ImageIcon(img.getScaledInstance(fotoPlaca1.getWidth(),fotoPlaca1.getHeight(), Image.SCALE_DEFAULT)));
                        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                        String placa = plateCarClient.getPlateFromImageFile(new File((i) + "-aa.jpg"));
                        
                        if (!placa.equals("")){
                            String placa_com_hifen = placa.substring(0, 3) + "-" +placa.substring(3, 7);
                            List valid = Arrays.asList("1","2","3","4","5","6","7","8","9", "I","i");
                            System.out.println(placa);
                                System.out.println("placa" + placa.substring(2,3));
                                
                                //placa mercosul
                            if ( valid.contains(placa.substring(2,3)) ){
                                placa = placa.replace("I", "1");
                                System.out.println(placa);
                                System.out.println("placa" + placa.substring(2));
                                
                                placa_com_hifen = placa.substring(0, 2) + "-" +placa.substring(2, 5) + "-" + placa.substring(5, 7);
                                System.out.println("placa" + placa_com_hifen);
                            }
                            cptPlaca1.setText(placa_com_hifen);
                            ClienteController objCliente = new ClienteController();
                            Cliente clienteTela = objCliente.getClientePelaPlaca(placa);
                            
                            cptNomeComp.setText(clienteTela.getNome());
                            cptID.setText(String.valueOf(clienteTela.getId()));
                            
                            fotoPlaca1.setIcon(new ImageIcon( (i) + "-aa.jpg"));
                            grabber.stop();
                            th.interrupt();
                        }
                        
//                        if ( i == 1){
//                            cptPlaca1.setText("UUU-0000");
//                            fotoPlaca1.setIcon(new ImageIcon( (i) + "-aa.jpg"));
//                            //th.interrupt();
//                            grabber.stop();
//                        }else if (i == 2){
//                            cptPlaca1.setText("AAA-0000");
//                            fotoPlaca1.setIcon(new ImageIcon( (i) + "-aa.jpg"));
//                        }else{
//                            cptPlaca1.setText("");
//                        }
                        
                        System.out.print("Tentou setar o texto");
                        JOptionPane.showMessageDialog(null, "Leitura realizada");
                    } catch (Exception ex) {
                        //JOptionPane.showConfirmDialog(null, ex.getMessage());
                    } finally {
                        setCursor(Cursor.getDefaultCursor());
                        
                    }
                }

                canvas.showImage(converter.convert(img));

                Thread.sleep(INTERVAL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public TelaCadCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        //WebcamImages gs = new WebcamImages();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCadCli = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cptNomeComp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboxSexo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cptRG = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cptEndereco = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cptEndComp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cptBairro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cptCidade = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cptCep = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cboxUF = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        cptTelefone = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cptEmail = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cboxAtivo = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        cptVeiculo1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        cptPlaca1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        cptChassi1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        fotoPlaca1 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        cptID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cptCpf = new javax.swing.JTextField();
        cptDtNasc = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Car-Code");
        setBackground(new java.awt.Color(0, 204, 153));
        setResizable(false);

        lblCadCli.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCadCli.setText("Cadastro de clientes");

        jLabel1.setText("Nome completo");

        cptNomeComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cptNomeCompActionPerformed(evt);
            }
        });

        jLabel2.setText("Sexo");

        cboxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino", "Não informado" }));

        jLabel3.setText("Data de nascimento");

        jLabel4.setText("RG");

        jLabel5.setText("CPF");

        jLabel6.setText("Endereço");

        jLabel7.setText("Complemento");

        jLabel8.setText("Bairro");

        jLabel9.setText("Cidade");

        jLabel10.setText("Cep");

        jLabel11.setText("UF");

        cboxUF.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PR", "PB", "PA", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SE", "SP", "TO" }));

        jLabel12.setText("Telefone");

        jLabel15.setText("E-Mail");

        jLabel20.setText("Cliente ativo?");

        cboxAtivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não" }));
        cboxAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxAtivoActionPerformed(evt);
            }
        });

        jLabel22.setText("Veículo ");

        jLabel23.setText("Placa ");

        cptPlaca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cptPlaca1ActionPerformed(evt);
            }
        });

        jLabel24.setText("Chassi ");

        jLabel25.setText("Foto da placa do veículo 1");

        fotoPlaca1.setBackground(new java.awt.Color(0, 102, 102));
        fotoPlaca1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 255)));

        btnPesquisar.setText("Pesquisar Placa");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel30.setText("Id");

        jButton1.setText("Ler Placa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lerPlaca(evt);
            }
        });

        cptCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cptCpfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(jLabel25))
                            .addComponent(lblCadCli)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cptRG, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)
                                        .addGap(6, 6, 6)
                                        .addComponent(cptCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cptEndereco))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel30)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cptID, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cptNomeComp, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cptEndComp, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(6, 6, 6)
                                        .addComponent(cptDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel20)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cboxAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(cboxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cptChassi1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cptVeiculo1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cptPlaca1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fotoPlaca1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(164, 164, 164)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cptBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cptCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cptCep, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboxUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cptEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cptTelefone)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCadCli))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(cboxAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cptNomeComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel30)
                    .addComponent(cptID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cboxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cptDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cptRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(cptEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(cptEndComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cptCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cptBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cptCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cptCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(cboxUF, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cptEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel12)
                    .addComponent(cptTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(cptChassi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(cptVeiculo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(cptPlaca1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(btnPesquisar))
                        .addGap(36, 36, 36)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fotoPlaca1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar)
                        .addComponent(btnSalvar)))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked

        this.dispose();

    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void lerPlaca(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lerPlaca
        th = new Thread(this);
        th.start();
    }//GEN-LAST:event_lerPlaca

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Cliente objCliente = new Cliente();
        ClienteController objClienteController = new ClienteController();
        
        if(!cptID.getText().equals("")){
            objCliente.setId(Integer.parseInt(cptID.getText()));
        }
        
        objCliente.setAtivo(cboxAtivo.getSelectedItem().toString());
        objCliente.setNome(cptNomeComp.getText().toUpperCase());
        objCliente.setPlaca(cptPlaca1.getText().toUpperCase());
        objCliente.setData_nascimento(cptDtNasc.getText().toString());
        objCliente.setSexo(cboxSexo.getSelectedItem().toString());
        objCliente.setRg(Integer.parseInt(cptRG.getText().toString()));
        objCliente.setCep((cptCep.getText().toString()));
        objCliente.setCpf(cptCpf.getText().toString());
        objCliente.setEndereco(cptEndereco.getText().toString());
        objCliente.setComplemento(cptEndComp.getText().toString());
        objCliente.setBairro(cptBairro.getText().toString());
        objCliente.setCidade(cptCidade.getText().toString());
        objCliente.setUf(cboxUF.getSelectedItem().toString());
        objCliente.setEmail(cptEmail.getText().toString());
        objCliente.setTelefone(cptTelefone.getText().toString());
        objCliente.setChassi(cptChassi1.getText().toString());
        objCliente.setVeiculo(cptVeiculo1.getText().toString());
       
        
        try {
            objClienteController.salvar(objCliente);
        } catch (Exception ex) {
            Logger.getLogger(TelaCadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } 
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        Cliente objCliente = new Cliente();
        ClienteController objClienteController = new ClienteController();
        
        objCliente.setPlaca(cptPlaca1.getText().toUpperCase());
        
        try {
            objCliente = objClienteController.getClientePelaPlaca(objCliente.getPlaca());
            
            if (objCliente == null){
                JOptionPane.showMessageDialog(null, "Cliente não cadastrado!");
            }else{
                cptID.setText(String.valueOf(objCliente.getId()));
                cptNomeComp.setText(objCliente.getNome());
                cptPlaca1.setText(objCliente.getPlaca());
                cptDtNasc.setText(objCliente.getData_nascimento());
                
                cboxAtivo.setSelectedItem(objCliente.getAtivo());
                
                cptRG.setText(String.valueOf(objCliente.getRg()));
                cptCpf.setText(String.valueOf(objCliente.getCpf()));
                cptEndereco.setText(objCliente.getEndereco());
                cptEndComp.setText(objCliente.getComplemento());
                cptBairro.setText(objCliente.getBairro());
                cptCidade.setText(objCliente.getCidade());
                cptCep.setText(String.valueOf(objCliente.getCep()));
                cboxUF.setSelectedItem(objCliente.getUf());
                
                cptEmail.setText(objCliente.getEmail());
                cptTelefone.setText(objCliente.getTelefone());
                cptChassi1.setText(objCliente.getChassi());
                cptVeiculo1.setText(objCliente.getVeiculo());
                
                
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaCadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void cboxAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxAtivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxAtivoActionPerformed

    private void cptCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cptCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cptCpfActionPerformed

    private void cptNomeCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cptNomeCompActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cptNomeCompActionPerformed

    private void cptPlaca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cptPlaca1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cptPlaca1ActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(TelaCadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @SuppressWarnings("override")
            public void run() {
                new TelaCadCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cboxAtivo;
    private javax.swing.JComboBox cboxSexo;
    private javax.swing.JComboBox cboxUF;
    private javax.swing.JTextField cptBairro;
    private javax.swing.JTextField cptCep;
    private javax.swing.JTextField cptChassi1;
    private javax.swing.JTextField cptCidade;
    private javax.swing.JTextField cptCpf;
    private javax.swing.JTextField cptDtNasc;
    private javax.swing.JTextField cptEmail;
    private javax.swing.JTextField cptEndComp;
    private javax.swing.JTextField cptEndereco;
    private javax.swing.JTextField cptID;
    private javax.swing.JTextField cptNomeComp;
    private javax.swing.JTextField cptPlaca1;
    private javax.swing.JTextField cptRG;
    private javax.swing.JTextField cptTelefone;
    private javax.swing.JTextField cptVeiculo1;
    private javax.swing.JLabel fotoPlaca1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblCadCli;
    // End of variables declaration//GEN-END:variables
}
