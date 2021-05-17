package dao;

import java.util.List;

public interface IDao<T> {

    public void inserir(T objeto);

    public void alterar(T objeto);

    public void deletar(Long codigo);

    public List<T> listar(T objeto);
}