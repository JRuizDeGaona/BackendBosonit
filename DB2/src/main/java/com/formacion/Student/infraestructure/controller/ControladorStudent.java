package com.formacion.Student.infraestructure.controller;

import com.formacion.Student.application.port.*;
import com.formacion.Student.domain.Student;
import com.formacion.Student.infraestructure.dtos.input.StudentInputDTO;
import com.formacion.Student.infraestructure.dtos.output.StudentOutputDTO;
import com.formacion.Excepciones.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class ControladorStudent {
    @Autowired
    CreateStudentPort createStudentPort;
    @Autowired
    UpdateStudentPort updateStudentPort;
    @Autowired
    DeleteStudentPort deleteStudentPort;
    @Autowired
    ObtenerStudentPort obtenerStudentPort;
    @Autowired
    AsignarAsignaturaPort asignarAsignaturaPort;

    // -----MOSTRAR LOS ESTUDIANTES DE LA BASE DE DATOS----- //
    /**
     * Método que muestra una persona según su ID
     * @param id_student ID del estudiante que queremos ver la información
     * @param outputType Si queremos ver la información sólo del estudiante ("simple") o también de la persona asociada ("full")
     * @return StudentOutputDTO con los datos del estudiante
     * @throws NotFoundException Si no encunetra el ID que le hemos pasado
     */
    @GetMapping("/buscarId/{id_student}")
    public StudentOutputDTO buscarPorId(@PathVariable int id_student, @RequestParam(name = "outputType", defaultValue = "simple")String outputType) throws NotFoundException {
        return obtenerStudentPort.buscarPorId(id_student, outputType);
    }

    /**
     * Método que te devuelve una lsita con todos los estudiantes de la base de datos
     * @return Lista de los estudiantes
     * @throws Exception Si la lista está vacía
     */
    @GetMapping("/buscarTodos")
    public List<StudentOutputDTO> buscarTodos () throws Exception {
        return obtenerStudentPort.buscarTodos();
    }


    // -----CRUD DE ESTUDIANTES----- //
    /**
     * Método para añadir un estudiante en la base de datos
     * @param studentInputDTO Datos de estudiante a añadir
     * @return StudentOutputDTO con los datos del estudiante
     * @throws Exception Si el estudiante no tiene datos
     */
    @PostMapping("/addStudent")
    public StudentOutputDTO addStudent(@RequestBody StudentInputDTO studentInputDTO) throws Exception {
        return createStudentPort.addStudent(studentInputDTO);
    }

    /**
     * Método que elimina un estudiante de la base de datos
     * @param id_student ID del estudiante que queremos eliminar
     * @throws NotFoundException Si el ID no existe
     */
    @DeleteMapping("/deleteStudent/{id_student}")
    public void deleteStudent(@PathVariable int id_student) throws NotFoundException {
        deleteStudentPort.deleteStudent(id_student);
    }

    /**
     * Método que me actualiza los cambios de los datos de un estudiante
     * @param id_student ID del estudiante que queremos actualizar
     * @param studentInputDTO Nuevos datos del estudiante
     * @return StuedntOutputDTO con los nuevos datos
     * @throws NotFoundException S i no encuentra el ID que le hemos pasado
     */
    @PutMapping("/updateStudent/{id_student}")
    public StudentOutputDTO updateStudent(@PathVariable int id_student, @RequestBody StudentInputDTO studentInputDTO) throws NotFoundException {
        return updateStudentPort.updateStudent(id_student, studentInputDTO);
    }

    /**
     * Método que asigna nuevas asignaturas a un estudinate
     * @param id_student ID del estudiante al que queremos añadir las asignaturas
     * @param id_study Asignaturas que queremos añadir
     * @return El estudinate con las asignaturas añadidas
     */
    @PutMapping("asignarEstudios/{id_student}")
    public Student asignarEstudios(@PathVariable int id_student, @RequestBody Map<String, Integer> id_study) {
        return asignarAsignaturaPort.asignarAsigantura(id_student, id_study);
    }

    /**
     * Método que elimina la asignatura a un estudiante
     * @param id_student ID del estudiante al que queremos borrarle la asignatura
     * @param id_study Mapa con la/s asignaturas que queremos borrarle
     * @return Estudiante con las asignaturas ya borradas
     */
    @DeleteMapping("desasignarEstudios/{id_student}")
    public Student desasignarEstudios(@PathVariable int id_student, @RequestBody Map<String, Integer> id_study) {
        return asignarAsignaturaPort.desasignarAsignatura(id_student, id_study);
    }
}
