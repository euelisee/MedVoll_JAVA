package med.voll.medvoll_java.controller;

import jakarta.validation.Valid;
import jdk.swing.interop.SwingInterOpUtils;
import med.voll.medvoll_java.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
@Transactional
public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(Pageable paginacao) {
       // return repository.findAll(paginacao).map(DadosListagemMedico::new); //tráz a listagem lógica, mesmo que não seja excluida totalmente do BD
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new); //listagem apenas como true no BD
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
            var medico = repository.getReferenceById(dados.id());
            medico.atualizarInformacoes(dados);
    }
    @Transactional
    @DeleteMapping("/{id}") //exclusao lógica , não deleta do BD
    public void excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }

    /* @Transactional
    @DeleteMapping("/{id}") //exclusao que deleta do BD
    public void excluir(@PathVariable Long id){
        var medico = repository.deleteById(id);
    }
    */

}