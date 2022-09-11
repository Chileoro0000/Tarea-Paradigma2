package pm.tarea;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import DTO.DatosUsuario;
import java.awt.List;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;
import java.util.Vector;
import javax.swing.JOptionPane;


public class Monitoreo extends javax.swing.JFrame {
    //VARIBALES PROPIAS DEL MONITOR
    public String a = "S";
    public String hash;
    public int time;
    public String unidadT = "°C";
    private ArrayList<Float> listaT;
    private ArrayList<Float> listaH;
    private ArrayList<Float> listaC;

    public Monitoreo(String hash){
        this.hash = hash;
        initComponents(); 
        this.setLocationRelativeTo(null);
        this.listaT = new ArrayList<Float>();
        this.listaC = new ArrayList<Float>();
        this.listaH = new ArrayList<Float>();
    }

    private Monitoreo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public float calcularMinimo(ArrayList<Float> lista){ //Cacular los minimos de una lista
        float min = lista.get(0);
        int n = lista.size();
        for (int i = 1; i < n; i++) {
            if (lista.get(i) < min) {
                min = lista.get(i);
            }
        }  
        return min;
    }
    
    public float calcularMaximo(ArrayList<Float> lista){ //Cacular los maximos de una lista
        float max = lista.get(0);
        int n = lista.size();
        for (int i = 1; i < n; i++) {
            if (lista.get(i) > max) {
                max = lista.get(i);
            }
        }
        return max;
    }
    
    public float calcularMedia(ArrayList<Float> lista){ //Cacular la media de una lista
        float media = 0;
        int n = lista.size();
        for (int i = 0; i < n; i++) {
            media = media + lista.get(i);
        }
        return media/n;
    }

    public void actualizar(DatosUsuario datos){ //Funcion que actualiza los datos 
        listaT.add(Float.parseFloat(datos.temperatura));
        listaH.add(Float.parseFloat(datos.humedad));
        listaC.add(Float.parseFloat(datos.co2));
        this.ValorMinimoHumedad.setText(calcularMinimo(listaH) + "%");
        this.ValorMinimaCo2.setText(Math.rint(calcularMinimo(listaC))+ "ppm");
        this.ValorMinimaTemperatura.setText(calcularMinimo(listaT) + unidadT);
        
        this.MaximaHumedad.setText(calcularMaximo(listaH) + "%");
        this.MaximaPresion.setText((Math.rint(calcularMaximo(listaC))) + "ppm");
        
        if (unidadT.equals("°F")){
            this.RecienteTemperatura.setText(((Math.round(Float.parseFloat(datos.temperatura))*1.8)+32) + unidadT);
            this.MediaTemperatura.setText((calcularMedia(listaT)*1.8)+32 + unidadT);
            this.MaximaTemperatura.setText((calcularMaximo(listaT)*1.8)+32 + unidadT);
            this.ValorMinimaTemperatura.setText((calcularMinimo(listaT)*1.8)+32 + unidadT);
        }
        if(unidadT.equals("°C")){
            this.RecienteTemperatura.setText(Math.round(Float.parseFloat(datos.temperatura)) + unidadT);
            this.MaximaTemperatura.setText(calcularMaximo(listaT) + unidadT);
            this.MediaTemperatura.setText(calcularMedia(listaT) + unidadT);
            this.ValorMinimaTemperatura.setText(calcularMinimo(listaT) + unidadT);
        }
 
        this.MediaHumedad.setText(calcularMedia(listaH) + "%");
        this.MediaPresion.setText(Math.rint(calcularMedia(listaC)) + "ppm");

        this.RecienteHumedad.setText(Math.round(Float.parseFloat(datos.humedad))+ "%");
        this.RecientePresion.setText(Math.round(Integer.parseInt(datos.co2))+ "ppm");
        
        this.ValorSegundosActuales.setText( time+1 + "");
    }
    
