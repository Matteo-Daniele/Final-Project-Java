import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.TreeSet;
import java.util.ArrayList;

public class PaginaPlaylist extends JFrame implements ActionListener {
    private Playlist playlist;
    private JPanel cancionesPanel;
    private Playlist meGustasPlaylist;
    private ImageIcon heartIcon;
    private ImageIcon filledHeartIcon;
    private CollectionsPlaylist playlists;
    private CollectionUsuarios usuarios;

    File f = new File("zCanciones.json");
    File f3 = new File("zplaylists.json");
    File f2 = new File("Usuarios.json");
 
        public PaginaPlaylist(Playlist playlist, Playlist meGustasPlaylist, CollectionsPlaylist playlists) {
        this.playlist = playlist;
        this.meGustasPlaylist = meGustasPlaylist;
        this.playlists = playlists;

        setTitle(playlist.getNombre());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Permitir cerrar esta ventana sin cerrar la aplicación
        setLayout(new BorderLayout());

        cancionesPanel = new JPanel(new GridLayout(0, 1)); // Layout para las canciones

        // Ajustar el tamaño de los iconos
        heartIcon = cargarIcono("Media/heart-icon.png", 20, 20);
        filledHeartIcon = cargarIcono("Media/filled-heart-icon.png", 20, 20);

        for (Cancion cancion : playlist.getCancionesPlaylist()) {
            JPanel cancionPanel = new JPanel(new BorderLayout());
            JButton cancionButton = new JButton(cancion.getNombre());
            cancionButton.addActionListener(this);
            cancionPanel.add(cancionButton, BorderLayout.CENTER);

            JButton likeButton = new JButton(meGustasPlaylist.getCancionesPlaylist().contains(cancion) ? filledHeartIcon : heartIcon);
            likeButton.setActionCommand(cancion.getNombre());
            likeButton.addActionListener(e -> {
                if (meGustasPlaylist.getCancionesPlaylist().contains(cancion)) {
                    usuarios.leerArchivo(f2);
                    meGustasPlaylist.eliminarCancion(cancion);
                    likeButton.setIcon(heartIcon);
                    ArrayList<Usuario>usuariosaux = new ArrayList<>();

                    for(Usuario auxi : usuarios.getUsuarios().values()){
                        usuariosaux.add(auxi);
                    }
                    
                    usuarios.reescribirArchivoLinea(f2, usuariosaux);
                } else {
                    meGustasPlaylist.agregarCancion(cancion);
                    likeButton.setIcon(filledHeartIcon);
                }
            });
            cancionPanel.add(likeButton, BorderLayout.EAST);

            cancionesPanel.add(cancionPanel);
        }

        add(new JScrollPane(cancionesPanel), BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private ImageIcon cargarIcono(String ruta, int width, int height) {
        ImageIcon icono = new ImageIcon(ruta);
        if (icono.getImageLoadStatus() == MediaTracker.COMPLETE) {
            Image imagen = icono.getImage();
            Image imagenEscalada = imagen.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(imagenEscalada);
        } else {
            System.out.println("Error al cargar la imagen: " + ruta);
            return null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String cancionName = clickedButton.getText();

        for (Cancion cancion : playlist.getCancionesPlaylist()) {
            if (cancion.getNombre().equals(cancionName)) {
                TreeSet<Cancion> canciones = new TreeSet<>();
                canciones.add(cancion);
                new ReproductorMusica(new ArrayList<>(canciones), playlists); // Reproducir la canción seleccionada
                break;
            }
        }
    }
}