import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class PaginaPrincipal extends JFrame implements ActionListener {
    private CollectionsPlaylist playlists;
    private JPanel playlistsPanel;
    private Playlist meGustasPlaylist;

    public PaginaPrincipal(CollectionsPlaylist playlists, Usuario activo) {
        this.playlists = playlists;

        // Encontrar o crear la playlist "ME GUSTAS"
        meGustasPlaylist = playlists.getPlaylists().values().stream()
                .filter(p -> "Tus me Gusta".equals(p.getNombre()))
                .findFirst()
                .orElseGet(() -> {
                    Playlist newPlaylist = new Playlist("Tus me Gusta", "Media/ACRU.jpg");
                    playlists.agregarPlaylist(newPlaylist);
                    return newPlaylist;
                });

        setTitle("Spotifake");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Configurar el ícono de la ventana y la barra de tareas
        ImageIcon icono = new ImageIcon("Media/Spotifake.png"); // Ruta del ícono
        setIconImage(icono.getImage()); // Establecer el ícono de la ventana

        setLayout(new BorderLayout());

        // Crear el panel de las playlists
        playlistsPanel = new JPanel(new GridLayout(3, 5, 10, 10)); // 3 filas, 5 columnas, espacio de 10 píxeles entre componentes
        playlistsPanel.setBackground(Color.BLACK); // Fondo negro

        for (Playlist playlist : playlists.getPlaylists().values()) {
            // Panel para contener el botón de la playlist y la portada
            JPanel playlistPanel = new JPanel(new BorderLayout());
            playlistPanel.setBackground(Color.BLACK); // Fondo negro

            // Botón de la playlist
            JButton playlistButton = new JButton(playlist.getNombre());
            playlistButton.setBackground(Color.BLACK); // Fondo negro del botón
            playlistButton.setForeground(Color.GREEN); // Texto del botón verde
            playlistButton.setBorder(BorderFactory.createLineBorder(Color.GREEN)); // Borde verde
            playlistButton.addActionListener(this);
            playlistButton.setActionCommand(playlist.getNombre());
            playlistPanel.add(playlistButton, BorderLayout.NORTH);

            // Etiqueta para mostrar la portada
            JLabel portadaLabel = new JLabel();
            ImageIcon portadaIcon = ajustarIcono(playlist.getPortada(), 150, 150); // Ajustar tamaño de imagen
            portadaLabel.setIcon(portadaIcon);
            portadaLabel.setHorizontalAlignment(JLabel.CENTER);
            portadaLabel.setVerticalAlignment(JLabel.CENTER);
            portadaLabel.setBackground(Color.BLACK); // Fondo negro
            portadaLabel.setOpaque(true); // Hacer el fondo de la etiqueta visible
            playlistPanel.add(portadaLabel, BorderLayout.CENTER);

            // Agregar el panel de la playlist al panel principal
            playlistsPanel.add(playlistPanel);
        }

        JScrollPane scrollPane = new JScrollPane(playlistsPanel);
        scrollPane.getViewport().setBackground(Color.BLACK); // Fondo negro del scroll pane
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.YELLOW)); // Borde amarillo del scroll pane
        add(scrollPane, BorderLayout.CENTER);

        // Añadir un listener para ajustar el layout al cambiar el tamaño de la ventana
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                ajustarLayout();
            }
        });

        // Establecer la ventana en modo de pantalla completa
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true);
    }

    private void ajustarLayout() {
        playlistsPanel.setLayout(new GridLayout(3, 5, 10, 10)); // Ajustar a 3 filas y 5 columnas, espacio de 10 píxeles entre componentes
        playlistsPanel.revalidate();
        playlistsPanel.repaint();
    }

    private ImageIcon ajustarIcono(String ruta, int width, int height) {
        ImageIcon icono = new ImageIcon(ruta);
        Image imagen = icono.getImage();
        Image imagenEscalada = imagen.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenEscalada);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String playlistName = e.getActionCommand();

        Playlist selectedPlaylist = playlists.getPlaylists().get(playlistName);
        if (selectedPlaylist != null) {
            new PaginaPlaylist(selectedPlaylist, meGustasPlaylist, playlists);
        }
    }
}