    public void GenerarInformacion(int tiempo, String hash) throws InterruptedException, IOException{
        ResponseMonitoreo responseM = new ResponseMonitoreo();
        Timer timer = new Timer();  //Mantener control del tiempo de actualizaciones.
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                try {
                    if(a.equals("D")){
                        BotonIniciar.setEnabled(true);
                        timer.cancel(); //para deneter si es que se preciona el boton
                    }
                    DatosUsuario datos = responseM.GET(hash);
                    actualizar(datos);
                    time = time + 1;              
                } catch (IOException | InterruptedException ex) {
                    Logger.getLogger(Monitoreo.class.getName()).log(Level.SEVERE, null, ex);
                }   
            };
        };
        timer.schedule(tarea, 0, (tiempo*1000));
    }
    
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        Fondo = new javax.swing.JPanel();
        PanelDer = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        CerrarSesionBoton = new javax.swing.JButton();
        TextRecientes = new javax.swing.JLabel();
        RecienteTemperatura = new javax.swing.JLabel();
        RecienteHumedad = new javax.swing.JLabel();
        RecientePresion = new javax.swing.JLabel();
        HumedadText = new javax.swing.JLabel();
        TemperaturaText = new javax.swing.JLabel();
        PresionText = new javax.swing.JLabel();
        PanelSep = new javax.swing.JPanel();
        TextHumedad = new javax.swing.JLabel();
        ValorMinimoHumedad = new javax.swing.JLabel();
        ValorMinimaTemperatura = new javax.swing.JLabel();
        ValorMinimaCo2 = new javax.swing.JLabel();
        TextCo2 = new javax.swing.JLabel();
        TextTemperatura = new javax.swing.JLabel();
        TextMinima = new javax.swing.JLabel();
        TextSegundos = new javax.swing.JLabel();
        ValorSegundos = new javax.swing.JTextField();
        TextMaxima = new javax.swing.JLabel();
        TextMedia = new javax.swing.JLabel();
        BotonIniciar = new javax.swing.JButton();
        ValorSegundosNoValidos = new javax.swing.JLabel();
        ValorSegundosActuales = new javax.swing.JLabel();
        BotonFaren = new javax.swing.JRadioButton();
        MediaHumedad = new javax.swing.JLabel();
        MediaTemperatura = new javax.swing.JLabel();
        MediaPresion = new javax.swing.JLabel();
        MaximaHumedad = new javax.swing.JLabel();
        MaximaTemperatura = new javax.swing.JLabel();
        MaximaPresion = new javax.swing.JLabel();
        RadioButonCelcius = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        BotonDetener = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Monitoreo");
        setMinimumSize(new java.awt.Dimension(762, 420));
        setResizable(false);

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setForeground(new java.awt.Color(0, 0, 0));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelDer.setBackground(new java.awt.Color(255, 255, 204));

        logo.setFont(new java.awt.Font("OCR A Extended", 2, 14)); // NOI18N
        logo.setForeground(new java.awt.Color(0, 0, 0));
        logo.setText("SensorMAX");

        CerrarSesionBoton.setFont(new java.awt.Font("Agency FB", 3, 12)); // NOI18N
        CerrarSesionBoton.setForeground(new java.awt.Color(0, 0, 0));
        CerrarSesionBoton.setText("Cerrar sesión");
        CerrarSesionBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CerrarSesionBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionBotonActionPerformed(evt);
            }
        });

        TextRecientes.setFont(new java.awt.Font("Agency FB", 3, 18)); // NOI18N
        TextRecientes.setForeground(new java.awt.Color(0, 0, 0));
        TextRecientes.setText("Recientes");

        RecienteTemperatura.setFont(new java.awt.Font("Agency FB", 3, 14)); // NOI18N
        RecienteTemperatura.setForeground(new java.awt.Color(0, 0, 0));

        RecienteHumedad.setFont(new java.awt.Font("Agency FB", 3, 14)); // NOI18N
        RecienteHumedad.setForeground(new java.awt.Color(0, 0, 0));

        RecientePresion.setFont(new java.awt.Font("Agency FB", 3, 14)); // NOI18N
        RecientePresion.setForeground(new java.awt.Color(0, 0, 0));

        HumedadText.setFont(new java.awt.Font("Agency FB", 2, 14)); // NOI18N
        HumedadText.setForeground(new java.awt.Color(0, 0, 0));
        HumedadText.setText("Humedad");

        TemperaturaText.setFont(new java.awt.Font("Agency FB", 2, 14)); // NOI18N
        TemperaturaText.setForeground(new java.awt.Color(0, 0, 0));
        TemperaturaText.setText("Temperatura");

        PresionText.setFont(new java.awt.Font("Agency FB", 2, 14)); // NOI18N
        PresionText.setForeground(new java.awt.Color(0, 0, 0));
        PresionText.setText("Presion");

        javax.swing.GroupLayout PanelDerLayout = new javax.swing.GroupLayout(PanelDer);
        PanelDer.setLayout(PanelDerLayout);
        PanelDerLayout.setHorizontalGroup(
            PanelDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDerLayout.createSequentialGroup()
                .addGroup(PanelDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelDerLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(CerrarSesionBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelDerLayout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(PanelDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TemperaturaText, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PanelDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TextRecientes, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PanelDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(RecienteHumedad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(HumedadText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(PanelDerLayout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addGroup(PanelDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(PresionText, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(RecienteTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(RecientePresion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelDerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        PanelDerLayout.setVerticalGroup(
            PanelDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDerLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(TextRecientes)
                .addGap(23, 23, 23)
                .addComponent(HumedadText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RecienteHumedad, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TemperaturaText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RecienteTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PresionText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RecientePresion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CerrarSesionBoton)
                .addContainerGap())
        );

        Fondo.add(PanelDer, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, -1, 420));

        javax.swing.GroupLayout PanelSepLayout = new javax.swing.GroupLayout(PanelSep);
        PanelSep.setLayout(PanelSepLayout);
        PanelSepLayout.setHorizontalGroup(
            PanelSepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        PanelSepLayout.setVerticalGroup(
            PanelSepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        Fondo.add(PanelSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 0, 10, 420));

        TextHumedad.setFont(new java.awt.Font("Agency FB", 3, 24)); // NOI18N
        TextHumedad.setForeground(new java.awt.Color(0, 0, 0));
        TextHumedad.setText("Humedad");
        Fondo.add(TextHumedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 190, 30));

        ValorMinimoHumedad.setFont(new java.awt.Font("Agency FB", 3, 18)); // NOI18N
        ValorMinimoHumedad.setForeground(new java.awt.Color(0, 0, 0));
        Fondo.add(ValorMinimoHumedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 210, 20));

        ValorMinimaTemperatura.setFont(new java.awt.Font("Agency FB", 3, 18)); // NOI18N
        ValorMinimaTemperatura.setForeground(new java.awt.Color(0, 0, 0));
        Fondo.add(ValorMinimaTemperatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 160, 20));

        ValorMinimaCo2.setFont(new java.awt.Font("Agency FB", 3, 18)); // NOI18N
        ValorMinimaCo2.setForeground(new java.awt.Color(0, 0, 0));
        Fondo.add(ValorMinimaCo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 230, 20));

        TextCo2.setBackground(new java.awt.Color(0, 0, 0));
        TextCo2.setFont(new java.awt.Font("Agency FB", 3, 24)); // NOI18N
        TextCo2.setForeground(new java.awt.Color(0, 0, 0));
        TextCo2.setText("CO2");
        Fondo.add(TextCo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 100, 40));

        TextTemperatura.setBackground(new java.awt.Color(0, 0, 0));
        TextTemperatura.setFont(new java.awt.Font("Agency FB", 3, 24)); // NOI18N
        TextTemperatura.setForeground(new java.awt.Color(0, 0, 0));
        TextTemperatura.setText("Temperatura");
        Fondo.add(TextTemperatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 120, -1));

        TextMinima.setFont(new java.awt.Font("Agency FB", 3, 14)); // NOI18N
        TextMinima.setForeground(new java.awt.Color(51, 51, 51));
        TextMinima.setText("MINIMA");
        Fondo.add(TextMinima, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 50, 20));

        TextSegundos.setFont(new java.awt.Font("Agency FB", 3, 36)); // NOI18N
        TextSegundos.setForeground(new java.awt.Color(51, 51, 51));
        TextSegundos.setText("Seleccione los segundos  ->");
        Fondo.add(TextSegundos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 40));

        ValorSegundos.setText("3");
        ValorSegundos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValorSegundosActionPerformed(evt);
            }
        });
        ValorSegundos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ValorSegundosKeyTyped(evt);
            }
        });
        Fondo.add(ValorSegundos, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 70, -1));

        TextMaxima.setFont(new java.awt.Font("Agency FB", 3, 14)); // NOI18N
        TextMaxima.setForeground(new java.awt.Color(51, 51, 51));
        TextMaxima.setText("MAXIMA");
        Fondo.add(TextMaxima, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 40, 20));

        TextMedia.setFont(new java.awt.Font("Agency FB", 3, 14)); // NOI18N
        TextMedia.setForeground(new java.awt.Color(51, 51, 51));
        TextMedia.setText("MEDIA");
        Fondo.add(TextMedia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 40, -1));

        BotonIniciar.setFont(new java.awt.Font("Agency FB", 3, 14)); // NOI18N
        BotonIniciar.setForeground(new java.awt.Color(0, 0, 0));
        BotonIniciar.setText("INICIAR");
        BotonIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIniciarActionPerformed(evt);
            }
        });
        Fondo.add(BotonIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        ValorSegundosNoValidos.setFont(new java.awt.Font("Agency FB", 3, 14)); // NOI18N
        ValorSegundosNoValidos.setForeground(new java.awt.Color(255, 51, 51));
        Fondo.add(ValorSegundosNoValidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 290, -1));

        ValorSegundosActuales.setFont(new java.awt.Font("Agency FB", 3, 14)); // NOI18N
        ValorSegundosActuales.setForeground(new java.awt.Color(0, 0, 0));
        Fondo.add(ValorSegundosActuales, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, 30, 20));

        BotonFaren.setBackground(new java.awt.Color(255, 255, 255));
        BotonFaren.setFont(new java.awt.Font("Agency FB", 3, 14)); // NOI18N
        BotonFaren.setForeground(new java.awt.Color(0, 0, 0));
        BotonFaren.setText("Farenheitt");
        BotonFaren.setBorder(null);
        BotonFaren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonFarenActionPerformed(evt);
            }
        });
        Fondo.add(BotonFaren, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 91, 100, -1));

        MediaHumedad.setFont(new java.awt.Font("Agency FB", 3, 18)); // NOI18N
        MediaHumedad.setForeground(new java.awt.Color(0, 0, 0));
        Fondo.add(MediaHumedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 160, 20));

        MediaTemperatura.setFont(new java.awt.Font("Agency FB", 3, 18)); // NOI18N
        MediaTemperatura.setForeground(new java.awt.Color(0, 0, 0));
        Fondo.add(MediaTemperatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 160, 20));

        MediaPresion.setFont(new java.awt.Font("Agency FB", 3, 18)); // NOI18N
        MediaPresion.setForeground(new java.awt.Color(0, 0, 0));
        Fondo.add(MediaPresion, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 150, 20));

        MaximaHumedad.setFont(new java.awt.Font("Agency FB", 3, 18)); // NOI18N
        MaximaHumedad.setForeground(new java.awt.Color(0, 0, 0));
        Fondo.add(MaximaHumedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 130, 20));

        MaximaTemperatura.setFont(new java.awt.Font("Agency FB", 3, 18)); // NOI18N
        MaximaTemperatura.setForeground(new java.awt.Color(0, 0, 0));
        Fondo.add(MaximaTemperatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 150, 20));

        MaximaPresion.setFont(new java.awt.Font("Agency FB", 3, 18)); // NOI18N
        MaximaPresion.setForeground(new java.awt.Color(0, 0, 0));
        Fondo.add(MaximaPresion, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 140, 20));

        RadioButonCelcius.setBackground(new java.awt.Color(255, 255, 255));
        RadioButonCelcius.setFont(new java.awt.Font("Agency FB", 3, 14)); // NOI18N
        RadioButonCelcius.setForeground(new java.awt.Color(0, 0, 0));
        RadioButonCelcius.setText("Celcius");
        RadioButonCelcius.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButonCelciusActionPerformed(evt);
            }
        });
        Fondo.add(RadioButonCelcius, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 70, 20));

        jLabel1.setFont(new java.awt.Font("Agency FB", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Total de actualizaciones:");
        Fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 130, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        Fondo.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 650, 10));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        Fondo.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 273, 650, 10));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        Fondo.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 650, 10));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Fondo.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 113, 650, 10));

        BotonDetener.setFont(new java.awt.Font("Agency FB", 3, 14)); // NOI18N
        BotonDetener.setForeground(new java.awt.Color(0, 0, 0));
        BotonDetener.setText("Detener");
        BotonDetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonDetenerActionPerformed(evt);
            }
        });
        Fondo.add(BotonDetener, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, 90, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIniciarActionPerformed
        BotonIniciar.setEnabled(false);
        this.ValorSegundosNoValidos.setText("");
        time = 0; //Reseteo valores para empezar de nuevo
        a = "S"; //Seguir 
        this.listaH.clear();
        this.listaC.clear();
        this.listaT.clear();
        if(Integer.parseInt(this.ValorSegundos.getText()) <= 120 && Integer.parseInt(this.ValorSegundos.getText()) >= 3){            
            try {
                
                GenerarInformacion(Integer.parseInt(this.ValorSegundos.getText()), this.hash); //Funcion para que monitor se arme.
            
            } catch (InterruptedException ex) {
                Logger.getLogger(Monitoreo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Monitoreo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            this.ValorSegundosNoValidos.setText("Valor no valido!, ingrese un valor entre (3 - 120).");
            BotonIniciar.setEnabled(true);
        }
    }//GEN-LAST:event_BotonIniciarActionPerformed

    private void ValorSegundosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValorSegundosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ValorSegundosActionPerformed

    private void ValorSegundosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValorSegundosKeyTyped
        char m = evt.getKeyChar();//permite obtener solo numeros
        if(!Character.isDigit(m)){//en caso de ser letras la casilla no permite escribir
            evt.consume();//elimina los datos no deseados
        }
    }//GEN-LAST:event_ValorSegundosKeyTyped

    private void BotonFarenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonFarenActionPerformed
        unidadT = "°F";
    }//GEN-LAST:event_BotonFarenActionPerformed

    private void CerrarSesionBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionBotonActionPerformed
        Login login = new Login();
        login.setVisible(true);
        JOptionPane.showMessageDialog(null, "Sesion cerrada correctamente.");
        this.setVisible(false);
    }//GEN-LAST:event_CerrarSesionBotonActionPerformed

    private void RadioButonCelciusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButonCelciusActionPerformed
        unidadT = "°C";
    }//GEN-LAST:event_RadioButonCelciusActionPerformed

    private void BotonDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonDetenerActionPerformed
        a = "D";
    }//GEN-LAST:event_BotonDetenerActionPerformed

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
            java.util.logging.Logger.getLogger(Monitoreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Monitoreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Monitoreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Monitoreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Monitoreo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonDetener;
    private javax.swing.JRadioButton BotonFaren;
    private javax.swing.JButton BotonIniciar;
    private javax.swing.JButton CerrarSesionBoton;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel HumedadText;
    private javax.swing.JLabel MaximaHumedad;
    private javax.swing.JLabel MaximaPresion;
    private javax.swing.JLabel MaximaTemperatura;
    private javax.swing.JLabel MediaHumedad;
    private javax.swing.JLabel MediaPresion;
    private javax.swing.JLabel MediaTemperatura;
    private javax.swing.JPanel PanelDer;
    private javax.swing.JPanel PanelSep;
    private javax.swing.JLabel PresionText;
    private javax.swing.JRadioButton RadioButonCelcius;
    private javax.swing.JLabel RecienteHumedad;
    private javax.swing.JLabel RecientePresion;
    private javax.swing.JLabel RecienteTemperatura;
    private javax.swing.JLabel TemperaturaText;
    private javax.swing.JLabel TextCo2;
    private javax.swing.JLabel TextHumedad;
    private javax.swing.JLabel TextMaxima;
    private javax.swing.JLabel TextMedia;
    private javax.swing.JLabel TextMinima;
    private javax.swing.JLabel TextRecientes;
    private javax.swing.JLabel TextSegundos;
    private javax.swing.JLabel TextTemperatura;
    private javax.swing.JLabel ValorMinimaCo2;
    private javax.swing.JLabel ValorMinimaTemperatura;
    private javax.swing.JLabel ValorMinimoHumedad;
    private javax.swing.JTextField ValorSegundos;
    private javax.swing.JLabel ValorSegundosActuales;
    private javax.swing.JLabel ValorSegundosNoValidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
