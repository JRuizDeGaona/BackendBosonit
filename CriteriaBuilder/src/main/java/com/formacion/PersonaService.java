package com.formacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class PersonaService {
    //Variables estáticas para la condicón de las fechas
    public static final String MENOR_QUE = "before";
    public static final String EQUALS = "equals";
    public static final String MAYOR_QUE = "after";

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    PersonaRepositorio personaRepositorio;

    /**
     * Método que devuelve una lista de personas según una consulta específica que depende de los perámetros que le pasa el usuario
     * @param cond Condición de fecha (MENOR_QUE, EQUALS, MAYOR_QUE)
     * @param min Número de resultados mínimo que queremos mostrar
     * @param max Número de resultados máximo que queremos mostrar
     * @return Lista de personas según la consulta que se ha ejecutado
     */
    public List<Persona> multiQuery(HashMap<String, String> cond, int min, int max) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> consulta = criteriaBuilder.createQuery(Persona.class);
        Root<Persona> root = consulta.from(Persona.class);
        List<Predicate> preds = new ArrayList<>();
        List<Persona> personaList;

        cond.forEach((clave, valor) -> {
            switch(clave) {
                case "name":
                case "surname":
                    preds.add(criteriaBuilder.like(root.get(clave), valor));
                    break;
                case "usuario":
                    preds.add(criteriaBuilder.equal(root.get(clave), valor));
                    break;
                case "created_date":
                    String fecha = cond.get("fecha");
                    //Convertimos la fecha (String) a Date
                    try {
                        Date fechaAux = strToDate(valor);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    //Si la fecha pasada es menor
                    if (MENOR_QUE.equalsIgnoreCase(fecha)) {
                        preds.add(criteriaBuilder.lessThan(root.get(clave), fecha));
                    //Si la fecha pasada es igual
                    } else if (EQUALS.equalsIgnoreCase(fecha)) {
                        preds.add(criteriaBuilder.equal(root.get(clave), fecha));
                    //Si la fecha pasada es mayor
                    } else if (MAYOR_QUE.equalsIgnoreCase(fecha)){
                        preds.add(criteriaBuilder.greaterThan(root.get(clave), fecha));
                    }
                    break;
            }
        });
        //Le metemos todos los campos a la consulta
        consulta.select(root).where(preds.toArray(new Predicate[preds.size()]));

        //Creamos la consulta, la ejecutamos y devolvemos los resultados de las personas obtenidas con el límite de resultados
        return personaList = entityManager.createQuery(consulta).setMaxResults(max).setFirstResult(min).getResultList();
    }

    /**
     * Método privado que convierte un String a un Date
     * @param date Fecha que queremos convertir
     * @return Fecha convertida (Date)
     * @throws ParseException Si falla la conversión
     */
    private Date strToDate(String date) throws ParseException {
        Date fecha = new SimpleDateFormat("yyyy/mm/dd").parse(date);

        return fecha;
    }

    /**
     * Método que añade personas a la base de datos
     * @param persona Persona que queremos añadir
     * @return Persona añadida
     * @throws Exception Si la persona no cumple las restricciones de nombre de usuario
     */
    public Persona addPersona(Persona persona) throws Exception {
        if (persona.getUsuario().length()<6 || persona.getUsuario().length() > 10) {
            throw new Exception("La longitud del nombre de usuario debe estar entre 6 y 10 caracteres");
        }
        personaRepositorio.save(persona);
        return persona;
    }

    /**
     * Método que borra una persona de la base de datos
     * @param id ID de la persona que queremos borrar
     * @throws Exception Si el ID pasado no existe
     */
    public void deletePersona(int id) throws Exception{
        PersonaDTO persona;
        persona = buscarPorID(id);

        if(persona == null){
            System.out.println("No hay usuarios");
        }else{
            personaRepositorio.deleteById(id);
        }
    }

    /**
     * Método para actualizar los datos de una persona
     * @param id ID de la persona a actualizar
     * @param p Nuevos datos de la persona
     */
    public void updatePersona(int id, Persona p) {

        personaRepositorio.findAll().forEach(persona -> {
            if (persona.getId_persona() == id) {
                persona.setId_persona(p.getId_persona());
                persona.setName(p.getName());
                persona.setSurname(p.getSurname());
                persona.setUsuario(p.getUsuario());
                persona.setPassword(p.getPassword());
                persona.setPersonal_email(p.getPersonal_email());
                persona.setCompany_email(p.getCompany_email());
                persona.setCity(p.getCity());
                persona.setImagen_url(p.getImagen_url());
                persona.setCreated_date(p.getCreated_date());
                persona.setTermination_date(p.getTermination_date());
                persona.setActive(p.isActive());

                personaRepositorio.saveAndFlush(persona);
            }
        });
    }

    /**
     * Método para buscar una persona según su ID
     * @param personaId ID de la persona
     * @return Información realtiva a la persona cuyo ID hemos pasado
     * @throws Exception Si el ID pasado no existe
     */
    public PersonaDTO buscarPorID(int personaId) throws Exception {
        Persona persona;
        PersonaDTO personaDTO;

        persona = personaRepositorio.findById(personaId).orElseThrow(() -> new Exception("ID no encontrado"));
        personaDTO = new PersonaDTO(persona);

        return personaDTO;
    }

    /**
     * Método que busca una persona por el nombre de usuario
     * @param nombreUsu Nombre de usuario de la persona que queremos pasar
     * @return Lista de Personas con ese nombre de usuario
     */
    public List<PersonaDTO> buscarPorUsuario(String nombreUsu) {
        List<PersonaDTO> listaPersonas = new ArrayList<>();

        personaRepositorio.findAll().forEach(persona -> {
            if (persona.getUsuario().equalsIgnoreCase(nombreUsu)) {
                PersonaDTO personaDTO = new PersonaDTO(persona);
                listaPersonas.add(personaDTO);
            }
        });

        if (listaPersonas.isEmpty()) {
            System.out.println("Sin usuarios con ese nombre");
        }
        return listaPersonas;
    }

    /**
     * Método que muestra todas las personas de la base de datos
     * @return Lista con todas las Personas de la base de datos
     */
    public List<PersonaDTO> buscarTodos() {
        List<PersonaDTO> listaPersonas = new ArrayList<>();

        personaRepositorio.findAll().forEach(persona -> {
            PersonaDTO personaDTO = new PersonaDTO(persona);
            listaPersonas.add(personaDTO);
        });

        if (listaPersonas.isEmpty()) {
            System.out.println("No hay usuarios en la base de datos");
        }
        return listaPersonas;
    }

}
