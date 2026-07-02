package cl.duoc.biblioteca.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cl.duoc.biblioteca.entity.Libro;
import cl.duoc.biblioteca.service.LibroService;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    // Registrar libro
    @PostMapping
    public Libro registrarLibro(@RequestBody Libro libro) {
        return libroService.registrarLibro(libro);
    }

    // Obtener todos los libros
    @GetMapping
    public List<Libro> obtenerTodos() {
        return libroService.obtenerTodos();
    }

    // Buscar libro por ID
    @GetMapping("/{id}")
    public Optional<Libro> buscarPorId(@PathVariable Long id) {
        return libroService.buscarPorId(id);
    }

    // Eliminar libro
    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
    }

    // Obtener libros disponibles
    @GetMapping("/disponibles")
    public List<Libro> obtenerDisponibles() {
        return libroService.obtenerDisponibles();
    }

    // Obtener cantidad total de libros
    @GetMapping("/total")
    public Map<String, Long> obtenerTotal() {
        Map<String, Long> respuesta = new HashMap<>();
        respuesta.put("total", libroService.contarLibros());
        return respuesta;
    }
}