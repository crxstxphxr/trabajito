package cl.duoc.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.biblioteca.entity.Libro;
import cl.duoc.biblioteca.repository.LibroRepository;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    // Registrar libro
    public Libro registrarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    // Obtener todos los libros
    public List<Libro> obtenerTodos() {
        return libroRepository.findAll();
    }

    // Buscar libro por ID
    public Optional<Libro> buscarPorId(Long id) {
        return libroRepository.findById(id);
    }

    // Eliminar libro
    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }

    // Obtener libros disponibles
    public List<Libro> obtenerDisponibles() {
        return libroRepository.findByDisponibleTrue();
    }

    // Contar libros
    public long contarLibros() {
        return libroRepository.count();
    }
}