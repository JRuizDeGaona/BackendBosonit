import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre, poblacion, fichero = "C:/Users/javier.rdegaona/Desktop/BackendBosonit/Ejercicio2/e1.txt";
    private int edad;
    private BufferedReader br;
    private List<Persona> lista = new ArrayList<Persona>();

    // Constructor por defecto
    public Persona() {
        leerFichero();
    }

    // Constructor con atributos
    public Persona(String nombre, String poblacion, int edad) {
        this.nombre = nombre;
        setPoblacion(poblacion);
        this.edad = edad;
    }

    /**
     * Método que lee un fichero y guarda en una List de Personas los datos obtenidos
     */
    public List<Persona> leerFichero() {
        String lineaActual;
        String[] atributos = new String[3];
        try {
            br = new BufferedReader(new FileReader(fichero));
            while ((lineaActual = br.readLine()) != null) {
                atributos = lineaActual.split(":");
                if (atributos.length == 3) {
                    Persona p = new Persona(atributos[0], atributos[1], Integer.parseInt(atributos[2]));
                    lista.add(p);
                } else if (atributos.length == 2) {
                    Persona p = new Persona(atributos[0], atributos[1], -1);
                    lista.add(p);
                }
            }
        } catch (FileNotFoundException e1) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e2) {
            System.out.println("Otro error");
        } finally {
            try {
                br.close();
            } catch (IOException e3) {
                System.out.println("Error al cerrar el archivo");
            }
        }
        return lista;
    }

    // Getters de las variables
    public String getNombre() {
        return nombre;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPoblacion(String poblacion) {
        if (poblacion.equals("")) {
            this.poblacion = "Desconocido";
        } else {
            this.poblacion = poblacion;
        }
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Creamos un método que devuelve un String con la información de las personas
    public void mostrarPersonas() {
        lista.stream().filter(persona -> persona.edad < 25 && persona.edad > 0).forEach(p -> System.out.println("Nombre-> " + p.nombre + " | Población-> " + p.poblacion + " | Edad-> " + p.edad));
    }
}

