package model;
 
/**
 * Interface que define o comportamento de situação de um vídeo.
 * Implementada por Video (e consequentemente por Filme e Serie).
 */
public interface Situacao {
 
    /**
     * Retorna uma descrição textual da situação/detalhe específico do vídeo.
     * Filme retorna a duração, Série retorna o número de temporadas.
     * @return 
     */
    String getSituacao();
}
 