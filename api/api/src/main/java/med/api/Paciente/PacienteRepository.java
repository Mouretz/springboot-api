package med.api.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;

//Mapear Paciente e representar no banco de dados, de dominio maior para fazer a persistence.
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
