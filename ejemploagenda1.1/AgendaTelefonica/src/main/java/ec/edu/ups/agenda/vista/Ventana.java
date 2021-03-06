package ec.edu.ups.agenda.vista;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.KeyboardFocusManager;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ec.edu.ups.agenda.modelo.PersonaEN;
import ec.edu.ups.agenda.modelo.TelefonoEN;
import ec.edu.ups.agenda.negocio.ContactosON;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.LineNumberInputStream;

import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Ventana extends JFrame {

	private JPanel contentPane;
	public JTextField txtNombre;
	public JTextField txtApellido;
	public JButton btnGuardar;
	public JTextField txtCedula;
	public JTextField txtNumeroTelefonico;
	public JTable table;
	public JTextField txtFiltrar;
	public List<String> recibirArreglo = new ArrayList<String>();
	private JButton btnActualizar;
	private JButton btnEliminar;
	public JComboBox comboCodigoOperadora;
	public JComboBox comboTipoTelefono;
	private JButton btnLimpiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	/*public Ventana() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNombre = new JTextField();
		txtNombre.setBounds(76, 56, 116, 22);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(76, 91, 116, 22);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 59, 56, 16);
		contentPane.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(12, 94, 56, 16);
		contentPane.add(lblApellido);

		

		JLabel lblAgendaDeContactos = new JLabel("Agenda de Contactos");
		lblAgendaDeContactos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAgendaDeContactos.setBounds(12, 13, 180, 16);
		contentPane.add(lblAgendaDeContactos);

		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(12, 129, 56, 16);
		contentPane.add(lblCdula);

		txtCedula = new JTextField();
		txtCedula.addKeyListener(new KeyAdapter() {

		});

		txtCedula.setBounds(76, 126, 116, 22);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);

		JLabel lblCdigoDelN = new JLabel("C\u00F3digo Operadora:");
		lblCdigoDelN.setBounds(302, 59, 116, 16);
		contentPane.add(lblCdigoDelN);

		JLabel lblNmeroTelefnico = new JLabel("N\u00FAmero telef\u00F3nico:");
		lblNmeroTelefnico.setBounds(302, 94, 116, 16);
		contentPane.add(lblNmeroTelefnico);

		JLabel lblTipoDeTelefono = new JLabel("Tipo de telefono:");
		lblTipoDeTelefono.setBounds(302, 129, 116, 16);
		contentPane.add(lblTipoDeTelefono);

		txtNumeroTelefonico = new JTextField();
		txtNumeroTelefonico.setBounds(424, 91, 116, 22);
		contentPane.add(txtNumeroTelefonico);
		txtNumeroTelefonico.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 213, 528, 135);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int filaSeleccionada = table.getSelectedRow();
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				txtCedula.setText(table.getValueAt(filaSeleccionada, 0) + "");
				txtApellido.setText(table.getValueAt(filaSeleccionada, 2) + "");
				txtNombre.setText(table.getValueAt(filaSeleccionada, 1) + "");
				txtNumeroTelefonico.setText(table.getValueAt(filaSeleccionada, 3) + "");
				comboCodigoOperadora.setSelectedItem((table.getValueAt(filaSeleccionada, 5) + ""));
				comboTipoTelefono.setSelectedItem((table.getValueAt(filaSeleccionada, 4) + ""));

			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "C\u00E9dula", "Nombre", "Apellido", "N\u00FAmero", "Tipo", "CódigoOperadora" }));
		scrollPane.setViewportView(table);

		JLabel lblBuscarPorCdula = new JLabel("Buscar por c\u00E9dula:");
		lblBuscarPorCdula.setBounds(558, 213, 116, 16);
		contentPane.add(lblBuscarPorCdula);

		txtFiltrar = new JTextField();
		txtFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ContactosON contactosOn = new ContactosON();
				contactosOn.limpiarCampos(table, txtNombre, txtApellido, txtCedula, txtNumeroTelefonico);
				try {
					recibirArreglo = contactosOn.listarContactosPorCedula(txtFiltrar.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error al cargar ocurrido por: " + e1.getMessage());
					e1.printStackTrace();
				}

				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				Object[] fila = new Object[6];

				int cont = 0;
				for (int j = 0; j < recibirArreglo.size(); j++) {
					fila[cont] = recibirArreglo.get(j);
					cont++;
					if (cont % 6 == 0) {
						cont = 0;
						modelo.addRow(fila);

					}

				}

				table.setModel(modelo);

			}
		});
		txtFiltrar.setBounds(558, 242, 116, 22);
		contentPane.add(txtFiltrar);
		txtFiltrar.setColumns(10);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ContactosON contactosOn = new ContactosON();

				PersonaEN p = new PersonaEN();
				p.setNombre(txtNombre.getText());
				p.setApellido(txtApellido.getText());

				TelefonoEN t = new TelefonoEN();
				t.setCodigo(comboCodigoOperadora.getSelectedItem() + "");
				t.setNumero(txtNumeroTelefonico.getText());
				t.setTipo(comboTipoTelefono.getSelectedItem() + "");

				try {
					contactosOn.actualizarPersona(p, t, "\'".concat(txtCedula.getText()).concat("\'"));
				} catch (Exception e1) {
					
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				contactosOn.limpiarCampos(table, txtNombre, txtApellido, txtCedula, txtNumeroTelefonico);
				listarContactosTabla();
			}
		});
		btnActualizar.setBounds(577, 55, 97, 25);
		contentPane.add(btnActualizar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ContactosON contactosOn = new ContactosON();
				try {
					contactosOn.eliminarContacto("\'".concat(txtCedula.getText()).concat("\'"));
				} catch (Exception e1) {
					
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				contactosOn.limpiarCampos(table, txtNombre, txtApellido, txtCedula, txtNumeroTelefonico);
				listarContactosTabla();
			}
		});
		btnEliminar.setBounds(577, 125, 97, 25);
		contentPane.add(btnEliminar);

		comboCodigoOperadora = new JComboBox();
		comboCodigoOperadora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == comboCodigoOperadora) {
					System.out.println("Se selecciono: " + comboCodigoOperadora.getSelectedItem());
				}

			}
		});
		comboCodigoOperadora.setModel(new DefaultComboBoxModel(new String[] { "+(593)", "+(072)" }));
		comboCodigoOperadora.setBounds(424, 56, 115, 22);
		contentPane.add(comboCodigoOperadora);

		comboTipoTelefono = new JComboBox();
		comboTipoTelefono.setModel(new DefaultComboBoxModel(new String[] { "M\u00F3vil", "Fijo" }));
		comboTipoTelefono.setBounds(424, 126, 116, 22);
		contentPane.add(comboTipoTelefono);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContactosON contactosOn = new ContactosON();
				contactosOn.limpiarCampos(table, txtNombre, txtApellido, txtCedula, txtNumeroTelefonico);
				listarContactosTabla();
			}
		});
		btnLimpiar.setBounds(577, 323, 97, 25);
		contentPane.add(btnLimpiar);
		listarContactosTabla();
	}

	public void listarContactosTabla() {
		// TODO Auto-generated method stub
		ContactosON contactosOn = new ContactosON();
		try {
			recibirArreglo = contactosOn.listarContactos();
		} catch (Exception e) {
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		Object[] fila = new Object[6];

		int cont = 0;
		for (int j = 0; j < recibirArreglo.size(); j++) {
			fila[cont] = recibirArreglo.get(j);
			cont++;
			if (cont % 6 == 0) {
				cont = 0;
				modelo.addRow(fila);
			}

		}

		table.setModel(modelo);
	}*/
}
